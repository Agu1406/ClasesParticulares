-- ============================================
-- EJERCICIO 8: Actualizar Datos (UPDATE)
-- ============================================
-- En este ejercicio aprenderás a modificar datos existentes en las tablas.

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

-- Ver los datos antes de actualizar
SELECT * FROM estudiantes;

-- ============================================
-- ACTUALIZAR UN REGISTRO ESPECÍFICO
-- ============================================

-- Actualizar la edad de Juan Pérez
UPDATE estudiantes 
SET edad = 21 
WHERE id = 1;

-- Verificar el cambio
SELECT * FROM estudiantes WHERE id = 1;

-- ============================================
-- ACTUALIZAR MÚLTIPLES COLUMNAS
-- ============================================

-- Actualizar ciudad y nota de un estudiante
UPDATE estudiantes 
SET ciudad = 'Bilbao', nota = 8.8 
WHERE id = 3;

-- Verificar el cambio
SELECT * FROM estudiantes WHERE id = 3;

-- ============================================
-- ACTUALIZAR MÚLTIPLES REGISTROS
-- ============================================

-- Actualizar la ciudad de todos los estudiantes de Madrid a 'Madrid Capital'
UPDATE estudiantes 
SET ciudad = 'Madrid Capital' 
WHERE ciudad = 'Madrid';

-- Ver todos los cambios
SELECT * FROM estudiantes;

-- ============================================
-- ACTUALIZAR CON OPERACIONES MATEMÁTICAS
-- ============================================

-- Incrementar la edad de todos los estudiantes en 1 año
UPDATE estudiantes 
SET edad = edad + 1;

-- Aumentar la nota en 0.5 puntos a estudiantes con nota menor a 8.0
UPDATE estudiantes 
SET nota = nota + 0.5 
WHERE nota < 8.0;

-- Ver los cambios
SELECT * FROM estudiantes;

-- ============================================
-- ACTUALIZAR CON CONDICIONES COMPLEJAS
-- ============================================

-- Actualizar email de estudiantes mayores de 21 años
UPDATE estudiantes 
SET email = CONCAT(nombre, '@nuevoemail.com') 
WHERE edad > 21;

-- Actualizar nota de estudiantes de Madrid con nota menor a 8.0
UPDATE estudiantes 
SET nota = 8.0 
WHERE ciudad LIKE '%Madrid%' AND nota < 8.0;

-- ============================================
-- ⚠️ CUIDADO: ACTUALIZAR SIN WHERE
-- ============================================

-- ⚠️ ESTO ACTUALIZARÁ TODOS LOS REGISTROS DE LA TABLA
-- UPDATE estudiantes SET ciudad = 'Desconocida';
-- NUNCA ejecutes UPDATE sin WHERE a menos que sea intencional

-- ============================================
-- VERIFICAR ANTES DE ACTUALIZAR
-- ============================================

-- Siempre es buena práctica ver qué se va a actualizar primero
-- Ver qué registros se van a actualizar
SELECT * FROM estudiantes WHERE ciudad = 'Madrid';

-- Luego ejecutar el UPDATE
-- UPDATE estudiantes SET ciudad = 'Madrid Capital' WHERE ciudad = 'Madrid';

-- ============================================
-- PRÁCTICA
-- ============================================
-- 1. Actualiza la edad de María García a 23 años
-- 2. Actualiza la ciudad y nota de Ana Martínez (ciudad: 'Alicante', nota: 7.0)
-- 3. Incrementa en 1 punto la nota de todos los estudiantes con nota menor a 8.0
-- 4. Cambia la ciudad de todos los estudiantes de 'Sevilla' a 'Sevilla Capital'
-- 5. Antes de actualizar, verifica qué registros se van a modificar

-- ============================================
-- SOLUCIÓN ESPERADA
-- ============================================
/*
-- 1.
UPDATE estudiantes SET edad = 23 WHERE nombre = 'María García';

-- 2.
UPDATE estudiantes 
SET ciudad = 'Alicante', nota = 7.0 
WHERE nombre = 'Ana Martínez';

-- 3.
-- Primero verificar:
SELECT * FROM estudiantes WHERE nota < 8.0;
-- Luego actualizar:
UPDATE estudiantes SET nota = nota + 1.0 WHERE nota < 8.0;

-- 4.
-- Primero verificar:
SELECT * FROM estudiantes WHERE ciudad = 'Sevilla';
-- Luego actualizar:
UPDATE estudiantes SET ciudad = 'Sevilla Capital' WHERE ciudad = 'Sevilla';

-- Verificar todos los cambios:
SELECT * FROM estudiantes;
*/

