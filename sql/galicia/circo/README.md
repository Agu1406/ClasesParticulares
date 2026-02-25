<!-- Etiquetas de estilo personales para el README. -->
<style>
    h1, h2, h3 {
        text-align: center;
        border: 5px solid grey;
        padding: 20px
    }

    h4 {
        text-align: center;
        font-size: 16px;
    }
    p {
        text-indent: 20px;
        text-align: justify;
    }

    table {
        border: 1px solid white;
        margin-left: auto;
        margin-right: auto;
        margin-bottom: 10%;
        margin-top: 10%;
    }
    th, td {
        border: 1px solid white;
        text-align: center;
    }
</style>

# Guía de Consultas SQL - Base de Datos Viviendas

Este material está diseñado para aprender SQL desde cero usando la base de datos de viviendas. Cada consulta está en un archivo separado con explicaciones detalladas.

**Alcance del material:** Esta guía se centra en **consultas (SELECT)**. La modificación de datos (INSERT, UPDATE, DELETE) se trata en otro bloque.

## Índice

* [**Estructura de la Base de Datos**](#estructura-de-la-base-de-datos)
    + 1. [**Tabla: personas**](#tabla-personas)
    + 2. [**Tabla: viviendas**](#tabla-viviendas)
    + 3. [**Tabla: zonas**](#tabla-zonas)
    + 4. [**Tabla: habitar**](#tabla-habitar)
* [**Diagrama Entidad-Relación**](#diagrama-entidad-relación)
    + 1. [**Explicación del Diagrama**](#explicación-del-diagrama)
    + 2. [**Símbolos del Diagrama**](#símbolos-del-diagrama)
* [**Conceptos Fundamentales de SQL**](#conceptos-fundamentales-de-sql)
    + 1. [**SELECT - Consultar Datos**](#select---consultar-datos)
    + 2. [**WHERE - Filtrar Resultados**](#where---filtrar-resultados)
    + 3. [**LIKE - Búsqueda de Patrones**](#like---búsqueda-de-patrones)
    + 4. [**ORDER BY - Ordenar Resultados**](#order-by---ordenar-resultados)
    + 5. [**DISTINCT - Eliminar Duplicados**](#distinct---eliminar-duplicados)
    + 6. [**NULL en las consultas**](#null-en-las-consultas)
* [**Tipos de JOIN**](#tipos-de-join---explicación-visual-con-diagramas-de-venn)
    + 1. [**Concepto base: dos círculos superpuestos**](#concepto-base-dos-círculos-superpuestos)
    + 2. [**INNER JOIN - Solo la intersección**](#inner-join---solo-la-intersección)
    + 3. [**LEFT JOIN - Todo el círculo izquierdo + intersección**](#left-join---todo-el-círculo-izquierdo--intersección)
    + 4. [**RIGHT JOIN - Todo el círculo derecho + intersección**](#right-join---todo-el-círculo-derecho--intersección)
    + 5. [**FULL OUTER JOIN - Ambos círculos completos**](#full-outer-join---ambos-círculos-completos)
    + 6. [**SELF JOIN - Un círculo consigo mismo**](#self-join---un-círculo-consigo-mismo)
    + 7. [**Comparación visual completa**](#comparación-visual-completa)
    + 8. [**Resumen rápido**](#resumen-rápido)
    + 9. [**Consejos para recordar**](#consejos-para-recordar)
    + 10. [**Comparación rápida: INNER vs LEFT JOIN**](#comparación-rápida-inner-vs-left-join)
* [**Funciones de Fecha**](#funciones-de-fecha)
    + 1. [**Funciones Básicas**](#funciones-básicas)
    + 2. [**Extraer Partes de una Fecha**](#extraer-partes-de-una-fecha)
    + 3. [**Calcular Diferencias de Tiempo**](#calcular-diferencias-de-tiempo)
    + 4. [**Formatear Fechas**](#formatear-fechas)
* [**Funciones de Agregación**](#funciones-de-agregación)
    + 1. [**COUNT() - Contar**](#count---contar)
    + 2. [**SUM() - Sumar**](#sum---sumar)
    + 3. [**AVG() - Promedio**](#avg---promedio)
    + 4. [**MAX() / MIN() - Máximo / Mínimo**](#max--min---máximo--mínimo)
    + 5. [**GROUP BY - Agrupar Resultados**](#group-by---agrupar-resultados)
    + 6. [**HAVING - Filtrar grupos**](#having---filtrar-grupos)
* [**Orden de Ejecución de las Consultas**](#orden-de-ejecución-de-las-consultas)
* [**Glosario de Términos**](#glosario-de-términos)
    + 1. [**Base de Datos (Database)**](#base-de-datos-database)
    + 2. [**Tabla (Table)**](#tabla-table)
    + 3. [**Registro / Fila (Row / Record)**](#registro--fila-row--record)
    + 4. [**Campo / Columna (Field / Column)**](#campo--columna-field--column)
    + 5. [**Clave Primaria (Primary Key - PK)**](#clave-primaria-primary-key---pk)
    + 6. [**Clave Foránea (Foreign Key - FK)**](#clave-foránea-foreign-key---fk)
    + 7. [**Relación**](#relación)
    + 8. [**JOIN**](#join)
    + 9. [**Alias**](#alias)
    + 10. [**NULL**](#null)
    + 11. [**Consulta (Query)**](#consulta-query)
    + 12. [**SGBD / SGBDR**](#sgbd--sgbdr)
* [**Consejos para Aprender**](#consejos-para-aprender)
* [**Archivos de Consultas**](#archivos-de-consultas)
* [**Cómo Usar Este Material**](#cómo-usar-este-material)
    + 1. [**Ruta de lectura sugerida**](#ruta-de-lectura-sugerida)
    + 2. [**Ejecutar el script de la base de datos**](#ejecutar-el-script-de-la-base-de-datos)
    + 3. [**Pasos generales**](#pasos-generales)

| [Anterior](#guía-de-consultas-sql---base-de-datos-viviendas) | [Índice](#índice) | [Siguiente](#estructura-de-la-base-de-datos) |
|---|---|---|

---

## Estructura de la Base de Datos

La base de datos `viviendas` está compuesta por 4 tablas principales:

### Tabla: `personas`

Almacena información de las personas registradas.

| Columna | Tipo | Descripción |
|---------|------|-------------|
| `dni` | CHAR(10) | **Clave Primaria** - Identificador único de la persona |
| `nombre` | CHAR(20) | Nombre de la persona |
| `apellidos` | CHAR(20) | Apellidos de la persona |
| `dni_padre` | CHAR(10) | **Clave Foránea** - DNI del padre (puede ser NULL) |

**Relaciones:**
- `dni_padre` referencia a `personas.dni` (relación consigo misma - auto-referencia)

### Tabla: `viviendas`

Almacena información de las viviendas.

| Columna | Tipo | Descripción |
|---------|------|-------------|
| `cod_vivienda` | CHAR(10) | **Clave Primaria** - Código único de la vivienda |
| `calle` | CHAR(20) | Nombre de la calle |
| `numero` | CHAR(10) | Número de la dirección |
| `piso` | CHAR(10) | Piso de la vivienda |
| `puerta` | CHAR(10) | Puerta/letra de la vivienda |
| `metros` | DOUBLE | Metros cuadrados de la vivienda |
| `fecha_construccion` | DATETIME(6) | Fecha de construcción |
| `nombre_zona` | CHAR(20) | **Clave Foránea** - Nombre de la zona |

**Relaciones:**
- `nombre_zona` referencia a `zonas.nombre_zona`

### Tabla: `zonas`

Almacena información de las zonas geográficas.

| Columna | Tipo | Descripción |
|---------|------|-------------|
| `nombre_zona` | CHAR(20) | **Clave Primaria** - Nombre único de la zona |
| `descripcion` | CHAR(30) | Descripción de la zona |

### Tabla: `habitar`

Tabla de relación que conecta personas con viviendas (tabla intermedia).

| Columna | Tipo | Descripción |
|---------|------|-------------|
| `dni` | CHAR(10) | **Clave Foránea** - DNI de la persona |
| `cod_vivienda` | CHAR(10) | **Clave Foránea** - Código de la vivienda |
| `fecha_inicio` | DATETIME(6) | Fecha en que la persona comenzó a habitar |

**Relaciones:**
- `dni` referencia a `personas.dni`
- `cod_vivienda` referencia a `viviendas.cod_vivienda`
- **Clave Primaria Compuesta:** (`dni`, `cod_vivienda`)

| [Anterior](#índice) | [Índice](#índice) | [Siguiente](#diagrama-entidad-relación) |
|---|---|---|

---

## Diagrama Entidad-Relación

```
┌─────────────────────────────────────────────────────────────────┐
│                    BASE DE DATOS: VIVIENDAS                     │
└─────────────────────────────────────────────────────────────────┘

┌──────────────┐
│   PERSONAS   │
├──────────────┤
│ PK dni       │◄─────┐
│ nombre       │      │
│ apellidos    │      │
│ FK dni_padre │──────┘ (auto-referencia)
└──────┬───────┘
       │
       │ 1
       │
       │ N
       │
┌──────▼──────────┐
│     HABITAR     │
├─────────────────┤
│ PK,FK dni       │
│ PK,FK           │
│   cod_vivienda  │
│ fecha_inicio    │
└──────┬──────────┘
       │
       │ N
       │
       │ 1
       │
┌──────▼──────────┐         ┌──────────────┐
│   VIVIENDAS     │         │    ZONAS     │
├─────────────────┤         ├──────────────┤
│ PK cod_vivienda │         │ PK nombre_   │
│ calle           │         │    zona      │
│ numero          │         │ descripcion  │
│ piso            │         └──────▲───────┘
│ puerta          │                │
│ metros          │                │
│ fecha_          │                │
│   construccion  │                │
│ FK nombre_zona  │────────────────┘
└─────────────────┘
```

### Explicación del Diagrama
1. **Relación Personas-Habitar-Viviendas:**
   - Una persona puede habitar múltiples viviendas (relación N:M)
   - Una vivienda puede ser habitada por múltiples personas (relación N:M)
   - La tabla `habitar` es una **tabla intermedia** que resuelve esta relación muchos-a-muchos

2. **Relación Viviendas-Zonas:**
   - Una vivienda pertenece a una zona (relación N:1)
   - Una zona puede tener múltiples viviendas (relación 1:N)

3. **Auto-referencia en Personas:**
   - Una persona puede tener un padre registrado (relación 1:N)
   - Una persona puede ser padre de múltiples personas (relación 1:N)

### Símbolos del Diagrama- **PK**: Clave Primaria (Primary Key)
- **FK**: Clave Foránea (Foreign Key)
- **1**: Uno
- **N**: Muchos
- **─**: Relación
- **◄─**: Dirección de la relación

| [Anterior](#estructura-de-la-base-de-datos) | [Índice](#índice) | [Siguiente](#conceptos-fundamentales-de-sql) |
|---|---|---|

---

## Conceptos Fundamentales de SQL

### SELECT - Consultar Datos
La sentencia `SELECT` se usa para consultar datos de una o más tablas.

```sql
SELECT columna1, columna2
FROM tabla
WHERE condicion;
```

**Ejemplo:**
```sql
SELECT nombre, apellidos
FROM personas
WHERE nombre = 'Juan';
```

### WHERE - Filtrar Resultados
`WHERE` se usa para filtrar filas que cumplen una condición específica.

**Operadores de comparación:**
- `=` : Igual a
- `<>` o `!=` : Diferente de
- `<` : Menor que
- `>` : Mayor que
- `<=` : Menor o igual que
- `>=` : Mayor o igual que

**Operadores lógicos:**
- `AND` : Ambas condiciones deben cumplirse
- `OR` : Al menos una condición debe cumplirse
- `NOT` : Niega una condición

**Ejemplos:**
```sql
-- Múltiples condiciones con AND
SELECT * FROM viviendas
WHERE nombre_zona = 'Centro' AND metros > 80;

-- Rango de valores con BETWEEN
SELECT * FROM viviendas
WHERE metros BETWEEN 70 AND 90;

-- Múltiples valores con IN
SELECT * FROM viviendas
WHERE nombre_zona IN ('Centro', 'Sector Norte');
```

### LIKE - Búsqueda de Patrones
`LIKE` se usa para buscar patrones en texto usando comodines.

**Comodines:**
- `%` : Cualquier secuencia de caracteres (0 o más)
- `_` : Un solo carácter

**Ejemplos:**
```sql
-- Apellidos que comienzan con 'L'
SELECT * FROM personas WHERE apellidos LIKE 'L%';

-- Nombres que terminan con 'o'
SELECT * FROM personas WHERE nombre LIKE '%o';

-- Apellidos que contienen 'ez'
SELECT * FROM personas WHERE apellidos LIKE '%ez%';
```

### ORDER BY - Ordenar Resultados
`ORDER BY` ordena los resultados de una consulta.

- `ASC` : Orden ascendente (predeterminado)
- `DESC` : Orden descendente

**Ejemplos:**
```sql
-- Ordenar por apellidos (A-Z)
SELECT * FROM personas ORDER BY apellidos ASC;

-- Ordenar por metros (de mayor a menor)
SELECT * FROM viviendas ORDER BY metros DESC;

-- Ordenar por múltiples columnas
SELECT * FROM viviendas
ORDER BY nombre_zona ASC, metros DESC;
```

### DISTINCT - Eliminar Duplicados
`DISTINCT` elimina filas duplicadas del resultado.

```sql
SELECT DISTINCT nombre_zona FROM viviendas;
```

### NULL en las consultas
En SQL, `NULL` significa "valor desconocido o ausente". No es lo mismo que cero ni que una cadena vacía. Para filtrar por NULL debes usar `IS NULL` o `IS NOT NULL` (no se usa `= NULL`).

**Ejemplos:**
```sql
-- Personas que NO tienen padre registrado (dni_padre es NULL)
SELECT nombre, apellidos FROM personas WHERE dni_padre IS NULL;

-- Personas que SÍ tienen padre registrado
SELECT nombre, apellidos FROM personas WHERE dni_padre IS NOT NULL;
```

**Regla:** En condiciones, `columna = NULL` no funciona; siempre usa `columna IS NULL` o `columna IS NOT NULL`.

| [Anterior](#diagrama-entidad-relación) | [Índice](#índice) | [Siguiente](#tipos-de-join---explicación-visual-con-diagramas-de-venn) |
|---|---|---|

---

## Tipos de JOIN - Explicación Visual con Diagramas de Venn

Los JOINs permiten combinar datos de múltiples tablas relacionadas. La mejor forma de entenderlos es visualizándolos como **círculos superpuestos** (diagramas de Venn).

### Concepto base: dos círculos superpuestos
Imagina que tienes dos tablas representadas como dos círculos:

```
        Tabla A              Tabla B
      ╭───────╮           ╭───────╮
     ╱         ╲         ╱         ╲
    │     A     │       │     B     │
     ╲         ╱         ╲         ╱
      ╰───────╯           ╰───────╯
```

Cuando las tablas tienen datos relacionados, los círculos se superponen:

```
      ╭───────╮     ╭───────╮
     ╱    A    ╲   ╱    B    ╲
    │           │ │           │
    │    ╔═══╗  │ │  ╔═══╗    │
    │    ║ ∩ ║  │ │  ║ ∩ ║    │  ← Intersección
    │    ╚═══╝  │ │  ╚═══╝    │
     ╲         ╱   ╲         ╱
      ╰───────╯     ╰───────╯
```

**La zona de intersección** (donde se solapan los círculos) contiene los datos que están relacionados entre ambas tablas (donde hay coincidencias).

---

### INNER JOIN - Solo la intersección
**¿Qué hace?** Devuelve **SOLO** las filas donde hay coincidencia en ambas tablas.

**Diagrama de Venn:**
```
      ╭───────╮     ╭───────╮
     ╱    A    ╲   ╱    B    ╲
    │           │ │           │
    │    ╔═══════╗═══════╗    │
    │    ║ INNER ║ JOIN  ║    │  ← SOLO ESTA ZONA
    │    ║ (solo ║       ║    │     (intersección)
    │    ╚═══════╝═══════╝    │
     ╲         ╱   ╲         ╱
      ╰───────╯     ╰───────╯
         ▲              ▲
         └──────────────┘
      Excluido      Excluido
```

**Explicación:**
- Solo se incluyen los datos que están en **ambas tablas** (la intersección)
- Los datos que solo están en A o solo en B se **excluyen**

**Ejemplo con datos reales:**

**Tabla `personas` (izquierda):**
| dni | nombre | apellidos |
|-----|--------|-----------|
| 33456123A | Rodrigo | Perez F |
| 33456789C | Marcos | Rodriguez B |
| 34561232D | Carlos | Duran |
| 50123456X | Juan | Gil |

**Tabla `habitar` (derecha):**
| dni | cod_vivienda | fecha_inicio |
|-----|--------------|--------------|
| 33456789C | 10003 | 1987-10-30 |
| 34561232D | 30000 | 1990-12-12 |
| 50123456X | 10003 | 2000-12-12 |
| 50123456X | 10004 | 1987-10-30 |

**Consulta:**
```sql
SELECT p.nombre, p.apellidos, h.cod_vivienda, h.fecha_inicio
FROM personas p
INNER JOIN habitar h ON p.dni = h.dni;
```

**Resultado del INNER JOIN:**
| nombre | apellidos | cod_vivienda | fecha_inicio |
|--------|-----------|--------------|--------------|
| Marcos | Rodriguez B | 10003 | 1987-10-30 |
| Carlos | Duran | 30000 | 1990-12-12 |
| Juan | Gil | 10003 | 2000-12-12 |
| Juan | Gil | 10004 | 1987-10-30 |

**Observaciones:**
- ✅ **Incluye:** Marcos, Carlos y Juan (tienen coincidencias en ambas tablas)
- ❌ **Excluye:** Rodrigo (no tiene registro en `habitar`)
- ⚠️ **Nota:** Juan aparece 2 veces porque habita 2 viviendas diferentes

**Cuándo usar:** Cuando solo necesitas datos que existen en ambas tablas.

---

### LEFT JOIN - Todo el círculo izquierdo + intersección
**¿Qué hace?** Devuelve **TODAS** las filas de la tabla izquierda (A) y las coincidencias de la tabla derecha (B). Si no hay coincidencia, las columnas de B serán NULL.

**Diagrama de Venn:**
```
      ╭═══════════════╮     ╭───────╮
     ╱   LEFT JOIN    ╲   ╱    B    ╲
    │   (A completo)   │ │           │
    │                  │ │           │
    │    ╔═════════════╗═══════╗    │
    │    ║ Intersección║       ║    │
    │    ╚═════════════╝═══════╝    │
     ╲                  ╱   ╲         ╱
      ╰═══════════════╯     ╰───────╯
         ▲              ▲
         │              └── Excluido
         └── Incluido
```

**Explicación:**
- Se incluyen **TODOS** los datos de la tabla A (izquierda)
- También se incluyen los datos relacionados (intersección)
- Los datos que solo están en B se **excluyen**
- Si un dato de A no tiene coincidencia en B, las columnas de B serán NULL

**Ejemplo con datos reales:**

**Tabla `personas` (izquierda):**
| dni | nombre | apellidos |
|-----|--------|-----------|
| 33456123A | Rodrigo | Perez F |
| 33456789C | Marcos | Rodriguez B |
| 34561232D | Carlos | Duran |
| 50123456X | Juan | Gil |

**Tabla `habitar` (derecha):**
| dni | cod_vivienda | fecha_inicio |
|-----|--------------|--------------|
| 33456789C | 10003 | 1987-10-30 |
| 34561232D | 30000 | 1990-12-12 |
| 50123456X | 10003 | 2000-12-12 |
| 50123456X | 10004 | 1987-10-30 |

**Consulta:**
```sql
SELECT p.nombre, p.apellidos, h.cod_vivienda, h.fecha_inicio
FROM personas p
LEFT JOIN habitar h ON p.dni = h.dni;
```

**Resultado del LEFT JOIN:**
| nombre | apellidos | cod_vivienda | fecha_inicio |
|--------|-----------|--------------|--------------|
| Rodrigo | Perez F | **NULL** | **NULL** |
| Marcos | Rodriguez B | 10003 | 1987-10-30 |
| Carlos | Duran | 30000 | 1990-12-12 |
| Juan | Gil | 10003 | 2000-12-12 |
| Juan | Gil | 10004 | 1987-10-30 |

**Observaciones:**
- ✅ **Incluye:** TODAS las personas de la tabla izquierda
- ✅ **Incluye:** Rodrigo aparece aunque no tenga vivienda (valores NULL)
- ✅ **Incluye:** Marcos, Carlos y Juan con sus datos de vivienda
- ⚠️ **Nota:** Juan aparece 2 veces porque habita 2 viviendas

**Cuándo usar:** Cuando necesitas todos los registros de la tabla izquierda, incluso si no tienen coincidencias.

---

### RIGHT JOIN - Todo el círculo derecho + intersección
**¿Qué hace?** Devuelve **TODAS** las filas de la tabla derecha (B) y las coincidencias de la tabla izquierda (A). Si no hay coincidencia, las columnas de A serán NULL.

**Diagrama de Venn:**
```
      ╭───────╮     ╭═══════════════╮
     ╱    A    ╲   ╱   RIGHT JOIN   ╲
    │           │ │   (B completo)   │
    │           │ │                  │
    │    ╔═══════╗═══════════════════╗
    │    ║       ║ Intersección      ║
    │    ╚═══════╝═══════════════════╝
     ╲         ╱   ╲                  ╱
      ╰───────╯     ╰═══════════════╯
         ▲              ▲
         └── Excluido   └── Incluido
```

**Explicación:**
- Se incluyen **TODOS** los datos de la tabla B (derecha)
- También se incluyen los datos relacionados (intersección)
- Los datos que solo están en A se **excluyen**
- Si un dato de B no tiene coincidencia en A, las columnas de A serán NULL

**Ejemplo con datos reales:**

**Tabla `viviendas` (izquierda):**
| cod_vivienda | calle | nombre_zona |
|--------------|-------|-------------|
| 10000 | Cernadas | Sector Sur |
| 20000 | Barcelona | Sector Norte |
| 30000 | Juan Florez | Centro |
| 40000 | Juan Florez | Centro |

**Tabla `zonas` (derecha):**
| nombre_zona | descripcion |
|-------------|-------------|
| Centro | Zona central |
| Sector Norte | Al norte de la ciudad |
| Sector Sur | Al sur |
| Sector Este | Al este |
| Sector Oeste | Al west |

**Consulta:**
```sql
SELECT z.nombre_zona, z.descripcion, v.cod_vivienda, v.calle
FROM viviendas v
RIGHT JOIN zonas z ON v.nombre_zona = z.nombre_zona;
```

**Resultado del RIGHT JOIN:**
| nombre_zona | descripcion | cod_vivienda | calle |
|-------------|-------------|--------------|-------|
| Centro | Zona central | 30000 | Juan Florez |
| Centro | Zona central | 40000 | Juan Florez |
| Sector Norte | Al norte de la ciudad | 20000 | Barcelona |
| Sector Sur | Al sur | 10000 | Cernadas |
| Sector Este | Al este | **NULL** | **NULL** |
| Sector Oeste | Al west | **NULL** | **NULL** |

**Observaciones:**
- ✅ **Incluye:** TODAS las zonas de la tabla derecha
- ✅ **Incluye:** Sector Este y Sector Oeste aparecen aunque no tengan viviendas (valores NULL)
- ✅ **Incluye:** Centro aparece 2 veces porque tiene 2 viviendas
- ❌ **Excluye:** Solo se muestran viviendas que coinciden con zonas

**Nota importante:** RIGHT JOIN es menos común. Muchos desarrolladores prefieren usar LEFT JOIN cambiando el orden de las tablas:

```sql
-- Equivalente con LEFT JOIN (más común)
SELECT z.nombre_zona, z.descripcion, v.cod_vivienda, v.calle
FROM zonas z
LEFT JOIN viviendas v ON z.nombre_zona = v.nombre_zona;
```

---

### FULL OUTER JOIN - Ambos círculos completos
**¿Qué hace?** Devuelve **TODAS** las filas de ambas tablas. Si no hay coincidencia, las columnas de la otra tabla serán NULL.

**Diagrama de Venn:**
```
      ╭═══════════════╮     ╭═══════════════╮
     ╱ FULL OUTER JOIN ╲   ╱ FULL OUTER JOIN ╲
    │   (A completo)     │ │   (B completo)     │
    │                    │ │                    │
    │    ╔═══════════════╗═══════════════╗    │
    │    ║ Intersección  ║               ║    │
    │    ╚═══════════════╝═══════════════╝    │
     ╲                    ╱   ╲                    ╱
      ╰═══════════════╯     ╰═══════════════╯
         ▲                      ▲
         └── Incluido           └── Incluido
```

**Explicación:**
- Se incluyen **TODOS** los datos de ambas tablas
- Si un dato de A no tiene coincidencia en B, las columnas de B serán NULL
- Si un dato de B no tiene coincidencia en A, las columnas de A serán NULL

**Ejemplo con datos reales:**

**Tabla `personas` (izquierda):**
| dni | nombre | apellidos |
|-----|--------|-----------|
| 33456123A | Rodrigo | Perez F |
| 33456789C | Marcos | Rodriguez B |
| 34561232D | Carlos | Duran |
| 50123456X | Juan | Gil |

**Tabla `habitar` (derecha):**
| dni | cod_vivienda | fecha_inicio |
|-----|--------------|--------------|
| 33456789C | 10003 | 1987-10-30 |
| 34561232D | 30000 | 1990-12-12 |
| 50123456X | 10003 | 2000-12-12 |
| 50123456Z | 40000 | 1985-12-11 |

**Nota:** MySQL **NO soporta** FULL OUTER JOIN directamente. Se puede simular con UNION:

**Consulta (simulación en MySQL):**
```sql
SELECT p.nombre, p.apellidos, h.cod_vivienda, h.fecha_inicio
FROM personas p
LEFT JOIN habitar h ON p.dni = h.dni
UNION
SELECT p.nombre, p.apellidos, h.cod_vivienda, h.fecha_inicio
FROM personas p
RIGHT JOIN habitar h ON p.dni = h.dni;
```

**Resultado del FULL OUTER JOIN (simulado):**
| nombre | apellidos | cod_vivienda | fecha_inicio |
|--------|-----------|--------------|--------------|
| Rodrigo | Perez F | **NULL** | **NULL** |
| Marcos | Rodriguez B | 10003 | 1987-10-30 |
| Carlos | Duran | 30000 | 1990-12-12 |
| Juan | Gil | 10003 | 2000-12-12 |
| **NULL** | **NULL** | 40000 | 1985-12-11 |

**Observaciones:**
- ✅ **Incluye:** TODAS las personas (incluso sin vivienda)
- ✅ **Incluye:** TODOS los registros de habitar (incluso sin persona)
- ✅ **Incluye:** La persona con DNI 50123456Z aparece aunque no esté en la tabla `personas` (valores NULL)
- ⚠️ **Nota:** En este caso, el último registro muestra una vivienda habitada por alguien que no está en la tabla `personas` (posible inconsistencia de datos)

---

### SELF JOIN - Un círculo consigo mismo
**¿Qué hace?** Una tabla se une consigo misma. Se usa para comparar filas dentro de la misma tabla.

**Diagrama conceptual:**
```
        Tabla Personas
    ┌───────────────────┐
    │                   │
    │   Personas (hijo)  │
    │                   │
    └───────────────────┘
              │
              │ (dni_padre referencia)
              ▼
    ┌───────────────────┐
    │                   │
    │  Personas (padre) │
    │                   │
    └───────────────────┘
```

**Ejemplo con datos reales:**

**Tabla `personas` (vista como "hijo"):**
| dni | nombre | apellidos | dni_padre |
|-----|--------|-----------|-----------|
| 33456123A | Rodrigo | Perez F | NULL |
| 33456789C | Marcos | Rodriguez B | NULL |
| 34561232D | Carlos | Duran | 33456123A |
| 50123456X | Juan | Gil | 33456123A |
| 50123456Z | Mario | Lopez B | 33456789C |
| 50123457A | Elena | Hernandez | 50123456Z |

**Tabla `personas` (vista como "padre" - misma tabla):**
| dni | nombre | apellidos |
|-----|--------|-----------|
| 33456123A | Rodrigo | Perez F |
| 33456789C | Marcos | Rodriguez B |
| 50123456Z | Mario | Lopez B |

**Consulta:**
```sql
SELECT hijo.nombre AS nombre_hijo,
       hijo.apellidos AS apellidos_hijo,
       padre.nombre AS nombre_padre,
       padre.apellidos AS apellidos_padre
FROM personas hijo
LEFT JOIN personas padre ON hijo.dni_padre = padre.dni;
```

**Resultado del SELF JOIN:**
| nombre_hijo | apellidos_hijo | nombre_padre | apellidos_padre |
|-------------|----------------|--------------|-----------------|
| Rodrigo | Perez F | **NULL** | **NULL** |
| Marcos | Rodriguez B | **NULL** | **NULL** |
| Carlos | Duran | Rodrigo | Perez F |
| Juan | Gil | Rodrigo | Perez F |
| Mario | Lopez B | Marcos | Rodriguez B |
| Elena | Hernandez | Mario | Lopez B |

**Observaciones:**
- ✅ **Incluye:** Todas las personas (hijos)
- ✅ **Incluye:** Relaciones padre-hijo cuando existen
- ✅ **Incluye:** NULL para personas sin padre registrado (Rodrigo y Marcos)
- 🔗 **Relación:** Carlos y Juan son hijos de Rodrigo; Mario es hijo de Marcos; Elena es hija de Mario

**Cuándo usar:** Para relaciones jerárquicas dentro de la misma tabla (padres-hijos, empleados-jefes, etc.).

---

### Comparación visual completa
```
INNER JOIN:                    LEFT JOIN:                    RIGHT JOIN:
  ╭───────╮     ╭───────╮      ╭═══════════╮     ╭───────╮      ╭───────╮     ╭═══════════╮
 ╱    A    ╲   ╱    B    ╲    ╱  LEFT JOIN ╲   ╱    B    ╲    ╱    A    ╲   ╱ RIGHT JOIN ╲
│           │ │           │   │  (A completo)│ │           │   │           │ │ (B completo)│
│    ╔═══╗  │ │  ╔═══╗    │   │              │ │           │   │           │ │             │
│    ║ ✓ ║  │ │  ║ ✓ ║    │   │    ╔═════════╗═══════╗    │   │    ╔═══════╗═════════════╗
│    ╚═══╝  │ │  ╚═══╝    │   │    ║    ✓    ║   ✓   ║    │   │    ║   ✓   ║      ✓      ║
│           │ │           │   │    ╚═════════╝═══════╝    │   │    ╚═══════╝═════════════╝
 ╲         ╱   ╲         ╱     ╲              ╱   ╲         ╱     ╲         ╱   ╲             ╱
  ╰───────╯     ╰───────╯       ╰═══════════╯     ╰───────╯       ╰───────╯     ╰═══════════╯
     ✗              ✗                ✓              ✗                ✗              ✓

Solo intersección          A completo +              B completo +
                           intersección             intersección
```

**Leyenda:**
- ✓ = Incluido en el resultado (área sombreada)
- ✗ = Excluido del resultado (área no sombreada)

---

### Resumen rápido
| Tipo de JOIN | ¿Qué incluye? | Diagrama de Venn |
|--------------|---------------|-------------------|
| **INNER JOIN** | Solo la intersección (datos en ambas tablas) | Solo el área superpuesta |
| **LEFT JOIN** | Todo el círculo izquierdo + intersección | Círculo izquierdo completo |
| **RIGHT JOIN** | Todo el círculo derecho + intersección | Círculo derecho completo |
| **FULL OUTER JOIN** | Ambos círculos completos | Ambos círculos completos |

---

### Consejos para recordar
1. **INNER JOIN = "Solo lo que coincide"**
   - Como una intersección de carreteras: solo donde se cruzan

2. **LEFT JOIN = "Todo lo de la izquierda"**
   - Piensa: "Quiero ver TODAS las personas, aunque no tengan vivienda"

3. **RIGHT JOIN = "Todo lo de la derecha"**
   - Piensa: "Quiero ver TODAS las zonas, aunque no tengan viviendas"

4. **La tabla "izquierda" es la que aparece después de FROM**
   ```sql
   FROM tabla_izquierda
   LEFT JOIN tabla_derecha
   ```

---

### Comparación rápida: INNER vs LEFT JOIN
**Tabla `personas` (izquierda):**
| dni | nombre | apellidos |
|-----|--------|-----------|
| 33456123A | Rodrigo | Perez F |
| 33456789C | Marcos | Rodriguez B |
| 34561232D | Carlos | Duran |
| 50123456X | Juan | Gil |

**Tabla `habitar` (derecha):**
| dni | cod_vivienda | fecha_inicio |
|-----|--------------|--------------|
| 33456789C | 10003 | 1987-10-30 |
| 34561232D | 30000 | 1990-12-12 |
| 50123456X | 10003 | 2000-12-12 |

**INNER JOIN:**
```sql
SELECT p.nombre, p.apellidos, h.cod_vivienda
FROM personas p
INNER JOIN habitar h ON p.dni = h.dni;
```
**Resultado:**
| nombre | apellidos | cod_vivienda |
|--------|-----------|--------------|
| Marcos | Rodriguez B | 10003 |
| Carlos | Duran | 30000 |
| Juan | Gil | 10003 |

**LEFT JOIN:**
```sql
SELECT p.nombre, p.apellidos, h.cod_vivienda
FROM personas p
LEFT JOIN habitar h ON p.dni = h.dni;
```
**Resultado:**
| nombre | apellidos | cod_vivienda |
|--------|-----------|--------------|
| Rodrigo | Perez F | **NULL** |
| Marcos | Rodriguez B | 10003 |
| Carlos | Duran | 30000 |
| Juan | Gil | 10003 |

**Diferencia clave:** LEFT JOIN incluye a Rodrigo (sin vivienda), INNER JOIN lo excluye.

| [Anterior](#tipos-de-join---explicación-visual-con-diagramas-de-venn) | [Índice](#índice) | [Siguiente](#funciones-de-fecha) |
|---|---|---|

---

## Funciones de Fecha

MySQL proporciona varias funciones para trabajar con fechas.

### Funciones Básicas
**CURDATE()** - Fecha actual
```sql
SELECT CURDATE();  -- Devuelve: 2024-01-15
```

**NOW()** - Fecha y hora actual
```sql
SELECT NOW();  -- Devuelve: 2024-01-15 14:30:00
```

### Extraer Partes de una Fecha
**YEAR(fecha)** - Extrae el año
```sql
SELECT YEAR('1987-10-30');  -- Devuelve: 1987
```

**MONTH(fecha)** - Extrae el mes (1-12)
```sql
SELECT MONTH('1987-10-30');  -- Devuelve: 10
```

**DAY(fecha)** - Extrae el día (1-31)
```sql
SELECT DAY('1987-10-30');  -- Devuelve: 30
```

**Ejemplo práctico:**
```sql
SELECT nombre, fecha_inicio,
       YEAR(fecha_inicio) AS año,
       MONTH(fecha_inicio) AS mes,
       DAY(fecha_inicio) AS dia
FROM habitar;
```

### Calcular Diferencias de Tiempo
**DATEDIFF(fecha1, fecha2)** - Diferencia en días
```sql
SELECT DATEDIFF(CURDATE(), '1987-10-30') AS dias_transcurridos;
-- Devuelve el número de días entre las dos fechas
```

**TIMESTAMPDIFF(unit, fecha1, fecha2)** - Diferencia en la unidad especificada
```sql
-- Diferencia en años
SELECT TIMESTAMPDIFF(YEAR, '1987-10-30', CURDATE()) AS años;

-- Diferencia en meses
SELECT TIMESTAMPDIFF(MONTH, '1987-10-30', CURDATE()) AS meses;

-- Diferencia en días
SELECT TIMESTAMPDIFF(DAY, '1987-10-30', CURDATE()) AS dias;
```

**Unidades disponibles:** YEAR, MONTH, DAY, HOUR, MINUTE, SECOND

**Ejemplo práctico:**
```sql
SELECT nombre, apellidos,
       DATEDIFF(CURDATE(), fecha_inicio) AS dias_habitando
FROM personas p
INNER JOIN habitar h ON p.dni = h.dni;
```

### Formatear Fechas
**DATE_FORMAT(fecha, formato)** - Formatea una fecha
```sql
SELECT DATE_FORMAT('1987-10-30', '%d/%m/%Y');  -- Devuelve: 30/10/1987
SELECT DATE_FORMAT('1987-10-30', '%Y-%m-%d');  -- Devuelve: 1987-10-30
```

**Formatos comunes:**
- `%Y` : Año con 4 dígitos
- `%y` : Año con 2 dígitos
- `%m` : Mes (01-12)
- `%d` : Día (01-31)
- `%M` : Nombre del mes (January-December)
- `%W` : Nombre del día de la semana

| [Anterior](#funciones-de-fecha) | [Índice](#índice) | [Siguiente](#funciones-de-agregación) |
|---|---|---|

---

## Funciones de Agregación

Las funciones de agregación realizan cálculos sobre un conjunto de filas.

### COUNT() - Contar
```sql
-- Contar todas las filas
SELECT COUNT(*) FROM personas;

-- Contar filas donde una columna no es NULL
SELECT COUNT(nombre) FROM personas;

-- Contar valores únicos
SELECT COUNT(DISTINCT nombre_zona) FROM viviendas;
```

### SUM() - Sumar
```sql
SELECT SUM(metros) AS total_metros FROM viviendas;
```

### AVG() - Promedio
```sql
SELECT AVG(metros) AS promedio_metros FROM viviendas;
```

### MAX() / MIN() - Máximo / Mínimo
```sql
SELECT MAX(metros) AS metros_maximos FROM viviendas;
SELECT MIN(metros) AS metros_minimos FROM viviendas;
```

### GROUP BY - Agrupar Resultados
`GROUP BY` agrupa filas que tienen los mismos valores en columnas especificadas.

```sql
SELECT nombre_zona, COUNT(*) AS total_viviendas
FROM viviendas
GROUP BY nombre_zona;
```

**Ejemplo:**
```sql
-- Promedio de metros por zona
SELECT nombre_zona, AVG(metros) AS promedio_metros
FROM viviendas
GROUP BY nombre_zona;
```

### HAVING - Filtrar grupos
`HAVING` filtra **grupos** después de que se aplica `GROUP BY`. Se diferencia de `WHERE`, que filtra **filas** antes de agrupar. Por tanto: `WHERE` no puede usar funciones de agregación; `HAVING` sí.

**Ejemplo:** Zonas que tienen más de 1 vivienda.
```sql
SELECT nombre_zona, COUNT(*) AS total_viviendas
FROM viviendas
GROUP BY nombre_zona
HAVING COUNT(*) > 1;
```

**Regla práctica:** Usa `WHERE` para filtrar filas; usa `HAVING` para filtrar resultados de agregación (por ejemplo "solo grupos con COUNT > 1").

| [Anterior](#funciones-de-agregación) | [Índice](#índice) | [Siguiente](#orden-de-ejecución-de-las-consultas) |
|---|---|---|

---

## Orden de Ejecución de las Consultas

Cuando MySQL ejecuta una consulta, sigue este orden:

1. **FROM** - Identifica las tablas
2. **JOIN** - Combina las tablas
3. **WHERE** - Filtra las filas
4. **GROUP BY** - Agrupa las filas
5. **HAVING** - Filtra los grupos (ver [HAVING](#having---filtrar-grupos) en Funciones de Agregación)
6. **SELECT** - Selecciona las columnas
7. **DISTINCT** - Elimina duplicados
8. **ORDER BY** - Ordena los resultados
9. **LIMIT** - Limita el número de resultados (opcional; ver documentación de MySQL)

**Ejemplo:**
```sql
SELECT DISTINCT p.nombre, COUNT(*)
FROM personas p
INNER JOIN habitar h ON p.dni = h.dni
WHERE YEAR(h.fecha_inicio) > 1985
GROUP BY p.nombre
ORDER BY p.nombre;
```

**Orden de ejecución:**
1. FROM personas p
2. INNER JOIN habitar h
3. WHERE YEAR(h.fecha_inicio) > 1985
4. GROUP BY p.nombre
5. SELECT p.nombre, COUNT(*)
6. DISTINCT
7. ORDER BY p.nombre

| [Anterior](#orden-de-ejecución-de-las-consultas) | [Índice](#índice) | [Siguiente](#glosario-de-términos) |
|---|---|---|

---

## Glosario de Términos

### Base de Datos (Database)Colección organizada de datos estructurados que se almacenan y acceden electrónicamente.

### Tabla (Table)Estructura que organiza datos en filas (registros) y columnas (campos).

### Registro / Fila (Row / Record)Una fila individual en una tabla que representa un conjunto completo de datos.

### Campo / Columna (Field / Column)Un atributo o propiedad de los datos en una tabla.

### Clave Primaria (Primary Key - PK)Columna o conjunto de columnas que identifica de forma única cada fila en una tabla. No puede ser NULL.

### Clave Foránea (Foreign Key - FK)Columna que referencia a la clave primaria de otra tabla. Establece una relación entre tablas.

### RelaciónConexión entre dos tablas basada en claves primarias y foráneas.

### JOINOperación que combina filas de dos o más tablas basándose en una condición de relación.

### AliasNombre alternativo temporal para una tabla o columna. Se usa con `AS` o simplemente con un espacio.

### NULLValor que representa la ausencia de datos. No es lo mismo que cero o cadena vacía.

### Consulta (Query)Instrucción SQL que solicita datos de una base de datos.

### SGBD / SGBDRSistema de Gestión de Bases de Datos (Relacionales). Software que gestiona bases de datos (MySQL, PostgreSQL, etc.).

| [Anterior](#orden-de-ejecución-de-las-consultas) | [Índice](#índice) | [Siguiente](#consejos-para-aprender) |
|---|---|---|

---

## Consejos para Aprender

1. **Empieza simple:** Comienza con consultas básicas (SELECT, WHERE) antes de JOINs complejos.

2. **Practica paso a paso:** 
   - Primero ejecuta la consulta básica
   - Luego agrega filtros (WHERE)
   - Después agrega JOINs
   - Finalmente agrega ordenamiento (ORDER BY)

3. **Usa alias:** Los alias hacen las consultas más legibles, especialmente con múltiples tablas.

4. **Verifica los resultados:** Siempre revisa que los resultados sean los esperados.

5. **Experimenta:** Prueba variaciones de las consultas para entender mejor cómo funcionan.

6. **Dibuja el diagrama:** Visualizar las relaciones entre tablas ayuda a entender las consultas.

| [Anterior](#glosario-de-términos) | [Índice](#índice) | [Siguiente](#archivos-de-consultas) |
|---|---|---|

---

## Archivos de Consultas

Cada consulta está en un archivo separado:

- `consulta_01_apellidos_por_L.sql` - LIKE y patrones
- `consulta_02_viviendas_centro_metros.sql` - WHERE con múltiples condiciones
- `consulta_03_viviendas_antes_1986.sql` - Funciones de fecha (YEAR)
- `consulta_04_viviendas_sector_sur_ordenadas.sql` - ORDER BY
- `consulta_05_viviendas_con_descripcion_zona.sql` - INNER JOIN básico
- `consulta_06_personas_con_vivienda_LEFT_JOIN.sql` - LEFT JOIN
- `consulta_07_viviendas_con_habitantes.sql` - Múltiples JOINs
- `consulta_08_personas_con_padre.sql` - SELF JOIN
- `consulta_09_personas_sector_norte.sql` - JOINs con WHERE
- `consulta_10_zonas_con_viviendas.sql` - RIGHT JOIN
- `consulta_11_personas_habitar_1985_1995.sql` - Rangos de fechas
- `consulta_12_viviendas_mas_40_años.sql` - TIMESTAMPDIFF
- `consulta_13_personas_mas_20_años_habitando.sql` - Cálculos de tiempo
- `consulta_14_personas_30_octubre.sql` - DAY y MONTH
- `consulta_15_personas_ordenadas_por_fecha.sql` - ORDER BY con fechas
- `consulta_16_personas_viviendas_antes_1985.sql` - JOINs complejos
- `consulta_17_dias_mario_lopez.sql` - DATEDIFF
- `consulta_18_viviendas_padre_registrado.sql` - JOINs múltiples con SELF JOIN
- `consulta_19_viviendas_personas_ordenadas_fecha.sql` - JOINs con ORDER BY
- `consulta_20_contar_viviendas_habitadas.sql` - COUNT y funciones de agregación

| [Anterior](#consejos-para-aprender) | [Índice](#índice) | [Siguiente](#cómo-usar-este-material) |
|---|---|---|

---

## Cómo Usar Este Material

### Ruta de lectura sugerida
Para no abrumarte, sigue el material en bloques y practica las consultas asociadas a cada uno:

| Bloque | Contenido del README | Consultas a practicar |
|--------|----------------------|------------------------|
| 1 | Estructura de la BD, Diagrama ER, Conceptos (SELECT, WHERE, LIKE, ORDER BY, DISTINCT, NULL) | 1 a 5 |
| 2 | Tipos de JOIN (INNER, LEFT, RIGHT, SELF JOIN) | 6 a 10 |
| 3 | Funciones de fecha | 11 a 15 |
| 4 | Funciones de agregación y HAVING | 16 a 20 |

Primera pasada: lee el Bloque 1 y haz las consultas 1-5. Segunda: Bloque 2 y consultas 6-10, y así sucesivamente. Puedes volver al README cuando necesites repasar un concepto.

### Ejecutar el script de la base de datos
Antes de practicar, crea la base de datos y carga los datos:

- **Desde terminal (línea de comandos):** en la carpeta donde está `viviendas.sql`, ejecuta:
  ```bash
  mysql -u tu_usuario -p < viviendas.sql
  ```
  Te pedirá la contraseña. Si MySQL está en el PATH, puedes usar `mysql`. En algunos entornos el ejecutable se llama `mysql.exe`.

- **Desde un cliente gráfico (MySQL Workbench, DBeaver, etc.):** abre el archivo `viviendas.sql` y ejecuta todo el script (Run / Ejecutar).

Después de ejecutarlo, tendrás la base de datos `viviendas` con las tablas y datos listos para las consultas.

### Pasos generales
1. **Preparación:**
   - Asegúrate de tener MySQL instalado
   - Ejecuta el script `viviendas.sql` como se indica arriba

2. **Estudiar:**
   - Lee este README por bloques (ver ruta de lectura sugerida)
   - Revisa el diagrama ER para entender las relaciones

3. **Practicar:**
   - Abre cada archivo de consulta en el orden indicado
   - Lee las explicaciones
   - Ejecuta la consulta
   - Compara con el resultado esperado
   - Prueba las variaciones sugeridas

4. **Revisar:**
   - Vuelve a este README cuando tengas dudas sobre conceptos
   - Consulta los ejemplos cuando necesites recordar sintaxis

| [Anterior](#archivos-de-consultas) | [Índice](#índice) | Siguiente — |
|---|---|---|

---

¡Buena suerte con tu aprendizaje de SQL!

