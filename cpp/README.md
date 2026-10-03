# C++ — Clases particulares

Material de C++ organizado **como `java/`, `python/` y `csharp/`**: evaluaciones **EV1–EV3**, unidades **UT1–UT9**, subtemas `u01…`, `teoria/`, `ejercicios/`, `practicas/`.

**Objetivo del repo:** paridad pedagógica con el módulo 0485 en Java (`../java/`), con Python (`../python/`) y con C# (`../csharp/`), adaptado a compilador, `iostream` y la STL.

**Familia espejo:** `java` ↔ `python` ↔ `csharp` ↔ `cpp`. Canon de carpetas/nombres: [`../java/README.md`](../java/README.md).

- **Fase A (hecha):** estructura EV1–EV3 alineada; prácticas CES en `ev3/ut6/…`.
- **Fase B (en curso):** EV2 + UT6 u01 + UT9 u01lambda. Pendiente: ut6 u02–u04, ut7–ut8.

El material de centro UAX permanece en `madrid/` (proyectos C con CMake). No forma parte del árbol EV.

## Requisitos

- Compilador **g++** con **C++17** (MinGW/MSYS2, o el g++ de tu distro)
- IDE: VS Code, Cursor, CLion o Visual Studio

## Estructura

```
cpp/
├── README.md
├── madrid/              ← UAX (C + CMake; no se toca)
└── src/
    ├── ev1/             UT1–UT4   (fundamentos, control, strings, struct/refs)
    ├── ev2/             UT3 punteros (extra C++) + UT4 colecciones + UT5 POO
    └── ev3/             UT6–UT9   (herencia, **UT8 = SDL**, lambda)
```

### Mapa UT ↔ Java / Python / C#

| UT | Carpeta C++ | Equivalente Java | Estado |
|----|-------------|------------------|--------|
| **UT1** | `ut1_fundamentoscpp` | `ut1_fundamentosjava` | Contenido EV1 |
| **UT2** | `ut2_controlflujometodos` | `ut2_controlflujometodos` | Contenido EV1 |
| **UT3 Ev1** | `ev1/ut3_strings` | strings | EV1 |
| **UT4 Ev1** | `ev1/ut4_tiposcompuestos` | *(C++ extra, PDF Intro)* enum/struct/`&`/casts | Nuevo |
| **UT3 Ev2** | `ev2/ut3_punterosmemoria` | *(C++ extra)* `*` `new` `delete[]` | Nuevo. **Después de arrays, antes de POO** |
| **UT4 Ev2** | `ev2/ut4_colecciones` | arrays, `array`, `vector`, `map`, `set` | Contenido |
| **UT5** | `ut5_pooexcepcionesio` | clases + **Vector2D** + **VectorOfDoubles** | Ampliado PDF POO |
| **UT6** | `ut6_pooavanzadaestructuras` | herencia | u01 |
| **UT7** | `ut7_persistenciastl` | ficheros/STL | Esqueleto |
| **UT8** | `ut8_frameworks` | **SDL** (PDF 3; en Java sería Spring) | Nuevo |
| **UT9** | `ut9_programacionfuncional` | lambda/STL | u01lambda |

**Orden de clase (PDFs UCM):** Ev1 UT1–UT4 → Ev2 UT4 u01 arrays → Ev2 UT3 punteros → Ev2 UT4 u02 vector → Ev2 UT5 POO → Ev3 UT8 SDL.

### Convención (igual que Java/Python/C#)

- **UT:** `ut{N}_{nombre}`
- **Subtema:** `u{NN}{nombre}`
- **Teoría:** `U{NN}_{Nombre}.cpp` ejecutables con explicación en comentario de bloque
- **Ejercicios:** `E{NN}_*_Pendiente.cpp` / `_Resuelto.cpp`
- **Prácticas de centro:** carpeta `{comunidad}{centro}{nombre}` sin guiones; enunciados en kebab-case
- **Sin `practicas/` en EV1** (el material UAX está en `madrid/`)

### Formato C++ (Ev1)

Cada `.cpp` es un programa independiente:

```cpp
#include <iostream>
using namespace std;

int main() {
    cout << "Hola Mundo" << endl;
    return 0;
}
```

- Estándar **C++17** y `using namespace std;` (nivel junior).
- **EV1:** no se usan **arrays**, punteros, `new` ni ficheros (se introducen en EV2). Ev1 **UT4** sí tiene `enum`, `struct` y referencias (`&`).
- Hasta `u03bucles`: programa lineal dentro de `main`.
- Desde **EV1 `ut2_controlflujometodos/u04metodos`**: menú `do-while` + `switch`, opción **0 = salir**. En comentarios se habla de **funciones** (aún no hay clases); la carpeta se llama `u04metodos` para paridad con Java/C#.

### Cómo ejecutar un fichero

Cada archivo se compila solo (como `dotnet run --file` en C#).

#### Botón Play

Abre la carpeta **`cpp/`** como workspace (File → Open Folder), no solo un archivo suelto.

**VS Code / Cursor:** instala **C/C++** (`ms-vscode.cpptools`) y **Code Runner** (`formulahendry.code-runner`). Abre un `.cpp` y usa el ▶ arriba a la derecha o **Ctrl+Alt+N**.

**Ambos editores (sin extensiones extra):** *Terminal → Run Task* → `Ejecutar .cpp actual`, o **Ctrl+Shift+B**.

#### Terminal

```powershell
g++ -std=c++17 U01_HolaMundo.cpp -o U01_HolaMundo
.\U01_HolaMundo
```

## Contacto

agu1406@outlook.es
