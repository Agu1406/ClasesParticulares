<?php
// Incluimos el control de acceso al área privada
require_once 'accesoareaprivada.php';

// Cargamos las funciones necesarias
require_once '../funciones/dao.php';

// Creamos la conexión
$conexion = conectarDB();

// Array para errores
$errores = [];

// Validamos el id de la película recibido por GET
$idPelicula = filter_input(INPUT_GET, 'id', FILTER_VALIDATE_INT);

if ($idPelicula === false || $idPelicula === null || $idPelicula < 1) {
    $errores[] = "El id de la película no es válido.";
} else {
    // Verificamos que la conexión es válida
    if ($conexion === false) {
        $errores[] = "No ha sido posible establecer una conexión con la base de datos.";
    } else {
        // Obtenemos los datos de la película
        $pelicula = obtenerPeliculaPorId($conexion, $idPelicula);
        
        if ($pelicula === false || empty($pelicula)) {
            $errores[] = "La película no existe en la base de datos.";
        } else {
            // Obtenemos las votaciones de la película
            $votaciones = obtenerVotacionesPorPelicula($conexion, $idPelicula);
            
            if ($votaciones === false) {
                $errores[] = "No ha sido posible obtener las votaciones de la película.";
            }
        }
    }
}

// Obtenemos el id del usuario autenticado
$idUsuarioAutenticado = $_SESSION['id'] ?? null;
?>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=100%, initial-scale=1.0">
    <title>Lista de votos y criticas</title>
</head>
<body>
    <H1>DWES 03. AUTOR: RAFAEL MORONES BURGOS.</H1>
    <h1>Lista de votos y criticas</h1>
    
    <?php if (!empty($errores)): ?>
        <h2>Se han producido los siguientes errores:</h2>
        <ul>
            <?php foreach ($errores as $error): ?>
                <li><?= htmlspecialchars($error) ?></li>
            <?php endforeach; ?>
        </ul>
        <a href="../index/index.php">Volver al listado de películas</a>
    <?php else: ?>
        <H2>Datos de la película</H2>
        <div>
            <strong>Título:</strong> <?= htmlspecialchars($pelicula['titulo']) ?><br>
            <strong>Género:</strong> <?= htmlspecialchars($pelicula['nombre_genero'] ?? 'Sin género') ?><br>
            <strong>Director:</strong> <?= htmlspecialchars($pelicula['direccion']) ?><br>
            <strong>Duración:</strong> <?= htmlspecialchars($pelicula['duracion']) ?> minutos<br>
            <strong>Año:</strong> <?= htmlspecialchars($pelicula['anio']) ?><br>
        </div>
        <hr>
        <table border="1" cellpadding="6" cellspacing="0">
            <thead>
                <tr>
                    <th>Usuario</th>
                    <th>Voto</th>
                    <th>Crítica</th>
                    <th>Eliminar</th>
                </tr>
            </thead>
            <tbody>
                <?php if ($votaciones === false || empty($votaciones)): ?>
                    <tr>
                        <td colspan="4">No hay votaciones para esta película.</td>
                    </tr>
                <?php else: ?>
                    <?php foreach ($votaciones as $votacion): ?>
                        <tr>
                            <td><?= htmlspecialchars($votacion['login']) ?></td>
                            <td><?= htmlspecialchars($votacion['valoracion']) ?></td>
                            <td><?= htmlspecialchars($votacion['comentario']) ?></td>
                            <td>
                                <?php if ($idUsuarioAutenticado !== null && $votacion['usuario'] == $idUsuarioAutenticado): ?>
                                    <form method="post" action="eliminarvoto.php">
                                        <input type="hidden" name="id_critica" value="<?= htmlspecialchars($votacion['id']) ?>">
                                        <input type="submit" value="Eliminar voto/critica">
                                    </form>
                                <?php else: ?>
                                    -
                                <?php endif; ?>
                            </td>
                        </tr>
                    <?php endforeach; ?>
                <?php endif; ?>
            </tbody>
        </table>
        <br>
        <a href="../index/index.php">Volver al listado de películas</a>
    <?php endif; ?>
</body>
</html>
