/*
E08 - Imprimir de 1 a N con una funcion (RESUELTO)

ENUNCIADO:
  Implementa void contar_hasta(int n) que muestre los numeros de 1 a n separados por
  espacios y un salto de linea al final. Llamala con 5 y con 0 (en este caso solo salto de linea).

EJEMPLO DE EJECUCION:
  1 2 3 4 5
  (linea vacia)

PISTA:
  Un bucle for dentro de una funcion void.

SOLUCION:
  La funcion no devuelve nada: solo imprime.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

void contar_hasta(int n);

int main(void) {
    contar_hasta(5);
    contar_hasta(0);
    return 0;
}

void contar_hasta(int n) {
    for (int i = 1; i <= n; i++) {
        printf("%d ", i);
    }
    printf("\n");
}
