/*
OBJETIVO: Solucion practica DDL academia.
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
*/

DROP DATABASE IF EXISTS academia;
CREATE DATABASE academia CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci;
USE academia;

CREATE TABLE profesor (
  id INT PRIMARY KEY AUTO_INCREMENT,
  nombre VARCHAR(80) NOT NULL
);

CREATE TABLE curso (
  codigo VARCHAR(10) PRIMARY KEY,
  titulo VARCHAR(100) NOT NULL,
  horas INT
);

SHOW TABLES;
DESCRIBE curso;
