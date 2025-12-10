-- Script SQL para crear la tabla empleados en MySQL
-- Base de datos: referencia

-- Eliminar la base de datos si existe
DROP DATABASE IF EXISTS referencia;

-- Crear la base de datos
CREATE DATABASE referencia;

-- Usar la base de datos
USE referencia;

-- Eliminar la tabla si existe
DROP TABLE IF EXISTS empleados;

-- Crear la tabla empleados
CREATE TABLE empleados (
    num_empleado  INT NOT NULL,
    dni           VARCHAR(9) NOT NULL,
    nombre        VARCHAR(50) NOT NULL,
    apellido1     VARCHAR(50) NOT NULL,
    apellido2     VARCHAR(50) NOT NULL,
    tfno_empresa  INT NOT NULL,
    sueldo        DECIMAL(9,2) NOT NULL,
    tfno_personal INT NULL,
    transporte    DECIMAL(6,2) NULL,
    num_jefe      INT NULL
);

ALTER TABLE empleados ADD CONSTRAINT emp_pk PRIMARY KEY (num_empleado);

ALTER TABLE empleados ADD CONSTRAINT emp_un1 UNIQUE (dni);

ALTER TABLE empleados  
    ADD CONSTRAINT emp_fk1 FOREIGN KEY (num_jefe) 
        REFERENCES empleados (num_empleado);

CREATE INDEX emp_idx1 ON empleados (nombre, apellido1, apellido2);

