<?php
$titulo = 'Catálogo';
require_once __DIR__ . '/conf/config.php';
require_once __DIR__ . '/funciones/dao-productos.php';

// Obtener categoría seleccionada
$categoria_id = isset($_GET['categoria']) ? (int)$_GET['categoria'] : null;

// Obtener productos
$productos = obtenerProductos($categoria_id);
$categorias = obtenerCategorias();

include __DIR__ . '/includes/header.php';
?>

<div class="container">
    <h1>Catálogo de Productos</h1>
    
    <div class="catalogo-layout">
        <aside class="filtros">
            <h3>Filtrar por Categoría</h3>
            <ul class="lista-categorias">
                <li><a href="catalogo.php" class="<?php echo $categoria_id === null ? 'active' : ''; ?>">Todas las categorías</a></li>
                <?php foreach ($categorias as $categoria): ?>
                    <li>
                        <a href="catalogo.php?categoria=<?php echo $categoria['id']; ?>" 
                           class="<?php echo $categoria_id == $categoria['id'] ? 'active' : ''; ?>">
                            <?php echo htmlspecialchars($categoria['nombre']); ?>
                        </a>
                    </li>
                <?php endforeach; ?>
            </ul>
        </aside>
        
        <div class="productos-grid">
            <?php if (empty($productos)): ?>
                <p class="mensaje-vacio">No hay productos disponibles en esta categoría.</p>
            <?php else: ?>
                <?php foreach ($productos as $producto): ?>
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
    </div>
</div>

<?php include __DIR__ . '/includes/footer.php'; ?>

