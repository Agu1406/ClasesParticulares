-- ============================================
-- CONSULTA 3: Nombres de animales con 2 o menos años
-- ============================================
-- Uso de WHERE con operador <= (menor o igual).

USE circo;

-- ============================================
-- EXPLICACIÓN
-- ============================================
-- anhos es la columna que almacena la edad en años.
-- <= 2 incluye 0, 1 y 2 años.

-- ============================================
-- SOLUCIÓN
-- ============================================
SELECT nombre_animal
FROM animales
WHERE anhos <= 2;

-- ============================================
-- RESULTADO ESPERADO
-- ============================================
-- Caiman (1), pepito (1), Peter (1), Princesa1 (2), Princesa2 (3 no, Leo 3 no)

-- ============================================
-- VARIACIONES PARA PRACTICAR
-- ============================================
-- Animales con más de 2 años
-- SELECT nombre_animal FROM animales WHERE anhos > 2;
