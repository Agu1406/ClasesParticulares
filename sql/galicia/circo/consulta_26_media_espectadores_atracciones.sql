-- ============================================
-- CONSULTA 26: Media de espectadores que acuden a las atracciones
-- ============================================
-- AVG sobre atraccion_dia.num_espectadores.

USE circo;

-- ============================================
-- EXPLICACIÓN
-- ============================================
-- AVG() calcula el promedio de los valores.
-- atraccion_dia tiene un registro por atracción y fecha.

-- ============================================
-- SOLUCIÓN
-- ============================================
SELECT AVG(num_espectadores) AS media_espectadores
FROM atraccion_dia;

-- ============================================
-- RESULTADO ESPERADO
-- ============================================
-- (400+100+230+330+110+323) / 6 = 1493/6 ≈ 248.83

-- ============================================
-- VARIACIONES PARA PRACTICAR
-- ============================================
-- Media de espectadores por atracción
-- SELECT nombre_atraccion, AVG(num_espectadores) FROM atraccion_dia GROUP BY nombre_atraccion;
