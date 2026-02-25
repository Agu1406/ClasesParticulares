-- ============================================
-- CONSULTA 10: Atracciones que no tuvieron 100, 500 o 1000 espectadores
-- ============================================
-- Uso de NOT IN. Datos en atraccion_dia.

USE circo;

-- ============================================
-- EXPLICACIÓN
-- ============================================
-- Buscamos atracciones que en NINGÚN día tuvieron exactamente 100, 500 o 1000.
-- Estrategia: atracciones cuyo nombre NO está en la subconsulta de las que sí tuvieron esos valores.

-- ============================================
-- SOLUCIÓN
-- ============================================
SELECT DISTINCT nombre_atraccion
FROM atraccion_dia
WHERE nombre_atraccion NOT IN (
    SELECT nombre_atraccion
    FROM atraccion_dia
    WHERE num_espectadores IN (100, 500, 1000)
);

-- ============================================
-- RESULTADO ESPERADO
-- ============================================
-- El gran felino tuvo 100 en un día, así que SÍ aparece en la subconsulta y NO en el resultado.
-- Las jirafas (110, 323) y El devorador (400) no tuvieron 100, 500 ni 1000.

-- ============================================
-- VARIACIONES PARA PRACTICAR
-- ============================================
-- Atracciones que SÍ tuvieron exactamente 100 espectadores algún día
-- SELECT DISTINCT nombre_atraccion FROM atraccion_dia WHERE num_espectadores = 100;
