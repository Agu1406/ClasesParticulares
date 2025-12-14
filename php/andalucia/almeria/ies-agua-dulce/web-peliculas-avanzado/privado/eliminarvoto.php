<?php
// Incluimos el control de acceso al área privada
require_once 'accesoareaprivada.php';

// Cargamos las funciones necesarias
require_once '../funciones/dao.php';

// Iniciamos la sesión (ya iniciada en accesoareaprivada.php, pero por seguridad)
session_start();

// Creamos la conexión
$conexion = conectarDB();

// Array para errores
$errores = [];
$mensaje = '';

// Verificamos que el formulario se haya enviado por POST
if ($_SERVER['REQUEST_METHOD'] !== 'POST') {
    $errores[] = "El formulario no ha sido enviado correctamente.";
} else {
    // Validamos el id de la crítica recibido por POST
    $idCritica = filter_input(INPUT_POST, 'id_critica', FILTER_VALIDATE_INT);
    
    if ($idCritica === false || $idCritica === null || $idCritica < 1) {
        $errores[] = "El id de crítica no es válido.";
    } else {
        // Verificamos que la conexión es válida
        if ($conexion === false) {
            $errores[] = "No ha sido posible establecer una conexión con la base de datos.";
        } else {
            // Obtenemos los datos de la crítica
            $critica = obtenerCriticaPorId($conexion, $idCritica);
            
            if ($critica === false || empty($critica)) {
                $errores[] = "No existe ninguna valoración con ese id en la base de datos.";
            } else {
                // Verificamos que la crítica pertenece al usuario autenticado
                $idUsuarioAutenticado = $_SESSION['id'];
                
                if ($critica['usuario'] != $idUsuarioAutenticado) {
                    $errores[] = "La valoración no pertenece al usuario autenticado.";
                } else {
                    // Eliminamos la crítica
                    $resultado = eliminarCritica($conexion, $idCritica);
                    
                    if ($resultado === false) {
                        $errores[] = "No ha sido posible eliminar la valoración.";
                    } else {
                        $mensaje = "La valoración se ha eliminado correctamente.";
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
    <H1>DWES 03. AUTOR: RAFAEL MORONES BURGOS.</H1>
    <h1>Eliminar voto y comentario</h1>
    
    <?php if (!empty($errores)): ?>
        <h2>Se han producido los siguientes errores:</h2>
        <ul>
            <?php foreach ($errores as $error): ?>
                <li><?= htmlspecialchars($error) ?></li>
            <?php endforeach; ?>
        </ul>
    <?php else: ?>
        <p><?= htmlspecialchars($mensaje) ?></p>
    <?php endif; ?>
    
    <a href="../index/index.php">Volver al listado de películas</a>
</body>
</html>
