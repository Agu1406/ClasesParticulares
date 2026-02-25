-- ============================================
-- CONSULTA 39: Borrar animales cuidados por el artista con NIF 11111111A
-- ============================================
-- DELETE con subconsulta. Primero eliminar de artista_animal, luego de animales.

USE circo;

-- ============================================
-- EXPLICACIÓN
-- ============================================
-- artista_animal relaciona nif con nombre (animal).
-- Subconsulta: animales cuyo nombre está en artista_animal para nif 11111111A.
-- Cuidado: DELETE de animales requiere eliminar antes las FK en artista_animal.

-- ============================================
-- SOLUCIÓN
-- ============================================
-- Guardar en tabla temporal los animales a borrar (antes de eliminar referencias)
CREATE TEMPORARY TABLE tmp_animales_borrar AS
SELECT nombre FROM artista_animal WHERE nif = '11111111A';

-- Eliminar referencias en artista_animal (Caiman también lo cuida 22222222B)
DELETE FROM artista_animal WHERE nombre IN (SELECT nombre FROM tmp_animales_borrar);

-- Eliminar los animales
DELETE FROM animales WHERE nombre_animal IN (SELECT nombre FROM tmp_animales_borrar);

DROP TEMPORARY TABLE tmp_animales_borrar;
