<?php
require_once "accesoareaprivada.php";
require_once "../funciones/dao.php";
require_once "../funciones/dbconn.php";

$conexion = conectarDB();
$errores = [];
$resultadoInsertarVoto = null;

// Comprobamos que existe una votación en curso
if (!isset($_SESSION['voto_en_curso'])) {
    $errores[] = "No hay ninguna votación en curso.";
} else {
    $voto = $_SESSION['voto_en_curso'];
    $idPelicula = $voto['id_pelicula'];
    $valoracion = $voto['valoracion'];
    $comentario = $voto['comentario'];
    $idUsuario = $_SESSION['id'];

    // Comprobamos método y checkboxes
    if ($_SERVER['REQUEST_METHOD'] !== 'POST') {
        $errores[] = "El formulario no ha sido enviado correctamente.";
    } elseif (empty($_POST['confirmar']) || empty($_POST['declaracion'])) {
        $errores[] = "Debe marcar ambas casillas de confirmación para enviar el voto.";
    }

    // Si no hay errores, procedemos a insertar
    if (empty($errores)) {
        if ($conexion === false) {
            $errores[] = "No ha sido posible establecer una conexión con la base de datos.";
        } else {
            $votoRegistrado = consultarVoto($conexion, $idUsuario, $idPelicula);

            if ($votoRegistrado === null) {
                $errores[] = "Se ha producido un error al comprobar el voto.";
            } elseif ($votoRegistrado === true) {
                $errores[] = "Ya has votado esta película anteriormente.";
                unset($_SESSION['voto_en_curso']);
            } else {
                $nuevoVoto = [
                    'valoracion' => $valoracion,
                    'comentario' => $comentario,
                    'pelicula' => $idPelicula,
                    'usuario' => $idUsuario
                ];

                $resultadoInsertarVoto = insertarNuevoVoto($conexion, $nuevoVoto);

                if ($resultadoInsertarVoto === false) {
                    $errores[] = "Ha habido un error al registrar el voto.";
                } else {
                    unset($_SESSION['voto_en_curso']);
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
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
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
        <?php if (isset($_SESSION['voto_en_curso'])): ?>
            <p><a href="form-confirmar-voto.php">Volver a la confirmación de voto</a></p>
        <?php endif; ?>
        <p><a href="../index/index.php">Volver al listado de películas</a></p>

    <?php elseif ($resultadoInsertarVoto): ?>
        <h2>¡FELICIDADES!</h2>
        <p>Su voto ha sido registrado con número: <?= htmlspecialchars($resultadoInsertarVoto) ?></p>
        <p><a href="../index/index.php">Volver al listado de películas</a></p>

    <?php endif; ?>
</body>
</html>
