/*
OBJETIVO: Filtrar y ordenar sobre un JOIN.
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
*/

USE tienda;

SELECT c.ciudad, pr.nombre, p.cantidad, p.estado
FROM pedidos p
INNER JOIN clientes c ON c.id_cliente = p.id_cliente
INNER JOIN productos pr ON pr.id_producto = p.id_producto
WHERE c.ciudad = 'Madrid'
ORDER BY p.fecha_pedido DESC;

SELECT pr.categoria, pr.nombre, c.nombre AS cliente
FROM pedidos p
INNER JOIN productos pr ON pr.id_producto = p.id_producto
INNER JOIN clientes c ON c.id_cliente = p.id_cliente
WHERE p.estado = 'entregado';
