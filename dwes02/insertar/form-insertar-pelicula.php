<?php
declare(strict_types=1);

require_once __DIR__ . '/../config.php';
require_once __DIR__ . '/../funciones/db.php';
require_once __DIR__ . '/../funciones/dao-peliculas.php';

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

$generos = obtenerGeneros($pdo);
if ($generos === false) { $generos = []; }

// Posibles datos y errores si venimos de un intento fallido
$val = $val ?? [
    'titulo' => '',
    'genero' => '',
    'anio' => '',
    'direccion' => '',
    'duracion' => '',
    'argumento' => '',
];
$errores = $errores ?? [];

?><!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Insertar película</title>
    <style>
        body { font-family: system-ui, -apple-system, Segoe UI, Roboto, Arial, sans-serif; margin: 24px; }
        form { max-width: 720px; display: grid; grid-template-columns: 1fr 2fr; gap: 10px 16px; }
        label { align-self: center; }
        input[type="text"], select, textarea { padding: 8px; }
        .errores { background: #ffe6e6; color: #a40000; padding: 12px; margin-bottom: 16px; }
        .actions { grid-column: 1 / -1; display: flex; gap: 10px; align-items: center; }
        a { text-decoration: none; color: #0b5ed7; }
    </style>
</head>
<body>
    <h1>Registrar nueva película</h1>
    <p><a href="/dwes02/index.php">Volver al listado</a></p>

    <?php if (!empty($errores)): ?>
        <div class="errores">
            <ul>
                <?php foreach ($errores as $e): ?>
                    <li><?php echo htmlspecialchars($e); ?></li>
                <?php endforeach; ?>
            </ul>
        </div>
    <?php endif; ?>

    <form action="/dwes02/insertar/insertar-pelicula.php" method="post">
        <label for="titulo">Título</label>
        <input type="text" id="titulo" name="titulo" maxlength="60" value="<?php echo htmlspecialchars((string)$val['titulo']); ?>" required>

        <label for="genero">Género</label>
        <select id="genero" name="genero" required>
            <option value="">-- Selecciona --</option>
            <?php foreach ($generos as $g): ?>
                <option value="<?php echo (int)$g['id']; ?>" <?php echo ((string)$val['genero'] === (string)$g['id']) ? 'selected' : ''; ?>>
                    <?php echo htmlspecialchars((string)$g['nombre']); ?>
                </option>
            <?php endforeach; ?>
            <option value="999999">Incorrecto (prueba)</option>
        </select>

        <label for="anio">Año</label>
        <input type="text" id="anio" name="anio" value="<?php echo htmlspecialchars((string)$val['anio']); ?>" placeholder="Ej: 2020" required>

        <label for="direccion">Dirección</label>
        <input type="text" id="direccion" name="direccion" maxlength="100" value="<?php echo htmlspecialchars((string)$val['direccion']); ?>" required>

        <label for="duracion">Duración (min)</label>
        <input type="text" id="duracion" name="duracion" value="<?php echo htmlspecialchars((string)$val['duracion']); ?>" placeholder="Ej: 120" required>

        <label for="argumento">Argumento</label>
        <textarea id="argumento" name="argumento" rows="4" maxlength="255" required><?php echo htmlspecialchars((string)$val['argumento']); ?></textarea>

        <div class="actions">
            <button type="submit">Insertar</button>
            <a href="/dwes02/index.php">Cancelar</a>
        </div>
    </form>
</body>
</html>


