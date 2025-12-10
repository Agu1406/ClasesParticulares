-- ============================================
-- EJERCICIO 10: Operadores y Funciones Básicas
-- ============================================
-- En este ejercicio aprenderás a usar operadores matemáticos
-- y funciones útiles en MySQL.

-- ============================================
-- PREPARACIÓN
-- ============================================
USE escuela;

-- Crear y poblar tabla de ejemplo
CREATE TABLE IF NOT EXISTS productos (
    id INT,
    nombre VARCHAR(100),
    precio DECIMAL(10, 2),
    cantidad INT,
    fecha_creacion DATE
);

INSERT INTO productos (id, nombre, precio, cantidad, fecha_creacion)
VALUES 
    (1, 'Laptop', 999.99, 5, '2024-01-15'),
    (2, 'Mouse', 25.50, 20, '2024-02-20'),
    (3, 'Teclado', 45.00, 15, '2024-03-10'),
    (4, 'Monitor', 299.99, 8, '2024-01-25'),
    (5, 'Auriculares', 79.99, 12, '2024-02-15');

-- ============================================
-- OPERADORES MATEMÁTICOS
-- ============================================

-- Suma (+)
SELECT nombre, precio, cantidad, precio + 10 AS 'Precio con recargo' 
FROM productos;

-- Resta (-)
SELECT nombre, precio, precio - 5 AS 'Precio con descuento' 
FROM productos;

-- Multiplicación (*)
SELECT nombre, precio, cantidad, precio * cantidad AS 'Valor total' 
FROM productos;

-- División (/)
SELECT nombre, precio, precio / 2 AS 'Precio mitad' 
FROM productos;

-- Módulo (%)
SELECT nombre, cantidad, cantidad % 3 AS 'Resto división por 3' 
FROM productos;

-- ============================================
-- FUNCIONES DE AGREGACIÓN
-- ============================================

-- COUNT: Contar registros
SELECT COUNT(*) AS total_productos FROM productos;

-- SUM: Sumar valores
SELECT SUM(precio) AS suma_precios FROM productos;
SELECT SUM(precio * cantidad) AS valor_total_inventario FROM productos;

-- AVG: Promedio
SELECT AVG(precio) AS precio_promedio FROM productos;

-- MAX: Valor máximo
SELECT MAX(precio) AS precio_maximo FROM productos;
SELECT MAX(cantidad) AS cantidad_maxima FROM productos;

-- MIN: Valor mínimo
SELECT MIN(precio) AS precio_minimo FROM productos;
SELECT MIN(cantidad) AS cantidad_minima FROM productos;

-- ============================================
-- FUNCIONES DE TEXTO
-- ============================================

-- CONCAT: Concatenar textos
SELECT CONCAT(nombre, ' - $', precio) AS producto_precio FROM productos;

-- UPPER: Convertir a mayúsculas
SELECT UPPER(nombre) AS nombre_mayusculas FROM productos;

-- LOWER: Convertir a minúsculas
SELECT LOWER(nombre) AS nombre_minusculas FROM productos;

-- LENGTH: Longitud del texto
SELECT nombre, LENGTH(nombre) AS longitud_nombre FROM productos;

-- SUBSTRING: Extraer parte del texto
SELECT nombre, SUBSTRING(nombre, 1, 3) AS primeras_3_letras FROM productos;

-- ============================================
-- FUNCIONES DE FECHA
-- ============================================

-- NOW(): Fecha y hora actual
SELECT NOW() AS fecha_actual;

-- CURDATE(): Fecha actual
SELECT CURDATE() AS fecha_hoy;

-- CURTIME(): Hora actual
SELECT CURTIME() AS hora_actual;

-- YEAR(): Extraer el año
SELECT nombre, fecha_creacion, YEAR(fecha_creacion) AS año FROM productos;

-- MONTH(): Extraer el mes
SELECT nombre, fecha_creacion, MONTH(fecha_creacion) AS mes FROM productos;

-- DAY(): Extraer el día
SELECT nombre, fecha_creacion, DAY(fecha_creacion) AS dia FROM productos;

-- DATEDIFF(): Diferencia entre fechas
SELECT nombre, fecha_creacion, 
       DATEDIFF(CURDATE(), fecha_creacion) AS dias_desde_creacion 
FROM productos;

-- ============================================
-- GROUP BY (Agrupar resultados)
-- ============================================

-- Agrupar por año de creación
SELECT YEAR(fecha_creacion) AS año, COUNT(*) AS total_productos 
FROM productos 
GROUP BY YEAR(fecha_creacion);

-- Agrupar y calcular promedios
SELECT YEAR(fecha_creacion) AS año, AVG(precio) AS precio_promedio 
FROM productos 
GROUP BY YEAR(fecha_creacion);

-- ============================================
-- HAVING (Filtrar grupos)
-- ============================================

-- Mostrar solo años con más de 1 producto
SELECT YEAR(fecha_creacion) AS año, COUNT(*) AS total_productos 
FROM productos 
GROUP BY YEAR(fecha_creacion)
HAVING COUNT(*) > 1;

-- ============================================
-- PRÁCTICA
-- ============================================
-- 1. Calcula el valor total del inventario (precio * cantidad) para cada producto
-- 2. Encuentra el precio promedio de todos los productos
-- 3. Muestra el nombre del producto en mayúsculas junto con su precio
-- 4. Calcula cuántos días han pasado desde la creación de cada producto
-- 5. Agrupa los productos por mes de creación y cuenta cuántos hay en cada mes

-- ============================================
-- SOLUCIÓN ESPERADA
-- ============================================
/*
-- 1.
SELECT nombre, precio, cantidad, precio * cantidad AS valor_total 
FROM productos;

-- 2.
SELECT AVG(precio) AS precio_promedio FROM productos;

-- 3.
SELECT UPPER(nombre) AS nombre, precio FROM productos;

-- 4.
SELECT nombre, fecha_creacion, 
       DATEDIFF(CURDATE(), fecha_creacion) AS dias_desde_creacion 
FROM productos;

-- 5.
SELECT MONTH(fecha_creacion) AS mes, COUNT(*) AS total_productos 
FROM productos 
GROUP BY MONTH(fecha_creacion);
*/

