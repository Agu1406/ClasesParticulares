/*
Practica ejemplo (entrada y estilo): ticket de compra (RESUELTO)

ENUNCIADO:
  Lee del teclado el nombre de un producto (con espacios), las unidades y el precio unitario,
  y muestra un ticket con IVA. Valida que las unidades sean mayores que 0.

PISTA:
  scanf devuelve cuantos datos ha leido: compara con 1.

SOLUCION:
  fgets para el texto con espacios y scanf con %d / %lf para los numeros.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>
#include <string.h>

#define IVA 0.21

int main(void) {
    char producto[50];
    int unidades = 0;
    double precio = 0.0;

    printf("Producto: ");
    if (fgets(producto, sizeof(producto), stdin) == NULL) {
        return 1;
    }
    producto[strcspn(producto, "\n")] = '\0';

    printf("Unidades: ");
    if (scanf("%d", &unidades) != 1) {
        printf("Unidades no validas\n");
        return 1;
    }
    printf("Precio unitario: ");
    if (scanf("%lf", &precio) != 1) {
        printf("Precio no valido\n");
        return 1;
    }
    if (unidades <= 0) {
        printf("Unidades no validas\n");
        return 1;
    }

    double subtotal = unidades * precio;
    double iva = subtotal * IVA;
    printf("===== TICKET =====\n");
    printf("Producto: %s\n", producto);
    printf("Unidades: %d\n", unidades);
    printf("Precio  : %.2f\n", precio);
    printf("Subtotal: %.2f\n", subtotal);
    printf("IVA 21%% : %.2f\n", iva);
    printf("Total   : %.2f\n", subtotal + iva);
    return 0;
}
