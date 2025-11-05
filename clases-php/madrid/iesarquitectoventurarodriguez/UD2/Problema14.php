<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Problema14</title>
</head>
<body>
    <?php
    function mostrarMultiplos($numero, $inicio, $fin) {
        $multiplos = array();
        
        for ($i = $inicio; $i <= $fin; $i++) {
            if ($i % $numero == 0) {
                $multiplos[] = $i;
            }
        }
        
        echo "<h3>Múltiplos de $numero entre $inicio y $fin:</h3>";
        echo "Cantidad encontrada: " . count($multiplos) . "<br>";
        echo "Números múltiplos: ";
        
        if (count($multiplos) > 0) {
            echo implode(", ", $multiplos);
        } else {
            echo "No se encontraron múltiplos";
        }
        echo "<br>";
    }
    
    // Ejemplos de uso
    mostrarMultiplos(3, 1, 30);
    echo "<br>";
    mostrarMultiplos(5, 10, 50);
    ?>
</body>
</html>

