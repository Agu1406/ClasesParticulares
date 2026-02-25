<?php

declare(strict_types=1);

/**
 * Enrutador: carga autoload, crea PDO y Smarty, ejecuta el controlador por defecto.
 * Ruta por defecto: este script (index.php).
 */

$baseDir = __DIR__;

require_once $baseDir . '/vendor/autoload.php';

$config = require $baseDir . '/config_db.php';
$pdo = new PDO(
    $config['dsn'],
    $config['username'],
    $config['password'],
    $config['options'] ?? []
);

$smarty = new Smarty();
$smarty->setTemplateDir($baseDir . '/plantillas');
$smarty->setCompileDir($baseDir . '/tmp/compiled_templates');
$smarty->setCacheDir($baseDir . '/tmp/smarty_cache');

\AAMP04\controlador\Controlador::listado($pdo, $smarty);
