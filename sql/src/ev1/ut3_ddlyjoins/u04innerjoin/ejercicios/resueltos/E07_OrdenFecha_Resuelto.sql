/*
OBJETIVO: JOIN cliente-pedido ORDER BY fecha DESC.
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
*/

USE tienda;

-- ENUNCIADO: JOIN cliente-pedido ORDER BY fecha DESC.
SELECT p.fecha_pedido, c.nombre, p.estado
FROM pedidos p
INNER JOIN clientes c ON c.id_cliente = p.id_cliente
ORDER BY p.fecha_pedido DESC;
