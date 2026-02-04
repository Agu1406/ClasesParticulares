-- ============================================
-- CONSULTA 49: Fechas en que la media de espectadores del día supera la media global
-- ============================================
-- Por cada fecha, calcular media de espectadores. Comparar con media global.
-- Media global = AVG(num_espectadores) de toda la tabla.
-- Por fecha: puede haber varias atracciones, la "media del día" sería el promedio de esas atracciones.

USE circo;

-- ============================================
-- EXPLICACIÓN
-- ============================================
-- atraccion_dia tiene fecha, nombre_atraccion, num_espectadores.
-- Por cada fecha hay uno o más registros (una atracción por fila).
-- Media del día = AVG(num_espectadores) agrupado por fecha.
-- Media global = AVG(num_espectadores) de toda la tabla.
-- Mostrar fechas donde media_dia > media_global.

-- ============================================
-- SOLUCIÓN
-- ============================================
SELECT ad.fecha, AVG(ad.num_espectadores) AS media_dia
FROM atraccion_dia ad
GROUP BY ad.fecha
HAVING AVG(ad.num_espectadores) > (SELECT AVG(num_espectadores) FROM atraccion_dia);

-- ============================================
-- RESULTADO ESPERADO
-- ============================================
-- Media global: (400+100+230+330+110+323)/6 ≈ 248.83
-- Por fecha: 1999-11-01: 100; 2000-01-01: 230; 2000-04-01: (230+110)/2=170; 2000-08-01: 323; 2001-04-01: 400
-- Fechas con media > 248.83: 2000-08-01 (323), 2001-04-01 (400)

-- ============================================
-- VARIACIONES PARA PRACTICAR
-- ============================================
-- Incluir número de atracciones ese día
-- SELECT fecha, AVG(num_espectadores) AS media, COUNT(*) AS num_atracciones FROM atraccion_dia GROUP BY fecha HAVING AVG(num_espectadores) > (SELECT AVG(num_espectadores) FROM atraccion_dia);
