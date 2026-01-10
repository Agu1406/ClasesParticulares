<?php
require_once "accesoareaprivada.php";
require_once "../funciones/dao.php";
require_once "../funciones/dbconn.php";



//Creamos una conexión 
$conexion = conectarDB();

//Variables auxiliares
$errores = [];
$mensaje = "";
$idCritica = null;
$critica = null;

//Comprobamos si existe una conexión 
if ($conexion === false) {
    $errores[] = "No hemos podido establecer una conexión con la BD";
} else {
    // Comprobamos que viene del método POST
    if ($_SERVER["REQUEST_METHOD"] !== "POST") {
        $errores[] = "El formulario no ha sido enviado por POST";
    } elseif (empty($_POST)) {
        $errores[] = "La petición no puede estar vacía";
    } else {
        //Si se han recibido datos validamos el id de la crítica
        $idCritica = filter_input(INPUT_POST, "id_critica", FILTER_VALIDATE_INT);
        //Si no es válido puede ser null o false
        if ($idCritica === false || $idCritica === null) {
            $errores[] = "El id de crítica no es válido";

            //Si es válido comprobamos que existe una crítica con ese id
        } else {
            $critica = obtenerUsuarioPorIdCritica($conexion, $idCritica);

            if ($critica === false) {
                $errores[] = "No existe ninguna valoración con ese id";

                //Si existe una crítica comprobamos que coincida con el usuario de la sesión
            } else {
                $idUsuarioSesion = $_SESSION["id"];
                if ($critica != $idUsuarioSesion) {
                    $errores[] = "No puede eliminar una valoración que no es suya";

                    //Si coinciden procedemos a eliminar la crítica
                } else {
                    $resultado = eliminarValoracionPorID($conexion, $idCritica);
                    if ($resultado === false) {
                        $errores[] = "No ha sido posible eliminar la valoración";
                    } else {
                        $mensaje = "La valoración con el id $idCritica se ha eliminado correctamente.";
                    }
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
    <title>Eliminar voto</title>
</head>

<body>
    <h1>DWES 03. AUTOR: RAFAEL MORONES BURGOS.</h1>
    <h1>Eliminar voto y comentario</h1>

    <?php if (!empty($errores)): ?>
        <h2>ERRORES:</h2>
        <ul>
            <?php foreach ($errores as $error): ?>
                <li><?= htmlspecialchars($error) ?></li>
            <?php endforeach; ?>
        </ul>
    <?php else: ?>
        <h2><?= htmlspecialchars($mensaje) ?></h2>
    <?php endif; ?>

    <p><a href="../index/index.php">Volver al listado de películas</a></p>
</body>

</html>