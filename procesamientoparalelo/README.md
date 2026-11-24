# Procesamiento Paralelo (UNED) — MPI en C

Temario propio para dar clase (mismo estilo que [`c/`](../c/README.md): teoría proyectable, ejercicios `_Pendiente` / `_Resuelto`, prácticas de centro).

**Asignatura:** Procesamiento Paralelo · código **71023051** · Grado en Ingeniería en Tecnologías de la Información (UNED).

**Foco de clase:** **MPI en C** (lo que cae en la prueba presencial). PVM/arquitecturas solo se mencionan; no se machacan aquí.

Material oficial del centro: [`madrid/uned/`](madrid/uned/) (guía, práctica 2026-27, exámenes sep 2025/2026).

## Si es vuestra primera vez con MPI (profesor o alumno)

1. Leed **[`MPI_DESDE_CERO.md`](MPI_DESDE_CERO.md)** (10–15 min): qué es, analogía, vocabulario, spawn.
2. Empezad solo por UT1 y UT2 con comentarios “junior” en los `.c`.
3. Spawn (UT4) **después** de Send/Recv; si no, confunde.
4. Ejecutar: idealmente en la **VM UNED**. En Windows a menudo no hay `mpicc` instalado.

## Requisitos

- Compilador MPI: `mpicc` + `mpirun` (máquina VirtualBox del curso UNED, o Open MPI / MPICH en local)
- Editor: Cursor / VS Code / lo que haya en la VM

```bash
mpicc -Wall -o prog prog.c
mpirun -np 4 ./prog
```

En Windows (MS-MPI) a veces es `mpiexec -n 4 prog.exe`. En la VM UNED suele bastar `mpirun`.

## Cómo dar clase mañana (~90–120 min)

Abre la carpeta **`procesamientoparalelo/`** como workspace.

| Minuto | Qué hacer | Dónde |
|--------|-----------|--------|
| 0–15 | Proyectar Hola MPI + rank/size. Compilar y `mpirun -np 4`. | `src/ut1_…/u01entorno` y `u02procesosrangos` |
| 15–35 | Send/Recv; alumno intenta el anillo pendiente. | `src/ut2_…/u01sendrecv` + `u02anillo` |
| 35–55 | **Spawn** (el que más se atasca): padre/hijo, `get_parent`. | `src/ut4_…/u01spawnparent` |
| 55–70 | Colectivas: Bcast / Scatter / Gather / Reduce. | `src/ut3_…/u01bcastscattergatherreduce` |
| 70–100 | Exámenes sep 2025 y 2026: recorrer `_Resuelto`, explicar diseño. | `src/ut6_examenes/practicas/` |
| Si sobra | Práctica ej1 (anillo sentido aleatorio). | `madridunedpractica202627` |

Orden pedagógico: **UT1 → UT2 → UT4 → UT3 → UT5 → UT6**. En clase mañana puedes saltar UT5 si el tiempo aprieta y dejarlo tras el primer examen.

## Estructura

```text
procesamientoparalelo/
├── README.md
├── madrid/uned/                 ← PDF oficiales (guía, práctica, exámenes)
└── src/
    ├── ut1_introduccionmpi/
    ├── ut2_puntopunto/
    ├── ut3_colectivas/
    ├── ut4_procesosdinamicos/
    ├── ut5_intercomunicadores/
    └── ut6_examenes/practicas/
```

Cada subtema: `teoria/` (`U01_…c`), `ejercicios/pendientes/` y `ejercicios/resueltos/`.

## Mapa rápido de UTs

| UT | Tema | Sirve para |
|----|------|------------|
| UT1 | Init, Finalize, rank, size | Arranque |
| UT2 | Send/Recv, tags, anillo | Examen 2026 P1, práctica ej1 |
| UT3 | Bcast, Scatter, Gather, Reduce | Examen 2025 P2, finales de anillo |
| UT4 | `MPI_Comm_spawn`, `get_parent` | Casi todos los problemas de examen |
| UT5 | Grupos + intercomunicadores | Examen 2026 P2, práctica ej3 |
| UT6 | Exámenes y práctica UNED resueltos | Machacar prueba presencial |

## Autor

Agustin. A. Marquez. Pina · https://github.com/Agu1406/ClasesParticulares
