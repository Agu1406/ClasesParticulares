<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Resultado alta película</title>
    <style>
        .error { color: #c00; }
        .ok { color: #080; }
    </style>
</head>
<body>
    <h1>Alta de película</h1>
    <p><a href="?">Volver al listado</a> | <a href="?accion=nueva_pelicula_form_AAMP">Añadir otra</a></p>

    {if $error_guardar}
        <p class="error">{$error_guardar}</p>
    {elseif $id_creado !== null}
        <p class="ok">Película dada de alta correctamente. Id asignado: <strong>{$id_creado}</strong></p>
    {/if}
</body>
</html>
