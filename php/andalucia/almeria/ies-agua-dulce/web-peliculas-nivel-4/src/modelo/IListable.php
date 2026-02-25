<?php

declare(strict_types=1);

namespace AAMP04\modelo;

use AAMP04\servicios\DBResult;
use PDO;

/**
 * Interfaz para clases que listan registros y comprueban existencia por id.
 *
 * @author Tu Nombre
 */
interface IListable
{
    /**
     * Lista todos los registros de la tabla correspondiente como array de entidades.
     *
     * @param PDO $pdo Conexión PDO.
     * @return DBResult|array Array de instancias de la entidad o valor DBResult en error.
     */
    public static function listar(PDO $pdo): DBResult|array;

    /**
     * Comprueba si existe un registro con el id dado.
     *
     * @param PDO $pdo Conexión PDO.
     * @param int $id Identificador a comprobar.
     * @return DBResult|int 1 si existe, 0 si no existe, o DBResult en error.
     */
    public static function existe(PDO $pdo, int $id): DBResult|int;
}
