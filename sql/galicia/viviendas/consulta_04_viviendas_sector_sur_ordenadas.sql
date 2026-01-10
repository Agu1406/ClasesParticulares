-- ============================================
-- CONSULTA 4: Mostrar las viviendas del Sector Sur ordenadas por piso
-- ============================================
-- En esta consulta aprenderás a usar ORDER BY para ordenar los resultados
-- de una consulta.

USE viviendas;

-- ============================================
-- EXPLICACIÓN
-- ============================================
-- ORDER BY: ordena los resultados de la consulta
-- ASC: orden ascendente (de menor a mayor) - es el predeterminado
-- DESC: orden descendente (de mayor a menor)
-- 
-- Puedes ordenar por múltiples columnas:
-- ORDER BY columna1 ASC, columna2 DESC

-- ============================================
-- SOLUCIÓN
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
WHERE nombre_zona = 'Sector Sur'
ORDER BY piso ASC;

-- ============================================
-- SOLUCIÓN ALTERNATIVA (ordenando por piso y luego por puerta)
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
-- WHERE nombre_zona = 'Sector Sur'
-- ORDER BY piso ASC, puerta ASC;

-- ============================================
-- RESULTADO ESPERADO
-- ============================================
-- Deberías ver las viviendas del Sector Sur ordenadas por piso
-- (primero piso 1, luego piso 2, luego piso 3)

-- ============================================
-- VARIACIONES PARA PRACTICAR
-- ============================================
-- Viviendas del Sector Sur ordenadas por metros (de mayor a menor)
-- SELECT * FROM viviendas 
-- WHERE nombre_zona = 'Sector Sur' 
-- ORDER BY metros DESC;

-- Todas las viviendas ordenadas por zona y luego por metros
-- SELECT * FROM viviendas 
-- ORDER BY nombre_zona ASC, metros DESC;

