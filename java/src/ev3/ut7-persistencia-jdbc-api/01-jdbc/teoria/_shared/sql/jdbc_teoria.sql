-- BD de demo para las clases de teoria JDBC (01-jdbc)
-- Ejecutar en phpMyAdmin o: mysql -u root < jdbc_teoria.sql

CREATE DATABASE IF NOT EXISTS JdbcTeoria
  DEFAULT CHARACTER SET utf8mb4
  DEFAULT COLLATE utf8mb4_general_ci;

USE JdbcTeoria;

CREATE TABLE IF NOT EXISTS libros (
  id INT AUTO_INCREMENT PRIMARY KEY,
  titulo VARCHAR(150) NOT NULL,
  autor VARCHAR(100) NOT NULL,
  precio DECIMAL(8,2) NOT NULL,
  stock INT NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DELETE FROM libros;

INSERT INTO libros (titulo, autor, precio, stock) VALUES
  ('Clean Code', 'Robert C. Martin', 29.95, 12),
  ('Effective Java', 'Joshua Bloch', 34.50, 8),
  ('Head First Java', 'Kathy Sierra', 24.00, 15),
  ('Java: The Complete Reference', 'Herbert Schildt', 39.99, 5);
