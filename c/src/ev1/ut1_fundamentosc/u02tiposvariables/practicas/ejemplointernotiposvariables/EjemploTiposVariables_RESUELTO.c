/*
Practica ejemplo (tipos y variables): factura de una cafeteria (RESUELTO)

ENUNCIADO:
  Calcula la factura de una cafeteria con variables del tipo adecuado y muestra el resultado
  con 2 decimales. Los datos son fijos (no se leen del teclado).

PISTA:
  Una variable double para dinero; un int para las unidades.

SOLUCION:
  El subtotal suma cantidad * precio; la media divide un double entre un int.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

#define IVA 0.21

int main(void) {
    int cafes = 3;
    int tostadas = 2;
    double precio_cafe = 1.35;
    double precio_tostada = 2.10;
    double subtotal = cafes * precio_cafe + tostadas * precio_tostada;
    double iva = subtotal * IVA;
    double total = subtotal + iva;
    int unidades = cafes + tostadas;
    double media = subtotal / unidades;
    int centimos = (int)(total * 100 + 0.5);
    printf("Subtotal: %.2f\n", subtotal);
    printf("IVA (21%%): %.2f\n", iva);
    printf("Total: %.2f\n", total);
    printf("Unidades: %d\n", unidades);
    printf("Precio medio por unidad: %.2f\n", media);
    printf("Total en centimos: %d\n", centimos);
    return 0;
}
