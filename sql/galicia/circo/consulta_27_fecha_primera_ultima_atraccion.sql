-- ============================================
-- CONSULTA 27: Fecha de la atracción que empezó primero y la que empezó más tarde
-- ============================================
-- MIN y MAX sobre F_inicio. Dos columnas en una fila.

USE circo;

-- ============================================
-- EXPLICACIÓN
-- ============================================
-- MIN(F_inicio) devuelve la fecha más antigua.
-- MAX(F_inicio) devuelve la fecha más reciente.
-- Excluir NULL si es necesario.

-- ============================================
-- SOLUCIÓN
-- ============================================
SELECT 
    MIN(F_inicio) AS primera_atraccion,
    MAX(F_inicio) AS ultima_atraccion
FROM atracciones
WHERE F_inicio IS NOT NULL;

-- ============================================
-- RESULTADO ESPERADO
-- ============================================
-- primera: 1999-11-01 (El gran felino), ultima: 2001-04-01 (El devorador)

-- ============================================
-- VARIACIONES PARA PRACTICAR
-- ============================================
-- Nombre de la atracción que empezó primero
-- SELECT Nombre FROM atracciones WHERE F_inicio = (SELECT MIN(F_inicio) FROM atracciones WHERE F_inicio IS NOT NULL);
