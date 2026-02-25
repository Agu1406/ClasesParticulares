-- ============================================
-- CONSULTA 36: Aumentar en 10 el peso de todos los animales
-- ============================================
-- UPDATE con expresión aritmética.

USE circo;

-- ============================================
-- EXPLICACIÓN
-- ============================================
-- UPDATE tabla SET columna = expresión [WHERE condición].
-- peso = peso + 10

-- ============================================
-- SOLUCIÓN
-- ============================================
UPDATE animales
SET peso = peso + 10
WHERE peso IS NOT NULL;

-- ============================================
-- RESULTADO ESPERADO
-- ============================================
-- Cada animal con peso no nulo aumenta 10 kg.

-- ============================================
-- VARIACIONES PARA PRACTICAR
-- ============================================
-- Aumentar solo animales con peso < 50
-- UPDATE animales SET peso = peso + 10 WHERE peso IS NOT NULL AND peso < 50;
