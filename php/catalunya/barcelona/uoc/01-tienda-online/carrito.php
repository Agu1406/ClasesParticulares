<?php
$titulo = 'Carrito de Compras';
require_once __DIR__ . '/conf/config.php';
require_once __DIR__ . '/funciones/dao-carrito.php';

// Verificar si el usuario está logueado
if (!estaLogueado()) {
    redirigir('auth/login.php');
}

$usuario_id = obtenerUsuarioId();
$items = obtenerCarrito($usuario_id);
$total = calcularTotalCarrito($items);

// Procesar acciones del carrito
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    if (isset($_POST['eliminar_item'])) {
        $item_id = (int)$_POST['item_id'];
        eliminarDelCarrito($item_id);
        redirigir('carrito.php');
    } elseif (isset($_POST['actualizar_cantidad'])) {
        $item_id = (int)$_POST['item_id'];
        $cantidad = (int)$_POST['cantidad'];
        actualizarCantidadCarrito($item_id, $cantidad);
        redirigir('carrito.php');
    } elseif (isset($_POST['vaciar_carrito'])) {
        vaciarCarrito($usuario_id);
        redirigir('carrito.php');
    }
}

include __DIR__ . '/includes/header.php';
?>

<div class="container">
    <h1>Carrito de Compras</h1>
    
    <?php if (empty($items)): ?>
        <div class="carrito-vacio">
            <p>Tu carrito está vacío.</p>
            <a href="catalogo.php" class="btn btn-primary">Continuar Comprando</a>
        </div>
    <?php else: ?>
        <div class="carrito-contenido">
            <table class="tabla-carrito">
                <thead>
                    <tr>
                        <th>Producto</th>
                        <th>Precio</th>
                        <th>Cantidad</th>
                        <th>Subtotal</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <?php foreach ($items as $item): ?>
                        <tr>
                            <td>
                                <div class="item-producto">
                                    <?php if ($item['imagen']): ?>
                                        <img src="imagenes/<?php echo htmlspecialchars($item['imagen']); ?>" 
                                             alt="<?php echo htmlspecialchars($item['nombre']); ?>"
                                             class="item-imagen"
                                             onerror="this.src='imagenes/placeholder.jpg'">
                                    <?php endif; ?>
                                    <span><?php echo htmlspecialchars($item['nombre']); ?></span>
                                </div>
                            </td>
                            <td><?php echo formatearPrecio($item['precio']); ?></td>
                            <td>
                                <form method="POST" class="form-cantidad">
                                    <input type="hidden" name="item_id" value="<?php echo $item['id']; ?>">
                                    <input type="number" name="cantidad" value="<?php echo $item['cantidad']; ?>" 
                                           min="1" max="<?php echo $item['stock']; ?>" required>
                                    <button type="submit" name="actualizar_cantidad" class="btn btn-small">Actualizar</button>
                                </form>
                            </td>
                            <td><?php echo formatearPrecio($item['precio'] * $item['cantidad']); ?></td>
                            <td>
                                <form method="POST" onsubmit="return confirm('¿Estás seguro de eliminar este producto?');">
                                    <input type="hidden" name="item_id" value="<?php echo $item['id']; ?>">
                                    <button type="submit" name="eliminar_item" class="btn btn-danger btn-small">Eliminar</button>
                                </form>
                            </td>
                        </tr>
                    <?php endforeach; ?>
                </tbody>
                <tfoot>
                    <tr>
                        <td colspan="3"><strong>Total:</strong></td>
                        <td colspan="2"><strong><?php echo formatearPrecio($total); ?></strong></td>
                    </tr>
                </tfoot>
            </table>
            
            <div class="carrito-acciones">
                <form method="POST" onsubmit="return confirm('¿Estás seguro de vaciar el carrito?');">
                    <button type="submit" name="vaciar_carrito" class="btn btn-danger">Vaciar Carrito</button>
                </form>
                <div class="carrito-botones">
                    <a href="catalogo.php" class="btn btn-secondary">Continuar Comprando</a>
                    <a href="checkout.php" class="btn btn-primary">Proceder al Pago</a>
                </div>
            </div>
        </div>
    <?php endif; ?>
</div>

<?php include __DIR__ . '/includes/footer.php'; ?>

