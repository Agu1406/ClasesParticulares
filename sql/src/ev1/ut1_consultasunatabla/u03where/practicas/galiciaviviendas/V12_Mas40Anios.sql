/*
OBJETIVO: Practica Galicia UT1 (origen viviendas/consulta_12_viviendas_mas_40_años.sql).
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
*/

-- Origen: galicia/viviendas/consulta_12_viviendas_mas_40_años.sql
-- Nivel UT1: una tabla. No uses JOIN.

-- ============================================
-- CONSULTA 12: Mostrar las viviendas y su fecha de construcción si han sido
--             construidas hace más de 40 años
-- ============================================
-- En esta consulta aprenderás a calcular diferencias de tiempo usando
-- funciones como TIMESTAMPDIFF() o DATEDIFF() y comparar con la fecha actual.

USE viviendas;

-- ============================================
-- EXPLICACIÓN: Funciones de fecha
-- ============================================
-- CURDATE(): devuelve la fecha actual
-- NOW(): devuelve la fecha y hora actual
-- TIMESTAMPDIFF(unit, date1, date2): diferencia entre dos fechas
--   unit puede ser: YEAR, MONTH, DAY, etc.
-- DATEDIFF(date1, date2): diferencia en días entre dos fechas

-- ============================================
-- SOLUCIÓN CON TIMESTAMPDIFF
-- ============================================
SELECT 
    cod_vivienda,
    calle,
    numero,
    piso,
    puerta,
    fecha_construccion,
    TIMESTAMPDIFF(YEAR, fecha_construccion, CURDATE()) AS años_antiguedad
FROM viviendas
WHERE TIMESTAMPDIFF(YEAR, fecha_construccion, CURDATE()) > 40;

-- ============================================
-- SOLUCIÓN ALTERNATIVA (calculando año límite)
-- ============================================
-- SELECT 
--     cod_vivienda,
--     calle,
--     numero,
--     piso,
--     puerta,
--     fecha_construccion,
--     YEAR(fecha_construccion) AS año_construccion
-- FROM viviendas
-- WHERE YEAR(fecha_construccion) < YEAR(CURDATE()) - 40;

-- ============================================
-- RESULTADO ESPERADO
-- ============================================
-- Deberías ver las viviendas construidas hace más de 40 años
-- (considerando la fecha actual)

-- ============================================
-- VARIACIONES PARA PRACTICAR
-- ============================================
-- Viviendas construidas hace entre 30 y 50 años
-- SELECT *, TIMESTAMPDIFF(YEAR, fecha_construccion, CURDATE()) AS años
-- FROM viviendas
-- WHERE TIMESTAMPDIFF(YEAR, fecha_construccion, CURDATE()) BETWEEN 30 AND 50;



