/*
E27 - Vocal en mayuscula (PENDIENTE)

ENUNCIADO:
  Pide un caracter. Si es vocal MAYUSCULA (A E I O U) muestra Vocal mayuscula; si es vocal minuscula, Vocal minuscula; si es otra letra, Otra letra; si no es letra, No es letra.

EJEMPLO DE EJECUCION:
  Letra: A
  Vocal mayuscula

PISTA:
  Usa ctype.h: isalpha, toupper, o compara a mano.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>
#include <ctype.h>

int main(void) {
    char c = ' ';
    printf("Letra: ");
    scanf(" %c", &c);
    // TODO: clasifica
    return 0;
}
