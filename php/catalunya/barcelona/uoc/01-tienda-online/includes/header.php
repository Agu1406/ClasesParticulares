<?php
require_once __DIR__ . '/../conf/config.php';
// Asegurar que BASE_PATH esté definida
if (!defined('BASE_PATH')) {
    define('BASE_PATH', '');
}
?>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><?php echo isset($titulo) ? $titulo . ' - ' : ''; ?><?php echo APP_NAME; ?></title>
    <link rel="stylesheet" href="<?php echo BASE_PATH; ?>css/estilos.css">
</head>
<body>
    <header class="header">
        <div class="container">
            <div class="header-content">
                <div class="logo">
                    <h1><a href="<?php echo BASE_PATH; ?>index.php"><?php echo APP_NAME; ?></a></h1>
                </div>
                <nav class="nav">
                    <ul>
                        <li><a href="<?php echo BASE_PATH; ?>index.php">Inicio</a></li>
                        <li><a href="<?php echo BASE_PATH; ?>catalogo.php">Catálogo</a></li>
                        <?php if (estaLogueado()): ?>
                            <li><a href="<?php echo BASE_PATH; ?>carrito.php">Carrito</a></li>
                            <li><a href="<?php echo BASE_PATH; ?>pedidos.php">Mis Pedidos</a></li>
                            <li><a href="<?php echo BASE_PATH; ?>perfil.php">Perfil</a></li>
                            <li><a href="<?php echo BASE_PATH; ?>auth/logout.php">Cerrar Sesión</a></li>
                        <?php else: ?>
                            <li><a href="<?php echo BASE_PATH; ?>auth/login.php">Iniciar Sesión</a></li>
                            <li><a href="<?php echo BASE_PATH; ?>auth/registro.php">Registrarse</a></li>
                        <?php endif; ?>
                    </ul>
                </nav>
            </div>
        </div>
    </header>
    <main class="main-content">

