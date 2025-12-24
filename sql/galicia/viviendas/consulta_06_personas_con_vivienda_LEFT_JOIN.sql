-- ============================================
-- CONSULTA 6: Nombre y apellidos de todas las personas (incluso aunque no habiten 
--            ninguna vivienda) y el código de la vivienda en donde viven
-- ============================================
-- En esta consulta aprenderás a usar LEFT JOIN para incluir todas las filas
-- de la tabla izquierda, incluso si no hay coincidencias en la tabla derecha.

USE viviendas;

-- ============================================
-- EXPLICACIÓN: LEFT JOIN
-- ============================================
-- LEFT JOIN (o LEFT OUTER JOIN) devuelve TODAS las filas de la tabla izquierda
-- y las filas coincidentes de la tabla derecha.
-- 
-- Si no hay coincidencia, las columnas de la tabla derecha tendrán valores NULL.
-- 
-- Diferencia con INNER JOIN:
-- - INNER JOIN: solo filas con coincidencia en ambas tablas
-- - LEFT JOIN: todas las filas de la tabla izquierda (con o sin coincidencia)

-- ============================================
-- SOLUCIÓN CON LEFT JOIN
-- ============================================
SELECT 
    p.nombre,
    p.apellidos,
    h.cod_vivienda
FROM personas p
LEFT JOIN habitar h ON p.dni = h.dni;

-- ============================================
-- EXPLICACIÓN DEL RESULTADO
-- ============================================
-- Verás todas las personas, incluso aquellas que no habitan ninguna vivienda.
-- Para esas personas, cod_vivienda será NULL.

-- ============================================
-- COMPARACIÓN: INNER JOIN vs LEFT JOIN
-- ============================================
-- Si usáramos INNER JOIN, solo veríamos personas que habitan viviendas:
-- SELECT p.nombre, p.apellidos, h.cod_vivienda
-- FROM personas p
-- INNER JOIN habitar h ON p.dni = h.dni;

-- ============================================
-- RESULTADO ESPERADO
-- ============================================
-- Deberías ver todas las personas con su código de vivienda (o NULL si no habitan)

-- ============================================
-- VARIACIONES PARA PRACTICAR
-- ============================================
-- Personas que NO habitan ninguna vivienda
-- SELECT p.nombre, p.apellidos
-- FROM personas p
-- LEFT JOIN habitar h ON p.dni = h.dni
-- WHERE h.cod_vivienda IS NULL;



