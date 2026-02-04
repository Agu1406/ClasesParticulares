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
