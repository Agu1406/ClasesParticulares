/*
E08 - Suma de las cifras (RESUELTO)

ENUNCIADO:
  Pide un entero positivo y calcula la suma de sus cifras con un while (% 10 y / 10).

EJEMPLO DE EJECUCION:
  Numero: 48291
  Suma de cifras: 24

PISTA:
  Mientras n > 0: suma n % 10 y quita la ultima cifra.

SOLUCION:
  Cada vuelta aisla la ultima cifra y la elimina del numero.

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
    while (n > 0) {
        suma += n % 10;
        n /= 10;
    }
    printf("Suma de cifras: %d\n", suma);
    return 0;
}
