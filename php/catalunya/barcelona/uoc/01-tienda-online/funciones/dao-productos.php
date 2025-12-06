<?php
/**
 * Data Access Object para productos
 */

require_once __DIR__ . '/../conf/db.php';
require_once __DIR__ . '/funciones.php';

/**
 * Obtiene todos los productos activos
 * @param int|null $categoria_id ID de la categoría (opcional)
 * @return array Lista de productos
 */
function obtenerProductos($categoria_id = null) {
    $conexion = conectarDB();
    
    $sql = "SELECT p.*, c.nombre as categoria_nombre 
            FROM productos p 
            LEFT JOIN categorias c ON p.categoria_id = c.id 
            WHERE p.activo = 1";
    
    if ($categoria_id !== null) {
        $categoria_id = (int)$categoria_id;
        $sql .= " AND p.categoria_id = $categoria_id";
    }
    
    $sql .= " ORDER BY p.fecha_creacion DESC";
    
    $resultado = $conexion->query($sql);
    $productos = [];
    
    if ($resultado && $resultado->num_rows > 0) {
        while ($fila = $resultado->fetch_assoc()) {
            $productos[] = $fila;
        }
    }
    
    cerrarDB($conexion);
    return $productos;
}

/**
 * Obtiene un producto por ID
 * @param int $id ID del producto
 * @return array|null Datos del producto o null si no existe
 */
function obtenerProductoPorId($id) {
    $conexion = conectarDB();
    $id = (int)$id;
    
    $sql = "SELECT p.*, c.nombre as categoria_nombre 
            FROM productos p 
            LEFT JOIN categorias c ON p.categoria_id = c.id 
            WHERE p.id = $id AND p.activo = 1";
    
    $resultado = $conexion->query($sql);
    $producto = null;
    
    if ($resultado && $resultado->num_rows > 0) {
        $producto = $resultado->fetch_assoc();
    }
    
    cerrarDB($conexion);
    return $producto;
}

/**
 * Obtiene todas las categorías activas
 * @return array Lista de categorías
 */
function obtenerCategorias() {
    $conexion = conectarDB();
    
    $sql = "SELECT * FROM categorias WHERE activa = 1 ORDER BY nombre";
    $resultado = $conexion->query($sql);
    $categorias = [];
    
    if ($resultado && $resultado->num_rows > 0) {
        while ($fila = $resultado->fetch_assoc()) {
            $categorias[] = $fila;
        }
    }
    
    cerrarDB($conexion);
    return $categorias;
}

/**
 * Verifica si hay stock disponible de un producto
 * @param int $producto_id ID del producto
 * @param int $cantidad Cantidad solicitada
 * @return bool True si hay stock suficiente, false en caso contrario
 */
function verificarStock($producto_id, $cantidad) {
    $producto = obtenerProductoPorId($producto_id);
    return $producto && $producto['stock'] >= $cantidad;
}
?>

