-- ============================================
-- EJERCICIO 9: Eliminar Datos (DELETE)
-- ============================================
-- En este ejercicio aprenderás a eliminar registros de las tablas.

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

-- Ver los datos antes de eliminar
SELECT * FROM estudiantes;

-- ============================================
-- ELIMINAR UN REGISTRO ESPECÍFICO
-- ============================================

-- Eliminar un estudiante por su ID
DELETE FROM estudiantes WHERE id = 4;

-- Verificar que se eliminó
SELECT * FROM estudiantes;

-- ============================================
-- ELIMINAR MÚLTIPLES REGISTROS
-- ============================================

-- Eliminar todos los estudiantes de una ciudad específica
DELETE FROM estudiantes WHERE ciudad = 'Sevilla';

-- Verificar los cambios
SELECT * FROM estudiantes;

-- ============================================
-- ELIMINAR CON CONDICIONES COMPLEJAS
-- ============================================

-- Eliminar estudiantes con nota menor a 7.0
DELETE FROM estudiantes WHERE nota < 7.0;

-- Eliminar estudiantes mayores de 22 años
DELETE FROM estudiantes WHERE edad > 22;

-- Eliminar estudiantes que cumplan múltiples condiciones
DELETE FROM estudiantes 
WHERE ciudad = 'Madrid' AND nota < 8.0;

-- ============================================
-- ⚠️ CUIDADO: ELIMINAR TODOS LOS REGISTROS
-- ============================================

-- ⚠️ ESTO ELIMINARÁ TODOS LOS REGISTROS DE LA TABLA
-- DELETE FROM estudiantes;
-- NUNCA ejecutes DELETE sin WHERE a menos que sea intencional

-- ============================================
-- VERIFICAR ANTES DE ELIMINAR
-- ============================================

-- Siempre es buena práctica ver qué se va a eliminar primero
-- Ver qué registros se van a eliminar
SELECT * FROM estudiantes WHERE ciudad = 'Barcelona';

-- Luego ejecutar el DELETE
-- DELETE FROM estudiantes WHERE ciudad = 'Barcelona';

-- ============================================
-- TRUNCATE TABLE (Alternativa a DELETE)
-- ============================================

-- TRUNCATE elimina todos los registros de una tabla más rápido que DELETE
-- ⚠️ CUIDADO: Esto elimina TODOS los datos de la tabla
-- TRUNCATE TABLE estudiantes;

-- Diferencias entre DELETE y TRUNCATE:
-- - DELETE puede usar WHERE, TRUNCATE no
-- - DELETE es más lento, TRUNCATE es más rápido
-- - DELETE se puede revertir (con transacciones), TRUNCATE no
-- - TRUNCATE reinicia los contadores AUTO_INCREMENT

-- ============================================
-- ELIMINAR TABLA COMPLETA
-- ============================================

-- Eliminar toda la tabla (estructura y datos)
-- DROP TABLE estudiantes;

-- Eliminar solo si existe
-- DROP TABLE IF EXISTS estudiantes;

-- ============================================
-- PRÁCTICA
-- ============================================
-- 1. Antes de eliminar, muestra los estudiantes de Madrid
-- 2. Elimina el estudiante con id = 3
-- 3. Elimina todos los estudiantes menores de 20 años
-- 4. Verifica cuántos estudiantes quedan en la tabla
-- 5. Muestra los estudiantes restantes ordenados por nombre

-- ============================================
-- SOLUCIÓN ESPERADA
-- ============================================
/*
-- 1.
SELECT * FROM estudiantes WHERE ciudad = 'Madrid';

-- 2.
DELETE FROM estudiantes WHERE id = 3;

-- 3.
-- Primero verificar:
SELECT * FROM estudiantes WHERE edad < 20;
-- Luego eliminar:
DELETE FROM estudiantes WHERE edad < 20;

-- 4.
SELECT COUNT(*) AS total_estudiantes FROM estudiantes;

-- 5.
SELECT * FROM estudiantes ORDER BY nombre;
*/

