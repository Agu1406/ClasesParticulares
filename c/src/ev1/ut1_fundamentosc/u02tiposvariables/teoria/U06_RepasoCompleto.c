/*
U06 — Repaso de u02tiposvariables.

OBJETIVO:
  - Repasar tipos, aritmetica, comparacion y logica en C.
  - Cerrar la unidad con una factura pequena (printf alineado).
  - Recordar division entera, modulo y un char/ASCII.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>
#include <stdbool.h>

#define IVA 0.21
#define DESCUENTO_MINIMO 100.0
#define PORCENTAJE_DESCUENTO 0.10

int main(void) {
    printf("\n¡INICIO DEL PROGRAMA!\n\n");

    /*
    PRIMERA PARTE - Tipos basicos.
    */
    printf("--- PRIMERA PARTE: Tipos ---\n\n");

    int edad = 19;
    double media = 7.5;
    char grupo = 'A';
    bool repetidor = false;
    const char *modulo = "Programacion";

    printf("Alumno de %s | grupo %c | edad %d | media %.1f | repetidor %d\n",
           modulo, grupo, edad, media, repetidor);

    /*
    SEGUNDA PARTE - Aritmetica.
    */
    printf("\n--- SEGUNDA PARTE: Aritmetica ---\n\n");

    int n1 = 10, n2 = 3;
    printf("%d + %d = %d\n", n1, n2, n1 + n2);
    printf("%d / %d (entera) = %d\n", n1, n2, n1 / n2);
    printf("%d / %d (decimal) = %.2f\n", n1, n2, (double)n1 / n2);
    printf("%d %% %d = %d\n", n1, n2, n1 % n2);

    /*
    TERCERA PARTE - Comparacion y logica.
    */
    printf("\n--- TERCERA PARTE: Comparacion y logica ---\n\n");

    bool aprobado = media >= 5.0;
    bool matricula = media >= 9.0 && !repetidor;
    printf("aprobado=%d | candidata a MH=%d\n", aprobado, matricula);

    int altura_cm = 178;
    bool puede_atraccion = altura_cm >= 140 && edad >= 12;
    printf("altura %d cm, edad %d -> atraccion: %d\n",
           altura_cm, edad, puede_atraccion);

    /*
    CUARTA PARTE - Factura (cierre practico).
    */
    printf("\n--- CUARTA PARTE: Factura ---\n\n");

    const char *p1 = "Teclado";
    const char *p2 = "Raton";
    const char *p3 = "Monitor";
    int u1 = 2, u2 = 3, u3 = 1;
    double pr1 = 24.90, pr2 = 9.95, pr3 = 129.00;

    double i1 = u1 * pr1;
    double i2 = u2 * pr2;
    double i3 = u3 * pr3;
    double subtotal = i1 + i2 + i3;

    bool hay_descuento = subtotal >= DESCUENTO_MINIMO;
    double descuento = hay_descuento ? subtotal * PORCENTAJE_DESCUENTO : 0.0;
    double base = subtotal - descuento;
    double iva = base * IVA;
    double total = base + iva;

    printf("%-10s %5s %9s %10s\n", "Producto", "Uds", "Precio", "Importe");
    printf("%-10s %5d %9.2f %10.2f\n", p1, u1, pr1, i1);
    printf("%-10s %5d %9.2f %10.2f\n", p2, u2, pr2, i2);
    printf("%-10s %5d %9.2f %10.2f\n", p3, u3, pr3, i3);
    printf("-------------------------------------\n");
    printf("%-26s %10.2f\n", "Subtotal:", subtotal);
    printf("%-26s %10.2f\n", "Descuento:", -descuento);
    printf("%-26s %10.2f\n", "Base:", base);
    printf("%-26s %10.2f\n", "IVA:", iva);
    printf("%-26s %10.2f\n", "TOTAL:", total);

    /*
    QUINTA PARTE - Modulo y caracteres.
    */
    printf("\n--- QUINTA PARTE: Modulo y char ---\n\n");

    int caramelos = 47, ninos = 6;
    printf("%d caramelos / %d ninos: %d cada uno, sobran %d\n",
           caramelos, ninos, caramelos / ninos, caramelos % ninos);

    char letra = 'm';
    char mayus = (char)(letra - 'a' + 'A');
    printf("'%c' -> '%c' (posicion %d)\n", letra, mayus, letra - 'a' + 1);

    printf("\n¡FIN DEL PROGRAMA!\n\n");
    return 0;
}
