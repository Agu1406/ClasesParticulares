# Pregunta

Escribe un script en Bash que recorra todos los archivos de un directorio y los copie a otro directorio, omitiendo los directorios. 

# Respuesta

## Script básico

```bash
#!/bin/bash

origen="$1"
destino="$2"

for archivo in "$origen"/*; do
    if [ -f "$archivo" ]; then
        cp "$archivo" "$destino"
    fi
done
```

**Ejemplo de uso:**
```bash
./script.sh /home/usuario/documentos /home/usuario/backup
```

En este ejemplo:
- **`origen`** = `/home/usuario/documentos` (primer argumento `$1`)
- **`destino`** = `/home/usuario/backup` (segundo argumento `$2`)

El script copiará todos los archivos del directorio `/home/usuario/documentos` al directorio `/home/usuario/backup`, omitiendo cualquier subdirectorio que haya en `documentos`.

### Explicación

El script cumple con todos los requisitos:

1. **Es un script en Bash**: La línea `#!/bin/bash` indica que es un script Bash ejecutable.

2. **Recorre todos los archivos de un directorio**: 
   - `for archivo in "$origen"/*` itera sobre todos los elementos del directorio origen
   - El `*` es un wildcard que selecciona todos los elementos (archivos y directorios)

3. **Omitiendo los directorios**:
   - `[ -f "$archivo" ]` verifica que el elemento sea un archivo regular (no un directorio)
   - Solo si es un archivo (`-f` = file), se ejecuta el bloque `if`
   - Los directorios se omiten porque `[ -f "$directorio" ]` devuelve `false`

4. **Los copia a otro directorio**:
   - `cp "$archivo" "$destino"` copia el archivo al directorio destino
   - Los parámetros `$1` y `$2` son el primer y segundo argumento pasados al script

**¿Por qué `$1` y no `$0`?**

En Bash, las variables especiales funcionan así:
- `$0` = nombre del script (ej: `./script.sh` o `/ruta/script.sh`)
- `$1` = primer argumento pasado al script
- `$2` = segundo argumento pasado al script
- `$3`, `$4`, etc. = argumentos siguientes

Por eso usamos `$1` para el directorio origen (primer argumento) y `$2` para el destino (segundo argumento), no `$0` que sería el nombre del script mismo.

**Ejemplo de ejecución:**
```bash
./script.sh /ruta/origen /ruta/destino
# $0 = "./script.sh"
# $1 = "/ruta/origen"
# $2 = "/ruta/destino"
```

## Script mejorado con validaciones

```bash
#!/bin/bash

origen="$1"
destino="$2"

mkdir -p "$destino"

for archivo in "$origen"/*; do
    [ -f "$archivo" ] && cp "$archivo" "$destino"
done
```