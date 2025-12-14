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
    $errores[] = "No ha seguido el proceso de votación correctamente.";
} else {
    // Verificamos que se hayan marcado los dos checkboxes
    $confirmar = filter_input(INPUT_POST, 'confirmar', FILTER_VALIDATE_INT);
    $declaracion = filter_input(INPUT_POST, 'declaracion', FILTER_VALIDATE_INT);
    
    if ($confirmar !== 1 || $declaracion !== 1) {
        $errores[] = "Debe marcar ambas casillas de confirmación para poder votar.";
    }
    
    // Verificamos que existe información de votación en la sesión
    if (!isset($_SESSION['voto_en_curso']) || empty($_SESSION['voto_en_curso'])) {
        $errores[] = "No hay información de votación en curso. Por favor, regrese al listado de películas y vuelva a iniciar el proceso.";
    } else {
        $votoEnCurso = $_SESSION['voto_en_curso'];
        $idPelicula = $votoEnCurso['pelicula_id'] ?? null;
        $valoracion = $votoEnCurso['valoracion'] ?? null;
        $comentario = $votoEnCurso['comentario'] ?? null;
        
        if ($idPelicula === null || $valoracion === null || $comentario === null) {
            $errores[] = "La información de votación en la sesión está incompleta.";
        } else {
            // Verificamos que la conexión es válida
            if ($conexion === false) {
                $errores[] = "No ha sido posible establecer una conexión con la base de datos.";
            } else {
                // Verificamos nuevamente que el usuario no haya votado esta película
                $idUsuario = $_SESSION['id'];
                $yaVoto = usuarioYaVoto($conexion, $idUsuario, $idPelicula);
                
                if ($yaVoto) {
                    // Si ya votó, descartamos la información de sesión
                    unset($_SESSION['voto_en_curso']);
                    $errores[] = "Ya ha votado esta película previamente. La información de votación ha sido descartada.";
                } else {
                    // Insertamos el voto en la base de datos
                    $resultado = insertarVotacion($conexion, $idUsuario, $idPelicula, $valoracion, $comentario);
                    
                    if ($resultado === false) {
                        $errores[] = "No ha sido posible registrar el voto en la base de datos.";
                    } else {
                        // Si todo fue correcto, eliminamos la información de sesión
                        unset($_SESSION['voto_en_curso']);
                        $mensaje = "El voto y comentario se han registrado correctamente.";
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
    <title>Proceso de votación</title>
</head>
<body>
    <H1>DWES 03. AUTOR: RAFAEL MORONES BURGOS.</H1>
    <h1>Proceso de votación</h1>
    
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
    
    <p>Por favor, regrese al listado de películas y vuelva a iniciar el proceso si desea votar otra película.</p>
    <a href="../index/index.php">Volver al listado de películas</a>
</body>
</html>
