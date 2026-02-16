<?php

// LOGIN SENCILLO (usa password_verify pero sin complicar el código)

session_start();
require_once 'db.php';

if ($_SERVER['REQUEST_METHOD'] === 'POST') {

    $email    = $_POST['email']    ?? '';
    $password = $_POST['password'] ?? '';

    if ($email === '' || $password === '') {
        echo "Debes introducir email y contraseña.";
        exit;
    }

    // Buscar el usuario por email (versión simple, sin prepare)
    $sql = "SELECT * FROM usuarios WHERE email = '$email'";
    $resultado = mysqli_query($conexion, $sql);

    if ($resultado && mysqli_num_rows($resultado) === 1) {
        $usuario = mysqli_fetch_assoc($resultado);

        // Comprobar la contraseña cifrada
        if (password_verify($password, $usuario['password'])) {
            $_SESSION['usuario_id']     = $usuario['id'];
            $_SESSION['usuario_nombre'] = $usuario['nombre'];
            $_SESSION['usuario_rol']    = $usuario['rol'];

            header("Location: panel.php");
            exit;
        } else {
            echo "Contraseña incorrecta.";
        }
    } else {
        echo "No existe un usuario con ese email.";
    }
} else {
    header("Location: login.html");
    exit;
}

?>
