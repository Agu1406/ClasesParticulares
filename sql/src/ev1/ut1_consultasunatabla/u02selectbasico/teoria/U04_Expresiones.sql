/*
OBJETIVO: Calcular columnas nuevas con aritmetica y CONCAT sin modificar la tabla.
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
*/

USE tienda;

-- =============================================================================
-- Expresiones en el SELECT
-- =============================================================================
-- Puedes calcular valores al vuelo. La tabla NO se modifica.

SELECT nombre,
       precio,
       precio * 1.21 AS precio_con_iva
FROM productos;

SELECT nombre,
       precio,
       stock,
       precio * stock AS valor_stock
FROM productos;

SELECT CONCAT(nombre, ' ', apellidos) AS nombre_completo
FROM clientes;

-- Redondeo util en MySQL:
SELECT nombre, ROUND(precio * 1.21, 2) AS precio_iva_2dec
FROM productos;

-- Errores tipicos:
-- - Dividir enteros y esperar decimales sin cuidado de tipos
-- - Olvidar AS y no saber que columna estas mirando

-- Prueba tu: precio con descuento 10% (precio * 0.9) como precio_oferta.
