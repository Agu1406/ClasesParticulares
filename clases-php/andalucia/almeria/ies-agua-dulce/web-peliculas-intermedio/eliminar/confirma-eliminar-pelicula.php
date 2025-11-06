<?php
//Incluimos los archivos necesarios
require_once "../funciones/connect-db.php";
require_once "../funciones/dao-peliculas.php";

//Creamos la conexión
$conexion = conectarDB();

//Verificamos que haya conexión
if ($conexion === false) {
    die("Error: No ha sido posible establecer una conexión con la base de datos.");
}

//Verificamos que se haya recibido el id de la película vía POST
$idPelicula = filter_input(INPUT_POST, 'id', FILTER_VALIDATE_INT);

if ($idPelicula === null || $idPelicula === false || $idPelicula <= 0) {
    die("Error: El ID de la película no es válido.");
}

//Obtenemos los datos de la película
$pelicula = obtenerPeliculaPorId($conexion, $idPelicula);

if ($pelicula === false) {
    die("Error: No se ha encontrado la película con el ID proporcionado.");
}

//Obtenemos los géneros para mostrar el nombre del género
$generos = listadoPorGeneros($conexion);
$nombreGenero = 'Desconocido';
if ($generos !== false) {
    foreach ($generos as $genero) {
        if ($genero['id'] == $pelicula['genero']) {
            $nombreGenero = $genero['nombre'];
            break;
        }
    }
}
?>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Confirmar eliminación de película</title>
</head>
<body>
    <H1>Autor/a: RAFAEL MORONES BURGOS - Ejercicio 5 - Tarea 2 </H1>
    <h1>Confirmar eliminación de película</h1>
    <a href="../index/index.php">Ir a la página principal</a><br><br>
    
    <h2>Datos de la película a eliminar:</h2>
    
    <!-- Formulario de confirmación de eliminación -->
    <form method="post" action="eliminar-pelicula.php">
        <input type="hidden" name="id" value="<?= htmlspecialchars($pelicula['id']) ?>">
        
        <table border="1" cellspacing="0" cellpadding="5">
            <tr>
                <th>Campo</th>
                <th>Valor</th>
            </tr>
            <tr>
                <td><strong>ID</strong></td>
                <td><input type="text" name="id_display" value="<?= htmlspecialchars($pelicula['id']) ?>" readonly></td>
            </tr>
            <tr>
                <td><strong>Título</strong></td>
                <td><input type="text" name="titulo_display" value="<?= htmlspecialchars($pelicula['titulo']) ?>" readonly></td>
            </tr>
            <tr>
                <td><strong>Género</strong></td>
                <td><input type="text" name="genero_display" value="<?= htmlspecialchars($nombreGenero) ?>" readonly></td>
            </tr>
            <tr>
                <td><strong>Dirección</strong></td>
                <td><input type="text" name="direccion_display" value="<?= htmlspecialchars($pelicula['direccion']) ?>" readonly></td>
            </tr>
            <tr>
                <td><strong>Duración</strong></td>
                <td><input type="text" name="duracion_display" value="<?= htmlspecialchars($pelicula['duracion']) ?>" readonly> minutos</td>
            </tr>
            <tr>
                <td><strong>Argumento</strong></td>
                <td><textarea name="argumento_display" readonly><?= htmlspecialchars($pelicula['argumento']) ?></textarea></td>
            </tr>
            <tr>
                <td><strong>Año</strong></td>
                <td><input type="text" name="anio_display" value="<?= htmlspecialchars($pelicula['anio']) ?>" readonly></td>
            </tr>
        </table>
        
        <br>
        <p>
            <label>
                <input type="checkbox" name="confirmar" value="1">
                Confirmo que deseo eliminar esta película
            </label>
        </p>
        
        <input type="submit" value="Confirmar eliminación">
    </form>
    <!-- Fin formulario de confirmación de eliminación -->
    
</body>
</html>
