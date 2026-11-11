/*
OBJETIVO: Practica Galicia UT1 (origen circo/consulta_02_atracciones_ganancia_superior_420000.sql).
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
*/

-- Origen: galicia/circo/consulta_02_atracciones_ganancia_superior_420000.sql
-- Nivel UT1: una tabla. No uses JOIN.

-- ============================================
-- CONSULTA 2: Atracciones con ganancia superior a 420000
-- ============================================
-- Uso de WHERE con operador de comparación (>).

USE circo;

-- ============================================
-- EXPLICACIÓN
-- ============================================
-- La columna ganancias de la tabla atracciones almacena el total.
-- WHERE filtra las filas que cumplen la condición.

-- ============================================
-- SOLUCIÓN
-- ============================================
SELECT *
FROM atracciones
WHERE ganancias > 420000;

-- ============================================
-- RESULTADO ESPERADO
-- ============================================
-- El gran felino (511212), El devorador (430123), Las jirafas (440300)
-- El orangután no aparece (ganancias NULL)

-- ============================================
-- VARIACIONES PARA PRACTICAR
-- ============================================
-- Atracciones con ganancia entre 400000 y 500000
-- SELECT * FROM atracciones WHERE ganancias BETWEEN 400000 AND 500000;
