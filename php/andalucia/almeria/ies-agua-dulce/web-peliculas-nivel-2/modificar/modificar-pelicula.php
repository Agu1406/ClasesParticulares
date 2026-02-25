<?php
//Incluimos los archivos necesarios
require_once "../funciones/connect-db.php";
require_once "../funciones/dao-peliculas.php";

//Creamos la conexión
$conexion = conectarDB();

// Array para guardar los datos que lleguen correctos del formulario.
$datosCorrectos = [];

// Si la conexión falla avisamos con un error.
if ($conexion === false) {
    echo "¡Error! No se ha podido conectar a la base de datos.";
    exit;
}

// Array para guardar los errores que nos encontremos durante las validaciones.
$errores = [];

// Si se accede a esta URL/URI y no hay nada dentro de "POST" lo devuelve al formulario.
if ($_SERVER["REQUEST_METHOD"] !== "POST") {
    $errores[] = "¡Error! No hay nada en POST para validar";
} else {

    /************************* VALIDACIÓN DEL ID DE LA PELICULA  ************************/

    // Verificamos que se ha recibido el id y que es un número entero
    $idPelicula = filter_input(INPUT_POST, "id", FILTER_VALIDATE_INT);

    // Si el id es false/null o menor-igual a cero, error, no es válido.
    if ($idPelicula === false || $idPelicula === null || $idPelicula <= 0) {
        $errores[] = "¡Error! El ID de la película no es válido o no se ha recibido.";
    } else {
        // Verificamos que la película existe antes de continuar
        $peliculaExiste = obtenerPeliculaPorId($conexion, $idPelicula);
        if ($peliculaExiste === false) {
            $errores[] = "¡Error! La película con el ID indicado no existe.";
        }
    }

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

// Si hay errores, los mostramos
if (!empty($errores)) {
?>
    <!DOCTYPE html>
    <html lang="es">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Resultado modificación película</title>
    </head>

    <body>
        <H1>Autor/a: RAFAEL MORONES BURGOS - Ejercicio 4 - Tarea 2 </H1>
        <h2>No se ha podido modificar la película porque los datos recibidos del formulario son incorrectos:</h2>
        <div style="color: red; margin: 20px 0;">
            <ul>
                <?php foreach ($errores as $error): ?>
                    <li><?= htmlspecialchars($error) ?></li>
                <?php endforeach; ?>
            </ul>
        </div>
        <a href="../index/index.php">Ir a la página principal</a><br><br>
    </body>

    </html>
<?php
} else {
    // Si no hay errores y el id es válido, procedemos a actualizar
    if (isset($idPelicula) && $idPelicula > 0) {
        $filasModificadas = actualizarPelicula($conexion, $idPelicula, $datosCorrectos);

        if ($filasModificadas === false) {
            // La película no existe o no se pudo modificar
            $mensaje = "Película no existe: El ID de la película no es válido o no existe.";
            $tipoMensaje = "error";
        } else {
            // La película se modificó correctamente
            $mensaje = "Película modificada correctamente. Número de registros modificados: " . $filasModificadas;
            $tipoMensaje = "exito";
        }
    } else {
        $mensaje = "Película no existe: El ID de la película no es válido o no existe.";
        $tipoMensaje = "error";
    }
?>
    <!DOCTYPE html>
    <html lang="es">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Resultado modificación película</title>
    </head>

    <body>
        <H1>Autor/a: RAFAEL MORONES BURGOS - Ejercicio 4 - Tarea 2 </H1>
        <h2>Resultado de la acción:</h2>
        <?php if ($tipoMensaje === "exito"): ?>
            <div style="color: green; margin: 20px 0;">
                <p><?= htmlspecialchars($mensaje) ?></p>
            </div>
        <?php else: ?>
            <div style="color: red; margin: 20px 0;">
                <p><?= htmlspecialchars($mensaje) ?></p>
            </div>
        <?php endif; ?>
        <a href="../index/index.php">Ir a la página principal</a><br><br>
    </body>

    </html>
<?php
}
?>

