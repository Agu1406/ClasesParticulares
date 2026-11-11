/*
OBJETIVO: Pedidos con estado = pendiente.
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
*/

USE tienda;

-- ENUNCIADO: Pedidos con estado = pendiente.
SELECT id_pedido, cantidad, fecha_pedido
FROM pedidos
WHERE estado = 'pendiente';
