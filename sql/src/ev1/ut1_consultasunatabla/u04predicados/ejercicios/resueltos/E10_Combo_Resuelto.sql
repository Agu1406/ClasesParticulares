/*
OBJETIVO: Perifericos con precio BETWEEN 25 AND 80.
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
*/

USE tienda;

-- ENUNCIADO: Perifericos con precio BETWEEN 25 AND 80.
SELECT nombre, precio
FROM productos
WHERE categoria = 'Perifericos'
  AND precio BETWEEN 25 AND 80;
