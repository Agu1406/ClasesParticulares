-- ============================================
-- CONSULTA 7: Atracciones que no tuvieron entre 50 y 100 espectadores
-- ============================================
-- Uso de NOT con BETWEEN. Los datos están en atraccion_dia.

USE circo;

-- ============================================
-- EXPLICACIÓN
-- ============================================
-- atraccion_dia tiene num_espectadores por fecha.
-- NOT (num_espectadores BETWEEN 50 AND 100) excluye ese rango.
-- También: num_espectadores < 50 OR num_espectadores > 100

-- ============================================
-- SOLUCIÓN
-- ============================================
SELECT DISTINCT nombre_atraccion
FROM atraccion_dia
WHERE nombre_atraccion NOT IN (
    SELECT nombre_atraccion
    FROM atraccion_dia
    WHERE num_espectadores BETWEEN 50 AND 100
);

-- ============================================
-- RESULTADO ESPERADO
-- ============================================
-- Atracciones que en ningún día tuvieron entre 50 y 100 espectadores.
-- El gran felino tuvo 100 un día, así que NO aparece.
-- Las jirafas (110, 323) y El devorador (400) sí aparecen.

-- ============================================
-- VARIACIONES PARA PRACTICAR
-- ============================================
-- Atracciones con más de 200 espectadores en algún día
-- SELECT DISTINCT nombre_atraccion FROM atraccion_dia WHERE num_espectadores > 200;
