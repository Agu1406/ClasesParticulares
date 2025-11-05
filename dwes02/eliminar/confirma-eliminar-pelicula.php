<?php
declare(strict_types=1);

require_once __DIR__ . '/../config.php';
require_once __DIR__ . '/../funciones/db.php';
require_once __DIR__ . '/../funciones/dao-peliculas.php';

$id = filter_input(INPUT_POST, 'id', FILTER_VALIDATE_INT);

if ($id === null || $id === false) {
    echo '<!DOCTYPE html><html lang="es"><head><meta charset="UTF-8"><title>Error</title></head><body>';
    echo '<p>El identificador recibido no es correcto.</p>';
    echo '<p><a href="/dwes02/index.php">Volver</a></p>';
    echo '</body></html>';
    exit;
}

try {
    $pdo = crearConexionPDO();
} catch (PDOException $ex) {
    http_response_code(500);
    echo '<!DOCTYPE html><html lang="es"><head><meta charset="UTF-8"><title>Error</title></head><body>';
    echo '<h1>Error de conexión</h1>';
    echo '<p>No se puede conectar con la base de datos.</p>';
    echo '</body></html>';
    exit;
}

$pelicula = obtenerPeliculaPorId($pdo, (int)$id);

if ($pelicula === false) {
    echo '<!DOCTYPE html><html lang="es"><head><meta charset="UTF-8"><title>Error</title></head><body>';
    echo '<p>Se ha producido un error al recuperar la película.</p>';
    echo '<p><a href="/dwes02/index.php">Volver</a></p>';
    echo '</body></html>';
    exit;
}

if ($pelicula === null) {
    echo '<!DOCTYPE html><html lang="es"><head><meta charset="UTF-8"><title>No encontrada</title></head><body>';
    echo '<p>La película indicada no existe.</p>';
    echo '<p><a href="/dwes02/index.php">Volver</a></p>';
    echo '</body></html>';
    exit;
}

?><!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Confirmar eliminación</title>
    <style>
        body { font-family: system-ui, -apple-system, Segoe UI, Roboto, Arial, sans-serif; margin: 24px; }
        form { max-width: 720px; display: grid; grid-template-columns: 1fr 2fr; gap: 10px 16px; }
        input[readonly], textarea[readonly] { background: #f8f9fa; }
        .actions { grid-column: 1 / -1; display: flex; gap: 10px; align-items: center; }
        a { color: #0b5ed7; }
    </style>
</head>
<body>
    <h1>Confirmar eliminación</h1>
    <p>Revisa los datos. Marca la casilla de confirmación y pulsa confirmar para eliminar.</p>

    <form action="/dwes02/eliminar/eliminar-pelicula.php" method="post">
        <input type="hidden" name="id" value="<?php echo (int)$pelicula['id']; ?>">

        <label>Título</label>
        <input type="text" value="<?php echo htmlspecialchars((string)$pelicula['titulo']); ?>" readonly>

        <label>Dirección</label>
        <input type="text" value="<?php echo htmlspecialchars((string)$pelicula['direccion']); ?>" readonly>

        <label>Duración</label>
        <input type="text" value="<?php echo (int)$pelicula['duracion']; ?> min" readonly>

        <label>Año</label>
        <input type="text" value="<?php echo (int)$pelicula['anio']; ?>" readonly>

        <label>Argumento</label>
        <textarea rows="4" readonly><?php echo htmlspecialchars((string)$pelicula['argumento']); ?></textarea>

        <div class="actions">
            <label><input type="checkbox" name="confirmar" value="1"> Confirmo la eliminación</label>
            <button type="submit">Confirmar eliminación</button>
            <a href="/dwes02/index.php">Cancelar</a>
        </div>
    </form>
</body>
</html>


