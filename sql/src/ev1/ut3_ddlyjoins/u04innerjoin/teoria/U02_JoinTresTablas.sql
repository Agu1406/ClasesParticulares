/*
OBJETIVO: Encadenar JOIN a tres tablas (cliente-pedido-producto).
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
       p.estado,
       p.fecha_pedido
FROM pedidos p
INNER JOIN clientes c ON c.id_cliente = p.id_cliente
INNER JOIN productos pr ON pr.id_producto = p.id_producto;

-- Orden de JOINs: suele ir de la tabla 'puente' (pedidos) hacia fuera.
