-- ============================================
-- CONSULTA 33: Insertar artista Sam Rodriguez
-- ============================================
-- INSERT INTO para añadir un nuevo registro.

USE circo;

-- ============================================
-- EXPLICACIÓN
-- ============================================
-- INSERT INTO tabla (columnas) VALUES (valores).
-- nif_jefe '22222222B' referencia a Luis Sanchez.

-- ============================================
-- SOLUCIÓN
-- ============================================
INSERT INTO artistas (Nif, apellidos, nombre, nif_jefe)
VALUES ('555555E', 'Rodriguez', 'Sam', '22222222B');

-- ============================================
-- RESULTADO ESPERADO
-- ============================================
-- Se añade una nueva fila a la tabla artistas.

-- ============================================
-- VARIACIONES PARA PRACTICAR
-- ============================================
-- Verificar la inserción
-- SELECT * FROM artistas WHERE Nif = '555555E';
