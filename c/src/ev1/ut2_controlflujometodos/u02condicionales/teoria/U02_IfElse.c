/*
U02 — if-else y cadenas else if.

OBJETIVO:
  - Elegir entre dos caminos con if / else.
  - Encadenar varias condiciones con else if.
  - Clasificar valores en rangos (notas, temperatura, precios).
  - Usar el operador ternario en casos sencillos.
  - Evitar el else colgante y ordenar bien las condiciones.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    printf("\n¡INICIO DEL PROGRAMA!\n\n");

    /*
    PRIMERA PARTE - if / else: dos caminos excluyentes.
      Se ejecuta SIEMPRE uno de los dos bloques.
    */
    printf("--- PRIMERA PARTE: if / else ---\n\n");

    int edad = 17;
    if (edad >= 18) {
        printf("Eres mayor de edad.\n");
    } else {
        printf("Eres menor de edad. Te faltan %d anos.\n", 18 - edad);
    }

    int numero = 14;
    if (numero % 2 == 0) {
        printf("%d es par.\n", numero);
    } else {
        printf("%d es impar.\n", numero);
    }

    /*
    SEGUNDA PARTE - else if: clasificacion de nota.
      Se evalua de arriba abajo; solo entra en UN bloque.
      Regla: de la condicion MAS restrictiva a la mas general.
    */
    printf("\n--- SEGUNDA PARTE: Calificacion por nota ---\n\n");

    int nota = 8;
    if (nota >= 9) {
        printf("Nota %d: Sobresaliente\n", nota);
    } else if (nota >= 7) {
        printf("Nota %d: Notable\n", nota);
    } else if (nota >= 5) {
        printf("Nota %d: Aprobado\n", nota);
    } else {
        printf("Nota %d: Suspenso\n", nota);
    }

    /*
    TERCERA PARTE - Temperatura y tramos de precio.
    */
    printf("\n--- TERCERA PARTE: Temperatura y entrada ---\n\n");

    double temp = 32.5;
    if (temp >= 35) {
        printf("Ola de calor: hidratate.\n");
    } else if (temp >= 25) {
        printf("Dia caluroso.\n");
    } else if (temp >= 15) {
        printf("Temperatura agradable.\n");
    } else {
        printf("Hace fresco, abrigate.\n");
    }

    int edad_entrada = 70;
    double precio;
    if (edad_entrada < 4) {
        precio = 0.0;
    } else if (edad_entrada < 12) {
        precio = 5.0;
    } else if (edad_entrada < 65) {
        precio = 10.0;
    } else {
        precio = 6.5;
    }
    printf("Edad %d -> entrada %.2f euros\n", edad_entrada, precio);

    /*
    CUARTA PARTE - Ternario y else colgante.
      condicion ? si_true : si_false
      Un else pertenece al if MAS CERCANO: usa llaves siempre.
    */
    printf("\n--- CUARTA PARTE: Ternario y else colgante ---\n\n");

    int n = 4;
    printf("Nota %d: %s\n", n, n >= 5 ? "Aprobado" : "Suspenso");

    int p = 5, q = -3;
    if (p > 0) {
        if (q > 0) {
            printf("p y q son positivos\n");
        } else {
            printf("p es positivo pero q no\n");
        }
    }

    /*
    QUINTA PARTE - else-if frente a varios if.
      Con else if solo se ejecuta UNA rama.
      Con varios if independientes se evaluan TODOS.
    */
    printf("\n--- QUINTA PARTE: else-if o varios if ---\n\n");

    int m = 15;
    printf("Varios if (pueden salir varios):\n");
    if (m % 3 == 0) {
        printf("  multiplo de 3\n");
    }
    if (m % 5 == 0) {
        printf("  multiplo de 5\n");
    }
    printf("Con else if (solo uno):\n");
    if (m % 3 == 0) {
        printf("  multiplo de 3\n");
    } else if (m % 5 == 0) {
        printf("  multiplo de 5\n");
    }

    printf("\n¡FIN DEL PROGRAMA!\n\n");
    return 0;
}
