<?php
$titulo = 'Inicio';
require_once __DIR__ . '/conf/config.php';
require_once __DIR__ . '/funciones/dao-productos.php';

// Obtener productos destacados (últimos 6 productos)
$productos = obtenerProductos();
$productos_destacados = array_slice($productos, 0, 6);

include __DIR__ . '/includes/header.php';
?>

<div class="container">
    <section class="hero">
        <h2>Bienvenido a nuestra tienda online</h2>
        <p>Descubre nuestros productos y ofertas especiales</p>
        <a href="catalogo.php" class="btn btn-primary">Ver Catálogo</a>
    </section>

    <section class="productos-destacados">
        <h2>Productos Destacados</h2>
        <div class="grid-productos">
            <?php if (empty($productos_destacados)): ?>
                <p>No hay productos disponibles en este momento.</p>
            <?php else: ?>
                <?php foreach ($productos_destacados as $producto): ?>
                    <div class="producto-card">
                        <div class="producto-imagen">
                            <?php if ($producto['imagen']): ?>
                                <img src="<?php echo APP_URL; ?>imagenes/<?php echo htmlspecialchars($producto['imagen']); ?>" 
                                     alt="<?php echo htmlspecialchars($producto['nombre']); ?>"
                                     onerror="this.src='<?php echo APP_URL; ?>imagenes/placeholder.jpg'">
                            <?php else: ?>
                                <img src="<?php echo APP_URL; ?>imagenes/placeholder.jpg" 
                                     alt="<?php echo htmlspecialchars($producto['nombre']); ?>">
                            <?php endif; ?>
                        </div>
                        <div class="producto-info">
                            <h3><a href="producto.php?id=<?php echo $producto['id']; ?>"><?php echo htmlspecialchars($producto['nombre']); ?></a></h3>
                            <p class="producto-categoria"><?php echo htmlspecialchars($producto['categoria_nombre'] ?? 'Sin categoría'); ?></p>
                            <p class="producto-precio"><?php echo formatearPrecio($producto['precio']); ?></p>
                            <p class="producto-stock">Stock: <?php echo $producto['stock']; ?> unidades</p>
                            <a href="producto.php?id=<?php echo $producto['id']; ?>" class="btn btn-secondary">Ver Detalles</a>
                        </div>
                    </div>
                <?php endforeach; ?>
            <?php endif; ?>
        </div>
    </section>
</div>

<?php include __DIR__ . '/includes/footer.php'; ?>

