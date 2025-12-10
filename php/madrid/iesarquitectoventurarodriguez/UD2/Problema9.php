<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Problema9</title>
</head>
<body>
    <?php
    function funcionConVariableLocal() {
        $variableLocal = "Soy una variable local";
        echo "Dentro de la función: " . $variableLocal . "<br>";
    }
    
    funcionConVariableLocal();
    
    // Intentar acceder a la variable local fuera de la función
    echo "Intentando acceder a la variable local fuera de la función:<br>";
    if (isset($variableLocal)) {
        echo "Variable local: " . $variableLocal;
    } else {
        echo "La variable local no está definida fuera de la función.";
    }
    ?>
</body>
</html>

