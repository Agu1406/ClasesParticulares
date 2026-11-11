/*
OBJETIVO: Cuantos pedidos tiene cada cliente (incluye 0).
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
*/

USE tienda;

-- ENUNCIADO: Cuantos pedidos tiene cada cliente (incluye 0).
SELECT c.nombre, COUNT(p.id_pedido) AS n
FROM clientes c
LEFT JOIN pedidos p ON p.id_cliente = c.id_cliente
GROUP BY c.id_cliente, c.nombre;
