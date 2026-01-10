-- ============================================
-- CONSULTA 3: Viviendas construidas antes del año 1986
-- ============================================
-- En esta consulta aprenderás a trabajar con fechas usando la función YEAR()
-- y operadores de comparación con fechas.

USE viviendas;

-- ============================================
-- EXPLICACIÓN
-- ============================================
-- YEAR(fecha): extrae el año de una fecha
-- También puedes comparar fechas directamente:
--   fecha_construccion < '1986-01-01'
--   fecha_construccion < DATE('1986-01-01')

-- ============================================
-- SOLUCIÓN CON YEAR()
-- ============================================
SELECT 
    cod_vivienda,
    calle,
    numero,
    piso,
    puerta,
    fecha_construccion,
    YEAR(fecha_construccion) AS año_construccion
FROM viviendas
WHERE YEAR(fecha_construccion) < 1986;

-- ============================================
-- SOLUCIÓN ALTERNATIVA (comparando fechas directamente)
-- ============================================
-- SELECT 
--     cod_vivienda,
--     calle,
--     numero,
--     piso,
--     puerta,
--     fecha_construccion
-- FROM viviendas
-- WHERE fecha_construccion < '1986-01-01';

-- ============================================
-- RESULTADO ESPERADO
-- ============================================
-- Deberías ver las viviendas construidas antes de 1986
-- (20000 construida en 1974, 20001 construida en 1984)

-- ============================================
-- VARIACIONES PARA PRACTICAR
-- ============================================
-- Viviendas construidas en el año 1987
-- SELECT * FROM viviendas WHERE YEAR(fecha_construccion) = 1987;

-- Viviendas construidas entre 1985 y 1990
-- SELECT * FROM viviendas 
-- WHERE YEAR(fecha_construccion) BETWEEN 1985 AND 1990;



