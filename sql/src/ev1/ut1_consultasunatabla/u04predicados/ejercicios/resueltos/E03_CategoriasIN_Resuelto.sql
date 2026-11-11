/*
OBJETIVO: Productos en Pantallas, Portatiles, Almacenamiento.
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
*/

USE tienda;

-- ENUNCIADO: Productos en Pantallas, Portatiles, Almacenamiento.
SELECT nombre, categoria
FROM productos
WHERE categoria IN ('Pantallas', 'Portatiles', 'Almacenamiento');
