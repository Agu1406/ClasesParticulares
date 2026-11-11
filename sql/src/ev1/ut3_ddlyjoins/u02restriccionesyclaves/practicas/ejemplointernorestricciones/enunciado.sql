/*
OBJETIVO: Practica: FK profesor-curso y alumno-matricula en academia.
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
*/

-- PRACTICA u02 (partiendo de academia de u01)
-- [ ] 1) CREATE TABLE alumno(dni PK, nombre NOT NULL, email UNIQUE)
-- [ ] 2) ALTER curso: id_profesor FK -> profesor(id)
-- [ ] 3) CREATE TABLE matricula(dni FK, codigo FK, fecha DATE, nota DECIMAL(4,2),
--          PRIMARY KEY(dni, codigo))
-- [ ] 4) Prueba INSERT matricula con dni inexistente (debe fallar)
-- [ ] 5) INSERT validos de prueba
