<?php
declare(strict_types=1);

/**
 * Retorna lista de películas. Si $anio es null, retorna todas.
 * Si $anio tiene un valor no válido, retorna array vacío.
 * En caso de error en ejecución/consulta, retorna false.
 *
 * @param PDO $pdo
 * @param int|null $anio
 * @return array<int,array<string,mixed>>|false
 */
function obtenerPeliculas(PDO $pdo, ?int $anio = null) {
    try {
        if ($anio !== null) {
            if ($anio < 1900 || $anio > 3000) {
                return [];
            }
            $stmt = $pdo->prepare(
                'SELECT id, titulo, genero, direccion, duracion, argumento, anio FROM peliculas WHERE anio = :anio ORDER BY titulo ASC'
            );
            $stmt->bindValue(':anio', $anio, PDO::PARAM_INT);
        } else {
            $stmt = $pdo->prepare(
                'SELECT id, titulo, genero, direccion, duracion, argumento, anio FROM peliculas ORDER BY anio DESC, titulo ASC'
            );
        }
        $stmt->execute();
        return $stmt->fetchAll();
    } catch (PDOException $e) {
        return false;
    }
}

/**
 * Retorna un único registro de película por id o null si no existe.
 * En caso de error, retorna false.
 *
 * @param PDO $pdo
 * @param int $id
 * @return array<string,mixed>|null|false
 */
function obtenerPeliculaPorId(PDO $pdo, int $id) {
    try {
        $stmt = $pdo->prepare('SELECT id, titulo, genero, direccion, duracion, argumento, anio FROM peliculas WHERE id = :id');
        $stmt->bindValue(':id', $id, PDO::PARAM_INT);
        $stmt->execute();
        $row = $stmt->fetch();
        if ($row === false) {
            return null;
        }
        return $row;
    } catch (PDOException $e) {
        return false;
    }
}

/**
 * Retorna lista de géneros con id, nombre, descripcion.
 * En caso de error, retorna false.
 *
 * @param PDO $pdo
 * @return array<int,array<string,mixed>>|false
 */
function obtenerGeneros(PDO $pdo) {
    try {
        $stmt = $pdo->prepare('SELECT id, nombre, descripcion FROM generos ORDER BY nombre ASC');
        $stmt->execute();
        return $stmt->fetchAll();
    } catch (PDOException $e) {
        return false;
    }
}

/**
 * Inserta una película y retorna el id autogenerado si ok; en caso contrario false.
 *
 * @param PDO $pdo
 * @param array<string,mixed> $data claves: titulo, genero, direccion, duracion, argumento, anio
 * @return int|false
 */
function insertarPelicula(PDO $pdo, array $data) {
    try {
        $sql = 'INSERT INTO peliculas (titulo, genero, direccion, duracion, argumento, anio)
                VALUES (:titulo, :genero, :direccion, :duracion, :argumento, :anio)';
        $stmt = $pdo->prepare($sql);
        $stmt->bindValue(':titulo', $data['titulo'], PDO::PARAM_STR);
        if ($data['genero'] === null) {
            $stmt->bindValue(':genero', null, PDO::PARAM_NULL);
        } else {
            $stmt->bindValue(':genero', (int)$data['genero'], PDO::PARAM_INT);
        }
        $stmt->bindValue(':direccion', $data['direccion'], PDO::PARAM_STR);
        $stmt->bindValue(':duracion', (int)$data['duracion'], PDO::PARAM_INT);
        $stmt->bindValue(':argumento', $data['argumento'], PDO::PARAM_STR);
        $stmt->bindValue(':anio', (int)$data['anio'], PDO::PARAM_INT);
        $stmt->execute();
        if ($stmt->rowCount() === 1) {
            return (int)$pdo->lastInsertId();
        }
        return false;
    } catch (PDOException $e) {
        return false;
    }
}

/**
 * Elimina película por id. Retorna número de registros eliminados o false si falla.
 *
 * @param PDO $pdo
 * @param int $id
 * @return int|false
 */
function eliminarPelicula(PDO $pdo, int $id) {
    try {
        $stmt = $pdo->prepare('DELETE FROM peliculas WHERE id = :id');
        $stmt->bindValue(':id', $id, PDO::PARAM_INT);
        $stmt->execute();
        return $stmt->rowCount();
    } catch (PDOException $e) {
        return false;
    }
}


