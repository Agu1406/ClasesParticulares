-- ============================================
-- CONSULTA 13: Nombre y apellidos de las personas que llevan más de 20 años
--             habitando su vivienda
-- ============================================
-- En esta consulta aprenderás a calcular el tiempo transcurrido desde
-- una fecha hasta la actualidad usando TIMESTAMPDIFF.

USE viviendas;

-- ============================================
-- EXPLICACIÓN
-- ============================================
-- Necesitamos:
-- 1. Unir personas con habitar para obtener fecha_inicio
-- 2. Calcular cuántos años han pasado desde fecha_inicio hasta hoy
-- 3. Filtrar por más de 20 años

-- ============================================
-- SOLUCIÓN
-- ============================================
SELECT 
    p.nombre,
    p.apellidos,
    h.fecha_inicio,
    TIMESTAMPDIFF(YEAR, h.fecha_inicio, CURDATE()) AS años_habitando
FROM personas p
INNER JOIN habitar h ON p.dni = h.dni
WHERE TIMESTAMPDIFF(YEAR, h.fecha_inicio, CURDATE()) > 20;

-- ============================================
-- EXPLICACIÓN: TIMESTAMPDIFF
-- ============================================
-- TIMESTAMPDIFF(YEAR, fecha_inicio, CURDATE())
-- Calcula la diferencia en años entre fecha_inicio y la fecha actual.
-- 
-- Si fecha_inicio es '1985-12-11' y hoy es 2024:
-- Resultado: 39 años (aproximadamente)

-- ============================================
-- RESULTADO ESPERADO
-- ============================================
-- Deberías ver las personas que llevan más de 20 años habitando
-- su vivienda actual

-- ============================================
-- VARIACIONES PARA PRACTICAR
-- ============================================
-- Personas que llevan exactamente entre 20 y 30 años habitando
-- SELECT p.nombre, p.apellidos, 
--        TIMESTAMPDIFF(YEAR, h.fecha_inicio, CURDATE()) AS años
-- FROM personas p
-- INNER JOIN habitar h ON p.dni = h.dni
-- WHERE TIMESTAMPDIFF(YEAR, h.fecha_inicio, CURDATE()) BETWEEN 20 AND 30;



