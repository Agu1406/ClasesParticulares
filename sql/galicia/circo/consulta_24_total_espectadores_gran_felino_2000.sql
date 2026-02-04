-- ============================================
-- CONSULTA 24: Total de espectadores en 'El gran felino' durante el año 2000
-- ============================================
-- SUM con WHERE. Datos en atraccion_dia.
-- Nota: en la BD es 'El gran felino' (g minúscula).

USE circo;

-- ============================================
-- EXPLICACIÓN
-- ============================================
-- atraccion_dia tiene nombre_atraccion, fecha, num_espectadores.
-- YEAR(fecha) = 2000 filtra el año.
-- SUM(num_espectadores) suma el total.

-- ============================================
-- SOLUCIÓN
-- ============================================
SELECT SUM(num_espectadores) AS total_espectadores
FROM atraccion_dia
WHERE nombre_atraccion = 'El gran felino'
  AND YEAR(fecha) = 2000;

-- ============================================
-- RESULTADO ESPERADO
-- ============================================
-- 2000-01-01: 230, 2000-04-01: 330. Total = 560 (100 es de 1999, no cuenta)

-- ============================================
-- VARIACIONES PARA PRACTICAR
-- ============================================
-- Total de espectadores por atracción en 2000
-- SELECT nombre_atraccion, SUM(num_espectadores) FROM atraccion_dia WHERE YEAR(fecha) = 2000 GROUP BY nombre_atraccion;
