# Python — Clases particulares

Material de Python organizado **como `java/`**: evaluaciones **EV1–EV3**, unidades **UT1–UT9** continuas, subtemas `u01…`, `teoria/`, `ejercicios/`, `practicas/`.

**Normativa de referencia:** curso de especialización RD 566/2024 (`BOE-2024-06-20-RD-566-curso-especializacion-python.md`). **Objetivo del repo:** profundidad y extensión **equivalente o superior** al módulo 0485 en Java (`../java/`), no limitarse al mínimo de 215 h del BOE estatal.

## Requisitos

- Python 3.10+ (recomendado 3.11 o 3.12)
- IDE: VS Code, PyCharm o IntelliJ (`src/` = Sources Root)

## Estructura

```
python/
├── BOE-2024-06-20-RD-566-curso-especializacion-python.md
├── README.md
├── sevilla/                    ← depósito original (PDFs ya copiados a practicas/)
└── src/
    ├── ev1/    UT1–UT3   (fundamentos, control, strings)
    ├── ev2/    UT4–UT5   (colecciones + datos, POO/IO)
    └── ev3/    UT6–UT9   (POO avanzada, persistencia, web, PF)
```

### Mapa UT ↔ Java (paridad)

| UT | Carpeta Python | Equivalente Java | Estado material |
|----|----------------|------------------|-----------------|
| **UT1** | `ut1_fundamentospython` | `ut1_fundamentosjava` | Teoría U01–U03 |
| **UT2** | `ut2_controlflujometodos` | `ut2_controlflujometodos` | Teoría U04–U09 |
| **UT3** | `ut3_strings` | `ut3_stringsyenvolventes` | U01 strings (inicio) |
| **UT4** | `ut4_colecciones` | `ut4_colecciones` + NumPy/pandas (5101) | U10–U13; práctica Sevilla gestor |
| **UT5** | `ut5_pooexcepcionesio` | `ut5_pooexcepcionesio` | `tiendacompra`; pendiente POO completa |
| **UT6** | `ut6_pooavanzadaestructuras` | `ut6_pooavanzadaestructuras` | PDF ampliación Sevilla |
| **UT7** | `ut7_persistenciaapi` | `ut7_persistenciajdbcapi` | Esqueleto (`sqlite3`, SQL) |
| **UT8** | `ut8_frameworksweb` | `ut8_frameworksspring` | Esqueleto (Flask/FastAPI) |
| **UT9** | `ut9_programacionfuncional` | `ut9_programacionfuncional` | Esqueleto (`pf/`) |

### Convención (igual que Java)

- **UT:** `ut{N}_{nombre}` (`ut4_colecciones`, `ut5_pooexcepcionesio`, …).
- **Subtema:** `u{NN}{nombre}` (`u01listas`, `u02excepciones`, …).
- **Último subtema de cada UT:** `u{NN}_examenes` o `u{NN}_repaso` según bloque.
- **Teoría:** `U{NN}_{NombreIntro}.py` ejecutables con explicación en docstring.
- **Ejercicios:** `ejercicios/pendientes/` y `resueltos/` — pares `E{NN}_*_Pendiente.py` / `_Resuelto.py` (por crear, como en Java).
- **Prácticas de centro:** carpeta `sevillaiesvelazquez{nombre}/`, PDF `sevilla-iesvelazquez-{nombre}.pdf` en la raíz del proyecto.

### Material Sevilla (IES Velázquez)

| Enunciado | Ubicación en `src/` |
|-----------|---------------------|
| Gestor de tareas básico | `ev2/ut4_colecciones/u01listas/practicas/sevillaiesvelazquezgestortareasbasico/` |
| Ejercicio ampliación Python | `ev3/ut6_pooavanzadaestructuras/u01herenciapolimorfismo/practicas/sevillaiesvelazquezejercicioampliacionpython/` |

Origen: `python/sevilla/documentos/` (copia de referencia).

## Módulos BOE 566/2024 → UT

| Código BOE | Contenido | UT principal |
|------------|-----------|--------------|
| 5098 | Entornos y sintaxis | UT1 |
| 5099 | Estructuras de control | UT2 |
| 5100 | POO | UT5 (+ UT6) |
| 5101 | Análisis de datos | UT4 (`u04numpy`, `u05pandas`) |

## Roadmap (igualar volumen Java)

- [x] Estructura UT1–UT9 y subtemas espejo de Java
- [x] Migrar teoria U01–U13 y prácticas existentes
- [x] Incorporar PDFs Sevilla en `practicas/`
- [ ] Diagnóstico de nivel (`src/diagnostico/`, como Java)
- [ ] Ejercicios pendientes/resueltos por subtema (meta: paridad con ~300+ ficheros Java de EV1–EV2)
- [ ] UT3 strings completa, UT5 POO con clases, UT7 sqlite, UT8 Flask, UT9 lambda/map/filter
- [ ] Prácticas Sevilla Java portadas o equivalentes (alquiler → UT6, colegio → UT7)

## Ejecutar

```powershell
cd python/src/ev1/ut1_fundamentospython/u02tiposvariables/teoria
python U01_VariablesIntro.py
```

## Contacto

agu1406@outlook.es
