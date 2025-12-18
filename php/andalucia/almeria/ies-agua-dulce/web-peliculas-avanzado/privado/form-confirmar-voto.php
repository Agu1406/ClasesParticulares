<?php
require_once "accesoareaprivada.php";
require_once "../funciones/dao.php";
require_once "../funciones/dbconn.php";


//Variables auxiliares
$errores = []; //Array para guardar errores
$conexion = conectarDB(); //para crear una conexión
$voto = null; // variable para guardar el voto 
$datosCorrectos = []; //Array para guardar datos correctos
$pelicula = null; //Array para cargar la película
$generos = null; //Array para cargar los géneros
$idNombreGeneros = [];
$idPelicula = null;


// Coprobamos si hay una votación en curso (ya validada previamente)
if (isset($_SESSION["voto_en_curso"])) {
    $voto = $_SESSION["voto_en_curso"];
    $idPelicula = $voto['id_pelicula'];
    $errores = []; // evitamos validaciones posteriores
} else {
    //Comprobamos si llega por enlace directo (votar.php)
    if ($_SERVER['REQUEST_METHOD'] === 'GET') {
        $errores[] = "No hay ninguna votación en curso. Por favor, inicie la votación desde el listado de películas.";
        echo '<a href="../index/index.php">Volver al inicio</a>';
        //Comprobamos que viene por el método post
    } elseif ($_SERVER['REQUEST_METHOD'] !== 'POST') {
        $errores[] = "El formulario no ha sido enviado por POST";
    } else {
        //Si ha sido enviada por POST comprobamos que no está vacío
        if (empty($_POST)) {
            $errores[] = "La petición no puede estar vacía";

            //Validadción datos recibidos por POST
        } else {

            //Validación ID PELICULA
            $idPelicula = filter_input(INPUT_POST, 'id_pelicula', FILTER_VALIDATE_INT);
            if ($idPelicula === false || $idPelicula === null) {
                $errores[] = "El id de la película no es válido";
            } else {
                $datosCorrectos['id_pelicula'] = $idPelicula;
            }

            //validación de la PUNTUACIÓN
            $valoracion = filter_input(INPUT_POST, 'valoracion', FILTER_VALIDATE_INT);

            if ($valoracion === false || $valoracion === null) {
                $errores[] = "La valoración de la película no es válida";
            } else if ($valoracion < 1 || $valoracion > 5) {
                $errores[] = "La valoración debe de estar entre 1 y 5";
            } else {
                $datosCorrectos['valoracion'] = $valoracion;
            }

            //Validación del COMENTARIO
            $comentario = filter_input(INPUT_POST, 'comentario', FILTER_SANITIZE_SPECIAL_CHARS);

            if ($comentario === null) {
                $errores[] = "El comentario de la película no es válido";
            } else {
                $comentario = trim($comentario);

                if (empty($comentario)) {
                    $errores[] = "El comentario no puede estar vacío";
                } else {
                    $datosCorrectos['comentario'] = $comentario;
                }
            }

            // Si hay errores guardamos en un array los errores para repintar form-nuevo-voto-php
            if (!empty($errores)) {
                $_SESSION['voto_form'] = [
                    'id_pelicula' => $idPelicula ?? "",
                    'valoracion' => $valoracion ?? "",
                    'comentario' => $comentario ?? ""
                ];
                //Redireccionamos a form-nuevo-voto.php
                header('Location: form-nuevo-voto.php');
                exit();
            }

            //Si no existe errores guardamos la votación del usuario (ya validada)
            if (empty($errores)) {
                $_SESSION['voto_en_curso'] = [
                    'id_pelicula' => $datosCorrectos['id_pelicula'],
                    'valoracion'  => $datosCorrectos['valoracion'],
                    'comentario'  => $datosCorrectos['comentario']
                ];

                $voto = $_SESSION['voto_en_curso'];
                // Opcional: como ya tenemos un voto válido, podemos limpiar el borrador
                unset($_SESSION['voto_form']);
            }
        } // else si el array POST no está vacío
    } // else si el voto ha llegado por el método POST
} // else si no existe aún el voto


//Si no existe errores y el id de la pelicula es valido
if (empty($errores) && $idPelicula !== null) {

    //Comprobamos la conexión
    if ($conexion === false) {
        $errores[] = "No ha sido posible establecer una conexión con la base de datos.";
    } else {
        // Si existe conexión cargamso la película
        $pelicula = obtenerPeliculaPorID($conexion, $idPelicula);
        if (empty($pelicula)) {
            $errores[] = "No hemos podido encontrar la película";
        } else {
            // Cargamos los géneros. 
            $generos = listadoPorGeneros($conexion);
            if ($generos === false || empty($generos)) {
                $errores[] = "El listado de géneros no ha sido localizado o está vacío";
            } else {
                foreach ($generos as $genero) {
                    $idNombreGeneros[$genero['id']] = $genero['nombre'];
                }
            }
        }
    }
}
?>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=100%, initial-scale=1.0">
    <title>Confirme la valoración</title>
</head>

<body>
    <H1>DWES 03. AUTOR: RAFAEL MORONES BURGOS.</H1>

    <?php
    // Mostrar errores si los hay
    if (!empty($errores)) {
        echo "<ul>";
        foreach ($errores as $error) {
            echo "<li>" . htmlspecialchars($error) . "</li>";
        }
        echo "</ul>";
        //enlace para volver al formulario inicial en caso de error
        echo '<p><a href="form-nuevo-voto.php">Volver al formulario de voto</a></p>';
        echo '<p><a href="../index/index.php">Volver al listado de películas</a></p>';
    } else {
    ?>
        <h1>Confirme la valoración</h1>

        <?php if ($pelicula !== null): ?>
            <H2>Datos de la película</H2>
            <div>
                <strong>Título:</strong> <?= htmlspecialchars($pelicula['titulo']) ?><br>
                <strong>Genero:</strong> <?= htmlspecialchars($idNombreGeneros[$pelicula['genero']]) ?><br>
                <strong>Director:</strong> <?= htmlspecialchars($pelicula['direccion']) ?><br>
                <strong>Duración:</strong> <?= htmlspecialchars($pelicula['duracion']) ?> minutos<br>
                <strong>Año:</strong> <?= htmlspecialchars($pelicula['anio']) ?><br><br>
            </div>
            <hr>
        <?php endif; ?>

        <h2>Por favor, confirme su valoración y comentario</h2>
        <div>
            <strong>Valoración:</strong> <?= htmlspecialchars($voto['valoracion']) ?><br>
            <label for="comentario">Comentario:</label><br>
            <textarea id="comentario" rows="4" cols="50"><?= htmlspecialchars($voto['comentario']) ?></textarea>

            <div></div>
        </div>
        <form action="votar.php" method="POST">
            <input type="checkbox" name="confirmar" value="1"> Haz clic aquí para confirmar que desea enviar esta valoración y comentario.
            <br>
            <input type="checkbox" name="declaracion" value="1"> Declaro que mi valoración y crítica se ajustan a las normas de la comunidad
            y soy consciente de que cualquier incumplimiento puede conllevar la eliminación de mi cuenta.
            <br>
            <input type="submit" value="Confirmar voto y comentario">
        </form>
        <form action="descartarvoto.php" method="POST">
            <input type="submit" value="Descartar voto y comentario">
        </form>
    <?php
    }
    ?>
</body>

</html>