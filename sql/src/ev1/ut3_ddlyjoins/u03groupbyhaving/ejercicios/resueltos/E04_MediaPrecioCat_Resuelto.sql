/*
OBJETIVO: Media de precio por categoria (ROUND 2).
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
*/

USE tienda;

-- ENUNCIADO: Media de precio por categoria (ROUND 2).
SELECT categoria, ROUND(AVG(precio), 2) AS media
FROM productos
GROUP BY categoria;
