# Guía de Consultas SQL - Base de Datos Circo (GROUP BY y HAVING)

Este material está diseñado para aprender **GROUP BY** y **HAVING** usando la base de datos del circo. Sigue el mismo enfoque didáctico que los ejercicios de viviendas.

## Índice

1. [Estructura de la Base de Datos](#estructura-de-la-base-de-datos)
2. [Diagrama Entidad-Relación](#diagrama-entidad-relación)
3. [GROUP BY - Agrupar Resultados](#group-by---agrupar-resultados)
4. [HAVING - Filtrar Grupos](#having---filtrar-grupos)
5. [Diferencia entre WHERE y HAVING](#diferencia-entre-where-y-having)
6. [Orden de Ejecución](#orden-de-ejecución)
7. [Archivos de Consultas](#archivos-de-consultas)

---

## Estructura de la Base de Datos

La base de datos `circo` gestiona artistas, animales, atracciones y pistas de un circo.

### Tabla: `artistas`
Información de los artistas del circo.

| Columna | Tipo | Descripción |
|---------|------|-------------|
| `Nif` | CHAR(9) | **Clave Primaria** - NIF del artista |
| `apellidos` | CHAR(30) | Apellidos |
| `nombre` | CHAR(15) | Nombre |
| `nif_jefe` | CHAR(9) | **Clave Foránea** - NIF del jefe (puede ser NULL) |

### Tabla: `animales`
Animales que participan en el circo.

| Columna | Tipo | Descripción |
|---------|------|-------------|
| `nombre_animal` | VARCHAR(50) | **Clave Primaria** |
| `tipo` | CHAR(15) | Tipo de animal (León, Jirafa, etc.) |
| `anhos` | TINYINT | Edad en años |
| `peso` | TINYINT | Peso en kg |
| `estatura` | DOUBLE | Estatura en metros |
| `nombre_pista` | CHAR(10) | **FK** - Pista asignada |
| `nombre_atraccion` | VARCHAR(50) | **FK** - Atracción asignada |

### Tabla: `atracciones`
Atracciones del circo.

| Columna | Tipo | Descripción |
|---------|------|-------------|
| `Nombre` | VARCHAR(50) | **Clave Primaria** |
| `F_inicio` | DATETIME | Fecha de inicio |
| `ganancias` | INT | Ganancias totales |

### Tabla: `pistas`
Pistas donde se realizan las actuaciones.

| Columna | Tipo | Descripción |
|---------|------|-------------|
| `Nombre_pista` | CHAR(10) | **Clave Primaria** |
| `Aforo` | INT | Capacidad de espectadores |

### Tabla: `artista_animal`
Relación N:M entre artistas y animales (qué artista trabaja con qué animal).

| Columna | Tipo | Descripción |
|---------|------|-------------|
| `nif` | CHAR(9) | **FK** - NIF del artista |
| `nombre` | VARCHAR(50) | **FK** - Nombre del animal |

### Tabla: `artista_atraccion`
Relación entre artistas y atracciones con fechas.

| Columna | Tipo | Descripción |
|---------|------|-------------|
| `nif` | CHAR(9) | **FK** - NIF del artista |
| `nombre_atraccion` | VARCHAR(50) | **FK** - Nombre de la atracción |
| `fecha_inicio` | DATETIME | Fecha de inicio |
| `fecha_fin` | DATETIME | Fecha de fin (NULL si sigue activo) |

### Tabla: `atraccion_dia`
Registro diario de espectadores y ganancias por atracción.

| Columna | Tipo | Descripción |
|---------|------|-------------|
| `nombre_atraccion` | VARCHAR(50) | **FK** - Nombre de la atracción |
| `fecha` | DATETIME | Fecha del registro |
| `num_espectadores` | INT | Número de espectadores ese día |
| `ganancia` | INT | Ganancia ese día |

---

## Diagrama Entidad-Relación

```
                    ARTISTAS (nif_jefe → artistas)
                         │
         ┌───────────────┼───────────────┐
         │               │               │
         ▼               ▼               ▼
   artista_animal   artista_atraccion   (auto-ref)
         │               │
         ▼               ▼
     ANIMALES       ATRACCIONES
         │               │
         │               ▼
         │         atraccion_dia
         │
         ├───────────────┐
         ▼               ▼
     PISTAS         ATRACCIONES
```

---

## GROUP BY - Agrupar Resultados

`GROUP BY` agrupa filas que tienen **los mismos valores** en las columnas especificadas. Se usa junto con funciones de agregación (COUNT, SUM, AVG, MAX, MIN).

### Regla importante
**Todas las columnas en SELECT que no sean funciones de agregación deben aparecer en GROUP BY.**

### Ejemplo básico
```sql
-- ¿Cuántos animales hay de cada tipo?
SELECT tipo, COUNT(*) AS cantidad
FROM animales
WHERE tipo IS NOT NULL
GROUP BY tipo;
```

### Funciones de agregación con GROUP BY
- **COUNT()**: Cuenta filas en cada grupo
- **SUM()**: Suma valores en cada grupo
- **AVG()**: Promedio en cada grupo
- **MAX()** / **MIN()**: Valor máximo/mínimo en cada grupo

---

## HAVING - Filtrar Grupos

`HAVING` filtra **grupos** después de que se han formado. Es como un `WHERE` pero para grupos.

### ¿Cuándo usar HAVING?
- Cuando quieres filtrar **por el resultado de una función de agregación**
- Ejemplo: "Mostrar solo los tipos de animal que tienen más de 1 ejemplar"

### Ejemplo
```sql
-- Tipos de animal con más de 1 ejemplar
SELECT tipo, COUNT(*) AS cantidad
FROM animales
WHERE tipo IS NOT NULL
GROUP BY tipo
HAVING COUNT(*) > 1;
```

---

## Diferencia entre WHERE y HAVING

| | WHERE | HAVING |
|---|-------|--------|
| **Filtra** | Filas individuales | Grupos completos |
| **Cuándo** | Antes del agrupamiento | Después del agrupamiento |
| **Puede usar** | Cualquier columna | Columnas del GROUP BY o funciones de agregación |
| **Ejemplo** | `WHERE peso > 50` | `HAVING COUNT(*) > 2` |

### Orden de uso
```sql
SELECT tipo, COUNT(*) AS cantidad
FROM animales
WHERE tipo IS NOT NULL    -- 1º: Filtra filas (ej: quitar NULL)
GROUP BY tipo             -- 2º: Agrupa
HAVING COUNT(*) > 1;      -- 3º: Filtra grupos
```

---

## Orden de Ejecución

Cuando usas GROUP BY y HAVING, el orden es:

1. **FROM** - Identifica las tablas
2. **JOIN** - Combina tablas (si hay)
3. **WHERE** - Filtra filas individuales
4. **GROUP BY** - Agrupa las filas
5. **HAVING** - Filtra los grupos
6. **SELECT** - Selecciona columnas y calcula agregaciones
7. **ORDER BY** - Ordena resultados
8. **LIMIT** - Limita resultados

---

## Formato estándar de las consultas

Mismo formato que las consultas de viviendas:

```
-- CONSULTA N: Título
-- Objetivo
-- EXPLICACIÓN: concepto que se practica
-- SOLUCIÓN: código SQL
-- RESULTADO ESPERADO
-- VARIACIONES PARA PRACTICAR
```

## Archivos de Consultas

Consultas 1-30: SELECT (básicas, JOINs, funciones de agregación)
- consulta_01 a consulta_10: SELECT, WHERE, LIKE, fechas, IN, subconsultas básicas
- consulta_11 a consulta_20: JOINs, ORDER BY, múltiples tablas
- consulta_21 a consulta_30: Funciones de agregación (SUM, AVG, COUNT, MIN, MAX)

Consultas 31-32: GROUP BY y HAVING
- consulta_31: Animales por artista
- consulta_32: Atracciones por día con HAVING

Consultas 33-38: Actualizaciones (INSERT, CREATE TABLE, DELETE, UPDATE)
- consulta_33: INSERT artista
- consulta_34: CREATE TABLE artistas_antiguos
- consulta_35 a consulta_38: DELETE y UPDATE

Consultas 39-49: Subconsultas
- consulta_39 a consulta_49: DELETE/UPDATE con subconsultas, subconsultas en WHERE

---

## Cómo Usar Este Material

1. **Preparación:** Ejecuta `BDCirco.sql` para crear la base de datos
2. **Estudiar:** Lee este README para entender la estructura
3. **Practicar:** Abre cada consulta en orden (01 a 49)
4. **Nota:** Las consultas 33-38 y 39 modifican datos; haz backup o usa una copia de la BD para practicar

Buena suerte.
