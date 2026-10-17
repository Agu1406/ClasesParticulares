/*
E11 - Ultima cifra y numero sin ultima cifra (PENDIENTE)

ENUNCIADO:
  Para n = 98765 muestra su ultima cifra (con %) y el numero sin ella (con /).

EJEMPLO DE EJECUCION:
  Ultima cifra: 5
  Sin la ultima cifra: 9876

PISTA:
  n % 10 da la ultima cifra y n / 10 quita la ultima cifra.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    int n = 98765;
    // TODO: calcula la ultima cifra y el numero acortado
    int ultima = 0;
    int resto_numero = 0;
    printf("Ultima cifra: %d\n", ultima);
    printf("Sin la ultima cifra: %d\n", resto_numero);
    return 0;
}
