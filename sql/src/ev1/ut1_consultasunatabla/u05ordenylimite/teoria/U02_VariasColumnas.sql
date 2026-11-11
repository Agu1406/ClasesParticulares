/*
OBJETIVO: Desempatar ordenando por varias columnas.
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
*/

USE tienda;

-- =============================================================================
-- Varias columnas: primera clave de orden, luego desempate
-- =============================================================================

SELECT nombre, categoria, precio
FROM productos
ORDER BY categoria ASC, precio DESC;

-- Primero agrupa visualmente por categoria; dentro, los mas caros primero.

SELECT ciudad, nombre, apellidos
FROM clientes
ORDER BY ciudad, apellidos;

-- Prueba tu: productos ORDER BY stock ASC, nombre ASC.
