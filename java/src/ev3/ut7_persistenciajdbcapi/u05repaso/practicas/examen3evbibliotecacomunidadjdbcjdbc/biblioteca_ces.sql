-- Base de datos del examen 3ª evaluación — Comunidad de bibliotecas
DROP DATABASE IF EXISTS biblioteca_ces;

CREATE DATABASE biblioteca_ces
    CHARACTER SET utf8mb4
    COLLATE utf8mb4_unicode_ci;

USE biblioteca_ces;

-- Un autor puede escribir muchos libros (DNI único)
CREATE TABLE autores (
    id       INT AUTO_INCREMENT PRIMARY KEY,
    nombre   VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    dni      VARCHAR(20)  NOT NULL UNIQUE
);

-- Una biblioteca puede tener muchos libros
CREATE TABLE bibliotecas (
    id        INT AUTO_INCREMENT PRIMARY KEY,
    calle     VARCHAR(200) NOT NULL,
    localidad VARCHAR(100) NOT NULL,
    provincia VARCHAR(100) NOT NULL
);

-- Un libro tiene un autor y está en una biblioteca (ISBN único)
CREATE TABLE libros (
    id               INT AUTO_INCREMENT PRIMARY KEY,
    isbn             VARCHAR(20) NOT NULL UNIQUE,
    num_paginas      INT         NOT NULL,
    tipo             VARCHAR(50) NOT NULL,
    anio_publicacion INT         NOT NULL,
    id_autor         INT         NOT NULL,
    id_biblioteca    INT         NOT NULL,
    FOREIGN KEY (id_autor) REFERENCES autores(id),
    FOREIGN KEY (id_biblioteca) REFERENCES bibliotecas(id)
);
