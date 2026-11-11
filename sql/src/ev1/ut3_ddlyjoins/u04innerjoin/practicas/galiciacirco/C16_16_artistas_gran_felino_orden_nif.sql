/*
OBJETIVO: Practica Galicia UT3 (JOIN). Origen banco galicia/.
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
*/

-- Origen: galicia/circo/consulta_16_artistas_gran_felino_orden_nif.sql

-- ============================================
-- CONSULTA 16: Artistas que trabajan en 'El gran felino' ordenados por NIF descendente
-- ============================================
-- JOIN con artista_atraccion y ORDER BY DESC.

USE circo;

-- ============================================
-- EXPLICACIÓN
-- ============================================
-- artista_atraccion tiene nif y nombre_atraccion.
-- ORDER BY nif DESC ordena de mayor a menor (Z antes que A en caracteres).
-- Incluir solo los que siguen trabajando (fecha_fin NULL) o todos los que han trabajado?

-- ============================================
-- SOLUCIÓN
-- ============================================
SELECT a.Nif, a.nombre, a.apellidos
FROM artistas a
INNER JOIN artista_atraccion aa ON a.Nif = aa.nif
WHERE aa.nombre_atraccion = 'El gran felino'
ORDER BY a.Nif DESC;

-- ============================================
-- RESULTADO ESPERADO
-- ============================================
-- 22222222B (Luis Sanchez), 11111111A (Juan Lopez) - ordenados por NIF descendente

-- ============================================
-- VARIACIONES PARA PRACTICAR
-- ============================================
-- Orden ascendente por apellidos
-- SELECT a.* FROM artistas a INNER JOIN artista_atraccion aa ON a.Nif = aa.nif WHERE aa.nombre_atraccion = 'El gran felino' ORDER BY a.apellidos ASC;
