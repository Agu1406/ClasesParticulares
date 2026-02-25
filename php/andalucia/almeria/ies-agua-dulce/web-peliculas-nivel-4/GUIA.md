# GUÍA – Web películas nivel 4 (MVC)

Registro paso a paso de lo realizado en el proyecto.  
**Convención**: en el enunciado "XYZ" son las **iniciales del alumno** (ej. AAMP). Se sustituye XYZ por tus iniciales en el **namespace** (ej. AAMP04). Para carpetas usamos **por defecto** `src` (clases) y `plantillas` (Smarty); solo si el enunciado exige "srcxyz" o "plantillasxyz" literal se usa src+iniciales (ej. srcaamp) y plantillas+iniciales (ej. plantillasaamp).

---

## PASO 1 – Preparar el script de base de datos

### Objetivo
Tener un SQL válido para importar en MySQL (XAMPP) y crear las tablas y datos de ejemplo.

### Archivo
- `peliculas_nivel_4.sql`

### Cambios realizados
- **Corrección de sintaxis**: en la definición de la tabla `peliculas`, la línea final tenía `ENGINE = InnoDB:` (dos puntos). Se corrigió a `ENGINE = InnoDB;` (punto y coma) para que MySQL acepte la sentencia.

### Cómo importar en XAMPP
1. Crear una base de datos en phpMyAdmin (por ejemplo `peliculas_nivel_4`).
2. Seleccionar esa base de datos.
3. Ir a “Importar” y elegir el archivo `peliculas_nivel_4.sql`.
4. Ejecutar la importación.

### Estructura resultante
- Tabla `generos`: id, nombre, descripcion.
- Tabla `peliculas`: id, titulo, genero (FK a generos), direccion, duracion, argumento, anio.
- Datos de ejemplo: 6 géneros y 18 películas.

---

## PASO 2 – Ejercicio 01: Proyecto con Composer y Smarty

En este paso se configura el proyecto con Composer, namespace **AAMP04**, autoload PSR-4 y Smarty. La raíz del proyecto es `web-peliculas-nivel-4` (no se usa carpeta `dwes04`).

**Orden recomendado (todo lo que hacemos en el Ejercicio 01):**  
1. Tener PHP en el PATH y Composer instalado (2.1).  
2. `composer init` en la raíz del proyecto; responder a las preguntas (2.2).  
3. Corregir `composer.json`: autoload `"AAMP04\\": "src/"` (2.3).  
4. Crear carpetas: **src**, **plantillas**, **tmp**, **tmp/compiled_templates**, **tmp/smarty_cache** (2.3 y 2.5).  
5. `composer dump-autoload` (2.3).  
6. `composer require smarty/smarty:4.4.1` (2.4).  
7. Crear **.gitignore** para no subir `vendor/` ni cientos de archivos (2.7).  
8. (Opcional) Clase de prueba, plantillas y `prueba1.php` (2.6).

---

### 2.1 – Instalar Composer
- Seguir la documentación oficial: https://getcomposer.org/download/
- En Windows con XAMPP: descargar el instalador o el `composer.phar` y asegurarse de tener PHP en el PATH.
- Comprobar que funciona: abrir terminal en la raíz del proyecto y ejecutar `composer --version`.

### 2.2 – Inicializar el proyecto con Composer
- En la carpeta `web-peliculas-nivel-4`, ejecutar: `composer init`
- Responder a las preguntas (nombre del paquete puede ser algo como `aamp04/web-peliculas-nivel-4`, descripción, autor, etc.). En “Would you define your dev dependencies” elegir “no” por ahora.
- Se generará el archivo `composer.json`.

**Respuestas concretas para cada pregunta de `composer init`:**

| Pregunta | Respuesta |
|----------|-----------|
| Package name | `aamp04/web-peliculas-nivel-4` o `aamp/web-peliculas-nivel-4` |
| Description | Una frase o Enter para vacío |
| Author | Nombre y email, o `n` para omitir |
| Minimum Stability | `stable` (o Enter) |
| Package Type | `project` (aplicación web) |
| License | `unlicense` o Enter para omitir |
| Define dev dependencies interactively? | `n` |
| Define dependencies interactively? | `n` |
| Add PSR-4 autoload mapping? [src/, n to skip] | Pulsa **Enter** para usar `src/`. Composer propondrá un namespace distinto (ej. Aamp\\WebPeliculasNivel4). Responde **yes** a "Do you confirm generation?" y luego corrige el namespace en `composer.json` (ver 2.3). |
| Do you confirm generation [yes]? | **yes**. Después edita `composer.json` y deja el autoload como en 2.3. |

### 2.3 – Namespace y directorio de clases (XYZ04 / src por defecto)
- **Carpeta de clases**: usamos **src** por defecto. (Si el enunciado exige "srcxyz", usa src+iniciales, ej. srcaamp.)
- Crear la carpeta **src** dentro de `web-peliculas-nivel-4` (si no existe).
- En `composer.json`, dejar el autoload así (namespace **TUS_INICIALES04**, carpeta **src**):
  ```json
  "autoload": {
      "psr-4": {
          "AAMP04\\": "src/"
      }
  }
  ```
  (Sustituye AAMP04 por tus iniciales + 04.)
- Ejecutar: `composer dump-autoload`.

**Resumen "¿Ahora qué hago?" después de `composer init`:**  
1) Corregir `composer.json`: autoload con `"AAMP04\\": "src/"`.  
2) Crear carpetas: **src**, **plantillas**, **tmp**, **tmp/compiled_templates**, **tmp/smarty_cache**.  
3) `composer dump-autoload`.  
4) `composer require smarty/smarty:4.4.1`.

### 2.4 – Añadir Smarty 4.4.1
- En la raíz del proyecto ejecutar:  
  `composer require smarty/smarty:4.4.1`
- Composer descargará Smarty y actualizará `composer.json` y `composer.lock`, y creará/actualizará la carpeta `vendor/`.

### 2.5 – Directorios para plantillas y cache de Smarty
- Usamos la carpeta **plantillas** por defecto. (Si el enunciado exige "plantillasxyz", usa plantillas+iniciales, ej. plantillasaamp.)
- Crear dentro de `web-peliculas-nivel-4`:
  - **plantillas** (plantillas Smarty)
  - **tmp/compiled_templates** (plantillas compiladas)
  - **tmp/smarty_cache** (caché de Smarty)

### 2.6 – Recomendación: clase de prueba, plantillas y prueba1.php (opcional)
- Crear una clase de prueba en **src/** con namespace `AAMP04` (o el tuyo), con constructor y al menos dos métodos de instancia.
- Crear dos plantillas en **plantillas/**: una con formulario y otra para mostrar resultados.
- Crear `prueba1.php` en la raíz que cargue `vendor/autoload.php`, use la clase de prueba y Smarty, y muestre el formulario o el resultado según corresponda.
- La URL será la que corresponda a tu instalación, por ejemplo:  
  `http://localhost/.../web-peliculas-nivel-4/prueba1.php`

### 2.7 – .gitignore (no subir vendor ni cientos de archivos)

Tras `composer require`, aparece la carpeta **vendor/** con cientos de archivos. **No se deben commitear**: se regeneran con `composer install` a partir de `composer.json` y `composer.lock`.

- Crear en la raíz del proyecto (`web-peliculas-nivel-4`) un archivo **.gitignore** con al menos:
  ```
  # Dependencias de Composer (se generan con composer install)
  vendor/

  # Configuración local (base de datos, etc.)
  .env
  .env.local
  *.local.php
  ```
- **Sí se suben a Git**: `composer.json`, `composer.lock`, `src/`, `plantillas/`, `GUIA.md`, `peliculas_nivel_4.sql`, `Peticion.php`, etc.  
- **No se suben**: `vendor/`, y opcionalmente `.env` si guardas ahí credenciales.
- Si ya habías añadido `vendor/` al commit: `git reset HEAD -- vendor/` (o `git reset HEAD -- .` y luego `git add .`) y vuelve a hacer `git status`; deberían desaparecer los cientos de archivos.

---

## Preguntas frecuentes (FAQ)

Todas las preguntas que suelen surgir al seguir esta guía, con la respuesta en un solo sitio.

### Composer y PHP

**P: Al ejecutar `composer init` o `composer require` sale: *"php" no se reconoce como un comando interno o externo*. ¿Qué hago?**  
R: PHP no está en el PATH de Windows. Composer necesita poder ejecutar `php`.  
- Localiza la carpeta de PHP de XAMPP (suele ser `C:\xampp\php`, donde está `php.exe`).  
- En la misma terminal, añade PHP al PATH solo para esta sesión:  
  `$env:Path += ";C:\xampp\php"`  
  (ajusta la ruta si tu XAMPP está en otro sitio).  
- Comprueba con `php -v` y luego ejecuta de nuevo `composer init`.  
- Para que sea permanente: Panel de control → Variables de entorno → Editar "Path" → Añadir la ruta de la carpeta donde está `php.exe` → Aceptar. Cierra y abre de nuevo la terminal.

### Nombre del paquete (composer init)

**P: ¿Qué nombre de paquete pongo en composer init? ¿Solo "aamp"?**  
R: Composer espera formato **vendor/paquete**. Ejemplos válidos:  
- `aamp04/web-peliculas-nivel-4` (recomendado: coincide con el namespace tipo XYZ04)  
- `aamp/web-peliculas-nivel-4`  
Sustituye "aamp" por tus propias iniciales si lo deseas.

### Minimum Stability

**P: ¿Qué pongo en "Minimum Stability"?**  
R: **stable**. Con eso solo se instalan versiones estables. Para esta práctica es suficiente. Si viene ya "stable" por defecto, pulsa Enter.

### Package Type

**P: ¿Qué pongo en "Package Type"?**  
R: **project**. Es una aplicación web, no una librería. Escribe: `project`.

### Directorio de clases: ¿src o src + iniciales?

**P: ¿Uso "src" o "srcaamp" (src + iniciales)? ¿Y "plantillas" o "plantillasaamp"?**  
R: En esta guía usamos **por defecto**:
- **src** para las clases.
- **plantillas** para las plantillas Smarty.  
Solo si el enunciado exige literalmente "srcxyz" o "plantillasxyz" (carpeta con iniciales), usa src+iniciales (ej. srcaamp) y plantillas+iniciales (ej. plantillasaamp). No uses "scraamp" (falta la *c* de *src*).

### PSR-4 y "Do you confirm generation?"

**P: Composer propone namespace "Aamp\WebPeliculasNivel4" y carpeta "src/". ¿Confirmo?**  
R: Responde **yes** a "Do you confirm generation?". Luego:  
1. Abre `composer.json` y en `autoload` → `psr-4` deja solo tu namespace (ej. `AAMP04\`) y la carpeta **src/** (ej. `"AAMP04\\": "src/"`).  
2. Crea la carpeta **src** si no existe.  
3. Ejecuta `composer dump-autoload`.  
Así el autoload queda correcto sin repetir `composer init`.

### Git: ¿Por qué 476 archivos para commit? ¿Hace falta .gitignore?

**P: Al hacer git status salen cientos de archivos (p. ej. 476). ¿Hace falta un .gitignore?**  
R: **Sí.** La carpeta **vendor/** no debe subirse al repositorio: son dependencias que se generan con `composer install`. Crea un archivo **.gitignore** en la raíz del proyecto con la línea `vendor/` (y opcionalmente `.env`). Así Git ignorará esos archivos. Sí debes commitear **composer.json** y **composer.lock** para que quien clone el repo pueda ejecutar `composer install` y obtener el mismo `vendor/`. Ver apartado 2.7.

---

## Checklist Ejercicio 01 (resumen)

- [ ] PHP en el PATH; `composer --version` funciona  
- [ ] `composer init`; respuestas según tabla 2.2; confirmar **yes**  
- [ ] `composer.json`: autoload `"AAMP04\\": "src/"`  
- [ ] Carpetas creadas: **src**, **plantillas**, **tmp**, **tmp/compiled_templates**, **tmp/smarty_cache**  
- [ ] `composer dump-autoload`  
- [ ] `composer require smarty/smarty:4.4.1`  
- [ ] Archivo **.gitignore** con `vendor/` (y opcionalmente `.env`)  
- [ ] (Opcional) Clase de prueba en src/, plantillas, prueba1.php  

---

*(Los siguientes pasos — Ejercicio 02 modelo, controladores, etc. — se irán añadiendo aquí.)*
