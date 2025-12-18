<?php
session_start();
require_once "../funciones/dao.php";
require_once "../funciones/dbconn.php";

$errores = [];
$mensaje = "";

// Si ya está autenticado, redirigir
if (isset($_SESSION['id'])) {
    header("Location: ../index/index.php");
    exit;
}

// Validar método POST
if ($_SERVER['REQUEST_METHOD'] !== 'POST' || !isset($_POST['entrar'])) {
    $errores[] = "El formulario no ha sido enviado correctamente.";
} else {
    // Validar usuario
    $usuario = filter_input(INPUT_POST, "login", FILTER_SANITIZE_SPECIAL_CHARS);
    if ($usuario === null || $usuario === false || trim($usuario) === '') {
        $errores[] = "El usuario no puede estar vacío.";
    } else {
        $usuario = trim($usuario);
    }

    // Validar contraseña
    $password = filter_input(INPUT_POST, "contraseña", FILTER_SANITIZE_SPECIAL_CHARS);
    if ($password === null || $password === false || trim($password) === '') {
        $errores[] = "La contraseña no puede estar vacía.";
    } else {
        $password = trim($password);
    }

    // Si no hay errores, intentar autenticar
    if (empty($errores)) {
        $conexion = conectarDB();
        if ($conexion === false) {
            $errores[] = "Error en la conexión con la base de datos.";
        } else {
            $idUsuario = autenticarUsuario($conexion, $usuario, $password);
            if ($idUsuario === false) {
                $errores[] = "El usuario o la contraseña no son correctos.";
            } else {
                $_SESSION['id'] = $idUsuario;
                $_SESSION['lastlogin'] = time();
                $mensaje = "El usuario se ha autenticado correctamente.";
            }
        }
    }
}
?>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Resultado de login</title>
</head>
<body>
    <h1>DWES 03. AUTOR: RAFAEL MORONES BURGOS.</h1>
    
    <?php if (!empty($errores)): ?>
        <h2>Se han producido los siguientes errores:</h2>
        <ul>
            <?php foreach ($errores as $error): ?>
                <li><?= htmlspecialchars($error) ?></li>
            <?php endforeach; ?>
        </ul>
        <p><a href="form-login.php">Volver al formulario de login</a></p>
    <?php else: ?>
        <p><?= htmlspecialchars($mensaje) ?></p>
        <p><a href="../index/index.php">Ir al listado de películas</a></p>
    <?php endif; ?>
</body>
</html>
