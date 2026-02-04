-- ============================================
-- CONSULTA 34: Crear tabla artistas_antiguos e insertar artistas con fecha_inicio anterior a 1999
-- ============================================
-- CREATE TABLE y INSERT ... SELECT. La fecha está en artista_atraccion.

USE circo;

-- ============================================
-- EXPLICACIÓN
-- ============================================
-- artista_atraccion tiene fecha_inicio por artista y atracción.
-- Un artista es "antiguo" si alguna de sus fechas_inicio es anterior a 1999.
-- Creamos tabla con estructura similar a artistas e insertamos los que cumplen.

-- ============================================
-- SOLUCIÓN
-- ============================================
CREATE TABLE artistas_antiguos (
    Nif CHAR(9) PRIMARY KEY,
    apellidos CHAR(30),
    nombre CHAR(15),
    nif_jefe CHAR(9)
);

INSERT INTO artistas_antiguos (Nif, apellidos, nombre, nif_jefe)
SELECT DISTINCT a.Nif, a.apellidos, a.nombre, a.nif_jefe
FROM artistas a
INNER JOIN artista_atraccion aa ON a.Nif = aa.nif
WHERE aa.fecha_inicio < '1999-01-01';

-- ============================================
-- RESULTADO ESPERADO
-- ============================================
-- "Anterior a 1999" = fecha_inicio < '1999-01-01'.
-- Con los datos actuales puede que no haya resultados (1999-11-01 no es < 1999-01-01).
-- Alternativa: YEAR(fecha_inicio) < 1999 para artistas que empezaron antes de 1999.

-- ============================================
-- VARIACIONES PARA PRACTICAR
-- ============================================
-- Si se interpreta como "antes del año 2000": WHERE YEAR(aa.fecha_inicio) < 2000
