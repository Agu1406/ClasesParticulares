-- ============================================
-- CONSULTA 9: Nombres de animales con edad 1, 2 o 5 años
-- ============================================
-- Uso del operador IN para múltiples valores.

USE circo;

-- ============================================
-- EXPLICACIÓN
-- ============================================
-- IN (valor1, valor2, ...) equivale a anhos = 1 OR anhos = 2 OR anhos = 5

-- ============================================
-- SOLUCIÓN
-- ============================================
SELECT nombre_animal
FROM animales
WHERE anhos IN (1, 2, 5);

-- ============================================
-- RESULTADO ESPERADO
-- ============================================
-- Caiman (1), pepito (1), Peter (1), Princesa1 (2)
-- Leo (3) y Princesa2 (3) no aparecen. No hay animales de 5 años.

-- ============================================
-- VARIACIONES PARA PRACTICAR
-- ============================================
-- Animales que NO tienen 1, 2 o 5 años
-- SELECT nombre_animal FROM animales WHERE anhos NOT IN (1, 2, 5);
