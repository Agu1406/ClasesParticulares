<?php
// Incluimos las funciones necesarias para la inserción.
require_once "../funciones/connect-db.php";
require_once "../funciones/dao-peliculas.php";

// Creamos una conexión a la base de datos.
$conexion = conectarDB();

// Creamos un array para almacenar los datos recogidos en el formulario.
// Estas variables pueden venir desde insertar-pelicula.php cuando hay errores
$datos = $datos ?? [
    "titulo" => "",
    "genero" => "",
    "direccion" => "",
    "duracion" => "",
    "argumento" => "",
    "anio" => ""
];

// Array (inicialmente vacio) para la recepción de errores.
$errores = $errores ?? [];

// Creamos y otenemos los generos existentes.
$generos = listadoPorGeneros($conexion);

?>

<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Insertar nueva película</title>
</head>

<body>
    <H1>Autor/a: RAFAEL MORONES BURGOS - Ejercicio 3 - Tarea 2 </H1>
    <h1>Formulario para insertar nueva película </h1>
    <a href="../index/index.php">Ir a listado de películas</a>

    <?php if (!empty($errores)): ?>
        <div style="color: red; margin: 20px 0;">
            <h3>Errores encontrados:</h3>
            <ul>
                <?php foreach ($errores as $error): ?>
                    <li><?= htmlspecialchars($error) ?></li>
                <?php endforeach; ?>
            </ul>
        </div>
    <?php endif; ?>

    <!-- Formulario de inserción de datos de la película -->
    <form method="post" action="insertar-pelicula.php">
        <!-- Recogida y almacenamiento del dato "titulo" dentro del Array de datos de peliculas. -->
        <label>Título: <input type="text" name="titulo" value="<?= htmlspecialchars($datos["titulo"] ?? '') ?>" maxlength="60"></label><BR>


        <label>Género:
            <SELECT name="genero">
                <option value="Selecciona un genero"></option>
                <?php foreach ($generos as $genero): ?>
                    <option
                        value="<?= htmlspecialchars($genero["id"]) ?>"
                        <?= (isset($datos["genero"]) && $datos["genero"] == $genero["id"]) ? "selected" : "" ?>>

                        <!-- Esto es lo que ve el usuario, son los "nombres" de los generos.  -->
                        <?= htmlspecialchars($genero["nombre"]) ?>
                    </option>
                    <!-- 
                    <option value="01" selected>Ciencia Ficcion</option>
                    <option value="02" selected>Drama Koreano</option> 
                    -->
                <?php endforeach; ?>
                <!-- Opción pensada expresamente para dar error a proposito (TEST) s-->
                <option value="9999999"> GENERO NO EXISTENTE (TEST) </option>
            </SELECT>
        </label><BR>

        <label>Dirección: <input type="text" name="direccion" value="<?= htmlspecialchars($datos["direccion"] ?? '') ?>" maxlength="100"></label><BR>


        <label>Duración: <input type="text" name="duracion" value="<?= htmlspecialchars($datos["duracion"] ?? '') ?>" maxlength="500"></label><BR>


        <label>Argumento: <textarea name="argumento" maxlength="255" rows="4" cols="50"><?= htmlspecialchars($datos["argumento"] ?? '') ?></textarea></label><BR>


        <label>Año: <input type="text" name="anio" value="<?= htmlspecialchars($datos["anio"] ?? '') ?>"></label><BR>


        <input type="submit" value="¡Alta nueva película!">


    </form>
    <!-- Fin formulario de inserción de la película -->

</body>

</html>
