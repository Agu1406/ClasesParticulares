-- ============================================
-- CONSULTA 18: Nombres de atracciones y ganancias donde actúan animales
-- ============================================
-- JOIN entre atracciones y animales (los animales tienen nombre_atraccion).

USE circo;

-- ============================================
-- EXPLICACIÓN
-- ============================================
-- animales.nombre_atraccion referencia a atracciones.Nombre.
-- INNER JOIN solo incluye atracciones que tienen animales asignados.

-- ============================================
-- SOLUCIÓN
-- ============================================
SELECT DISTINCT atr.Nombre, atr.ganancias
FROM atracciones atr
INNER JOIN animales a ON atr.Nombre = a.nombre_atraccion
WHERE a.nombre_atraccion IS NOT NULL;

-- ============================================
-- RESULTADO ESPERADO
-- ============================================
-- El devorador (430123), El gran felino (511212), Las jirafas (440300)
-- El orangután no tiene animales, no aparece.

-- ============================================
-- VARIACIONES PARA PRACTICAR
-- ============================================
-- Incluir atracciones sin animales (LEFT JOIN desde atracciones)
-- SELECT atr.Nombre, atr.ganancias FROM atracciones atr LEFT JOIN animales a ON atr.Nombre = a.nombre_atraccion;
