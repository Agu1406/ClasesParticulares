-- ============================================
-- CONSULTA 14: Nombre y apellidos de las personas que comenzaron a habitar
--             una vivienda un 30 de Octubre
-- ============================================
-- En esta consulta aprenderás a usar las funciones DAY() y MONTH()
-- para filtrar por día y mes específicos, independientemente del año.

USE viviendas;

-- ============================================
-- EXPLICACIÓN: Funciones DAY() y MONTH()
-- ============================================
-- DAY(fecha): extrae el día del mes (1-31)
-- MONTH(fecha): extrae el mes (1-12)
-- YEAR(fecha): extrae el año
-- 
-- Estas funciones permiten filtrar por partes específicas de una fecha

-- ============================================
-- SOLUCIÓN
-- ============================================
SELECT 
    p.nombre,
    p.apellidos,
    h.fecha_inicio,
    DAY(h.fecha_inicio) AS dia,
    MONTH(h.fecha_inicio) AS mes
FROM personas p
INNER JOIN habitar h ON p.dni = h.dni
WHERE DAY(h.fecha_inicio) = 30 
  AND MONTH(h.fecha_inicio) = 10;

-- ============================================
-- SOLUCIÓN ALTERNATIVA (usando DATE_FORMAT)
-- ============================================
-- SELECT 
--     p.nombre,
--     p.apellidos,
--     h.fecha_inicio
-- FROM personas p
-- INNER JOIN habitar h ON p.dni = h.dni
-- WHERE DATE_FORMAT(h.fecha_inicio, '%m-%d') = '10-30';

-- ============================================
-- RESULTADO ESPERADO
-- ============================================
-- Deberías ver las personas que comenzaron a habitar una vivienda
-- el día 30 de octubre de cualquier año

-- ============================================
-- VARIACIONES PARA PRACTICAR
-- ============================================
-- Personas que comenzaron a habitar en diciembre
-- SELECT p.nombre, p.apellidos, h.fecha_inicio
-- FROM personas p
-- INNER JOIN habitar h ON p.dni = h.dni
-- WHERE MONTH(h.fecha_inicio) = 12;

-- Personas que comenzaron a habitar el día 12 de cualquier mes
-- SELECT p.nombre, p.apellidos, h.fecha_inicio
-- FROM personas p
-- INNER JOIN habitar h ON p.dni = h.dni
-- WHERE DAY(h.fecha_inicio) = 12;



