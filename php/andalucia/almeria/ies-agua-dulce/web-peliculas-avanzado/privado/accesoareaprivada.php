<?php
session_start();

// Tiempo máximo de inactividad en segundos
$tiempoMaxInactividad = 300;

// ¿Usuario autenticado?
if (!isset($_SESSION["id"])) {
    echo "<h1>ERROR: no autenticado</h1>";
    echo "<p>Debes iniciar sesión para acceder a esta página.</p>";
    echo '<p><a href="../login/form-login.php">Login</a></p>';
    exit;
}

// Comprobar tiempo de inactividad (compatible con lastlogin de procesarlogin.php)
$ultimoAcceso = $_SESSION["lastlogin"] ?? time();
$inactividad = time() - $ultimoAcceso;

if ($inactividad > $tiempoMaxInactividad) {
    // Eliminar información de usuario de la sesión
    session_unset();
    session_destroy();

    echo "<h1>ERROR: sesión expirada</h1>";
    echo "<p>Tu sesión ha expirado por inactividad. Debes iniciar sesión de nuevo.</p>";
    echo '<p><a href="../login/form-login.php">Iniciar sesión</a></p>';
    exit;
}

// Si todo es correcto, renovamos último acceso y dejamos continuar
$_SESSION["lastlogin"] = time();
