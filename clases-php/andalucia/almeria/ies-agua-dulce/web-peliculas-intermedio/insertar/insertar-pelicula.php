<?php
//Incluimos los archivos necesarios
require_once "../funciones/connect-db.php";
require_once "../funciones/dao-peliculas.php";

//Creamos la conexión
$conexion = conectarDB();

//Array para almacenar errores
$errores = [];
$valoresCorrectos = [];

//Verificamos que haya conexión
if ($conexion === false) {
    die("Error: No ha sido posible establecer una conexión con la base de datos.");
}

//Si no se recibieron datos por POST, redirigimos al formulario
if ($_SERVER['REQUEST_METHOD'] !== 'POST') {
    header('Location: form-insertar-pelicula.php');
    exit;
}

//Sanitización y validación de datos usando filter_input

//Título - No puede estar vacío y no puede superar 60 caracteres
$titulo = filter_input(INPUT_POST, 'titulo', FILTER_SANITIZE_FULL_SPECIAL_CHARS);
if ($titulo === null || $titulo === false) {
    $errores[] = "El título no puede estar vacío.";
} else {
    $titulo = trim($titulo);
    if (empty($titulo)) {
        $errores[] = "El título no puede estar vacío.";
    } elseif (strlen($titulo) > 60) {
        $errores[] = "El título no puede superar los 60 caracteres.";
    } else {
        $valoresCorrectos['titulo'] = $titulo;
    }
}

//Género - Número entero mayor de cero y que corresponda a un género válido
$genero = filter_input(INPUT_POST, 'genero', FILTER_VALIDATE_INT);
if ($genero === null || $genero === false || $genero <= 0) {
    $errores[] = "El género debe ser un número entero mayor de cero.";
} else {
    //Verificamos que el género exista en la base de datos
    $generos = listadoPorGeneros($conexion);
    if ($generos === false) {
        $errores[] = "Error al verificar los géneros disponibles.";
    } else {
        $generosIds = array_column($generos, 'id');
        if (!in_array($genero, $generosIds)) {
            $errores[] = "El género seleccionado no es válido.";
        } else {
            $valoresCorrectos['genero'] = $genero;
        }
    }
}

//Año - Número entero mayor de 1960 y menor o igual al año actual
$anio = filter_input(INPUT_POST, 'anio', FILTER_VALIDATE_INT);
if ($anio === null || $anio === false) {
    $errores[] = "El año debe ser un número entero.";
} else {
    $anioActual = intval(date('Y'));
    if ($anio <= 1960 || $anio > $anioActual) {
        $errores[] = "El año debe ser mayor de 1960 y menor o igual al año actual ($anioActual).";
    } else {
        $valoresCorrectos['anio'] = $anio;
    }
}

//Dirección - No puede estar vacío y no puede superar 100 caracteres
$direccion = filter_input(INPUT_POST, 'direccion', FILTER_SANITIZE_FULL_SPECIAL_CHARS);
if ($direccion === null || $direccion === false) {
    $errores[] = "La dirección no puede estar vacía.";
} else {
    $direccion = trim($direccion);
    if (empty($direccion)) {
        $errores[] = "La dirección no puede estar vacía.";
    } elseif (strlen($direccion) > 100) {
        $errores[] = "La dirección no puede superar los 100 caracteres.";
    } else {
        $valoresCorrectos['direccion'] = $direccion;
    }
}

//Duración - Número entero mayor de 0 y menor de 500
$duracion = filter_input(INPUT_POST, 'duracion', FILTER_VALIDATE_INT);
if ($duracion === null || $duracion === false) {
    $errores[] = "La duración debe ser un número entero.";
} else {
    if ($duracion <= 0 || $duracion >= 500) {
        $errores[] = "La duración debe ser mayor de 0 y menor de 500 minutos.";
    } else {
        $valoresCorrectos['duracion'] = $duracion;
    }
}

//Argumento - No puede estar vacío y no puede superar 255 caracteres (TINYTEXT)
$argumento = filter_input(INPUT_POST, 'argumento', FILTER_SANITIZE_FULL_SPECIAL_CHARS);
if ($argumento === null || $argumento === false) {
    $errores[] = "El argumento no puede estar vacío.";
} else {
    $argumento = trim($argumento);
    if (empty($argumento)) {
        $errores[] = "El argumento no puede estar vacío.";
    } elseif (strlen($argumento) > 255) {
        $errores[] = "El argumento no puede superar los 255 caracteres.";
    } else {
        $valoresCorrectos['argumento'] = $argumento;
    }
}

//Si hay errores, pasamos las variables al formulario e incluimos el formulario
if (!empty($errores)) {
    //Pasamos las variables $errores y $valoresCorrectos al formulario
    $valores = $valoresCorrectos;
    include('form-insertar-pelicula.php');
    exit;
}

//Si todos los datos son correctos, procedemos a insertar
$idInsertado = insertarPelicula($conexion, $valoresCorrectos);

if ($idInsertado === false) {
    //Si falló la inserción, mostramos error en el formulario
    $errores = ['Error al insertar la película en la base de datos.'];
    $valores = $valoresCorrectos;
    include('form-insertar-pelicula.php');
    exit;
}
?>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Resultado inserción</title>
</head>

<body>
    <H1>Autor/a: RAFAEL MORONES BURGOS - Ejercicio 3 - Tarea 2 </H1>
    <h2>Resultado de la acción:</h2>
    <p style="color: green; font-weight: bold;">
        La película ha sido insertada correctamente y su identificador es <?= htmlspecialchars($idInsertado) ?>
    </p>
    <a href="../index.php">Ir a la página principal</a><br><br>
</body>

</html>
