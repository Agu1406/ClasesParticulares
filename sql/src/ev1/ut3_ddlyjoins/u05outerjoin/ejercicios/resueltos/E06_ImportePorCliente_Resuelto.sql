/*
OBJETIVO: Importe total (cantidad*precio) por cliente.
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
*/

USE tienda;

-- ENUNCIADO: Importe total (cantidad*precio) por cliente.
SELECT c.nombre, SUM(p.cantidad * pr.precio) AS importe
FROM pedidos p
INNER JOIN clientes c ON c.id_cliente = p.id_cliente
INNER JOIN productos pr ON pr.id_producto = p.id_producto
GROUP BY c.id_cliente, c.nombre
ORDER BY importe DESC;
