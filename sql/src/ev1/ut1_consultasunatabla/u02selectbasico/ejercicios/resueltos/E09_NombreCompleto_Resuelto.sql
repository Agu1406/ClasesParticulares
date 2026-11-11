/*
OBJETIVO: CONCAT nombre y apellidos como nombre_completo.
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
*/

USE tienda;

-- ENUNCIADO: CONCAT nombre y apellidos como nombre_completo.
SELECT CONCAT(nombre, ' ', apellidos) AS nombre_completo
FROM clientes;
