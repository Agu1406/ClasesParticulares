-- ============================================
-- CONSULTA 41: Atracciones con ganancias por encima de la media
-- ============================================
-- Subconsulta para calcular la media. WHERE ganancias > (SELECT AVG(...)).

USE circo;

-- ============================================
-- EXPLICACIÓN
-- ============================================
-- AVG(ganancias) en subconsulta calcula la media.
-- La consulta principal filtra atracciones con ganancias superiores.

-- ============================================
-- SOLUCIÓN
-- ============================================
SELECT Nombre, ganancias
FROM atracciones
WHERE ganancias > (SELECT AVG(ganancias) FROM atracciones WHERE ganancias IS NOT NULL);

-- ============================================
-- RESULTADO ESPERADO
-- ============================================
-- Media: (430123+511212+440300)/3 ≈ 460545. Las que superan: El gran felino (511212), Las jirafas (440300 no), El devorador (430123 no).
-- Solo El gran felino supera la media.

-- ============================================
-- VARIACIONES PARA PRACTICAR
-- ============================================
-- Atracciones con ganancias por debajo de la media
-- WHERE ganancias < (SELECT AVG(ganancias) FROM atracciones WHERE ganancias IS NOT NULL)
