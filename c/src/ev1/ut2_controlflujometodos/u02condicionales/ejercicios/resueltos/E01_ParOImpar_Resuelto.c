/*
E01 - Par o impar (RESUELTO)

ENUNCIADO:
  Pide un entero y muestra si es par o impar.

EJEMPLO DE EJECUCION:
  Numero: 7
  7 es impar

PISTA:
  Un numero es par si n % 2 == 0.

SOLUCION:
  El resto de dividir entre 2 decide la rama del if/else.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    int n = 0;
    printf("Numero: ");
    scanf("%d", &n);
    if (n % 2 == 0) {
        printf("%d es par\n", n);
    } else {
        printf("%d es impar\n", n);
    }
    return 0;
}
