<?php

// REGISTRO MÁS SENCILLO POSIBLE (pero usando password_hash)

session_start();
require_once 'db.php';

// Solo aceptamos peticiones que vengan del formulario (POST)
if ($_SERVER['REQUEST_METHOD'] === 'POST') {

    // 1. Recoger datos del formulario
    $nombre   = $_POST['nombre']   ?? '';
    $email    = $_POST['email']    ?? '';
    $password = $_POST['password'] ?? '';

    // 2. Comprobar que no estén vacíos (validación muy básica)
    if ($nombre === '' || $email === '' || $password === '') {
        echo "Faltan datos por rellenar.";
        exit;
    }

    // 3. Cifrar la contraseña
    $password_hash = password_hash($password, PASSWORD_DEFAULT);

    // 4. Insertar el usuario en la base de datos (versión muy simple)
    $sql = "INSERT INTO usuarios (nombre, email, password)
            VALUES ('$nombre', '$email', '$password_hash')";

    $ok = mysqli_query($conexion, $sql);

    if ($ok) {
        // 5. Si todo va bien, mandamos al login
        header("Location: login.html");
        exit;
    } else {
        echo "No se pudo registrar el usuario.";
    }
} else {
    // Si entran aquí escribiendo la URL a mano, los mandamos al formulario
    header("Location: registro.html");
    exit;
}

?>
