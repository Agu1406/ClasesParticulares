-- ============================================
-- CONSULTA 44: Animales con más de 1 año que actúan en pistas con aforo < 500, ordenados por nombre
-- ============================================
-- JOIN animales con pistas. WHERE anhos > 1 AND Aforo < 500.

USE circo;

-- ============================================
-- EXPLICACIÓN
-- ============================================
-- animales.nombre_pista referencia pistas.
-- pistas.Aforo: CENTRAL 1000, LATERAL1 300, LATERAL2 400.
-- Aforo < 500: LATERAL1 (300), LATERAL2 (400).

-- ============================================
-- SOLUCIÓN
-- ============================================
SELECT a.nombre_animal, a.tipo, a.anhos, p.Nombre_pista, p.Aforo
FROM animales a
INNER JOIN pistas p ON a.nombre_pista = p.Nombre_pista
WHERE a.anhos > 1 AND p.Aforo < 500
ORDER BY a.nombre_animal;

-- ============================================
-- RESULTADO ESPERADO
-- ============================================
-- Princesa1 (2 años, LATERAL1, 300), Princesa2 (3 años, LATERAL1, 300)
-- Leo (3 años) está en CENTRAL (1000), no cumple aforo < 500.

-- ============================================
-- VARIACIONES PARA PRACTICAR
-- ============================================
-- Animales en pistas con aforo exactamente 400
-- WHERE p.Aforo = 400
