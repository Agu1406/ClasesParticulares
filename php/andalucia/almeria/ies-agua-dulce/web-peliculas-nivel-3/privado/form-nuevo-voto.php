<?php
require_once "accesoareaprivada.php";
require_once "../funciones/dao.php";
require_once "../funciones/dbconn.php";

$errores = [];
$erroresValidacion = [];
$valoracionForm = "";
$comentarioForm = "";
$idPelicula = null;
$pelicula = null;
$idNombreGeneros = [];

// Si ya hay votación en curso, redirigir a confirmación
if (isset($_SESSION['voto_en_curso'])) {
?>
    <!DOCTYPE html>
    <html lang="es">

    <head>
        <meta charset="UTF-8">
        <title>Votación en curso</title>
    </head>

    <body>
        <h1>DWES 03. AUTOR: RAFAEL MORONES BURGOS.</h1>
        <h2>Ya existe una votación en curso</h2>
        <p><a href="form-confirmar-voto.php">Continuar con la confirmación</a></p>
        <p><a href="descartarvoto.php">Descartar votación</a></p>
    </body>

    </html>
<?php
    exit;
}

$conexion = conectarDB();

if ($conexion === false) {
    $errores[] = "No ha sido posible conectar con la base de datos.";
} else {
    // Venimos rebotados con errores de validación
    if (isset($_SESSION['voto_form'])) {
        $valoracionForm = $_SESSION['voto_form']['valoracion'] ?? "";
        $comentarioForm = $_SESSION['voto_form']['comentario'] ?? "";
        $idPelicula = $_SESSION['voto_form']['id_pelicula'] ?? null;
        $erroresValidacion = $_SESSION['voto_form']['errores'] ?? [];
        unset($_SESSION['voto_form']);

        if ($idPelicula !== null && $idPelicula !== "") {
            $idPelicula = (int)$idPelicula;
        }
    } elseif ($_SERVER["REQUEST_METHOD"] === "POST" && !empty($_POST)) {
        $idPelicula = filter_input(INPUT_POST, "id", FILTER_VALIDATE_INT);
        if ($idPelicula === false || $idPelicula === null) {
            $errores[] = "ID de película inválido.";
        }
    } else {
        $errores[] = "Seleccione una película desde el listado.";
    }

    // Cargar datos de la película
    if (empty($errores) && $idPelicula !== null) {
        $pelicula = obtenerPeliculaPorID($conexion, $idPelicula);
        if (empty($pelicula)) {
            $errores[] = "Película no encontrada.";
        } else {
            $generos = listadoPorGeneros($conexion);
            if ($generos !== false) {
                foreach ($generos as $g) {
                    $idNombreGeneros[$g['id']] = $g['nombre'];
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
    <title>Formulario de votación</title>
</head>

<body>
    <h1>DWES 03. AUTOR: RAFAEL MORONES BURGOS.</h1>

    <?php if (!empty($errores)): ?>
        <h2>Errores:</h2>
        <ul>
            <?php foreach ($errores as $e): ?>
                <li><?= htmlspecialchars($e) ?></li>
            <?php endforeach; ?>
        </ul>
        <p><a href="../index/index.php">Volver al listado</a></p>

    <?php elseif ($pelicula): ?>
        <?php if (!empty($erroresValidacion)): ?>
            <div style="color:red; border:1px solid red; padding:10px;">
                <h3>Corrija los siguientes errores:</h3>
                <ul>
                    <?php foreach ($erroresValidacion as $e): ?>
                        <li><?= htmlspecialchars($e) ?></li>
                    <?php endforeach; ?>
                </ul>
            </div>
        <?php endif; ?>

        <h2>Datos de la película</h2>
        <div>
            <p><b>Título:</b> <?= htmlspecialchars($pelicula['titulo']) ?></p>
            <p><b>Género:</b> <?= htmlspecialchars($idNombreGeneros[$pelicula['genero']] ?? 'Desconocido') ?></p>
            <p><b>Director:</b> <?= htmlspecialchars($pelicula['direccion']) ?></p>
            <p><b>Duración:</b> <?= htmlspecialchars($pelicula['duracion']) ?> min</p>
            <p><b>Año:</b> <?= htmlspecialchars($pelicula['anio']) ?></p>
        </div>
        <hr>

        <h2>Formulario para votar y comentar la película</h2>
        <form action="form-confirmar-voto.php" method="POST">
            <input type="hidden" name="id_pelicula" value="<?= htmlspecialchars($pelicula['id']) ?>">
            <div>
                <label>Valoración (1-5):</label>
                <select name="valoracion">
                    <option value="">Seleccione</option>
                    <?php for ($i = 1; $i <= 5; $i++): ?>
                        <option value="<?= $i ?>" <?= ($valoracionForm == $i) ? 'selected' : '' ?>><?= $i ?></option>
                    <?php endfor; ?>
                </select><br><br>
            </div>
            <div>
                <label>Comentario:</label><br>
                <textarea name="comentario" rows="4" cols="50"><?= htmlspecialchars($comentarioForm) ?></textarea><br><br>
            </div>
            <div>
                <input type="submit" value="Enviar">
            </div>
        </form>
        <p><a href="../index/index.php">Cancelar</a></p>
    <?php endif; ?>
</body>

</html>