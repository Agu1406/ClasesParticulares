<?php
// Recuperamos la información de la sesión
session_start();

// Verificamos si existe una sesión
$sesion = $_SESSION['id'] ?? null;

// Si existe una sesión, eliminamos los datos del usuario autenticado
if ($sesion) {
    unset($_SESSION['id']);
    unset($_SESSION['ultimo_acceso']);
}
?>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cierre de sesión</title>
</head>

<body>
    <h1>DWES 03. AUTOR: RAFAEL MORONES BURGOS.</h1>
    <h1>Cierre de sesión</h1>

    <?php if (!$sesion): ?>
        <h2>No había ninguna sesión iniciada</h2>
    <?php else: ?>
        <h2>Sesión cerrada correctamente</h2>
    <?php endif; ?>
    
    <br>
    <a href="../index/index.php">Volver al listado de películas</a>
</body>

</html>