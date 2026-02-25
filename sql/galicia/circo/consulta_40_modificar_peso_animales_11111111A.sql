-- ============================================
-- CONSULTA 40: Aumentar 10 kg el peso de animales cuidados por el artista con NIF 11111111A
-- ============================================
-- UPDATE con subconsulta IN.

USE circo;

-- ============================================
-- EXPLICACIÓN
-- ============================================
-- Subconsulta obtiene los nombres de animales que cuida 11111111A.
-- UPDATE animales SET peso = peso + 10 WHERE nombre_animal IN (subconsulta)

-- ============================================
-- SOLUCIÓN
-- ============================================
UPDATE animales
SET peso = peso + 10
WHERE nombre_animal IN (
    SELECT nombre FROM artista_animal WHERE nif = '11111111A'
);

-- ============================================
-- RESULTADO ESPERADO
-- ============================================
-- Caiman, Leo, Princesa1 aumentan 10 kg cada uno.

-- ============================================
-- VARIACIONES PARA PRACTICAR
-- ============================================
-- Ver animales antes del update
-- SELECT nombre_animal, peso FROM animales WHERE nombre_animal IN (SELECT nombre FROM artista_animal WHERE nif = '11111111A');
