<?php
declare(strict_types=1);

require_once __DIR__ . '/../config.php';
require_once __DIR__ . '/../funciones/db.php';
require_once __DIR__ . '/../funciones/dao-peliculas.php';

$id = filter_input(INPUT_POST, 'id', FILTER_VALIDATE_INT);
$confirmar = filter_input(INPUT_POST, 'confirmar', FILTER_VALIDATE_BOOL, FILTER_NULL_ON_FAILURE);

?><!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Eliminar película</title>
    <style> body { font-family: system-ui, -apple-system, Segoe UI, Roboto, Arial, sans-serif; margin: 24px; } a { color: #0b5ed7; } </style>
</head>
<body>
<h1>Eliminar película</h1>
<?php
if ($id === null || $id === false) {
    echo '<p>El id de la película no es correcto.</p>';
    echo '<p><a href="/dwes02/index.php">Volver</a></p>'; echo '</body></html>'; exit;
}

if (!$confirmar) {
    echo '<p>Es obligatorio marcar la casilla de confirmación.</p>';
    echo '<p><a href="/dwes02/index.php">Volver</a></p>'; echo '</body></html>'; exit;
}

try {
    $pdo = crearConexionPDO();
} catch (PDOException $ex) {
    http_response_code(500);
    echo '<p>Error de conexión con la base de datos.</p>';
    echo '<p><a href="/dwes02/index.php">Volver</a></p>'; echo '</body></html>'; exit;
}

$resultado = eliminarPelicula($pdo, (int)$id);
if ($resultado === false) {
    echo '<p>Se ha producido un error al eliminar.</p>';
} else {
    echo '<p>Número de registros eliminados: ' . (int)$resultado . '.</p>';
}
echo '<p><a href="/dwes02/index.php">Volver a la página principal</a></p>';
?>
</body>
</html>


