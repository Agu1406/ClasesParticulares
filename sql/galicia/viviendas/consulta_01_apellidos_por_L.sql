/*
  CONSULTA 1: Mostrar las personas con apellido que comience por 'L'

  Aquí practicamos LIKE con comodines para buscar patrones en texto.
  El % significa "cualquier cosa" (0 o más caracteres).
  El _ significa "un solo carácter".
  Por ejemplo: 'L%' = empieza por L, '%z' = termina en z.
*/

USE viviendas;

/* La consulta */
SELECT 
    dni,
    nombre,
    apellidos
FROM personas
WHERE apellidos LIKE 'L%';

/* Deberías ver a Mario López (apellidos 'Lopez B') porque comienza con L. */

/* Prueba también: apellidos que terminen con 'z', que contengan 'ez',
   o nombres de exactamente 5 caracteres que empiecen por M. */



