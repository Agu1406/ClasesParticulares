/*
OBJETIVO: Suma cantidades por categoria (INNER).
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
*/

USE tienda;

-- ENUNCIADO: Suma cantidades por categoria (INNER).
SELECT pr.categoria, SUM(p.cantidad) AS uds
FROM pedidos p
INNER JOIN productos pr ON pr.id_producto = p.id_producto
GROUP BY pr.categoria;
