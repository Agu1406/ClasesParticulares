/*
OBJETIVO: Combinar dos tablas con INNER JOIN ... ON.
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
*/

USE tienda;

-- INNER JOIN: solo filas con pareja en ambas tablas.

SELECT c.nombre, c.apellidos, p.id_pedido, p.fecha_pedido, p.estado
FROM clientes c
INNER JOIN pedidos p ON p.id_cliente = c.id_cliente;

-- Equivalente antiguo (menos claro): FROM clientes c, pedidos p WHERE ...

-- Alias de tabla (c, p) acortan y evitan ambiguedad de columnas.
