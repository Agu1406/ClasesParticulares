/*
OBJETIVO: Crear tablas con tipos MySQL habituales y clave primaria.
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
*/

USE tienda;

-- Tipos que usamos en clase:
-- INT, DECIMAL(p,s), VARCHAR(n), CHAR(n), DATE, TINYINT(1), TEXT

-- Ejemplo (NO ejecutar si ya existe; es plantilla de clase):
/*
CREATE TABLE productos (
  id_producto INT PRIMARY KEY AUTO_INCREMENT,
  nombre VARCHAR(80) NOT NULL,
  precio DECIMAL(8,2) NOT NULL,
  stock INT NOT NULL DEFAULT 0,
  fecha_alta DATE NOT NULL
);
*/

DESCRIBE productos;
SHOW CREATE TABLE productos;

-- AUTO_INCREMENT: MySQL asigna el siguiente entero a la PK.
