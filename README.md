# Clases Particulares - Repositorio Educativo

## Despliegue en Vivo con Github Pages (HTML/CSS/JS todo nativo)

#### **Sistema de Tests Interactivos:** [https://agu1406.github.io/ClasesParticulares](https://agu1406.github.io/ClasesParticulares)

Los estudiantes pueden acceder a tests interactivos tipo Google Forms para preparar sus exámenes. El sistema incluye tests sobre JavaFX y Arrays en Java, con más categorías en desarrollo.

## Propósito del Repositorio

Este repositorio nace con el objetivo de **preservar y organizar todo el contenido teórico y práctico** que enseño a través de mi servicio de clases particulares a distancia.

### Origen de la Idea

La idea surgió este año (2025) después de más de un año impartiendo clases, cuando me di cuenta de que **no estaba guardando el contenido en ningún lugar** y era demasiado valioso para dejarlo perder. Cada ejercicio, práctica, proyecto y explicación representa horas de trabajo y conocimiento acumulado que merece ser preservado.

## Organización del repo: dos familias

### Familia espejo (Programación 0485 / paridad pedagógica)

Misma jerarquía `src/ev{N}/ut{N}_{tema}/u{NN}…` y las mismas convenciones de nombres. **Canon:** [`java/README.md`](java/README.md).

| Módulo | Rol |
|--------|-----|
| [`java/`](java/README.md) | Guía canónica + material más completo |
| [`python/`](python/README.md) | Espejo + RD 566/2024 (NumPy/pandas, etc.) |
| [`csharp/`](csharp/README.md) | Espejo .NET / C# |
| [`cpp/`](cpp/README.md) | Espejo C++ / STL |

**Fase A (estructura):** hecha — EV/UT alineados; prácticas CES (centralita, figuras, trabajadores, alumnos) en `ev3/ut6_…/u01herenciapolimorfismo/practicas/` en los cuatro.

**Fase B (contenido):** pendiente — paridad bidireccional de teoría/ejercicios (Java → resto y exclusivos de cada lenguaje → Java/resto).

### Temario propio (no forzar UT1–UT9 de Java)

| Módulo | Temario |
|--------|---------|
| [`js/`](js/README.md) | DWEC 0612 (mapa propio, kebab-case) |
| [`android/`](android/README.md) / [`flutter/`](flutter/README.md) | PMDM (Kotlin / Dart) |
| [`javafx/`](javafx/README.md) | GUI JavaFX (RA5) |
| [`c/`](c/README.md) | C por módulos `01-…` |
| [`interfaces/`](interfaces/) | HTML/CSS/JS por centro |
| [`php/`](php/), [`sql/`](sql/), [`linux/`](linux/) | Por CCAA / centro |
| [`react/`](react/), [`css/`](css/), [`tests/`](tests/README.md), [`portfolio/`](portfolio/) | Tutoriales, estilos, tests, sitio |

## Estructura del Repositorio

### **android/**
- PMDM / Kotlin con estructura **EV1–EV3** (mapa propio PMDM, no UT1–UT9 de Java)
- Prompt examen CES: [`android/madrid/cesjuanpablosegundo/`](android/madrid/cesjuanpablosegundo/)
- Prácticas CES + teoría Android; SharedPreferences, archivos, SQLite
- Ver [android/README.md](android/README.md)

### **flutter/**
- Rama Flutter del temario PMDM (Dart, widgets, proyectos)
- Ver [flutter/README.md](flutter/README.md)

### **c/**
- Programación en C por módulos progresivos (`01-introduccion`, `02-sintaxis-basica`, `03-control-flujo`, …)
- Documentación PDF (pilas, colas, registros) y ejercicios de laboratorio

### **cpp/**
- Familia espejo: `src/ev1` (UT1–UT3), `ev2` (UT4–UT5 esqueleto), `ev3` (UT6 CES + UT7–UT9 esqueleto)
- Material UAX en `madrid/` (CMake), fuera del árbol EV
- Ver [cpp/README.md](cpp/README.md)

### **css/**
- Estilos CSS reutilizables y compartidos (`index.css`)

### **interfaces/**
- Desarrollo de interfaces web (HTML/CSS/JS) organizado por comunidad y centro

### **java/**
- Canon de la familia espejo — Programación (0485), EV1–EV3 / UT1–UT9
- Teoría, ejercicios, prácticas de centro, diagnóstico, recuperación ordinaria
- Guía completa: [java/README.md](java/README.md)

### **javafx/**
- GUI JavaFX: misma lógica `ev1`/`ev2`/`ev3` que `java/`, módulo Gradle aparte
- Núcleo en `ev2/ut5_pooexcepcionesio/`; legacy en `javafx/src/ignorar/legacy/`

### **js/**
- **DWEC** (0612): temario BOE propio (`ev1`–`ev3`, kebab-case, sin forzar UT Java)
- Ver [js/README.md](js/README.md) y [BOE DWEC](js/BOE-2023-06-03-RD-405-modulo-0612-DWEC.md)

### **php/**
- Desarrollo web por regiones (Andalucía, Catalunya/UOC, Madrid UD2–UD4)
- MVC, DAO, MySQL

### **python/**
- Familia espejo + curso especialización RD 566/2024
- CES en `ev3/ut6/…`; material Sevilla/Elche documentado en el README del módulo
- Ver [python/README.md](python/README.md)

### **csharp/**
- Familia espejo .NET: EV1–EV3 / UT1–UT9; prácticas CES en `ev3/ut6/…`
- Ver [csharp/README.md](csharp/README.md)

### **sql/**
- Scripts y prácticas MySQL / Access organizados por región y centro

### **react/**
- Tutoriales React (inicio rápido, tres en línea); no es temario EV

### **linux/**
- Material de sistemas / RA3 y centros concretos

### **tests/**
- Sistema de tests interactivos (Examen / Estudio) en GitHub Pages
- Ver [tests/README.md](tests/README.md)

### **portfolio/**
- Sitio del portfolio (Astro/React); no es asignatura

## Contenido Educativo

### Tipos de Material Incluido:
- **Ejercicios prácticos** con soluciones completas
- **Proyectos de ejemplo** paso a paso
- **Documentación técnica** y guías
- **Código fuente comentado** y explicado
- **Enunciados de prácticas** y exámenes
- **Ejemplos de buenas prácticas** de programación
- **Tests interactivos** para preparación de exámenes

## Tecnologías y Lenguajes

| Lenguaje | Uso Principal |
|----------|---------------|
| **Java** | Canon espejo 0485: POO, Swing, JDBC, multihilo, colecciones |
| **Python** | Espejo + datos (NumPy/pandas), Flask (esqueleto) |
| **C#** | Espejo .NET: fundamentos, colecciones, POO, ADO.NET/LINQ (esqueleto) |
| **C++** | Espejo: fundamentos EV1; EV2/EV3 estructura + prácticas CES |
| **C** | Programación estructurada por módulos |
| **Kotlin / Android** | PMDM: consola CES, UI, persistencia |
| **JavaScript** | DWEC (cliente web) |
| **PHP** | Desarrollo web, formularios, BD, MVC |
| **SQL** | MySQL, consultas, Access |
| **HTML/CSS** | Interfaces web, maquetación |
| **Flutter / Dart** | PMDM multiplataforma |
| **React** | Tutoriales frontend |
| **CSS** | Estilos reutilizables |

## Sistema de Tests Interactivos

El repositorio incluye un **sistema completo de tests interactivos** desplegado en GitHub Pages que permite a los estudiantes:

- Realizar tests de preparación para exámenes
- Elegir entre modo **Examen** (sin feedback) y modo **Estudio** (con feedback inmediato)
- Navegar entre preguntas y cambiar respuestas
- Ver resultados detallados con explicaciones
- Acceder desde cualquier dispositivo (diseño responsive)

**URL:** [https://agu1406.github.io/ClasesParticulares](https://agu1406.github.io/ClasesParticulares)

### Tests Disponibles:
- **JavaFX**: 2 tests (Conceptos básicos y Completar código) - 37 preguntas
- **Arrays en Java**: 1 test - 20 preguntas
- Más categorías en desarrollo

## Convenciones del Proyecto

### Commits
Seguimos la convención de **Conventional Commits** (`PERSONALGUIDE.md`):
- `feat`: Nuevas funcionalidades
- `fix`: Corrección de errores
- `docs`: Documentación
- `style`: Formato y estilo
- `refactor`: Refactorización
- `test`: Añadir o modificar tests
- `chore`: Tareas de mantenimiento

### Organización
- **Familia espejo:** `src/evN/utN_tema/uNNsubtema/{teoria,ejercicios,practicas}` — detalles en [`java/README.md`](java/README.md)
- **Por centro (php/sql/interfaces/…):** comunidad → ciudad → centro
- **Código fuente** separado de **documentación** de módulo
- **Tests interactivos** en `tests/`

## Objetivos

1. **Preservar el conocimiento** generado durante las clases
2. **Facilitar el aprendizaje** con ejemplos prácticos
3. **Crear un banco de recursos** reutilizable
4. **Documentar el progreso** educativo de los estudiantes
5. **Compartir buenas prácticas** de programación
6. **Proporcionar herramientas de estudio** interactivas para los estudiantes

## Contribuciones

Este repositorio es principalmente personal, pero está abierto a:
- **Sugerencias de mejora** en los ejercicios
- **Correcciones** de errores encontrados
- **Nuevos ejemplos** que complementen el contenido
- **Mejoras** en el sistema de tests

## Contacto

Para consultas sobre el contenido educativo o clases particulares, puedes contactarme a través de los siguientes canales:
- **GitHub**: [@Agu1406](https://github.com/Agu1406)
- **LinkedIn**: [agustin6041](https://www.linkedin.com/in/agustin6041)
- **Email**: agu1406@outlook.es

## Frases

*"La educación es la base de la libertad y el progreso de los pueblos"* - **Simón Bolívar**

*"La programación no es sobre lo que sabes, es sobre lo que puedes descubrir"* - **Chris Pine**
