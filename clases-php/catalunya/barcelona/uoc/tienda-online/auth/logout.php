<?php
require_once __DIR__ . '/../conf/config.php';

// Destruir sesión
session_destroy();

// Redirigir a inicio
redirigir('../index.php');
?>

