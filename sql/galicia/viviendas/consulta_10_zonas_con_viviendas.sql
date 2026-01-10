-- ============================================
-- CONSULTA 10: Datos de las zonas y su descripción y código de las viviendas
--             que se encuentran en ella (con o sin viviendas registradas)
-- ============================================
-- En esta consulta aprenderás a usar RIGHT JOIN o cambiar el orden de las tablas
-- en LEFT JOIN para incluir todas las zonas, incluso si no tienen viviendas.

USE viviendas;

-- ============================================
-- EXPLICACIÓN: RIGHT JOIN
-- ============================================
-- RIGHT JOIN (o RIGHT OUTER JOIN) devuelve TODAS las filas de la tabla derecha
-- y las filas coincidentes de la tabla izquierda.
-- 
-- Es el opuesto de LEFT JOIN. Si no hay coincidencia, las columnas de la
-- tabla izquierda tendrán valores NULL.
-- 
-- NOTA: RIGHT JOIN es menos común que LEFT JOIN. Muchos desarrolladores
-- prefieren usar LEFT JOIN cambiando el orden de las tablas.

-- ============================================
-- SOLUCIÓN CON RIGHT JOIN
-- ============================================
SELECT 
    z.nombre_zona,
    z.descripcion,
    v.cod_vivienda
FROM viviendas v
RIGHT JOIN zonas z ON v.nombre_zona = z.nombre_zona;

-- ============================================
-- SOLUCIÓN ALTERNATIVA (con LEFT JOIN, más común)
-- ============================================
-- SELECT 
--     z.nombre_zona,
--     z.descripcion,
--     v.cod_vivienda
-- FROM zonas z
-- LEFT JOIN viviendas v ON z.nombre_zona = v.nombre_zona;

-- ============================================
-- RESULTADO ESPERADO
-- ============================================
-- Deberías ver todas las zonas con sus viviendas correspondientes
-- (o NULL en cod_vivienda si una zona no tiene viviendas registradas)

-- ============================================
-- VARIACIONES PARA PRACTICAR
-- ============================================
-- Zonas que NO tienen viviendas registradas
-- SELECT z.nombre_zona, z.descripcion
-- FROM zonas z
-- LEFT JOIN viviendas v ON z.nombre_zona = v.nombre_zona
-- WHERE v.cod_vivienda IS NULL;



