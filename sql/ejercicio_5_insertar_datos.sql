-- ============================================
-- EJERCICIO 5: Insertar Datos (INSERT)
-- ============================================
-- En este ejercicio aprenderás a insertar datos en las tablas.

-- ============================================
-- PREPARACIÓN
-- ============================================
USE escuela;

-- Crear una tabla de ejemplo
CREATE TABLE IF NOT EXISTS estudiantes (
    id INT,
    nombre VARCHAR(50),
    edad INT,
    email VARCHAR(100)
);

-- ============================================
-- INSERTAR UN REGISTRO
-- ============================================

-- Insertar un estudiante con todos los campos
INSERT INTO estudiantes (id, nombre, edad, email)
VALUES (1, 'Juan Pérez', 20, 'juan@email.com');

-- Insertar especificando solo algunos campos
INSERT INTO estudiantes (nombre, edad)
VALUES ('María García', 22);

-- Insertar sin especificar nombres de columnas (debe incluir todos los valores)
INSERT INTO estudiantes
VALUES (3, 'Carlos López', 19, 'carlos@email.com');

-- ============================================
-- INSERTAR MÚLTIPLES REGISTROS
-- ============================================

-- Insertar varios estudiantes a la vez
INSERT INTO estudiantes (id, nombre, edad, email)
VALUES 
    (4, 'Ana Martínez', 21, 'ana@email.com'),
    (5, 'Luis Rodríguez', 23, 'luis@email.com'),
    (6, 'Sofía Fernández', 20, 'sofia@email.com');

-- ============================================
-- VERIFICAR LOS DATOS INSERTADOS
-- ============================================

-- Ver todos los registros de la tabla
SELECT * FROM estudiantes;

-- ============================================
-- INSERTAR CON DIFERENTES TIPOS DE DATOS
-- ============================================

-- Crear tabla de ejemplo con diferentes tipos
CREATE TABLE IF NOT EXISTS productos (
    id INT,
    nombre VARCHAR(100),
    precio DECIMAL(10, 2),
    disponible BOOLEAN,
    fecha_creacion DATE
);

-- Insertar productos
INSERT INTO productos (id, nombre, precio, disponible, fecha_creacion)
VALUES 
    (1, 'Laptop', 999.99, TRUE, '2024-01-15'),
    (2, 'Mouse', 25.50, TRUE, '2024-02-20'),
    (3, 'Teclado', 45.00, FALSE, '2024-03-10');

-- Ver los productos insertados
SELECT * FROM productos;

-- ============================================
-- PRÁCTICA
-- ============================================
-- 1. Crea una tabla llamada "profesores" con:
--    - id (INT)
--    - nombre (VARCHAR(80))
--    - materia (VARCHAR(50))
--    - años_experiencia (INT)
-- 2. Inserta 5 profesores diferentes
-- 3. Verifica que todos se insertaron correctamente usando SELECT

-- ============================================
-- SOLUCIÓN ESPERADA
-- ============================================
/*
CREATE TABLE profesores (
    id INT,
    nombre VARCHAR(80),
    materia VARCHAR(50),
    años_experiencia INT
);

INSERT INTO profesores (id, nombre, materia, años_experiencia)
VALUES 
    (1, 'Dr. García', 'Matemáticas', 10),
    (2, 'Dra. López', 'Historia', 5),
    (3, 'Prof. Martínez', 'Ciencias', 8),
    (4, 'Dra. Fernández', 'Literatura', 12),
    (5, 'Prof. Rodríguez', 'Inglés', 3);

SELECT * FROM profesores;
*/

