/*
U06 — Repaso general de u02tiposvariables.

OBJETIVO:
  - Crear variables de distintos tipos.
  - Recordar enteros, doubles, char, bool, const y #define.
  - Practicar operadores aritmeticos, de comparacion y logicos.
  - Integrarlo en una factura pequena (como cierre de la unidad).

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>
#include <stdbool.h>

#define IVA 0.21
#define DESCUENTO_MINIMO_COMPRA 100.0
#define PORCENTAJE_DESCUENTO 0.10

int main(void) {
    printf("\n¡INICIO DEL PROGRAMA!\n\n");

    /*
    PRIMERA PARTE - Tipos basicos en C.
      int / double / bool / char / const char * (texto; no hay string).
    */
    printf("--- PRIMERA PARTE: Datos del profesor y del alumno ---\n\n");

    const char *nombre_p = "Agustin";
    const char *nombre_a = "Eduardo";
    int edad_p = 26;
    int edad_a = 29;
    double altura_p = 1.76;
    double altura_a = 1.74;
    bool soy_humano = true;
    bool hoy_martes = false;
    char inicial_p = 'A';

    printf("Profesor: %s (%c), %d anos, %.2f m\n", nombre_p, inicial_p, edad_p, altura_p);
    printf("Alumno:   %s, %d anos, %.2f m\n", nombre_a, edad_a, altura_a);
    printf("Tipo de edad_p: int | soy_humano && !hoy_martes: %s\n",
           (soy_humano && !hoy_martes) ? "true" : "false");

    /*
    SEGUNDA PARTE - Operadores aritmeticos.
    */
    printf("\n--- SEGUNDA PARTE: Operadores aritmeticos ---\n\n");

    int num1 = 10, num2 = 3;
    printf("%d + %d = %d\n", num1, num2, num1 + num2);
    printf("%d - %d = %d\n", num1, num2, num1 - num2);
    printf("%d * %d = %d\n", num1, num2, num1 * num2);
    printf("%d / %d (entera) = %d\n", num1, num2, num1 / num2);
    printf("%d / %d (decimal) = %.2f\n", num1, num2, (double)num1 / num2);
    printf("%d %% %d = %d\n", num1, num2, num1 % num2);

    /*
    TERCERA PARTE - Comparacion y logica.
    */
    printf("\n--- TERCERA PARTE: Comparacion y logica ---\n\n");

    printf("¿Alumno mayor que profesor? %s\n", edad_a > edad_p ? "true" : "false");
    printf("¿Alturas distintas? %s\n", altura_a != altura_p ? "true" : "false");
    bool puede_montana = altura_p >= 1.75 && edad_p >= 18;
    printf("¿Profesor puede montana rusa? %s\n", puede_montana ? "true" : "false");

    /*
    CUARTA PARTE - Factura con IVA y descuento (cierre practico).
    */
    printf("\n--- CUARTA PARTE: Factura ---\n\n");

    const char *producto1 = "Teclado";
    const char *producto2 = "Raton";
    const char *producto3 = "Monitor";
    int unidades1 = 2, unidades2 = 3, unidades3 = 1;
    double precio1 = 24.90, precio2 = 9.95, precio3 = 129.00;

    double importe1 = unidades1 * precio1;
    double importe2 = unidades2 * precio2;
    double importe3 = unidades3 * precio3;
    double subtotal = importe1 + importe2 + importe3;

    bool aplica_descuento = subtotal >= DESCUENTO_MINIMO_COMPRA;
    double descuento = aplica_descuento ? subtotal * PORCENTAJE_DESCUENTO : 0.0;
    double base = subtotal - descuento;
    double iva = base * IVA;
    double total = base + iva;

    printf("%-10s %5s %9s %10s\n", "Producto", "Uds", "Precio", "Importe");
    printf("%-10s %5d %9.2f %10.2f\n", producto1, unidades1, precio1, importe1);
    printf("%-10s %5d %9.2f %10.2f\n", producto2, unidades2, precio2, importe2);
    printf("%-10s %5d %9.2f %10.2f\n", producto3, unidades3, precio3, importe3);
    printf("-------------------------------------\n");
    printf("%-26s %10.2f\n", "Subtotal:", subtotal);
    printf("%-26s %10.2f\n", "Descuento (10%):", -descuento);
    printf("%-26s %10.2f\n", "Base imponible:", base);
    printf("%-26s %10.2f\n", "IVA (21%):", iva);
    printf("%-26s %10.2f\n", "TOTAL:", total);

    /*
    QUINTA PARTE - Reparto y caracteres (division / modulo / ASCII).
    */
    printf("\n--- QUINTA PARTE: Reparto y caracteres ---\n\n");

    int caramelos = 47, ninos = 6;
    printf("%d caramelos entre %d ninos: %d cada uno y sobran %d\n",
           caramelos, ninos, caramelos / ninos, caramelos % ninos);

    char inicial = 'm';
    char mayuscula = (char)(inicial - 'a' + 'A');
    int posicion = inicial - 'a' + 1;
    printf("'%c' -> '%c' (letra numero %d del alfabeto)\n", inicial, mayuscula, posicion);

    printf("\n¡FIN DEL PROGRAMA!\n\n");
    return 0;
}
