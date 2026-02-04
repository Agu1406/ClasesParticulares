-- ============================================
-- CONSULTA 47: Artistas cuyo jefe comenzó a actuar en el año 2000
-- ============================================
-- SELF JOIN artistas. El jefe (nif_jefe) debe tener fecha_inicio en 2000 en artista_atraccion.

USE circo;

-- ============================================
-- EXPLICACIÓN
-- ============================================
-- artistas.nif_jefe referencia al jefe.
-- artista_atraccion tiene fecha_inicio por artista.
-- El jefe debe tener alguna fecha_inicio en 2000.

-- ============================================
-- SOLUCIÓN
-- ============================================
SELECT DISTINCT emp.nombre, emp.apellidos
FROM artistas emp
INNER JOIN artistas jefe ON emp.nif_jefe = jefe.Nif
INNER JOIN artista_atraccion aa ON jefe.Nif = aa.nif
WHERE YEAR(aa.fecha_inicio) = 2000;

-- ============================================
-- RESULTADO ESPERADO
-- ============================================
-- Jefes: 22222222B (Luis Sanchez) empezó 1999-11-01, no 2000.
-- 11111111A (Juan Lopez) es jefe de 55555E, 6655555E, 77777e. Juan empezó en Las jirafas 2000-04-01.
-- Empleados cuyo jefe empezó en 2000: los que tienen nif_jefe = 11111111A (Juan Lopez).

-- ============================================
-- VARIACIONES PARA PRACTICAR
-- ============================================
-- Incluir nombre del jefe
-- SELECT emp.nombre, emp.apellidos, jefe.nombre AS jefe_nombre FROM artistas emp INNER JOIN artistas jefe ON emp.nif_jefe = jefe.Nif INNER JOIN artista_atraccion aa ON jefe.Nif = aa.nif WHERE YEAR(aa.fecha_inicio) = 2000;
