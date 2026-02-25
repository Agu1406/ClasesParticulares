-- ============================================
-- CONSULTA 4: NIF de los artistas que atienden animales
-- ============================================
-- Uso de DISTINCT para obtener valores únicos de una tabla de relación.

USE circo;

-- ============================================
-- EXPLICACIÓN
-- ============================================
-- artista_animal relaciona artistas (nif) con animales (nombre).
-- DISTINCT evita repetir el mismo NIF si un artista atiende varios animales.

-- ============================================
-- SOLUCIÓN
-- ============================================
SELECT DISTINCT nif
FROM artista_animal;

-- ============================================
-- RESULTADO ESPERADO
-- ============================================
-- 11111111A, 22222222B

-- ============================================
-- VARIACIONES PARA PRACTICAR
-- ============================================
-- NIF y nombre del animal que atiende cada artista
-- SELECT nif, nombre FROM artista_animal;
