/*
OBJETIVO: Practica Galicia UT1 (origen circo/consulta_15_artistas_apellido_san_gar.sql).
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
*/

-- Origen: galicia/circo/consulta_15_artistas_apellido_san_gar.sql
-- Nivel UT1: una tabla. No uses JOIN.

-- ============================================
-- CONSULTA 15: Artistas con apellido que comience por San o por Gar
-- ============================================
-- Uso de LIKE con OR para múltiples patrones.

USE circo;

-- ============================================
-- EXPLICACIÓN
-- ============================================
-- apellidos LIKE 'San%' = empieza por San (Sanchez, Sanz, etc.)
-- apellidos LIKE 'Gar%' = empieza por Gar (Garcia, Garrido, etc.)

-- ============================================
-- SOLUCIÓN
-- ============================================
SELECT *
FROM artistas
WHERE apellidos LIKE 'San%' OR apellidos LIKE 'Gar%';

-- ============================================
-- RESULTADO ESPERADO
-- ============================================
-- Sanchez (Luis), y cualquier artista con apellido Garcia, Garrido, etc.
-- En los datos: Sanchez. No hay Gar.

-- ============================================
-- VARIACIONES PARA PRACTICAR
-- ============================================
-- Artistas con apellido que contenga 'ez'
-- SELECT * FROM artistas WHERE apellidos LIKE '%ez%';
