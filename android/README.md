# Android / Kotlin (PMDM) — Clases particulares

Módulo de **Programación Multimedia y Dispositivos Móviles** y Kotlin consola, organizado como `java/` (EV1–EV3).

Origen principal absorbido: CES Juan Pablo Segundo + repo ClasePMDM (DevelopSys / Borja).

## Examen con agente (CES)

Antes de cualquier otra cosa:

| Archivo | Uso |
|---------|-----|
| [`madrid/cesjuanpablosegundo/PROMPT_EXAMEN_AGENTE.md`](madrid/cesjuanpablosegundo/PROMPT_EXAMEN_AGENTE.md) | Pegar en turno 1 |
| [`madrid/cesjuanpablosegundo/PLAYBOOK_5_TURNOS.md`](madrid/cesjuanpablosegundo/PLAYBOOK_5_TURNOS.md) | Máximo 5 interacciones |
| [`madrid/cesjuanpablosegundo/referencia-estilo/`](madrid/cesjuanpablosegundo/referencia-estilo/) | Few-shot P1–P4 |
| [`.cursor/rules/estilo-profesor-kotlin-ces.mdc`](.cursor/rules/estilo-profesor-kotlin-ces.mdc) | Regla Cursor automática en `.kt` |

## Estructura

```
android/
├── .cursor/rules/
├── madrid/
│   ├── cesjuanpablosegundo/     # prompt + referencias estilo
│   └── convocatoria-extraordinaria-dam/
├── proyectos-generales/         # app reserva, híbrida, etc.
└── src/
    ├── ev1/ut1_fundamentoskotlin/   # U1–U4 Kotlin lenguaje
    ├── ev2/ut2_pookotlin/           # U5 + prácticas POO CES
    └── ev3/
        ├── ut3_androidpersistencia/ # SharedPreferences, archivos, SQLite
        └── ut4_androidui/           # teoría Android Java T1–T8 + diálogos
```

## EV1 — Kotlin fundamentos

| Subtema | Contenido |
|---------|-----------|
| `u01variablesvisibilidad` | var/val, null, visibilidad |
| `u02controlflujo` | if, when, bucles, menús |
| `u03funciones` | fun, defaults, lambdas |
| `u04colecciones` | Array, ArrayList, práctica pizarra |

## EV2 — POO Kotlin (estilo profesor)

Prácticas en `u01clasesherencia/practicas/`:

- `madridcesjuanpablosegundocentralita`
- `madridcesjuanpablosegundofiguras`
- `madridcesjuanpablosegundotrabajadores`
- `madridcesjuanpablosegundoalumnos`
- `madridcesjuanpablosegundoobjetosschool`

## EV3 — Android

- Persistencia: ejercicios migrados desde `ejercicios-codigo/`
- UI: teoría Markdown T01–T08 + proyecto `T05_Dialogos`

## Flutter

Módulo hermano: [`../flutter/`](../flutter/README.md)
