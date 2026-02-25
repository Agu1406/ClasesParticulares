<?php

?>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../codeparts/estilo.css">
    <title>Formulario de Login</title>
</head>

<body>
    <H1>DWES 03. AUTOR: RAFAEL MORONES BURGOS</H1>

    <h1>Formulario de Login</h1>

    <form action="procesarlogin.php" method="POST">
        <div>
            <label for="login">Usuario</label>
            <input type="text" id="login" name="login">
        </div>
        <div>
            <label for="contraseña">Contraseña</label>
            <input type="password" id="contraseña" name="contraseña">
        </div>
        <button type="submit" name="entrar">Entrar</button>
    </form>
</body>

</html>