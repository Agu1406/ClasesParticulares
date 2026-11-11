/*
OBJETIVO: Solucion catalogo u02.
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
*/

USE tienda;

SELECT nombre AS producto, categoria, precio AS precio_euros
FROM productos;

SELECT DISTINCT categoria FROM productos;

SELECT nombre, ROUND(precio * 1.21, 2) AS precio_con_iva
FROM productos;

SELECT DISTINCT estado FROM pedidos;

SELECT CONCAT(nombre, ' ', apellidos) AS nombre_completo
FROM clientes;
