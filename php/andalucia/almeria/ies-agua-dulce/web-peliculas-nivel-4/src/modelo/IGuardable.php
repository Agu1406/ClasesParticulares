<?php

declare(strict_types=1);

namespace AAMP04\modelo;

use AAMP04\servicios\DBResult;
use PDO;

interface IGuardable
{
    public function guardar(PDO $pdo): DBResult|int;

    public static function rescatar(PDO $pdo, int $id): DBResult|EntidadIdentificable;

    public static function borrar(PDO $pdo, int $id): DBResult|int;
}
