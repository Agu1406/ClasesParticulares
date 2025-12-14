<?php
//Cargamos los datos de la conexión
require_once '../conf/db-config.php';

/*********************************************
CREACIÓN DE LA FUNCIÓN CONEXIÓN SIN PARÁMETROS
 ***********************************************/

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
        // Usamos una consulta SQL que calcula el hash directamente en MySQL
        // para asegurar que la comparación sea exacta
        $query = "SELECT id, login, password FROM usuarios 
                  WHERE login = :login 
                  AND password = SHA2(CONCAT(REVERSE(:login), REVERSE(:password)), 256)";
        //Preparamos la consulta
        $stmt = $pdo->prepare($query);
        //Vinculamos parámetros    
        $stmt->bindParam(':login', $login, PDO::PARAM_STR);
        $stmt->bindParam(':password', $password, PDO::PARAM_STR);
        //Ejecutamos la consulta
        $stmt->execute();
        //Obtenemos el resultado
        $usuario = $stmt->fetch(PDO::FETCH_ASSOC);
        
        //Si existe usuario y la contraseña coincide
        if ($usuario === false || empty($usuario)) {
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

/**********************************
FUNCIÓN PARA OBTENER UNA PELÍCULA POR ID
 *********************************/
function obtenerPeliculaPorId(PDO $pdo, $idPelicula)
{
    $resultado = false;
    try {
        $query = "SELECT p.id, p.titulo, p.genero, p.direccion, p.duracion, p.argumento, p.anio, g.nombre as nombre_genero 
                  FROM peliculas p 
                  LEFT JOIN generos g ON p.genero = g.id 
                  WHERE p.id = :id";
        $stmt = $pdo->prepare($query);
        $stmt->bindParam(':id', $idPelicula, PDO::PARAM_INT);
        $stmt->execute();
        $resultado = $stmt->fetch(PDO::FETCH_ASSOC);
        if ($resultado === false) {
            $resultado = false;
        }
    } catch (PDOException $ex) {
        $resultado = false;
    }
    return $resultado;
}

/**********************************
FUNCIÓN PARA OBTENER VOTACIONES DE UNA PELÍCULA
 *********************************/
function obtenerVotacionesPorPelicula(PDO $pdo, $idPelicula)
{
    $resultado = [];
    try {
        $query = "SELECT c.id, c.valoracion, c.comentario, c.pelicula, c.usuario, u.login 
                  FROM criticas c 
                  INNER JOIN usuarios u ON c.usuario = u.id 
                  WHERE c.pelicula = :id_pelicula 
                  ORDER BY c.id DESC";
        $stmt = $pdo->prepare($query);
        $stmt->bindParam(':id_pelicula', $idPelicula, PDO::PARAM_INT);
        $stmt->execute();
        $resultado = $stmt->fetchAll(PDO::FETCH_ASSOC);
    } catch (PDOException $ex) {
        $resultado = false;
    }
    return $resultado;
}

/**********************************
FUNCIÓN PARA VERIFICAR SI UN USUARIO YA VOTÓ UNA PELÍCULA
 *********************************/
function usuarioYaVoto(PDO $pdo, $idUsuario, $idPelicula)
{
    $resultado = false;
    try {
        $query = "SELECT id FROM criticas WHERE usuario = :usuario AND pelicula = :pelicula";
        $stmt = $pdo->prepare($query);
        $stmt->bindParam(':usuario', $idUsuario, PDO::PARAM_INT);
        $stmt->bindParam(':pelicula', $idPelicula, PDO::PARAM_INT);
        $stmt->execute();
        $resultado = $stmt->fetch(PDO::FETCH_ASSOC);
        if ($resultado !== false) {
            $resultado = true;
        } else {
            $resultado = false;
        }
    } catch (PDOException $ex) {
        $resultado = false;
    }
    return $resultado;
}

/**********************************
FUNCIÓN PARA INSERTAR UNA VOTACIÓN
 *********************************/
function insertarVotacion(PDO $pdo, $idUsuario, $idPelicula, $valoracion, $comentario)
{
    $resultado = false;
    try {
        $query = "INSERT INTO criticas (valoracion, comentario, pelicula, usuario) 
                  VALUES (:valoracion, :comentario, :pelicula, :usuario)";
        $stmt = $pdo->prepare($query);
        $stmt->bindParam(':valoracion', $valoracion, PDO::PARAM_INT);
        $stmt->bindParam(':comentario', $comentario, PDO::PARAM_STR);
        $stmt->bindParam(':pelicula', $idPelicula, PDO::PARAM_INT);
        $stmt->bindParam(':usuario', $idUsuario, PDO::PARAM_INT);
        if ($stmt->execute()) {
            $resultado = $pdo->lastInsertId();
        }
    } catch (PDOException $ex) {
        $resultado = false;
    }
    return $resultado;
}

/**********************************
FUNCIÓN PARA OBTENER ESTADÍSTICAS DE VOTACIONES DE UNA PELÍCULA
 *********************************/
function obtenerEstadisticasVotaciones(PDO $pdo, $idPelicula)
{
    $resultado = ['num_votos' => 0, 'puntuacion_media' => 0];
    try {
        $query = "SELECT COUNT(*) as num_votos, AVG(valoracion) as puntuacion_media 
                  FROM criticas 
                  WHERE pelicula = :id_pelicula";
        $stmt = $pdo->prepare($query);
        $stmt->bindParam(':id_pelicula', $idPelicula, PDO::PARAM_INT);
        $stmt->execute();
        $datos = $stmt->fetch(PDO::FETCH_ASSOC);
        if ($datos !== false) {
            $resultado['num_votos'] = (int)$datos['num_votos'];
            $resultado['puntuacion_media'] = $datos['puntuacion_media'] !== null ? round((float)$datos['puntuacion_media'], 2) : 0;
        }
    } catch (PDOException $ex) {
        $resultado = false;
    }
    return $resultado;
}

/**********************************
FUNCIÓN PARA OBTENER UNA CRÍTICA POR ID
 *********************************/
function obtenerCriticaPorId(PDO $pdo, $idCritica)
{
    $resultado = false;
    try {
        $query = "SELECT id, valoracion, comentario, pelicula, usuario FROM criticas WHERE id = :id";
        $stmt = $pdo->prepare($query);
        $stmt->bindParam(':id', $idCritica, PDO::PARAM_INT);
        $stmt->execute();
        $resultado = $stmt->fetch(PDO::FETCH_ASSOC);
        if ($resultado === false) {
            $resultado = false;
        }
    } catch (PDOException $ex) {
        $resultado = false;
    }
    return $resultado;
}

/**********************************
FUNCIÓN PARA ELIMINAR UNA CRÍTICA
 *********************************/
function eliminarCritica(PDO $pdo, $idCritica)
{
    $resultado = false;
    try {
        $query = "DELETE FROM criticas WHERE id = :id";
        $stmt = $pdo->prepare($query);
        $stmt->bindParam(':id', $idCritica, PDO::PARAM_INT);
        if ($stmt->execute()) {
            $resultado = $stmt->rowCount() > 0;
        }
    } catch (PDOException $ex) {
        $resultado = false;
    }
    return $resultado;
}
