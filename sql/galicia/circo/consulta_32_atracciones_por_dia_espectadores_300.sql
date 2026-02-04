-- ============================================
-- CONSULTA 32: Cuántas atracciones por día, cuando el total de espectadores del día supera 300
-- ============================================
-- GROUP BY fecha. HAVING SUM(num_espectadores) > 300.

USE circo;

-- ============================================
-- EXPLICACIÓN
-- ============================================
-- atraccion_dia tiene fecha, nombre_atraccion, num_espectadores.
-- Por cada fecha, sumamos espectadores de todas las atracciones.
-- HAVING filtra los días donde esa suma > 300.

-- ============================================
-- SOLUCIÓN
-- ============================================
SELECT 
    fecha,
    SUM(num_espectadores) AS total_espectadores,
    COUNT(DISTINCT nombre_atraccion) AS num_atracciones
FROM atraccion_dia
GROUP BY fecha
HAVING SUM(num_espectadores) > 300;

-- ============================================
-- RESULTADO ESPERADO
-- ============================================
-- 1999-11-01: 100 (1 atracción) - no supera 300
-- 2000-01-01: 230 - no supera 300
-- 2000-04-01: 230+110=340 (2 atracciones) - supera 300
-- 2000-08-01: 323 - supera 300
-- 2001-04-01: 400 - supera 300

-- ============================================
-- VARIACIONES PARA PRACTICAR
-- ============================================
-- Días con más de 2 atracciones
-- HAVING COUNT(DISTINCT nombre_atraccion) > 2
