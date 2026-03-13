-- Script SQL para MySQL: creación de BD Colegio y tabla Alumnos
-- Asegúrate de ejecutar con un usuario con permisos de CREATE DATABASE

CREATE DATABASE IF NOT EXISTS Colegio
  DEFAULT CHARACTER SET utf8mb4
  DEFAULT COLLATE utf8mb4_0900_ai_ci;

USE Colegio;

-- Tabla Alumnos según requisitos: Teléfono, ID alumno, nombre, correo
-- Usamos tipos y restricciones habituales
CREATE TABLE IF NOT EXISTS Alumnos (
  id_alumno INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(100) NOT NULL,
  correo VARCHAR(150) NOT NULL UNIQUE,
  telefono VARCHAR(20) NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


