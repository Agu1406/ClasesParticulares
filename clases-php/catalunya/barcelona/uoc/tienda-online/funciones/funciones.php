<?php
/**
 * Funciones auxiliares generales
 */

/**
 * Escapa caracteres especiales para prevenir XSS
 * @param string $data Datos a escapar
 * @return string Datos escapados
 */
function limpiarDatos($data) {
    $data = trim($data);
    $data = stripslashes($data);
    $data = htmlspecialchars($data, ENT_QUOTES, 'UTF-8');
    return $data;
}

/**
 * Verifica si el usuario está logueado
 * @return bool True si está logueado, false en caso contrario
 */
function estaLogueado() {
    return isset($_SESSION['usuario_id']) && !empty($_SESSION['usuario_id']);
}

/**
 * Obtiene el ID del usuario actual
 * @return int|null ID del usuario o null si no está logueado
 */
function obtenerUsuarioId() {
    return isset($_SESSION['usuario_id']) ? $_SESSION['usuario_id'] : null;
}

/**
 * Obtiene el nombre del usuario actual
 * @return string Nombre del usuario o cadena vacía
 */
function obtenerNombreUsuario() {
    return isset($_SESSION['usuario_nombre']) ? $_SESSION['usuario_nombre'] : '';
}

/**
 * Redirige a una página
 * @param string $url URL a la que redirigir
 */
function redirigir($url) {
    header("Location: " . $url);
    exit();
}

/**
 * Formatea un precio para mostrar
 * @param float $precio Precio a formatear
 * @return string Precio formateado
 */
function formatearPrecio($precio) {
    return number_format($precio, 2, ',', '.') . ' €';
}

/**
 * Obtiene el ID de sesión
 * @return string ID de sesión
 */
function obtenerSesionId() {
    if (session_status() === PHP_SESSION_NONE) {
        session_start();
    }
    return session_id();
}

/**
 * Valida un email
 * @param string $email Email a validar
 * @return bool True si es válido, false en caso contrario
 */
function validarEmail($email) {
    return filter_var($email, FILTER_VALIDATE_EMAIL) !== false;
}

/**
 * Genera un hash de contraseña
 * @param string $password Contraseña en texto plano
 * @return string Hash de la contraseña
 */
function hashPassword($password) {
    return password_hash($password, PASSWORD_DEFAULT);
}

/**
 * Verifica una contraseña con su hash
 * @param string $password Contraseña en texto plano
 * @param string $hash Hash almacenado
 * @return bool True si coinciden, false en caso contrario
 */
function verificarPassword($password, $hash) {
    return password_verify($password, $hash);
}

/**
 * Obtiene la ruta base relativa desde el archivo actual hasta la raíz del proyecto
 * @return string Ruta base relativa (ej: "" o "../")
 */
function obtenerRutaBase() {
    // Usar la constante BASE_PATH definida en config.php
    return defined('BASE_PATH') ? BASE_PATH : '';
}
?>

