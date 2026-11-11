/*
OBJETIVO: Practica Galicia UT1 (origen circo/consulta_28_cuantos_artistas_circo.sql).
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
*/

-- Origen: galicia/circo/consulta_28_cuantos_artistas_circo.sql
-- Nivel UT1: una tabla. No uses JOIN.

-- ============================================
-- CONSULTA 28: Cuántos artistas tiene el circo
-- ============================================
-- COUNT sobre la tabla artistas.

USE circo;

-- ============================================
-- EXPLICACIÓN
-- ============================================
-- COUNT(*) cuenta todas las filas de la tabla.

-- ============================================
-- SOLUCIÓN
-- ============================================
SELECT COUNT(*) AS total_artistas
FROM artistas;

-- ============================================
-- RESULTADO ESPERADO
-- ============================================
-- 6 artistas en los datos

-- ============================================
-- VARIACIONES PARA PRACTICAR
-- ============================================
-- Artistas que tienen jefe
-- SELECT COUNT(*) FROM artistas WHERE nif_jefe IS NOT NULL;
