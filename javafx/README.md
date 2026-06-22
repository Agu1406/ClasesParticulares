# JavaFX — Clases particulares (DAM/DAW)

Capa **visual** del modulo 0485 Programacion. Complementa a `../java/` con la misma logica de carpetas (`ev1` / `ev2` / `ev3`, UT, `teoria`, `ejercicios`, `practicas`).

Normativa: `../java/BOE-2023-06-03-RD-405-modulo-0485-programacion.md`.

## Requisitos

- **JDK 21** · **JavaFX 21.0.6** · **Gradle** (wrapper)
- IntelliJ: **Gradle JVM = JDK 21** → Reload Gradle Project
- **Scene Builder** para editar `.fxml` (recomendado)

## Regla de diseño GUI

Todas las interfaces son **nivel junior** y **editables en Scene Builder**:

| Pieza | Rol |
|-------|-----|
| `*App.java` | `Application`, carga FXML con `FXMLLoader` |
| `*Controller.java` | Logica y eventos (`@FXML`, `onAction`) |
| `*-view.fxml` | Layout visual (abrir en Scene Builder) |

No se crean GUIs solo en codigo Java salvo material en `ignorar/legacy/`.

## Estructura

```
javafx/src/
├── ev1/
│   ├── ut1_fundamentosjava/teoria/     App + Controller + FXML
│   ├── ut2_controlflujometodos/teoria/
│   └── ut3_stringsyenvolventes/teoria/
├── ev2/
│   └── ut5_pooexcepcionesio/     Nucleo actual
│       ├── teoria/
│       ├── ejercicios/
│       └── practicas/
├── ev3/
│   ├── ut6_pooavanzadaestructuras/   Marco futuro
│   └── ut7_persistenciajdbcapi/      Marco futuro
└── ignorar/
    ├── legacy/                   Versiones avanzadas / originales (no compilado)
    └── referencia-centros/       Maven Eclipse de centros (no compilado)
```

En `javafx/` el contenido va **directo bajo la UT** (sin `u01…`). En `java/` si se mantienen subtemas.

El `package` coincide con la ruta bajo `src/`.

## Teoria actual

### EV1 (una GUI por UT)

Ver `src/ev1/README.md`.

### EV2 · UT5

| App | FXML | Contenido |
|-----|------|-----------|
| `U01_StageYSceneApp` | `u01_stage-view.fxml` | Stage, Scene, controles basicos |
| `U02_FXMLLoaderIntro` | `u02_hello-view.fxml` | Carga de FXML |
| `U03_ControllerVentanas` | `u02_hello-view.fxml` | Segunda ventana |
| `U03_FormularioController` | `u03_formulario-view.fxml` | Formulario en ventana nueva |
| `U04_CalculadoraApp` | `u04_calculadora-view.fxml` | Calculadora junior (+, -, *, /) |

```powershell
cd javafx
.\gradlew.bat run
```

Por defecto arranca `U02_FXMLLoaderIntro`. Cambiar `mainClass` en `build.gradle` para otra App.

## Convenciones

| Carpeta | Contenido |
|---------|-----------|
| `teoria/` | Bloques `U01_`, `U02_`… (App + Controller + FXML) |
| `ejercicios/pendientes` y `resueltos` | `_SIN_RESOLVER` / `_RESUELTO` |
| `practicas/` | Enunciado + App, Controller, FXML en carpeta plana |

### Material legacy

Versiones en codigo puro o calculadora avanzada: `src/ignorar/legacy/`. Ver `src/ignorar/legacy/README.md`.

## Ejecutar (importante)

Desde JDK 11, **JavaFX no viene dentro del JDK**. IntelliJ suele lanzar tareas Gradle del tipo `NombreApp.main()`; el `build.gradle` ya les anade el module-path de JavaFX.

Pasos:

1. Abre el proyecto **`javafx`** como proyecto **Gradle** (carpeta con `build.gradle`).
2. **File → Settings → Build, Execution, Deployment → Build Tools → Gradle**
   - **Gradle JVM = JDK 21**
   - **Build and run using: Gradle** (recomendado)
3. **Reload Gradle Project** (icono elefante).
4. Pulsa **Run** en cualquier `*App.java`.

Si aun falla, usa Gradle directamente:

```powershell
cd javafx
.\gradlew.bat run
```

Para otra App sin editar `build.gradle`:

```powershell
.\gradlew.bat run "-PmainClass=ev1.ut1_fundamentosjava.teoria.U01_TiposYConversionApp"
```

## Build

```powershell
.\gradlew.bat clean compileJava run
```

## Contacto

agu1406@outlook.es
