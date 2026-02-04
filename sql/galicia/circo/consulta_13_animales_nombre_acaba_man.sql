-- ============================================
-- CONSULTA 13: Nombres de animales que acaban en 'man'
-- ============================================
-- Uso de LIKE con el comodín % al final.

USE circo;

-- ============================================
-- EXPLICACIÓN
-- ============================================
-- LIKE '%man' busca patrones que terminen en 'man'.
-- % representa cualquier secuencia de caracteres (0 o más).

-- ============================================
-- SOLUCIÓN
-- ============================================
SELECT nombre_animal
FROM animales
WHERE nombre_animal LIKE '%man';

-- ============================================
-- RESULTADO ESPERADO
-- ============================================
-- Caiman (termina en 'man')

-- ============================================
-- VARIACIONES PARA PRACTICAR
-- ============================================
-- Animales cuyo nombre empieza por 'P'
-- SELECT nombre_animal FROM animales WHERE nombre_animal LIKE 'P%';
