<?php

// RESERVA MUY SENCILLA:
// - Si viene "clase_id" por GET -> crear reserva
// - Si viene "reserva_id" por GET -> cancelar reserva

session_start();

if (!isset($_SESSION['usuario_id'])) {
    header("Location: login.html");
    exit;
}

require_once 'db.php';

$usuario_id = $_SESSION['usuario_id'];

// 1. Crear reserva
if (isset($_GET['clase_id'])) {
    $clase_id = (int) $_GET['clase_id'];

    if ($clase_id <= 0) {
        echo "Clase no válida.";
        exit;
    }

    $sql = "INSERT INTO reservas (usuario_id, clase_id)
            VALUES ($usuario_id, $clase_id)";
    mysqli_query($conexion, $sql);

    header("Location: panel.php");
    exit;
}

// 2. Cancelar reserva
if (isset($_GET['reserva_id'])) {
    $reserva_id = (int) $_GET['reserva_id'];

    if ($reserva_id <= 0) {
        echo "Reserva no válida.";
        exit;
    }

    // Solo borra si la reserva es del usuario actual
    $sql = "DELETE FROM reservas
            WHERE id = $reserva_id AND usuario_id = $usuario_id";
    mysqli_query($conexion, $sql);

    header("Location: panel.php");
    exit;
}

// Si no viene nada, volvemos al panel
header("Location: panel.php");
exit;

?>
