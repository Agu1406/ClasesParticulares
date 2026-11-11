<!--
OBJETIVO: Solución modelo relacional sedes/complejos + ISA para proyectar en clase.
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
-->

# E03 — Relacional sedes / complejos (RESUELTO)

## Lectura del E/R (pág. 3)

| Relación | Cardinalidad adoptada | Consecuencia |
|----------|----------------------|--------------|
| SEDES — Dividen — COMPLEJOS | 1 : N | `id_sede` FK en COMPLEJOS |
| COMPLEJOS — Celebra — EVENTOS | 1 : N | `id_complejo` FK en EVENTOS |
| EVENTOS — Involucrado — COMISARIOS | N : M (+ **Tarea**) | tabla puente |
| Areas (débil) de POLIDEPORTIVO | 1 : N | PK incluye `id_complejo` |
| ISA COMPLEJOS | total / disjunta | UNIC.DEPORTE \| POLIDEPORTIVO |

Restricciones del texto:

- `jefe_organizacion` → **UNIQUE**
- `n_complejos` (en SEDES), `n_comisarios` y `n_participantes` (en EVENTOS) → **NOT NULL**

## Cómo se resuelve la ISA

**Opción elegida: tabla superclase + tablas de subtipos** (recomendable en examen).

- `COMPLEJOS`: datos comunes a todos.
- `UNIC_DEPORTE`: PK = FK a COMPLEJOS (1:1).
- `POLIDEPORTIVO`: PK = FK a COMPLEJOS (1:1).
- `AREAS` solo cuelga de POLIDEPORTIVO.

Disjunta: un complejo no está a la vez en ambas subtablas.  
Total: todo complejo está en exactamente una (en la práctica se controla por aplicación/trigger; en el modelo se documenta).

Otras opciones válidas si el alumno las justifica:

- Una sola tabla + discriminador `tipo`.
- Solo subtablas (repetir atributos comunes).

## Esquema relacional

Notación: **PK**, **FK**, **NN** = NOT NULL, **UQ** = UNIQUE.

```text
SEDES (
  id_sede        PK,
  n_complejos    NN,          -- requisito enunciado
  presupuesto
)

COMPLEJOS (
  id_complejo       PK,
  localizacion,
  area_ocupada,
  jefe_organizacion UQ NN,    -- “no dos jefes iguales”
  id_sede           NN FK → SEDES
)

UNIC_DEPORTE (
  id_complejo  PK FK → COMPLEJOS
  -- atributos propios del subtipo si el centro los pide;
  -- el diagrama no añade más óvalos
)

POLIDEPORTIVO (
  id_complejo  PK FK → COMPLEJOS
)

AREAS (  -- entidad DÉBIL
  id_complejo  NN FK → POLIDEPORTIVO,
  id_area      NN,              -- discriminante / clave parcial
  localizacion,
  PRIMARY KEY (id_complejo, id_area)
)

EVENTOS (
  id_evento         PK,
  fecha,
  duracion,
  n_comisarios      NN,         -- requisito enunciado
  n_participantes   NN,         -- requisito enunciado
  id_complejo       NN FK → COMPLEJOS
)

COMISARIOS (
  id_comisario   PK,
  nombre,
  nacionalidad,
  telefono
)

INVOLUCRADO (  -- N:M EVENTOS–COMISARIOS + atributo Tarea
  id_evento      NN FK → EVENTOS,
  id_comisario   NN FK → COMISARIOS,
  tarea          NN,
  PRIMARY KEY (id_evento, id_comisario)
)
```

## Diagrama relacional resumido

```text
SEDES 1 ──< COMPLEJOS 1 ──< EVENTOS >──< INVOLUCRADO >──< COMISARIOS
                │
                ├── UNIC_DEPORTE (1:1)
                └── POLIDEPORTIVO 1 ──< AREAS
```

## Notas de corrección

- Si Areas se modela como fuerte sin FK al polideportivo → **incorrecto**.
- Si Involucrado no tiene `tarea` → falta el atributo de la relación.
- Si `jefe_organizacion` no es UQ → incumple el enunciado.
- Celebra: cada evento en un solo complejo → FK en EVENTOS, no tabla puente.
