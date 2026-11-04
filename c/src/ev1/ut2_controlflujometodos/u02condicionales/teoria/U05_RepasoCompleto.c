/*
U05 — Repaso de condicionales: if, else if, switch, trampas y validacion.

OBJETIVO:
  - Integrar if / else if / switch / ternario en un solo programa.
  - Repasar trampas tipicas de C (= vs ==, reales, strcmp, rangos).
  - Leer una opcion de menu con scanf y validar el retorno.
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
      Solo entra una rama. Orden: de la franja mas baja a la alta.
      Guardamos la etiqueta en un puntero a literal para un solo printf.
    */
    printf("--- PRIMERA PARTE: IMC ---\n\n");

    double peso = 72.5, altura = 1.78;
    double imc = peso / (altura * altura);
    const char *categoria;
    if (imc < 18.5) {
        categoria = "bajo peso";
    } else if (imc < 25) {
        categoria = "peso normal";
    } else if (imc < 30) {
        categoria = "sobrepeso";
    } else {
        categoria = "obesidad";
    }
    printf("Peso %.1f kg, altura %.2f m -> IMC %.1f: %s\n",
           peso, altura, imc, categoria);

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
    TERCERA PARTE - Menu con switch y scanf.
      Si scanf no lee un entero, forzamos opcion invalida.
    */
    printf("\n--- TERCERA PARTE: Menu ---\n\n");
    printf("1. Ver perfil\n");
    printf("2. Editar datos\n");
    printf("3. Cerrar sesion\n");
    printf("Opcion: ");

    int opcion;
    if (scanf("%d", &opcion) != 1) {
        printf("Entrada no numerica.\n");
        opcion = -1;
    }

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
    CUARTA PARTE - Trampas de C (demos vivas).
      = vs == | asignacion en if | reales con epsilon | cadenas con strcmp | rangos
    */
    printf("\n--- CUARTA PARTE: Trampas de C ---\n\n");

    int x = 3;
    printf("x empieza en %d\n", x);
    if (x = 5) {
        printf("if (x = 5) SI compila: asigna 5 y la condicion vale 5 (verdadero).\n");
        printf("Ahora x = %d\n", x);
    }
    x = 3;
    if (x == 5) {
        printf("x vale 5\n");
    } else {
        printf("Con == no entra; x sigue siendo %d. Usa ==, no =.\n", x);
    }

    int activo = 1;
    if ((activo = 0)) {
        printf("Este texto no sale: la asignacion vale 0 (falso)\n");
    }
    printf("activo = 0 dentro del if dejo activo en %d\n", activo);

    double suma = 0.1 + 0.2;
    printf("0.1 + 0.2 == 0.3 -> %d\n", suma == 0.3);
    printf("con tolerancia     -> %d\n", fabs(suma - 0.3) < 1e-9);

    char usuario[] = "admin";
    char escrito[] = "admin";
    printf("usuario == escrito (compara direcciones) -> %d\n",
           usuario == escrito);
    printf("strcmp(usuario, escrito) == 0            -> %d\n",
           strcmp(usuario, escrito) == 0);

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
    double tarifa;
    if (gramos <= 500) {
        tarifa = 3.50;
    } else if (gramos <= 2000) {
        tarifa = 6.00;
    } else {
        tarifa = 9.50;
    }
    if (urgente) {
        tarifa *= 1.40;
    }
    printf("Paquete %d g, urgente: %s -> %.2f euros\n",
           gramos, urgente ? "si" : "no", tarifa);

    printf("\n¡FIN DEL PROGRAMA!\n\n");
    return 0;
}
