<?php
//Iniciamos sesión si no está iniciada (para pasar errores)
if (session_status() === PHP_SESSION_NONE) {
    session_start();
}

//Incluimos los archivos necesarios
require_once "../funciones/connect-db.php";
require_once "../funciones/dao-peliculas.php";

//Creamos la conexión
$conexion = conectarDB();

//Variables para errores y valores del formulario
$errores = [];
$valores = [
    'titulo' => '',
    'genero' => '',
    'direccion' => '',
    'duracion' => '',
    'argumento' => '',
    'anio' => ''
];

//Si hay errores pasados desde insertar-pelicula.php, los recuperamos
if (isset($_SESSION['errores'])) {
    $errores = $_SESSION['errores'];
    unset($_SESSION['errores']);
}

if (isset($_SESSION['valores'])) {
    $valores = $_SESSION['valores'];
    unset($_SESSION['valores']);
}

//Obtenemos los géneros disponibles
$generos = [];
if ($conexion !== false) {
    $generos = listadoPorGeneros($conexion);
    if ($generos === false) {
        $generos = [];
    }
}
?>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Insertar nueva película</title>
</head>

<body>
    <H1>Autor/a: RAFAEL MORONES BURGOS - Ejercicio 3 - Tarea 2 </H1>
    <h1>Formulario para insertar nueva película </h1>
    <a href="../index.php">Ir a listado de películas</a>

    <?php if (!empty($errores)): ?>
        <div style="color: red; margin: 20px 0;">
            <h3>Errores encontrados:</h3>
            <ul>
                <?php foreach ($errores as $error): ?>
                    <li><?= htmlspecialchars($error) ?></li>
                <?php endforeach; ?>
            </ul>
        </div>
    <?php endif; ?>

    <!-- Formulario de inserción de datos de la película -->
    <form method="post" action="insertar-pelicula.php">
        <div>
            <label>Título: <input type="text" name="titulo" value="<?= htmlspecialchars($valores['titulo']) ?>" maxlength="60"></label>
        </div>
        <BR>
        <div>
            <label>Género: 
                <SELECT name="genero">
                    <option value="">-- Seleccione un género --</option>
                    <?php foreach ($generos as $genero): ?>
                        <option value="<?= htmlspecialchars($genero['id']) ?>" 
                                <?= ($valores['genero'] == $genero['id']) ? 'selected' : '' ?>>
                            <?= htmlspecialchars($genero['nombre']) ?>
                        </option>
                    <?php endforeach; ?>
                    <option value="<?= bin2hex(random_bytes(5)) ?>">Valor al azar</option>
                    <option value="9999999"> GENERO NO EXISTENTE (TEST) </option>
                </SELECT>
            </label>
        </div>
        <BR>
        <div>
            <label>Dirección: <input type="text" name="direccion" value="<?= htmlspecialchars($valores['direccion']) ?>" maxlength="100"></label>
        </div>
        <BR>
        <div>
            <label>Duración: <input type="text" name="duracion" value="<?= htmlspecialchars($valores['duracion']) ?>"></label>
        </div>
        <BR>
        <div>
            <label>Argumento: <textarea name="argumento" maxlength="255" rows="4" cols="50"><?= htmlspecialchars($valores['argumento']) ?></textarea></label>
        </div>
        <BR>
        <div>
            <label>Año: <input type="text" name="anio" value="<?= htmlspecialchars($valores['anio']) ?>"></label>
        </div>
        <BR>
        <input type="submit" value="¡Alta nueva película!">
    </form>
    <!-- Fin formulario de inserción de la película -->

</body>

</html>
