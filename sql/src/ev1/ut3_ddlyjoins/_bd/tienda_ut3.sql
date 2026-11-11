/*
OBJETIVO: BD practica tienda para EV1 UT3 (DDL demos, GROUP BY y JOIN). Compatible XAMPP/MySQL.
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
*/

DROP DATABASE IF EXISTS tienda;
CREATE DATABASE tienda CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci;
USE tienda;

CREATE TABLE clientes (
    id_cliente INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL,
    apellidos VARCHAR(80) NOT NULL,
    email VARCHAR(100) UNIQUE,
    ciudad VARCHAR(50),
    telefono VARCHAR(20),
    fecha_alta DATE NOT NULL,
    activo TINYINT(1) NOT NULL DEFAULT 1
);

CREATE TABLE productos (
    id_producto INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(80) NOT NULL,
    categoria VARCHAR(40) NOT NULL,
    precio DECIMAL(8,2) NOT NULL,
    stock INT NOT NULL DEFAULT 0,
    descripcion VARCHAR(200),
    fecha_alta DATE NOT NULL
);

CREATE TABLE pedidos (
    id_pedido INT PRIMARY KEY AUTO_INCREMENT,
    id_cliente INT NOT NULL,
    id_producto INT NOT NULL,
    cantidad INT NOT NULL,
    fecha_pedido DATE NOT NULL,
    estado VARCHAR(20) NOT NULL,
    CONSTRAINT fk_pedidos_cliente FOREIGN KEY (id_cliente) REFERENCES clientes(id_cliente),
    CONSTRAINT fk_pedidos_producto FOREIGN KEY (id_producto) REFERENCES productos(id_producto)
);

INSERT INTO clientes (nombre, apellidos, email, ciudad, telefono, fecha_alta, activo) VALUES
('Ana', 'García López', 'ana.garcia@mail.com', 'Madrid', '600111222', '2023-01-15', 1),
('Luis', 'Pérez Ruiz', 'luis.perez@mail.com', 'Barcelona', '600222333', '2023-03-20', 1),
('María', 'Santos Díaz', NULL, 'Valencia', '600333444', '2023-05-10', 1),
('Carlos', 'Nieto Sol', 'carlos.nieto@mail.com', 'Madrid', NULL, '2024-02-01', 1),
('Elena', 'Ruiz Mora', 'elena.ruiz@mail.com', 'Sevilla', '600555666', '2024-04-12', 0),
('Pablo', 'Gil Castro', 'pablo.gil@mail.com', 'Bilbao', '600666777', '2024-06-18', 1),
('Lucía', 'Vega Núñez', NULL, 'Madrid', '600777888', '2024-08-05', 1),
('Diego', 'Ortega Sáez', 'diego.ortega@mail.com', 'Zaragoza', '600888999', '2025-01-09', 1),
('Sofía', 'Campos Rey', 'sofia.campos@mail.com', 'Barcelona', NULL, '2025-03-22', 1),
('Hugo', 'Molina Paz', 'hugo.molina@mail.com', 'Málaga', '600000111', '2025-05-30', 0);

INSERT INTO productos (nombre, categoria, precio, stock, descripcion, fecha_alta) VALUES
('Teclado mecanico', 'Perifericos', 79.90, 25, 'Switch rojo, retroiluminado', '2023-02-01'),
('Raton inalambrico', 'Perifericos', 29.50, 40, 'Ergonomico 2.4GHz', '2023-02-01'),
('Monitor 27 4K', 'Pantallas', 349.00, 12, 'IPS UHD HDR', '2023-06-15'),
('Cable HDMI 2m', 'Cables', 9.99, 100, NULL, '2023-07-01'),
('SSD 1TB NVMe', 'Almacenamiento', 89.00, 30, 'Lectura 3500 MB/s', '2023-09-10'),
('Webcam Full HD', 'Perifericos', 45.00, 18, 'Microfono integrado', '2024-01-20'),
('Auriculares BT', 'Audio', 59.90, 22, 'Cancelacion de ruido', '2024-03-05'),
('Hub USB-C 7 en 1', 'Cables', 39.90, 15, NULL, '2024-05-12'),
('Silla ergonomica', 'Mobiliario', 199.00, 8, 'Soporte lumbar', '2024-08-01'),
('Lampara LED escritorio', 'Mobiliario', 24.90, 35, 'Brazo articulado', '2024-10-15'),
('Portatil 15 i5', 'Portatiles', 799.00, 6, '16GB RAM, 512GB SSD', '2025-01-10'),
('Mochila portatil', 'Accesorios', 34.50, 50, 'Compartimento acolchado', '2025-02-18');

INSERT INTO pedidos (id_cliente, id_producto, cantidad, fecha_pedido, estado) VALUES
(1, 1, 1, '2024-11-02', 'entregado'),
(1, 4, 2, '2024-11-02', 'entregado'),
(2, 3, 1, '2024-12-10', 'enviado'),
(3, 5, 1, '2025-01-15', 'pendiente'),
(4, 2, 1, '2025-02-01', 'entregado'),
(4, 7, 1, '2025-02-01', 'entregado'),
(6, 11, 1, '2025-03-20', 'cancelado'),
(7, 9, 1, '2025-04-05', 'pendiente'),
(8, 6, 2, '2025-05-12', 'enviado'),
(9, 12, 1, '2025-06-01', 'entregado'),
(2, 8, 1, '2025-06-18', 'pendiente'),
(1, 10, 1, '2025-07-03', 'enviado');
