/*
E08 - Leer un caracter y mostrar la siguiente letra (RESUELTO)

ENUNCIADO:
  Pide una letra y muestra: la letra, su codigo ASCII y la letra siguiente.
  Acuerdate del espacio antes de %c para ignorar saltos de linea previos.

EJEMPLO DE EJECUCION:
  Letra: k
  Has escrito k (ASCII 107)
  La siguiente es l

PISTA:
  scanf(" %c", &letra);

SOLUCION:
  El espacio en el formato descarta blancos; despues letra + 1 da la siguiente.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    char letra = ' ';
    printf("Letra: ");
    scanf(" %c", &letra);
    printf("Has escrito %c (ASCII %d)\n", letra, letra);
    printf("La siguiente es %c\n", letra + 1);
    return 0;
}
