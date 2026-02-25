<?php

declare(strict_types=1);

namespace AAMP04\modelo;

use AAMP04\servicios\DBResult;
use PDO;

interface IListable
{
    public static function listar(PDO $pdo): DBResult|array;

    public static function existe(PDO $pdo, int $id): DBResult|int;
}
