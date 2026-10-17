/*
U05 — Repaso de condicionales: if, else if, switch, trampas y validacion.

OBJETIVO:
  - Integrar if / else if / switch / ternario en un solo programa.
  - Repasar trampas tipicas de C (= vs ==, reales, strcmp, rangos).
  - Validar entrada y montar un menu sencillo.
  - Resolver problemas tipicos: IMC, dias del mes, tarifa.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>
#include <stdbool.h>
#include <string.h>
#include <math.h>

int main(void) {
    printf("\n¡INICIO DEL PROGRAMA!\n\n");

    /*
    PRIMERA PARTE - IMC con else if.
    */
    printf("--- PRIMERA PARTE: IMC ---\n\n");

    double peso = 72.5, altura = 1.78;
    double imc = peso / (altura * altura);
    printf("Peso %.1f kg, altura %.2f m -> IMC %.1f: ", peso, altura, imc);
    if (imc < 18.5) {
        printf("bajo peso\n");
    } else if (imc < 25) {
        printf("peso normal\n");
    } else if (imc < 30) {
        printf("sobrepeso\n");
    } else {
        printf("obesidad\n");
    }

    /*
    SEGUNDA PARTE - Dias del mes (switch + bisiesto).
    */
    printf("\n--- SEGUNDA PARTE: Dias del mes ---\n\n");

    int mes = 2, anio = 2024, dias;
    bool bisiesto = (anio % 4 == 0 && anio % 100 != 0) || anio % 400 == 0;
    switch (mes) {
        case 4: case 6: case 9: case 11:
            dias = 30;
            break;
        case 2:
            dias = bisiesto ? 29 : 28;
            break;
        default:
            dias = 31;
            break;
    }
    printf("El mes %d del ano %d tiene %d dias\n", mes, anio, dias);

    /*
    TERCERA PARTE - Menu con switch (datos puestos a mano; en clase usa scanf).
    */
    printf("\n--- TERCERA PARTE: Menu ---\n\n");

    int opcion = 2;
    switch (opcion) {
        case 1:
            printf("Has elegido: Ver perfil\n");
            break;
        case 2:
            printf("Has elegido: Editar datos\n");
            break;
        case 3:
            printf("Has elegido: Cerrar sesion\n");
            break;
        default:
            printf("Opcion invalida\n");
            break;
    }

    /*
    CUARTA PARTE - Trampas de C (resumen para examen).
      = vs == | ; tras if | reales con epsilon | cadenas con strcmp | rangos con &&
    */
    printf("\n--- CUARTA PARTE: Trampas de C ---\n\n");

    int x = 3;
    if (x == 5) {
        printf("x vale 5\n");
    } else {
        printf("x NO vale 5 (vale %d). Nunca uses = en el if.\n", x);
    }

    double suma = 0.1 + 0.2;
    if (fabs(suma - 0.3) < 1e-9) {
        printf("0.1+0.2 ≈ 0.3 con tolerancia (no con ==)\n");
    }

    char usuario[] = "admin";
    char escrito[] = "admin";
    if (strcmp(usuario, escrito) == 0) {
        printf("strcmp: textos iguales (no uses == entre cadenas)\n");
    }

    int z = 7;
    if (z >= 0 && z <= 10) {
        printf("z (%d) entre 0 y 10: escribe ambos lados con &&\n", z);
    }

    /*
    QUINTA PARTE - Promocion y tarifa (condiciones compuestas).
    */
    printf("\n--- QUINTA PARTE: Promocion y tarifa ---\n\n");

    double media = 8.2;
    int asistencia = 65;
    bool promociona = (media >= 5 && asistencia >= 80) || media >= 8;
    printf("media=%.1f asistencia=%d%% -> %s\n", media, asistencia,
           promociona ? "PROMOCIONA" : "NO PROMOCIONA");

    int gramos = 1200;
    bool urgente = true;
    double tarifa = gramos <= 500 ? 3.50 : (gramos <= 2000 ? 6.00 : 9.50);
    if (urgente) {
        tarifa *= 1.40;
    }
    printf("Paquete %d g, urgente: %s -> %.2f euros\n",
           gramos, urgente ? "si" : "no", tarifa);

    printf("\n¡FIN DEL PROGRAMA!\n\n");
    return 0;
}
