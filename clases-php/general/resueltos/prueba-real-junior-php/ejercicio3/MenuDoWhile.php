<?php
$opcionMenu;

do {
    MostrarMenu();
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
} while ($opcionMenu != 4);

function ValidarNumero($mensaje)
{
    $valor = null;

    do {
        $valor = readline($mensaje);

        if (!is_numeric($valor)) {
            echo "¡Error! El valor debe ser un número, intentalo de nuevo. \n";
        }
    } while (!is_numeric($valor));

    return (int)$valor;
}

function ValidarNumeroPositivo($mensaje)
{
    $valor = null;

    do {
        $valor = readline($mensaje);

        if (!is_numeric($valor) || $valor <= 0) {
            echo "¡Error! El valor debe ser un número positivo, intentalo de nuevo. \n";
        }
    } while (!is_numeric($valor) || $valor <= 0);

    return (int) $valor;
}

function CalcularAreaRectangulo()
{
    $base = ValidarNumeroPositivo("¿Cual es la base (en centimetros) del rectangulo?: ");
    $altura = ValidarNumeroPositivo("¿Cual es la altura (en centimetros) del rectangulo?: ");

    $area = $base * $altura;

    echo "El aréa de un rectángulo cuya base es de {$base} centimetros y cuya altura es de {$altura} centimetros es {$area} centimetros cuadrados. \n";
}

function ConvertirTemperaturaCF()
{
    $centigrados = ValidarNumero("¿Cuantos grados centigrados deseas convertir a farenheit?: ");

    $farenheit = (($centigrados * 9) / 5) + 32;

    echo "{$centigrados} grados centigrados son {$farenheit} grados farenheit. \n";
}

function DiferenciaTiempoFechas() {
    $fechaA = ValidarFecha("Introduce la primera fecha (DD-MM-YYYY): ");
    $fechaB = ValidarFecha("Introduce la segunda fecha (DD-MM-YYYY): ");

    $diferencia = $fechaA->diff($fechaB);

    echo "La diferencia entre las fechas es de {$diferencia->days} días.\n";
}

function ValidarFecha($mensaje) {
    do {
        $fechaCruda = readline($mensaje);

        $fechaFinal = DateTime::createFromFormat("d-m-Y", $fechaCruda);

        if (!$fechaFinal) {
            echo "¡Error! La fecha debe tener formato DD-MM-YYYY. \n";
        }

    } while (!$fechaFinal);

    return $fechaFinal;
}

function MostrarMenu()
{
    echo "
    ¡Elige una de las siguientes opciones! \n
    1.) Calcular aréa de un rectangúlo \n
    2.) Convertir temperatura de centigrados a farenheit. \n
    3.) Calcular la distancia (en tiempo) entre dos fechas dadas. \n
    4.) Salir del programa. \n \n";
}