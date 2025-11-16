-- Base de datos para la tienda online
-- Práctica 1 - Comercio Electrónico UOC

-- Crear base de datos
CREATE DATABASE IF NOT EXISTS tienda_online CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

USE tienda_online;

-- Tabla de usuarios
CREATE TABLE IF NOT EXISTS usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellidos VARCHAR(100) NOT NULL,
    email VARCHAR(150) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    telefono VARCHAR(20),
    direccion TEXT,
    ciudad VARCHAR(100),
    codigo_postal VARCHAR(10),
    fecha_registro DATETIME DEFAULT CURRENT_TIMESTAMP,
    activo TINYINT(1) DEFAULT 1,
    INDEX idx_email (email)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Tabla de categorías
CREATE TABLE IF NOT EXISTS categorias (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT,
    activa TINYINT(1) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Tabla de productos
CREATE TABLE IF NOT EXISTS productos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(200) NOT NULL,
    descripcion TEXT,
    precio DECIMAL(10, 2) NOT NULL,
    stock INT DEFAULT 0,
    imagen VARCHAR(255),
    categoria_id INT,
    activo TINYINT(1) DEFAULT 1,
    fecha_creacion DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (categoria_id) REFERENCES categorias(id) ON DELETE SET NULL,
    INDEX idx_categoria (categoria_id),
    INDEX idx_activo (activo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Tabla de pedidos
CREATE TABLE IF NOT EXISTS pedidos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    usuario_id INT NOT NULL,
    fecha_pedido DATETIME DEFAULT CURRENT_TIMESTAMP,
    total DECIMAL(10, 2) NOT NULL,
    estado ENUM('pendiente', 'procesando', 'enviado', 'entregado', 'cancelado') DEFAULT 'pendiente',
    direccion_envio TEXT NOT NULL,
    ciudad_envio VARCHAR(100) NOT NULL,
    codigo_postal_envio VARCHAR(10) NOT NULL,
    telefono_envio VARCHAR(20),
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id) ON DELETE CASCADE,
    INDEX idx_usuario (usuario_id),
    INDEX idx_fecha (fecha_pedido),
    INDEX idx_estado (estado)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Tabla de detalles de pedido
CREATE TABLE IF NOT EXISTS detalles_pedido (
    id INT AUTO_INCREMENT PRIMARY KEY,
    pedido_id INT NOT NULL,
    producto_id INT NOT NULL,
    cantidad INT NOT NULL,
    precio_unitario DECIMAL(10, 2) NOT NULL,
    subtotal DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (pedido_id) REFERENCES pedidos(id) ON DELETE CASCADE,
    FOREIGN KEY (producto_id) REFERENCES productos(id) ON DELETE CASCADE,
    INDEX idx_pedido (pedido_id),
    INDEX idx_producto (producto_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Tabla de carrito (sesión)
CREATE TABLE IF NOT EXISTS carrito (
    id INT AUTO_INCREMENT PRIMARY KEY,
    usuario_id INT,
    sesion_id VARCHAR(255),
    producto_id INT NOT NULL,
    cantidad INT NOT NULL DEFAULT 1,
    fecha_agregado DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id) ON DELETE CASCADE,
    FOREIGN KEY (producto_id) REFERENCES productos(id) ON DELETE CASCADE,
    INDEX idx_usuario (usuario_id),
    INDEX idx_sesion (sesion_id),
    INDEX idx_producto (producto_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Insertar categorías de ejemplo
INSERT INTO categorias (nombre, descripcion) VALUES
('Electrónica', 'Dispositivos electrónicos y tecnología'),
('Ropa', 'Ropa y accesorios de moda'),
('Hogar', 'Artículos para el hogar y decoración'),
('Deportes', 'Equipamiento deportivo y fitness'),
('Libros', 'Libros y material de lectura');

-- Insertar productos de ejemplo
INSERT INTO productos (nombre, descripcion, precio, stock, categoria_id, imagen) VALUES
('Smartphone XYZ', 'Teléfono inteligente con pantalla de 6.5 pulgadas, 128GB de almacenamiento', 299.99, 50, 1, 'smartphone.jpg'),
('Laptop ABC', 'Portátil con procesador Intel i7, 16GB RAM, 512GB SSD', 899.99, 30, 1, 'laptop.jpg'),
('Auriculares Bluetooth', 'Auriculares inalámbricos con cancelación de ruido', 79.99, 100, 1, 'auriculares.jpg'),
('Camiseta Básica', 'Camiseta de algodón 100%, disponible en varios colores', 19.99, 200, 2, 'camiseta.jpg'),
('Pantalón Vaquero', 'Pantalón vaquero clásico, corte regular', 49.99, 150, 2, 'pantalon.jpg'),
('Zapatillas Deportivas', 'Zapatillas para running con tecnología de amortiguación', 89.99, 80, 4, 'zapatillas.jpg'),
('Mesa de Comedor', 'Mesa de madera para 6 personas', 299.99, 20, 3, 'mesa.jpg'),
('Sofá Moderno', 'Sofá de 3 plazas con tapizado de tela', 599.99, 15, 3, 'sofa.jpg'),
('Libro de Programación PHP', 'Guía completa de programación en PHP', 29.99, 100, 5, 'libro-php.jpg'),
('Libro de MySQL', 'Manual de bases de datos MySQL', 34.99, 80, 5, 'libro-mysql.jpg');

-- Insertar usuario de prueba (password: admin123)
INSERT INTO usuarios (nombre, apellidos, email, password, telefono, direccion, ciudad, codigo_postal) VALUES
('Admin', 'Sistema', 'admin@tienda.com', '$2y$10$92IXUNpkjO0rOQ5byMi.Ye4oKoEa3Ro9llC/.og/at2.uheWG/igi', '600123456', 'Calle Principal 123', 'Barcelona', '08001');

