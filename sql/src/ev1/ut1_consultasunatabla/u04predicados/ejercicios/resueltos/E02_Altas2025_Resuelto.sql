/*
OBJETIVO: Clientes con fecha_alta en 2025 (BETWEEN).
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
*/

USE tienda;

-- ENUNCIADO: Clientes con fecha_alta en 2025 (BETWEEN).
SELECT nombre, fecha_alta
FROM clientes
WHERE fecha_alta BETWEEN '2025-01-01' AND '2025-12-31';
