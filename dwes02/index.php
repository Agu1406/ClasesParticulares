<?php
declare(strict_types=1);

require_once __DIR__ . '/config.php';
require_once __DIR__ . '/funciones/db.php';
require_once __DIR__ . '/funciones/dao-peliculas.php';

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

$anio = null;
// Admite filtrado por GET o POST
$anioGet = filter_input(INPUT_GET, 'anio', FILTER_VALIDATE_INT);
$anioPost = filter_input(INPUT_POST, 'anio', FILTER_VALIDATE_INT);
if ($anioGet !== null && $anioGet !== false) {
    $anio = (int)$anioGet;
} elseif ($anioPost !== null && $anioPost !== false) {
    $anio = (int)$anioPost;
}

$peliculas = obtenerPeliculas($pdo, $anio);
$generos = obtenerGeneros($pdo);

// Mapeo id => nombre de género para mostrar el nombre en la tabla
$generosPorId = [];
if (is_array($generos)) {
    foreach ($generos as $g) {
        $generosPorId[(int)$g['id']] = (string)$g['nombre'];
    }
}

?><!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>DWES02 - Películas</title>
    <style>
        body { font-family: system-ui, -apple-system, Segoe UI, Roboto, Arial, sans-serif; margin: 24px; }
        table { border-collapse: collapse; width: 100%; margin-top: 16px; }
        th, td { border: 1px solid #ccc; padding: 8px 10px; text-align: left; }
        th { background: #f5f5f5; }
        .acciones form { display: inline; margin: 0; }
        .topbar { display: flex; gap: 16px; align-items: center; }
        .topbar a { text-decoration: none; color: #0b5ed7; }
        .filter { margin-top: 8px; }
    </style>
    <!-- Enlace a insertar nueva película -->
</head>
<body>
    <div class="topbar">
        <h1>Gestión de Películas</h1>
        <a href="/dwes02/insertar/form-insertar-pelicula.php">Insertar nueva película</a>
    </div>

    <section class="filter">
        <h2>Filtrar por año</h2>
        <form action="/dwes02/index.php" method="get">
            <label for="anio">Año:</label>
            <input type="text" name="anio" id="anio" value="<?php echo $anio !== null ? htmlspecialchars((string)$anio) : ''; ?>" />
            <button type="submit">Filtrar</button>
            <a href="/dwes02/index.php">Quitar filtro</a>
        </form>
    </section>

    <section>
        <h2>Listado de películas <?php echo $anio !== null ? '('.(int)$anio.')' : ''; ?></h2>
        <?php
        if ($peliculas === false) {
            echo '<p>Se ha producido un error al obtener las películas.</p>';
        } else {
            // Disponibles: $peliculas y $generosPorId
            include __DIR__ . '/recuperar/cargar-peliculas.php';
        }
        ?>
    </section>
</body>
</html>


