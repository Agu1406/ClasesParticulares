-- ============================================
-- CONSULTA 1: Mostrar las personas con apellido que comience por 'L'
-- ============================================
-- En esta consulta aprenderás a usar el operador LIKE con comodines
-- para buscar patrones en texto.

USE viviendas;

-- ============================================
-- EXPLICACIÓN
-- ============================================
-- LIKE es un operador que permite buscar patrones en texto
-- '%' representa cualquier secuencia de caracteres (0 o más)
-- '_' representa un solo carácter
-- 
-- Ejemplos:
-- 'L%' = cualquier texto que comience con 'L'
-- '%L' = cualquier texto que termine con 'L'
-- '%L%' = cualquier texto que contenga 'L'
-- 'L___' = texto que comience con 'L' seguido de exactamente 3 caracteres

-- ============================================
-- SOLUCIÓN
-- ============================================
SELECT 
    dni,
    nombre,
    apellidos
FROM personas
WHERE apellidos LIKE 'L%';

-- ============================================
-- RESULTADO ESPERADO
-- ============================================
-- Deberías ver a Mario López (apellidos: 'Lopez B')
-- ya que comienza con 'L'

-- ============================================
-- VARIACIONES PARA PRACTICAR
-- ============================================
-- Buscar apellidos que terminen con 'z'
-- SELECT * FROM personas WHERE apellidos LIKE '%z';

-- Buscar apellidos que contengan 'ez'
-- SELECT * FROM personas WHERE apellidos LIKE '%ez%';

-- Buscar nombres que comiencen con 'M' y tengan exactamente 5 caracteres
-- SELECT * FROM personas WHERE nombre LIKE 'M____';



