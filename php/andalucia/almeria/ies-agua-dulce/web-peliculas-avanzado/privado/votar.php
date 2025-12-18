<?php
//Nos aseguramos la sesión está iniciada y no hemos excedido el tiempo
require_once "accesoareaprivada.php";

//Cargamos las funciones definidas en DAO
require_once "../funciones/dao.php";
require_once "../funciones/dbconn.php";

//Variables auxiliares
$conexion = conectarDB();
$errores = [];
$voto = null;
$votoRegistrado = false;
$nuevoVoto = [];

//Comprobamos que existe $voto;
if (!isset($_SESSION['voto_en_curso'])) {
    $errores[] = "No hay ninguna votación en curso.";
    //en caso de que exista
} else {
    $voto = $_SESSION['voto_en_curso'];
    $idPelicula = $voto['id_pelicula'];
    $valoracion = $voto['valoracion'];
    $comentario = $voto['comentario'];
    $idUsuario = $_SESSION['id'];

    // Comprobamos que se ha llegado aqui por el formulario
    if ($_SERVER['REQUEST_METHOD'] !== 'POST') {
        $errores[] = "El formulario no ha sido enviado por POST.";
        //Y que los 2 checks están marcados
    } else {
        if (empty($_POST['confirmar']) || empty($_POST['declaracion'])) {
            $errores[] = "Debe marcar ambas casillas de confirmación para enviar el voto.";
        }
    }

    //Si no hay errores hasta ahora comprobamos la conexión. 
    if (empty($errores)) {
        if ($conexion === false) {
            $errores[] = "No ha sido posible establecer una conexión con la base de datos.";
        } else {
            // Comprobamos si el usuario ya ha votado esta película
            $votoRegistrado = consultarVoto($conexion, $idUsuario, $idPelicula);

            if ($votoRegistrado === null) {
                $errores[] = "Se ha producido un error al comprobar el voto.";
            } else if ($votoRegistrado === true) {
                $errores[] = "El usuario ya ha votado al menos una vez esta película.";
                //Si no ha votado creamos un array llamado nuevoVoto
            } else {

                $nuevoVoto = [ //este array lo usamos como parámetros para la función de insertar voto en la BD
                    'valoracion' => $valoracion,
                    'comentario' => $comentario,
                    'idPelicula' => $idPelicula,
                    'idUsuario' => $idUsuario
                ];

                //Guardamos la llamada de la función en una variable
                $resultadoInsertarVoto = insertarNuevoVoto($conexion, $nuevoVoto);

                if ($resultadoInsertarVoto === false) {
                    $errores[] = "ha habido un error a la hora de insertar el voto";
                }
            }
        }
    }

    // 5) En cualquier caso, descartamos la votación en curso
    unset($_SESSION['voto_en_curso']);
}
?>

<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=100%, initial-scale=1.0">
    <title>Proceso de votación</title>
</head>

<body>
    <h1>DWES 03. AUTOR: RAFAEL MORONES BURGOS.</h1>

    <?php if (!empty($errores)): ?>
        <h2>Se han producido los siguientes errores:</h2>
        <ul>
            <?php foreach ($errores as $error): ?>
                <li><?= htmlspecialchars($error) ?></li>
            <?php endforeach; ?>
        </ul>

        <h3>No ha seguido el proceso de votación correctamente.</h3>
        <h4>Por favor, regrese al listado de películas y vuelva a iniciar el proceso.</h4>
        <a href="../index/index.php">Volver al inicio</a>
        <a href="form-confirmar-voto.php">Volver a la confirmación de voto.</a>

    <?php elseif ($votoRegistrado): ?>
        <h3>Ya había registrado un voto para esta película.</h3>
        <h4>Por favor, regrese al listado de películas.</h4>
        <a href="../index/index.php">Volver al inicio</a>

    <?php else: ?>
        <h3>¡FELICIDADES! Su voto ha sido registrado con número:</h3>
        <p><?= htmlspecialchars($resultadoInsertarVoto) ?></p>
        <a href="../index/index.php">Volver al inicio</a>
    <?php endif; ?>
</body>

</html>