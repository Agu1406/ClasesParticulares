<?php
//incluimos los archivos necesarios para la conexion
//Constantes de conexión y función de conexión
require_once "../funciones/connect-db.php";
//Función para obtener películas
require_once "../funciones/dao-peliculas.php";

//Creamos la conexion usando la funcion conectarDB
$conexion = conectarDB();

// Variables para la vista
$peliculas = false;
$todasPeliculas = false;
$generos = false;
$valorGeneros = [];
$aniosDisponibles = [];
$este_script = $_SERVER['PHP_SELF'];


//Si la conexión ha fallado termina el script
if ($conexion === false) {
    echo "No ha sido posible establecer una conexión con la base de datos.";
} else {
    // Si ha tenido éxito cargamos todas las películas sin filtros
    $peliculasTodas = listadoPeliculas($conexion, null);
    if ($peliculasTodas === false) {
        echo "Error: No ha sido posible obtener las películas para los años.";
    } else {
        // Una vez que tenemos todas las películas obtenemos los años no repetidos
        $aniosDisponibles = array_unique(array_column($peliculasTodas, 'anio'));
        sort($aniosDisponibles);
    }

    // Validamos con filter_input el año desde GET
    $anioFiltro = filter_input(INPUT_GET, 'anio', FILTER_VALIDATE_INT);
    if ($anioFiltro === false || $anioFiltro === null) {
        $anioFiltro = null;
    }

    // Obtenemos las películas filtradas o todas
    $peliculas = listadoPeliculas($conexion, $anioFiltro);

    //Verificamos que las películas hayan cargado con éxito
    if ($peliculas === false) {
        echo "Error: No ha sido posible obtener las películas.";
    } else {
        // Solo si tenemos éxito obtenemos los géneros
        $generos = listadoPorGeneros($conexion);
        if ($generos === false) {
            echo "Error: No ha sido posible obtener los géneros.";
        } else {
            foreach ($generos as $genero) {
                $valorGeneros[$genero['id']] = $genero['nombre'];
            }
        }
    }
}

?>

<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tarea 2 - Ejercicio 3</title>
    <link rel="stylesheet" href="index.css">
</head>

<body>
    <H1>Autor/a: RAFAEL MORONES BURGOS - Ejercicio 2 - Tarea 2 </H1>
    <HR>
    <a href="<?= $_SERVER['PHP_SELF'] ?>"> Resetear </a> |
    <a href="../ejercicio1.html">Ir a respuestas ejercicio 1</a> |
    <a href="../insertar/form-insertar-pelicula.php"> Ir a formulario para insertar película </a>
        <HR>
        <!-- filtro por años -->
        <H1>Haz clic para filtrar por año:</H1>
        <div>
            <?php foreach ($aniosDisponibles as $anio): ?>
                <a href="<?= $este_script . '?anio=' . urlencode($anio) ?>">
                    <?= htmlspecialchars($anio) ?>
                </a> |
            <?php endforeach; ?>
        </div>

        <!-- Tabla de películas
        Incluimos la tabla solo si tenemos películas y mapa de géneros
         -->
        <?php if ($peliculas !== false && !empty($valorGeneros)): ?>
            <?php 
            // Pasamos las variables necesarias al script incluido
            $generos = $valorGeneros; // Para compatibilidad con cargar-peliculas.php
            include('../recuperar/cargar-peliculas.php'); 
            ?>
        <?php else: ?>
            <p>No hay datos de peliculas para mostrar.</p>

        <?php endif; ?>

</body>

</html>

