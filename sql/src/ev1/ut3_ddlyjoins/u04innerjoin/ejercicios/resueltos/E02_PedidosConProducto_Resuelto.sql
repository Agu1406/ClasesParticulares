/*
OBJETIVO: Pedidos con nombre del producto.
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
*/

USE tienda;

-- ENUNCIADO: Pedidos con nombre del producto.
SELECT p.id_pedido, pr.nombre AS producto, p.cantidad
FROM pedidos p
INNER JOIN productos pr ON pr.id_producto = p.id_producto;
