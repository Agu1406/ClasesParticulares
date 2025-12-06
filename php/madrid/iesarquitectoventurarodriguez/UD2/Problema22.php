<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Problema22</title>
</head>
<body>
    <?php
    // Generar matriz bidimensional con números aleatorios
    $filas = 5;
    $columnas = 4;
    $matriz = array();
    
    // Llenar la matriz con números aleatorios enteros
    for ($i = 0; $i < $filas; $i++) {
        $matriz[$i] = array();
        for ($j = 0; $j < $columnas; $j++) {
            $matriz[$i][$j] = rand(1, 100);
        }
    }
    
    // Mostrar la matriz
    echo "<h2>Matriz bidimensional de $filas x $columnas:</h2>";
    echo "<table border='1' cellpadding='5'>";
    
    for ($i = 0; $i < $filas; $i++) {
        echo "<tr>";
        for ($j = 0; $j < $columnas; $j++) {
            echo "<td>" . $matriz[$i][$j] . "</td>";
        }
        echo "</tr>";
    }
    
    echo "</table>";
    
    // También mostrar con print_r
    echo "<h2>Matriz con print_r():</h2>";
    echo "<pre>";
    print_r($matriz);
    echo "</pre>";
    ?>
</body>
</html>

