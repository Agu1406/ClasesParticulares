# BOE — Curso de especialización Python (RD 566/2024)

Fuente oficial: [Real Decreto 566/2024 (BOE-A-2024-12503)](https://www.boe.es/diario_boe/txt.php?id=BOE-A-2024-12503)

## Curso

| Campo | Valor |
|-------|--------|
| **Denominación** | Desarrollo de aplicaciones en lenguaje Python |
| **Nivel** | FP Grado Superior (curso de especialización) |
| **Duración** | 430 horas · 26 ECTS |
| **Familia** | Informática y Comunicaciones |
| **Norma** | RD 566/2024, de 18 de junio de 2024 |

## Módulos BOE → UT del repositorio

El repo organiza el contenido en **UT1–UT9** (como `java/`), mapeando los cuatro módulos del BOE y ampliando hacia paridad con el **0485 Programación**:

| Código | Módulo BOE | Horas | ECTS | UT en `python/src/` |
|--------|------------|-------|------|---------------------|
| **5098** | Entornos y sintaxis | 25 | 3 | **UT1** `ut1_fundamentospython` |
| **5099** | Estructuras de control | 40 | 5 | **UT2** `ut2_controlflujometodos` |
| — | Cadenas (paridad 0485 / Java UT3) | — | — | **UT3** `ut3_strings` |
| **5101** | Análisis de datos (colecciones, NumPy, pandas) | 75 | 9 | **UT4** `ut4_colecciones` |
| **5100** | Programación orientada a objetos | 75 | 9 | **UT5** `ut5_pooexcepcionesio` |
| — | POO avanzada (paridad 0485 / Java UT6) | — | — | **UT6** `ut6_pooavanzadaestructuras` |
| — | Persistencia (paridad JDBC → sqlite/SQL) | — | — | **UT7** `ut7_persistenciaapi` |
| — | Frameworks web (paridad Spring → Flask) | — | — | **UT8** `ut8_frameworksweb` |
| — | Programación funcional (paridad Java UT9) | — | — | **UT9** `ut9_programacionfuncional` |

## Reparto por evaluación

| Evaluación | UT | Módulos BOE cubiertos |
|------------|-----|------------------------|
| **EV1** | UT1, UT2, UT3 | 5098, 5099 + strings |
| **EV2** | UT4, UT5 | 5101, 5100 |
| **EV3** | UT6, UT7, UT8, UT9 | 5100 (avanzado) + ampliación 0485 |

## Resultados de aprendizaje → carpetas

### 5098 → UT1

| Contenido | Carpeta |
|-----------|---------|
| Entorno, tipos, operadores, input | `u01entornopython`, `u02tiposvariables`, `u03inputcomentarios` |

### 5099 → UT2

| Contenido | Carpeta |
|-----------|---------|
| Condicionales, bucles, funciones, excepciones | `u01condicionales` … `u04excepciones` |

### 5101 → UT4

| Contenido | Carpeta |
|-----------|---------|
| Listas, tuplas, diccionarios | `u01listas`–`u03diccionarios` |
| NumPy, pandas | `u04numpy`, `u05pandas` |
| Práctica Sevilla gestor tareas | `u01listas/practicas/sevillaiesvelazquezgestortareasbasico/` |

### 5100 → UT5 + UT6

| Contenido | Carpeta |
|-----------|---------|
| Clases, excepciones, ficheros | UT5 `u01poobasica` … `u03ficherosio` |
| Herencia, ampliación centro | UT6 `u01herenciapolimorfismo` (+ PDF Sevilla) |

## Nota didáctica

- **UT1–UT9** es la convención del repo (alineada a `java/`).
- **UT3 y UT6–UT9** amplían el mínimo del RD 566/2024 hacia el alcance del **0485** en Java; el BOE de especialización no los exige todos, pero el objetivo pedagógico del repo es **equivalencia o mayor profundidad**.

## Relación con Java (0485)

| Java `src/` | Python `src/` |
|-------------|---------------|
| `ev1/ut1` … `ut3` | `ev1/ut1` … `ut3` |
| `ev2/ut4`, `ut5` | `ev2/ut4`, `ut5` |
| `ev3/ut6` … `ut9` | `ev3/ut6` … `ut9` |

El ciclo DAM/DAW imparte el 0485 casi siempre en **Java**. Este módulo Python cubre el BOE 566 **y** el camino hacia la misma amplitud que `../java/`.
