/*
OBJETIVO: cliente, producto, cantidad, estado.
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
*/

USE tienda;

-- ENUNCIADO: cliente, producto, cantidad, estado.
SELECT c.nombre, pr.nombre AS producto, p.cantidad, p.estado
FROM pedidos p
INNER JOIN clientes c ON c.id_cliente = p.id_cliente
INNER JOIN productos pr ON pr.id_producto = p.id_producto;
