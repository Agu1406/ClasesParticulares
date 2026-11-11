/*
OBJETIVO: Cuantos productos hay por categoria?
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
*/

USE tienda;

-- ENUNCIADO: Cuantos productos hay por categoria?
SELECT categoria, COUNT(*) AS cuantos
FROM productos
GROUP BY categoria;
