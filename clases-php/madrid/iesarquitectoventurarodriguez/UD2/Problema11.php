<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Problema11</title>
</head>
<body>
    <?php
    // Array indexado
    $arrayIndexado = array("Manzana", "Banana", "Naranja", "Pera");
    
    // Array asociativo
    $arrayAsociativo = array(
        "nombre" => "Juan",
        "edad" => 25,
        "ciudad" => "Madrid",
        "profesion" => "Desarrollador"
    );
    
    echo "<h2>Arrays con print_r():</h2>";
    echo "<h3>Array indexado:</h3>";
    echo "<pre>";
    print_r($arrayIndexado);
    echo "</pre>";
    
    echo "<h3>Array asociativo:</h3>";
    echo "<pre>";
    print_r($arrayAsociativo);
    echo "</pre>";
    
    echo "<h2>Array indexado con for:</h2>";
    for ($i = 0; $i < count($arrayIndexado); $i++) {
        echo "Elemento $i: " . $arrayIndexado[$i] . "<br>";
    }
    
    echo "<h2>Array indexado con foreach:</h2>";
    foreach ($arrayIndexado as $indice => $valor) {
        echo "Índice $indice: $valor<br>";
    }
    
    echo "<h2>Array asociativo con foreach:</h2>";
    foreach ($arrayAsociativo as $clave => $valor) {
        echo "$clave: $valor<br>";
    }
    ?>
</body>
</html>

