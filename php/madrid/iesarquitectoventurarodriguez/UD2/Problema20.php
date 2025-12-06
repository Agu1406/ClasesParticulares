<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Problema20</title>
</head>
<body>
    <?php
    function esPalindromo($cadena) {
        // Eliminar espacios en blanco
        $cadenaSinEspacios = str_replace(' ', '', $cadena);
        
        // Convertir a minúsculas para comparación
        $cadenaSinEspacios = strtolower($cadenaSinEspacios);
        
        // Longitud de la cadena
        $longitud = strlen($cadenaSinEspacios);
        
        // Comparar carácter por carácter desde ambos extremos
        for ($i = 0; $i < $longitud / 2; $i++) {
            if ($cadenaSinEspacios[$i] != $cadenaSinEspacios[$longitud - 1 - $i]) {
                return false;
            }
        }
        
        return true;
    }
    
    echo "<h2>Comprobación de palíndromos:</h2>";
    
    $palabras = array(
        "ana",
        "radar",
        "reconocer",
        "anita lava la tina",
        "hola mundo",
        "salas",
        "oso"
    );
    
    foreach ($palabras as $palabra) {
        if (esPalindromo($palabra)) {
            echo "'$palabra' <strong>ES</strong> un palíndromo<br>";
        } else {
            echo "'$palabra' <strong>NO ES</strong> un palíndromo<br>";
        }
    }
    ?>
</body>
</html>

