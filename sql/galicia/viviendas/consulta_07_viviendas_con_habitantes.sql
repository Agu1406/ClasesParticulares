-- ============================================
-- CONSULTA 7: Mostrar todas las viviendas y quien vive en ellas
-- ============================================
-- En esta consulta aprenderás a usar LEFT JOIN desde la perspectiva
-- de la tabla viviendas para mostrar todas las viviendas, incluso
-- si no están habitadas.

USE viviendas;

-- ============================================
-- EXPLICACIÓN
-- ============================================
-- Esta consulta es similar a la anterior, pero ahora queremos ver
-- TODAS las viviendas (tabla izquierda) y sus habitantes (tabla derecha).
-- 
-- Usamos LEFT JOIN porque queremos ver viviendas aunque no tengan habitantes.

-- ============================================
-- SOLUCIÓN CON LEFT JOIN
-- ============================================
SELECT 
    v.cod_vivienda,
    v.calle,
    v.numero,
    v.piso,
    v.puerta,
    p.nombre,
    p.apellidos
FROM viviendas v
LEFT JOIN habitar h ON v.cod_vivienda = h.cod_vivienda
LEFT JOIN personas p ON h.dni = p.dni;

-- ============================================
-- EXPLICACIÓN: MÚLTIPLES JOINs
-- ============================================
-- Necesitamos dos JOINs porque:
-- 1. viviendas -> habitar: para saber quién habita cada vivienda
-- 2. habitar -> personas: para obtener los datos de las personas
-- 
-- La tabla 'habitar' es una tabla intermedia (tabla de relación)
-- que conecta viviendas con personas.

-- ============================================
-- RESULTADO ESPERADO
-- ============================================
-- Deberías ver todas las viviendas con el nombre y apellidos de
-- sus habitantes (o NULL si la vivienda no está habitada)

-- ============================================
-- VARIACIONES PARA PRACTICAR
-- ============================================
-- Viviendas que NO están habitadas
-- SELECT v.*
-- FROM viviendas v
-- LEFT JOIN habitar h ON v.cod_vivienda = h.cod_vivienda
-- WHERE h.dni IS NULL;



