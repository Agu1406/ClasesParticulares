/*
U07 - Repaso completo de la UT1: del teclado a la pantalla.

OBJETIVO:
  - Integrar variables, tipos, casting, constantes, operadores, scanf y printf.
  - Construir un programa interactivo completo con entrada validada.
  - Presentar el resultado con formato.
  - Aplicar el esquema:  1) pedir datos  2) validar  3) calcular  4) mostrar.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>
#include <stdbool.h>
#include <string.h>

#define IVA 0.21
#define UMBRAL_ENVIO_GRATIS 50.0
#define COSTE_ENVIO 4.95
#define TAM_NOMBRE 30

static void limpiar_buffer(void) {
    int c;
    while ((c = getchar()) != '\n' && c != EOF) {
    }
}

int main(void) {
    printf("\n¡INICIO DEL PROGRAMA!\n\n");

    /*
    PRIMERA PARTE - Pedir los datos.
      Se leen: nombre del cliente, unidades y precio unitario.
    */
    printf("--- PRIMERA PARTE: Entrada de datos ---\n\n");

    char cliente[TAM_NOMBRE] = "";
    int unidades = 0;
    double precio_unitario = 0.0;

    printf("Nombre del cliente (una palabra): ");
    if (scanf("%29s", cliente) != 1) {
        strcpy(cliente, "desconocido");
    }

    printf("Unidades: ");
    if (scanf("%d", &unidades) != 1) {
        unidades = 0;
        limpiar_buffer();
    }

    printf("Precio unitario: ");
    if (scanf("%lf", &precio_unitario) != 1) {
        precio_unitario = 0.0;
        limpiar_buffer();
    }

    /*
    SEGUNDA PARTE - Validar.
      Rechazamos unidades menores que 1 y precios negativos.
    */
    printf("\n--- SEGUNDA PARTE: Validacion ---\n\n");

    bool datos_validos = unidades >= 1 && precio_unitario >= 0.0;
    if (!datos_validos) {
        printf("Datos no validos: unidades=%d, precio=%.2f\n", unidades, precio_unitario);
        printf("\n¡FIN DEL PROGRAMA!\n\n");
        return 1;
    }
    printf("Datos validos.\n");

    /*
    TERCERA PARTE - Calcular.
    */
    printf("\n--- TERCERA PARTE: Calculos ---\n\n");

    double subtotal = unidades * precio_unitario;
    double iva = subtotal * IVA;
    bool envio_gratis = subtotal >= UMBRAL_ENVIO_GRATIS;
    double envio = envio_gratis ? 0.0 : COSTE_ENVIO;
    double total = subtotal + iva + envio;
    double precio_medio_por_unidad = total / unidades;   // unidades >= 1: no divide entre 0

    printf("Calculos realizados.\n");

    /*
    CUARTA PARTE - Mostrar un ticket.
    */
    printf("\n--- CUARTA PARTE: Ticket ---\n\n");

    printf("=============================\n");
    printf(" TICKET DE COMPRA\n");
    printf("=============================\n");
    printf("Cliente:   %s\n", cliente);
    printf("Unidades:  %d x %.2f\n", unidades, precio_unitario);
    printf("-----------------------------\n");
    printf("%-14s %10.2f\n", "Subtotal:", subtotal);
    printf("%-14s %10.2f\n", "IVA (21%):", iva);
    printf("%-14s %10.2f\n", "Envio:", envio);
    printf("%-14s %10.2f\n", "TOTAL:", total);
    printf("=============================\n");
    printf("Envio gratis: %s\n", envio_gratis ? "SI" : "NO");
    printf("Coste real por unidad: %.2f\n", precio_medio_por_unidad);

    printf("\n¡FIN DEL PROGRAMA!\n\n");
    return 0;
}
