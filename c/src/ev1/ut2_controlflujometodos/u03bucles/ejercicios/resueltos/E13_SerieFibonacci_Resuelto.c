/*
E13 - Serie de Fibonacci (RESUELTO)

ENUNCIADO:
  Pide cuantos terminos (1 a 90) y muestralos: 0 1 1 2 3 5 ... Usa long long.

EJEMPLO DE EJECUCION:
  Terminos: 10
  0 1 1 2 3 5 8 13 21 34

PISTA:
  Guarda los dos ultimos terminos y calcula el siguiente.

SOLUCION:
  En cada vuelta se imprime el termino actual y se desplazan las dos variables.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    int n = 0;
    printf("Terminos: ");
    scanf("%d", &n);
    long long a = 0, b = 1;
    for (int i = 0; i < n; i++) {
        printf("%lld ", a);
        long long siguiente = a + b;
        a = b;
        b = siguiente;
    }
    printf("\n");
    return 0;
}
