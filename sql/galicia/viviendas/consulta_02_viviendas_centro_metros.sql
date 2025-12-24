-- ============================================
-- CONSULTA 2: Mostrar las viviendas de la zona Centro con metros entre 70 y 90
-- ============================================
-- En esta consulta aprenderás a usar múltiples condiciones en WHERE
-- usando operadores lógicos (AND) y comparaciones de rangos.

USE viviendas;

-- ============================================
-- EXPLICACIÓN
-- ============================================
-- AND: ambas condiciones deben cumplirse
-- OR: al menos una condición debe cumplirse
-- BETWEEN: permite buscar valores en un rango (inclusive)
-- 
-- Opciones para rangos:
-- 1. metros BETWEEN 70 AND 90  (incluye 70 y 90)
-- 2. metros >= 70 AND metros <= 90  (equivalente)

-- ============================================
-- SOLUCIÓN CON BETWEEN
-- ============================================
SELECT 
    cod_vivienda,
    calle,
    numero,
    piso,
    puerta,
    metros,
    nombre_zona
FROM viviendas
WHERE nombre_zona = 'Centro'
  AND metros BETWEEN 70 AND 90;

-- ============================================
-- SOLUCIÓN ALTERNATIVA (sin BETWEEN)
-- ============================================
-- SELECT 
--     cod_vivienda,
--     calle,
--     numero,
--     piso,
--     puerta,
--     metros,
--     nombre_zona
-- FROM viviendas
-- WHERE nombre_zona = 'Centro'
--   AND metros >= 70 
--   AND metros <= 90;

-- ============================================
-- RESULTADO ESPERADO
-- ============================================
-- Deberías ver las viviendas del Centro que tienen entre 70 y 90 metros
-- (30000 y 30001)

-- ============================================
-- VARIACIONES PARA PRACTICAR
-- ============================================
-- Viviendas del Centro con más de 80 metros
-- SELECT * FROM viviendas WHERE nombre_zona = 'Centro' AND metros > 80;

-- Viviendas del Centro o Sector Norte con más de 75 metros
-- SELECT * FROM viviendas 
-- WHERE (nombre_zona = 'Centro' OR nombre_zona = 'Sector Norte') 
--   AND metros > 75;



