-- ============================================
-- CONSULTA 20: Artistas que cuidan animales (nombre, apellidos) y datos de animales (nombre, tipo, peso), pista y aforo. Solo animales con peso > 70
-- ============================================
-- Múltiples JOINs: artistas, artista_animal, animales, pistas. Orden alfabético por artista.

USE circo;

-- ============================================
-- EXPLICACIÓN
-- ============================================
-- artista_animal relaciona artistas con animales.
-- animales tiene nombre_pista que referencia pistas.
-- WHERE a.peso > 70 filtra animales pesados.

-- ============================================
-- SOLUCIÓN
-- ============================================
SELECT 
    ar.nombre,
    ar.apellidos,
    a.nombre_animal, ✅
    a.tipo,
    a.peso,
    p.Nombre_pista,
    p.Aforo
FROM artistas ar
-- Artista animal se conecta con artistas
INNER JOIN artista_animal aa ON ar.Nif = aa.nif
-- Animnales se conecta con artista_animal
INNER JOIN animales a ON aa.nombre = a.nombre_animal
-- Pistas se conectan con animales
LEFT JOIN pistas p ON a.nombre_pista = p.Nombre_pista
WHERE a.peso > 70
ORDER BY ar.apellidos, ar.nombre;

-- ============================================
-- RESULTADO ESPERADO
-- ============================================
-- Caiman (70 no, 70 no es > 70), Leo (120), Princesa1 (100), Princesa2 (110)
-- Animales con peso > 70: Leo, Princesa1, Princesa2

-- ============================================
-- VARIACIONES PARA PRACTICAR
-- ============================================
-- Incluir peso >= 70 para incluir Caiman
-- WHERE a.peso >= 70
