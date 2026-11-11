/*
OBJETIVO: Media precio de Perifericos y Cables por categoria.
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
*/

USE tienda;

-- ENUNCIADO: Media precio de Perifericos y Cables por categoria.
SELECT categoria, ROUND(AVG(precio), 2) AS media
FROM productos
WHERE categoria IN ('Perifericos', 'Cables')
GROUP BY categoria;
