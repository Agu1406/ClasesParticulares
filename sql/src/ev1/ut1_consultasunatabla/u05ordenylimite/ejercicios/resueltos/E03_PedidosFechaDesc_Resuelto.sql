/*
OBJETIVO: Pedidos ordenados por fecha_pedido DESC.
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
*/

USE tienda;

-- ENUNCIADO: Pedidos ordenados por fecha_pedido DESC.
SELECT id_pedido, fecha_pedido, estado
FROM pedidos
ORDER BY fecha_pedido DESC;
