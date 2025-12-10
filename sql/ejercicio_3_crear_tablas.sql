-- ============================================
-- EJERCICIO 3: Crear Tablas
-- ============================================
-- En este ejercicio aprenderás a crear tablas en MySQL.

-- ============================================
-- PREPARACIÓN
-- ============================================
-- Primero, crea y selecciona una base de datos para trabajar
CREATE DATABASE IF NOT EXISTS escuela;
USE escuela;

-- ============================================
-- CREAR UNA TABLA BÁSICA
-- ============================================

-- Crear una tabla simple llamada "estudiantes"
CREATE TABLE estudiantes (
    id INT,
    nombre VARCHAR(50),
    edad INT
);

-- ============================================
-- VER TABLAS EN UNA BASE DE DATOS
-- ============================================

-- Ver todas las tablas en la base de datos actual
SHOW TABLES;

-- Ver la estructura de una tabla (columnas y tipos)
DESCRIBE estudiantes;
-- O también puedes usar:
DESC estudiantes;

-- Ver cómo se creó la tabla (comando completo)
SHOW CREATE TABLE estudiantes;

-- ============================================
-- ELIMINAR UNA TABLA
-- ============================================

-- ⚠️ CUIDADO: Esto elimina la tabla y todos sus datos
-- Eliminar una tabla
-- DROP TABLE estudiantes;

-- Eliminar solo si existe
-- DROP TABLE IF EXISTS estudiantes;

-- ============================================
-- PRÁCTICA
-- ============================================
-- 1. Crea una tabla llamada "productos" con las columnas:
--    - id (número entero)
--    - nombre (texto, máximo 100 caracteres)
--    - precio (número decimal)
-- 2. Verifica que la tabla se creó correctamente usando SHOW TABLES
-- 3. Revisa la estructura de la tabla usando DESCRIBE
-- 4. Crea otra tabla llamada "clientes" con:
--    - id (número entero)
--    - nombre (texto, máximo 80 caracteres)
--    - email (texto, máximo 150 caracteres)

-- ============================================
-- SOLUCIÓN ESPERADA
-- ============================================
/*
CREATE TABLE productos (
    id INT,
    nombre VARCHAR(100),
    precio DECIMAL(10, 2)
);

SHOW TABLES;
DESCRIBE productos;

CREATE TABLE clientes (
    id INT,
    nombre VARCHAR(80),
    email VARCHAR(150)
);
*/

