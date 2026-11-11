/*
OBJETIVO: Practica Galicia UT3 (JOIN). Origen banco galicia/.
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
*/

-- Origen: galicia/circo/consulta_21_artistas_actuado_atraccion_trabajando.sql

-- ============================================
-- CONSULTA 21: Artistas que han actuado en alguna atracción y siguen trabajando en ella, ordenados por apellidos y nombre
-- ============================================
-- artista_atraccion con fecha_fin NULL. Orden alfabético.

USE circo;

-- ============================================
-- EXPLICACIÓN
-- ============================================
-- fecha_fin IS NULL indica que el artista sigue en esa atracción.
-- JOIN con artistas para obtener nombre y apellidos.

-- ============================================
-- SOLUCIÓN
-- ============================================
SELECT DISTINCT ar.nombre, ar.apellidos
FROM artistas ar
INNER JOIN artista_atraccion aa ON ar.Nif = aa.nif
WHERE aa.fecha_fin IS NULL
ORDER BY ar.apellidos, ar.nombre;

-- ============================================
-- RESULTADO ESPERADO
-- ============================================
-- Juan Flórez, Juan Lopez, Carlos Perez, Luis Sanchez (ordenados por apellidos)

-- ============================================
-- VARIACIONES PARA PRACTICAR
-- ============================================
-- Incluir nombre de la atracción donde trabajan
-- SELECT ar.nombre, ar.apellidos, aa.nombre_atraccion FROM artistas ar INNER JOIN artista_atraccion aa ON ar.Nif = aa.nif WHERE aa.fecha_fin IS NULL;
