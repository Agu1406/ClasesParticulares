<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Problema13</title>
</head>
<body>
    <?php
    function esPrimo($numero) {
        if ($numero < 2) {
            return false;
        }
        
        for ($i = 2; $i <= sqrt($numero); $i++) {
            if ($numero % $i == 0) {
                return false;
            }
        }
        return true;
    }
    
    echo "<h2>Números primos del 1 al 100:</h2>";
    $primos = array();
    
    for ($i = 1; $i <= 100; $i++) {
        if (esPrimo($i)) {
            $primos[] = $i;
        }
    }
    
    echo "Cantidad de números primos encontrados: " . count($primos) . "<br><br>";
    echo "Números primos: ";
    echo implode(", ", $primos);
    ?>
</body>
</html>

