/*
Ej1 - Link y los corazones (PENDIENTE)
UCAM Primer parcial - Completar codigo. PDF: Ej1_Completar.pdf

Sustituye cada marca TODO (1)..(8) por la expresion correcta del examen.
Ahora compila, pero la logica esta incompleta a proposito.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

#define CUARTOS 4 /* un corazon son cuatro cuartos */
#define GOLPE 3   /* un golpe quita tres cuartos */

int main(void) {
    int vida = 3 * CUARTOS, maximo = 3 * CUARTOS;
    char evento;

    printf("Evento (G golpe, C corazon, F fin): ");
    scanf(" %c", &evento);
    while (1 /* TODO (1): condicion mientras no sea F */) {
        switch (evento) {
            case 'G':
                vida = vida; /* TODO (2): restar GOLPE */
                break;
            case 'C':
                vida = vida; /* TODO (3): sumar CUARTOS */
                if (0 /* TODO (4): se pasa del maximo */)
                    vida = vida; /* TODO (5): topar en maximo */
                break;
            default:
                printf("Evento desconocido\n");
        }
        if (0 /* TODO (6): vida agotada */) {
            printf("GAME OVER\n");
            break;
        }
        printf("Corazones: %d y %d/4 (maximo: %d)\n",
               0 /* TODO (7): corazones enteros */,
               0 /* TODO (8): cuartos restantes */,
               maximo / CUARTOS);
        printf("Evento (G golpe, C corazon, F fin): ");
        scanf(" %c", &evento);
    }
    printf("Fin de la partida\n");
    return 0;
}
