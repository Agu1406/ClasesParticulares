# UT9 — LINQ y programación funcional

Equivalente a Java `ut9_programacionfuncional` / Python `ut9_programacionfuncional` / C++ `ut9_programacionfuncional`.

## Mapa de subtemas

| Unidad | Carpeta | Estado |
|--------|---------|--------|
| u01 | `u01lambda/` | **Completo** (teoría U01–U03 + E01–E12 pendientes/resueltos) |
| u02 | `u02linq/` | Esqueleto |
| u03 | `u03delegates/` | Esqueleto |
| u04 | `u04principios/` | Esqueleto |
| u05 | `u05repaso/` | Esqueleto |

Empieza por `u01lambda/teoria/U01_LambdaIntro.cs`.

### u01lambda — contenido

**Teoría**

| Archivo | Tema |
|---------|------|
| `U01_LambdaIntro.cs` | Expresiones lambda, `Action`, `Func` |
| `U02_LinqWhereSelect.cs` | LINQ `Where`, `Select`, `OrderBy` sobre `List<T>` |
| `U03_DelegatesFuncAction.cs` | Delegates, `Func`, `Action`, `Predicate` |

**Ejercicios E01–E12** (pares `*Pendiente.cs` / `*Resuelto.cs`)

| # | Nombre | Idea |
|---|--------|------|
| E01 | OrdenarPorLongitud | `OrderBy(x => x.Length)` |
| E02 | OrdenAlfabetico | `OrderBy(x => x)` |
| E03 | ActionLambda | `Action` sin parámetros |
| E04 | FiltrarPrefijo | `Where` / `RemoveAll` prefijo x |
| E05 | SelectLongitudes | `Select(x => x.Length)` |
| E06 | ForEachImprimir | `ForEach` / `Action<T>` |
| E07 | FuncMensaje | `Func<string>` (supplier) |
| E08 | CalculadoraMultiplicar | `Func<int,int,int>` |
| E09 | SortDescendente | `OrderByDescending` |
| E10 | SortIgnoreCase | orden ignore case |
| E11 | PredicadoVacia | `Predicate<string>` vacía |
| E12 | PredicadoMayuscula | `Predicate<char>` mayúscula |
