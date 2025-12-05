/*
Escribe una consulta SQL para seleccionar todos los usuarios de una tabla "usuarios" 
cuyo nombre empiece por "A" y ordenarlos por apellido.

Tabla "usuarios":
| Id_contacto   | nombre    | apellido  | email                    |
|---------------|-----------|-----------|--------------------------|
| 1             | Ana       | García    | ana_garcia@correo.es     |
| 2             | Beatriz   | Pérez     | Beatriz.perez@correo.es  |
| 3             | Carlos    | López     | carlosL@correo.es        |
| 4             | Álvaro    | Martínez  | A.Martinez@correo.es     |
| 5             | Andrea    | Sánchez   | Andrea-sanchez@correo.es |
*/

-- Consulta SQL
SELECT * 
FROM usuarios 
WHERE nombre LIKE 'A%' 
ORDER BY apellido;