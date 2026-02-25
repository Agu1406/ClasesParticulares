<?php

declare(strict_types=1);

namespace AAMP04\modelo;

use AAMP04\servicios\DBResult;
use PDO;

/**
 * Interfaz para entidades que se pueden guardar, rescatar por id y borrar en base de datos.
 *
 * @author Tu Nombre
 */
interface IGuardable
{
    /**
     * Guarda la entidad en la base de datos (INSERT si es nueva, UPDATE si tiene id).
     *
     * @param PDO $pdo Conexión PDO.
     * @return DBResult|int Número de filas afectadas en éxito, o un valor DBResult en error.
     */
    public function guardar(PDO $pdo): DBResult|int;

    /**
     * Recupera una entidad por su id.
     *
     * @param PDO $pdo Conexión PDO.
     * @param int $id Identificador del registro.
     * @return DBResult|EntidadIdentificable Instancia de la entidad o valor DBResult si falla o no existe.
     */
    public static function rescatar(PDO $pdo, int $id): DBResult|EntidadIdentificable;

    /**
     * Borra el registro con el id dado.
     *
     * @param PDO $pdo Conexión PDO.
     * @param int $id Identificador del registro.
     * @return DBResult|int Número de filas afectadas o valor DBResult en error.
     */
    public static function borrar(PDO $pdo, int $id): DBResult|int;
}
