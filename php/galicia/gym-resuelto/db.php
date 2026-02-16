<?php

// Archivo de conexión a la base de datos
// Este archivo se incluirá en todos los demás PHP que necesiten acceder a MySQL

$servidor = "localhost";
$usuario  = "root";      // cámbialo si tu usuario de MySQL es otro
$clave    = "";          // cámbialo si tienes contraseña en MySQL
$basededatos = "gimnasio";

// Conexión usando mysqli (estilo procedimental, más fácil de entender al principio)
$conexion = mysqli_connect($servidor, $usuario, $clave, $basededatos);

// Comprobar si ha ocurrido algún error
if (!$conexion) {
    die("Error al conectar con la base de datos: " . mysqli_connect_error());
}

// Aseguramos que los acentos se guarden y se lean bien
mysqli_set_charset($conexion, "utf8mb4");

?>
