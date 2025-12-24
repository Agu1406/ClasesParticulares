-- ============================================
-- CONSULTA 15: Nombre y apellidos de las personas ordenadas por la fecha
--             en que empezaron a habitar una vivienda
-- ============================================
-- En esta consulta aprenderás a ordenar resultados por fechas
-- usando ORDER BY con columnas de fecha.

USE viviendas;

-- ============================================
-- EXPLICACIÓN
-- ============================================
-- ORDER BY puede ordenar por columnas de fecha.
-- Las fechas se ordenan cronológicamente:
-- - ASC: de más antigua a más reciente
-- - DESC: de más reciente a más antigua

-- ============================================
-- SOLUCIÓN (orden ascendente: más antiguas primero)
-- ============================================
SELECT 
    p.nombre,
    p.apellidos,
    h.fecha_inicio
FROM personas p
INNER JOIN habitar h ON p.dni = h.dni
ORDER BY h.fecha_inicio ASC;

-- ============================================
-- SOLUCIÓN ALTERNATIVA (orden descendente: más recientes primero)
-- ============================================
-- SELECT 
--     p.nombre,
--     p.apellidos,
--     h.fecha_inicio
-- FROM personas p
-- INNER JOIN habitar h ON p.dni = h.dni
-- ORDER BY h.fecha_inicio DESC;

-- ============================================
-- RESULTADO ESPERADO
-- ============================================
-- Deberías ver las personas ordenadas por fecha_inicio
-- (de más antigua a más reciente)

-- ============================================
-- VARIACIONES PARA PRACTICAR
-- ============================================
-- Personas ordenadas por fecha de inicio (más recientes primero)
-- y luego por apellidos
-- SELECT p.nombre, p.apellidos, h.fecha_inicio
-- FROM personas p
-- INNER JOIN habitar h ON p.dni = h.dni
-- ORDER BY h.fecha_inicio DESC, p.apellidos ASC;



