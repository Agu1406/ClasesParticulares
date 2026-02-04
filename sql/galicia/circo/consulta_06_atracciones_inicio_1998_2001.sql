-- ============================================
-- CONSULTA 6: Atracciones que comenzaron entre 1-Ene-1998 y 1-Ene-2001
-- ============================================
-- Uso de BETWEEN con fechas.

USE circo;

-- ============================================
-- EXPLICACIÓN
-- ============================================
-- F_inicio es la fecha de inicio de cada atracción.
-- BETWEEN incluye ambos extremos (1-Ene-1998 y 1-Ene-2001).

-- ============================================
-- SOLUCIÓN
-- ============================================
SELECT *
FROM atracciones
WHERE F_inicio BETWEEN '1998-01-01' AND '2001-01-01';

-- ============================================
-- RESULTADO ESPERADO
-- ============================================
-- El gran felino (1999-11-01), Las jirafas (2000-04-01), El devorador (2001-04-01 no, fuera)
-- El devorador empieza 2001-04-01, está fuera del rango. El orangután tiene NULL.

-- ============================================
-- VARIACIONES PARA PRACTICAR
-- ============================================
-- Atracciones que comenzaron antes del año 2000
-- SELECT * FROM atracciones WHERE YEAR(F_inicio) < 2000;
