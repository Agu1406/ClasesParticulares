/*
OBJETIVO: Solucion predicados u04.
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
*/

USE tienda;

SELECT nombre, precio FROM productos
WHERE precio BETWEEN 20 AND 60;

SELECT nombre, categoria FROM productos
WHERE categoria IN ('Mobiliario', 'Accesorios');

SELECT nombre FROM productos
WHERE nombre LIKE '%LED%' OR nombre LIKE '%USB%';

SELECT nombre, email, telefono FROM clientes
WHERE email IS NULL OR telefono IS NULL;

SELECT nombre, precio FROM productos
WHERE categoria = 'Perifericos' AND precio BETWEEN 25 AND 80;
