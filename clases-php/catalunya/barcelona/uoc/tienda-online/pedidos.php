<?php
$titulo = 'Mis Pedidos';
require_once __DIR__ . '/conf/config.php';
require_once __DIR__ . '/funciones/dao-pedidos.php';

// Verificar si el usuario está logueado
if (!estaLogueado()) {
    redirigir('auth/login.php');
}

$usuario_id = obtenerUsuarioId();
$pedidos = obtenerPedidosUsuario($usuario_id);

include __DIR__ . '/includes/header.php';
?>

<div class="container">
    <h1>Mis Pedidos</h1>
    
    <?php if (empty($pedidos)): ?>
        <div class="sin-pedidos">
            <p>No has realizado ningún pedido aún.</p>
            <a href="catalogo.php" class="btn btn-primary">Ver Catálogo</a>
        </div>
    <?php else: ?>
        <div class="lista-pedidos">
            <?php foreach ($pedidos as $pedido): ?>
                <div class="pedido-card">
                    <div class="pedido-header">
                        <div>
                            <h3>Pedido #<?php echo $pedido['id']; ?></h3>
                            <p class="pedido-fecha">Fecha: <?php echo date('d/m/Y H:i', strtotime($pedido['fecha_pedido'])); ?></p>
                        </div>
                        <div class="pedido-estado">
                            <span class="estado-badge estado-<?php echo $pedido['estado']; ?>">
                                <?php echo ucfirst($pedido['estado']); ?>
                            </span>
                        </div>
                    </div>
                    <div class="pedido-body">
                        <p><strong>Total:</strong> <?php echo formatearPrecio($pedido['total']); ?></p>
                        <p><strong>Dirección de envío:</strong> <?php echo htmlspecialchars($pedido['direccion_envio']); ?>, 
                           <?php echo htmlspecialchars($pedido['ciudad_envio']); ?> 
                           (<?php echo htmlspecialchars($pedido['codigo_postal_envio']); ?>)</p>
                    </div>
                    <div class="pedido-acciones">
                        <a href="detalle-pedido.php?id=<?php echo $pedido['id']; ?>" class="btn btn-secondary">Ver Detalles</a>
                    </div>
                </div>
            <?php endforeach; ?>
        </div>
    <?php endif; ?>
</div>

<?php include __DIR__ . '/includes/footer.php'; ?>

