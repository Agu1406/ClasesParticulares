<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Añadir película</title>
    <style>
        .error { color: #c00; }
        label { display: inline-block; width: 100px; }
        input, select, textarea { margin-bottom: 0.5em; }
        .campo-error { color: #c00; font-size: 0.9em; }
    </style>
</head>
<body>
    <h1>Añadir película</h1>
    <p><a href="?">Volver al listado</a></p>

    {if $error}
        <p class="error">{$error}</p>
    {/if}

    <form method="post" action="?accion=nueva_pelicula_guardar_AAMP">
        <p>
            <label for="titulo">Título:</label>
            <input type="text" name="titulo" id="titulo" value="{$datos.titulo|default:''|escape}" maxlength="60" size="40">
            {if isset($errores.titulo)}<span class="campo-error">{$errores.titulo}</span>{/if}
        </p>
        <p>
            <label for="genero">Género:</label>
            <select name="genero" id="genero">
                <option value="">— Elija género —</option>
                {foreach $generos as $g}
                    <option value="{$g.id}" {if isset($datos.genero) && $datos.genero == $g.id}selected{/if}>{$g.nombre|escape}</option>
                {/foreach}
            </select>
            {if isset($errores.genero)}<span class="campo-error">{$errores.genero}</span>{/if}
        </p>
        <p>
            <label for="direccion">Dirección:</label>
            <input type="text" name="direccion" id="direccion" value="{$datos.direccion|default:''|escape}" maxlength="100" size="40">
            {if isset($errores.direccion)}<span class="campo-error">{$errores.direccion}</span>{/if}
        </p>
        <p>
            <label for="duracion">Duración (min):</label>
            <input type="number" name="duracion" id="duracion" value="{$datos.duracion|default:''}" min="1" max="499" size="5">
            {if isset($errores.duracion)}<span class="campo-error">{$errores.duracion}</span>{/if}
        </p>
        <p>
            <label for="argumento">Argumento:</label>
            <textarea name="argumento" id="argumento" rows="4" cols="50" maxlength="255">{$datos.argumento|default:''|escape}</textarea>
            {if isset($errores.argumento)}<span class="campo-error">{$errores.argumento}</span>{/if}
        </p>
        <p>
            <label for="anio">Año:</label>
            <input type="number" name="anio" id="anio" value="{$datos.anio|default:''}" min="1965" max="{$anio_actual}" size="6">
            {if isset($errores.anio)}<span class="campo-error">{$errores.anio}</span>{/if}
        </p>
        <p>
            <button type="submit">Guardar película</button>
        </p>
    </form>
</body>
</html>
