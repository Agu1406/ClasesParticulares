/*
OBJETIVO: Cuantos clientes tienen email informado.
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
*/

USE tienda;

-- ENUNCIADO: Cuantos clientes tienen email informado.
SELECT COUNT(email) AS con_email
FROM clientes;
