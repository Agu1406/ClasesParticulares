/*
OBJETIVO: Usar =, <>, !=, <, >, <=, >= con numeros, textos y fechas.
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
*/

USE tienda;

-- =============================================================================
-- Comparadores
-- =============================================================================
-- =   igual
-- <>  distinto (tambien != en MySQL)
-- < > <= >=

SELECT nombre, stock FROM productos WHERE stock <= 10;
SELECT nombre, precio FROM productos WHERE precio <> 9.99;
SELECT nombre, fecha_alta FROM clientes WHERE fecha_alta >= '2025-01-01';
SELECT nombre FROM productos WHERE categoria = 'Perifericos';

-- Textos: comparacion exacta (ojo a mayusculas/acentos segun collation).
-- Fechas: usa formato 'YYYY-MM-DD'.

-- Errores tipicos:
-- - WHERE ciudad = Madrid;     -- falta comillas
-- - WHERE precio = '50';       -- a veces funciona por conversion, mal estilo
-- - WHERE activo = true;       -- en nuestra BD usamos 1/0

-- Prueba tu: pedidos con cantidad >= 2.
