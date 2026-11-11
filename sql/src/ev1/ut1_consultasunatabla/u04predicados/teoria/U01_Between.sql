/*
OBJETIVO: Filtrar rangos inclusivos con BETWEEN ... AND ...
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
*/

USE tienda;

-- =============================================================================
-- BETWEEN: desde X hasta Y (INCLUSIVE)
-- =============================================================================
-- precio BETWEEN 30 AND 100  <=>  precio >= 30 AND precio <= 100

SELECT nombre, precio
FROM productos
WHERE precio BETWEEN 30 AND 100;

SELECT nombre, fecha_alta
FROM clientes
WHERE fecha_alta BETWEEN '2024-01-01' AND '2024-12-31';

-- NOT BETWEEN tambien existe.

-- Errores tipicos:
-- - Creer que el extremo superior no entra (SI entra)
-- - Invertir extremos: BETWEEN 100 AND 30 -> resultado vacio

-- Prueba tu: stock BETWEEN 10 AND 30.
