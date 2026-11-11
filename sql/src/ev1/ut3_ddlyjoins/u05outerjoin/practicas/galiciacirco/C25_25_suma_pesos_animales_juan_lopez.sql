/*
OBJETIVO: Practica Galicia UT3 (JOIN). Origen banco galicia/.
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
*/

-- Origen: galicia/circo/consulta_25_suma_pesos_animales_juan_lopez.sql

-- ============================================
-- CONSULTA 25: Suma de los pesos de los animales atendidos por 'Juan López'
-- ============================================
-- JOIN artistas, artista_animal, animales. SUM(peso).
-- En la BD: Juan Lopez (11111111A).

USE circo;

-- ============================================
-- EXPLICACIÓN
-- ============================================
-- artista_animal relaciona nif con nombre (animal).
-- animales tiene el peso.
-- Juan Lopez = 11111111A. Atiende: Caiman, Leo, Princesa1.

-- ============================================
-- SOLUCIÓN
-- ============================================
SELECT SUM(a.peso) AS suma_pesos
FROM artistas ar
INNER JOIN artista_animal aa ON ar.Nif = aa.nif
INNER JOIN animales a ON aa.nombre = a.nombre_animal
WHERE ar.nombre = 'Juan' AND ar.apellidos LIKE 'Lop%';

-- ============================================
-- RESULTADO ESPERADO
-- ============================================
-- Caiman 70 + Leo 120 + Princesa1 100 = 290

-- ============================================
-- VARIACIONES PARA PRACTICAR
-- ============================================
-- Peso medio de animales por artista
-- SELECT ar.nombre, ar.apellidos, AVG(a.peso) FROM artistas ar INNER JOIN artista_animal aa ON ar.Nif = aa.nif INNER JOIN animales a ON aa.nombre = a.nombre_animal GROUP BY ar.Nif;
