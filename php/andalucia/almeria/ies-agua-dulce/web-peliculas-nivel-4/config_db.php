<?php

/**
 * Configuración de acceso a la base de datos.
 * Ajusta estos valores según tu instalación XAMPP/MySQL.
 */
return [
    'dsn'      => 'mysql:host=127.0.0.1;port=3306;dbname=peliculas_nivel_4;charset=utf8mb4',
    'username' => 'root',
    'password' => '',
    'options'  => [
        PDO::ATTR_ERRMODE            => PDO::ERRMODE_EXCEPTION,
        PDO::ATTR_DEFAULT_FETCH_MODE => PDO::FETCH_ASSOC,
    ],
];
