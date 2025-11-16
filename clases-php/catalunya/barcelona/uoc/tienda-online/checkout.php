<?php
$titulo = 'Checkout';
require_once __DIR__ . '/conf/config.php';
require_once __DIR__ . '/funciones/dao-carrito.php';
require_once __DIR__ . '/funciones/dao-usuarios.php';
require_once __DIR__ . '/funciones/dao-pedidos.php';

// Verificar si el usuario está logueado
if (!estaLogueado()) {
    redirigir('auth/login.php?redirect=checkout.php');
}

$usuario_id = obtenerUsuarioId();
$usuario = obtenerUsuarioPorId($usuario_id);
$items = obtenerCarrito($usuario_id);

if (empty($items)) {
    redirigir('carrito.php');
}

$total = calcularTotalCarrito($items);
$error = '';

// Procesar pedido
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $direccion = isset($_POST['direccion']) ? limpiarDatos($_POST['direccion']) : '';
    $ciudad = isset($_POST['ciudad']) ? limpiarDatos($_POST['ciudad']) : '';
    $codigo_postal = isset($_POST['codigo_postal']) ? limpiarDatos($_POST['codigo_postal']) : '';
    $telefono = isset($_POST['telefono']) ? limpiarDatos($_POST['telefono']) : '';
    
    if (empty($direccion) || empty($ciudad) || empty($codigo_postal)) {
        $error = 'Por favor, completa todos los campos de envío';
    } else {
        $datos_envio = [
            'direccion' => $direccion,
            'ciudad' => $ciudad,
            'codigo_postal' => $codigo_postal,
            'telefono' => $telefono
        ];
        
        $pedido_id = crearPedido($usuario_id, $items, $datos_envio);
        
        if ($pedido_id) {
            // Vaciar carrito
            vaciarCarrito($usuario_id);
            
            // Redirigir a confirmación
            redirigir("pedido-confirmado.php?id=$pedido_id");
        } else {
            $error = 'Error al procesar el pedido. Por favor, intenta de nuevo';
        }
    }
}

include __DIR__ . '/includes/header.php';
?>

<div class="container">
    <h1>Finalizar Compra</h1>
    
    <?php if ($error): ?>
        <div class="mensaje error">
            <?php echo htmlspecialchars($error); ?>
        </div>
    <?php endif; ?>
    
    <div class="checkout-layout">
        <div class="checkout-resumen">
            <h2>Resumen del Pedido</h2>
            <div class="resumen-items">
                <?php foreach ($items as $item): ?>
                    <div class="resumen-item">
                        <span><?php echo htmlspecialchars($item['nombre']); ?> x <?php echo $item['cantidad']; ?></span>
                        <span><?php echo formatearPrecio($item['precio'] * $item['cantidad']); ?></span>
                    </div>
                <?php endforeach; ?>
            </div>
            <div class="resumen-total">
                <strong>Total: <?php echo formatearPrecio($total); ?></strong>
            </div>
        </div>
        
        <div class="checkout-formulario">
            <h2>Datos de Envío</h2>
            <form method="POST">
                <div class="form-group">
                    <label for="direccion">Dirección: *</label>
                    <input type="text" id="direccion" name="direccion" required 
                           value="<?php echo isset($_POST['direccion']) ? htmlspecialchars($_POST['direccion']) : htmlspecialchars($usuario['direccion'] ?? ''); ?>">
                </div>
                
                <div class="form-row">
                    <div class="form-group">
                        <label for="ciudad">Ciudad: *</label>
                        <input type="text" id="ciudad" name="ciudad" required 
                               value="<?php echo isset($_POST['ciudad']) ? htmlspecialchars($_POST['ciudad']) : htmlspecialchars($usuario['ciudad'] ?? ''); ?>">
                    </div>
                    
                    <div class="form-group">
                        <label for="codigo_postal">Código Postal: *</label>
                        <input type="text" id="codigo_postal" name="codigo_postal" required 
                               value="<?php echo isset($_POST['codigo_postal']) ? htmlspecialchars($_POST['codigo_postal']) : htmlspecialchars($usuario['codigo_postal'] ?? ''); ?>">
                    </div>
                </div>
                
                <div class="form-group">
                    <label for="telefono">Teléfono:</label>
                    <input type="tel" id="telefono" name="telefono" 
                           value="<?php echo isset($_POST['telefono']) ? htmlspecialchars($_POST['telefono']) : htmlspecialchars($usuario['telefono'] ?? ''); ?>">
                </div>
                
                <button type="submit" class="btn btn-primary">Confirmar Pedido</button>
                <a href="carrito.php" class="btn btn-secondary">Volver al Carrito</a>
            </form>
        </div>
    </div>
</div>

<?php include __DIR__ . '/includes/footer.php'; ?>

