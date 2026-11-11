/*
OBJETIVO: Practica Galicia UT1 (origen circo/consulta_01_todos_datos_animales.sql).
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
*/

-- Origen: galicia/circo/consulta_01_todos_datos_animales.sql
-- Nivel UT1: una tabla. No uses JOIN.

-- ============================================
-- CONSULTA 1: Todos los datos de todos los animales del circo
-- ============================================
-- Consulta básica SELECT * para ver todos los registros de una tabla.

USE circo;

-- ============================================
-- EXPLICACIÓN
-- ============================================
-- SELECT * devuelve todas las columnas de la tabla.
-- FROM animales indica la tabla a consultar.

-- ============================================
-- SOLUCIÓN
-- ============================================
SELECT *
FROM animales;

/* Verás todas las filas: nombre, tipo, años, peso, estatura, pista y atracción de cada animal. */

/* Para practicar: prueba mostrando solo nombre y tipo. */
