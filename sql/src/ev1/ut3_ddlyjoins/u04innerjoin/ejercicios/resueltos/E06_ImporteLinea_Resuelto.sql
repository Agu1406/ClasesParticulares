/*
OBJETIVO: nombre producto, cantidad, precio, importe (=cantidad*precio).
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
*/

USE tienda;

-- ENUNCIADO: nombre producto, cantidad, precio, importe (=cantidad*precio).
SELECT pr.nombre, p.cantidad, pr.precio,
       p.cantidad * pr.precio AS importe
FROM pedidos p
INNER JOIN productos pr ON pr.id_producto = p.id_producto;
