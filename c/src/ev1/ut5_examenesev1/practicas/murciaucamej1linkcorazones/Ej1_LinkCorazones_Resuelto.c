/*
Ej1 - Link y los corazones (RESUELTO)
UCAM Primer parcial - Completar codigo. PDF: Ej1_Completar.pdf / Completar_Soluciones.pdf

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
    while (evento != 'F') {
        switch (evento) {
            case 'G':
                vida = vida - GOLPE;
                break;
            case 'C':
                vida = vida + CUARTOS;
                if (vida > maximo)
                    vida = maximo;
                break;
            default:
                printf("Evento desconocido\n");
        }
        if (vida <= 0) {
            printf("GAME OVER\n");
            break;
        }
        printf("Corazones: %d y %d/4 (maximo: %d)\n",
               vida / CUARTOS, vida % CUARTOS, maximo / CUARTOS);
        printf("Evento (G golpe, C corazon, F fin): ");
        scanf(" %c", &evento);
    }
    printf("Fin de la partida\n");
    return 0;
}
