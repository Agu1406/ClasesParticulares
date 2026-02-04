-- ============================================
-- CONSULTA 31: Cuántos animales atiende cada artista, con nombre y apellidos
-- ============================================
-- GROUP BY con JOIN. COUNT y datos del artista.

USE circo;

-- ============================================
-- EXPLICACIÓN
-- ============================================
-- artista_animal tiene nif y nombre (animal).
-- GROUP BY nif agrupa por artista.
-- JOIN con artistas para obtener nombre y apellidos.

-- ============================================
-- SOLUCIÓN
-- ============================================
SELECT 
    ar.nombre,
    ar.apellidos,
    COUNT(aa.nombre) AS num_animales
FROM artistas ar
INNER JOIN artista_animal aa ON ar.Nif = aa.nif
GROUP BY ar.Nif, ar.nombre, ar.apellidos;

-- ============================================
-- RESULTADO ESPERADO
-- ============================================
-- Juan Lopez: 3 (Caiman, Leo, Princesa1), Luis Sanchez: 2 (Caiman, Princesa2)

-- ============================================
-- VARIACIONES PARA PRACTICAR
-- ============================================
-- Solo artistas que atienden más de 1 animal
-- Añadir: HAVING COUNT(aa.nombre) > 1
