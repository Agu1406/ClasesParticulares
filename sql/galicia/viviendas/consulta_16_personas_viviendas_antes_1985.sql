-- ============================================
-- CONSULTA 16: Nombre y apellidos de las personas que viven en viviendas
--             construidas antes del año 1985
-- ============================================
-- En esta consulta aprenderás a combinar múltiples tablas y filtrar
-- por condiciones en tablas relacionadas.

USE viviendas;

-- ============================================
-- EXPLICACIÓN
-- ============================================
-- Necesitamos conectar tres tablas:
-- 1. personas -> habitar: para saber qué viviendas habitan
-- 2. habitar -> viviendas: para obtener fecha_construccion
-- 3. Filtrar por YEAR(fecha_construccion) < 1985

-- ============================================
-- SOLUCIÓN
-- ============================================
SELECT 
    p.nombre,
    p.apellidos,
    v.cod_vivienda,
    v.calle,
    v.numero,
    v.fecha_construccion,
    YEAR(v.fecha_construccion) AS año_construccion
FROM personas p
INNER JOIN habitar h ON p.dni = h.dni
INNER JOIN viviendas v ON h.cod_vivienda = v.cod_vivienda
WHERE YEAR(v.fecha_construccion) < 1985;

-- ============================================
-- EXPLICACIÓN: Múltiples JOINs con filtros
-- ============================================
-- Cuando necesitas datos de múltiples tablas relacionadas:
-- 1. Identifica las tablas necesarias
-- 2. Identifica cómo se relacionan (claves foráneas)
-- 3. Haz los JOINs necesarios
-- 4. Aplica filtros WHERE según sea necesario

-- ============================================
-- RESULTADO ESPERADO
-- ============================================
-- Deberías ver las personas que habitan viviendas construidas antes de 1985

-- ============================================
-- VARIACIONES PARA PRACTICAR
-- ============================================
-- Personas que viven en viviendas construidas entre 1985 y 1990
-- SELECT p.nombre, p.apellidos, v.fecha_construccion
-- FROM personas p
-- INNER JOIN habitar h ON p.dni = h.dni
-- INNER JOIN viviendas v ON h.cod_vivienda = v.cod_vivienda
-- WHERE YEAR(v.fecha_construccion) BETWEEN 1985 AND 1990;



