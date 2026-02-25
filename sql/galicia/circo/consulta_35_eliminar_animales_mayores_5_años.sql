-- ============================================
-- CONSULTA 35: Eliminar todos los animales mayores de 5 años
-- ============================================
-- DELETE con WHERE. Cuidado con claves foráneas (artista_animal referencia animales).

USE circo;

-- ============================================
-- EXPLICACIÓN
-- ============================================
-- DELETE FROM tabla WHERE condición.
-- anhos > 5. Si hay FK desde artista_animal, primero eliminar referencias.

-- ============================================
-- SOLUCIÓN
-- ============================================
DELETE FROM artista_animal
WHERE nombre IN (SELECT nombre_animal FROM animales WHERE anhos > 5);

DELETE FROM animales
WHERE anhos > 5;

-- ============================================
-- RESULTADO ESPERADO
-- ============================================
-- En los datos no hay animales con más de 5 años (máximo 3). No se elimina nada.

-- ============================================
-- VARIACIONES PARA PRACTICAR
-- ============================================
-- Ver animales antes de eliminar
-- SELECT * FROM animales WHERE anhos > 5;
