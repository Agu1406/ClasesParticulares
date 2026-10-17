/*
E01 - Variables personales (RESUELTO)

ENUNCIADO:
  Declara cuatro variables con tus datos (edad int, altura double, inicial char y
  numero_calzado int) y muestralas en una linea cada una con su etiqueta.

EJEMPLO DE EJECUCION:
  Edad: 19
  Altura: 1.75
  Inicial: L
  Calzado: 42

PISTA:
  Recuerda el especificador de cada tipo: %d, %.2f, %c.

SOLUCION:
  Cada variable se declara con su tipo y se imprime con el formato que le corresponde.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    int edad = 19;
    double altura = 1.75;
    char inicial = 'L';
    int numero_calzado = 42;
    printf("Edad: %d\n", edad);
    printf("Altura: %.2f\n", altura);
    printf("Inicial: %c\n", inicial);
    printf("Calzado: %d\n", numero_calzado);
    return 0;
}
