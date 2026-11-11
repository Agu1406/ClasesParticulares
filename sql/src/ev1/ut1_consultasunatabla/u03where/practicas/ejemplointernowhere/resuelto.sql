/*
OBJETIVO: Solucion filtros u03.
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
*/

USE tienda;

SELECT nombre, precio FROM productos
WHERE categoria = 'Mobiliario' AND precio >= 20;

SELECT nombre, apellidos, ciudad FROM clientes
WHERE activo = 1 AND ciudad = 'Madrid';

SELECT id_pedido, estado FROM pedidos
WHERE estado = 'enviado' OR estado = 'entregado';

SELECT nombre, stock, precio FROM productos
WHERE stock <= 15 AND precio > 40;

SELECT nombre, ciudad, activo FROM clientes
WHERE (ciudad = 'Barcelona' AND activo = 1) OR ciudad = 'Bilbao';
