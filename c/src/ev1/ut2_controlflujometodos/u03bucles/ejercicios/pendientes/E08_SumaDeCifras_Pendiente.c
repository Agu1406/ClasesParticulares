/*
E08 - Suma de las cifras (PENDIENTE)

ENUNCIADO:
  Pide un entero positivo y calcula la suma de sus cifras con un while (% 10 y / 10).

EJEMPLO DE EJECUCION:
  Numero: 48291
  Suma de cifras: 24

PISTA:
  Mientras n > 0: suma n % 10 y quita la ultima cifra.

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
    int suma = 0;
    // TODO: suma las cifras con un while
    printf("Suma de cifras: %d\n", suma);
    return 0;
}
