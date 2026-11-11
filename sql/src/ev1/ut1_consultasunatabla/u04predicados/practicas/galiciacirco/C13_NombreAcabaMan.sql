/*
OBJETIVO: Practica Galicia UT1 (origen circo/consulta_13_animales_nombre_acaba_man.sql).
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
*/

-- Origen: galicia/circo/consulta_13_animales_nombre_acaba_man.sql
-- Nivel UT1: una tabla. No uses JOIN.

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
