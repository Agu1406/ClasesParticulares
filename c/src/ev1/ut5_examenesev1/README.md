# UT5 — Examenes EV1 (UCAM / parcial)

Ultima unidad de **EV1**: modelos de examen practico escrito (C11), no temario nuevo.

## Prioridad de clase: “el juego”

Si el alumno dice que lo importante es **el juego**, se refiere al **Ejercicio 1 del parcial**:

- *The Legend of Zelda* — vida de Link (corazones / cuartos, G/C/F, GAME OVER).
- Carpeta: [`practicas/murciaucamej1linkcorazones/`](practicas/murciaucamej1linkcorazones/)
- Ya tiene `_Pendiente.c` y `_Resuelto.c` + `Ej1_Completar.pdf`.

## Practicas (una carpeta = una practica)

| Carpeta | Que es |
|---------|--------|
| `practicas/murciaucamej1linkcorazones/` | Ej1 Link / Zelda (**el juego**) |
| `practicas/murciaucamej2ligarobotica/` | Ej2 liga de robotica (menu) |
| `practicas/murciaucamsimulacrofinal/` | Simulacro: primos gemelos + rover Marte |

PDFs compartidos (guia, compendio, soluciones Completar, soluciones Simulacro): [`documentos/`](documentos/).

## Compilar

```powershell
gcc -std=c11 -Wall -Wextra -pedantic Ej1_LinkCorazones_Pendiente.c -o ej1
.\ej1
```
