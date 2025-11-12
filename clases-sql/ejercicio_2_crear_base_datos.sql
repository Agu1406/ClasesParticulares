-- ============================================
-- EJERCICIO 2: Crear y Gestionar Bases de Datos
-- ============================================
-- En este ejercicio aprenderás a crear, usar y eliminar bases de datos.

-- ============================================
-- CREAR UNA BASE DE DATOS
-- ============================================

-- Crear una base de datos llamada "tienda"
CREATE DATABASE tienda;

-- Crear una base de datos con codificación UTF-8 (recomendado)
CREATE DATABASE tienda_utf8
CHARACTER SET utf8mb4
COLLATE utf8mb4_unicode_ci;

-- Crear una base de datos solo si no existe (evita errores)
CREATE DATABASE IF NOT EXISTS escuela;

-- ============================================
-- SELECCIONAR UNA BASE DE DATOS
-- ============================================

-- Seleccionar la base de datos "tienda" para trabajar con ella
USE tienda;

-- Verificar qué base de datos estás usando
SELECT DATABASE();

-- ============================================
-- VER INFORMACIÓN DE UNA BASE DE DATOS
-- ============================================

-- Ver todas las bases de datos
SHOW DATABASES;

-- Ver cómo se creó una base de datos específica
SHOW CREATE DATABASE tienda;

-- ============================================
-- ELIMINAR UNA BASE DE DATOS
-- ============================================

-- ⚠️ CUIDADO: Esto elimina TODA la base de datos y sus datos
-- Eliminar una base de datos
-- DROP DATABASE tienda;

-- Eliminar solo si existe (evita errores)
-- DROP DATABASE IF EXISTS tienda;

-- ============================================
-- PRÁCTICA
-- ============================================
-- 1. Crea una base de datos llamada "mi_primera_bd"
-- 2. Selecciónala usando USE
-- 3. Verifica que estás usando la base de datos correcta
-- 4. Crea otra base de datos llamada "practica" con codificación UTF-8
-- 5. Cambia entre las dos bases de datos usando USE
-- 6. Lista todas las bases de datos para ver las que creaste

-- ============================================
-- SOLUCIÓN ESPERADA
-- ============================================
/*
CREATE DATABASE mi_primera_bd;
USE mi_primera_bd;
SELECT DATABASE();

CREATE DATABASE practica
CHARACTER SET utf8mb4
COLLATE utf8mb4_unicode_ci;

USE practica;
SELECT DATABASE();

USE mi_primera_bd;
SHOW DATABASES;
*/

