<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Problema16</title>
</head>
<body>
    <?php
    function tablaMultiplicar($numero) {
        echo "<h2>Tabla de multiplicar del $numero:</h2>";
        echo "<table border='1' cellpadding='5'>";
        
        for ($i = 1; $i <= 10; $i++) {
            $resultado = $numero * $i;
            echo "<tr>";
            echo "<td>$numero x $i</td>";
            echo "<td>=</td>";
            echo "<td>$resultado</td>";
            echo "</tr>";
        }
        
        echo "</table>";
    }
    
    // Ejemplos de uso
    tablaMultiplicar(5);
    echo "<br>";
    tablaMultiplicar(7);
    ?>
</body>
</html>

