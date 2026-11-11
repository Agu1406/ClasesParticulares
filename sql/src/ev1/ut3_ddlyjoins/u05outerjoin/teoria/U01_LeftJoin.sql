/*
OBJETIVO: Conservar filas sin pareja con LEFT JOIN.
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
*/

USE tienda;

-- LEFT JOIN: todas las filas de la izquierda + pareja si existe (si no, NULL).

-- Clientes aunque no tengan pedidos:
SELECT c.id_cliente, c.nombre, p.id_pedido, p.estado
FROM clientes c
LEFT JOIN pedidos p ON p.id_cliente = c.id_cliente;

-- Clientes SIN pedidos:
SELECT c.id_cliente, c.nombre
FROM clientes c
LEFT JOIN pedidos p ON p.id_cliente = c.id_cliente
WHERE p.id_pedido IS NULL;
