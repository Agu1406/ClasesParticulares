<?php
// Control de acceso al área privada 
//El scritp se detendrá aqui si el usuario no tiene sesion o se ha caducado
require_once "accesoareaprivada.php";



//Comprobamos si existe una votación en curso
if (isset($_SESSION['voto_en_curso'])) {
    // Mostrar solo enlace para continuar
    echo "<h1><b>ERRORES</b></h1>";
    echo "<h3>Ya existe datos de confirmación de voto de sesión. Por favor
    continúe con el proceso de confirmación </h3>";
    echo "<p><a href='form-confirmar-voto.php'>Ir a la página de confirmación del voto</a></p>";


    //solo en el caso de que exista una sesión y no existe una votación en curso continuamos con el script
} else {

    //Cargamos las funciones guaradas en DAO.php
    require_once "../funciones/dao.php";
    require_once "../funciones/dbconn.php";

    //Creamos una conexión
    $conexion = conectarDB();

    //Creamos un array para recoger los errores
    $errores = [];

    // NUEVO: valores por defecto para el formulario (por si volvemos desde un error)
    $valoracionForm = "";
    $comentarioForm = "";

    // Para el caso de venir rebotados de form-confirmar-voto
    if (isset($_SESSION['voto_form'])) {
        $valoracionForm = $_SESSION['voto_form']['valoracion'] ?? "";
        $comentarioForm = $_SESSION['voto_form']['comentario'] ?? "";
        $idPeliculaForm = $_SESSION['voto_form']['id_pelicula'] ?? "";
    }

    //comprobamos que existe una conexión
    if ($conexion === false) {
        $errores = "existe un error con la conexión";

        //Si llegamos aqui sabemos que existe sesión y que existe conexión
    } else {
        //Nos aseguramos que los datos han venido por el método POST desde index.php
        if ($_SERVER["REQUEST_METHOD"] !== "POST") {
            $errores[] = "El formulario no ha sido enviado por POST";
        } else {
            //Si ha sido enviada por POST comprobamos que no está vacío
            if (empty($_POST)) {
                $errores[] = "La petición no puede estar vacía";

                //Validamos el id del formulario que viene el hidden
            } else {
                $idPelicula = filter_input(INPUT_POST, "id", FILTER_VALIDATE_INT);

                if ($idPelicula === false || $idPelicula === null) {
                    $errores[] = "ID de película inválido";

                    //Si el id es correcto buscamos la película correspondiente a dicho id
                } else {
                    $pelicula = obtenerPeliculaPorID($conexion, $idPelicula);

                    //Comprobamos que existe una película con ese id
                    if (empty($pelicula)) {
                        $errores[] = "La película no ha sido localizada";
                    } else {
                        //Si existe una conexión comprobamos que existen géneros que mostrar al usuario
                        $generos = listadoPorGeneros($conexion);

                        //Comprobamso que se han cargado el array de géneros;
                        if ($generos === false || (empty($generos))) {
                            $errores[] = "no se ha cargado el listado de géneros o está vacío";
                        } else {
                            // A partir de los géneros cargados con la funcion listadPorGeneros
                            //asociamos el id con su nombre y lo guardamos en un array
                            $idNombreGeneros = [];
                            foreach ($generos as $genero) {
                                $idNombreGeneros[$genero['id']] = $genero['nombre'];
                            }
                            if (empty($idNombreGeneros)) {
                                $errores = "no ha sido posible obtener los nombres de los géneros";
                            } else {
                                //en caso de qeu todo haya ido bien mostramos la cabecera de la web
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
                                    <H2>Datos de la película</H2>
                                    <div>
                                        <?php
                                        // Mostramos errores si existen
                                        if (!empty($errores)) {
                                            echo "<ul>";
                                            foreach ($errores as $error) {
                                                echo "<li>" . htmlspecialchars($error) . "</li>";
                                            }
                                            echo "</ul>";
                                        } else {
                                            // Mostramos los datos de la película
                                            echo "<p><b>Título:</b> " . htmlspecialchars($pelicula['titulo']) . "</p>";
                                            echo "<p><b>Género:</b> " . htmlspecialchars($idNombreGeneros[$pelicula['genero']]) . "</p>";
                                            echo "<p><b>Director:</b> " . htmlspecialchars($pelicula['direccion']) . "</p>";
                                            echo "<p><b>Duración:</b> " . htmlspecialchars($pelicula['duracion']) . " minutos</p>";
                                            echo "<p><b>Año:</b> " . htmlspecialchars($pelicula['anio']) . "</p>";
                                        }
                                        ?>
                                    </div>
                                    <hr>
                                    <h2>Formulario para votar y comentar la película</h2>
                                    <form action="form-confirmar-voto.php" method="POST">
                                        <input type="hidden" name="id_pelicula" value="<?= htmlspecialchars($pelicula['id']) ?>">
                                        <div>
                                            <label for="valoracion">Valoración (1-5):</label>
                                            <select name="valoracion" id="valoracion">
                                                <option value="">Seleccione</option>
                                                <option value="1" <?= ($valoracionForm == 1) ? 'selected' : '' ?>>1</option>
                                                <option value="2" <?= ($valoracionForm == 2) ? 'selected' : '' ?>>2</option>
                                                <option value="3" <?= ($valoracionForm == 3) ? 'selected' : '' ?>>3</option>
                                                <option value="4" <?= ($valoracionForm == 4) ? 'selected' : '' ?>>4</option>
                                                <option value="5" <?= ($valoracionForm == 5) ? 'selected' : '' ?>>5</option>
                                            </select>
                                        </div>
                                        <div>
                                            <label for="comentario">Comentario:</label><br>
                                            <textarea name="comentario" id="comentario" rows="4" cols="50"><?= htmlspecialchars($comentarioForm) ?></textarea>
                                        </div>
                                        <div>
                                            <input type="submit" value="Enviar voto y comentario">
                                        </div>
                                    </form>
                                </body>

                                </html>

<?php
                            }
                        }
                    }
                }
            }
        }
    }
}
?>