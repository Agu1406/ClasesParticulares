-- ============================================
-- CONSULTA 42: Animales atendidos por Luis Sánchez
-- ============================================
-- Subconsulta o JOIN. Luis Sanchez = 22222222B.

USE circo;

-- ============================================
-- EXPLICACIÓN
-- ============================================
-- artista_animal tiene nif y nombre (animal).
-- Subconsulta: nif de Luis Sanchez. O JOIN con artistas.

-- ============================================
-- SOLUCIÓN
-- ============================================
SELECT a.*
FROM animales a
INNER JOIN artista_animal aa ON a.nombre_animal = aa.nombre
INNER JOIN artistas ar ON aa.nif = ar.Nif
WHERE ar.nombre = 'Luis' AND ar.apellidos = 'Sanchez';

-- Alternativa con subconsulta:
-- SELECT * FROM animales WHERE nombre_animal IN (SELECT nombre FROM artista_animal WHERE nif = (SELECT Nif FROM artistas WHERE nombre='Luis' AND apellidos='Sanchez'));

-- ============================================
-- RESULTADO ESPERADO
-- ============================================
-- Caiman, Princesa2

-- ============================================
-- VARIACIONES PARA PRACTICAR
-- ============================================
-- Solo nombres de animales
-- SELECT a.nombre_animal FROM animales a INNER JOIN artista_animal aa ON a.nombre_animal = aa.nombre WHERE aa.nif = (SELECT Nif FROM artistas WHERE apellidos='Sanchez');
