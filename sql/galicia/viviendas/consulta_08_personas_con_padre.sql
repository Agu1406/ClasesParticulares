-- ============================================
-- CONSULTA 8: Mostrar las personas registradas y el nombre de su padre
--            (aunque no esté registrado)
-- ============================================
-- En esta consulta aprenderás a hacer un SELF JOIN (unión de una tabla consigo misma)
-- usando LEFT JOIN para incluir personas aunque su padre no esté registrado.

USE viviendas;

-- ============================================
-- EXPLICACIÓN: SELF JOIN
-- ============================================
-- Un SELF JOIN es cuando una tabla se une consigo misma.
-- Necesitamos usar alias diferentes para distinguir entre:
-- - La tabla de hijos (personas)
-- - La tabla de padres (también personas, pero con otro alias)
-- 
-- La columna dni_padre en la tabla personas referencia a otra fila
-- de la misma tabla personas.

-- ============================================
-- SOLUCIÓN CON SELF JOIN Y LEFT JOIN
-- ============================================
SELECT 
    hijo.nombre AS nombre_hijo,
    hijo.apellidos AS apellidos_hijo,
    padre.nombre AS nombre_padre,
    padre.apellidos AS apellidos_padre
FROM personas hijo
LEFT JOIN personas padre ON hijo.dni_padre = padre.dni;

-- ============================================
-- EXPLICACIÓN DE LOS ALIAS
-- ============================================
-- 'hijo' y 'padre' son alias para la misma tabla 'personas'
-- - hijo: representa a la persona (hijo)
-- - padre: representa al padre de esa persona
-- 
-- LEFT JOIN asegura que veamos todas las personas, incluso si
-- su padre no está registrado (dni_padre será NULL o no existirá)

-- ============================================
-- RESULTADO ESPERADO
-- ============================================
-- Deberías ver todas las personas con el nombre de su padre
-- (o NULL si el padre no está registrado)

-- ============================================
-- VARIACIONES PARA PRACTICAR
-- ============================================
-- Personas cuyo padre SÍ está registrado
-- SELECT hijo.nombre, hijo.apellidos, padre.nombre AS nombre_padre
-- FROM personas hijo
-- INNER JOIN personas padre ON hijo.dni_padre = padre.dni;



