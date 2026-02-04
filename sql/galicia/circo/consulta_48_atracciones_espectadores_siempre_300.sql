-- ============================================
-- CONSULTA 48: Atracciones que siempre han tenido más de 300 espectadores
-- ============================================
-- Subconsulta: atracciones que NO tienen ningún día con <= 300 espectadores.
-- O: atracciones cuyo mínimo de espectadores es > 300.

USE circo;

-- ============================================
-- EXPLICACIÓN
-- ============================================
-- "Siempre" = en todos sus registros en atraccion_dia.
-- Estrategia: atracciones donde el MÍNIMO de espectadores es > 300.
-- GROUP BY nombre_atraccion HAVING MIN(num_espectadores) > 300

-- ============================================
-- SOLUCIÓN
-- ============================================
SELECT nombre_atraccion
FROM atraccion_dia
GROUP BY nombre_atraccion
HAVING MIN(num_espectadores) > 300;

-- ============================================
-- RESULTADO ESPERADO
-- ============================================
-- El gran felino: 100, 230, 330 - mínimo 100, no cumple.
-- Las jirafas: 110, 323 - mínimo 110, no cumple.
-- El devorador: 400 - mínimo 400, cumple.
-- Solo El devorador.

-- ============================================
-- VARIACIONES PARA PRACTICAR
-- ============================================
-- Atracciones que al menos una vez tuvieron más de 300
-- SELECT DISTINCT nombre_atraccion FROM atraccion_dia WHERE num_espectadores > 300;
