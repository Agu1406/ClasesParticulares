<?php
// Control de acceso al área privada 
require_once "accesoareaprivada.php";
//Cargamos las funciones guaradas en DAO.php
require_once "../funciones/dao.php";
require_once "../funciones/dbconn.php";

//Creamos una conexión
$conexion = conectarDB();

//Variables auxiliares
$errores = []; //Array para mostrar errores
$criticas = []; // array para guardar las críticas

//Comprobamos si existe conexión. 
if ($conexion === false) {
    echo "No ha sido posible establecer una conexión con la base de datos.";
    exit;
} else {

    //si existe una sesión verificamos el método GET
    if ($_SERVER['REQUEST_METHOD'] != 'GET') {
        $errores[] = "El formulario no ha sido enviado por GET";
    } else {
        //Si ha sido enviada por GET comprobamos que no está vacío
        if (empty($_GET)) {
            $errores[] = "La petición no puede estar vacía";
        }

        // Validamos los datos del formulario
        $idPelicula = filter_input(INPUT_GET, "id", FILTER_VALIDATE_INT);

        if ($idPelicula === false || $idPelicula === null) {
            $errores[] = "ID de película inválido";

            //Si el id es correcto buscamos la película correspondiente a dicho id
        } else {
            $pelicula = obtenerPeliculaPorID($conexion, $idPelicula);

            //Comprobamos que existe una película con ese id
            if (empty($pelicula)) {
                $errores[] = "La película no ha sido localizada";
            } else {
                //Si la película existe obtenemos las críticas
                $criticas = obtenerCriticaCompleta($conexion, $idPelicula);

                if (empty($criticas)) {
                    $avisoSinCriticas = "No existe críticas para esta película";
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
    <title>Lista de votos y críticas</title>
</head>

<body>

    <h1>DWES 03. AUTOR: RAFAEL MORONES BURGOS</h1>
    <p>
        <a href="../index/index.php">Volver al listado de películas</a> |
        <a href="../login/cerrarsesion.php">Cerrar sesión</a>
    </p>

    <h2>Lista de votos y críticas</h2>
    <h2>Datos de la película</h2>

    <div>
        <?php
        // Mostramos errores si existen
        if (!empty($errores)) {
            echo "<ul>";
            foreach ($errores as $error) {
                echo "<li>" . htmlspecialchars($error) . "</li>";
            }
            echo "</ul>";
            exit; // Salimos si hay errores
        } else {
            // Mostramos los datos de la película
            echo "<p><b>Título:</b> " . htmlspecialchars($pelicula['titulo']) . "</p>";
            echo "<p><b>Género:</b> " . htmlspecialchars($pelicula['genero']) . "</p>";
            echo "<p><b>Director:</b> " . htmlspecialchars($pelicula['direccion']) . "</p>";
            echo "<p><b>Duración:</b> " . htmlspecialchars($pelicula['duracion']) . " minutos</p>";
            echo "<p><b>Año:</b> " . htmlspecialchars($pelicula['anio']) . "</p>";

            // Mostramos aviso si no hay críticas
            if (!empty($avisoSinCriticas)) {
                echo "<p>" . htmlspecialchars($avisoSinCriticas) . "</p>";
            }
        }
        ?>
    </div>

    <hr>
    <table border="1" cellpadding="6" cellspacing="0">
        <thead>
            <tr>
                <th>Usuario</th>
                <th>Voto</th>
                <th>Crítica</th>
                <th>Eliminar</th>
            </tr>
        </thead>
        <tbody>
            <?php if (!empty($criticas)): ?>
                <?php foreach ($criticas as $critica): ?>
                    <tr>
                        <td><?= htmlspecialchars($critica['usuario']) ?></td>
                        <td><?= htmlspecialchars($critica['valoracion']) ?></td>
                        <td><?= htmlspecialchars($critica['comentario']) ?></td>
                        <td>
                            <?php if ($critica['usuario'] == $_SESSION['id']): ?>
                                <form method="post" action="eliminarvoto.php">
                                    <input type="hidden" name="id_critica" value="<?= htmlspecialchars($critica['id']) ?>">
                                    <input type="submit" value="Eliminar voto/critica">
                                </form>
                            <?php endif; ?>
                        </td>
                    </tr>
                <?php endforeach; ?>
            <?php else: ?>
                <tr>
                    <td colspan="4">No existe críticas para esta película</td>
                </tr>
            <?php endif; ?>
        </tbody>
    </table>

</body>

</html>