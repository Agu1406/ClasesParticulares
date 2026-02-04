/*
  CONSULTA 5: Peso de los animales en gramos

  El peso está en kg, así que multiplicamos por 1000.
  AS nos permite ponerle un nombre bonito a la columna calculada.
*/

USE circo;

/* La consulta */
SELECT nombre_animal, peso * 1000 AS "peso en gramos"
FROM animales;

/* Cada animal aparecerá con su peso en gramos (70 kg = 70000 gramos). */

/* Prueba filtrando solo los que tienen peso: añade WHERE peso IS NOT NULL */
