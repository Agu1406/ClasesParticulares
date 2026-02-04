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
