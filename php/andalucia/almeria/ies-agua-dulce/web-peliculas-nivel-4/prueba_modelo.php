<?php

declare(strict_types=1);

/**
 * Script de prueba del modelo (Ejercicio 05 - Opción 01).
 * Verifica que las operaciones del modelo y los métodos set/get funcionan correctamente.
 * Acceso: http://localhost/.../web-peliculas-nivel-4/prueba_modelo.php
 */

require_once __DIR__ . '/vendor/autoload.php';

$config = require __DIR__ . '/config_db.php';
$pdo = new PDO(
    $config['dsn'],
    $config['username'],
    $config['password'],
    $config['options'] ?? []
);

use AAMP04\modelo\Genero;
use AAMP04\modelo\Generos;
use AAMP04\modelo\Pelicula;
use AAMP04\modelo\Peliculas;
use AAMP04\servicios\DBResult;

$tests = [];
$ok = function (string $nombre) use (&$tests) {
    $tests[] = ['nombre' => $nombre, 'ok' => true];
};
$fail = function (string $nombre, string $mensaje) use (&$tests) {
    $tests[] = ['nombre' => $nombre, 'ok' => false, 'mensaje' => $mensaje];
};

// --- Genero: get/set ---
$g = new Genero();
$g->setId(1);
$g->setNombre('drama');
if ($g->getId() === 1 && $g->getNombre() === 'drama') {
    $ok('Genero: setId/getId y setNombre/getNombre');
} else {
    $fail('Genero: setId/getId y setNombre/getNombre', 'Valores no coinciden');
}

// --- Generos::listar ---
$listaGeneros = Generos::listar($pdo);
if ($listaGeneros instanceof DBResult) {
    $fail('Generos::listar', 'Devolvió DBResult en lugar de array');
} elseif (!is_array($listaGeneros)) {
    $fail('Generos::listar', 'No devolvió array');
} else {
    $ok('Generos::listar devuelve array de ' . count($listaGeneros) . ' género(s)');
}

// --- Generos::existe ---
$existe1 = Generos::existe($pdo, 1);
$existeFake = Generos::existe($pdo, 99999);
if ($existe1 === DBResult::DB_EXCEPTION || $existeFake === DBResult::DB_EXCEPTION) {
    $fail('Generos::existe', 'Excepción de BD');
} elseif ($existe1 === 1 && $existeFake === 0) {
    $ok('Generos::existe(id existente)=1, existe(id inexistente)=0');
} else {
    $fail('Generos::existe', "existe(1)=$existe1, existe(99999)=$existeFake");
}

// --- Pelicula: get/set ---
$p = new Pelicula();
$p->setTitulo('Título');
$p->setGenero(1);
$p->setDireccion('Director');
$p->setDuracion(90);
$p->setArgumento('Argumento');
$p->setAnio(2000);
$igual = $p->getTitulo() === 'Título' && $p->getGenero() === 1 && $p->getDireccion() === 'Director'
    && $p->getDuracion() === 90 && $p->getArgumento() === 'Argumento' && $p->getAnio() === 2000;
if ($igual) {
    $ok('Pelicula: todos los set/get');
} else {
    $fail('Pelicula: set/get', 'Algún valor no coincide');
}

// --- Peliculas::listar ---
$listaPeliculas = Peliculas::listar($pdo);
if ($listaPeliculas instanceof DBResult) {
    $fail('Peliculas::listar', 'Devolvió DBResult');
} elseif (!is_array($listaPeliculas)) {
    $fail('Peliculas::listar', 'No devolvió array');
} else {
    $ok('Peliculas::listar devuelve array de ' . count($listaPeliculas) . ' película(s)');
}

// --- Peliculas::existe ---
$primerId = null;
if (is_array($listaPeliculas) && count($listaPeliculas) > 0) {
    $primerId = $listaPeliculas[0]->getId();
}
$existeP = $primerId !== null ? Peliculas::existe($pdo, $primerId) : 0;
$existePFalse = Peliculas::existe($pdo, 99999999);
if ($existeP === DBResult::DB_EXCEPTION || $existePFalse === DBResult::DB_EXCEPTION) {
    $fail('Peliculas::existe', 'Excepción de BD');
} elseif ($primerId === null) {
    $ok('Peliculas::existe (sin películas para probar id existente)');
} elseif ($existeP === 1 && $existePFalse === 0) {
    $ok('Peliculas::existe(id existente)=1, existe(id inexistente)=0');
} else {
    $fail('Peliculas::existe', "existe($primerId)=$existeP, existe(99999999)=$existePFalse");
}

// --- Pelicula: guardar (INSERT), rescatar, guardar (UPDATE), borrar ---
$tituloPrueba = 'Prueba modelo ' . time();
$nueva = new Pelicula();
$nueva->setTitulo($tituloPrueba);
$nueva->setGenero(1);
$nueva->setDireccion('Dir prueba');
$nueva->setDuracion(60);
$nueva->setArgumento('Argumento prueba');
$nueva->setAnio(2020);
$resGuardar = $nueva->guardar($pdo);

$idCreado = null;
if ($resGuardar === DBResult::DB_EXCEPTION || $resGuardar === DBResult::DB_NOCOLS_AFFECTED) {
    $fail('Pelicula::guardar (INSERT)', 'No se insertó: ' . (is_int($resGuardar) ? '' : 'error BD'));
} elseif ($nueva->getId() === null) {
    $fail('Pelicula::guardar (INSERT)', 'lastInsertId no asignado a la entidad');
} else {
    $ok('Pelicula::guardar (INSERT) y getId tras insert');
    $idCreado = $nueva->getId();
}

$rescatada = null;
if ($idCreado !== null) {
    $rescatada = Pelicula::rescatar($pdo, $idCreado);
}
if ($rescatada === null) {
    $fail('Pelicula::rescatar', 'No se ejecutó (falló INSERT previo)');
} elseif ($rescatada instanceof DBResult) {
    $fail('Pelicula::rescatar', 'No se rescató la película recién creada');
} else {
    if ($rescatada->getTitulo() === $tituloPrueba && $rescatada->getId() === $idCreado) {
        $ok('Pelicula::rescatar devuelve entidad con datos correctos');
    } else {
        $fail('Pelicula::rescatar', 'Datos no coinciden');
    }
}

// UPDATE
if ($idCreado !== null && $rescatada instanceof Pelicula) {
    $rescatada->setTitulo($tituloPrueba . ' actualizado');
    $resUpdate = $rescatada->guardar($pdo);
    if ($resUpdate === DBResult::DB_EXCEPTION || $resUpdate === DBResult::DB_OPNOTFULFILLED) {
        $fail('Pelicula::guardar (UPDATE)', 'No se actualizó');
    } else {
        $otra = Pelicula::rescatar($pdo, $idCreado);
        if ($otra instanceof Pelicula && $otra->getTitulo() === $tituloPrueba . ' actualizado') {
            $ok('Pelicula::guardar (UPDATE) y rescatar comprueba el cambio');
        } else {
            $fail('Pelicula::guardar (UPDATE)', 'Rescatar no devolvió el título actualizado');
        }
    }
}

// BORRAR
if ($idCreado !== null) {
    $resBorrar = Pelicula::borrar($pdo, $idCreado);
    if ($resBorrar === DBResult::DB_EXCEPTION) {
        $fail('Pelicula::borrar', 'Excepción de BD');
    } elseif ($resBorrar !== 1) {
        $fail('Pelicula::borrar', "rowCount=$resBorrar, se esperaba 1");
    } else {
        $ok('Pelicula::borrar elimina el registro');
    }

    $existeTrasBorrar = Peliculas::existe($pdo, $idCreado);
    $rescatarTrasBorrar = Pelicula::rescatar($pdo, $idCreado);
    if ($existeTrasBorrar === 0 && $rescatarTrasBorrar === DBResult::DB_EMPTYRESULT) {
        $ok('Peliculas::existe y Pelicula::rescatar tras borrado devuelven 0 y DB_EMPTYRESULT');
    } else {
        $fail('Tras borrado', "existe=$existeTrasBorrar, rescatar=" . ($rescatarTrasBorrar instanceof DBResult ? 'OK' : 'entidad'));
    }
} else {
    $fail('Pelicula::borrar / tras borrado', 'No se ejecutó (no hubo id creado)');
}

// --- Salida HTML ---
header('Content-Type: text/html; charset=utf-8');
$total = count($tests);
$pasados = count(array_filter($tests, fn($t) => $t['ok']));
?>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Prueba del modelo</title>
    <style>
        body { font-family: sans-serif; margin: 1em 2em; }
        h1 { color: #333; }
        .resumen { margin: 1em 0; padding: 0.5em; background: #f0f0f0; border-radius: 4px; }
        .ok { color: #080; }
        .fail { color: #c00; }
        ul { list-style: none; padding: 0; }
        li { padding: 0.2em 0; border-bottom: 1px solid #eee; }
        li .nombre { font-weight: bold; }
        .mensaje { color: #666; font-size: 0.9em; margin-left: 1em; }
    </style>
</head>
<body>
    <h1>Prueba del modelo – Web películas nivel 4</h1>
    <p class="resumen"><strong>Resultado:</strong> <?= $pasados ?> / <?= $total ?> pruebas correctas.</p>
    <ul>
        <?php foreach ($tests as $t): ?>
        <li class="<?= $t['ok'] ? 'ok' : 'fail' ?>">
            <span class="nombre"><?= $t['ok'] ? '✓' : '✗' ?> <?= htmlspecialchars($t['nombre']) ?></span>
            <?php if (!empty($t['mensaje'])): ?>
                <span class="mensaje"><?= htmlspecialchars($t['mensaje']) ?></span>
            <?php endif; ?>
        </li>
        <?php endforeach; ?>
    </ul>
    <p><a href="index.php">Volver al listado</a></p>
</body>
</html>
