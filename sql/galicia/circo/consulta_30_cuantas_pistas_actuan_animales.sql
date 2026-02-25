-- ============================================
-- CONSULTA 30: Cuántas pistas diferentes actúan los animales
-- ============================================
-- COUNT(DISTINCT nombre_pista) en animales.

USE circo;

-- ============================================
-- EXPLICACIÓN
-- ============================================
-- animales.nombre_pista indica en qué pista actúa cada animal.
-- DISTINCT evita contar la misma pista varias veces.
-- Excluir NULL (animales sin pista asignada).

-- ============================================
-- SOLUCIÓN
-- ============================================
SELECT COUNT(DISTINCT nombre_pista) AS pistas_diferentes
FROM animales
WHERE nombre_pista IS NOT NULL;

-- ============================================
-- RESULTADO ESPERADO
-- ============================================
-- CENTRAL, LATERAL1, LATERAL2 = 3 pistas

-- ============================================
-- VARIACIONES PARA PRACTICAR
-- ============================================
-- Listar las pistas donde actúan animales
-- SELECT DISTINCT nombre_pista FROM animales WHERE nombre_pista IS NOT NULL;
