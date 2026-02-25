-- ============================================
-- CONSULTA 37: Aumentar en 10 espectadores y en 100 ganancias de atracciones del año 2000
-- ============================================
-- UPDATE en atraccion_dia con condición de fecha.

USE circo;

-- ============================================
-- EXPLICACIÓN
-- ============================================
-- atraccion_dia tiene num_espectadores y ganancia por fecha.
-- YEAR(fecha) = 2000 filtra el año.

-- ============================================
-- SOLUCIÓN
-- ============================================
UPDATE atraccion_dia
SET num_espectadores = num_espectadores + 10,
    ganancia = ganancia + 100
WHERE YEAR(fecha) = 2000;

-- ============================================
-- RESULTADO ESPERADO
-- ============================================
-- Registros de 2000: El gran felino (2000-01-01, 2000-04-01), Las jirafas (2000-04-01, 2000-08-01)

-- ============================================
-- VARIACIONES PARA PRACTICAR
-- ============================================
-- Ver registros afectados antes de actualizar
-- SELECT * FROM atraccion_dia WHERE YEAR(fecha) = 2000;
