/*
E09 - Precio con IVA usando #define (PENDIENTE)

ENUNCIADO:
  Define con #define el IVA (0.21). Un producto cuesta 80 euros: calcula el IVA, el
  precio final y muestralos con dos decimales.

EJEMPLO DE EJECUCION:
  IVA: 16.80
  Precio final: 96.80

PISTA:
  iva = precio * IVA; final = precio + iva

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

// TODO: define la constante IVA con valor 0.21
#define IVA 0.0

int main(void) {
    double precio = 80;
    // TODO: calcula el iva y el precio final
    double iva = 0;
    double final_con_iva = 0;
    printf("IVA: %.2f\n", iva);
    printf("Precio final: %.2f\n", final_con_iva);
    return 0;
}
