<?php

/*********************************************
CREACIÓN DE LA FUNCIÓN CONEXIÓN SIN PARÁMETROS
 ***********************************************/

require_once "../conf/db-config.php";

function conectarDB()
{
    //Devolvemos false si la conexión falla. 
    $conexion = false;
    try {
        //Usamos el DSN y las constantes contraseña y pasword para crear un objeto PDO
        $pdo = new PDO(DB_DSN, DB_USER, DB_PASSWORD, array(PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION));
        //Si la conexion es exitosa devolvemos el objeto pdo
        $conexion = $pdo;
    } catch (PDOException $ex) {
        $conexion = false;
    }
    return $conexion;
}
