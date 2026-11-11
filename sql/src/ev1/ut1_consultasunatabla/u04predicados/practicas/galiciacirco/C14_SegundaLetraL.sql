/*
OBJETIVO: Practica Galicia UT1 (origen circo/consulta_14_atracciones_segunda_letra_l.sql).
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
*/

-- Origen: galicia/circo/consulta_14_atracciones_segunda_letra_l.sql
-- Nivel UT1: una tabla. No uses JOIN.

-- ============================================
-- CONSULTA 14: Nombres de atracciones cuya segunda letra sea 'l'
-- ============================================
-- Uso de LIKE con el comodín _ (un solo carácter).

USE circo;

-- ============================================
-- EXPLICACIÓN
-- ============================================
-- _ representa exactamente un carácter.
-- '_l%' = primera letra cualquiera, segunda 'l', resto cualquiera.

-- ============================================
-- SOLUCIÓN
-- ============================================
SELECT Nombre
FROM atracciones
WHERE Nombre LIKE '_l%';

-- ============================================
-- RESULTADO ESPERADO
-- ============================================
-- El gran felino (E-l-...), El devorador (E-l-...), El orangután (E-l-...), Las jirafas (L-a-... no, segunda es 'a')

-- ============================================
-- VARIACIONES PARA PRACTICAR
-- ============================================
-- Atracciones cuya tercera letra sea 'a'
-- SELECT Nombre FROM atracciones WHERE Nombre LIKE '__a%';
