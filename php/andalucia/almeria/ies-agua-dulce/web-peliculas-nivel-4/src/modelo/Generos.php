<?php

declare(strict_types=1);

namespace AAMP04\modelo;

use AAMP04\servicios\DBResult;
use PDO;

class Generos implements IListable
{
    public static function listar(PDO $pdo): DBResult|array
    {
        try {
            $stmt = $pdo->query('SELECT id, nombre, descripcion FROM generos ORDER BY nombre');
            $rows = $stmt->fetchAll(PDO::FETCH_ASSOC);
            if ($rows === false) {
                return DBResult::DB_EMPTYRESULT;
            }
            $lista = [];
            foreach ($rows as $row) {
                $g = new Genero();
                $g->setId((int) $row['id']);
                $g->setNombre($row['nombre']);
                $lista[] = $g;
            }
            return $lista;
        } catch (\Throwable) {
            return DBResult::DB_EXCEPTION;
        }
    }

    public static function existe(PDO $pdo, int $id): DBResult|int
    {
        try {
            $stmt = $pdo->prepare('SELECT 1 FROM generos WHERE id = ?');
            $stmt->execute([$id]);
            $row = $stmt->fetch(PDO::FETCH_NUM);
            return $row ? 1 : 0;
        } catch (\Throwable) {
            return DBResult::DB_EXCEPTION;
        }
    }
}
