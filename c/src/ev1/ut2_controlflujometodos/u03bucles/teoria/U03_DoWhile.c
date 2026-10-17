/*
U03 — El bucle do-while.

OBJETIVO:
  - Ejecutar el cuerpo AL MENOS UNA VEZ y repetirlo mientras la condicion sea cierta.
  - No olvidar el punto y coma final: while (condicion);
  - Usar do-while para validar entradas y para menus que se repiten.
  - Comparar los tres bucles: for, while y do-while.
  - Construir un menu completo con opcion 0 = salir.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    printf("\n¡INICIO DEL PROGRAMA!\n\n");

    /*
    PRIMERA PARTE - Estructura.
      do {
          cuerpo
      } while (condicion);        <- OJO: lleva ; al final
      La condicion se comprueba DESPUES de ejecutar el cuerpo, asi que como
      minimo se ejecuta una vez.
    */
    printf("--- PRIMERA PARTE: Al menos una vez ---\n\n");

    int n = 100;
    do {
        printf("Este mensaje sale una vez aunque n (%d) no sea menor que 5\n", n);
        n++;
    } while (n < 5);

    /*
    SEGUNDA PARTE - Contar con do-while.
    */
    printf("\n--- SEGUNDA PARTE: Contar del 1 al 5 ---\n\n");

    int i = 1;
    do {
        printf("i = %d\n", i);
        i++;
    } while (i <= 5);

    /*
    TERCERA PARTE - Validar una entrada.
      Es el uso mas habitual: pedir el dato y REPETIR mientras no sea valido.
      Con while normal habria que pedir el dato dos veces (antes y dentro).
    */
    printf("\n--- TERCERA PARTE: Pedir una nota valida ---\n\n");

    int nota = -1;
    int leidos;
    do {
        printf("Nota (0-10): ");
        leidos = scanf("%d", &nota);
        if (leidos != 1) {
            printf("  No es un numero.\n");
            int c;
            while ((c = getchar()) != '\n' && c != EOF) {
            }
            if (c == EOF) {
                break;       // no hay mas entrada: salimos para no quedar en bucle infinito
            }
            nota = -1;
        } else if (nota < 0 || nota > 10) {
            printf("  Fuera de rango.\n");
        }
    } while (nota < 0 || nota > 10);
    printf("Nota aceptada: %d\n", nota);

    /*
    CUARTA PARTE - Menu repetitivo.
      Patron clasico: se muestra el menu, se lee la opcion, se actua con
      switch y se repite hasta que el usuario elige 0 (salir).
    */
    printf("\n--- CUARTA PARTE: Menu ---\n\n");

    int opcion;
    int contador = 0;
    do {
        printf("\n=== MENU ===\n");
        printf("1. Sumar 1 al contador\n");
        printf("2. Mostrar contador\n");
        printf("0. Salir\n");
        printf("Opcion: ");
        if (scanf("%d", &opcion) != 1) {
            break;           // entrada agotada o no numerica
        }
        switch (opcion) {
            case 1:
                contador++;
                printf("Contador incrementado.\n");
                break;
            case 2:
                printf("El contador vale %d\n", contador);
                break;
            case 0:
                printf("Saliendo...\n");
                break;
            default:
                printf("Opcion no valida.\n");
                break;
        }
    } while (opcion != 0);

    /*
    QUINTA PARTE - Comparativa.
      for       -> sabes cuantas vueltas
      while     -> puede no ejecutarse nunca (condicion antes)
      do-while  -> se ejecuta como minimo una vez (condicion despues)
    */
    printf("\n--- QUINTA PARTE: Comparativa ---\n\n");
    printf("for: conocido | while: 0 o mas vueltas | do-while: 1 o mas vueltas\n");

    printf("\n¡FIN DEL PROGRAMA!\n\n");
    return 0;
}
