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
