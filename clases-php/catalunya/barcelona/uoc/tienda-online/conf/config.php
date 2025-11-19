<?php
/**
 * Configuración general de la aplicación
 */

// Iniciar sesión si no está iniciada
if (session_status() === PHP_SESSION_NONE) {
    session_start();
}

// Configuración de la aplicación
define('APP_NAME', 'Tienda Online');

// Calcular ruta base relativa: detectar si estamos en una subcarpeta (como auth/)
// Simplemente verificar si la ruta del script contiene "/auth/"
$script_name = $_SERVER['SCRIPT_NAME'] ?? '';
$base_path = (strpos($script_name, '/auth/') !== false) ? '../' : '';
define('BASE_PATH', $base_path);

// Configuración de rutas
define('ROOT_PATH', dirname(__DIR__));
define('INCLUDES_PATH', ROOT_PATH . '/includes');
define('FUNCIONES_PATH', ROOT_PATH . '/funciones');

// Incluir archivos necesarios
require_once ROOT_PATH . '/conf/db.php';
require_once FUNCIONES_PATH . '/funciones.php';
?>

