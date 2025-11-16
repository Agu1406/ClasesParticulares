<?php
/**
 * Data Access Object para pedidos
 */

require_once __DIR__ . '/../conf/db.php';
require_once __DIR__ . '/funciones.php';

/**
 * Crea un nuevo pedido
 * @param int $usuario_id ID del usuario
 * @param array $items Items del carrito
 * @param array $datos_envio Datos de envío
 * @return int|false ID del pedido creado o false en caso de error
 */
function crearPedido($usuario_id, $items, $datos_envio) {
    $conexion = conectarDB();
    $conexion->autocommit(false);
    
    try {
        // Calcular total
        $total = 0;
        foreach ($items as $item) {
            $total += $item['precio'] * $item['cantidad'];
        }
        
        // Crear pedido
        $usuario_id = (int)$usuario_id;
        $total = (float)$total;
        $direccion = $conexion->real_escape_string($datos_envio['direccion']);
        $ciudad = $conexion->real_escape_string($datos_envio['ciudad']);
        $codigo_postal = $conexion->real_escape_string($datos_envio['codigo_postal']);
        $telefono = isset($datos_envio['telefono']) ? $conexion->real_escape_string($datos_envio['telefono']) : '';
        
        $sql = "INSERT INTO pedidos (usuario_id, total, direccion_envio, ciudad_envio, codigo_postal_envio, telefono_envio) 
                VALUES ($usuario_id, $total, '$direccion', '$ciudad', '$codigo_postal', '$telefono')";
        
        if (!$conexion->query($sql)) {
            throw new Exception("Error al crear el pedido");
        }
        
        $pedido_id = $conexion->insert_id;
        
        // Crear detalles del pedido
        foreach ($items as $item) {
            $producto_id = (int)$item['producto_id'];
            $cantidad = (int)$item['cantidad'];
            $precio_unitario = (float)$item['precio'];
            $subtotal = $precio_unitario * $cantidad;
            
            $sql = "INSERT INTO detalles_pedido (pedido_id, producto_id, cantidad, precio_unitario, subtotal) 
                    VALUES ($pedido_id, $producto_id, $cantidad, $precio_unitario, $subtotal)";
            
            if (!$conexion->query($sql)) {
                throw new Exception("Error al crear los detalles del pedido");
            }
            
            // Actualizar stock
            $sql = "UPDATE productos SET stock = stock - $cantidad WHERE id = $producto_id";
            if (!$conexion->query($sql)) {
                throw new Exception("Error al actualizar el stock");
            }
        }
        
        $conexion->commit();
        cerrarDB($conexion);
        return $pedido_id;
        
    } catch (Exception $e) {
        $conexion->rollback();
        cerrarDB($conexion);
        return false;
    }
}

/**
 * Obtiene los pedidos de un usuario
 * @param int $usuario_id ID del usuario
 * @return array Lista de pedidos
 */
function obtenerPedidosUsuario($usuario_id) {
    $conexion = conectarDB();
    $usuario_id = (int)$usuario_id;
    
    $sql = "SELECT * FROM pedidos WHERE usuario_id = $usuario_id ORDER BY fecha_pedido DESC";
    $resultado = $conexion->query($sql);
    $pedidos = [];
    
    if ($resultado && $resultado->num_rows > 0) {
        while ($fila = $resultado->fetch_assoc()) {
            $pedidos[] = $fila;
        }
    }
    
    cerrarDB($conexion);
    return $pedidos;
}

/**
 * Obtiene un pedido por ID
 * @param int $pedido_id ID del pedido
 * @param int|null $usuario_id ID del usuario (para verificar propiedad)
 * @return array|null Datos del pedido o null si no existe
 */
function obtenerPedidoPorId($pedido_id, $usuario_id = null) {
    $conexion = conectarDB();
    $pedido_id = (int)$pedido_id;
    
    $sql = "SELECT * FROM pedidos WHERE id = $pedido_id";
    if ($usuario_id) {
        $usuario_id = (int)$usuario_id;
        $sql .= " AND usuario_id = $usuario_id";
    }
    
    $resultado = $conexion->query($sql);
    $pedido = null;
    
    if ($resultado && $resultado->num_rows > 0) {
        $pedido = $resultado->fetch_assoc();
    }
    
    cerrarDB($conexion);
    return $pedido;
}

/**
 * Obtiene los detalles de un pedido
 * @param int $pedido_id ID del pedido
 * @return array Lista de detalles del pedido
 */
function obtenerDetallesPedido($pedido_id) {
    $conexion = conectarDB();
    $pedido_id = (int)$pedido_id;
    
    $sql = "SELECT dp.*, p.nombre as producto_nombre, p.imagen 
            FROM detalles_pedido dp 
            INNER JOIN productos p ON dp.producto_id = p.id 
            WHERE dp.pedido_id = $pedido_id";
    
    $resultado = $conexion->query($sql);
    $detalles = [];
    
    if ($resultado && $resultado->num_rows > 0) {
        while ($fila = $resultado->fetch_assoc()) {
            $detalles[] = $fila;
        }
    }
    
    cerrarDB($conexion);
    return $detalles;
}
?>

