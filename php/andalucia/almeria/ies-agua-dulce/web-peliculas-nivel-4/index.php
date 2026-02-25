<?php

declare(strict_types=1);

/**
 * Enrutador: carga autoload, crea PDO y Smarty, despacha por acción (GET/POST).
 * Ruta por defecto: listado. Acciones: nueva_pelicula_form_AAMP, nueva_pelicula_guardar_AAMP,
 * borrar_pelicula_form_AAMP, borrar_pelicula_confirmacion_AAMP.
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

$accionPost = filter_input(INPUT_POST, 'accion', FILTER_SANITIZE_SPECIAL_CHARS);
$accionGet = filter_input(INPUT_GET, 'accion', FILTER_SANITIZE_SPECIAL_CHARS);
$accion = is_string($accionPost) && $accionPost !== '' ? trim($accionPost) : (is_string($accionGet) ? trim($accionGet) : '');

switch ($accion) {
    case 'nueva_pelicula_form_AAMP':
        \AAMP04\controlador\Controlador::formNuevaPelicula($pdo, $smarty);
        break;
    case 'nueva_pelicula_guardar_AAMP':
        if ($_SERVER['REQUEST_METHOD'] === 'POST') {
            \AAMP04\controlador\Controlador::guardarNuevaPelicula($pdo, $smarty);
        } else {
            \AAMP04\controlador\Controlador::errorAccion($smarty, 'La acción de guardar película debe realizarse por POST.');
        }
        break;
    case 'borrar_pelicula_form_AAMP':
        if ($_SERVER['REQUEST_METHOD'] === 'POST') {
            \AAMP04\controlador\Controlador::formBorrarPelicula($pdo, $smarty);
        } else {
            \AAMP04\controlador\Controlador::errorAccion($smarty, 'La acción de borrar película debe realizarse por POST.');
        }
        break;
    case 'borrar_pelicula_confirmacion_AAMP':
        if ($_SERVER['REQUEST_METHOD'] === 'POST') {
            \AAMP04\controlador\Controlador::confirmarBorrarPelicula($pdo, $smarty);
        } else {
            \AAMP04\controlador\Controlador::errorAccion($smarty, 'La confirmación de borrado debe realizarse por POST.');
        }
        break;
    default:
        \AAMP04\controlador\Controlador::listado($pdo, $smarty);
        break;
}
