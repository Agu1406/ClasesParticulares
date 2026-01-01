<?php
require_once "accesoareaprivada.php";
require_once "../funciones/dao.php";
require_once "../funciones/dbconn.php";

$errores = [];
$conexion = conectarDB();
$voto = null;
$pelicula = null;
$idNombreGeneros = [];
$idPelicula = null;

// CASO 1: Ya hay votación en curso (a medias)
if (isset($_SESSION["voto_en_curso"])) {
    $voto = $_SESSION["voto_en_curso"];
    $idPelicula = $voto['id_pelicula'];

    // CASO 2: Viene del formulario por POST (no hay votación en curso)
} elseif ($_SERVER['REQUEST_METHOD'] === 'POST' && !empty($_POST)) {
    $idPelicula = filter_input(INPUT_POST, 'id_pelicula', FILTER_VALIDATE_INT);
    $valoracion = filter_input(INPUT_POST, 'valoracion', FILTER_VALIDATE_INT);
    $comentario = trim(filter_input(INPUT_POST, 'comentario', FILTER_SANITIZE_SPECIAL_CHARS) ?? '');

    // Validaciones
    if (!$idPelicula) $errores[] = "El id de la película no es válido";
    if (!$valoracion || $valoracion < 1 || $valoracion > 5) $errores[] = "La valoración debe de estar entre 1 y 5";
    if (empty($comentario)) $errores[] = "El comentario no puede estar vacío";

    // Si hay errores, guardamos datos para repintar form-nuevo-voto.php
    if (!empty($errores)) {
        $_SESSION['voto_form'] = [
            'id_pelicula' => $idPelicula ?? "",
            'valoracion' => $valoracion ?? "",
            'comentario' => $comentario ?? "",
            'errores' => $errores
        ];
        header('Location: form-nuevo-voto.php');
        exit();
    }

    // Si no hay errores, guardamos la votación en curso
    $_SESSION['voto_en_curso'] = [
        'id_pelicula' => $idPelicula,
        'valoracion' => $valoracion,
        'comentario' => $comentario
    ];
    $voto = $_SESSION['voto_en_curso'];
    unset($_SESSION['voto_form']);
} else {
    // Acceso directo sin datos
    $errores[] = "No hay ninguna votación en curso. Por favor, inicie la votación desde el listado de películas.";
}

// Si tenemos votación, verificamos si el usuario ya votó esta película
if (empty($errores) && isset($voto)) {
    if ($conexion === false) {
        $errores[] = "No ha sido posible establecer una conexión con la base de datos.";
    } else {
        // Verificar si ya votó esta película
        $yaVoto = consultarVoto($conexion, $_SESSION['id'], $voto['id_pelicula']);

        if ($yaVoto === true) {
            // Si ya votó, descartamos la información de sesión
            unset($_SESSION['voto_en_curso']);
            $errores[] = "Ya has votado esta película previamente. No puedes votar de nuevo.";
        } elseif ($yaVoto === null) {
            $errores[] = "Error al comprobar si ya has votado esta película.";
        } else {
            // No ha votado, cargamos datos de la película
            $pelicula = obtenerPeliculaPorID($conexion, $voto['id_pelicula']);
            if (empty($pelicula)) {
                $errores[] = "No hemos podido encontrar la película";
            } else {
                $generos = listadoPorGeneros($conexion);
                if ($generos) {
                    foreach ($generos as $g) {
                        $idNombreGeneros[$g['id']] = $g['nombre'];
                    }
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
    <h1>DWES 03. AUTOR: RAFAEL MORONES BURGOS.</h1>

    <?php if (!empty($errores)): ?>
        <ul>
            <?php foreach ($errores as $e): ?>
                <li><?= htmlspecialchars($e) ?></li>
            <?php endforeach; ?>
        </ul>
        <p><a href="form-nuevo-voto.php">Volver al formulario de voto</a></p>
        <p><a href="../index/index.php">Volver al listado de películas</a></p>

    <?php else: ?>
        <h1>Confirme la valoración</h1>

        <?php if ($pelicula !== null): ?>
            <h2>Datos de la película</h2>
            <div>
                <strong>Título:</strong> <?= htmlspecialchars($pelicula['titulo']) ?><br>
                <strong>Genero:</strong> <?= htmlspecialchars($idNombreGeneros[$pelicula['genero']] ?? '') ?><br>
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
            <textarea id="comentario" rows="4" cols="50" readonly><?= htmlspecialchars($voto['comentario']) ?></textarea>
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
    <?php endif; ?>
</body>

</html>