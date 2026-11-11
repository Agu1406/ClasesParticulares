/*
OBJETIVO: Aplicar NOT NULL, UNIQUE, DEFAULT y CHECK en CREATE TABLE.
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
*/

USE tienda;

/*
CREATE TABLE clientes (
  id_cliente INT PRIMARY KEY AUTO_INCREMENT,
  nombre VARCHAR(50) NOT NULL,
  email VARCHAR(100) UNIQUE,
  activo TINYINT(1) NOT NULL DEFAULT 1,
  precio DECIMAL(8,2) CHECK (precio >= 0)  -- CHECK: MariaDB/MySQL 8.0.16+
);
*/

-- NOT NULL: obligatorio
-- UNIQUE: no repetir (permite varios NULL en MySQL)
-- DEFAULT: valor si no envias la columna
-- CHECK: condicion sobre la fila

DESCRIBE clientes;
