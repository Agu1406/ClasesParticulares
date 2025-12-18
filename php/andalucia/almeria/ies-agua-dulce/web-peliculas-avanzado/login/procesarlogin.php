<?php
// Cargamos las funciones guardadas en DAO
require_once "../funciones/dao.php";
require_once "../funciones/dbconn.php";

// Comenzamos la sesión SIEMPRE al principio del script
session_start();

// Array para guardar los errores que nos encontremos durante las validaciones.
$errores = [];

// Comprobamos si existe una sesión con el id del usuario (ya está autentificado)
if (isset($_SESSION['id'])) {
    $mensaje = "El usuario ya se ha autenticado previamente.";
    header("Location: ../index/index.php");
} else {
    // Comprobamos si el formulario ha llegado por POST
    if ($_SERVER['REQUEST_METHOD'] !== 'POST' || !isset($_POST['entrar'])) {
        $errores[] = "El formulario no ha sido enviado correctamente.";
    } else {
        // Validamos los datos del formulario

        /* VALIDACIÓN DEL USUARIO */
        $usuario = filter_input(INPUT_POST, "login", FILTER_SANITIZE_SPECIAL_CHARS);

        if ($usuario === null || $usuario === false) {
            $errores[] = "El usuario no puede estar vacío.";
        } else {
            $usuario = trim($usuario);
            if ($usuario === '') {
                $errores[] = "El usuario no puede estar vacío.";
            }
        }

        /* VALIDACIÓN DE LA CONTRASEÑA */
        $password = filter_input(INPUT_POST, "contraseña", FILTER_SANITIZE_SPECIAL_CHARS);

        if ($password === null || $password === false) {
            $errores[] = "La contraseña no puede estar vacía.";
        } else {
            $password = trim($password);
            if ($password === '') {
                $errores[] = "La contraseña no puede estar vacía.";
            }
        }

        //Si no hay errores en los datos del formulario intentamos autentificar
        if (empty($errores)) {
            // Creamos la conexión a la base de datos
            $conexion = conectarDB();
            //si no es posible establecer conexión con la base de datos
            if ($conexion === false) {
                $errores[] = "Error en la conexión con la base de datos.";
            } else {
                // Si hay conexión intentamos autentificar la usuario
                $idUsuario = autenticarUsuario($conexion, $usuario, $password);
                //Esta fución nos devuelve false si no hemos tenido éxito
                if ($idUsuario === false) {
                    $errores[] = "El usuario o la contraseña no son correctos.";
                } else {
                    // Si tenemos éxito en la autentificación 
                    // Guardamos solo lo necesario en la sesión
                    $_SESSION['id'] = $idUsuario;
                    $_SESSION['lastlogin'] = time();

                    $mensaje = "El usuario se ha autenticado correctamente.";
?>
                    <!DOCTYPE html>
                    <html lang="es">

                    <head>
                        <meta charset="UTF-8">
                        <title>Resultado de la operación de login</title>
                    </head>

                    <body>

                        <h1>DWES 03. AUTOR: RAFAEL MORONES BURGOS.</h1>

                        <?php
                        // MOSTRAMOS MENSAJES
                        if (!empty($errores)) {
                            echo "<h2>Se han producido los siguientes errores:</h2><ul>";
                            foreach ($errores as $error) {
                                echo "<li>" . htmlspecialchars($error) . "</li>";
                            }
                            echo "</ul>";
                        } else {
                            echo "<p>" . htmlspecialchars($mensaje) . "</p>";
                        }
                        ?>

                        <a href="../index/index.php">Volver al inicio</a>

                    </body>


                    </html>

<?php
                }
            }
        }
    }
}
?>