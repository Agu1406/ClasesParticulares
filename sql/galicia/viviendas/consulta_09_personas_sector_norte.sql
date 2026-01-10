-- ============================================
-- CONSULTA 9: Personas que habitan en el Sector Norte
-- ============================================
-- En esta consulta aprenderás a combinar múltiples JOINs con condiciones WHERE
-- para filtrar resultados basados en datos de tablas relacionadas.

USE viviendas;

-- ============================================
-- EXPLICACIÓN
-- ============================================
-- Necesitamos conectar tres tablas:
-- 1. personas -> habitar: para saber qué viviendas habitan
-- 2. habitar -> viviendas: para obtener datos de las viviendas
-- 3. Filtrar por nombre_zona = 'Sector Norte'

-- ============================================
-- SOLUCIÓN
-- ============================================
SELECT 
    p.nombre,
    p.apellidos,
    v.cod_vivienda,
    v.calle,
    v.numero,
    v.nombre_zona
FROM personas p
INNER JOIN habitar h ON p.dni = h.dni
INNER JOIN viviendas v ON h.cod_vivienda = v.cod_vivienda
WHERE v.nombre_zona = 'Sector Norte';

-- ============================================
-- EXPLICACIÓN: INNER JOIN vs LEFT JOIN
-- ============================================
-- Usamos INNER JOIN porque solo queremos personas que:
-- 1. Habiten alguna vivienda (tienen registro en habitar)
-- 2. Esa vivienda esté en el Sector Norte
-- 
-- Si usáramos LEFT JOIN, veríamos todas las personas y NULL
-- para las que no habitan en Sector Norte.

-- ============================================
-- RESULTADO ESPERADO
-- ============================================
-- Deberías ver solo las personas que habitan viviendas en el Sector Norte

-- ============================================
-- VARIACIONES PARA PRACTICAR
-- ============================================
-- Personas que habitan en el Centro o Sector Sur
-- SELECT p.nombre, p.apellidos, v.nombre_zona
-- FROM personas p
-- INNER JOIN habitar h ON p.dni = h.dni
-- INNER JOIN viviendas v ON h.cod_vivienda = v.cod_vivienda
-- WHERE v.nombre_zona IN ('Centro', 'Sector Sur');



