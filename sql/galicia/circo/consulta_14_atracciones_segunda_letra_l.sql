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
