<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Problema8</title>
</head>
<body>
    <?php
    $variableGlobal = "Soy una variable global";
    
    function mostrarVariableGlobal() {
        global $variableGlobal;
        echo "Dentro de la función: " . $variableGlobal;
    }
    
    mostrarVariableGlobal();
    ?>
</body>
</html>

