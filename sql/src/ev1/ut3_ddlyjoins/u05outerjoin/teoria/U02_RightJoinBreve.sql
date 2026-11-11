/*
OBJETIVO: Mencionar RIGHT JOIN como espejo de LEFT JOIN.
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
*/

USE tienda;

-- RIGHT JOIN: conserva la derecha. En clase preferimos LEFT y cambiamos el orden.

SELECT pr.nombre, p.id_pedido
FROM pedidos p
RIGHT JOIN productos pr ON pr.id_producto = p.id_producto;

-- Equivalente mas legible:
SELECT pr.nombre, p.id_pedido
FROM productos pr
LEFT JOIN pedidos p ON p.id_producto = pr.id_producto;
