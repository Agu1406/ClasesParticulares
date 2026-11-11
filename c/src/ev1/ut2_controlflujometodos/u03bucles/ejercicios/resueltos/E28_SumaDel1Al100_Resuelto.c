/*
E28 - Suma del 1 al 100 (RESUELTO)

ENUNCIADO:
  Con un for, suma los enteros del 1 al 100 y muestra el total.

EJEMPLO DE EJECUCION:
  Suma: 5050

SOLUCION:
  Acumulador inicializado a 0.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    int suma = 0;
    for (int i = 1; i <= 100; i++) {
        suma += i;
    }
    printf("Suma: %d\n", suma);
    return 0;
}
