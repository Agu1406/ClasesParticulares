<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Listado de películas</title>
    <style>
        table { border-collapse: collapse; margin: 1em 0; }
        th, td { border: 1px solid #333; padding: 0.4em 0.6em; text-align: left; }
        th { background: #eee; }
        .error { color: #c00; margin: 0.5em 0; }
        form { margin: 1em 0; }
        label { margin-right: 0.5em; }
    </style>
</head>
<body>
    <h1>Listado de películas</h1>

    <p><a href="?accion=nueva_pelicula_form_AAMP">Añadir película</a></p>

    {if $error}
        <p class="error">{$error}</p>
    {/if}

    {if $error_orden}
        <p class="error">{$error_orden}</p>
    {/if}

    <form method="post" action="">
        <label for="columna">Ordenar por:</label>
        <select name="columna" id="columna">
            <option value="">— Elija columna —</option>
            <option value="titulo" {if $columna_seleccionada == 'titulo'}selected{/if}>Título</option>
            <option value="anio" {if $columna_seleccionada == 'anio'}selected{/if}>Año</option>
            <option value="duracion" {if $columna_seleccionada == 'duracion'}selected{/if}>Duración</option>
        </select>
        <label for="orden">Dirección:</label>
        <select name="orden" id="orden">
            <option value="">— Elija orden —</option>
            <option value="asc" {if $orden_seleccionado == 'asc'}selected{/if}>Ascendente</option>
            <option value="desc" {if $orden_seleccionado == 'desc'}selected{/if}>Descendente</option>
        </select>
        <button type="submit">Ordenar</button>
    </form>

    <table>
        <thead>
            <tr>
                <th>Id</th>
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
            {foreach $peliculas as $p}
            <tr>
                <td>{$p.id}</td>
                <td>{$p.titulo|escape}</td>
                <td>{if isset($generos[$p.genero])}{$generos[$p.genero]|escape}{else}—{/if} ({$p.genero})</td>
                <td>{$p.direccion|escape}</td>
                <td>{$p.duracion}</td>
                <td>{$p.argumento|escape}</td>
                <td>{$p.anio}</td>
                <td>
                    <form method="post" action="" style="display:inline;">
                        <input type="hidden" name="accion" value="borrar_pelicula_form_AAMP">
                        <input type="hidden" name="id" value="{$p.id}">
                        <button type="submit">Borrar</button>
                    </form>
                </td>
            </tr>
            {/foreach}
        </tbody>
    </table>
</body>
</html>
