<?php
// Iniciamos la sesión
session_start();

// Tiempo máximo de inactividad en segundos (300 segundos = 5 minutos)
define('TIEMPO_MAX_INACTIVIDAD', 300);

// Verificamos si el usuario está autenticado
if (!isset($_SESSION['id'])) {
    ?>
    <!DOCTYPE html>
    <html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Acceso denegado</title>
    </head>
    <body>
        <h1>DWES 03. AUTOR: RAFAEL MORONES BURGOS.</h1>
        <h2>Acceso denegado</h2>
        <p>Debe estar autenticado para acceder a esta área.</p>
        <a href="../index/index.php">Volver al listado de películas</a>
    </body>
    </html>
    <?php
    exit;
}

// Verificamos el tiempo de inactividad
$tiempoActual = time();
$ultimoAcceso = $_SESSION['ultimo_acceso'] ?? $tiempoActual;

// Calculamos el tiempo transcurrido desde el último acceso
$tiempoTranscurrido = $tiempoActual - $ultimoAcceso;

// Si se ha superado el tiempo máximo de inactividad
if ($tiempoTranscurrido > TIEMPO_MAX_INACTIVIDAD) {
    // Destruimos la sesión
    session_destroy();
    ?>
    <!DOCTYPE html>
    <html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Tiempo de inactividad superado</title>
    </head>
    <body>
        <h1>DWES 03. AUTOR: RAFAEL MORONES BURGOS.</h1>
        <h2>Tiempo de inactividad superado</h2>
        <p>Ha superado el tiempo máximo de inactividad (<?= TIEMPO_MAX_INACTIVIDAD ?> segundos). Por favor, vuelva a iniciar sesión.</p>
        <a href="../index/index.php">Volver al listado de películas</a>
    </body>
    </html>
    <?php
    exit;
}

// Si todo está correcto, actualizamos el tiempo de último acceso
$_SESSION['ultimo_acceso'] = $tiempoActual;
?>
