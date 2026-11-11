/*
OBJETIVO: LEFT JOIN clientes-pedidos.
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
*/

USE tienda;

-- ENUNCIADO: LEFT JOIN clientes-pedidos.
SELECT c.nombre, p.id_pedido, p.estado
FROM clientes c
LEFT JOIN pedidos p ON p.id_cliente = c.id_cliente;
