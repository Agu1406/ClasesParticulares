<?php

// Conexión muy sencilla a MySQL

$servidor   = "localhost";
$usuario    = "root";      // cámbialo si tu usuario es otro
$contrasena = "";          // cámbialo si tu MySQL tiene contraseña
$basedatos  = "gimnasio";

$conexion = mysqli_connect($servidor, $usuario, $contrasena, $basedatos);

if (!$conexion) {
    die("Error de conexión: " . mysqli_connect_error());
}

mysqli_set_charset($conexion, "utf8mb4");

?>
