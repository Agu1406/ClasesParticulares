<?php 

require_once "conexionMySQL.php";

$conexion = new conexionMySQL("../../secure/mysql_config.php");

$conexion->conectar();

$conexion->selectEmpleados();
?>