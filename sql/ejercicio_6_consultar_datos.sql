-- ============================================
-- EJERCICIO 6: Consultar Datos (SELECT)
-- ============================================
-- En este ejercicio aprenderás a consultar y ver datos de las tablas.

-- ============================================
-- PREPARACIÓN
-- ============================================
USE escuela;

-- Crear y poblar tabla de ejemplo
CREATE TABLE IF NOT EXISTS estudiantes (
    id INT,
    nombre VARCHAR(50),
    edad INT,
    email VARCHAR(100),
    ciudad VARCHAR(50)
);

INSERT INTO estudiantes (id, nombre, edad, email, ciudad)
VALUES 
    (1, 'Juan Pérez', 20, 'juan@email.com', 'Madrid'),
    (2, 'María García', 22, 'maria@email.com', 'Barcelona'),
    (3, 'Carlos López', 19, 'carlos@email.com', 'Madrid'),
    (4, 'Ana Martínez', 21, 'ana@email.com', 'Valencia'),
    (5, 'Luis Rodríguez', 23, 'luis@email.com', 'Madrid'),
    (6, 'Sofía Fernández', 20, 'sofia@email.com', 'Sevilla');

-- ============================================
-- CONSULTAR TODAS LAS COLUMNAS
-- ============================================

-- Ver todos los registros y todas las columnas
SELECT * FROM estudiantes;

-- ============================================
-- CONSULTAR COLUMNAS ESPECÍFICAS
-- ============================================

-- Ver solo nombre y edad
SELECT nombre, edad FROM estudiantes;

-- Ver solo nombre y email
SELECT nombre, email FROM estudiantes;

-- Ver id, nombre y ciudad
SELECT id, nombre, ciudad FROM estudiantes;

-- ============================================
-- ORDENAR RESULTADOS (ORDER BY)
-- ============================================

-- Ordenar por edad de menor a mayor (ascendente)
SELECT * FROM estudiantes ORDER BY edad;

-- Ordenar por edad de mayor a menor (descendente)
SELECT * FROM estudiantes ORDER BY edad DESC;

-- Ordenar por nombre alfabéticamente
SELECT * FROM estudiantes ORDER BY nombre;

-- Ordenar por múltiples columnas (primero por ciudad, luego por edad)
SELECT * FROM estudiantes ORDER BY ciudad, edad;

-- ============================================
-- LIMITAR RESULTADOS (LIMIT)
-- ============================================

-- Ver solo los primeros 3 estudiantes
SELECT * FROM estudiantes LIMIT 3;

-- Ver los primeros 2 estudiantes ordenados por edad
SELECT * FROM estudiantes ORDER BY edad LIMIT 2;

-- ============================================
-- ALIASES (AS)
-- ============================================

-- Usar alias para cambiar el nombre de las columnas en el resultado
SELECT 
    nombre AS 'Nombre del Estudiante',
    edad AS 'Edad',
    email AS 'Correo Electrónico'
FROM estudiantes;

-- ============================================
-- PRÁCTICA
-- ============================================
-- 1. Muestra solo los nombres y ciudades de todos los estudiantes
-- 2. Ordena los estudiantes por edad de mayor a menor
-- 3. Muestra los 3 estudiantes más jóvenes
-- 4. Muestra nombre y email usando alias: "Nombre Completo" y "Email"

-- ============================================
-- SOLUCIÓN ESPERADA
-- ============================================
/*
-- 1.
SELECT nombre, ciudad FROM estudiantes;

-- 2.
SELECT * FROM estudiantes ORDER BY edad DESC;

-- 3.
SELECT * FROM estudiantes ORDER BY edad LIMIT 3;

-- 4.
SELECT 
    nombre AS 'Nombre Completo',
    email AS 'Email'
FROM estudiantes;
*/

