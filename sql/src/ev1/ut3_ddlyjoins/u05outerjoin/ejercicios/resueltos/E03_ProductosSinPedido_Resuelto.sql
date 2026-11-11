/*
OBJETIVO: Productos que nunca salieron en pedidos.
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
*/

USE tienda;

-- ENUNCIADO: Productos que nunca salieron en pedidos.
SELECT pr.nombre
FROM productos pr
LEFT JOIN pedidos p ON p.id_producto = pr.id_producto
WHERE p.id_pedido IS NULL;
