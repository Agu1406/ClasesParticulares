/*
OBJETIVO: Anade id_profesor FK a curso (academia).
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
*/

-- ENUNCIADO: Anade id_profesor FK a curso (academia).
ALTER TABLE curso
  ADD COLUMN id_profesor INT NULL,
  ADD CONSTRAINT fk_curso_profesor
    FOREIGN KEY (id_profesor) REFERENCES profesor(id);
