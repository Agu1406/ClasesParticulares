/*
OBJETIVO: Conectar a MySQL/MariaDB, seleccionar tienda e inspeccionar el esquema.
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
*/

USE tienda;

-- =============================================================================
-- Ritual de arranque de clase
-- =============================================================================
-- 1) Tener cargado el script: src/ev1/ut1_consultasunatabla/_bd/tienda.sql
--    mysql -u root -p < tienda.sql
-- 2) Abrir el cliente (Workbench, DBeaver, CLI, extension VS Code...)
-- 3) Ejecutar en orden:

USE tienda;          -- entrar en la base de datos de practica
SHOW TABLES;         -- debe listar: clientes, productos, pedidos
DESCRIBE productos;  -- columnas y tipos de una tabla
DESCRIBE clientes;
DESCRIBE pedidos;

-- Conteo rapido para comprobar que hay datos:
SELECT COUNT(*) AS cuantos_productos FROM productos;
SELECT COUNT(*) AS cuantos_clientes FROM clientes;

-- =============================================================================
-- Errores tipicos
-- =============================================================================
-- - ERROR 1049: Unknown database 'tienda'  -> no has ejecutado tienda.sql
-- - Olvidar USE tienda  -> las tablas "no existen" en la BD por defecto
-- - Conectarte a otro puerto/servidor sin darte cuenta

-- Prueba tu: DESCRIBE pedidos; y lee en voz alta clave primaria y foraneas.
