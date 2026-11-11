/*
OBJETIVO: Explicar que es SQL y situar DQL, DML y DDL antes de escribir la primera consulta.
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
*/

USE tienda;

-- =============================================================================
-- 1) Que problema resuelve SQL?
-- =============================================================================
-- Una aplicacion (web, movil, escritorio) necesita GUARDAR y RECUPERAR datos
-- de forma fiable: clientes, productos, pedidos, notas...
-- SQL (Structured Query Language) es el lenguaje estandar para hablar con
-- una base de datos RELACIONAL (tablas con filas y columnas).

-- Es DECLARATIVO: describes QUE quieres obtener.
-- El SGBD (MySQL, MariaDB, PostgreSQL...) decide COMO hacerlo.

-- =============================================================================
-- 2) Tres familias que veras todo el curso
-- =============================================================================
-- DQL  Consulta de datos     -> SELECT
-- DML  Manipulacion de datos -> INSERT, UPDATE, DELETE
-- DDL  Definicion de estructura -> CREATE, ALTER, DROP

-- En UT1 trabajamos casi solo DQL (SELECT) sobre UNA tabla.
-- Mas adelante: varias tablas (JOIN), agrupar, insertar, procedimientos...

-- =============================================================================
-- 3) Ejemplo minimo (solo para situarte)
-- =============================================================================
SELECT nombre, precio
FROM productos;

-- Errores tipicos al empezar:
-- - Olvidar el ; final (en muchos clientes hace falta)
-- - Escribir FRON en vez de FROM
-- - Pedir una columna que no existe (Error: Unknown column)

-- Prueba tu: cambia precio por stock y vuelve a ejecutar.
