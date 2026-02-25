<?php
// Incluimos las funciones necesarias para la modificación.
require_once "../funciones/connect-db.php";
require_once "../funciones/dao-peliculas.php";

// Creamos una conexión a la base de datos.
$conexion = conectarDB();

// Validamos que se haya recibido el id por POST
$idPelicula = filter_input(INPUT_POST, "id", FILTER_VALIDATE_INT);

// Si la conexión falla avisamos con un error.
if ($conexion === false) {
    echo "¡Error! No se ha podido conectar a la base de datos.";
    exit;
}

// Si no se ha recibido el id o no es válido
if ($idPelicula === false || $idPelicula === null || $idPelicula <= 0) {
    $pelicula = false;
    $error = "El ID de la película no es válido.";
} else {
    // Obtenemos los datos de la película
    $pelicula = obtenerPeliculaPorId($conexion, $idPelicula);
    if ($pelicula === false) {
        $error = "La película con el ID indicado no existe.";
    }
}

// Obtenemos los géneros para el select
$generos = listadoPorGeneros($conexion);
?>

<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Modificar una película</title>
</head>

<body>
    <H1>Autor/a: RAFAEL MORONES BURGOS - Ejercicio 4 - Tarea 2 </H1>
    <h1>Formulario para modificar una película </h1>
    <a href="../index/index.php">Ir a la página principal</a><br><br>

    <?php if (isset($error)): ?>
        <div style="color: red; margin: 20px 0;">
            <h3>Error:</h3>
            <p><?= htmlspecialchars($error) ?></p>
        </div>
    <?php elseif ($pelicula !== false): ?>
        <!-- Inicio formulario de modificación de la película -->
        <form method="post" action="modificar-pelicula.php">
            <!-- Campo hidden para pasar el id -->
            <input type="hidden" name="id" value="<?= htmlspecialchars($pelicula['id']) ?>">

            <label>Título: <input type="text" name="titulo" value="<?= htmlspecialchars($pelicula['titulo']) ?>" maxlength="60"></label><BR>

            <label>Género:
                <SELECT name="genero">
                    <option value="">Selecciona un género</option>
                    <?php if ($generos !== false): ?>
                        <?php foreach ($generos as $genero): ?>
                            <option value="<?= htmlspecialchars($genero["id"]) ?>" 
                                <?= ($pelicula['genero'] == $genero["id"]) ? "selected" : "" ?>>
                                <?= htmlspecialchars($genero["nombre"]) ?>
                            </option>
                        <?php endforeach; ?>
                        <!-- Opción pensada expresamente para dar error a propósito (TEST) -->
                        <option value="9999999"> GENERO NO EXISTENTE (TEST) </option>
                    <?php endif; ?>
                </SELECT>
            </label><BR>

            <label>Dirección: <input type="text" name="direccion" value="<?= htmlspecialchars($pelicula['direccion']) ?>" maxlength="100"></label><BR>

            <label>Duración: <input type="text" name="duracion" value="<?= htmlspecialchars($pelicula['duracion']) ?>" maxlength="500"></label><BR>

            <label>Argumento: <textarea name="argumento" maxlength="255" rows="4" cols="50"><?= htmlspecialchars($pelicula['argumento']) ?></textarea></label><BR>

            <label>Año: <input type="text" name="anio" value="<?= htmlspecialchars($pelicula['anio']) ?>"></label><BR>

            <input type="submit" value="Guardar">
        </form>
        <!-- Fin formulario de modificación de la película -->
    <?php endif; ?>

</body>

</html>
