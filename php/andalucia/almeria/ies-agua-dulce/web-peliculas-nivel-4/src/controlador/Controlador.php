<?php

declare(strict_types=1);

namespace AAMP04\controlador;

use AAMP04\modelo\Generos;
use AAMP04\modelo\Pelicula;
use AAMP04\modelo\Peliculas;
use AAMP04\servicios\DBResult;
use PDO;

/**
 * Controlador por defecto: listado de películas con ordenación (Título, Año, Duración; asc/desc).
 * Usa sesión para recordar último orden y preseleccionar el formulario.
 */
class Controlador
{
    private const COLUMNAS_VALIDAS = ['titulo', 'anio', 'duracion'];
    private const ORDENES_VALIDOS = ['asc', 'desc'];

    public static function listado(PDO $pdo, \Smarty $smarty): void
    {
        if (session_status() === PHP_SESSION_NONE) {
            session_start();
        }

        $peliculas = Peliculas::listar($pdo);
        $error = null;
        if ($peliculas instanceof DBResult) {
            $error = 'No se pudieron cargar las películas.';
            $peliculas = [];
        }

        $columna = null;
        $orden = null;
        $errorOrden = null;

        if ($_SERVER['REQUEST_METHOD'] === 'POST') {
            $columna = filter_input(INPUT_POST, 'columna', FILTER_SANITIZE_SPECIAL_CHARS);
            $orden = filter_input(INPUT_POST, 'orden', FILTER_SANITIZE_SPECIAL_CHARS);
            $columna = is_string($columna) ? trim($columna) : null;
            $orden = is_string($orden) ? strtolower(trim($orden)) : null;
            if ($columna !== null && $orden !== null && in_array($columna, self::COLUMNAS_VALIDAS, true) && in_array($orden, self::ORDENES_VALIDOS, true)) {
                $_SESSION['orden_columna'] = $columna;
                $_SESSION['orden_direccion'] = $orden;
                $peliculas = self::ordenarPeliculas($peliculas, $columna, $orden);
            } else {
                $errorOrden = 'Orden o columna no válidos. Elija Título, Año o Duración y Ascendente o Descendente.';
                if (isset($_SESSION['orden_columna'], $_SESSION['orden_direccion'])) {
                    $peliculas = self::ordenarPeliculas($peliculas, $_SESSION['orden_columna'], $_SESSION['orden_direccion']);
                }
            }
        } elseif (isset($_SESSION['orden_columna'], $_SESSION['orden_direccion'])) {
            $columna = $_SESSION['orden_columna'];
            $orden = $_SESSION['orden_direccion'];
            $peliculas = self::ordenarPeliculas($peliculas, $columna, $orden);
        }

        $smarty->assign('peliculas', self::peliculasToArray($peliculas));
        $smarty->assign('columna_seleccionada', $columna);
        $smarty->assign('orden_seleccionado', $orden);
        $smarty->assign('error', $error);
        $smarty->assign('error_orden', $errorOrden);
        $smarty->display('listado.tpl');
    }

    /**
     * Convierte array de Pelicula a array de arrays para la vista (sin exponer entidad).
     */
    private static function peliculasToArray(array $peliculas): array
    {
        $out = [];
        foreach ($peliculas as $p) {
            $out[] = [
                'id'        => $p->getId(),
                'titulo'    => $p->getTitulo(),
                'genero'    => $p->getGenero(),
                'direccion' => $p->getDireccion(),
                'duracion'  => $p->getDuracion(),
                'argumento' => $p->getArgumento(),
                'anio'      => $p->getAnio(),
            ];
        }
        return $out;
    }

    /**
     * Ordena array de Pelicula por columna y dirección (solo en memoria; no SQL).
     */
    private static function ordenarPeliculas(array $peliculas, string $columna, string $orden): array
    {
        $getter = match ($columna) {
            'titulo' => 'getTitulo',
            'anio' => 'getAnio',
            'duracion' => 'getDuracion',
            default => null,
        };
        if ($getter === null) {
            return $peliculas;
        }
        $mult = $orden === 'desc' ? -1 : 1;
        usort($peliculas, function ($a, $b) use ($getter, $mult) {
            $va = $a->$getter();
            $vb = $b->$getter();
            if ($va === $vb) {
                return 0;
            }
            return $mult * (($va <=> $vb));
        });
        return $peliculas;
    }

    /** Constantes para validación de nueva película (enunciado: año 1965–actual, duración >0 y ≤500; tabla CHECK duracion<500). */
    private const ANIO_MIN = 1965;
    private const DURACION_MAX = 499;
    private const TITULO_MAX = 60;
    private const DIRECCION_MAX = 100;
    private const ARGUMENTO_MAX = 255; // TINYTEXT

    /**
     * Muestra el formulario para añadir una nueva película (GET ?accion=nueva_pelicula_form_AAMP).
     */
    public static function formNuevaPelicula(PDO $pdo, \Smarty $smarty): void
    {
        $generos = Generos::listar($pdo);
        $listaGeneros = [];
        $error = null;
        if ($generos instanceof DBResult) {
            $error = 'No se pudieron cargar los géneros.';
        } else {
            foreach ($generos as $g) {
                $listaGeneros[] = ['id' => $g->getId(), 'nombre' => $g->getNombre()];
            }
        }
        $smarty->assign('generos', $listaGeneros);
        $smarty->assign('error', $error);
        $smarty->assign('datos', []); // para rellenar en caso de errores de validación
        $smarty->assign('errores', []);
        $smarty->assign('anio_actual', (int) date('Y'));
        $smarty->display('nueva_pelicula_form.tpl');
    }

    /**
     * Procesa el guardado de una nueva película (POST ?accion=nueva_pelicula_guardar_AAMP).
     * Valida campos NOT NULL, tipos, año 1965–actual, duración 1–500, género existente, longitudes máximas.
     */
    public static function guardarNuevaPelicula(PDO $pdo, \Smarty $smarty): void
    {
        $errores = [];
        $titulo = filter_input(INPUT_POST, 'titulo', FILTER_SANITIZE_SPECIAL_CHARS);
        $titulo = is_string($titulo) ? trim($titulo) : '';
        $genero = filter_input(INPUT_POST, 'genero', FILTER_VALIDATE_INT);
        $direccion = filter_input(INPUT_POST, 'direccion', FILTER_SANITIZE_SPECIAL_CHARS);
        $direccion = is_string($direccion) ? trim($direccion) : '';
        $duracion = filter_input(INPUT_POST, 'duracion', FILTER_VALIDATE_INT);
        $argumento = filter_input(INPUT_POST, 'argumento', FILTER_SANITIZE_SPECIAL_CHARS);
        $argumento = is_string($argumento) ? trim($argumento) : '';
        $anio = filter_input(INPUT_POST, 'anio', FILTER_VALIDATE_INT);

        $anioActual = (int) date('Y');

        if ($titulo === '') {
            $errores['titulo'] = 'El título es obligatorio.';
        } elseif (strlen($titulo) > self::TITULO_MAX) {
            $errores['titulo'] = 'El título no puede superar ' . self::TITULO_MAX . ' caracteres.';
        }

        if ($genero === false || $genero === null) {
            $errores['genero'] = 'Debe seleccionar un género válido.';
        } else {
            $existe = Generos::existe($pdo, $genero);
            if ($existe === DBResult::DB_EXCEPTION) {
                $errores['genero'] = 'Error al comprobar el género.';
            } elseif ($existe === 0) {
                $errores['genero'] = 'El género seleccionado no existe.';
            }
        }

        if ($direccion === '') {
            $errores['direccion'] = 'La dirección es obligatoria.';
        } elseif (strlen($direccion) > self::DIRECCION_MAX) {
            $errores['direccion'] = 'La dirección no puede superar ' . self::DIRECCION_MAX . ' caracteres.';
        }

        if ($duracion === false || $duracion === null) {
            $errores['duracion'] = 'La duración debe ser un número entero.';
        } elseif ($duracion < 1 || $duracion > self::DURACION_MAX) {
            $errores['duracion'] = 'La duración debe estar entre 1 y ' . self::DURACION_MAX . ' minutos.';
        }

        if ($argumento === '') {
            $errores['argumento'] = 'El argumento es obligatorio.';
        } elseif (strlen($argumento) > self::ARGUMENTO_MAX) {
            $errores['argumento'] = 'El argumento no puede superar ' . self::ARGUMENTO_MAX . ' caracteres.';
        }

        if ($anio === false || $anio === null) {
            $errores['anio'] = 'El año debe ser un número entero.';
        } elseif ($anio < self::ANIO_MIN || $anio > $anioActual) {
            $errores['anio'] = 'El año debe estar entre ' . self::ANIO_MIN . ' y ' . $anioActual . '.';
        }

        $datos = [
            'titulo' => $titulo,
            'genero' => $genero,
            'direccion' => $direccion,
            'duracion' => $duracion,
            'argumento' => $argumento,
            'anio' => $anio,
        ];

        if ($errores !== []) {
            $generos = Generos::listar($pdo);
            $listaGeneros = [];
            if (!($generos instanceof DBResult)) {
                foreach ($generos as $g) {
                    $listaGeneros[] = ['id' => $g->getId(), 'nombre' => $g->getNombre()];
                }
            }
            $smarty->assign('generos', $listaGeneros);
            $smarty->assign('errores', $errores);
            $smarty->assign('datos', $datos);
            $smarty->assign('error', null);
            $smarty->assign('anio_actual', (int) date('Y'));
            $smarty->display('nueva_pelicula_form.tpl');
            return;
        }

        $p = new Pelicula();
        $p->setTitulo($titulo);
        $p->setGenero($genero);
        $p->setDireccion($direccion);
        $p->setDuracion($duracion);
        $p->setArgumento($argumento);
        $p->setAnio($anio);
        $res = $p->guardar($pdo);

        if ($res === DBResult::DB_EXCEPTION) {
            $smarty->assign('error_guardar', 'No se pudo guardar la película.');
            $smarty->assign('id_creado', null);
        } else {
            $smarty->assign('error_guardar', null);
            $smarty->assign('id_creado', $p->getId());
        }
        $smarty->display('nueva_pelicula_resultado.tpl');
    }

    /**
     * Muestra el formulario de confirmación para borrar una película (POST ?accion=borrar_pelicula_form_AAMP).
     * Requiere id numérico y que la película exista.
     */
    public static function formBorrarPelicula(PDO $pdo, \Smarty $smarty): void
    {
        $idRaw = filter_input(INPUT_POST, 'id', FILTER_SANITIZE_SPECIAL_CHARS);
        $id = is_string($idRaw) ? filter_var($idRaw, FILTER_VALIDATE_INT) : false;
        if ($id === false || $id === null) {
            $smarty->assign('error', 'El identificador de película no es válido o no es numérico.');
            $smarty->assign('pelicula', null);
            $smarty->display('borrar_pelicula_confirmar.tpl');
            return;
        }
        $existe = Peliculas::existe($pdo, $id);
        if ($existe === DBResult::DB_EXCEPTION) {
            $smarty->assign('error', 'Error al comprobar la película.');
            $smarty->assign('pelicula', null);
            $smarty->display('borrar_pelicula_confirmar.tpl');
            return;
        }
        if ($existe === 0) {
            $smarty->assign('error', 'La película no existe o ya ha sido borrada.');
            $smarty->assign('pelicula', null);
            $smarty->display('borrar_pelicula_confirmar.tpl');
            return;
        }
        $rescatada = Pelicula::rescatar($pdo, $id);
        if ($rescatada instanceof DBResult) {
            $smarty->assign('error', 'No se pudo cargar la película.');
            $smarty->assign('pelicula', null);
            $smarty->display('borrar_pelicula_confirmar.tpl');
            return;
        }
        /** @var Pelicula $rescatada */
        $smarty->assign('error', null);
        $smarty->assign('pelicula', [
            'id' => $rescatada->getId(),
            'titulo' => $rescatada->getTitulo(),
        ]);
        $smarty->display('borrar_pelicula_confirmar.tpl');
    }

    /**
     * Ejecuta el borrado si el usuario marcó la casilla (POST ?accion=borrar_pelicula_confirmacion_AAMP).
     */
    public static function confirmarBorrarPelicula(PDO $pdo, \Smarty $smarty): void
    {
        $confirmacion = filter_input(INPUT_POST, 'confirmacion', FILTER_VALIDATE_INT);
        $idRaw = filter_input(INPUT_POST, 'id', FILTER_SANITIZE_SPECIAL_CHARS);
        $id = is_string($idRaw) ? filter_var($idRaw, FILTER_VALIDATE_INT) : false;

        if ($confirmacion !== 1) {
            $smarty->assign('error', 'Debe marcar la casilla de confirmación para borrar la película.');
            $smarty->assign('borrado_ok', false);
            $smarty->display('borrar_pelicula_resultado.tpl');
            return;
        }
        if ($id === false || $id === null) {
            $smarty->assign('error', 'El identificador de película no es válido o no es numérico.');
            $smarty->assign('borrado_ok', false);
            $smarty->display('borrar_pelicula_resultado.tpl');
            return;
        }
        $existe = Peliculas::existe($pdo, $id);
        if ($existe === DBResult::DB_EXCEPTION) {
            $smarty->assign('error', 'Error al comprobar la película.');
            $smarty->assign('borrado_ok', false);
            $smarty->display('borrar_pelicula_resultado.tpl');
            return;
        }
        if ($existe === 0) {
            $smarty->assign('error', 'La película no existe o ya ha sido borrada.');
            $smarty->assign('borrado_ok', false);
            $smarty->display('borrar_pelicula_resultado.tpl');
            return;
        }
        $res = Pelicula::borrar($pdo, $id);
        if ($res === DBResult::DB_EXCEPTION) {
            $smarty->assign('error', 'No se pudo borrar la película.');
            $smarty->assign('borrado_ok', false);
        } else {
            $smarty->assign('error', null);
            $smarty->assign('borrado_ok', true);
        }
        $smarty->display('borrar_pelicula_resultado.tpl');
    }

    /**
     * Muestra mensaje de error cuando la acción requiere POST y se ha recibido GET (u otro).
     */
    public static function errorAccion(\Smarty $smarty, string $mensaje): void
    {
        $smarty->assign('error_accion', $mensaje);
        $smarty->display('error_accion.tpl');
    }
}
