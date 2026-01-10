-- ============================================
-- CONSULTA 11: Personas que comenzaron a habitar viviendas (mostrar su nombre 
--             y apellidos) si empezaron a habitarla entre 1985 y 1995
-- ============================================
-- En esta consulta aprenderás a filtrar por rangos de fechas usando
-- funciones de fecha y operadores de comparación.

USE viviendas;

-- ============================================
-- EXPLICACIÓN
-- ============================================
-- Necesitamos:
-- 1. Obtener datos de personas desde la tabla habitar
-- 2. Filtrar por fecha_inicio entre 1985 y 1995
-- 3. Usar YEAR() o comparar fechas directamente

-- ============================================
-- SOLUCIÓN CON YEAR()
-- ============================================
SELECT DISTINCT
    p.nombre,
    p.apellidos,
    h.fecha_inicio,
    YEAR(h.fecha_inicio) AS año_inicio
FROM personas p
INNER JOIN habitar h ON p.dni = h.dni
WHERE YEAR(h.fecha_inicio) BETWEEN 1985 AND 1995;

-- ============================================
-- EXPLICACIÓN: DISTINCT
-- ============================================
-- DISTINCT elimina filas duplicadas del resultado.
-- Si una persona habitó múltiples viviendas en ese período,
-- sin DISTINCT aparecería varias veces.

-- ============================================
-- SOLUCIÓN ALTERNATIVA (comparando fechas directamente)
-- ============================================
-- SELECT DISTINCT
--     p.nombre,
--     p.apellidos,
--     h.fecha_inicio
-- FROM personas p
-- INNER JOIN habitar h ON p.dni = h.dni
-- WHERE h.fecha_inicio >= '1985-01-01' 
--   AND h.fecha_inicio < '1996-01-01';

-- ============================================
-- RESULTADO ESPERADO
-- ============================================
-- Deberías ver las personas que comenzaron a habitar viviendas
-- entre 1985 y 1995

-- ============================================
-- VARIACIONES PARA PRACTICAR
-- ============================================
-- Personas que comenzaron a habitar en octubre de cualquier año
-- SELECT p.nombre, p.apellidos, h.fecha_inicio
-- FROM personas p
-- INNER JOIN habitar h ON p.dni = h.dni
-- WHERE MONTH(h.fecha_inicio) = 10;



