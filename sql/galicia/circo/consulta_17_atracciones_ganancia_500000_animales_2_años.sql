-- ============================================
-- CONSULTA 17: Atracciones con ganancia > 500000 O con animales de más de 2 años, ordenadas
-- ============================================
-- UNION o OR con JOIN. Atracciones que cumplan una u otra condición.

USE circo;

-- ============================================
-- EXPLICACIÓN
-- ============================================
-- Condición 1: ganancias > 500000 (tabla atracciones)
-- Condición 2: actúan animales con más de 2 años (tabla animales)
-- UNION combina resultados sin duplicados. ORDER BY al final.

-- ============================================
-- SOLUCIÓN
-- ============================================
SELECT DISTINCT atr.Nombre
FROM atracciones atr
LEFT JOIN animales a ON atr.Nombre = a.nombre_atraccion
WHERE atr.ganancias > 500000
   OR (a.anhos IS NOT NULL AND a.anhos > 2)
ORDER BY atr.Nombre;

-- ============================================
-- RESULTADO ESPERADO
-- ============================================
-- El gran felino (511212 > 500000, y tiene Leo y Princesa2 con 3 años)
-- Las jirafas (440300 no > 500000, pero tiene Princesa2 con 3 años)

-- ============================================
-- VARIACIONES PARA PRACTICAR
-- ============================================
-- Solo atracciones con ganancia > 500000
-- SELECT Nombre FROM atracciones WHERE ganancias > 500000;
