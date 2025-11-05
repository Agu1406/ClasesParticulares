<?php
// Asumimos que $peliculas y $valorGeneros vienen de index.php
// $valorGeneros es un array asociativo id => nombre
?>
<table border="1" cellspacing="0" cellpadding="5">
    <thead>
        <tr>
            <th>ID</th>
            <th>Título</th>
            <th>Género</th>
            <th>Dirección</th>
            <th>Duración</th>
            <th>Argumento</th>
            <th>Año</th>
            <th>Acciones</th>
        </tr>
    </thead>
    <tbody>
        <?php foreach ($peliculas as $pelicula): ?>
            <tr>
                <td><?= htmlspecialchars($pelicula['id']) ?></td>
                <td><?= htmlspecialchars($pelicula['titulo']) ?></td>
                <td>
                    <?= isset($valorGeneros[$pelicula['genero']]) ?
                        htmlspecialchars($valorGeneros[$pelicula['genero']]) :
                        'Desconocido' ?>
                </td>
                <td><?= htmlspecialchars($pelicula['direccion']) ?></td>
                <td><?= htmlspecialchars($pelicula['duracion']) ?></td>
                <td><?= htmlspecialchars($pelicula['argumento']) ?></td>
                <td><?= htmlspecialchars($pelicula['anio']) ?></td>
                <td>
                    <form method="post" action="../eliminar/confirma-eliminar-pelicula.php" style="display: inline;">
                        <input type="hidden" name="id" value="<?= htmlspecialchars($pelicula['id']) ?>">
                        <input type="submit" value="Eliminar">
                    </form>
                </td>
            </tr>
        <?php endforeach; ?>
    </tbody>
</table>