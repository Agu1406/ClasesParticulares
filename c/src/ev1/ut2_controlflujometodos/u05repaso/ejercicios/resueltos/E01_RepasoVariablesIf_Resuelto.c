/*
E01 - Mayor o menor de edad (RESUELTO)

ENUNCIADO:
  Pide la edad (entero) y muestra 'Mayor de edad' (18 o mas) o 'Menor de edad'. Si es negativa muestra 'Edad no valida'.

EJEMPLO DE EJECUCION:
  Edad: 20
  Mayor de edad

PISTA:
  Primero descarta el caso invalido.

SOLUCION:
  Se comprueba primero la edad negativa y luego el umbral de 18.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    int edad = 0;
    printf("Edad: ");
    scanf("%d", &edad);
    if (edad < 0) {
        printf("Edad no valida\n");
    } else if (edad >= 18) {
        printf("Mayor de edad\n");
    } else {
        printf("Menor de edad\n");
    }
    return 0;
}
