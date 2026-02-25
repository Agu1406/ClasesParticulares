-- ============================================
-- CONSULTA 22: Apellidos y nombre de artistas que cuidan animales, con todos los datos de animales
-- ============================================
-- LEFT JOIN o INNER JOIN para incluir artistas con todos los datos de animales.
-- "Incluyendo todos los datos de animales" sugiere LEFT JOIN desde artistas que cuidan.

USE circo;

-- ============================================
-- EXPLICACIÓN
-- ============================================
-- artista_animal relaciona artistas con animales.
-- INNER JOIN con animales para obtener todos los campos del animal.
-- Si un artista cuida varios animales, aparecerá una fila por cada uno.

-- ============================================
-- SOLUCIÓN
-- ============================================
SELECT 
    ar.apellidos,
    ar.nombre,
    a.nombre_animal,
    a.tipo,
    a.anhos,
    a.peso,
    a.estatura,
    a.nombre_pista,
    a.nombre_atraccion
FROM artistas ar
INNER JOIN artista_animal aa ON ar.Nif = aa.nif
INNER JOIN animales a ON aa.nombre = a.nombre_animal
ORDER BY ar.apellidos, ar.nombre;

-- ============================================
-- RESULTADO ESPERADO
-- ============================================
-- Cada combinación artista-animal con todos los datos del animal

-- ============================================
-- VARIACIONES PARA PRACTICAR
-- ============================================
-- Solo artistas y nombres de animales
-- SELECT ar.apellidos, ar.nombre, a.nombre_animal FROM artistas ar INNER JOIN artista_animal aa ON ar.Nif = aa.nif INNER JOIN animales a ON aa.nombre = a.nombre_animal;
