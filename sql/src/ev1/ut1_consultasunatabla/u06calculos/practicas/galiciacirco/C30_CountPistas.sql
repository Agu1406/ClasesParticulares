/*
OBJETIVO: Practica Galicia UT1 (origen circo/consulta_30_cuantas_pistas_actuan_animales.sql).
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
*/

-- Origen: galicia/circo/consulta_30_cuantas_pistas_actuan_animales.sql
-- Nivel UT1: una tabla. No uses JOIN.

-- ============================================
-- CONSULTA 30: Cuántas pistas diferentes actúan los animales
-- ============================================
-- COUNT(DISTINCT nombre_pista) en animales.

USE circo;

-- ============================================
-- EXPLICACIÓN
-- ============================================
-- animales.nombre_pista indica en qué pista actúa cada animal.
-- DISTINCT evita contar la misma pista varias veces.
-- Excluir NULL (animales sin pista asignada).

-- ============================================
-- SOLUCIÓN
-- ============================================
SELECT COUNT(DISTINCT nombre_pista) AS pistas_diferentes
FROM animales
WHERE nombre_pista IS NOT NULL;

-- ============================================
-- RESULTADO ESPERADO
-- ============================================
-- CENTRAL, LATERAL1, LATERAL2 = 3 pistas

-- ============================================
-- VARIACIONES PARA PRACTICAR
-- ============================================
-- Listar las pistas donde actúan animales
-- SELECT DISTINCT nombre_pista FROM animales WHERE nombre_pista IS NOT NULL;
