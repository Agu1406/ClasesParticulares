# Examen UNED — Septiembre 2026 (recuperación)

PDF: [`../../../../madrid/uned/madrid-uned-pp-exam-sep-2026-recu.pdf`](../../../../madrid/uned/madrid-uned-pp-exam-sep-2026-recu.pdf)

| Fichero | Contenido |
|---------|-----------|
| `Problema1_Pendiente.c` / `_Resuelto.c` | 1 estático, N hijos, anillo descendente + gather/suma |
| `Problema2_Pendiente.c` / `_Resuelto.c` | 100 hijos, intercomms ×2 y ×3 |

```bash
mpicc -Wall -o p1 Problema1_Resuelto.c && mpirun -np 1 ./p1
# P1 pide N por argv o define N_HIJOS; por defecto 4
mpicc -Wall -o p2 Problema2_Resuelto.c && mpirun -np 1 ./p2
```
