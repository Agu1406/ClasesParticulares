/*
OBJETIVO: Pedidos cuyo estado no es cancelado.
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
*/

USE tienda;

-- ENUNCIADO: Pedidos cuyo estado no es cancelado.
SELECT id_pedido, estado
FROM pedidos
WHERE estado <> 'cancelado';
