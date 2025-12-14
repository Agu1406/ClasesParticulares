<?php
//Cargamos las funciones guaradas en DAO.php
require_once "../funciones/dao.php";
//Cargamos las funciones guaradas en COOKIES.php
require_once "../funciones/cookies.php";

//Creamos una conexión
$conexion = conectarDB();

//Variables auxiliares
$errores = []; //Array para mostrar errores
$generosBD0 = []; //Array para guardar los géneros de la base de datos
//Arrays para validar los valores recibidos por el post
$generosValidos = [];
$idsGenerosBD = [];

if ($conexion === false) {
    echo "No ha sido posible establecer una conexión con la base de datos.";
} else {
    //si existe una sesión verificamos el método POST
    if ($_SERVER['REQUEST_METHOD'] != 'POST' || !isset($_POST['enviar'])) {
        $errores[] = "el formulario no ha sido enviado por POST";

        //Si ha sido enviada por POST comprobamos que no está vacío
    } else {
        if (empty($_POST)) {
            $errores[] = "La petición no puede estar vacía";

            //Validamos cada uno de los datos del formulario
        } else {

            // Comprobamos si se han seleccionado géneros
            // Si no se seleccionan géneros, se eliminarán las cookies
            if (!isset($_POST['generos']) || empty($_POST['generos'])) {
                // No hay géneros seleccionados, eliminamos las cookies
                forzarEliminacionCookies();
                header("Location: ../index/index.php");
                exit;
            } else {
                // Comprobamos que generos es un array
                if (!is_array($_POST['generos'])) {
                    $errores[] = "Los géneros no han sido enviadas como un array";
                } else {

                    // Validamos los valores recibidos dentro del array
                    //Obtenemos los géneros que hay en nuestra base de datos
                    $generosBD = listadoPorGeneros($conexion);

                    if ($generosBD === false || empty($generosBD)) {
                        $errores[] = "No se han podido cargar los géneros de la base de datos";
                    } else {
                        // Guardamos solo los ids de los géneros que hay actualmente en la base de datos
                        $idsGenerosBD = array_column($generosBD, "id");
                    }

                    //Recorremos todos los valores del array genero recibido pro el formulario
                    foreach ($_POST['generos'] as $genero) {
                        // comprobamos si es un entero
                        $id = filter_var($genero, FILTER_VALIDATE_INT);
                        //Si el valor es falso y es menor que 1
                        if ($id === false || $id < 1) {
                            $errores[] = "El valor del id es falso o menor que 1";
                            //Comprobamos que el género existe en la base de datos
                        } else if (!in_array($id, $idsGenerosBD)) {
                            $errores[] = "El género con id $id no existe";
                        } else {
                            // Si hemos llegado aqui se considera que el id es correcto y existe
                            $generosValidos[] = $id;
                        }
                    }

                    // Comprobamos que el array generosValidos no está vacío
                    if (empty($generosValidos)) {
                        $errores[] = "No se han recibido ningún género válido";
                    }
                }
            }
        }
    }
}

// Si no hay errores y hay géneros válidos, guardamos las cookies y redirigimos
if (empty($errores) && !empty($generosValidos)) {
    enviarCookiesGenerosPreferidos($generosValidos);
    header("Location: ../index/index.php");
    exit;
}
?>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Resulado de guardar preferencias</title>
</head>

<body>
    <H1>DWES 03. AUTOR: RAFAEL MORONES BURGOS.</H1>
    <br>
    <a href="../index/index.php">Volver al listado de películas.</a>

    <?php
    //Si hay errores los mostramos en el html
    if (!empty($errores)) {
        echo "<h2> Se han producido los siguientes errores</h2><ul>";
        foreach ($errores as $error) {
            echo "<li>" . htmlspecialchars($error) . "</li>";
        }
        echo "</ul>";
    }
    ?>
</body>

</html>
?>