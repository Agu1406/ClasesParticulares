<?php
$titulo = 'Producto';
require_once __DIR__ . '/conf/config.php';
require_once __DIR__ . '/funciones/dao-productos.php';
require_once __DIR__ . '/funciones/dao-carrito.php';

// Obtener ID del producto
$producto_id = isset($_GET['id']) ? (int)$_GET['id'] : 0;

if ($producto_id <= 0) {
    redirigir('catalogo.php');
}

// Obtener producto
$producto = obtenerProductoPorId($producto_id);

if (!$producto) {
    redirigir('catalogo.php');
}

// Procesar agregar al carrito
$mensaje = '';
$tipo_mensaje = '';

if ($_SERVER['REQUEST_METHOD'] === 'POST' && isset($_POST['agregar_carrito'])) {
    $cantidad = isset($_POST['cantidad']) ? (int)$_POST['cantidad'] : 1;
    
    if ($cantidad <= 0) {
        $mensaje = 'La cantidad debe ser mayor a 0';
        $tipo_mensaje = 'error';
    } elseif ($cantidad > $producto['stock']) {
        $mensaje = 'No hay suficiente stock disponible';
        $tipo_mensaje = 'error';
    } else {
        $usuario_id = obtenerUsuarioId();
        $sesion_id = obtenerSesionId();
        
        if (agregarAlCarrito($producto_id, $cantidad, $usuario_id, $sesion_id)) {
            $mensaje = 'Producto agregado al carrito correctamente';
            $tipo_mensaje = 'success';
        } else {
            $mensaje = 'Error al agregar el producto al carrito';
            $tipo_mensaje = 'error';
        }
    }
}

include __DIR__ . '/includes/header.php';
?>

<div class="container">
    <?php if ($mensaje): ?>
        <div class="mensaje <?php echo $tipo_mensaje; ?>">
            <?php echo htmlspecialchars($mensaje); ?>
        </div>
    <?php endif; ?>
    
    <div class="producto-detalle">
        <div class="producto-imagen-grande">
            <?php if ($producto['imagen']): ?>
                <img src="imagenes/<?php echo htmlspecialchars($producto['imagen']); ?>" 
                     alt="<?php echo htmlspecialchars($producto['nombre']); ?>"
                     onerror="this.src='imagenes/placeholder.jpg'">
            <?php else: ?>
                <img src="imagenes/placeholder.jpg" 
                     alt="<?php echo htmlspecialchars($producto['nombre']); ?>">
            <?php endif; ?>
        </div>
        
        <div class="producto-info-detalle">
            <h1><?php echo htmlspecialchars($producto['nombre']); ?></h1>
            <p class="producto-categoria">Categoría: <?php echo htmlspecialchars($producto['categoria_nombre'] ?? 'Sin categoría'); ?></p>
            <p class="producto-precio-grande"><?php echo formatearPrecio($producto['precio']); ?></p>
            
            <?php if ($producto['descripcion']): ?>
                <div class="producto-descripcion">
                    <h3>Descripción</h3>
                    <p><?php echo nl2br(htmlspecialchars($producto['descripcion'])); ?></p>
                </div>
            <?php endif; ?>
            
            <div class="producto-stock-info">
                <p><strong>Stock disponible:</strong> <?php echo $producto['stock']; ?> unidades</p>
            </div>
            
            <?php if ($producto['stock'] > 0): ?>
                <form method="POST" class="form-agregar-carrito">
                    <div class="form-group">
                        <label for="cantidad">Cantidad:</label>
                        <input type="number" id="cantidad" name="cantidad" value="1" min="1" max="<?php echo $producto['stock']; ?>" required>
                    </div>
                    <button type="submit" name="agregar_carrito" class="btn btn-primary">Agregar al Carrito</button>
                </form>
            <?php else: ?>
                <p class="sin-stock">Producto sin stock</p>
            <?php endif; ?>
            
            <a href="catalogo.php" class="btn btn-secondary">Volver al Catálogo</a>
        </div>
    </div>
</div>

<?php include __DIR__ . '/includes/footer.php'; ?>

