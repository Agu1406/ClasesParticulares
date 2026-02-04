-- ============================================
-- CONSULTA 45: Artistas que han trabajado en alguna atracción, ordenados
-- ============================================
-- DISTINCT artistas que aparecen en artista_atraccion. ORDER BY.

USE circo;

-- ============================================
-- EXPLICACIÓN
-- ============================================
-- artista_atraccion tiene nif y nombre_atraccion.
-- JOIN con artistas. ORDER BY apellidos, nombre.

-- ============================================
-- SOLUCIÓN
-- ============================================
SELECT DISTINCT ar.nombre, ar.apellidos
FROM artistas ar
INNER JOIN artista_atraccion aa ON ar.Nif = aa.nif
ORDER BY ar.apellidos, ar.nombre;

-- ============================================
-- RESULTADO ESPERADO
-- ============================================
-- Juan Flórez, Juan Lopez, Carlos Perez, Luis Sanchez (ordenados alfabéticamente por apellidos)

-- ============================================
-- VARIACIONES PARA PRACTICAR
-- ============================================
-- Incluir nombre de la atracción
-- SELECT ar.nombre, ar.apellidos, aa.nombre_atraccion FROM artistas ar INNER JOIN artista_atraccion aa ON ar.Nif = aa.nif ORDER BY ar.apellidos, ar.nombre;
