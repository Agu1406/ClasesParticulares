<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Problema17</title>
</head>
<body>
    <?php
    // Factorial usando bucle
    function factorialBucle($numero) {
        if ($numero < 0) {
            return "Error: No se puede calcular factorial de un número negativo";
        }
        
        if ($numero == 0 || $numero == 1) {
            return 1;
        }
        
        $resultado = 1;
        for ($i = 2; $i <= $numero; $i++) {
            $resultado *= $i;
        }
        
        return $resultado;
    }
    
    // Factorial usando recursividad
    function factorialRecursivo($numero) {
        if ($numero < 0) {
            return "Error: No se puede calcular factorial de un número negativo";
        }
        
        if ($numero == 0 || $numero == 1) {
            return 1;
        }
        
        return $numero * factorialRecursivo($numero - 1);
    }
    
    // Ejemplos de uso
    echo "<h2>Factorial usando bucle:</h2>";
    echo "5! = " . factorialBucle(5) . "<br>";
    echo "7! = " . factorialBucle(7) . "<br>";
    echo "0! = " . factorialBucle(0) . "<br>";
    
    echo "<h2>Factorial usando recursividad:</h2>";
    echo "5! = " . factorialRecursivo(5) . "<br>";
    echo "7! = " . factorialRecursivo(7) . "<br>";
    echo "0! = " . factorialRecursivo(0) . "<br>";
    ?>
</body>
</html>

