/*
OBJETIVO: Contar valores distintos y presentar medias redondeadas.
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
*/

USE tienda;

SELECT COUNT(DISTINCT ciudad) AS ciudades_distintas FROM clientes;
SELECT COUNT(DISTINCT categoria) AS num_categorias FROM productos;
SELECT COUNT(DISTINCT estado) AS estados_pedido FROM pedidos;

SELECT ROUND(AVG(precio), 2) AS precio_medio_2dec FROM productos;
SELECT ROUND(AVG(precio), 2) AS media, MIN(precio) AS min_p, MAX(precio) AS max_p
FROM productos
WHERE stock > 0;

-- Errores tipicos:
-- - Mezclar en el mismo SELECT una agregada y una columna "suelta" sin GROUP BY
--   (en MySQL con ONLY_FULL_GROUP_BY falla; evita ese patron en UT1)
-- Bien en UT1: solo agregadas, o solo columnas de fila (u02), no mezclar.

-- Prueba tu: SUM(cantidad) FROM pedidos WHERE estado = 'entregado';
