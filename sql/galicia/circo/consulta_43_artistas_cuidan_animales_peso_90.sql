-- ============================================
-- CONSULTA 43: Artistas que cuidan animales con peso superior a 90
-- ============================================
-- JOIN artista_animal con animales. WHERE peso > 90.

USE circo;

-- ============================================
-- EXPLICACIÓN
-- ============================================
-- artista_animal relaciona artistas con animales.
-- JOIN con animales para filtrar por peso.
-- DISTINCT para no repetir artistas que cuidan varios animales pesados.

-- ============================================
-- SOLUCIÓN
-- ============================================
SELECT DISTINCT ar.*
FROM artistas ar
INNER JOIN artista_animal aa ON ar.Nif = aa.nif
INNER JOIN animales a ON aa.nombre = a.nombre_animal
WHERE a.peso > 90;

-- ============================================
-- RESULTADO ESPERADO
-- ============================================
-- Leo (120), Princesa1 (100), Princesa2 (110). Artistas: Juan Lopez (Leo, Princesa1), Luis Sanchez (Princesa2)

-- ============================================
-- VARIACIONES PARA PRACTICAR
-- ============================================
-- Incluir nombre y peso del animal
-- SELECT ar.*, a.nombre_animal, a.peso FROM artistas ar INNER JOIN artista_animal aa ON ar.Nif = aa.nif INNER JOIN animales a ON aa.nombre = a.nombre_animal WHERE a.peso > 90;
