-- ============================================
-- CONSULTA 19: Para cada animal: pista y aforo, ordenado por nombre, aforo >= 400
-- ============================================
-- JOIN animales con pistas. Filtrar por aforo.

USE circo;

-- ============================================
-- EXPLICACIÓN
-- ============================================
-- animales.nombre_pista referencia pistas.Nombre_pista.
-- Solo animales con pista asignada y aforo >= 400.

-- ============================================
-- SOLUCIÓN
-- ============================================
SELECT a.nombre_animal, p.Nombre_pista, p.Aforo
FROM animales a
INNER JOIN pistas p ON a.nombre_pista = p.Nombre_pista
WHERE p.Aforo >= 400
ORDER BY a.nombre_animal;

-- ============================================
-- RESULTADO ESPERADO
-- ============================================
-- CENTRAL tiene aforo 1000, LATERAL1 tiene 300, LATERAL2 tiene 400.
-- Solo CENTRAL (1000) y LATERAL2 (400) cumplen. Leo en CENTRAL, Caiman en LATERAL2.

-- ============================================
-- VARIACIONES PARA PRACTICAR
-- ============================================
-- Todas las pistas con sus animales, sin filtrar aforo
-- SELECT a.nombre_animal, p.Nombre_pista, p.Aforo FROM animales a INNER JOIN pistas p ON a.nombre_pista = p.Nombre_pista ORDER BY a.nombre_animal;
