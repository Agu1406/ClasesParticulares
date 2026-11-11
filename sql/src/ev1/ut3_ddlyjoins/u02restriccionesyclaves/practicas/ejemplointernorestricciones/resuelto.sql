/*
OBJETIVO: Solucion restricciones academia.
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
*/

USE academia;

CREATE TABLE IF NOT EXISTS alumno (
  dni CHAR(9) PRIMARY KEY,
  nombre VARCHAR(80) NOT NULL,
  email VARCHAR(100) UNIQUE
);

-- Si id_profesor no existe aun:
-- ALTER TABLE curso ADD COLUMN id_profesor INT NULL;
-- ALTER TABLE curso ADD CONSTRAINT fk_curso_profesor
--   FOREIGN KEY (id_profesor) REFERENCES profesor(id);

CREATE TABLE IF NOT EXISTS matricula (
  dni CHAR(9) NOT NULL,
  codigo VARCHAR(10) NOT NULL,
  fecha DATE NOT NULL,
  nota DECIMAL(4,2),
  PRIMARY KEY (dni, codigo),
  CONSTRAINT fk_mat_alumno FOREIGN KEY (dni) REFERENCES alumno(dni),
  CONSTRAINT fk_mat_curso FOREIGN KEY (codigo) REFERENCES curso(codigo)
);
