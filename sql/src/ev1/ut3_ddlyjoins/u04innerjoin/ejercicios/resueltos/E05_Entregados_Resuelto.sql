/*
OBJETIVO: JOIN tres tablas solo estado entregado.
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
*/

USE tienda;

-- ENUNCIADO: JOIN tres tablas solo estado entregado.
SELECT c.nombre, pr.nombre, p.fecha_pedido
FROM pedidos p
INNER JOIN clientes c ON c.id_cliente = p.id_cliente
INNER JOIN productos pr ON pr.id_producto = p.id_producto
WHERE p.estado = 'entregado';
