-- ============================================
-- EJERCICIO 1: Introducción a MySQL
-- ============================================
-- En este ejercicio aprenderás los conceptos básicos de MySQL
-- y cómo conectarte a un servidor MySQL.

-- ============================================
-- CONCEPTOS BÁSICOS
-- ============================================
-- MySQL es un sistema de gestión de bases de datos relacionales (SGBDR)
-- - Una BASE DE DATOS es un contenedor que agrupa tablas relacionadas
-- - Una TABLA es una estructura que organiza datos en filas y columnas
-- - Una FILA (registro) representa un dato completo
-- - Una COLUMNA (campo) representa un atributo del dato

-- ============================================
-- CONECTARSE A MYSQL
-- ============================================
-- Para conectarte a MySQL desde la línea de comandos:
-- mysql -u root -p
-- (te pedirá la contraseña)

-- O desde MySQL Workbench:
-- 1. Abre MySQL Workbench
-- 2. Crea una nueva conexión
-- 3. Ingresa: host (localhost), puerto (3306), usuario (root), contraseña

-- ============================================
-- COMANDOS BÁSICOS DE NAVEGACIÓN
-- ============================================

-- Ver todas las bases de datos disponibles
SHOW DATABASES;

-- Ver la base de datos actual que estás usando
SELECT DATABASE();

-- Ver la versión de MySQL que estás usando
SELECT VERSION();

-- Ver el usuario actual
SELECT USER();

-- ============================================
-- PRÁCTICA
-- ============================================
-- 1. Ejecuta cada uno de los comandos SHOW y SELECT anteriores
-- 2. Observa qué bases de datos existen en tu servidor
-- 3. Anota la versión de MySQL que estás usando
-- 4. Verifica qué usuario estás usando

-- ============================================
-- NOTAS IMPORTANTES
-- ============================================
-- - Los comandos SQL pueden escribirse en mayúsculas o minúsculas
-- - Es una buena práctica usar mayúsculas para palabras clave (SHOW, SELECT, etc.)
-- - Los comentarios de una línea empiezan con --
-- - Los comentarios de múltiples líneas usan /* ... */
-- - Cada comando SQL termina con punto y coma (;)

