<?php

/*
FUNCION PARA LISTAR PELICULAS POR AÑOS
*/

function listadoPeliculas(PDO $pdo, $anio = null)
{
    // Creamos la variable resultado que devuelve por defecto un array Vacio
    $resultado = [];

    // Verificamos si se ha introducido un año, ya que es opcional
    // Si no se ha introducido el valor es nulo y se devuelven todas las películas 

    try {
        if ($anio === null) {
            // Creamos el cuery con el select de la tabla películas. 
            $query = "SELECT id, titulo, genero, direccion, duracion, argumento, anio FROM peliculas";
            // Ejecutamos la consulta
            $stmt = $pdo->query($query);
            // Recoger los resultados en un array asociativo
            $resultado = $stmt->fetchAll(PDO::FETCH_ASSOC);

            // Si se ha introducido un valor en $anio
        } else {
            // Usamos filter_var para verificar que es un número entero y que está dentro del rango
            $anioValido = filter_var($anio, FILTER_VALIDATE_INT, [
                'options' => ['min_range' => 1900, 'max_range' => intval(date('Y')) + 1]
            ]);

            // Si se cumple filter_var devuelve true
            if ($anioValido !== false) {
                // Creamos un query al cual le introducimos una restricción WHERE
                $query = "SELECT id, titulo, genero, direccion, duracion, argumento, anio FROM peliculas WHERE anio = :anio";
                $stmt = $pdo->prepare($query);
                // Asociamos el parámetro año con su variable. 
                $stmt->bindParam(':anio', $anioValido, PDO::PARAM_INT);
                $stmt->execute();
                // Devolvemos todos los resultados
                $resultado = $stmt->fetchAll(PDO::FETCH_ASSOC);
            } else {
                //Si $anivoValido=false se retorna el array vacio
                $resultado = [];
            }
        }
        //Si se produce cualquier  exepcion está será recogida en el try-catch 
    } catch (PDOException $ex) {
        //Si ocurre una excepción retornamos un valor
        $resultado = false;
    }
    return $resultado;
}

/*
FUNCION PARA LISTAR PELICULAS POR GÉNEROS
*/
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

/*
FUNCION PARA INSERTAR UNA NUEVA PELICULA
*/
function insertarPelicula(PDO $pdo, array $datos)
{
    $resultado = false;
    try {
        //Creamos el query del INSERT
        $sql = "INSERT INTO peliculas (titulo, genero, direccion, duracion, argumento, anio)
                VALUES (:titulo, :genero, :direccion, :duracion, :argumento, :anio)";

        //Preparamos la consulta        
        $stmt = $pdo->prepare($sql);

        //Vinculamos parámetros    
        $stmt->bindParam(':titulo',    $datos['titulo'],    PDO::PARAM_STR);
        $stmt->bindParam(':genero',    $datos['genero'],    PDO::PARAM_INT);
        $stmt->bindParam(':direccion', $datos['direccion'], PDO::PARAM_STR);
        $stmt->bindParam(':duracion',  $datos['duracion'],  PDO::PARAM_INT);
        $stmt->bindParam(':argumento', $datos['argumento'], PDO::PARAM_STR);
        $stmt->bindParam(':anio',      $datos['anio'],      PDO::PARAM_INT);

        //Ejecutamos la consulta
        if ($stmt->execute()) {
            //Verificamos que se haya insertado al menos una fila
            if ($stmt->rowCount() > 0) {
                //Si todo es correcto, obtenemos el id autogenerado
                $resultado = $pdo->lastInsertId();
            }
        }
    } catch (PDOException $e) {
        $resultado = false;
    }

    //Si todo ha ido bien devolvemos el id, si no false
    return $resultado;
}

/*
FUNCION PARA ELIMINAR UNA PELICULA
*/
function eliminarPelicula(PDO $pdo, $id)
{
    $resultado = false;
    try {
        //Creamos el query del DELETE
        $sql = "DELETE FROM peliculas WHERE id = :id";

        //Preparamos la consulta        
        $stmt = $pdo->prepare($sql);

        //Vinculamos el parámetro    
        $stmt->bindParam(':id', $id, PDO::PARAM_INT);

        //Ejecutamos la consulta
        if ($stmt->execute()) {
            //Verificamos cuántas filas se han eliminado
            $filasEliminadas = $stmt->rowCount();
            if ($filasEliminadas > 0) {
                //Si se eliminó al menos una fila, retornamos el número de filas eliminadas
                $resultado = $filasEliminadas;
            } else {
                //Si no se eliminó ninguna fila (el id no existe), retornamos false
                $resultado = false;
            }
        }
    } catch (PDOException $e) {
        $resultado = false;
    }

    //Retornamos el número de filas eliminadas o false en caso de error
    return $resultado;
}

/*
FUNCION PARA OBTENER UNA PELICULA POR SU ID
*/
function obtenerPeliculaPorId(PDO $pdo, $id)
{
    $resultado = false;
    try {
        //Creamos el query del SELECT
        $sql = "SELECT id, titulo, genero, direccion, duracion, argumento, anio FROM peliculas WHERE id = :id";

        //Preparamos la consulta        
        $stmt = $pdo->prepare($sql);

        //Vinculamos el parámetro    
        $stmt->bindParam(':id', $id, PDO::PARAM_INT);

        //Ejecutamos la consulta
        if ($stmt->execute()) {
            //Obtenemos el resultado
            $resultado = $stmt->fetch(PDO::FETCH_ASSOC);
            //Si no hay resultado, devolvemos false
            if ($resultado === false) {
                $resultado = false;
            }
        }
    } catch (PDOException $e) {
        $resultado = false;
    }

    //Retornamos el array asociativo con los datos de la película o false
    return $resultado;
}
