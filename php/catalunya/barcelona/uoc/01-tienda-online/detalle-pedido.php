<?php
$titulo = 'Detalle del Pedido';
require_once __DIR__ . '/conf/config.php';
require_once __DIR__ . '/funciones/dao-pedidos.php';

// Verificar si el usuario está logueado
if (!estaLogueado()) {
    redirigir('auth/login.php');
}

$pedido_id = isset($_GET['id']) ? (int)$_GET['id'] : 0;
$usuario_id = obtenerUsuarioId();

if ($pedido_id <= 0) {
    redirigir('pedidos.php');
}

$pedido = obtenerPedidoPorId($pedido_id, $usuario_id);

if (!$pedido) {
    redirigir('pedidos.php');
}

$detalles = obtenerDetallesPedido($pedido_id);

include __DIR__ . '/includes/header.php';
?>

<div class="container">
    <h1>Detalle del Pedido #<?php echo $pedido['id']; ?></h1>
    
    <div class="pedido-detalle-completo">
        <div class="pedido-info">
            <h2>Información del Pedido</h2>
            <p><strong>Fecha:</strong> <?php echo date('d/m/Y H:i', strtotime($pedido['fecha_pedido'])); ?></p>
            <p><strong>Estado:</strong> 
                <span class="estado-badge estado-<?php echo $pedido['estado']; ?>">
                    <?php echo ucfirst($pedido['estado']); ?>
                </span>
            </p>
            <p><strong>Total:</strong> <?php echo formatearPrecio($pedido['total']); ?></p>
        </div>
        
        <div class="pedido-productos">
            <h2>Productos</h2>
            <table class="tabla-pedido">
                <thead>
                    <tr>
                        <th>Producto</th>
                        <th>Cantidad</th>
                        <th>Precio Unitario</th>
                        <th>Subtotal</th>
                    </tr>
                </thead>
                <tbody>
                    <?php foreach ($detalles as $detalle): ?>
                        <tr>
                            <td><?php echo htmlspecialchars($detalle['producto_nombre']); ?></td>
                            <td><?php echo $detalle['cantidad']; ?></td>
                            <td><?php echo formatearPrecio($detalle['precio_unitario']); ?></td>
                            <td><?php echo formatearPrecio($detalle['subtotal']); ?></td>
                        </tr>
                    <?php endforeach; ?>
                </tbody>
                <tfoot>
                    <tr>
                        <td colspan="3"><strong>Total:</strong></td>
                        <td><strong><?php echo formatearPrecio($pedido['total']); ?></strong></td>
                    </tr>
                </tfoot>
            </table>
        </div>
        
        <div class="pedido-envio">
            <h2>Dirección de Envío</h2>
            <p><?php echo htmlspecialchars($pedido['direccion_envio']); ?></p>
            <p><?php echo htmlspecialchars($pedido['codigo_postal_envio']); ?> <?php echo htmlspecialchars($pedido['ciudad_envio']); ?></p>
            <?php if ($pedido['telefono_envio']): ?>
                <p>Teléfono: <?php echo htmlspecialchars($pedido['telefono_envio']); ?></p>
            <?php endif; ?>
        </div>
        
        <div class="pedido-acciones">
            <a href="pedidos.php" class="btn btn-secondary">Volver a Mis Pedidos</a>
        </div>
    </div>
</div>

<?php include __DIR__ . '/includes/footer.php'; ?>

