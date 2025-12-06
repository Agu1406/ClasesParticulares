<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Problema12</title>
</head>
<body>
    <?php
    function calculadora($a, $b, $operador) {
        switch ($operador) {
            case '+':
                return $a + $b;
            case '-':
                return $a - $b;
            case '*':
                return $a * $b;
            case '/':
                if ($b != 0) {
                    return $a / $b;
                } else {
                    return "Error: División por cero";
                }
            default:
                return "Operador no válido";
        }
    }
    
    // Ejemplos de uso
    echo "5 + 3 = " . calculadora(5, 3, '+') . "<br>";
    echo "10 - 4 = " . calculadora(10, 4, '-') . "<br>";
    echo "6 * 7 = " . calculadora(6, 7, '*') . "<br>";
    echo "15 / 3 = " . calculadora(15, 3, '/') . "<br>";
    echo "10 / 0 = " . calculadora(10, 0, '/') . "<br>";
    ?>
</body>
</html>

