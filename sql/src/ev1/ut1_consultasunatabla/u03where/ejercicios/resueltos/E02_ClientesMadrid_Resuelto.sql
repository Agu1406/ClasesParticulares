/*
OBJETIVO: Clientes de ciudad = Madrid.
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
*/

USE tienda;

-- ENUNCIADO: Clientes de ciudad = Madrid.
SELECT nombre, apellidos, ciudad
FROM clientes
WHERE ciudad = 'Madrid';
