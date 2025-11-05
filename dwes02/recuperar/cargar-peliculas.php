<?php
// Variables esperadas: $peliculas (array) y $generosPorId (array id=>nombre)

if (!is_array($peliculas)) {
    echo '<p>No hay datos que mostrar.</p>';
    return;
}

echo '<table>';
echo '<thead><tr>';
echo '<th>ID</th><th>Título</th><th>Género</th><th>Dirección</th><th>Duración</th><th>Año</th><th>Argumento</th><th>Acciones</th>';
echo '</tr></thead>';
echo '<tbody>';

foreach ($peliculas as $p) {
    $generoId = $p['genero'];
    $generoNombre = '';
    if ($generoId !== null) {
        $gid = (int)$generoId;
        $generoNombre = $generosPorId[$gid] ?? (string)$gid;
    }

    echo '<tr>';
    echo '<td>' . (int)$p['id'] . '</td>';
    echo '<td>' . htmlspecialchars((string)$p['titulo']) . '</td>';
    echo '<td>' . htmlspecialchars($generoNombre) . '</td>';
    echo '<td>' . htmlspecialchars((string)$p['direccion']) . '</td>';
    echo '<td>' . (int)$p['duracion'] . '</td>';
    echo '<td>' . (int)$p['anio'] . '</td>';
    echo '<td>' . htmlspecialchars((string)$p['argumento']) . '</td>';
    echo '<td class="acciones">';
    // Botón eliminar (POST) hacia confirma-eliminar-pelicula.php
    echo '<form action="/dwes02/eliminar/confirma-eliminar-pelicula.php" method="post">';
    echo '<input type="hidden" name="id" value="' . (int)$p['id'] . '">';
    echo '<button type="submit">Eliminar</button>';
    echo '</form>';
    echo '</td>';
    echo '</tr>';
}

echo '</tbody>';
echo '</table>';


