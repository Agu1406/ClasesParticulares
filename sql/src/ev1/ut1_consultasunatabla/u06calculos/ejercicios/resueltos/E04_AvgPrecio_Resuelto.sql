/*
OBJETIVO: Media de precios de productos (ROUND 2 decimales).
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
*/

USE tienda;

-- ENUNCIADO: Media de precios de productos (ROUND 2 decimales).
SELECT ROUND(AVG(precio), 2) AS precio_medio
FROM productos;
