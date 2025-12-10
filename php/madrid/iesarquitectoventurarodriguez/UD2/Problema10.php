<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Problema10</title>
</head>
<body>
    <?php
    function contador() {
        static $contador = 0;
        $contador++;
        echo "Contador: " . $contador . "<br>";
    }
    
    echo "Llamadas a la función contador:<br>";
    contador();
    contador();
    contador();
    contador();
    contador();
    ?>
</body>
</html>

