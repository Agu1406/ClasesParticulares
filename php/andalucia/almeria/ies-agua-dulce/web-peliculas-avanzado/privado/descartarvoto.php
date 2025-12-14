<?php
// Incluimos el control de acceso al área privada
require_once 'accesoareaprivada.php';

// Iniciamos la sesión (ya iniciada en accesoareaprivada.php, pero por seguridad)
session_start();

// Eliminamos la información de votación en curso de la sesión
if (isset($_SESSION['voto_en_curso'])) {
    unset($_SESSION['voto_en_curso']);
}
?>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=100%, initial-scale=1.0">
    <title>Proceso de votación</title>
</head>
<body>
    <H1>DWES 03. AUTOR: RAFAEL MORONES BURGOS.</H1>
    <h1>Proceso de votación</h1>
    <p>La votación ha sido descartada correctamente.</p>
    <a href="../index/index.php">Volver al listado de películas</a>
</body>
</html>
