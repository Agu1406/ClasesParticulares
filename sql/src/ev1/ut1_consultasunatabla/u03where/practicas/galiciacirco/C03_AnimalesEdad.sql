/*
OBJETIVO: Practica Galicia UT1 (origen circo/consulta_03_animales_2_o_menos_años.sql).
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
*/

-- Origen: galicia/circo/consulta_03_animales_2_o_menos_años.sql
-- Nivel UT1: una tabla. No uses JOIN.

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
