/*
OBJETIVO: Resumir despues de juntar tablas (JOIN + GROUP BY).
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
*/

USE tienda;

SELECT c.nombre, COUNT(p.id_pedido) AS num_pedidos
FROM clientes c
LEFT JOIN pedidos p ON p.id_cliente = c.id_cliente
GROUP BY c.id_cliente, c.nombre
ORDER BY num_pedidos DESC;

SELECT pr.categoria, SUM(p.cantidad) AS uds_vendidas
FROM pedidos p
INNER JOIN productos pr ON pr.id_producto = p.id_producto
GROUP BY pr.categoria;
