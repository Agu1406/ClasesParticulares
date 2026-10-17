/*
E09 - Precio con IVA usando #define (RESUELTO)

ENUNCIADO:
  Define con #define el IVA (0.21). Un producto cuesta 80 euros: calcula el IVA, el
  precio final y muestralos con dos decimales.

EJEMPLO DE EJECUCION:
  IVA: 16.80
  Precio final: 96.80

PISTA:
  iva = precio * IVA; final = precio + iva

SOLUCION:
  El preprocesador sustituye IVA por 0.21 antes de compilar.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

#define IVA 0.21

int main(void) {
    double precio = 80;
    double iva = precio * IVA;
    double final_con_iva = precio + iva;
    printf("IVA: %.2f\n", iva);
    printf("Precio final: %.2f\n", final_con_iva);
    return 0;
}
