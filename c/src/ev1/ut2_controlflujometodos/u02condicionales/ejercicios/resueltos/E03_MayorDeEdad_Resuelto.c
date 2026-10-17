/*
E03 - Mayor de edad y entrada de cine (RESUELTO)

ENUNCIADO:
  Pide la edad. Si es menor de 0 o mayor de 120 muestra 'Edad no valida'.
  Si no: menor de 18 -> 'Menor de edad', 18 o mas -> 'Mayor de edad'.

EJEMPLO DE EJECUCION:
  Edad: 17
  Menor de edad

PISTA:
  Valida primero el rango y despues clasifica.

SOLUCION:
  La validacion se hace en la primera rama de la cadena else if.

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
    if (edad < 0 || edad > 120) {
        printf("Edad no valida\n");
    } else if (edad >= 18) {
        printf("Mayor de edad\n");
    } else {
        printf("Menor de edad\n");
    }
    return 0;
}
