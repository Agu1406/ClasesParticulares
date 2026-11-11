/*
OBJETIVO: Filtrar filas con WHERE: quedarte solo con las que cumplen una condicion.
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
*/

USE tienda;

-- =============================================================================
-- WHERE: filtro de filas
-- =============================================================================
-- SELECT ... FROM ... WHERE condicion;
-- Se evalua DESPUES de localizar la tabla y ANTES de devolver el resultado.

SELECT nombre, precio
FROM productos
WHERE precio > 50;

SELECT nombre, apellidos, ciudad
FROM clientes
WHERE ciudad = 'Madrid';

-- Sin WHERE: todas las filas. Con WHERE: solo las que cumplen.

-- Orden mental (simplificado UT1):
-- FROM -> WHERE -> SELECT

-- Prueba tu: productos con stock = 0 (si no hay, prueba stock < 10).
