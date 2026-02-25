# GUÍA – Web películas nivel 4 (MVC)

Registro paso a paso de lo realizado en el proyecto.  
**Convención**: en el enunciado "XYZ" son las **iniciales del alumno** (ej. AAMP). Se sustituye XYZ por tus iniciales en el **namespace** (ej. AAMP04). Para carpetas usamos **por defecto** `src` (clases) y `plantillas` (Smarty); solo si el enunciado exige "srcxyz" o "plantillasxyz" literal se usa src+iniciales (ej. srcaamp) y plantillas+iniciales (ej. plantillasaamp).

---

# Índice

- [PASO 1 – Preparar el script de base de datos](#paso-1--preparar-el-script-de-base-de-datos)
	- [Objetivo](#objetivo)
	- [Archivo](#archivo)
	- [Cambios realizados](#cambios-realizados)
	- [Cómo importar en XAMPP](#cómo-importar-en-xampp)
	- [Estructura resultante](#estructura-resultante)
- [PASO 2 – Ejercicio 01: Proyecto con Composer y Smarty](#paso-2--ejercicio-01-proyecto-con-composer-y-smarty)
	- [2.1 – Instalar Composer](#21--instalar-composer)
	- [2.2 – Inicializar el proyecto con Composer](#22--inicializar-el-proyecto-con-composer)
	- [2.3 – Namespace y directorio de clases (XYZ04 / src por defecto)](#23--namespace-y-directorio-de-clases-xyz04--src-por-defecto)
	- [2.4 – Añadir Smarty 4.4.1](#24--añadir-smarty-441)
	- [2.5 – Directorios para plantillas y cache de Smarty](#25--directorios-para-plantillas-y-cache-de-smarty)
	- [2.6 – Recomendación: clase de prueba, plantillas y prueba1.php (opcional)](#26--recomendación-clase-de-prueba-plantillas-y-prueba1php-opcional)
	- [2.7 – .gitignore (no subir vendor ni cientos de archivos)](#27--gitignore-no-subir-vendor-ni-cientos-de-archivos)
- [Preguntas frecuentes (FAQ)](#preguntas-frecuentes-faq)
	- [Composer y PHP](#composer-y-php)
	- [Nombre del paquete (composer init)](#nombre-del-paquete-composer-init)
	- [Minimum Stability](#minimum-stability)
	- [Package Type](#package-type)
	- [Directorio de clases: ¿src o src + iniciales?](#directorio-de-clases-src-o-src--iniciales)
	- [PSR-4 y "Do you confirm generation?"](#psr-4-y-do-you-confirm-generation)
	- [Git: ¿Por qué 476 archivos para commit? ¿Hace falta .gitignore?](#git-por-qué-476-archivos-para-commit-hace-falta-gitignore)
- [Checklist Ejercicio 01 (resumen)](#checklist-ejercicio-01-resumen)
- [PASO 3 – Ejercicio 02: Modelo (MVC)](#paso-3--ejercicio-02-modelo-mvc)
	- [Reglas importantes](#reglas-importantes)
	- [Estructura de namespaces y carpetas](#estructura-de-namespaces-y-carpetas)
	- [Orden de creación de los archivos (y por qué)](#orden-de-creación-de-los-archivos-y-por-qué)
	- [3.1 – Enumerado DBResult](#31--enumerado-dbresult-srcserviciosdbresultphp)
	- [3.2 – Clase abstracta EntidadIdentificable](#32--clase-abstracta-entidadidentificable-srcmodeloentidadidentificablephp)
	- [3.3 – Interfaz IGuardable](#33--interfaz-iguardable-srcmodeloiguardablephp)
	- [3.4 – Interfaz IListable](#34--interfaz-ilistable-srcmodeloilistablephp)
	- [3.5 – Clase Genero](#35--clase-genero-srcmodelogenerophp)
	- [3.6 – Clase Generos](#36--clase-generos-srcmodelogenerosphp)
	- [3.7 – Clase Pelicula](#37--clase-pelicula-srcmodelopeliculaphp)
	- [3.8 – Clase Peliculas](#38--clase-peliculas-srcmodelopeliculasphp)
	- [Checklist Ejercicio 02 (respetando el orden)](#checklist-ejercicio-02-respetando-el-orden)

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

| [Anterior](#índice) | [Índice](#índice) | [Siguiente](#paso-2--ejercicio-01-proyecto-con-composer-y-smarty) |
|-----------|-------|------------|

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

| [Anterior](#paso-1--preparar-el-script-de-base-de-datos) | [Índice](#índice) | [Siguiente](#preguntas-frecuentes-faq) |
|-----------|-------|------------|

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

| [Anterior](#paso-2--ejercicio-01-proyecto-con-composer-y-smarty) | [Índice](#índice) | [Siguiente](#checklist-ejercicio-01-resumen) |
|-----------|-------|------------|

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

| [Anterior](#preguntas-frecuentes-faq) | [Índice](#índice) | [Siguiente](#paso-3--ejercicio-02-modelo-mvc) |
|-----------|-------|------------|

---

## PASO 3 – Ejercicio 02: Modelo (MVC)

El modelo da soporte a los datos de la aplicación. **Solo en las clases del modelo** se accede a la base de datos (con PDO). El controlador y las vistas no ejecutan SQL ni crean conexiones.

### Reglas importantes
- **Solo PDO** para acceder a la base de datos.
- El código que toca la BD **solo** va en las clases del modelo (no en controladores ni en scripts sueltos).
- En todo método que ejecute consultas: **consultas preparadas** cuando haya parámetros (evita inyección SQL) y **try-catch** para capturar excepciones y devolver un valor controlado (p. ej. un valor del enumerado DBResult).
- El modelo **no** hace `echo` ni imprime HTML; **no** crea la conexión PDO (la recibe por parámetro desde el enrutador o el controlador).
- **No** se usa `include` ni `require` para estas clases: se cargan por **autoload PSR-4** (Composer).

### Estructura de namespaces y carpetas
- **AAMP04\servicios**: solo el enumerado `DBResult`. Ruta: `src/servicios/DBResult.php`. Va en un subespacio distinto porque es un “servicio” reutilizable, no una entidad de negocio.
- **AAMP04\modelo**: todo lo demás del modelo (entidades, interfaces, listados). Ruta: `src/modelo/*.php`. A ese directorio lo llamamos **directorio del modelo**.

---

### Orden de creación de los archivos (y por qué)

Hay que crear los archivos en un orden que respete las **dependencias**: no puedes implementar una clase que use `DBResult` o `EntidadIdentificable` si aún no existen. El orden que se sigue es:

| Orden | Archivo | Motivo |
|-------|---------|--------|
| **1** | `src/servicios/DBResult.php` | No depende de ninguna otra clase nuestra. Las interfaces y el resto del modelo devuelven o usan `DBResult`, así que debe existir primero. |
| **2** | `src/modelo/EntidadIdentificable.php` | Clase base abstracta sin dependencias de nuestro código. `Genero` y `Pelicula` la extienden, y la interfaz `IGuardable` declara que `rescatar` devuelve `EntidadIdentificable`, así que debe existir antes que las interfaces y las entidades. |
| **3** | `src/modelo/IGuardable.php` | Interfaz que usa `DBResult` y `EntidadIdentificable` en las firmas. Ya existen ambos. |
| **4** | `src/modelo/IListable.php` | Interfaz que usa `DBResult`. No depende de entidades concretas. |
| **5** | `src/modelo/Genero.php` | Solo extiende `EntidadIdentificable` y añade `$nombre`. No usa interfaces ni BD aún. |
| **6** | `src/modelo/Generos.php` | Implementa `IListable` y usa la clase `Genero` para construir el array que devuelve `listar`. Necesita que existan `IListable`, `Genero` y `DBResult`. |
| **7** | `src/modelo/Pelicula.php` | Extiende `EntidadIdentificable` e implementa `IGuardable`; tiene todos los atributos de la tabla `peliculas` y los métodos que tocan la BD. Necesita `EntidadIdentificable`, `IGuardable` y `DBResult`. |
| **8** | `src/modelo/Peliculas.php` | Implementa `IListable` y usa la clase `Pelicula` para construir el array de `listar`. Necesita `IListable`, `Pelicula` y `DBResult`. |

Resumen: primero lo que no depende de nadie (**DBResult**, **EntidadIdentificable**), luego las **interfaces** que solo dependen de eso, después las **entidades** que solo extienden la base (**Genero**, **Pelicula**), y por último las **clases “listado”** que implementan las interfaces y usan las entidades (**Generos**, **Peliculas**).

---

### 3.1 – Enumerado DBResult (`src/servicios/DBResult.php`)

**Crear primero.** No depende de otras clases del proyecto.

- **Namespace**: `AAMP04\servicios`.
- **Qué es**: un `enum` de PHP que representa el resultado de una operación con la base de datos cuando algo falla o no hay resultados. Así el controlador puede comprobar el valor devuelto sin depender de excepciones ni de números mágicos.
- **Valores** (y cuándo usarlos):
  - `DB_EXCEPTION` (-1): se lanzó una excepción en el try-catch (error de conexión, SQL, etc.).
  - `DB_OPNOTFULFILLED` (-2): la operación no se cumplió; por ejemplo, un UPDATE que no afectó ninguna fila (id inexistente).
  - `DB_NOCOLS_AFFECTED` (-3): opcional; ninguna fila afectada (INSERT/UPDATE/DELETE sin cambios).
  - `DB_EMPTYRESULT` (-4): una consulta SELECT no devolvió filas (no existe el registro, o la consulta está vacía).
- En los métodos del modelo que devuelven `DBResult|int` o `DBResult|array`, etc., en caso de error se retorna el valor de `DBResult` que mejor describa la situación.

---

### 3.2 – Clase abstracta EntidadIdentificable (`src/modelo/EntidadIdentificable.php`)

**Crear en segundo lugar.** Es la base de las entidades que tienen un identificador numérico (clave primaria).

- **Namespace**: `AAMP04\modelo`.
- **Qué es**: clase abstracta (no se instancia directamente; la extienden `Genero` y `Pelicula`). Centraliza el atributo `id` y su acceso.
- **Atributo**: `protected ?int $id = null` (nullable, por defecto null para entidades nuevas).
- **Métodos**:
  - `protected function getId(): ?int` — devuelve el id (protegido para que solo la propia clase y las hijas lo usen).
  - `public function setId(?int $id): void` — asigna el id (público para que, por ejemplo, tras un INSERT se pueda hacer `$entidad->setId((int) $pdo->lastInsertId())`).

---

### 3.3 – Interfaz IGuardable (`src/modelo/IGuardable.php`)

**Crear después de DBResult y EntidadIdentificable.** Define el “contrato” para entidades que se pueden guardar, rescatar por id y borrar.

- **Namespace**: `AAMP04\modelo`. Usar: `use AAMP04\servicios\DBResult;` y `use PDO;`.
- **Métodos** (las clases que la implementen deben tener estos exactamente):
  - `public function guardar(PDO $pdo): DBResult|int` — guarda la entidad (INSERT si es nueva, UPDATE si ya tiene id). Retorna el número de filas afectadas en éxito, o un valor `DBResult` en error.
  - `public static function rescatar(PDO $pdo, int $id): DBResult|EntidadIdentificable` — obtiene un registro por su id y devuelve una instancia de la clase rellena, o un valor `DBResult` si falla o no existe.
  - `public static function borrar(PDO $pdo, int $id): DBResult|int` — borra el registro con ese id. Retorna filas afectadas o `DBResult` en error.

---

### 3.4 – Interfaz IListable (`src/modelo/IListable.php`)

**Crear después de DBResult.** Define el contrato para “listados” (conjuntos de registros) y comprobación de existencia.

- **Namespace**: `AAMP04\modelo`. Usar: `use AAMP04\servicios\DBResult;` y `use PDO;`.
- **Métodos**:
  - `public static function listar(PDO $pdo): DBResult|array` — devuelve un array de **instancias** de la entidad correspondiente (p. ej. `Genero[]` o `Pelicula[]`), no un array asociativo crudo de filas. En error, devuelve un valor `DBResult`.
  - `public static function existe(PDO $pdo, int $id): DBResult|int` — comprueba si existe un registro con ese id. Retorna `1` si existe, `0` si no existe, o un valor `DBResult` si hay excepción.

---

### 3.5 – Clase Genero (`src/modelo/Genero.php`)

**Crear después de EntidadIdentificable.** Representa una fila de la tabla `generos`.

- **Namespace**: `AAMP04\modelo`.
- **Extiende**: `EntidadIdentificable` (hereda `$id`, `getId()`, `setId()`). No se declara de nuevo el atributo `id`.
- **Atributo propio**: `private ?string $nombre = null` (corresponde a la columna `nombre` de `generos`).
- **Métodos**: `getNombre(): ?string` y `setNombre(?string $nombre): void`. No lleva lógica de BD; esa va en la clase `Generos`.

---

### 3.6 – Clase Generos (`src/modelo/Generos.php`)

**Crear después de IListable y Genero.** Encapsula las operaciones sobre el conjunto de géneros (listar todos, comprobar si existe uno por id).

- **Namespace**: `AAMP04\modelo`. Usar: `use AAMP04\servicios\DBResult;`, `use PDO;`.
- **Implementa**: `IListable`.
- **listar(PDO $pdo)**:
  - Hacer un `SELECT id, nombre, descripcion FROM generos` (o al menos `id, nombre` si la clase `Genero` no tiene descripción). Usar `$pdo->query()` (sin parámetros) o, si se añade orden/filtro con parámetros, `prepare` + `execute`.
  - Dentro de un try-catch: recorrer las filas, crear una instancia de `Genero` por fila, asignar `setId` y `setNombre` (y descripción si existe), añadirla a un array y devolver ese array. Si hay excepción, devolver `DBResult::DB_EXCEPTION`. Si no hay filas, se puede devolver array vacío o `DBResult::DB_EMPTYRESULT` según se prefiera (el enunciado suele aceptar array vacío para listar).
- **existe(PDO $pdo, int $id)**:
  - Preparar `SELECT 1 FROM generos WHERE id = ?`, ejecutar con `[$id]`, comprobar si hay fila. Devolver `1` o `0`. En excepción, devolver `DBResult::DB_EXCEPTION`.

---

### 3.7 – Clase Pelicula (`src/modelo/Pelicula.php`)

**Crear después de EntidadIdentificable e IGuardable.** Representa una fila de la tabla `peliculas` y permite guardar, rescatar y borrar.

- **Namespace**: `AAMP04\modelo`. Usar: `use AAMP04\servicios\DBResult;`, `use PDO;`.
- **Extiende**: `EntidadIdentificable`. **Implementa**: `IGuardable`.
- **Atributos privados** (todos con valor por defecto `null`): `titulo`, `genero` (int, FK a generos.id), `direccion`, `duracion`, `argumento`, `anio`. Un getter y un setter por cada uno (p. ej. `getTitulo`, `setTitulo`). No declares de nuevo `id`.
- **guardar(PDO $pdo)**:
  - Si `$this->id === null`: es una película nueva. Hacer **INSERT** de `titulo, genero, direccion, duracion, argumento, anio` (consultas preparadas con `?`). Tras el `execute`, obtener el id autogenerado con `$pdo->lastInsertId()` y asignarlo con `$this->setId((int) ...)`. Devolver `$stmt->rowCount()` o, si es 0, `DBResult::DB_NOCOLS_AFFECTED`.
  - Si `$this->id !== null`: es una actualización. Hacer **UPDATE** de los mismos campos WHERE `id = ?`. No modificar el `id` de la entidad. Devolver filas afectadas o `DBResult::DB_OPNOTFULFILLED` si es 0.
  - En cualquier excepción: devolver `DBResult::DB_EXCEPTION`.
- **rescatar(PDO $pdo, int $id)** (estático):
  - Preparar `SELECT id, titulo, genero, direccion, duracion, argumento, anio FROM peliculas WHERE id = ?`, ejecutar, leer una fila. Si no hay fila, devolver `DBResult::DB_EMPTYRESULT`. Si hay fila, crear una instancia de `Pelicula`, asignar todos los atributos con los setters (incluido `setId`), devolver esa instancia. En excepción, devolver `DBResult::DB_EXCEPTION`.
- **borrar(PDO $pdo, int $id)** (estático):
  - Preparar `DELETE FROM peliculas WHERE id = ?`, ejecutar. Devolver `$stmt->rowCount()` o `DBResult::DB_EXCEPTION` en excepción.

---

### 3.8 – Clase Peliculas (`src/modelo/Peliculas.php`)

**Crear al final.** Encapsula las operaciones sobre el conjunto de películas (listar todas, comprobar si existe una por id).

- **Namespace**: `AAMP04\modelo`. Usar: `use AAMP04\servicios\DBResult;`, `use PDO;`.
- **Implementa**: `IListable`.
- **listar(PDO $pdo)**:
  - SELECT de todas las columnas necesarias de `peliculas`. En un try-catch, recorrer las filas, crear una instancia de `Pelicula` por fila, rellenarla con los setters, añadirla a un array y devolver ese array. En excepción, devolver `DBResult::DB_EXCEPTION`.
- **existe(PDO $pdo, int $id)**:
  - Igual que en `Generos`: `SELECT 1 FROM peliculas WHERE id = ?`, devolver 1, 0 o `DBResult::DB_EXCEPTION`.

---

### Checklist Ejercicio 02 (respetando el orden)

- [ ] 1. `src/servicios/DBResult.php` (enumerado).
- [ ] 2. `src/modelo/EntidadIdentificable.php` (clase abstracta).
- [ ] 3. `src/modelo/IGuardable.php` (interfaz).
- [ ] 4. `src/modelo/IListable.php` (interfaz).
- [ ] 5. `src/modelo/Genero.php` (entidad).
- [ ] 6. `src/modelo/Generos.php` (listado).
- [ ] 7. `src/modelo/Pelicula.php` (entidad con BD).
- [ ] 8. `src/modelo/Peliculas.php` (listado).
- [ ] En el Ejercicio 05 se añaden comentarios PHPDoc a las clases y métodos.

| [Anterior](#checklist-ejercicio-01-resumen) | [Índice](#índice) | — |
|-----------|-------|------------|

---

*(Los siguientes pasos — Ejercicio 03 controlador por defecto, vistas, etc. — se irán añadiendo aquí.)*
