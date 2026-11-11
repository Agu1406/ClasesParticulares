/*
OBJETIVO: Solucion outer join.
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
*/

USE tienda;

SELECT c.nombre, p.id_pedido, p.estado
FROM clientes c
LEFT JOIN pedidos p ON p.id_cliente = c.id_cliente;

SELECT c.nombre
FROM clientes c
LEFT JOIN pedidos p ON p.id_cliente = c.id_cliente
WHERE p.id_pedido IS NULL;

SELECT c.nombre, COUNT(p.id_pedido) AS n
FROM clientes c
LEFT JOIN pedidos p ON p.id_cliente = c.id_cliente
GROUP BY c.id_cliente, c.nombre;

SELECT pr.categoria, SUM(p.cantidad * pr.precio) AS importe
FROM pedidos p
INNER JOIN productos pr ON pr.id_producto = p.id_producto
GROUP BY pr.categoria;
