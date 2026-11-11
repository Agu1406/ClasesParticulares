/*
OBJETIVO: Repasar expresiones y alias como base de los resumenes numericos.
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
*/

USE tienda;

-- Antes de COUNT/SUM: recuerda que puedes calcular en el SELECT.
SELECT nombre,
       precio,
       ROUND(precio * 1.21, 2) AS con_iva,
       precio * stock AS valor_stock
FROM productos;

-- Esto NO agrupa filas: sigue habiendo una fila por producto.
