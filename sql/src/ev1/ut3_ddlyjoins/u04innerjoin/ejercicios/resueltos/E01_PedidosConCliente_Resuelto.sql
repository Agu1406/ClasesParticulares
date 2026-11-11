/*
OBJETIVO: Pedidos con nombre del cliente.
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
*/

USE tienda;

-- ENUNCIADO: Pedidos con nombre del cliente.
SELECT p.id_pedido, c.nombre, c.apellidos, p.estado
FROM pedidos p
INNER JOIN clientes c ON c.id_cliente = p.id_cliente;
