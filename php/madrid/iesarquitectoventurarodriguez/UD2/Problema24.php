<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Problema24</title>
</head>
<body>
    <?php
    // Función para generar matriz aleatoria
    function generarMatriz($filas, $columnas) {
        $matriz = array();
        for ($i = 0; $i < $filas; $i++) {
            $matriz[$i] = array();
            for ($j = 0; $j < $columnas; $j++) {
                $matriz[$i][$j] = rand(0, 10);
            }
        }
        return $matriz;
    }
    
    // Función para mostrar matriz
    function mostrarMatriz($matriz, $nombre) {
        echo "<h3>$nombre:</h3>";
        echo "<table border='1' cellpadding='5'>";
        for ($i = 0; $i < count($matriz); $i++) {
            echo "<tr>";
            for ($j = 0; $j < count($matriz[$i]); $j++) {
                echo "<td>" . $matriz[$i][$j] . "</td>";
            }
            echo "</tr>";
        }
        echo "</table>";
    }
    
    // Función para multiplicar matrices
    function multiplicarMatrices($matrizA, $matrizB) {
        $m = count($matrizA); // Filas de A
        $n = count($matrizA[0]); // Columnas de A
        $p = count($matrizB); // Filas de B
        $q = count($matrizB[0]); // Columnas de B
        
        // Verificar si se puede multiplicar: n debe ser igual a p
        if ($n != $p) {
            return false; // No se puede multiplicar
        }
        
        // Crear matriz resultado: m filas x q columnas
        $matrizC = array();
        for ($i = 0; $i < $m; $i++) {
            $matrizC[$i] = array();
            for ($j = 0; $j < $q; $j++) {
                $matrizC[$i][$j] = 0;
                // Calcular C[i][j] = suma de A[i][k] * B[k][j]
                for ($k = 0; $k < $n; $k++) {
                    $matrizC[$i][$j] += $matrizA[$i][$k] * $matrizB[$k][$j];
                }
            }
        }
        
        return $matrizC;
    }
    
    // Generar dimensiones aleatorias de 2 a 5
    $m = rand(2, 5); // Filas de A
    $n = rand(2, 5); // Columnas de A (filas de B)
    $q = rand(2, 5); // Columnas de B
    
    // Generar matrices
    $matrizA = generarMatriz($m, $n);
    $matrizB = generarMatriz($n, $q);
    
    echo "<h2>Multiplicación de Matrices</h2>";
    echo "<p>Dimensiones:</p>";
    echo "<ul>";
    echo "<li>Matriz A: $m x $n</li>";
    echo "<li>Matriz B: $n x $q</li>";
    echo "<li>Matriz resultado C: $m x $q</li>";
    echo "</ul>";
    
    mostrarMatriz($matrizA, "Matriz A ($m x $n)");
    echo "<br>";
    mostrarMatriz($matrizB, "Matriz B ($n x $q)");
    
    // Multiplicar matrices
    $matrizC = multiplicarMatrices($matrizA, $matrizB);
    
    if ($matrizC !== false) {
        echo "<br>";
        mostrarMatriz($matrizC, "Matriz Resultado C = A × B ($m x $q)");
    } else {
        echo "<p style='color: red;'><strong>Error: No se puede multiplicar las matrices.</strong><br>";
        echo "El número de columnas de A ($n) debe ser igual al número de filas de B (" . count($matrizB) . ").</p>";
    }
    
    // Ejemplo adicional: caso donde no se puede multiplicar
    echo "<hr>";
    echo "<h2>Ejemplo de matrices que NO se pueden multiplicar:</h2>";
    
    $matrizA2 = generarMatriz(3, 4); // 3 x 4
    $matrizB2 = generarMatriz(5, 2); // 5 x 2 (no coincide: 4 != 5)
    
    mostrarMatriz($matrizA2, "Matriz A (3 x 4)");
    echo "<br>";
    mostrarMatriz($matrizB2, "Matriz B (5 x 2)");
    
    $matrizC2 = multiplicarMatrices($matrizA2, $matrizB2);
    
    if ($matrizC2 === false) {
        echo "<p style='color: red;'><strong>Error: No se puede multiplicar las matrices.</strong><br>";
        echo "El número de columnas de A (4) no es igual al número de filas de B (5).</p>";
    }
    ?>
</body>
</html>

