# Examen UNED — Septiembre 2025 (recuperación)

PDF: [`../../../../madrid/uned/madrid-uned-pp-exam-sep-2025-recu.pdf`](../../../../madrid/uned/madrid-uned-pp-exam-sep-2025-recu.pdf)

| Fichero | Contenido |
|---------|-----------|
| `Problema1_Pendiente.c` / `_Resuelto.c` | 2 estáticos, 1 hijo cada uno; token entre hijos |
| `Problema2_Pendiente.c` / `_Resuelto.c` | N estáticos, cada uno M hijos; arrays y suma colectiva |

```bash
mpicc -Wall -o p1 Problema1_Resuelto.c && mpirun -np 2 ./p1
mpicc -Wall -o p2 Problema2_Resuelto.c && mpirun -np 3 ./p2
```
