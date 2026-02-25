<?php

declare(strict_types=1);

namespace AAMP04\modelo;

use AAMP04\servicios\DBResult;
use PDO;
use PDOException;

/**
 * Clase que encapsula las operaciones sobre el conjunto de géneros (listar y comprobar existencia).
 *
 * @author Tu Nombre
 */
class Generos implements IListable
{
    /**
     * Lista todos los géneros de la base de datos.
     *
     * @param PDO $pdo Conexión PDO.
     * @return DBResult|array Array de instancias de Genero o valor DBResult en error.
     */
    public static function listar(PDO $pdo): DBResult|array
    {
        $resultados = [];

        try {
            $sql = "SELECT id, nombre FROM generos";
            $stmt = $pdo->prepare($sql);
            if ($stmt->execute()) {
                $filas = $stmt->fetchAll(PDO::FETCH_ASSOC);
                if (empty($filas)) {
                    $resultados = DBResult::DB_EMPTYRESULT;
                } else {
                    $generos = [];
                    foreach ($filas as $fila) {
                        $genero = new Genero();
                        $genero->setId((int) $fila['id']);
                        $genero->setNombre($fila['nombre']);
                        $generos[] = $genero;
                    }
                    if (!empty($generos)) {
                        $resultados = $generos;
                    }
                }
            }
        } catch (PDOException $e) {
            $resultados = DBResult::DB_EXCEPTION;
        }

        return $resultados;
    }

    /**
     * Comprueba si existe un género por su ID.
     *
     * @param PDO $pdo Conexión PDO.
     * @param int $id Identificador del género.
     * @return DBResult|int 1 si existe, 0 si no, o DBResult::DB_EXCEPTION en error.
     */
    public static function existe(PDO $pdo, int $id): DBResult|int
    {
        $resultado = 0;

        try {
            $sql = "SELECT id FROM generos WHERE id = :id";
            $stmt = $pdo->prepare($sql);
            $stmt->bindParam(':id', $id, PDO::PARAM_INT);
            if ($stmt->execute()) {
                $idObtenido = $stmt->fetchColumn();
                if ($idObtenido > 0) {
                    $resultado = 1;
                } else {
                    $resultado = 0;
                }
            }
        } catch (PDOException $e) {
            $resultado = DBResult::DB_EXCEPTION;
        }

        return $resultado;
    }
}
