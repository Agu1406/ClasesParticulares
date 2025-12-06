-- ============================================
-- EJERCICIO 4: Tipos de Datos en MySQL
-- ============================================
-- En este ejercicio aprenderás los diferentes tipos de datos
-- que puedes usar en MySQL.

-- ============================================
-- PREPARACIÓN
-- ============================================
USE escuela;

-- ============================================
-- TIPOS DE DATOS NUMÉRICOS
-- ============================================

-- INT: Números enteros (desde -2,147,483,648 hasta 2,147,483,647)
-- TINYINT: Números enteros pequeños (-128 a 127)
-- BIGINT: Números enteros muy grandes
-- DECIMAL(M, D): Números decimales exactos
--   M = número total de dígitos
--   D = número de dígitos después del punto decimal
-- FLOAT: Números decimales aproximados
-- DOUBLE: Números decimales de doble precisión

-- Ejemplo de tabla con tipos numéricos
CREATE TABLE IF NOT EXISTS productos_numericos (
    id INT,
    cantidad TINYINT,
    precio DECIMAL(10, 2),  -- 10 dígitos totales, 2 después del punto
    peso FLOAT,
    descuento DOUBLE
);

-- ============================================
-- TIPOS DE DATOS DE TEXTO
-- ============================================

-- CHAR(N): Texto de longitud fija (máximo 255 caracteres)
-- VARCHAR(N): Texto de longitud variable (máximo 65,535 caracteres)
-- TEXT: Texto largo (hasta 65,535 caracteres)
-- LONGTEXT: Texto muy largo (hasta 4GB)

-- Ejemplo de tabla con tipos de texto
CREATE TABLE IF NOT EXISTS productos_texto (
    id INT,
    codigo CHAR(10),        -- Siempre 10 caracteres
    nombre VARCHAR(100),    -- Hasta 100 caracteres
    descripcion TEXT,       -- Texto largo
    notas LONGTEXT          -- Texto muy largo
);

-- ============================================
-- TIPOS DE DATOS DE FECHA Y HORA
-- ============================================

-- DATE: Fecha (YYYY-MM-DD)
-- TIME: Hora (HH:MM:SS)
-- DATETIME: Fecha y hora (YYYY-MM-DD HH:MM:SS)
-- TIMESTAMP: Marca de tiempo (similar a DATETIME, pero con zona horaria)
-- YEAR: Año (YYYY)

-- Ejemplo de tabla con tipos de fecha
CREATE TABLE IF NOT EXISTS eventos (
    id INT,
    fecha_evento DATE,
    hora_inicio TIME,
    fecha_hora_creacion DATETIME,
    fecha_modificacion TIMESTAMP,
    año_nacimiento YEAR
);

-- ============================================
-- TIPOS DE DATOS BOOLEANOS
-- ============================================

-- BOOLEAN o BOOL: Valores TRUE (1) o FALSE (0)
-- En MySQL, BOOLEAN es un alias de TINYINT(1)

-- Ejemplo de tabla con booleanos
CREATE TABLE IF NOT EXISTS usuarios (
    id INT,
    nombre VARCHAR(50),
    activo BOOLEAN,         -- TRUE o FALSE
    es_premium BOOL         -- También TRUE o FALSE
);

-- ============================================
-- PRÁCTICA
-- ============================================
-- Crea una tabla llamada "empleados" con las siguientes columnas:
-- 1. id: número entero
-- 2. nombre: texto variable hasta 80 caracteres
-- 3. salario: número decimal con 2 decimales
-- 4. fecha_contratacion: fecha
-- 5. hora_entrada: hora
-- 6. activo: booleano
-- 7. descripcion: texto largo

-- ============================================
-- SOLUCIÓN ESPERADA
-- ============================================
/*
CREATE TABLE empleados (
    id INT,
    nombre VARCHAR(80),
    salario DECIMAL(10, 2),
    fecha_contratacion DATE,
    hora_entrada TIME,
    activo BOOLEAN,
    descripcion TEXT
);

DESCRIBE empleados;
*/

