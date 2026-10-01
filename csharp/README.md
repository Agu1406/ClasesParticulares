# C# — Clases particulares

Material de C# / .NET organizado **como `java/` y `python/`**: evaluaciones **EV1–EV3**, unidades **UT1–UT9**, subtemas `u01…`, `teoria/`, `ejercicios/`, `practicas/`.

**Objetivo del repo:** paridad pedagógica con el módulo 0485 en Java (`../java/`) y con Python (`../python/`), adaptado a CLR, SDK .NET y APIs de C#.

**Familia espejo:** `java` ↔ `python` ↔ `csharp` ↔ `cpp`. Canon de carpetas/nombres: [`../java/README.md`](../java/README.md).

- **Fase A (hecha):** estructura EV1–EV3 alineada; prácticas CES en `ev3/ut6/…`.
- **Fase B (en curso):** UT7 `u01sqlite` + UT8 `u01minimalapis` + UT9 `u01lambda`. Pendiente: ampliar u02+ de cada UT.

## Requisitos

- .NET SDK 8.0+ (recomendado)
- IDE: Visual Studio, Rider o VS Code + C# Dev Kit

## Estructura

```
csharp/
├── README.md
└── src/
    ├── ev1/    UT1–UT3   (fundamentos, control, strings)
    ├── ev2/    UT4–UT5   (colecciones + POO/excepciones/IO)
    └── ev3/    UT6–UT9   (herencia + CES, ADO.NET, ASP.NET, LINQ)
```

### Mapa UT ↔ Java / Python

| UT | Carpeta C# | Equivalente Java | Notas |
|----|------------|------------------|-------|
| **UT1** | `ut1_fundamentoscsharp` | `ut1_fundamentosjava` | SDK, Console, tipos |
| **UT2** | `ut2_controlflujometodos` | `ut2_controlflujometodos` | if/switch, bucles, métodos |
| **UT3** | `ut3_strings` | `ut3_stringsyenvolventes` | string, interpolación, StringBuilder (Split/Join en EV2: arrays) |
| **UT4** | `ut4_colecciones` | `ut4_colecciones` | arrays, List, Dictionary |
| **UT5** | `ut5_pooexcepcionesio` | `ut5_pooexcepcionesio` | clases, try/catch, File (sin GUI) |
| **UT6** | `ut6_pooavanzadaestructuras` | igual | herencia + prácticas CES en u01; resto esqueleto |
| **UT7** | `ut7_persistenciaado` | `ut7_persistenciajdbcapi` | **u01sqlite** (ADO + Microsoft.Data.Sqlite); resto esqueleto |
| **UT8** | `ut8_aspnet` | `ut8_frameworksspring` | **u01minimalapis** (espejo Flask); u02 esqueleto |
| **UT9** | `ut9_linqfuncional` | `ut9_programacionfuncional` | **u01lambda** (teoría+E01–E12); resto esqueleto |

### Convención (igual que Java/Python)

- **UT:** `ut{N}_{nombre}`
- **Subtema:** `u{NN}{nombre}`
- **Teoría:** `U{NN}_{Nombre}.cs` ejecutables con explicación en comentario de bloque
- **Ejercicios:** `E{NN}_*_Pendiente.cs` / `_Resuelto.cs`
- **Prácticas de centro:** carpeta `{comunidad}{centro}{nombre}` sin guiones; ficheros `NombrePendiente.cs` / `NombreResuelto.cs` (PascalCase)

### Prácticas CES (Juan Pablo Segundo)

En `ev3/ut6_pooavanzadaestructuras/u01herenciapolimorfismo/practicas/` (misma ruta relativa que Java/Python/C++):

- `madridcesjuanpablosegundocentralita` — `CentralitaPendiente.cs` / `CentralitaResuelto.cs`
- `madridcesjuanpablosegundofiguras` — `FigurasPendiente.cs` / `FigurasResuelto.cs`
- `madridcesjuanpablosegundotrabajadores` — `TrabajadoresPendiente.cs` / `TrabajadoresResuelto.cs`
- `madridcesjuanpablosegundoalumnos` — `AlumnosPendiente.cs` / `AlumnosResuelto.cs`

### Formato de ejercicios (desde `u04metodos` en adelante)

Desde **EV1 `ut2_controlflujometodos/u04metodos`**, los ejercicios `_Pendiente.cs` y `_Resuelto.cs` usan un **menú `do-while`** con entrada por teclado.

**EV1:** no se usan **arrays** ni colecciones (se introducen en EV2). **EV3** sigue el mismo formato de menú que EV2 (`class Program` + `Main`).

### Formato EV2 / EV3 (class + Main)

Toda **EV2** y **EV3** (teoría y ejercicios) usa `public class Program` + `static void Main()` + menú:

```csharp
public class Program
{
    static void ImprimirMenu() { /* 1..N y 0 salir */ }

    static void Main()
    {
        int opcion;
        do
        {
            ImprimirMenu();
            Console.Write("Introduce una opcion -> ");
            opcion = int.Parse(Console.ReadLine()!);
            switch (opcion) { /* demos / práctica */ }
        } while (opcion != 0);
    }
}
```

- Opción **0** = salir.
- Teoría: cada demo es un `case` + método `static void DemoXxx()`.
- Ejercicios: opción 1 = ejecutar/trabajar, 2 = ver objetivo, 0 = salir.
- POO: clases de dominio (`Persona`, etc.) **fuera** de `Program`.

### Cómo ejecutar un fichero

Con **.NET 10+**, los `.cs` sueltos se ejecutan como *file-based apps* (`dotnet run --file Archivo.cs`). EV1 (antes de métodos) usa a menudo *top-level statements*; EV2 usa siempre `class` + `Main`.

#### Botón Play

Abre la carpeta **`csharp/`** como workspace (File → Open Folder), no solo un archivo suelto.

**VS Code (recomendado):** instala **C#** + **C# Dev Kit** (`ms-dotnettools.csharp`, `ms-dotnettools.csdevkit`). Abre un `.cs` y usa el ▶ arriba a la derecha o **F5**.

**Cursor:** C# Dev Kit no está disponible. Usa **Code Runner** (`formulahendry.code-runner`): ▶ arriba a la derecha o **Ctrl+Alt+N**.

**Ambos editores (sin extensiones extra):** *Terminal → Run Task* → `Ejecutar .cs actual`, o **Ctrl+Shift+B**.

#### Terminal

```powershell
dotnet run --file U01_If.cs
# o, en la carpeta del archivo:
dotnet run U01_If.cs
```

## Contacto

agu1406@outlook.es
