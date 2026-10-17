/*
U04 — Condicionales anidados.

OBJETIVO:
  - Colocar un if dentro de otro para decisiones encadenadas.
  - Decidir entre anidar y combinar con && / ||.
  - Evitar el "codigo flecha" (demasiada sangria).
  - Resolver reglas tipicas: acceso, bisiesto, descuentos.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>
#include <stdbool.h>

int main(void) {
    printf("\n¡INICIO DEL PROGRAMA!\n\n");

    /*
    PRIMERA PARTE - if dentro de if.
    */
    printf("--- PRIMERA PARTE: Acceso a una pelicula ---\n\n");

    int edad = 16;
    bool acompanado = true;
    if (edad >= 12) {
        if (edad >= 18) {
            printf("Puede entrar solo\n");
        } else if (acompanado) {
            printf("Puede entrar acompanado\n");
        } else {
            printf("Necesita ir acompanado\n");
        }
    } else {
        printf("No puede entrar: edad minima 12\n");
    }

    /*
    SEGUNDA PARTE - Anidar o combinar con &&.
    */
    printf("\n--- SEGUNDA PARTE: Anidar o && ---\n\n");

    int hora = 10;
    bool abierto = true;
    if (abierto) {
        if (hora >= 9 && hora < 14) {
            printf("[anidado] Atendiendo en horario de manana\n");
        }
    }
    if (abierto && hora >= 9 && hora < 14) {
        printf("[con &&]  Atendiendo en horario de manana\n");
    }

    /*
    TERCERA PARTE - Ano bisiesto (anidado vs una expresion).
    */
    printf("\n--- TERCERA PARTE: Ano bisiesto ---\n\n");

    int anio = 1900;
    if (anio % 4 == 0) {
        if (anio % 100 == 0) {
            if (anio % 400 == 0) {
                printf("%d es bisiesto\n", anio);
            } else {
                printf("%d NO es bisiesto\n", anio);
            }
        } else {
            printf("%d es bisiesto\n", anio);
        }
    } else {
        printf("%d NO es bisiesto\n", anio);
    }

    bool bisiesto = (anio % 4 == 0 && anio % 100 != 0) || anio % 400 == 0;
    printf("Con una sola expresion: %d %s bisiesto\n", anio, bisiesto ? "es" : "no es");

    /*
    CUARTA PARTE - Evitar el codigo flecha: casos malos primero.
    */
    printf("\n--- CUARTA PARTE: Evitar el codigo flecha ---\n\n");

    double saldo = 100.0, importe = 30.0;
    bool tarjeta_activa = true;

    if (!tarjeta_activa) {
        printf("Tarjeta bloqueada\n");
    } else if (importe <= 0) {
        printf("Importe no valido\n");
    } else if (saldo < importe) {
        printf("Saldo insuficiente\n");
    } else {
        saldo -= importe;
        printf("Pago correcto. Saldo: %.2f\n", saldo);
    }

    /*
    QUINTA PARTE - Descuento por varias reglas.
    */
    printf("\n--- QUINTA PARTE: Descuento ---\n\n");

    double compra = 120.0;
    bool es_socio = true;
    double descuento;
    if (es_socio) {
        descuento = compra >= 100 ? 0.15 : 0.05;
    } else {
        descuento = compra >= 100 ? 0.05 : 0.0;
    }
    printf("Compra %.2f, socio: %s -> descuento %.0f%%, a pagar %.2f\n",
           compra, es_socio ? "si" : "no", descuento * 100, compra * (1 - descuento));

    /*
    SEXTA PARTE - Traza a mano.
    */
    printf("\n--- SEXTA PARTE: Traza ---\n\n");

    int x = 5, y = 10;
    if (x > 3) {
        y = y - 2;
        if (y > 7) {
            x = x * 2;
        } else {
            x = 0;
        }
    }
    printf("Resultado de la traza: x = %d, y = %d\n", x, y);

    printf("\n¡FIN DEL PROGRAMA!\n\n");
    return 0;
}
