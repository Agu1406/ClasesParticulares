<?php
//Incluimos los archivos necesarios
require_once "../funciones/connect-db.php";
require_once "../funciones/dao-peliculas.php";

//Creamos la conexión
$conexion = conectarDB();

// Array para guadar los datos que lleguen correctos del formulario.
$datosCorrectos = [];

// Si la conexión falla avisamos con un error.
if ($conexion === false) {
    echo "¡Error! No se ha podido conectar a la base de datos.";
}

// Array para guardar los errores que nos encontremos durante las validaciones.
$errores = [];

// Si se accede a esta URL/URI y no hay nada dentro de "POST" lo devuelve al formulario.
if ($_SERVER["REQUEST_METHOD"] !== "POST") {
    echo "¡Error! No hay nada en POST para validar";
} else {

    /**
     * normalmente para sacar los datos de $_POST tendríamos que hacer algo como lo
     * siguiente:
     * 
     * $titulo = $_POST["titulo"];
     * 
     * Sin embargo, "filter_input" nos ahorra ese paso porque el automaticamente saca
     * de $_POST los datos al utilizar el argumento en la función de tipeado "INPUT_POST".
     */

    /************************* VALIDACIÓN DEL TITUTLO DE LA PELICULA  ************************/

    // Filtra y limpia el "titulo" de carácteres especiales y posibles inyecciones de código.
    $titulo = filter_input(INPUT_POST, "titulo", FILTER_SANITIZE_SPECIAL_CHARS);

    // Si el titulo esta vacio (false) o es nulo (null) guardamos el error.
    if ($titulo === null || $titulo === false) {
        $errores[] = "¡Error! Titulo incorrecto, intentalo de nuevo.";
    }
    // Si no esta vacio hacemos el resto de validaciones.
    else {
        // Borramos todos los espacios en blanco adelante o atrás.
        $titulo = trim($titulo);

        // Si el titutlo era ("   ") y al borrar los espacios es ("") entonces esta vacio, error.
        if (empty($titulo)) {
            $errores[] = "El titulo no puede estar vacio.";
        }
        // Validamos que el String no sea más grande que 60 carácteres (tamaño maximo)
        elseif (strlen($titulo) > 60) {
            $errores[] = "El titutlo no puede superar los 60 carácteres.";
        }
        // Si nada salio mal anteriormente el dato es correcto, lo guardamos.
        else {
            $datosCorrectos["titulo"] = $titulo;
        }
    }

    /************************* VALIDACIÓN DEL GENERO DE LA PELICULA  ************************/

    // Valida que el dato sea un número entero valido, si no lo es devuelve null/false.
    $genero = filter_input(INPUT_POST, "genero", FILTER_VALIDATE_INT);

    // Si el genero es false/null o menor-igual a cero, error, no es valido.
    if ($genero === false || $genero === null || $genero <= 0) {
        // Guardamos el mensaje de error respectivo.
        $errores[] = "¡Error! El genero no es valido, debe ser un número entero positivo mayor a 0.";
    } else {
        // Obtenemos todos los datos que existan en la base de datos.
        $generos = listadoPorGeneros($conexion);

        // Si intentamos obtener los generos que existen y da error, guardamos el error.
        if ($generos === false) {
            $errores[] = "¡Error! No se han podido cargar los generos de la base de datos.";
        }
        // Si no hay error entonces podemos usarlos para hacer las validaciones.
        else {
            // Guardamos en un Array solo los ID's de los generos (es lo unico necesario para validaciones).
            $IDSGeneros = array_column($generos, "id");

            /**
             * "!in_array" revisa el Array de "IDSGeneros" verificando si existe un genero igual
             * al recibido desde el formulario cuyo nombre es "$genero", por ejemplo, si "$genero"
             * es "10" y ese número no exisre en "IDSGeneros" significa que el genero no existe y
             * por lo tanto no es valido.
             */
            if (!in_array($genero, $IDSGeneros)) {
                $errores[] = "¡Error! El genero que has seleccionado no existe en la base de datos.";
            }
            // Si llegamos hasta aquí sin erorres entonces el genero si es valido.
            else {
                $datosCorrectos["genero"] = $genero;
            }
        }
    }

    /************************* VALIDACIÓN DEL AÑO DE LA PELICULA  ************************/

    //Comprobamos si el dato es número y está dentro del rango
    $anio = filter_input(INPUT_POST, 'anio', FILTER_VALIDATE_INT, [
        'options' => ['min_range' => 1960, 'max_range' => date("Y")]
    ]);

    //Si no es un dato valido o fuera de rango devuelve false
    if ($anio === false || $anio === null) {
        $errores[] = "¡Error! El año debe ser un número entero entre 1960 y " . date("Y") . ".";
    } else {
        //Si el dato es válido lo añadimos al array
        $datosCorrectos["anio"] = $anio;
    }

    /************************* VALIDACIÓN DE LA DIRECCIÓN DE LA PELICULA  ************************/

    // Filtra y limpia la "direccion" de carácteres especiales y posibles inyecciones de código.
    $direccion = filter_input(INPUT_POST, "direccion", FILTER_SANITIZE_SPECIAL_CHARS);

    // Si la direccion esta vacia (false) o es nula (null) guardamos el error.
    if ($direccion === null || $direccion === false) {
        $errores[] = "¡Error! Dirección incorrecta, intentalo de nuevo.";
    }
    // Si no esta vacia hacemos el resto de validaciones.
    else {
        // Borramos todos los espacios en blanco adelante o atrás.
        $direccion = trim($direccion);

        // Si la direccion era ("   ") y al borrar los espacios es ("") entonces esta vacia, error.
        if (empty($direccion)) {
            $errores[] = "La dirección no puede estar vacía.";
        }
        // Validamos que la dirección no sea un número
        elseif (is_numeric($direccion)) {
            $errores[] = "La dirección no puede ser un número.";
        }
        // Validamos que el String no sea más grande que 100 carácteres (tamaño maximo)
        elseif (strlen($direccion) > 100) {
            $errores[] = "La dirección no puede superar los 100 carácteres.";
        }
        // Si nada salio mal anteriormente el dato es correcto, lo guardamos.
        else {
            $datosCorrectos["direccion"] = $direccion;
        }
    }

    /************************* VALIDACIÓN DE LA DURACION DE LA PELICULA  ************************/

    //Comprobamos si el dato es número y está dentro del rango
    $duracion = filter_input(INPUT_POST, 'duracion', FILTER_VALIDATE_INT, [
        'options' => ['min_range' => 1, 'max_range' => 499]
    ]);

    //Si no es un dato valido o fuera de rango devuelve false
    if ($duracion === false || $duracion === null) {
        $errores[] = "¡Error! La duración debe ser un número entero mayor de 0 y menor de 500.";
    } else {
        //Si el dato es válido lo añadimos al array
        $datosCorrectos["duracion"] = $duracion;
    }

    /************************* VALIDACIÓN DEL ARGUMENTO DE LA PELICULA  ************************/

    // Filtra y limpia el "argumento" de carácteres especiales y posibles inyecciones de código.
    $argumento = filter_input(INPUT_POST, "argumento", FILTER_SANITIZE_SPECIAL_CHARS);

    // Si el argumento esta vacio (false) o es nulo (null) guardamos el error.
    if ($argumento === null || $argumento === false) {
        $errores[] = "¡Error! Argumento incorrecto, intentalo de nuevo.";
    }
    // Si no esta vacio hacemos el resto de validaciones.
    else {
        // Borramos todos los espacios en blanco adelante o atrás.
        $argumento = trim($argumento);

        // Si el argumento era ("   ") y al borrar los espacios es ("") entonces esta vacio, error.
        if (empty($argumento)) {
            $errores[] = "El Argumento no puede estar vacio.";
        }
        // Validamos que el String no sea más grande que 255 carácteres (tamaño maximo)
        elseif (strlen($argumento) > 255) {
            $errores[] = "El Argumento no puede superar los 255 carácteres.";
        }
        // Si nada salio mal anteriormente el dato es correcto, lo guardamos.
        else {
            $datosCorrectos["argumento"] = $argumento;
        }
    }
}


// El formulario ya tiene su propio HTML completo, así que hacemos exit para no mostrar el HTML de abajo
if (!empty($errores)) {
    // Inicializamos $datos con todos los campos vacíos
    $datos = [
        "titulo" => "",
        "genero" => "",
        "direccion" => "",
        "duracion" => "",
        "argumento" => "",
        "anio" => ""
    ];
    // Sobrescribimos solo los campos que pasaron la validación
    $datos = array_merge($datos, $datosCorrectos);
    // Pasamos las variables al formulario para que muestre los errores y valores correctos
    include 'form-insertar-pelicula.php';
    exit; // Importante: salimos para que no se ejecute el código de abajo
}
// Si no hay errores entonces si mostramos el HTML de abajo e intentamos insertar la pelicula.
else {

    // Si todos los datos son correctos, procedemos a insertar
    $idInsertado = insertarPelicula($conexion, $datosCorrectos);

?>

    <!DOCTYPE html>
    <html lang="es">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Resultado inserción</title>
    </head>

    <body>
        <H1>Autor/a: INDICAR AUTOR/A - Ejercicio 3 - Tarea 2 </H1>
        Resultado de la acción:
        <a href="../index/index.php">Ir a la página principal</a><br><br>

        <?php if ($idInsertado === false): ?>
            <h2>Error: No se pudo insertar la película en la base de datos.</h2>
        <?php else: ?>
            <h2>La película ha sido insertada correctamente y su identificador es <?= htmlspecialchars($idInsertado) ?></h2>
        <?php endif; ?>

    </body>

    </html>
<?php }

?>