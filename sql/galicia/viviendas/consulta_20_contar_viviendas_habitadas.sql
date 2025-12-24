-- ============================================
-- CONSULTA 20: Mostrar cuántas viviendas están registradas como habitadas
-- ============================================
-- En esta consulta aprenderás a usar funciones de agregación como COUNT()
-- para contar registros.

USE viviendas;

-- ============================================
-- EXPLICACIÓN: Funciones de agregación
-- ============================================
-- COUNT(): cuenta el número de filas
-- COUNT(DISTINCT columna): cuenta valores únicos
-- SUM(): suma valores
-- AVG(): calcula el promedio
-- MAX(): valor máximo
-- MIN(): valor mínimo
-- 
-- Cuando usas funciones de agregación, normalmente no necesitas
-- otras columnas en SELECT (a menos que uses GROUP BY)

-- ============================================
-- SOLUCIÓN CON COUNT(*)
-- ============================================
SELECT COUNT(DISTINCT cod_vivienda) AS total_viviendas_habitadas
FROM habitar;

-- ============================================
-- EXPLICACIÓN: COUNT(*) vs COUNT(DISTINCT)
-- ============================================
-- COUNT(*): cuenta todas las filas
-- COUNT(cod_vivienda): cuenta filas donde cod_vivienda no es NULL
-- COUNT(DISTINCT cod_vivienda): cuenta valores únicos de cod_vivienda
-- 
-- Usamos DISTINCT porque una vivienda puede estar habitada por
-- múltiples personas (aunque en este caso no parece ser así)

-- ============================================
-- SOLUCIÓN ALTERNATIVA (más explícita)
-- ============================================
-- SELECT COUNT(*) AS total_viviendas_habitadas
-- FROM (
--     SELECT DISTINCT cod_vivienda
--     FROM habitar
-- ) AS viviendas_habitadas;

-- ============================================
-- RESULTADO ESPERADO
-- ============================================
-- Deberías ver un número que indica cuántas viviendas diferentes
-- están registradas como habitadas

-- ============================================
-- VARIACIONES PARA PRACTICAR
-- ============================================
-- Total de personas que habitan viviendas
-- SELECT COUNT(*) AS total_personas_habitando
-- FROM habitar;

-- Total de viviendas (habitadas y no habitadas)
-- SELECT COUNT(*) AS total_viviendas
-- FROM viviendas;



