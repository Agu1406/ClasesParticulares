<?php
// Incluimos el control de acceso al área privada
require_once 'accesoareaprivada.php';

// Cargamos las funciones necesarias
require_once '../funciones/dao.php';

// Creamos la conexión
$conexion = conectarDB();

// Array para errores
$errores = [];

// Validamos el id de la película recibido por POST
$idPelicula = filter_input(INPUT_POST, 'id', FILTER_VALIDATE_INT);

if ($idPelicula === false || $idPelicula === null || $idPelicula < 1) {
    $errores[] = "El id de la película no es válido.";
} else {
    // Verificamos que la conexión es válida
    if ($conexion === false) {
        $errores[] = "No ha sido posible establecer una conexión con la base de datos.";
    } else {
        // Obtenemos los datos de la película
        $pelicula = obtenerPeliculaPorId($conexion, $idPelicula);
        
        if ($pelicula === false || empty($pelicula)) {
            $errores[] = "La película no existe en la base de datos.";
        } else {
            // Verificamos si el usuario ya votó esta película
            $idUsuario = $_SESSION['id'];
            $yaVoto = usuarioYaVoto($conexion, $idUsuario, $idPelicula);
            
            if ($yaVoto) {
                $errores[] = "Ya ha votado esta película previamente.";
            } else {
                // Verificamos si hay una votación en curso en la sesión
                if (isset($_SESSION['voto_en_curso']) && isset($_SESSION['voto_en_curso']['pelicula_id'])) {
                    // Si hay una votación en curso, redirigimos a la confirmación
                    header("Location: form-confirmar-voto.php");
                    exit;
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
    <H1>DWES 03. AUTOR: RAFAEL MORONES BURGOS.</H1>
    
    <?php if (!empty($errores)): ?>
        <h2>Se han producido los siguientes errores:</h2>
        <ul>
            <?php foreach ($errores as $error): ?>
                <li><?= htmlspecialchars($error) ?></li>
            <?php endforeach; ?>
        </ul>
        <a href="../index/index.php">Volver al listado de películas</a>
    <?php else: ?>
        <H2>Datos de la película</H2>
        <div>
            <strong>Título:</strong> <?= htmlspecialchars($pelicula['titulo']) ?><br>
            <strong>Género:</strong> <?= htmlspecialchars($pelicula['nombre_genero'] ?? 'Sin género') ?><br>
            <strong>Director:</strong> <?= htmlspecialchars($pelicula['direccion']) ?><br>
            <strong>Duración:</strong> <?= htmlspecialchars($pelicula['duracion']) ?> minutos<br>
            <strong>Año:</strong> <?= htmlspecialchars($pelicula['anio']) ?><br>
        </div>
        <hr>
        <h2>Formulario para votar y comentar la película</h2>
        <form action="form-confirmar-voto.php" method="POST">
            <input type="hidden" name="id_pelicula" value="<?= htmlspecialchars($idPelicula) ?>">
            <div>
                <label for="valoracion">Valoración (1-5):</label>
                <select name="valoracion" id="valoracion" required>
                    <option value="">Seleccione</option>
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                    <option value="5">5</option>
                </select>
            </div>
            <div>
                <label for="comentario">Comentario:</label><br>
                <textarea name="comentario" id="comentario" rows="4" cols="50" required></textarea>
            </div>
            <div>
                <input type="submit" value="Enviar voto y comentario">
            </div>
        </form>
        <a href="../index/index.php">Volver al listado de películas</a>
    <?php endif; ?>
</body>
</html>
