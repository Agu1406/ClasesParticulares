/*
OBJETIVO: Practica Galicia UT1 (origen circo/consulta_08_años_funcionando_atracciones.sql).
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
*/

-- Origen: galicia/circo/consulta_08_años_funcionando_atracciones.sql
-- Nivel UT1: una tabla. No uses JOIN.

-- ============================================
-- CONSULTA 8: Número de años que lleva funcionando cada atracción
-- ============================================
-- Uso de TIMESTAMPDIFF o DATEDIFF con CURDATE().

USE circo;

-- ============================================
-- EXPLICACIÓN
-- ============================================
-- TIMESTAMPDIFF(unit, start, end) calcula la diferencia.
-- CURDATE() devuelve la fecha actual.
-- Solo para atracciones con F_inicio no nulo.

-- ============================================
-- SOLUCIÓN
-- ============================================
SELECT 
    Nombre,
    F_inicio,
    TIMESTAMPDIFF(YEAR, F_inicio, CURDATE()) AS años_funcionando
FROM atracciones
WHERE F_inicio IS NOT NULL;

-- ============================================
-- RESULTADO ESPERADO
-- ============================================
-- Cada atracción con F_inicio y los años desde entonces hasta hoy

-- ============================================
-- VARIACIONES PARA PRACTICAR
-- ============================================
-- Años y meses funcionando
-- SELECT Nombre, TIMESTAMPDIFF(MONTH, F_inicio, CURDATE()) AS meses_funcionando FROM atracciones WHERE F_inicio IS NOT NULL;
