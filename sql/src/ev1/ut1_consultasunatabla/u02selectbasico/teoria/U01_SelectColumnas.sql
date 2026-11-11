/*
OBJETIVO: Pedir columnas concretas con SELECT ... FROM y leer el resultado fila a fila.
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
*/

USE tienda;

-- =============================================================================
-- Forma base
-- =============================================================================
-- SELECT columna1, columna2, ...
-- FROM tabla;

-- Cada fila del resultado es un registro.
-- Cada columna del resultado es un campo que has pedido.

SELECT nombre, precio
FROM productos;

SELECT nombre, apellidos, ciudad
FROM clientes;

-- El orden de las columnas en el SELECT es el orden en el que aparecen.
SELECT precio, nombre
FROM productos;

-- =============================================================================
-- Errores tipicos
-- =============================================================================
-- - SELECT nombre FROM producto;   -- tabla mal escrita (singular)
-- - SELECT Nombre FROM productos;  -- en MySQL suele ir, pero seamos consistentes: minusculas
-- - Pedir email FROM productos;    -- esa columna no existe ahi

-- Prueba tu: pide id_producto, categoria y stock de productos.
