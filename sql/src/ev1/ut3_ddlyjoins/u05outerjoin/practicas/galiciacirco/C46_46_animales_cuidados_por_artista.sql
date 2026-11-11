/*
OBJETIVO: Practica Galicia UT3 (JOIN). Origen banco galicia/.
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
*/

-- Origen: galicia/circo/consulta_46_animales_cuidados_por_artista.sql

-- ============================================
-- CONSULTA 46: Animales (nombre, tipo, años) que están cuidados por algún artista
-- ============================================
-- INNER JOIN con artista_animal. Solo animales que tienen cuidador.

USE circo;

-- ============================================
-- EXPLICACIÓN
-- ============================================
-- artista_animal indica qué animales tienen artista asignado.
-- INNER JOIN solo incluye animales que aparecen en artista_animal.

-- ============================================
-- SOLUCIÓN
-- ============================================
SELECT a.nombre_animal, a.tipo, a.anhos
FROM animales a
INNER JOIN artista_animal aa ON a.nombre_animal = aa.nombre;

-- ============================================
-- RESULTADO ESPERADO
-- ============================================
-- Caiman, Leo, Princesa1, Princesa2 (los que tienen artista)
-- pepito, Peter y el vacío no tienen cuidador, no aparecen.

-- ============================================
-- VARIACIONES PARA PRACTICAR
-- ============================================
-- Animales SIN cuidador (LEFT JOIN ... WHERE aa.nombre IS NULL)
-- SELECT a.* FROM animales a LEFT JOIN artista_animal aa ON a.nombre_animal = aa.nombre WHERE aa.nombre IS NULL;
