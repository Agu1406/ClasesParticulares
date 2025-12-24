-- ============================================
-- CONSULTA 5: Mostrar viviendas y la descripción de su zona
-- ============================================
-- En esta consulta aprenderás a hacer un JOIN entre dos tablas
-- para combinar información relacionada.

USE viviendas;

-- ============================================
-- EXPLICACIÓN: INNER JOIN
-- ============================================
-- JOIN (o INNER JOIN) combina filas de dos o más tablas
-- basándose en una condición de relación entre ellas.
-- 
-- Solo muestra filas donde hay coincidencia en ambas tablas.
-- 
-- Sintaxis:
-- SELECT columnas
-- FROM tabla1
-- INNER JOIN tabla2 ON tabla1.columna = tabla2.columna

-- ============================================
-- SOLUCIÓN CON INNER JOIN
-- ============================================
SELECT 
    v.cod_vivienda,
    v.calle,
    v.numero,
    v.piso,
    v.puerta,
    v.nombre_zona,
    z.descripcion AS descripcion_zona
FROM viviendas v
INNER JOIN zonas z ON v.nombre_zona = z.nombre_zona;

-- ============================================
-- EXPLICACIÓN DE ALIAS
-- ============================================
-- 'v' y 'z' son alias (nombres cortos) para las tablas
-- Esto hace el código más legible y permite usar la misma tabla
-- múltiples veces si es necesario.
-- 
-- También puedes usar AS para alias de columnas:
-- z.descripcion AS descripcion_zona

-- ============================================
-- SOLUCIÓN ALTERNATIVA (sin alias)
-- ============================================
-- SELECT 
--     viviendas.cod_vivienda,
--     viviendas.calle,
--     viviendas.numero,
--     viviendas.piso,
--     viviendas.puerta,
--     viviendas.nombre_zona,
--     zonas.descripcion AS descripcion_zona
-- FROM viviendas
-- INNER JOIN zonas ON viviendas.nombre_zona = zonas.nombre_zona;

-- ============================================
-- RESULTADO ESPERADO
-- ============================================
-- Deberías ver todas las viviendas con su descripción de zona correspondiente

-- ============================================
-- VARIACIONES PARA PRACTICAR
-- ============================================
-- Viviendas del Centro con su descripción
-- SELECT v.*, z.descripcion 
-- FROM viviendas v
-- INNER JOIN zonas z ON v.nombre_zona = z.nombre_zona
-- WHERE v.nombre_zona = 'Centro';



