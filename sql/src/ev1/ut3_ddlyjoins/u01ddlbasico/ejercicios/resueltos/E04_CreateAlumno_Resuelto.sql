/*
OBJETIVO: CREATE TABLE alumno(dni PK, nombre NOT NULL, email).
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
*/

-- ENUNCIADO: CREATE TABLE alumno(dni PK, nombre NOT NULL, email).
CREATE TABLE alumno (
  dni CHAR(9) PRIMARY KEY,
  nombre VARCHAR(80) NOT NULL,
  email VARCHAR(100)
);
