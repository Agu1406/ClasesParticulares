/*
OBJETIVO: Solucion top N u05.
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
*/

USE tienda;

SELECT nombre, precio FROM productos ORDER BY precio DESC LIMIT 4;
SELECT ciudad, nombre, apellidos FROM clientes ORDER BY ciudad, apellidos;
SELECT nombre, precio FROM productos ORDER BY nombre LIMIT 4 OFFSET 4;
SELECT nombre, stock FROM productos ORDER BY stock DESC LIMIT 5;
SELECT id_pedido, fecha_pedido, estado FROM pedidos ORDER BY fecha_pedido DESC LIMIT 3;
