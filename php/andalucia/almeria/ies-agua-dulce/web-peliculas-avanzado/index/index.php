<?php
session_start();

//Cargamos las funciones guaradas en DAO.php y en COOKIES.php
require_once "../funciones/dbconn.php";
require_once "../funciones/dao.php";
require_once "../funciones/cookies.php";



//Creamos una conexión
$conexion = conectarDB();

//Variables auxiliares a utilizar
$generos = [];
$peliculas = [];
$generosSeleccionadosCookis = [];

//comprobamos que la conexión es válida
if ($conexion === false) {
    echo "No ha sido posible establecer una conexión con la base de datos.";
} else {
    //Si existe una conexión comprobamos que existen géneros que mostrar al usuario
    $generos = listadoPorGeneros($conexion);
    //Comprobamso que se han cargado el array de géneros;
    if ($generos === false || (empty($generos))) {
        echo "no se ha cargado el listado de géneros o está vacío";
    } else {
        //Comprobamos si hay géneros guardados en las cookies
        $generosGuardosCookies = obtenerGenerosPreferidosDeCookies();

        //Si es la primera vez que entra no habrá ningún género guardado
        if ($generosGuardosCookies === false) {
            $peliculas = listadoPeliculas($conexion, null); //Cargamos todas las películas por defecto
            $generosSeleccionados = []; // ningún checkbox marcado
        } else {
            //Cargamos solo las películas de los géneros seleccionados
            $peliculas = listadoPeliculas($conexion, $generosGuardosCookies);
            $generosSeleccionados = $generosGuardosCookies; //guardamos los checkbox marcados
        }

        // A partir de los géneros cargados con la funcion listadPorGeneros
        //asociamos el id con su nombre y lo guardamos en un array
        $idNombreGeneros = [];
        foreach ($generos as $genero) {
            $idNombreGeneros[$genero['id']] = $genero['nombre'];
        }
?>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Lista de películas</title>
        </head>

        <body>
            <H1>DWES 03. AUTOR: RAFAEL MORONES BURGOS.</H1>
            <?php if (isset($_SESSION["id"])): ?>
                <p>Has inicicado sesión, <a href="../login/cerrarsesion.php">¿Deseas cerrar sesión?</a></p>
            <?php else: ?>
                <p>No has iniciado sesión, <a href="../login/form-login.php">¿Deseas iniciar sesión?</a></p>
            <?php endif; ?>
            <h2>Resultado de procesar las cookies recibidas:</h2>
            <p></p>
            <h2>Formulario para seleccionar preferencias (géneros) a almacenar en cookies:</h2>

            <form action="../preferencias/preferencia_generos.php" method="POST">
                <?php foreach ($generos as $genero): ?>
                    <div>
                        <input type="checkbox" name="generos[]" value="<?= $genero['id'] ?>">
                        <b><?= htmlspecialchars($genero['nombre']) ?>:</b>
                        (<?= htmlspecialchars($genero['descripcion']) ?>)
                    </div>
                <?php endforeach; ?>

                <!-- Checkboxes de prueba, fuera del foreach -->
                <div>
                    <input type="checkbox" name="generos[]" value="99999"> <b>ERROR1:</b>
                    (Para testear, género no válido, id no existente en la base de datos)
                </div>
                <div>
                    <input type="checkbox" name="generos[]" value="TEST"> <b>ERROR2:</b>
                    (Para testear, género no numérico)
                </div>

                <input type="submit" value="Seleccionar preferencias!" name="enviar">
            </form>

            <br>
            <table border="1">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Título</th>
                        <th>Género</th>
                        <th>Dirección</th>
                        <th>Duración</th>
                        <th>Año</th>
                        <th>Votos</th>
                        <th>Puntuación</th>
                        <th>Votar</th>
                    </tr>
                </thead>

                <tbody>
                    <tr>
                        <?php if ($peliculas === false || empty($peliculas)): ?>
                            <td>...</td>
                            <td>...</td>
                            <td>...</td>
                            <td>...</td>
                            <td>...</td>
                            <td>...</td>
                            <td><a href="privado/vervotaciones.php?id=..." alt="Haz clic para ver los comentarios">...</a></td>
                            <td></td>
                            <td>
                                <form action="privado/form-nuevo-voto.php" method="post">
                                    <input type="hidden" name="id" value="...">
                                    <input type="submit" value="Votar">
                                </form>
                            </td>
                        <?php else: ?>
                            <?php foreach ($peliculas as $pelicula): ?>
                                <?php
                                $datos = obtenerCriticasPeliculas($conexion, $pelicula["id"]);

                                $cantidadVotos = $datos["cantidad_votos"];
                                $puntuacionMedia = $datos["puntuacion_media"];
                                ?>
                    <tr>
                        <td><?= htmlspecialchars($pelicula['id']) ?></td>
                        <td><?= htmlspecialchars($pelicula['titulo']) ?></td>
                        <td>
                            <?= htmlspecialchars($idNombreGeneros[$pelicula['genero']] ?? '...') ?>
                        </td>
                        <td><?= htmlspecialchars($pelicula['direccion']) ?></td>
                        <td><?= htmlspecialchars($pelicula['duracion']) ?></td>
                        <td><?= htmlspecialchars($pelicula['anio']) ?></td>
                        <td><a href="../privado/vervotaciones.php?id=<?= htmlspecialchars($pelicula['id']) ?>" alt="Haz clic para ver los comentarios"><?= htmlspecialchars($cantidadVotos) ?></a></td>
                        <td><?= htmlspecialchars($puntuacionMedia) ?></td>
                        <td>
                            <form action="../privado/form-nuevo-voto.php" method="post">
                                <input type="hidden" name="id" value="<?= htmlspecialchars($pelicula['id']) ?>">
                                <input type="submit" value="Votar">
                            </form>
                        </td>
                    </tr>
                <?php endforeach; ?>
            <?php endif; ?>
                </tbody>

            </table>
        </body>

        </html>

<?php
    } //else si el listado de géneros se ha cargado
} // else de comprobación que existe una conexión
?>