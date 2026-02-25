<?php

declare(strict_types=1);

namespace AAMP04\controlador;

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
}
