/*
U03 — Estructura switch: multiples casos sobre un mismo valor.

OBJETIVO:
  - Usar switch con case, break y default.
  - Comparar int y char con switch (en C no admite string ni double).
  - Agrupar casos y ver el fall-through controlado (y el accidental).
  - Elegir switch frente a if / else if segun el problema.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    printf("\n¡INICIO DEL PROGRAMA!\n\n");

    /*
    PRIMERA PARTE - switch con enteros.
      La expresion debe ser ENTERA (int, char, enum). Cada case: constante.
      break sale del switch. Sin break, continua al siguiente case.
    */
    printf("--- PRIMERA PARTE: Dia de la semana ---\n\n");

    int dia = 3;
    switch (dia) {
        case 1:
            printf("Lunes\n");
            break;
        case 2:
            printf("Martes\n");
            break;
        case 3:
            printf("Miercoles\n");
            break;
        case 4:
            printf("Jueves\n");
            break;
        case 5:
            printf("Viernes\n");
            break;
        case 6:
        case 7:
            printf("Fin de semana\n");
            break;
        default:
            printf("Dia no valido (usa 1-7)\n");
            break;
    }

    /*
    SEGUNDA PARTE - switch con char (menus y calculadoras).
    */
    printf("\n--- SEGUNDA PARTE: Calculadora con char ---\n\n");

    char operador = '*';
    double x = 6, y = 4;
    switch (operador) {
        case '+':
            printf("%.1f + %.1f = %.1f\n", x, y, x + y);
            break;
        case '-':
            printf("%.1f - %.1f = %.1f\n", x, y, x - y);
            break;
        case '*':
            printf("%.1f * %.1f = %.1f\n", x, y, x * y);
            break;
        case '/':
            if (y != 0) {
                printf("%.1f / %.1f = %.2f\n", x, y, x / y);
            } else {
                printf("No se puede dividir entre cero\n");
            }
            break;
        default:
            printf("Operador '%c' no reconocido\n", operador);
            break;
    }

    /*
    TERCERA PARTE - Agrupar casos (estaciones).
    */
    printf("\n--- TERCERA PARTE: Estaciones ---\n\n");

    int mes = 4;
    switch (mes) {
        case 12: case 1: case 2:
            printf("Mes %d: invierno\n", mes);
            break;
        case 3: case 4: case 5:
            printf("Mes %d: primavera\n", mes);
            break;
        case 6: case 7: case 8:
            printf("Mes %d: verano\n", mes);
            break;
        case 9: case 10: case 11:
            printf("Mes %d: otono\n", mes);
            break;
        default:
            printf("Mes no valido\n");
            break;
    }

    /*
    CUARTA PARTE - Fall-through a proposito (y el error de olvidar break).
    */
    printf("\n--- CUARTA PARTE: Caida a proposito ---\n\n");

    int nivel = 2;
    printf("Premios del nivel %d:\n", nivel);
    switch (nivel) {
        case 3:
            printf("  - Trofeo\n");
            /* fall through */
        case 2:
            printf("  - Medalla\n");
            /* fall through */
        case 1:
            printf("  - Diploma\n");
            break;
        default:
            printf("  - Sin premios\n");
            break;
    }

    /*
    QUINTA PARTE - Limitaciones y cuando usar if.
      No: switch (3.5), switch (cadena), case x > 5.
      switch -> valores EXACTOS. if -> rangos y condiciones compuestas.
    */
    printf("\n--- QUINTA PARTE: Cuando usar cada uno ---\n\n");

    int opcion = 2;
    switch (opcion) {
        case 1:
            printf("Abrir\n");
            break;
        case 2:
            printf("Guardar\n");
            break;
        case 3:
            printf("Salir\n");
            break;
        default:
            printf("Opcion invalida\n");
    }
    printf("Rangos y cadenas -> if / else if (y strcmp en UT3).\n");

    printf("\n¡FIN DEL PROGRAMA!\n\n");
    return 0;
}
