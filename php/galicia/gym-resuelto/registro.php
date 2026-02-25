<?php

// REGISTRO SENCILLO: guarda usuario con contraseña cifrada

session_start();
require_once 'db.php';

if ($_SERVER['REQUEST_METHOD'] === 'POST') {

    // 1. Recoger datos del formulario
    $nombre   = $_POST['nombre']   ?? '';
    $email    = $_POST['email']    ?? '';
    $password = $_POST['password'] ?? '';

    // 2. Validación muy básica
    if ($nombre === '' || $email === '' || $password === '') {
        echo "Faltan datos por rellenar.";
        exit;
    }

    // 3. Cifrar la contraseña
    $password_hash = password_hash($password, PASSWORD_DEFAULT);

    // 4. Insertar el usuario (versión simple con mysqli_query)
    $sql = "INSERT INTO usuarios (nombre, email, password)
            VALUES ('$nombre', '$email', '$password_hash')";

    $ok = mysqli_query($conexion, $sql);

    if ($ok) {
        // 5. Redirigir al login
        header("Location: login.html");
        exit;
    } else {
        echo "No se pudo registrar el usuario.";
    }
} else {
    // Si no viene de un formulario, mandamos al registro
    header("Location: registro.html");
    exit;
}

?>
<?php

// REGISTRO MUY SENCILLO (usa password_hash)

session_start();
require_once 'db.php';

if ($_SERVER['REQUEST_METHOD'] === 'POST') {

    // 1. Recoger datos del formulario
    $nombre   = $_POST['nombre']   ?? '';
    $email    = $_POST['email']    ?? '';
    $password = $_POST['password'] ?? '';

    // 2. Validación básica
    if ($nombre === '' || $email === '' || $password === '') {
        echo "Faltan datos por rellenar.";
        exit;
    }

    // 3. Cifrar la contraseña
    $password_hash = password_hash($password, PASSWORD_DEFAULT);

    // 4. Insertar en la base de datos
    $sql = "INSERT INTO usuarios (nombre, email, password)
            VALUES ('$nombre', '$email', '$password_hash')";

    $ok = mysqli_query($conexion, $sql);

    if ($ok) {
        header("Location: login.html");
        exit;
    } else {
        echo "No se pudo registrar el usuario.";
    }
} else {
    header("Location: registro.html");
    exit;
}

?>
