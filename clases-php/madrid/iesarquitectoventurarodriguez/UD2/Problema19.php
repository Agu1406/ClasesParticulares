<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <?php
    #19. (Entregable) Realizar una función recursiva para implementar la división mediante restas.

    /**
     * Funcion recursiva que nos permite verificar cuantas veces es posible
     * dividir un dividendo entre un divisor de forma recursiva sin llegar
     * a números negativos.º
     */
    function divisionRecursiva($dividendo, $divisor, $contador = 0) {

        if ($dividendo < $divisor) {
            // Cuando el dividendo sea menor al divisor la función para.
            return $contador;
        }
        /**
         * La función funciona como un bucle, se llama así misma y en cada
         * llamada va actualizando sus valores, por ejemplo, con "20" y "4".
         * 
         * (Argumento1) 20 - 4 = 16, (Argumento2) 4, (Argumento3) 0 + 1 = 1.
         * (Argumento1) 20 - 4 = 12, (Argumento2) 4, (Argumento3) 1 + 1 = 2.
         * (Argumento1) 20 - 4 = 08, (Argumento2) 4, (Argumento3) 2 + 1 = 3.
         * (Argumento1) 20 - 4 = 04, (Argumento2) 4, (Argumento3) 3 + 1 = 4.
         * (Argumento1) 20 - 4 = 00, (Argumento2) 4, (Argumento3) 4 + 1 = 5.
         */
        return divisionRecursiva($dividendo - $divisor, $divisor, $contador + 1);
    }

    // Elegimos dos números para hacer la prueba (dividendo y divisor).
    $dividendo = 20; 
    $divisor = 4;

    // Llamo a la función para que me devuelva el valor de contador.
    $resultado = divisionRecursiva($dividendo, $divisor);

    // Nos muestra cuantas veces es divisivle el número 20 entre 4 de forma recursiva.
    echo "El número $dividendo dividido entre $divisor se puede divivir un total de $resultado veces de forma recursiva.";
    ?>
</body>
</html>