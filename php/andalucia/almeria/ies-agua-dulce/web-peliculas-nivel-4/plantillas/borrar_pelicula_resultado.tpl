<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Resultado borrado</title>
    <style>
        .error { color: #c00; }
        .ok { color: #080; }
    </style>
</head>
<body>
    <h1>Borrado de película</h1>
    <p><a href="?">Volver al listado</a></p>

    {if $borrado_ok}
        <p class="ok">La película se ha borrado correctamente.</p>
    {elseif $error}
        <p class="error">{$error}</p>
    {/if}
</body>
</html>
