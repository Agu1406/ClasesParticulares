-- ============================================
-- CONSULTA 38: Eliminar el número de años de los animales con menos de 20 kg de peso
-- ============================================
-- UPDATE estableciendo anhos = NULL.

USE circo;

-- ============================================
-- EXPLICACIÓN
-- ============================================
-- "Eliminar el nº de años" = poner anhos a NULL.

-- ============================================
-- SOLUCIÓN
-- ============================================
UPDATE animales
SET anhos = NULL
WHERE peso < 20;

-- ============================================
-- RESULTADO ESPERADO
-- ============================================
-- pepito (1 kg) cumple. pepito quedará con anhos = NULL.

-- ============================================
-- VARIACIONES PARA PRACTICAR
-- ============================================
-- Ver animales afectados
-- SELECT nombre_animal, anhos, peso FROM animales WHERE peso < 20;
