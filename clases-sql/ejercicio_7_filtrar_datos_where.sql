-- ============================================
-- EJERCICIO 7: Filtrar Datos (WHERE)
-- ============================================
-- En este ejercicio aprenderás a filtrar datos usando condiciones.

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
    ciudad VARCHAR(50),
    nota DECIMAL(4, 2)
);

INSERT INTO estudiantes (id, nombre, edad, email, ciudad, nota)
VALUES 
    (1, 'Juan Pérez', 20, 'juan@email.com', 'Madrid', 8.5),
    (2, 'María García', 22, 'maria@email.com', 'Barcelona', 9.0),
    (3, 'Carlos López', 19, 'carlos@email.com', 'Madrid', 7.5),
    (4, 'Ana Martínez', 21, 'ana@email.com', 'Valencia', 6.5),
    (5, 'Luis Rodríguez', 23, 'luis@email.com', 'Madrid', 8.0),
    (6, 'Sofía Fernández', 20, 'sofia@email.com', 'Sevilla', 9.5);

-- ============================================
-- OPERADORES DE COMPARACIÓN
-- ============================================

-- Igual a (=)
SELECT * FROM estudiantes WHERE ciudad = 'Madrid';

-- Diferente de (!= o <>)
SELECT * FROM estudiantes WHERE ciudad != 'Madrid';
SELECT * FROM estudiantes WHERE ciudad <> 'Madrid';

-- Mayor que (>)
SELECT * FROM estudiantes WHERE edad > 20;

-- Mayor o igual que (>=)
SELECT * FROM estudiantes WHERE nota >= 8.0;

-- Menor que (<)
SELECT * FROM estudiantes WHERE edad < 21;

-- Menor o igual que (<=)
SELECT * FROM estudiantes WHERE nota <= 7.0;

-- ============================================
-- OPERADORES LÓGICOS
-- ============================================

-- AND: Ambas condiciones deben ser verdaderas
SELECT * FROM estudiantes WHERE ciudad = 'Madrid' AND edad > 20;

-- OR: Al menos una condición debe ser verdadera
SELECT * FROM estudiantes WHERE ciudad = 'Madrid' OR ciudad = 'Barcelona';

-- NOT: Niega una condición
SELECT * FROM estudiantes WHERE NOT ciudad = 'Madrid';

-- Combinar múltiples condiciones
SELECT * FROM estudiantes 
WHERE (ciudad = 'Madrid' OR ciudad = 'Barcelona') 
AND nota >= 8.0;

-- ============================================
-- OPERADOR IN
-- ============================================

-- Buscar valores en una lista
SELECT * FROM estudiantes WHERE ciudad IN ('Madrid', 'Barcelona', 'Valencia');

-- Equivale a:
-- SELECT * FROM estudiantes WHERE ciudad = 'Madrid' OR ciudad = 'Barcelona' OR ciudad = 'Valencia';

-- ============================================
-- OPERADOR LIKE (Búsqueda de texto)
-- ============================================

-- Buscar nombres que empiecen con 'J'
SELECT * FROM estudiantes WHERE nombre LIKE 'J%';

-- Buscar nombres que contengan 'a'
SELECT * FROM estudiantes WHERE nombre LIKE '%a%';

-- Buscar nombres que terminen con 'ez'
SELECT * FROM estudiantes WHERE nombre LIKE '%ez';

-- Buscar nombres con exactamente 10 caracteres
SELECT * FROM estudiantes WHERE nombre LIKE '__________';  -- 10 guiones bajos

-- ============================================
-- OPERADOR BETWEEN
-- ============================================

-- Buscar edades entre 20 y 22 (inclusive)
SELECT * FROM estudiantes WHERE edad BETWEEN 20 AND 22;

-- Buscar notas entre 7.0 y 8.5
SELECT * FROM estudiantes WHERE nota BETWEEN 7.0 AND 8.5;

-- ============================================
-- VALORES NULL
-- ============================================

-- Buscar registros donde un campo es NULL
-- SELECT * FROM estudiantes WHERE email IS NULL;

-- Buscar registros donde un campo NO es NULL
-- SELECT * FROM estudiantes WHERE email IS NOT NULL;

-- ============================================
-- PRÁCTICA
-- ============================================
-- 1. Muestra los estudiantes que tienen más de 20 años
-- 2. Muestra los estudiantes de Madrid que tienen nota mayor o igual a 8.0
-- 3. Muestra los estudiantes cuyo nombre empiece con 'A'
-- 4. Muestra los estudiantes con nota entre 7.0 y 8.5
-- 5. Muestra los estudiantes que NO son de Madrid ni de Barcelona

-- ============================================
-- SOLUCIÓN ESPERADA
-- ============================================
/*
-- 1.
SELECT * FROM estudiantes WHERE edad > 20;

-- 2.
SELECT * FROM estudiantes WHERE ciudad = 'Madrid' AND nota >= 8.0;

-- 3.
SELECT * FROM estudiantes WHERE nombre LIKE 'A%';

-- 4.
SELECT * FROM estudiantes WHERE nota BETWEEN 7.0 AND 8.5;

-- 5.
SELECT * FROM estudiantes WHERE ciudad NOT IN ('Madrid', 'Barcelona');
-- O también:
SELECT * FROM estudiantes WHERE ciudad != 'Madrid' AND ciudad != 'Barcelona';
*/

