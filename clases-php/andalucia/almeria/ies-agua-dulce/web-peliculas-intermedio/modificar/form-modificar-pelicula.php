<?php

?>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Modificar una película</title>
</head>
<body>
    <H1>Autor/a: INDICAR AUTOR/A - Ejercicio 4 - Tarea 2 </H1>
    <h1>Formulario para modificar una película </h1>
    <a href="../index.php">Ir a la página principal</a><br><br>

    <!-- Inicio formulario de modificación de la película -->    
    <form>
        <label>Título: <input type="text"></label>
        <BR>
        <label>Género: <SELECT>                    
                <option value="9999999"> GENERO NO EXISTENTE (TEST) </option>                
            </SELECT>
        </label><BR>
        <label>Dirección: <input type="text"></label><BR>
        <label>Duración: <input type="text"></label><BR>
        <label>Argumento: <input type="text"></label><BR>
        <label>Año: <input type="text"></label><BR>  
        <input type="submit" value="¡Modificar película!">
    </form>
    <!-- Fin formulario de modificación de la película -->    
</body>

</html>
