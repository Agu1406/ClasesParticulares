/*
OBJETIVO: Inspeccionar tablas existentes con SHOW y DESCRIBE.
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
*/

USE tienda;

SHOW TABLES;
DESCRIBE clientes;
DESCRIBE productos;
DESCRIBE pedidos;

-- Columnas de information_schema (opcional):
SELECT TABLE_NAME, COLUMN_NAME, DATA_TYPE, IS_NULLABLE, COLUMN_KEY
FROM information_schema.COLUMNS
WHERE TABLE_SCHEMA = 'tienda'
ORDER BY TABLE_NAME, ORDINAL_POSITION;

-- Prueba tu: DESCRIBE pedidos; identifica las FK (COLUMN_KEY = MUL).
