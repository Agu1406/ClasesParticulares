/*
E10 - Mayor y menor de tres con el operador ternario (PENDIENTE)

ENUNCIADO:
  Pide tres enteros y muestra el mayor y el menor usando SOLO el operador ternario
  (sin if).

EJEMPLO DE EJECUCION:
  Numeros: 8 15 3
  Mayor: 15
  Menor: 3

PISTA:
  Primero el mayor de a y b; luego compara ese resultado con c.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    int a = 0, b = 0, c = 0;
    printf("Numeros: ");
    scanf("%d %d %d", &a, &b, &c);
    // TODO: calcula mayor y menor con ternarios
    int mayor = 0;
    int menor = 0;
    printf("Mayor: %d\n", mayor);
    printf("Menor: %d\n", menor);
    return 0;
}
