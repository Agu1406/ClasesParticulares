-- ============================================
-- CONSULTA 46: Animales (nombre, tipo, años) que están cuidados por algún artista
-- ============================================
-- INNER JOIN con artista_animal. Solo animales que tienen cuidador.

USE circo;

-- ============================================
-- EXPLICACIÓN
-- ============================================
-- artista_animal indica qué animales tienen artista asignado.
-- INNER JOIN solo incluye animales que aparecen en artista_animal.

-- ============================================
-- SOLUCIÓN
-- ============================================
SELECT a.nombre_animal, a.tipo, a.anhos
FROM animales a
INNER JOIN artista_animal aa ON a.nombre_animal = aa.nombre;

-- ============================================
-- RESULTADO ESPERADO
-- ============================================
-- Caiman, Leo, Princesa1, Princesa2 (los que tienen artista)
-- pepito, Peter y el vacío no tienen cuidador, no aparecen.

-- ============================================
-- VARIACIONES PARA PRACTICAR
-- ============================================
-- Animales SIN cuidador (LEFT JOIN ... WHERE aa.nombre IS NULL)
-- SELECT a.* FROM animales a LEFT JOIN artista_animal aa ON a.nombre_animal = aa.nombre WHERE aa.nombre IS NULL;
