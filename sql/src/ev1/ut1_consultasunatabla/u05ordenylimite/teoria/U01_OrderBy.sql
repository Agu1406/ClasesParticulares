/*
OBJETIVO: Ordenar el resultado con ORDER BY ASC o DESC.
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
*/

USE tienda;

-- =============================================================================
-- ORDER BY: orden del resultado
-- =============================================================================
-- No garantiza orden si no lo pides. Si lo necesitas, ORDER BY.

SELECT nombre, precio
FROM productos
ORDER BY precio ASC;   -- de menor a mayor (ASC es el default)

SELECT nombre, precio
FROM productos
ORDER BY precio DESC;  -- de mayor a menor

SELECT nombre, apellidos
FROM clientes
ORDER BY apellidos;

-- ORDER BY va al FINAL de la consulta (en UT1: SELECT FROM WHERE ORDER BY).

-- Prueba tu: pedidos ORDER BY fecha_pedido DESC.
