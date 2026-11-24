# Práctica UNED 2026-27 — Ejercicio 2 (factoriales)

Solo el comportamiento del enunciado (maestro, spawn, cola, 1000 factoriales).

| Fichero | Rol |
|---------|-----|
| `Ej2_Factoriales_Pendiente.c` | Alumno (TODOs) |
| `Ej2_Factoriales_Resuelto.c` | Solución mínima |

```bash
mpicc -Wall -o ej2 Ej2_Factoriales_Resuelto.c && mpirun -np 1 ./ej2
```

Aviso: 1000 números con `sleep(1)` tarda ~17+ minutos (lo pide el enunciado).
