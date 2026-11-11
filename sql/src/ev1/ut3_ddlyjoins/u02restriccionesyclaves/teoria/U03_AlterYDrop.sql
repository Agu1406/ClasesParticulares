/*
OBJETIVO: Modificar y borrar objetos con ALTER TABLE y DROP.
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
*/

USE tienda;

-- Anadir columna (ejemplo; no lo dejes permanente en clase si compartes BD):
-- ALTER TABLE productos ADD COLUMN peso_kg DECIMAL(5,2) NULL;

-- Anadir FK a posteriori:
-- ALTER TABLE curso
--   ADD COLUMN id_profesor INT,
--   ADD CONSTRAINT fk_curso_prof FOREIGN KEY (id_profesor) REFERENCES profesor(id);

-- Borrar tabla / BD (CUIDADO):
-- DROP TABLE IF EXISTS temporal;
-- DROP DATABASE IF EXISTS academia;

-- En practicas usamos academia aparte para no romper tienda.
SELECT 'Usa academia para probar ALTER/DROP' AS consejo;
