<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Error en la acción</title>
    <style>
        .error { color: #c00; }
    </style>
</head>
<body>
    <h1>Error en la acción</h1>
    <p><a href="?">Volver al listado</a></p>
    <p class="error">{$error_accion|escape}</p>
</body>
</html>
