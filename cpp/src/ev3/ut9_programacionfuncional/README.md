# UT9 — Programación funcional (C++)

Equivalente a Java `ut9_programacionfuncional` / C# `ut9_linqfuncional` / Python `ut9_programacionfuncional`.

## Mapa de subtemas

| Unidad | Carpeta | Estado |
|--------|---------|--------|
| u01 | `u01lambda/` | **Completo** (teoría U01–U03 + E01–E10 pendientes/resueltos) |
| u02 | `u02algorithms/` | Esqueleto |
| u03 | `u03functional/` | Esqueleto |
| u04 | `u04principios/` | Esqueleto |
| u05 | `u05repaso/` | Esqueleto |

Empieza por `u01lambda/teoria/U01_LambdaIntro.cpp`.

Estándar: **C++17**. Compilar, por ejemplo:

```bash
g++ -std=c++17 -o demo U01_LambdaIntro.cpp
```

### u01lambda — contenido

**Teoría**

| Archivo | Tema |
|---------|------|
| `U01_LambdaIntro.cpp` | Lambdas `[]( ){ }`, `auto` / `std::function`, `count_if`, `sort` |
| `U02_AlgorithmSortCount.cpp` | `sort`, `count_if`, `find_if` |
| `U03_TransformAccumulate.cpp` | `transform`, `accumulate`, `copy_if` |

**Ejercicios E01–E10** (pares `*_Pendiente.cpp` / `*_Resuelto.cpp`)

| # | Nombre | Idea |
|---|--------|------|
| E01 | OrdenarPorLongitud | `sort` por `size()` |
| E02 | OrdenAlfabetico | `sort` natural |
| E03 | CountIfPares | `count_if` pares |
| E04 | FiltrarPrefijo | `copy_if` a otro vector (sin prefijo x) |
| E05 | TransformLongitudes | `transform` → longitudes |
| E06 | ForEachImprimir | `for_each` con `N=` |
| E07 | SortDescendente | `sort` mayor→menor |
| E08 | SortIgnoreCase | `sort` + `tolower` |
| E09 | AnyAllEquivalente | `any_of` / `all_of` |
| E10 | AccumulateSuma | `accumulate` suma |
