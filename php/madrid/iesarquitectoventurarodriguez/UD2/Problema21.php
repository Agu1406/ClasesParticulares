<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Problema21</title>
</head>
<body>
    <?php
    function ordenarBurbuja($array, $sentido) {
        $n = count($array);
        
        // Algoritmo de burbuja
        for ($i = 0; $i < $n - 1; $i++) {
            for ($j = 0; $j < $n - $i - 1; $j++) {
                $intercambiar = false;
                
                if ($sentido == "a") {
                    // Ordenar de menor a mayor
                    if ($array[$j] > $array[$j + 1]) {
                        $intercambiar = true;
                    }
                } elseif ($sentido == "d") {
                    // Ordenar de mayor a menor
                    if ($array[$j] < $array[$j + 1]) {
                        $intercambiar = true;
                    }
                }
                
                if ($intercambiar) {
                    // Intercambiar elementos
                    $temp = $array[$j];
                    $array[$j] = $array[$j + 1];
                    $array[$j + 1] = $temp;
                }
            }
        }
        
        return $array;
    }
    
    // Generar array de 100 elementos aleatorios
    $array = array();
    for ($i = 0; $i < 100; $i++) {
        $array[] = rand(1, 1000);
    }
    
    echo "<h2>Array original (primeros 10 elementos):</h2>";
    echo "[" . implode(", ", array_slice($array, 0, 10)) . ", ...]<br><br>";
    
    // Ordenar de menor a mayor
    $arrayAscendente = ordenarBurbuja($array, "a");
    echo "<h2>Array ordenado de menor a mayor (primeros 10 elementos):</h2>";
    echo "[" . implode(", ", array_slice($arrayAscendente, 0, 10)) . ", ...]<br><br>";
    
    // Ordenar de mayor a menor
    $arrayDescendente = ordenarBurbuja($array, "d");
    echo "<h2>Array ordenado de mayor a menor (primeros 10 elementos):</h2>";
    echo "[" . implode(", ", array_slice($arrayDescendente, 0, 10)) . ", ...]<br><br>";
    
    echo "<h2>Array completo ordenado de menor a mayor:</h2>";
    echo "[" . implode(", ", $arrayAscendente) . "]<br><br>";
    
    echo "<h2>Array completo ordenado de mayor a menor:</h2>";
    echo "[" . implode(", ", $arrayDescendente) . "]";
    ?>
</body>
</html>

