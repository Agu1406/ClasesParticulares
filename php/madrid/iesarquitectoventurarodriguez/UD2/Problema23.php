<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Problema23</title>
</head>
<body>
    <?php
    // Generar y almacenar todas las tablas de multiplicar del 1 al 10
    $tablasMultiplicar = array();
    
    for ($numero = 1; $numero <= 10; $numero++) {
        $tablasMultiplicar[$numero] = array();
        for ($multiplicador = 1; $multiplicador <= 10; $multiplicador++) {
            $tablasMultiplicar[$numero][$multiplicador] = $numero * $multiplicador;
        }
    }
    
    echo "<h2>Todas las tablas de multiplicar (1 al 10):</h2>";
    echo "<pre>";
    print_r($tablasMultiplicar);
    echo "</pre>";
    
    // Mostrar una tabla en concreto (por ejemplo, la del 7)
    $tablaSeleccionada = 7;
    echo "<h2>Tabla de multiplicar del $tablaSeleccionada:</h2>";
    echo "<table border='1' cellpadding='5'>";
    echo "<tr><th>Multiplicación</th><th>Resultado</th></tr>";
    
    for ($i = 1; $i <= 10; $i++) {
        echo "<tr>";
        echo "<td>$tablaSeleccionada x $i</td>";
        echo "<td>" . $tablasMultiplicar[$tablaSeleccionada][$i] . "</td>";
        echo "</tr>";
    }
    
    echo "</table>";
    
    // Ejemplo: mostrar otra tabla
    $tablaSeleccionada2 = 9;
    echo "<h2>Tabla de multiplicar del $tablaSeleccionada2:</h2>";
    echo "<table border='1' cellpadding='5'>";
    echo "<tr><th>Multiplicación</th><th>Resultado</th></tr>";
    
    for ($i = 1; $i <= 10; $i++) {
        echo "<tr>";
        echo "<td>$tablaSeleccionada2 x $i</td>";
        echo "<td>" . $tablasMultiplicar[$tablaSeleccionada2][$i] . "</td>";
        echo "</tr>";
    }
    
    echo "</table>";
    ?>
</body>
</html>

