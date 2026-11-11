/*
OBJETIVO: Usar COUNT, SUM, AVG, MIN y MAX sobre toda la tabla (sin GROUP BY).
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
*/

USE tienda;

-- =============================================================================
-- Agregadas SIN GROUP BY: un solo resumen de toda la tabla
-- =============================================================================
-- COUNT(*)     cuantas filas
-- COUNT(col)   cuantas filas con col NOT NULL
-- SUM(col)     suma
-- AVG(col)     media
-- MIN / MAX    minimo / maximo

SELECT COUNT(*) AS total_productos FROM productos;
SELECT COUNT(email) AS clientes_con_email FROM clientes;  -- ignora NULL
SELECT COUNT(*) AS clientes_sin_email FROM clientes WHERE email IS NULL;

SELECT SUM(stock) AS stock_total FROM productos;
SELECT AVG(precio) AS precio_medio FROM productos;
SELECT MIN(precio) AS mas_barato, MAX(precio) AS mas_caro FROM productos;

-- Con filtro:
SELECT COUNT(*) AS perifericos
FROM productos
WHERE categoria = 'Perifericos';

SELECT AVG(precio) AS media_perifericos
FROM productos
WHERE categoria = 'Perifericos';

-- GROUP BY / HAVING NO entran en UT1 (siguiente unidad).
