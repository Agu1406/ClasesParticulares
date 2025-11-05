<?php
declare(strict_types=1);

/**
 * Crea y retorna una conexión PDO a MySQL usando ERRMODE_EXCEPTION.
 * Requiere que existan las constantes DB_HOST, DB_NAME, DB_USER, DB_PASS, DB_CHARSET.
 *
 * @return PDO
 * @throws PDOException si no se puede establecer la conexión.
 */
function crearConexionPDO(): PDO {
    $host = defined('DB_HOST') ? DB_HOST : '127.0.0.1';
    $db   = defined('DB_NAME') ? DB_NAME : '';
    $user = defined('DB_USER') ? DB_USER : 'root';
    $pass = defined('DB_PASS') ? DB_PASS : '';
    $charset = defined('DB_CHARSET') ? DB_CHARSET : 'utf8mb4';

    $dsn = "mysql:host={$host};dbname={$db};charset={$charset}";
    $options = [
        PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION,
        PDO::ATTR_DEFAULT_FETCH_MODE => PDO::FETCH_ASSOC,
        PDO::ATTR_EMULATE_PREPARES => false,
    ];

    return new PDO($dsn, $user, $pass, $options);
}


