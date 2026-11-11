/*
OBJETIVO: Practica Galicia UT1 (origen circo/consulta_29_atracciones_no_han_comenzado.sql).
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
*/

-- Origen: galicia/circo/consulta_29_atracciones_no_han_comenzado.sql
-- Nivel UT1: una tabla. No uses JOIN.

-- ============================================
-- CONSULTA 29: Número de atracciones que todavía no han comenzado
-- ============================================
-- COUNT con WHERE F_inicio IS NULL.

USE circo;

-- ============================================
-- EXPLICACIÓN
-- ============================================
-- F_inicio IS NULL indica que la atracción aún no ha comenzado.

-- ============================================
-- SOLUCIÓN
-- ============================================
SELECT COUNT(*) AS atracciones_sin_comenzar
FROM atracciones
WHERE F_inicio IS NULL;

-- ============================================
-- RESULTADO ESPERADO
-- ============================================
-- El orangután tiene F_inicio NULL. Total = 1.

-- ============================================
-- VARIACIONES PARA PRACTICAR
-- ============================================
-- Listar las atracciones que no han comenzado
-- SELECT Nombre FROM atracciones WHERE F_inicio IS NULL;
