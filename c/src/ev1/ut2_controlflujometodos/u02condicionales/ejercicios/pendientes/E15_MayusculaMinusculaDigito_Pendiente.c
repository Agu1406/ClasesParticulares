/*
E15 - Mayuscula, minuscula o digito (PENDIENTE)

ENUNCIADO:
  Pide un caracter y clasificalo: mayuscula, minuscula, digito u otro simbolo.
  Si es letra muestra tambien su version contraria (mayuscula <-> minuscula) sin usar ctype.h.

EJEMPLO DE EJECUCION:
  Caracter: g
  Minuscula (mayuscula: G)

PISTA:
  La diferencia entre 'a' y 'A' es 32.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    char c = ' ';
    printf("Caracter: ");
    scanf(" %c", &c);
    // TODO: clasifica el caracter y muestra su contrario si es letra
    return 0;
}
