<?php

declare(strict_types=1);

namespace AAMP04\modelo;

use AAMP04\servicios\DBResult;
use PDO;

class Peliculas implements IListable
{
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
