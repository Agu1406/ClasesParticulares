/*
E15 - Mayuscula, minuscula o digito (RESUELTO)

ENUNCIADO:
  Pide un caracter y clasificalo: mayuscula, minuscula, digito u otro simbolo.
  Si es letra muestra tambien su version contraria (mayuscula <-> minuscula) sin usar ctype.h.

EJEMPLO DE EJECUCION:
  Caracter: g
  Minuscula (mayuscula: G)

PISTA:
  La diferencia entre 'a' y 'A' es 32.

SOLUCION:
  Los rangos ASCII permiten clasificar sin librerias: 'a'..'z', 'A'..'Z', '0'..'9'.

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
    if (c >= 'A' && c <= 'Z') {
        printf("Mayuscula (minuscula: %c)\n", c + 32);
    } else if (c >= 'a' && c <= 'z') {
        printf("Minuscula (mayuscula: %c)\n", c - 32);
    } else if (c >= '0' && c <= '9') {
        printf("Digito\n");
    } else {
        printf("Otro simbolo\n");
    }
    return 0;
}
