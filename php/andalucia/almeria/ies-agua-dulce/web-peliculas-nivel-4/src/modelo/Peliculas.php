<?php

declare(strict_types=1);

namespace AAMP04\modelo;

use AAMP04\servicios\DBResult;
use PDO;

/**
 * Clase que encapsula las operaciones sobre el conjunto de películas (listar y comprobar existencia).
 *
 * @author Tu Nombre
 */
class Peliculas implements IListable
{
    /**
     * Lista todas las películas de la base de datos.
     *
     * @param PDO $pdo Conexión PDO.
     * @return DBResult|array Array de instancias de Pelicula o valor DBResult en error.
     */
    public static function listar(PDO $pdo): DBResult|array
    {
        try {
            $stmt = $pdo->query(
                'SELECT id, titulo, genero, direccion, duracion, argumento, anio FROM peliculas'
            );
            $rows = $stmt->fetchAll(PDO::FETCH_ASSOC);
            if ($rows === false) {
                return DBResult::DB_EMPTYRESULT;
            }
            $lista = [];
            foreach ($rows as $row) {
                $p = new Pelicula();
                $p->setId((int) $row['id']);
                $p->setTitulo($row['titulo']);
                $p->setGenero($row['genero'] !== null ? (int) $row['genero'] : null);
                $p->setDireccion($row['direccion']);
                $p->setDuracion((int) $row['duracion']);
                $p->setArgumento($row['argumento']);
                $p->setAnio((int) $row['anio']);
                $lista[] = $p;
            }
            return $lista;
        } catch (\Throwable) {
            return DBResult::DB_EXCEPTION;
        }
    }

    /**
     * Comprueba si existe una película con el id dado.
     *
     * @param PDO $pdo Conexión PDO.
     * @param int $id Identificador de la película.
     * @return DBResult|int 1 si existe, 0 si no, o DBResult::DB_EXCEPTION en error.
     */
    public static function existe(PDO $pdo, int $id): DBResult|int
    {
        try {
            $stmt = $pdo->prepare('SELECT 1 FROM peliculas WHERE id = ?');
            $stmt->execute([$id]);
            $row = $stmt->fetch(PDO::FETCH_NUM);
            return $row ? 1 : 0;
        } catch (\Throwable) {
            return DBResult::DB_EXCEPTION;
        }
    }
}
