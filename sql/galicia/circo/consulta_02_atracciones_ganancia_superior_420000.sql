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
