-- ============================================
-- CONSULTA 23: Nombres de los jefes de los artistas con primer apellido 'López'
-- ============================================
-- SELF JOIN en artistas. nif_jefe referencia a otro artista.
-- Nota: en la BD el apellido está como 'Lopez' (sin tilde).

USE circo;

-- ============================================
-- EXPLICACIÓN
-- ============================================
-- artistas tiene nif_jefe que referencia a otro artista (el jefe).
-- SELF JOIN: unir artistas consigo misma para obtener datos del jefe.
-- LIKE 'Lop%' o 'Lopez%' para coincidir con Lopez/López.

-- ============================================
-- SOLUCIÓN
-- ============================================
SELECT DISTINCT jefe.nombre AS nombre_jefe
FROM artistas emp
INNER JOIN artistas jefe ON emp.nif_jefe = jefe.Nif
WHERE emp.apellidos LIKE 'Lop%' OR emp.apellidos LIKE 'López%';

-- ============================================
-- RESULTADO ESPERADO
-- ============================================
-- Juan Lopez tiene nif_jefe 22222222B (Luis Sanchez). Luis Sanchez es el jefe.
-- Si buscamos "Lopez": Juan Lopez (11111111A) tiene jefe Luis Sanchez.
-- El resultado sería: Luis (nombre del jefe Luis Sanchez)

-- ============================================
-- VARIACIONES PARA PRACTICAR
-- ============================================
-- Incluir apellidos del jefe
-- SELECT jefe.nombre, jefe.apellidos FROM artistas emp INNER JOIN artistas jefe ON emp.nif_jefe = jefe.Nif WHERE emp.apellidos LIKE 'Lop%';
