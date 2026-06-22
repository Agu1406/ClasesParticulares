# EV1 — Fundamentos Python (UT1–UT3)

## Ejercicios por bloque

Cada **subtema** (o UT3 a nivel de unidad) tiene **10 ejercicios** en:

- `ejercicios/pendientes/E01_…_Pendiente.py` … `E10_…_Pendiente.py`
- `ejercicios/resueltos/E01_…_Resuelto.py` … `E10_…_Resuelto.py`

**Total EV1:** 9 bloques × 10 = **90 ejercicios** (180 archivos).

| UT | Subtema | Carpeta ejercicios |
|----|---------|-------------------|
| UT1 | `u01entornopython` | `ut1_fundamentospython/u01entornopython/ejercicios/` |
| UT1 | `u02tiposvariables` | `ut1_fundamentospython/u02tiposvariables/ejercicios/` |
| UT1 | `u03inputcomentarios` | `ut1_fundamentospython/u03inputcomentarios/ejercicios/` |
| UT2 | `u01condicionales` | `ut2_controlflujometodos/u01condicionales/ejercicios/` |

### Condicionales — teoria y tipos de ejercicio

| Teoria | Contenido |
|--------|-----------|
| `U01_IfIntro` | `if` solo |
| `U02_IfElseIntro` | `if` / `elif` / `else`, ternario |
| `U03_MatchCaseIntro` | `match` / `case` (switch Python 3.10+) |
| `U04_CondicionalesAnidadasIntro` | anidados, `and` / `or` / `not` |

| Ejercicio | Tipo |
|-----------|------|
| E01–E04 | `if`, `elif`, `else` |
| E05 | `if` sin `else` |
| E06 | `and` |
| E07 | `if` + `in` |
| E08–E09 | `match` / `case` |
| E10 | operador ternario |

| UT2 | `u02bucles` | `ut2_controlflujometodos/u02bucles/ejercicios/` |
| UT2 | `u03funciones` | `ut2_controlflujometodos/u03funciones/ejercicios/` |
| UT2 | `u04excepciones` | `ut2_controlflujometodos/u04excepciones/ejercicios/` |
| UT2 | `u05repaso` | `ut2_controlflujometodos/u05repaso/ejercicios/` |
| UT3 | (unidad) | `ut3_strings/ejercicios/` |

## Teoria

Ver bloques `teoria/U##_*.py` en cada subtema (UT3: `ut3_strings/teoria/`).

**Convencion didactica EV1:** en cada archivo de teoria, encima de cada linea que usa una funcion o metodo (`print()`, `int()`, `.strip()`, `range()`, etc.) hay un comentario `#` explicando que hace. Es la primera vez del alumno con Python.

## Regenerar ejercicios

```powershell
python python/ignorar/scripts/generar_ejercicios_ev1_completo.py
python python/ignorar/scripts/generar_ejercicios_condicionales.py
```

## Practicas

Sin practicas inventadas en EV1. Material real de centro en EV2 UT4 (Sevilla gestor).

## Ejemplo de uso

```powershell
cd python/src/ev1/ut2_controlflujometodos/u02bucles/ejercicios/pendientes
python E03_SumaUnoADiez_Pendiente.py
# comparar con resueltos/E03_SumaUnoADiez_Resuelto.py
```
