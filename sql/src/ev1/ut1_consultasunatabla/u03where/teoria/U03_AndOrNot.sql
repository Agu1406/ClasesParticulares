/*
OBJETIVO: Combinar condiciones con AND, OR y NOT.
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
*/

USE tienda;

-- =============================================================================
-- AND: las dos (o mas) deben cumplirse
-- OR:  basta con una
-- NOT: niega una condicion
-- =============================================================================

SELECT nombre, precio, stock
FROM productos
WHERE precio < 50 AND stock > 20;

SELECT nombre, ciudad
FROM clientes
WHERE ciudad = 'Madrid' OR ciudad = 'Barcelona';

SELECT nombre, apellidos
FROM clientes
WHERE activo = 1;

SELECT nombre FROM clientes WHERE NOT (activo = 0);
-- Equivalente practico: WHERE activo = 1

-- Errores tipicos:
-- - WHERE ciudad = 'Madrid' OR 'Barcelona';  -- INVALIDO
-- - Mezclar AND/OR sin parentesis (ver U04)

-- Prueba tu: productos categoria 'Cables' AND precio < 20.
