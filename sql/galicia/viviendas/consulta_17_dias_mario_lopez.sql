-- ============================================
-- CONSULTA 17: Calcular cuántos días lleva Mario López viviendo en su vivienda
-- ============================================
-- En esta consulta aprenderás a usar DATEDIFF() para calcular
-- la diferencia en días entre dos fechas.

USE viviendas;

-- ============================================
-- EXPLICACIÓN: DATEDIFF()
-- ============================================
-- DATEDIFF(fecha1, fecha2): calcula la diferencia en días
-- entre fecha1 y fecha2
-- 
-- Resultado positivo si fecha1 > fecha2
-- Resultado negativo si fecha1 < fecha2
-- 
-- Diferencia con TIMESTAMPDIFF:
-- - DATEDIFF: siempre devuelve días
-- - TIMESTAMPDIFF: permite especificar la unidad (YEAR, MONTH, DAY, etc.)

-- ============================================
-- SOLUCIÓN
-- ============================================
SELECT 
    p.nombre,
    p.apellidos,
    h.fecha_inicio,
    CURDATE() AS fecha_actual,
    DATEDIFF(CURDATE(), h.fecha_inicio) AS dias_habitando
FROM personas p
INNER JOIN habitar h ON p.dni = h.dni
WHERE p.nombre = 'Mario' 
  AND p.apellidos = 'Lopez B';

-- ============================================
-- SOLUCIÓN ALTERNATIVA (usando LIKE para apellidos)
-- ============================================
-- SELECT 
--     p.nombre,
--     p.apellidos,
--     h.fecha_inicio,
--     DATEDIFF(CURDATE(), h.fecha_inicio) AS dias_habitando
-- FROM personas p
-- INNER JOIN habitar h ON p.dni = h.dni
-- WHERE p.nombre = 'Mario' 
--   AND p.apellidos LIKE 'Lopez%';

-- ============================================
-- RESULTADO ESPERADO
-- ============================================
-- Deberías ver a Mario López con el número de días que lleva
-- habitando su vivienda

-- ============================================
-- VARIACIONES PARA PRACTICAR
-- ============================================
-- Días que lleva cada persona habitando su vivienda
-- SELECT p.nombre, p.apellidos,
--        DATEDIFF(CURDATE(), h.fecha_inicio) AS dias_habitando
-- FROM personas p
-- INNER JOIN habitar h ON p.dni = h.dni
-- ORDER BY dias_habitando DESC;



