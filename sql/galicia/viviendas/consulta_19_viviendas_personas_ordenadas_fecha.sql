-- ============================================
-- CONSULTA 19: Mostrar las viviendas y el nombre y apellidos de las personas
--             que las habitan ordenadas por fecha de inicio
-- ============================================
-- En esta consulta aprenderás a combinar JOINs con ORDER BY
-- para ordenar resultados complejos.

USE viviendas;

-- ============================================
-- EXPLICACIÓN
-- ============================================
-- Necesitamos:
-- 1. Obtener todas las viviendas con sus habitantes
-- 2. Incluir la fecha_inicio de la relación habitar
-- 3. Ordenar por fecha_inicio

-- ============================================
-- SOLUCIÓN
-- ============================================
SELECT 
    v.cod_vivienda,
    v.calle,
    v.numero,
    v.piso,
    v.puerta,
    p.nombre,
    p.apellidos,
    h.fecha_inicio
FROM viviendas v
INNER JOIN habitar h ON v.cod_vivienda = h.cod_vivienda
INNER JOIN personas p ON h.dni = p.dni
ORDER BY h.fecha_inicio ASC;

-- ============================================
-- EXPLICACIÓN: Ordenar por fecha
-- ============================================
-- ORDER BY fecha_inicio ASC ordena de más antigua a más reciente.
-- Si queremos ver primero las más recientes, usamos DESC.

-- ============================================
-- RESULTADO ESPERADO
-- ============================================
-- Deberías ver todas las viviendas habitadas con sus habitantes,
-- ordenadas por la fecha en que comenzaron a habitarlas
-- (de más antigua a más reciente)

-- ============================================
-- VARIACIONES PARA PRACTICAR
-- ============================================
-- Viviendas y habitantes ordenadas por fecha (más recientes primero)
-- y luego por apellidos
-- SELECT v.*, p.nombre, p.apellidos, h.fecha_inicio
-- FROM viviendas v
-- INNER JOIN habitar h ON v.cod_vivienda = h.cod_vivienda
-- INNER JOIN personas p ON h.dni = p.dni
-- ORDER BY h.fecha_inicio DESC, p.apellidos ASC;



