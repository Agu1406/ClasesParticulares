<?php
// Creación de las variables utilizadas en el ejercicio al principio del script.
$opcionMenu;

while ($opcionMenu != 4) {
    // Función para mostrar el menú de opciones del programa.
    MostrarMenu();
    // Solicitud de una opción del menú con "readline" y "prompt".
    $opcionMenu = readline("Elige una opción: ");

    switch ($opcionMenu) {
        case 1:
            CalcularAreaRectangulo();
            break;
        case 2:
            ConvertirTemperaturaCF();
            break;
        case 3:
            DiferenciaTiempoFechas();
            break;
        case 4:
            echo "¡Gracías por usar este programa! Hasta luego.";
            break;
        default:
            echo "¡Has elegido una opción no valida! Intentalo de nuevo.";
            break;
    };
};

/**
 * Función auxiliar que valida si un valor es un número.
 * @return int
 */
function ValidarNumero($mensaje)
{
    $valor = null;

    while (!is_numeric($valor)) {
        $valor = readline($mensaje);

        if (!is_numeric($valor)) {
            echo "¡Error! El valor debe ser un número, intentalo de nuevo. \n";
        }
    }

    return (int)$valor;
}


/**
 * Función auxiliar que valida que un valor sea un número positivo mayor a cero.
 * @return int
 */
function ValidarNumeroPositivo($mensaje)
{
    $valor = null;

    while (!is_numeric($valor) || $valor <= 0) {
        $valor = readline($mensaje);

        if (!is_numeric($valor) || $valor <= 0) {
            echo "¡Error! El valor debe ser un número positivo, intentalo de nuevo. \n";
        }
    }

    return (int) $valor;
}

/**
 * Función encargada de calcular el aréa de un rectángulo (en centimetros cuadrados) usando la base y altura 
 * (en centimetros) del mismo.
 * @return void
 */
function CalcularAreaRectangulo()
{
    // Solicitud, intercepción y validación de datos con función auxiliar.
    $base = ValidarNumeroPositivo("¿Cual es la base (en centimetros) del rectangulo?: ");
    $altura = ValidarNumeroPositivo("¿Cual es la altura (en centimetros) del rectangulo?: ");

    // Logica de la función.
    $area = $base * $altura;

    // Imprimir resultado del calculo.
    echo "El aréa de un rectángulo cuya base es de {$base} centimetros y cuya altura es de {$altura} centimetros es {$area} centimetros cuadrados. \n";
}

/**
 * Función que convierte una "X" temperatura dada en centigrados a farenheit.
 * @return void
 */
function ConvertirTemperaturaCF()
{
    // Solicitud e intercepción de datos.
    $centigrados = ValidarNumero("¿Cuantos grados centigrados deseas convertir a farenheit?: ");

    // Logica de la función.
    $farenheit = (($centigrados * 9) / 5) + 32;

    // Imprimir resultado del calculo.
    echo "{$centigrados} grados centigrados son {$farenheit} grados farenheit. \n";
}

/**
 * Función encargada de recibir, validar y mostrar la diferencia en días entre dos fechas.
 * @return void
 */
function DiferenciaTiempoFechas() {
    // Solicitud e intercepción de datos.
    $fechaA = ValidarFecha("Introduce la primera fecha (DD-MM-YYYY): ");
    $fechaB = ValidarFecha("Introduce la segunda fecha (DD-MM-YYYY): ");

    // Logica delegada a función auxiliar reutilizable.
    $diferencia = $fechaA->diff($fechaB);

    // Imprimir resultado del calculo.
    echo "La diferencia entre las fechas es de {$diferencia->days} días.\n";
}

/**
 * Función encargada de validar que una fecha cualquiera ha sido escrita correctamente, donde
 * correcto se entienden ambos, el formato internacional ISO-8601 (YYYY-MM-DD) y el formato 
 * tradicional español (DD-MM-YYYY).
 * @param string $fecha
 * @return DateTime
 */
function ValidarFecha($mensaje) {
    do {
        // Solicitud e intercepción de datos.
        $fechaCruda = readline($mensaje);

        // Intento de convertir el String en una instancia de DateTime usando formato "d-m-Y".
        $fechaFinal = DateTime::createFromFormat("d-m-Y", $fechaCruda);

        // Si la conversión falla devuelve "false", ejecuta el "if" y el bucle continua.
        if (!$fechaFinal) {
            echo "¡Error! La fecha debe tener formato DD-MM-YYYY. \n";
        }

    } while (!$fechaFinal);

    return $fechaFinal;
}
/**
 * Función que muestra con "echo" las ocpiones del menú del script.
 * @return void
 */
function MostrarMenu()
{
    echo "
    ¡Elige una de las siguientes opciones! \n
    1.) Calcular aréa de un rectangúlo \n
    2.) Convertir temperatura de centigrados a farenheit. \n
    3.) Calcular la distancia (en tiempo) entre dos fechas dadas. \n
    4.) Salir del programa. \n \n";
}
