-- ============================================
-- CONSULTA 18: Viviendas (indicando su calle y número) donde vive alguien
--             cuyo padre también está registrado en la base de datos
-- ============================================
-- En esta consulta aprenderás a combinar múltiples JOINs incluyendo
-- un SELF JOIN para verificar relaciones entre personas.

USE viviendas;

-- ============================================
-- EXPLICACIÓN
-- ============================================
-- Necesitamos:
-- 1. Obtener viviendas donde habitan personas
-- 2. Verificar que esas personas tengan un padre registrado
-- 3. Usar SELF JOIN en personas para verificar que el padre existe

-- ============================================
-- SOLUCIÓN
-- ============================================
SELECT DISTINCT
    v.cod_vivienda,
    v.calle,
    v.numero,
    p.nombre AS nombre_hijo,
    p.apellidos AS apellidos_hijo,
    padre.nombre AS nombre_padre,
    padre.apellidos AS apellidos_padre
FROM viviendas v
INNER JOIN habitar h ON v.cod_vivienda = h.cod_vivienda
INNER JOIN personas p ON h.dni = p.dni
INNER JOIN personas padre ON p.dni_padre = padre.dni;

-- ============================================
-- EXPLICACIÓN: Múltiples JOINs complejos
-- ============================================
-- Esta consulta combina:
-- 1. JOIN normal: viviendas -> habitar -> personas (hijo)
-- 2. SELF JOIN: personas (hijo) -> personas (padre)
-- 
-- El INNER JOIN con padre asegura que solo veamos personas
-- cuyo padre SÍ está registrado (dni_padre existe y coincide)

-- ============================================
-- RESULTADO ESPERADO
-- ============================================
-- Deberías ver las viviendas donde habitan personas cuyo padre
-- también está registrado en la base de datos

-- ============================================
-- VARIACIONES PARA PRACTICAR
-- ============================================
-- Viviendas donde vive alguien cuyo padre NO está registrado
-- SELECT DISTINCT v.cod_vivienda, v.calle, v.numero, p.nombre, p.apellidos
-- FROM viviendas v
-- INNER JOIN habitar h ON v.cod_vivienda = h.cod_vivienda
-- INNER JOIN personas p ON h.dni = p.dni
-- LEFT JOIN personas padre ON p.dni_padre = padre.dni
-- WHERE padre.dni IS NULL;



