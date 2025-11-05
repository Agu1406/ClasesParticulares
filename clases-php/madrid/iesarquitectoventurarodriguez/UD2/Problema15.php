<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Problema15</title>
</head>
<body>
    <?php
    function mostrarMultiplos($numero, $inicio, $fin, &$cantidad) {
        $multiplos = array();
        
        for ($i = $inicio; $i <= $fin; $i++) {
            if ($i % $numero == 0) {
                $multiplos[] = $i;
            }
        }
        
        $cantidad = count($multiplos);
        
        echo "<h3>Múltiplos de $numero entre $inicio y $fin:</h3>";
        echo "Cantidad encontrada: $cantidad<br>";
        echo "Números múltiplos: ";
        
        if ($cantidad > 0) {
            echo implode(", ", $multiplos);
        } else {
            echo "No se encontraron múltiplos";
        }
        echo "<br>";
    }
    
    // Ejemplos de uso
    $cantidad1 = 0;
    mostrarMultiplos(3, 1, 30, $cantidad1);
    echo "<br>La variable cantidad contiene: $cantidad1<br><br>";
    
    $cantidad2 = 0;
    mostrarMultiplos(7, 10, 70, $cantidad2);
    echo "<br>La variable cantidad contiene: $cantidad2";
    ?>
</body>
</html>

