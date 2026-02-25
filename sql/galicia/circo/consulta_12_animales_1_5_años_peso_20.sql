-- ============================================
-- CONSULTA 12: Animales con 1 o 5 años y peso >= 20
-- ============================================
-- Uso de IN con AND para combinar condiciones.

USE circo;

-- ============================================
-- EXPLICACIÓN
-- ============================================
-- anhos IN (1, 5) equivale a (anhos = 1 OR anhos = 5).
-- AND peso >= 20 añade la condición de peso.

-- ============================================
-- SOLUCIÓN
-- ============================================
SELECT nombre_animal
FROM animales
WHERE anhos IN (1, 5)
  AND peso >= 20;

-- ============================================
-- RESULTADO ESPERADO
-- ============================================
-- Caiman (1 año, 70 kg), Peter (1 año, 30 kg)
-- pepito (1 año, 1 kg) no cumple peso >= 20. No hay animales de 5 años.

-- ============================================
-- VARIACIONES PARA PRACTICAR
-- ============================================
-- Animales con 1 o 5 años y peso menor a 50
-- SELECT nombre_animal FROM animales WHERE anhos IN (1, 5) AND peso < 50;
