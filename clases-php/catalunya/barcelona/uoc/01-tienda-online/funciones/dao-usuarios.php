<?php
/**
 * Data Access Object para usuarios
 */

require_once __DIR__ . '/../conf/db.php';
require_once __DIR__ . '/funciones.php';

/**
 * Obtiene un usuario por email
 * @param string $email Email del usuario
 * @return array|null Datos del usuario o null si no existe
 */
function obtenerUsuarioPorEmail($email) {
    $conexion = conectarDB();
    $email = $conexion->real_escape_string($email);
    
    $sql = "SELECT id, nombre, apellidos, email, password, telefono, direccion, ciudad, codigo_postal 
            FROM usuarios 
            WHERE email = '$email' AND activo = 1";
    
    $resultado = $conexion->query($sql);
    $usuario = null;
    
    if ($resultado && $resultado->num_rows > 0) {
        $usuario = $resultado->fetch_assoc();
    }
    
    cerrarDB($conexion);
    return $usuario;
}

/**
 * Obtiene un usuario por ID
 * @param int $id ID del usuario
 * @return array|null Datos del usuario o null si no existe
 */
function obtenerUsuarioPorId($id) {
    $conexion = conectarDB();
    $id = (int)$id;
    
    $sql = "SELECT id, nombre, apellidos, email, telefono, direccion, ciudad, codigo_postal 
            FROM usuarios 
            WHERE id = $id AND activo = 1";
    
    $resultado = $conexion->query($sql);
    $usuario = null;
    
    if ($resultado && $resultado->num_rows > 0) {
        $usuario = $resultado->fetch_assoc();
    }
    
    cerrarDB($conexion);
    return $usuario;
}

/**
 * Crea un nuevo usuario
 * @param array $datos Datos del usuario
 * @return int|false ID del usuario creado o false en caso de error
 */
function crearUsuario($datos) {
    $conexion = conectarDB();
    
    $nombre = $conexion->real_escape_string($datos['nombre']);
    $apellidos = $conexion->real_escape_string($datos['apellidos']);
    $email = $conexion->real_escape_string($datos['email']);
    $password = hashPassword($datos['password']);
    $telefono = isset($datos['telefono']) ? $conexion->real_escape_string($datos['telefono']) : '';
    $direccion = isset($datos['direccion']) ? $conexion->real_escape_string($datos['direccion']) : '';
    $ciudad = isset($datos['ciudad']) ? $conexion->real_escape_string($datos['ciudad']) : '';
    $codigo_postal = isset($datos['codigo_postal']) ? $conexion->real_escape_string($datos['codigo_postal']) : '';
    
    $sql = "INSERT INTO usuarios (nombre, apellidos, email, password, telefono, direccion, ciudad, codigo_postal) 
            VALUES ('$nombre', '$apellidos', '$email', '$password', '$telefono', '$direccion', '$ciudad', '$codigo_postal')";
    
    $resultado = $conexion->query($sql);
    $id = false;
    
    if ($resultado) {
        $id = $conexion->insert_id;
    }
    
    cerrarDB($conexion);
    return $id;
}

/**
 * Verifica si un email ya existe
 * @param string $email Email a verificar
 * @return bool True si existe, false en caso contrario
 */
function existeEmail($email) {
    $conexion = conectarDB();
    $email = $conexion->real_escape_string($email);
    
    $sql = "SELECT id FROM usuarios WHERE email = '$email'";
    $resultado = $conexion->query($sql);
    $existe = $resultado && $resultado->num_rows > 0;
    
    cerrarDB($conexion);
    return $existe;
}
?>

