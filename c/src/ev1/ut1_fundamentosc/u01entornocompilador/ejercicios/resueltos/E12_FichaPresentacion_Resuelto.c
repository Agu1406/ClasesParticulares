/*
E12 - Ficha de presentacion (RESUELTO)

ENUNCIADO:
  Declara tu nombre (char), edad (int), altura (double) y modulo (cadena)
  como variables y muestra una ficha con ellas:
    Inicial: L
    Edad: 19
    Altura: 1.68 m
    Modulo: Programacion

EJEMPLO DE EJECUCION:
  Inicial: L
  Edad: 19
  Altura: 1.68 m
  Modulo: Programacion

PISTA:
  Usa %c para el char, %d para el int, %.2f para el double y %s para la cadena.

SOLUCION:
  Cada tipo tiene su especificador: %c, %d, %.2f y %s.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    char inicial = 'L';
    int edad = 19;
    double altura = 1.68;
    const char *modulo = "Programacion";
    printf("Inicial: %c\n", inicial);
    printf("Edad: %d\n", edad);
    printf("Altura: %.2f m\n", altura);
    printf("Modulo: %s\n", modulo);
    return 0;
}
