<?php
declare(strict_types=1);

require_once __DIR__ . '/../config.php';
require_once __DIR__ . '/../funciones/db.php';
require_once __DIR__ . '/../funciones/dao-peliculas.php';

try {
    $pdo = crearConexionPDO();
} catch (PDOException $ex) {
    http_response_code(500);
    echo '<!DOCTYPE html><html lang="es"><head><meta charset="UTF-8"><title>Error</title></head><body>';
    echo '<h1>Error de conexión</h1>';
    echo '<p>No se puede conectar con la base de datos.</p>';
    echo '</body></html>';
    exit;
}

// Sanitizar y validar
$titulo = filter_input(INPUT_POST, 'titulo', FILTER_SANITIZE_FULL_SPECIAL_CHARS);
$genero = filter_input(INPUT_POST, 'genero', FILTER_VALIDATE_INT);
$anio = filter_input(INPUT_POST, 'anio', FILTER_VALIDATE_INT);
$direccion = filter_input(INPUT_POST, 'direccion', FILTER_SANITIZE_FULL_SPECIAL_CHARS);
$duracion = filter_input(INPUT_POST, 'duracion', FILTER_VALIDATE_INT);
$argumento = filter_input(INPUT_POST, 'argumento', FILTER_SANITIZE_FULL_SPECIAL_CHARS);

// Trim de campos de texto
if ($titulo !== null && $titulo !== false) { $titulo = trim($titulo); }
if ($direccion !== null && $direccion !== false) { $direccion = trim($direccion); }
if ($argumento !== null && $argumento !== false) { $argumento = trim($argumento); }

$errores = [];
$val = [
    'titulo' => (string)($titulo ?? ''),
    'genero' => $genero !== false && $genero !== null ? (string)$genero : '',
    'anio' => $anio !== false && $anio !== null ? (string)$anio : '',
    'direccion' => (string)($direccion ?? ''),
    'duracion' => $duracion !== false && $duracion !== null ? (string)$duracion : '',
    'argumento' => (string)($argumento ?? ''),
];

// Reglas
if ($titulo === null || $titulo === false || $titulo === '') {
    $errores[] = 'El título no puede estar vacío.';
} elseif (mb_strlen($titulo) > 60) {
    $errores[] = 'El título supera la longitud máxima (60).';
}

if ($genero === null || $genero === false || $genero <= 0) {
    $errores[] = 'El género es obligatorio y debe ser un entero > 0.';
} else {
    // Verificar que el género existe
    $generos = obtenerGeneros($pdo);
    $idsValidos = [];
    if (is_array($generos)) {
        foreach ($generos as $g) { $idsValidos[] = (int)$g['id']; }
    }
    if (!in_array((int)$genero, $idsValidos, true)) {
        $errores[] = 'El género seleccionado no existe.';
    }
}

if ($anio === null || $anio === false || $anio <= 1960 || $anio > (int)date('Y')) {
    $errores[] = 'El año debe ser un entero > 1960 y <= año actual.';
}

if ($direccion === null || $direccion === false || $direccion === '') {
    $errores[] = 'La dirección no puede estar vacía.';
} elseif (mb_strlen($direccion) > 100) {
    $errores[] = 'La dirección supera la longitud máxima (100).';
}

if ($duracion === null || $duracion === false || $duracion <= 0 || $duracion >= 500) {
    $errores[] = 'La duración debe ser un entero > 0 y < 500.';
}

if ($argumento === null || $argumento === false || $argumento === '') {
    $errores[] = 'El argumento no puede estar vacío.';
}

if (!empty($errores)) {
    // Re-mostrar el formulario con errores y valores
    // Variables $errores y $val serán usadas en el form
    include __DIR__ . '/form-insertar-pelicula.php';
    exit;
}

$data = [
    'titulo' => $titulo,
    'genero' => (int)$genero,
    'direccion' => $direccion,
    'duracion' => (int)$duracion,
    'argumento' => $argumento,
    'anio' => (int)$anio,
];

$nuevoId = insertarPelicula($pdo, $data);

?><!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Resultado inserción</title>
    <style> body { font-family: system-ui, -apple-system, Segoe UI, Roboto, Arial, sans-serif; margin: 24px; } a { color: #0b5ed7; } </style>
    </head>
<body>
    <h1>Resultado</h1>
    <?php if ($nuevoId !== false): ?>
        <p>La película ha sido insertada correctamente y su identificador es <?php echo (int)$nuevoId; ?>.</p>
    <?php else: ?>
        <p>No se pudo insertar la película. Inténtalo de nuevo.</p>
    <?php endif; ?>
    <p><a href="/dwes02/index.php">Volver a inicio</a></p>
</body>
</html>


