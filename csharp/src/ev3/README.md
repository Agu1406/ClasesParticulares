# EV3 — Programación avanzada (C#)

Equivalente a **Java EV3** (UT6–UT9). Misma idea pedagógica: herencia/polimorfismo → persistencia → web → LINQ/funcional.

**Familia espejo** con `java` / `python` / `cpp`. Fase A = estructura; Fase B = paridad de contenido.

## Mapa de unidades

| UT | Carpeta | Tema | Estado |
|----|---------|------|--------|
| **UT6** | `ut6_pooavanzadaestructuras/` | Herencia, polimorfismo, colecciones, concurrencia | **u01 completo** (+ prácticas CES); resto esqueleto |
| **UT7** | `ut7_persistenciaado/` | Persistencia con ADO.NET / SQLite | **u01sqlite completo**; resto esqueleto |
| **UT8** | `ut8_aspnet/` | ASP.NET Core (web) | **u01minimalapis completo**; u02 esqueleto |
| **UT9** | `ut9_linqfuncional/` | LINQ, delegates, programación funcional | **u01lambda completo**; resto esqueleto |

## Cómo estudiar UT6 u01 (herencia)

Orden pedagógico (no el número de carpeta):

1. **Herencia** — `U01_HerenciaIntro.cs` (`:`, `base`, `virtual`/`override`, `protected`)
2. **Polimorfismo** — `U02_PolimorfismoIntro.cs` (referencia de base, `is` / `as`)
3. **Abstracción** — `U03_AbstraccionIntro.cs` (`abstract class`)
4. **Interfaces** — `U04_InterfacesIntro.cs` (`interface` + implementación)

Empieza por `u01herenciapolimorfismo/teoria/U00_Indice.cs` y luego los ejercicios E01–E10.

Prácticas CES: `u01herenciapolimorfismo/practicas/madridcesjuanpablosegundo*`.

## Convención de código (igual EV2)

Cada `.cs` ejecutable usa:

- `public class Program` + `ImprimirMenu` + `Main`
- Menú `do-while` + `int.Parse` + salida con **0**
- Clases de dominio **fuera** de `Program` (mismo archivo, para `dotnet run --file`)

```powershell
dotnet run --file .\ruta\al\archivo.cs
```
