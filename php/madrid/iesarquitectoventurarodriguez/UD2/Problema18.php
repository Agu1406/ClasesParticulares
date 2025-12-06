<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Problema18</title>
</head>
<body>
    <?php
    // Función recursiva para sumar elementos de un array
    function sumaRecursiva($array, $indice = 0) {
        // Caso base: si el índice es igual o mayor al tamaño del array
        if ($indice >= count($array)) {
            return 0;
        }
        
        // Caso recursivo: sumar el elemento actual más la suma del resto
        return $array[$indice] + sumaRecursiva($array, $indice + 1);
    }
    
    // Generar array de enteros
    $enteros = array(5, 10, 15, 20, 25, 30, 35, 40);
    
    echo "<h2>Array de enteros:</h2>";
    echo "[" . implode(", ", $enteros) . "]<br><br>";
    
    echo "<h2>Suma de elementos usando función recursiva:</h2>";
    $suma = sumaRecursiva($enteros);
    echo "La suma de todos los elementos es: $suma";
    ?>
</body>
</html>

