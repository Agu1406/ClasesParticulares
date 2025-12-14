<?php
// Incluimos el control de acceso al área privada
require_once 'accesoareaprivada.php';

// Cargamos las funciones necesarias
require_once '../funciones/dao.php';

// Iniciamos la sesión (ya iniciada en accesoareaprivada.php, pero por seguridad)
session_start();

// Creamos la conexión
$conexion = conectarDB();

// Array para errores
$errores = [];

// Verificamos si hay datos de votación en la sesión o si vienen del formulario
if ($_SERVER['REQUEST_METHOD'] === 'POST' && isset($_POST['id_pelicula'])) {
    // Validamos el id de la película
    $idPelicula = filter_input(INPUT_POST, 'id_pelicula', FILTER_VALIDATE_INT);
    $valoracion = filter_input(INPUT_POST, 'valoracion', FILTER_VALIDATE_INT);
    $comentario = filter_input(INPUT_POST, 'comentario', FILTER_SANITIZE_SPECIAL_CHARS);
    
    if ($idPelicula === false || $idPelicula === null || $idPelicula < 1) {
        $errores[] = "El id de la película no es válido.";
    } elseif ($valoracion === false || $valoracion === null || $valoracion < 1 || $valoracion > 5) {
        $errores[] = "La valoración debe ser un número entre 1 y 5.";
    } elseif ($comentario === false || $comentario === null || trim($comentario) === '') {
        $errores[] = "El comentario no puede estar vacío.";
    } else {
        // Verificamos que la conexión es válida
        if ($conexion === false) {
            $errores[] = "No ha sido posible establecer una conexión con la base de datos.";
        } else {
            // Verificamos si el usuario ya votó esta película
            $idUsuario = $_SESSION['id'];
            $yaVoto = usuarioYaVoto($conexion, $idUsuario, $idPelicula);
            
            if ($yaVoto) {
                // Si ya votó, descartamos la información de sesión
                unset($_SESSION['voto_en_curso']);
                $errores[] = "Ya ha votado esta película previamente.";
            } else {
                // Almacenamos la información en la sesión
                $_SESSION['voto_en_curso'] = [
                    'pelicula_id' => $idPelicula,
                    'valoracion' => $valoracion,
                    'comentario' => trim($comentario)
                ];
            }
        }
    }
}

// Si hay errores o no hay datos en sesión, redirigimos
if (!empty($errores) || !isset($_SESSION['voto_en_curso'])) {
    if (!empty($errores)) {
        // Mostramos errores
        ?>
        <!DOCTYPE html>
        <html lang="es">
        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=100%, initial-scale=1.0">
            <title>Error en la votación</title>
        </head>
        <body>
            <H1>DWES 03. AUTOR: RAFAEL MORONES BURGOS.</H1>
            <h2>Se han producido los siguientes errores:</h2>
            <ul>
                <?php foreach ($errores as $error): ?>
                    <li><?= htmlspecialchars($error) ?></li>
                <?php endforeach; ?>
            </ul>
            <a href="../index/index.php">Volver al listado de películas</a>
        </body>
        </html>
        <?php
        exit;
    } else {
        // No hay datos en sesión, redirigimos al formulario
        header("Location: form-nuevo-voto.php");
        exit;
    }
}

// Obtenemos los datos de la votación en curso
$votoEnCurso = $_SESSION['voto_en_curso'];
$idPelicula = $votoEnCurso['pelicula_id'];

// Obtenemos los datos de la película
$pelicula = obtenerPeliculaPorId($conexion, $idPelicula);

if ($pelicula === false || empty($pelicula)) {
    // Si la película no existe, limpiamos la sesión y redirigimos
    unset($_SESSION['voto_en_curso']);
    header("Location: ../index/index.php");
    exit;
}

// Verificamos nuevamente que el usuario no haya votado (por si acaso)
$idUsuario = $_SESSION['id'];
$yaVoto = usuarioYaVoto($conexion, $idUsuario, $idPelicula);

if ($yaVoto) {
    // Si ya votó, descartamos la información de sesión
    unset($_SESSION['voto_en_curso']);
    ?>
    <!DOCTYPE html>
    <html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=100%, initial-scale=1.0">
        <title>Error en la votación</title>
    </head>
    <body>
        <H1>DWES 03. AUTOR: RAFAEL MORONES BURGOS.</H1>
        <h2>Error</h2>
        <p>Ya ha votado esta película previamente.</p>
        <a href="../index/index.php">Volver al listado de películas</a>
    </body>
    </html>
    <?php
    exit;
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
    <h1>Confirme la valoración</h1>
   
    <H2>Datos de la película</H2>
    <div>
        <strong>Título:</strong> <?= htmlspecialchars($pelicula['titulo']) ?><br>
        <strong>Género:</strong> <?= htmlspecialchars($pelicula['nombre_genero'] ?? 'Sin género') ?><br>
        <strong>Director:</strong> <?= htmlspecialchars($pelicula['direccion']) ?><br>
        <strong>Duración:</strong> <?= htmlspecialchars($pelicula['duracion']) ?> minutos<br>
        <strong>Año:</strong> <?= htmlspecialchars($pelicula['anio']) ?><br>
    </div>
    <hr>
    <h2>Por favor, confirme su valoración y comentario</h2> 
    <div>
        <strong>Valoración:</strong> <?= htmlspecialchars($votoEnCurso['valoracion']) ?><br>
        <strong>Comentario:</strong> <?= htmlspecialchars($votoEnCurso['comentario']) ?><br>
    </div>
    <form action="votar.php" method="POST">
        <div>
            <input type="checkbox" name="confirmar" value="1" id="confirmar" required> 
            <label for="confirmar">Haz clic aquí para confirmar que desea enviar esta valoración y comentario.</label>
        </div>
        <div>
            <input type="checkbox" name="declaracion" value="1" id="declaracion" required> 
            <label for="declaracion">Declaro que mi valoración y crítica se ajustan a las normas de la comunidad 
            y soy consciente de que cualquier incumplimiento puede conllevar la eliminación de mi cuenta.</label>
        </div>
        <div>
            <input type="submit" value="Confirmar voto y comentario">
        </div>
    </form> 
    <form action="descartarvoto.php" method="POST">
        <input type="submit" value="Descartar voto y comentario">
    </form>
    <a href="../index/index.php">Volver al listado de películas</a>
</body>
</html>
