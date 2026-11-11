/*
OBJETIVO: Solucion inner join tienda.
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
*/

USE tienda;

SELECT c.nombre AS cliente,
       pr.nombre AS producto,
       p.cantidad,
       p.cantidad * pr.precio AS importe,
       p.estado
FROM pedidos p
INNER JOIN clientes c ON c.id_cliente = p.id_cliente
INNER JOIN productos pr ON pr.id_producto = p.id_producto;

SELECT c.nombre, pr.nombre, p.cantidad
FROM pedidos p
INNER JOIN clientes c ON c.id_cliente = p.id_cliente
INNER JOIN productos pr ON pr.id_producto = p.id_producto
WHERE p.estado = 'pendiente';

SELECT c.nombre, pr.nombre, p.cantidad
FROM pedidos p
INNER JOIN clientes c ON c.id_cliente = p.id_cliente
INNER JOIN productos pr ON pr.id_producto = p.id_producto
WHERE c.ciudad = 'Barcelona';

SELECT c.nombre, pr.nombre, p.cantidad * pr.precio AS importe
FROM pedidos p
INNER JOIN clientes c ON c.id_cliente = p.id_cliente
INNER JOIN productos pr ON pr.id_producto = p.id_producto
ORDER BY importe DESC;
