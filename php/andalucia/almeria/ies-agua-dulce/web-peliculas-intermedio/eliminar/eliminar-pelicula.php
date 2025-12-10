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

//Verificamos si se marcó la casilla de confirmación
$confirmar = filter_input(INPUT_POST, 'confirmar', FILTER_VALIDATE_INT);
?>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Resultado Eliminar</title>    
</head>
<body>
    <H1>Autor/a: RAFAEL MORONES BURGOS - Ejercicio 5 - Tarea 2 </H1>
    <h2>Resultado de la acción:</h2>
    
    <?php
    //Verificamos que el ID sea válido
    if ($idPelicula === null || $idPelicula === false || $idPelicula <= 0) {
        echo "<p style='color: red;'>Error: El ID de la película no es correcto.</p>";
    } else {
        //Verificamos si se marcó la casilla de confirmación
        if ($confirmar === null || $confirmar === false || $confirmar != 1) {
            echo "<p style='color: red;'>Es obligatorio marcar la casilla de confirmación para eliminar la película.</p>";
        } else {
            //Si todo es correcto, procedemos a eliminar
            $filasEliminadas = eliminarPelicula($conexion, $idPelicula);
            
            if ($filasEliminadas === false) {
                echo "<p style='color: red;'>Error: No se pudo eliminar la película o la película no existe.</p>";
            } else {
                echo "<p style='color: green; font-weight: bold;'>La película ha sido eliminada correctamente. Número de registros eliminados: " . htmlspecialchars($filasEliminadas) . "</p>";
            }
        }
    }
    ?>
    
    <br>
    <a href="../index/index.php">Ir a la página principal</a><br><br>
</body>
</html>
