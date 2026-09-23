# C++ — Clases particulares

Material de C++ organizado **como `java/`, `python/` y `csharp/`**: evaluaciones **EV1** (UT1–UT3), subtemas `u01…`, `teoria/`, `ejercicios/`.

**Objetivo del repo:** paridad pedagógica con el módulo 0485 en Java (`../java/`), con Python (`../python/`) y con C# (`../csharp/`), adaptado a compilador, `iostream` y la STL.

El material de centro UAX permanece en `madrid/` (proyectos C con CMake). No forma parte de Ev1.

## Requisitos

- Compilador **g++** con **C++17** (MinGW/MSYS2, o el g++ de tu distro)
- IDE: VS Code, Cursor, CLion o Visual Studio

## Estructura

```
cpp/
├── README.md
├── madrid/              ← UAX (C + CMake; no se toca)
└── src/
    ├── ev1/             UT1–UT3   (fundamentos, control, strings)
    └── ev2/             practicas CES (herencia) — ver src/ev2/README.md
```

**EV2** incluye practicas espejo CES Juan Pablo Segundo (centralita, figuras, trabajadores, alumnos) en `ut6_pooavanzadaestructuras/u01herenciapolimorfismo/practicas/`. **EV3** aún no existe.

### Mapa UT ↔ Java / Python / C#

| UT | Carpeta C++ | Equivalente Java | Notas |
|----|-------------|------------------|-------|
| **UT1** | `ut1_fundamentoscpp` | `ut1_fundamentosjava` | g++, `cout`/`cin`, tipos |
| **UT2** | `ut2_controlflujometodos` | `ut2_controlflujometodos` | if/switch, bucles, funciones |
| **UT3** | `ut3_strings` | `ut3_stringsyenvolventes` | `std::string` mutable (sin StringBuilder) |

### Convención (igual que Java/Python/C#)

- **UT:** `ut{N}_{nombre}`
- **Subtema:** `u{NN}{nombre}`
- **Teoría:** `U{NN}_{Nombre}.cpp` ejecutables con explicación en comentario de bloque
- **Ejercicios:** `E{NN}_*_Pendiente.cpp` / `_Resuelto.cpp`
- **Sin `practicas/`** en Ev1 (el material UAX está en `madrid/`)

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
- **EV1:** no se usan **arrays**, punteros, `new` ni ficheros (se introducen en EV2).
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
