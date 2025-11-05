<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Problema5</title>
</head>
<body>
    <?php
    // Primera parte: copia por valor
    $a = 5;
    $b = $a; // Copia del valor
    echo "Copia por valor:<br>";
    echo "a = " . $a . "<br>";
    echo "b = " . $b . "<br>";
    
    $b = 10; // Cambio de b
    echo "Después de cambiar b a 10:<br>";
    echo "a = " . $a . "<br>";
    echo "b = " . $b . "<br><br>";
    
    // Segunda parte: referencia
    $a = 5;
    $b = &$a; // Referencia a $a
    echo "Referencia:<br>";
    echo "a = " . $a . "<br>";
    echo "b = " . $b . "<br>";
    
    $a = 20; // Cambio de a
    echo "Después de cambiar a a 20:<br>";
    echo "a = " . $a . "<br>";
    echo "b = " . $b;
    ?>
</body>
</html>

