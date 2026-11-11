/*
OBJETIVO: Practica Galicia UT1 (origen viviendas/consulta_02_viviendas_centro_metros.sql).
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
*/

-- Origen: galicia/viviendas/consulta_02_viviendas_centro_metros.sql
-- Nivel UT1: una tabla. No uses JOIN.

/*
  CONSULTA 2: Viviendas del Centro con entre 70 y 90 metros

  Combinamos condiciones con AND. BETWEEN sirve para rangos (incluye los extremos).
  Es lo mismo que metros >= 70 AND metros <= 90.
*/

USE viviendas;

/* La consulta */
SELECT 
    cod_vivienda,
    calle,
    numero,
    piso,
    puerta,
    metros,
    nombre_zona
FROM viviendas
WHERE nombre_zona = 'Centro'
  AND metros BETWEEN 70 AND 90;

/* Alternativa sin BETWEEN:
   SELECT ... WHERE nombre_zona = 'Centro' AND metros >= 70 AND metros <= 90;
*/

/* Otra forma de escribirlo:
-- SELECT 
--     cod_vivienda,
--     calle,
--     numero,
--     piso,
--     puerta,
--     metros,
--     nombre_zona
-- FROM viviendas
-- WHERE nombre_zona = 'Centro'
--   AND metros >= 70 
--   AND metros <= 90;
*/

/* Verás las viviendas 30000 y 30001 del Centro. */

/* Prueba: viviendas del Centro con más de 80 m, o del Centro/Sector Norte con más de 75 m. */



