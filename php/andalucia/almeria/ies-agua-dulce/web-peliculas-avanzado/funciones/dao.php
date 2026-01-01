<?php

/***********************************************
FUNCIÓN PARA LISTAR LOS GÉNEROS DE LAS PELICULAS
 ***********************************************/
function listadoPorGeneros(PDO $pdo)
{
    //Creamos un array vació por defecto
    $resultado = [];

    //Usamos un try-catch para envolver los errores. 
    try {

        //Creamos un query con la selección
        $query = "SELECT id, nombre, descripcion FROM generos ORDER BY nombre";
        $stmt = $pdo->query($query);
        //Recogemos los resultados en un array asociativo.
        $resultado = $stmt->fetchAll(PDO::FETCH_ASSOC);
    } catch (PDOException $ex) {
        $resultado = false;
    }

    //Devolvemos un array
    return $resultado;
}

/***********************************************
FUNCIÓN PARA FILTRAS LAS PELÍCULAS POR GÉNERO
 ***********************************************/
//A la función le pasamos un objeto conexión y un array de géneros    
function listadoPeliculas(PDO $pdo, $idGeneros = null)
{
    // Creamos la variable resultado que devuelve por defecto un array Vacio
    $resultado = [];

    // Verificamos si se ha introducido un género. 
    // Si no se ha introducido el valor es nulo y se devuelven todas las películas 
    try {
        if ($idGeneros === null || empty($idGeneros)) {
            // Creamos el query con el select de la tabla películas. 
            $query = "SELECT id, titulo, genero, direccion, duracion, anio FROM peliculas";
            // Ejecutamos la consulta
            $stmt = $pdo->prepare($query);
            $stmt->execute();
            // Recoger los resultados en un array asociativo
            $resultado = $stmt->fetchAll(PDO::FETCH_ASSOC);

            // Si se ha introducido un valor en $generos
        } else {

            // Creamos el query con filtro por géneros válidos
            $placeholders = implode(',', array_fill(0, count($idGeneros), '?'));
            $query = "SELECT id, titulo, genero, direccion, duracion, anio 
                              FROM peliculas 
                              WHERE genero IN ($placeholders)";
            // Ejecutamos la consulta
            $stmt = $pdo->prepare($query);
            $stmt->execute($idGeneros);
            $resultado = $stmt->fetchAll(PDO::FETCH_ASSOC);
        }

        //Si existe alguna excepción será recogida pro el cath
    } catch (PDOException $ex) {
        $resultado = false;
    }
    //Devolemos $resultado, ya sea un array de películas o un valor false
    return $resultado;
}


/**********************************
FUNCIÓN PARA AUTENTIFICAR USUARIO
 *********************************/
function autenticarUsuario(PDO $pdo, $login, $password)
{
    $id = false;

    try {
        //Creamos el query del SELECT para buscar por el usuario

        // SHA2()
        $query = "SELECT id, login, password FROM usuarios WHERE login=:login AND password = SHA2(CONCAT(REVERSE(:login), REVERSE(:password)), 256)";
        //Preparamos la consulta
        $stmt = $pdo->prepare($query);
        //Vinculamos parámetros    
        $stmt->bindParam(':login', $login, PDO::PARAM_STR);
        $stmt->bindParam(':password', $password, PDO::PARAM_STR);
        //Ejecutamos la consulta
        $stmt->execute();

        $usuario = $stmt->fetch(PDO::FETCH_ASSOC);
        //Si existe usuario
        if ($usuario == false || empty($usuario)) {
            $id = false;
        } else {
            $id = $usuario['id'];
        }
        //Si existe alguna excepción será recogida pro el cath
    } catch (PDOException $ex) {
        $id = false;
    }

    return $id;
}
/*********************************************************************************
FUNCIÓN PARA OBTENER LA CANTIDAD DE VOTACIONES DE UNA PELICULA Y CALCULAR LA MEDIA
 **********************************************************************************/
function obtenerCriticasPeliculas(PDO $pdo, $idPelicula)
{
    $votos = ["cantidad_votos" => 0, "puntuacion_media" => 0];

    try {
        $query = "SELECT COUNT(*) as cantidad_votos, AVG(valoracion) as puntuacion_media FROM criticas WHERE pelicula = :id_pelicula";

        $stmt = $pdo->prepare($query);
        $stmt->bindParam(":id_pelicula", $idPelicula, PDO::PARAM_INT);
        $stmt->execute();

        // ["cantidad_votos" => 3, "puntuacion_media" => 13]
        $resultado = $stmt->fetch(PDO::FETCH_ASSOC);

        if ($resultado !== false) {
            //Si hay criticas obtenemos el número de votos
            $votos["cantidad_votos"] = (int)$resultado["cantidad_votos"];

            // Calculamos la media de los votos. 
            if ($resultado["puntuacion_media"] === null || $votos["cantidad_votos"] === 0) {
                $votos["puntuacion_media"] = "Sin votos"; //Si el número de votos es cero 
            } else {
                $votos["puntuacion_media"] = (float)$resultado["puntuacion_media"]; //Si hay votos obtenemos la media
            }
        }
    } catch (PDOException $ex) {
        $votos = ["cantidad_votos" => 0, "puntuacion_media" => 0];
    }

    return $votos;
}
/**************************************************************
FUNCIÓN PARA OBTENER UNA PELICULA POR UN ID ESPECIFICO
 **************************************************************/
function obtenerPeliculaPorID(PDO $pdo, $idPelicula)
{
    // Creamos la variable resultado que devuelve por defecto un array Vacio
    $resultado = [];
    try {
        // Creamos el query con el select de la tabla películas. 
        $query = "SELECT id, titulo, genero, direccion, duracion, anio FROM peliculas WHERE id = :id_pelicula";
        // Ejecutamos la consulta
        $stmt = $pdo->prepare($query);
        // Vinculamos los parámetros
        $stmt->bindParam(":id_pelicula", $idPelicula, PDO::PARAM_INT);
        $stmt->execute();
        // Recoger los resultados en un array asociativo
        $resultado = $stmt->fetch(PDO::FETCH_ASSOC); // 

        //En el caso de que no exista una película
        if (!$resultado) {
            $resultado = []; //Devolvemos un array vacío
        }
        //Si existe alguna excepción será recogida por el cath
    } catch (PDOException $ex) {
        $resultado = false;
    }
    //Devolvemos el array
    return $resultado;
}

/**************************************************************
FUNCIÓN PARA OBTENER LAS CRITICAS DE UNA PELICULA EN ESPECIFICO
 **************************************************************/
function obtenerCriticaCompleta(PDO $pdo, $idPelicula)
{
    //Este array es lo que devolverá la función
    $criticas = [];

    try {
        //Realizamos la consulta
        $query = "SELECT id, valoracion, comentario, pelicula, usuario FROM criticas WHERE pelicula = :id_pelicula";

        $stmt = $pdo->prepare($query);
        $stmt->bindParam(":id_pelicula", $idPelicula, PDO::PARAM_INT);
        $stmt->execute();

        //Obtenemos todas las críticas
        $criticas = $stmt->fetchAll(PDO::FETCH_ASSOC);
        if ($criticas === false) {
            $criticas = []; //Si no hay críticas devuelve un array vacío
        }
    } catch (PDOException $ex) {
        // en error también devolvemos array vacío, no false
        $criticas = [];
    }

    return $criticas;
}
/**************************************************************
FUNCIÓN PARA CONFIRMAR SI UN USUARIO YA HA VOTADO UNA PELÍCULA
 **************************************************************/
function consultarVoto(PDO $pdo, $idUsuario, $idPelicula)
{
    //Por defecto la función devolverá FALSE(usuario no ha votado)
    $resultado = false;

    try {
        //Creamos el query del SELECT
        $query = "SELECT pelicula FROM criticas WHERE usuario= :idUsuario AND pelicula= :idPelicula";
        $stmt = $pdo->prepare($query);
        $stmt->bindParam(":idUsuario", $idUsuario, PDO::PARAM_INT);
        $stmt->bindParam(":idPelicula", $idPelicula, PDO::PARAM_INT);
        $stmt->execute();

        //Recogemos el resultado en una variable
        $id = $stmt->fetch(PDO::FETCH_ASSOC);

        //Si existe un id pelicula signfica que el usuario ya ha votado
        if ($id !== false) {
            $resultado = true;
        } else {
            $resultado = false;
        }
    } catch (PDOException $ex) {
        // Si hay error devuelve null
        $resultado = null; //Para distinguir del false (cuando no hay voto)
    }

    return $resultado;
}

/**************************************************************
FUNCIÓN PARA INSERTAR EL VOTO DE UN USUARIO EN UNA PELÍCULA
 **************************************************************/

function insertarNuevoVoto(PDO $pdo, array $nuevoVoto)
{
    //El resultado que devolvemos por defecto
    $resultado = false;

    try {
        //Creamos el query del INSERT
        $sql = "INSERT INTO criticas (valoracion, comentario, pelicula, usuario)
                VALUES (:valoracion, :comentario, :pelicula, :usuario)";
        //Preparamos al consulta        
        $stmt = $pdo->prepare($sql);

        //Vinculamos parámetros    
        $stmt->bindParam(':valoracion',    $nuevoVoto['valoracion'],    PDO::PARAM_INT);
        $stmt->bindParam(':comentario',    $nuevoVoto['comentario'],    PDO::PARAM_STR);
        $stmt->bindParam(':pelicula', $nuevoVoto['pelicula'], PDO::PARAM_INT);
        $stmt->bindParam(':usuario',  $nuevoVoto['usuario'],  PDO::PARAM_INT);

        //ejecutamos
        //Si la consulta se ha ejectuado nos devuelve el id insertado
        if ($stmt->execute()) {
            // Si al menos hay 1 linea modificada significa que salio bien.
            if ($stmt->rowCount() > 0) {
                // Si todo sale bien devuelve ese ID.
                $resultado = $pdo->lastInsertId();
            }
        }
    } catch (PDOException $ex) {
        $resultado = false;
    }

    return $resultado;
}


/**************************************************************
FUNCIÓN PARA OBTENER VALORACIÓN POR ID
 **************************************************************/

function obtenerUsuarioPorIdCritica(PDO $pdo, $idCritica)
{
    //Valor que devolvemos por defecto (si no existe una critica con ese id)
    $resultado = false;

    try {
        //Creamos el query para buscar que usario ha realizado esa crítica
        $sql = "SELECT usuario FROM criticas WHERE id = :id";
        //Preparamos la consulta        
        $stmt = $pdo->prepare($sql);

        //Vinculamos parámetros    
        $stmt->bindParam(':id', $idCritica, PDO::PARAM_INT);

        //Ejecutamos
        $stmt->execute();

        //Recogemos el resultado
        $fila = $stmt->fetch(PDO::FETCH_ASSOC);

        //Si existe la crítica devolvemos el id del usuario
        if ($fila !== false) {
            $resultado = $fila['usuario'];
        } else {
            $resultado = false; // no existe la crítica
        }
    } catch (PDOException $ex) {
        // Si hay error devuelve null
        $resultado = null;
    }

    return $resultado;
}


/**************************************************************
FUNCIÓN PARA ELIMINAR VALORACIÓN POR ID
 **************************************************************/

function eliminarValoracionPorID(PDO $pdo, int $idCritica)
{
    // Valor por defecto (en el caso de no haber podido eliminar la crítica)
    $resultado = false;

    try {
        // Creamos el query con el DELETE
        $sql = "DELETE FROM criticas WHERE id = :id";

        // Preparamos la consulta
        $stmt = $pdo->prepare($sql);

        // Vinculamos los parámetros
        $stmt->bindParam(':id', $idCritica, PDO::PARAM_INT);

        // Ejecutamos. devolverá true si ha tenido exito
        if ($stmt->execute()) {
            // rowCount nos dice cuántas filas se han afectado
            if ($stmt->rowCount() > 0) {
                $resultado = true; // se ha eliminado una crítica
            }
        }
    } catch (PDOException $ex) {
        $resultado = false;
    }

    return $resultado;
}
