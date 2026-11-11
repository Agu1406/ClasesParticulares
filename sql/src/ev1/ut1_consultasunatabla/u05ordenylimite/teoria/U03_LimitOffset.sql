/*
OBJETIVO: Cortar el resultado con LIMIT y paginar con OFFSET.
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
*/

USE tienda;

-- =============================================================================
-- LIMIT: quedarte con N filas
-- OFFSET: saltar M filas (paginacion)
-- =============================================================================

-- Top 5 mas caros:
SELECT nombre, precio
FROM productos
ORDER BY precio DESC
LIMIT 5;

-- Saltar 2 y coger 3:
SELECT nombre, precio
FROM productos
ORDER BY precio DESC
LIMIT 3 OFFSET 2;

-- Sintaxis corta MySQL: LIMIT offset, count
SELECT nombre, precio
FROM productos
ORDER BY precio DESC
LIMIT 2, 3;

-- IMPORTANTE: LIMIT sin ORDER BY -> que filas salen es indefinido. Ordena siempre.

-- Prueba tu: top 3 clientes por fecha_alta DESC (los mas recientes).
