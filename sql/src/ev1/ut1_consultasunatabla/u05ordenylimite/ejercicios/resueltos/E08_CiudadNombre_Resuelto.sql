/*
OBJETIVO: Clientes ORDER BY ciudad, nombre LIMIT 5.
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
*/

USE tienda;

-- ENUNCIADO: Clientes ORDER BY ciudad, nombre LIMIT 5.
SELECT ciudad, nombre, apellidos
FROM clientes
ORDER BY ciudad ASC, nombre ASC
LIMIT 5;
