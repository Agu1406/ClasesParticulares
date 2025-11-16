<?php
/**
 * Data Access Object para el carrito de compras
 */

require_once __DIR__ . '/../conf/db.php';
require_once __DIR__ . '/funciones.php';

/**
 * Obtiene los items del carrito
 * @param int|null $usuario_id ID del usuario (si está logueado)
 * @param string|null $sesion_id ID de sesión (si no está logueado)
 * @return array Lista de items del carrito
 */
function obtenerCarrito($usuario_id = null, $sesion_id = null) {
    $conexion = conectarDB();
    
    if ($usuario_id) {
        $usuario_id = (int)$usuario_id;
        $sql = "SELECT c.*, p.nombre, p.precio, p.imagen, p.stock 
                FROM carrito c 
                INNER JOIN productos p ON c.producto_id = p.id 
                WHERE c.usuario_id = $usuario_id";
    } else if ($sesion_id) {
        $sesion_id = $conexion->real_escape_string($sesion_id);
        $sql = "SELECT c.*, p.nombre, p.precio, p.imagen, p.stock 
                FROM carrito c 
                INNER JOIN productos p ON c.producto_id = p.id 
                WHERE c.sesion_id = '$sesion_id'";
    } else {
        cerrarDB($conexion);
        return [];
    }
    
    $resultado = $conexion->query($sql);
    $items = [];
    
    if ($resultado && $resultado->num_rows > 0) {
        while ($fila = $resultado->fetch_assoc()) {
            $items[] = $fila;
        }
    }
    
    cerrarDB($conexion);
    return $items;
}

/**
 * Agrega un producto al carrito
 * @param int $producto_id ID del producto
 * @param int $cantidad Cantidad a agregar
 * @param int|null $usuario_id ID del usuario (si está logueado)
 * @param string|null $sesion_id ID de sesión (si no está logueado)
 * @return bool True si se agregó correctamente, false en caso contrario
 */
function agregarAlCarrito($producto_id, $cantidad, $usuario_id = null, $sesion_id = null) {
    $conexion = conectarDB();
    $producto_id = (int)$producto_id;
    $cantidad = (int)$cantidad;
    
    // Verificar si el producto ya está en el carrito
    if ($usuario_id) {
        $usuario_id = (int)$usuario_id;
        $sql_check = "SELECT id, cantidad FROM carrito WHERE usuario_id = $usuario_id AND producto_id = $producto_id";
    } else if ($sesion_id) {
        $sesion_id = $conexion->real_escape_string($sesion_id);
        $sql_check = "SELECT id, cantidad FROM carrito WHERE sesion_id = '$sesion_id' AND producto_id = $producto_id";
    } else {
        cerrarDB($conexion);
        return false;
    }
    
    $resultado_check = $conexion->query($sql_check);
    
    if ($resultado_check && $resultado_check->num_rows > 0) {
        // Actualizar cantidad
        $item = $resultado_check->fetch_assoc();
        $nueva_cantidad = $item['cantidad'] + $cantidad;
        $id = $item['id'];
        $sql = "UPDATE carrito SET cantidad = $nueva_cantidad WHERE id = $id";
    } else {
        // Insertar nuevo item
        if ($usuario_id) {
            $sql = "INSERT INTO carrito (usuario_id, producto_id, cantidad) 
                    VALUES ($usuario_id, $producto_id, $cantidad)";
        } else {
            $sql = "INSERT INTO carrito (sesion_id, producto_id, cantidad) 
                    VALUES ('$sesion_id', $producto_id, $cantidad)";
        }
    }
    
    $resultado = $conexion->query($sql);
    $exito = $resultado !== false;
    
    cerrarDB($conexion);
    return $exito;
}

/**
 * Elimina un item del carrito
 * @param int $item_id ID del item del carrito
 * @return bool True si se eliminó correctamente, false en caso contrario
 */
function eliminarDelCarrito($item_id) {
    $conexion = conectarDB();
    $item_id = (int)$item_id;
    
    $sql = "DELETE FROM carrito WHERE id = $item_id";
    $resultado = $conexion->query($sql);
    $exito = $resultado !== false;
    
    cerrarDB($conexion);
    return $exito;
}

/**
 * Actualiza la cantidad de un item del carrito
 * @param int $item_id ID del item del carrito
 * @param int $cantidad Nueva cantidad
 * @return bool True si se actualizó correctamente, false en caso contrario
 */
function actualizarCantidadCarrito($item_id, $cantidad) {
    $conexion = conectarDB();
    $item_id = (int)$item_id;
    $cantidad = (int)$cantidad;
    
    if ($cantidad <= 0) {
        return eliminarDelCarrito($item_id);
    }
    
    $sql = "UPDATE carrito SET cantidad = $cantidad WHERE id = $item_id";
    $resultado = $conexion->query($sql);
    $exito = $resultado !== false;
    
    cerrarDB($conexion);
    return $exito;
}

/**
 * Vacía el carrito
 * @param int|null $usuario_id ID del usuario
 * @param string|null $sesion_id ID de sesión
 * @return bool True si se vació correctamente, false en caso contrario
 */
function vaciarCarrito($usuario_id = null, $sesion_id = null) {
    $conexion = conectarDB();
    
    if ($usuario_id) {
        $usuario_id = (int)$usuario_id;
        $sql = "DELETE FROM carrito WHERE usuario_id = $usuario_id";
    } else if ($sesion_id) {
        $sesion_id = $conexion->real_escape_string($sesion_id);
        $sql = "DELETE FROM carrito WHERE sesion_id = '$sesion_id'";
    } else {
        cerrarDB($conexion);
        return false;
    }
    
    $resultado = $conexion->query($sql);
    $exito = $resultado !== false;
    
    cerrarDB($conexion);
    return $exito;
}

/**
 * Calcula el total del carrito
 * @param array $items Items del carrito
 * @return float Total del carrito
 */
function calcularTotalCarrito($items) {
    $total = 0;
    foreach ($items as $item) {
        $total += $item['precio'] * $item['cantidad'];
    }
    return $total;
}
?>

