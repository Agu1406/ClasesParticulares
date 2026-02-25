<?php

//Incluimos el archivo donde están guardadas las constantes de la conexion
// La ruta es relativa: desde funciones/ subimos un nivel (../) y entramos en conf/
require_once '../conf/db.php';

//Creamos la funcion de conexión sin parámetros
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
