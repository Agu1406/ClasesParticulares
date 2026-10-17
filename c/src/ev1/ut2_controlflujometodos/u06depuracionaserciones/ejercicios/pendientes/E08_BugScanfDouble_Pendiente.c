/*
E08 - Encuentra el error: formato de scanf (PENDIENTE)

ENUNCIADO:
  Pide un numero decimal y muestra su doble con 2 decimales. Con 3.5 debe mostrar 'Doble: 7.00'.
  Hay un fallo en el formato de scanf.

EJEMPLO DE EJECUCION:
  Numero: 3.5
  Doble: 7.00

PISTA:
  Para leer un double con scanf se usa otro especificador que para float.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    double d = 0.0;
    printf("Numero: ");
    // TODO: corrige el formato
    scanf("%f", &d);
    printf("Doble: %.2f\n", d * 2);
    return 0;
}
