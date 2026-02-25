<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Confirmar borrado</title>
    <style>
        .error { color: #c00; }
    </style>
</head>
<body>
    <h1>Borrar película</h1>
    <p><a href="?">Volver al listado</a></p>

    {if $error}
        <p class="error">{$error}</p>
    {elseif $pelicula}
        <p>Va a borrar la película: <strong>{$pelicula.titulo|escape}</strong> (id: {$pelicula.id}).</p>
        <form method="post" action="?accion=borrar_pelicula_confirmacion_AAMP">
            <input type="hidden" name="id" value="{$pelicula.id}">
            <label>
                <input type="checkbox" name="confirmacion" value="1">
                Confirmo que deseo borrar esta película
            </label>
            <p><button type="submit">Borrar</button></p>
        </form>
    {/if}
</body>
</html>
