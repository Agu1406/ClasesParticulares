/*
E23 - Piedra, papel o tijera (RESUELTO)

ENUNCIADO:
  Dos jugadores eligen una letra: p (piedra), a (papel), t (tijera). Muestra quien gana:
  piedra gana a tijera, tijera a papel y papel a piedra. Si coinciden: 'Empate'.

EJEMPLO DE EJECUCION:
  Jugadas: p t
  Gana el jugador 1

PISTA:
  Resuelve primero el empate y luego los tres casos en que gana el 1.

SOLUCION:
  Si no es empate y no gana el 1, gana el 2.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    char j1 = ' ', j2 = ' ';
    printf("Jugadas: ");
    scanf(" %c %c", &j1, &j2);
    if (j1 == j2) {
        printf("Empate\n");
    } else if ((j1 == 'p' && j2 == 't') || (j1 == 't' && j2 == 'a') || (j1 == 'a' && j2 == 'p')) {
        printf("Gana el jugador 1\n");
    } else {
        printf("Gana el jugador 2\n");
    }
    return 0;
}
