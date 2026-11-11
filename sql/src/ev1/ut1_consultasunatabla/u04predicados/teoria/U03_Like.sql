/*
OBJETIVO: Buscar patrones de texto con LIKE, % y _.
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
*/

USE tienda;

-- =============================================================================
-- LIKE: patrones
-- =============================================================================
-- %  cualquier secuencia (incluido vacio)
-- _  exactamente un caracter

SELECT nombre FROM productos WHERE nombre LIKE 'Cable%';   -- empieza por Cable
SELECT nombre FROM productos WHERE nombre LIKE '%USB%';    -- contiene USB
SELECT nombre FROM productos WHERE nombre LIKE '%m';       -- termina en m (minuscula)
SELECT nombre, email FROM clientes WHERE email LIKE '%@mail.com';
SELECT nombre FROM clientes WHERE nombre LIKE '_a%';       -- 2a letra = a

-- LIKE no es regex. Para "empieza por" usa 'texto%'.

-- Errores tipicos:
-- - WHERE nombre LIKE Teclado;     -- faltan comillas / comodines
-- - Confundir % con * (en SQL es %)

-- Prueba tu: apellidos LIKE '%ez' en clientes.
