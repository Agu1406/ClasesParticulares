/*
OBJETIVO: Precio minimo y maximo.
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
*/

USE tienda;

-- ENUNCIADO: Precio minimo y maximo.
SELECT MIN(precio) AS min_precio, MAX(precio) AS max_precio
FROM productos;
