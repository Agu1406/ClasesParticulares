-- ============================================
-- CONSULTA 11: Artistas que todavía trabajan en alguna atracción
-- ============================================
-- Uso de artista_atraccion: fecha_fin NULL indica que sigue activo.

USE circo;

-- ============================================
-- EXPLICACIÓN
-- ============================================
-- artista_atraccion relaciona artistas con atracciones y fechas.
-- fecha_fin IS NULL significa que el artista sigue trabajando en esa atracción.

-- ============================================
-- SOLUCIÓN
-- ============================================
SELECT DISTINCT a.nif, a.nombre, a.apellidos
FROM artistas a
INNER JOIN artista_atraccion aa ON a.Nif = aa.nif
WHERE aa.fecha_fin IS NULL;

-- ============================================
-- RESULTADO ESPERADO
-- ============================================
-- Juan Lopez (11111111A), Luis Sanchez (22222222B), Carlos Perez (33333333C), Juan Flórez (77777e)

-- ============================================
-- VARIACIONES PARA PRACTICAR
-- ============================================
-- Artistas que ya no trabajan (fecha_fin no nula)
-- SELECT DISTINCT a.* FROM artistas a INNER JOIN artista_atraccion aa ON a.Nif = aa.nif WHERE aa.fecha_fin IS NOT NULL;
