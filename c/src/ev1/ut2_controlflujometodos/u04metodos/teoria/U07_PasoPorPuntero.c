/*
U07 - Paso por puntero: modificar variables de quien llama.

OBJETIVO:
  - Entender de forma intuitiva que es una DIRECCION (&) y que es un PUNTERO (*).
  - Escribir funciones que modifican variables de fuera (swap, incremento).
  - Devolver varios resultados desde una funcion usando parametros de salida.
  - Entender por que scanf necesita el & delante de las variables.
  - Preparar el terreno para punteros y arrays (se estudian a fondo en EV2).

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

void intercambiar_mal(int a, int b);
void intercambiar(int *a, int *b);
void incrementar(int *valor);
void dividir(int dividendo, int divisor, int *cociente, int *resto);
int minimo_y_maximo(int a, int b, int c, int *minimo, int *maximo);

int main(void) {
    printf("\n¡INICIO DEL PROGRAMA!\n\n");

    /*
    PRIMERA PARTE - Direccion y puntero.
      Cada variable ocupa un lugar en la memoria con una DIRECCION.
        &x     -> direccion de x (donde esta guardada)
        int *p -> p es un PUNTERO a int: guarda la direccion de un int
        *p     -> el valor que hay en esa direccion (desreferenciar)
    */
    printf("--- PRIMERA PARTE: & y * ---\n\n");

    int x = 25;
    int *p = &x;                              // p apunta a x
    printf("x vale %d\n", x);
    printf("*p vale %d (el valor al que apunta p)\n", *p);

    *p = 40;                                  // cambia x a traves de p
    printf("Tras *p = 40, x vale %d\n", x);
    printf("(la direccion exacta cambia en cada ejecucion: %s)\n",
           (void *)p == (void *)&x ? "p y &x coinciden" : "error");

    /*
    SEGUNDA PARTE - El problema: C pasa por valor.
      intercambiar_mal recibe COPIAS de a y b: intercambia las copias y las
      variables originales no cambian.
    */
    printf("\n--- SEGUNDA PARTE: Intercambio fallido ---\n\n");

    int a = 3, b = 8;
    printf("Antes:   a = %d, b = %d\n", a, b);
    intercambiar_mal(a, b);
    printf("Despues: a = %d, b = %d (no cambio nada)\n", a, b);

    /*
    TERCERA PARTE - La solucion: pasar direcciones.
      Se pasan &a y &b; la funcion recibe punteros y modifica las originales.
    */
    printf("\n--- TERCERA PARTE: Intercambio correcto ---\n\n");

    intercambiar(&a, &b);
    printf("Despues de intercambiar(&a, &b): a = %d, b = %d\n", a, b);

    int contador = 0;
    incrementar(&contador);
    incrementar(&contador);
    printf("contador tras dos incrementos = %d\n", contador);

    /*
    CUARTA PARTE - Parametros de salida: devolver varios valores.
      return solo devuelve UN valor. Con punteros una funcion puede
      "devolver" varios dejandolos en variables de quien llama.
    */
    printf("\n--- CUARTA PARTE: Varios resultados ---\n\n");

    int cociente, resto;
    dividir(47, 6, &cociente, &resto);
    printf("47 / 6 = %d, resto %d\n", cociente, resto);

    int menor, mayor;
    int ok = minimo_y_maximo(8, 3, 12, &menor, &mayor);
    printf("minimo_y_maximo(8, 3, 12): menor=%d mayor=%d (estado %d)\n", menor, mayor, ok);

    /*
    QUINTA PARTE - Por fin se entiende scanf.
      scanf("%d", &edad) pasa la DIRECCION de edad para que scanf pueda
      escribir ahi el valor leido. Por eso lleva &.
      (Con printf no hace falta &: solo lee el valor.)
    */
    printf("\n--- QUINTA PARTE: scanf y & ---\n\n");

    int edad = 0;
    printf("Escribe tu edad: ");
    if (scanf("%d", &edad) == 1) {
        printf("scanf guardo %d en la direccion de edad\n", edad);
    }

    /*
    SEXTA PARTE - Cuidado.
      - Un puntero sin inicializar apunta a cualquier sitio: nunca usar *p asi.
      - NULL es el "puntero a nada": comprueba p != NULL antes de usar *p.
      - Los punteros, los arrays y la memoria dinamica se veran en EV2.
    */
    printf("\n--- SEXTA PARTE: Precauciones ---\n\n");

    int *nulo = NULL;
    if (nulo == NULL) {
        printf("El puntero es NULL: no se debe desreferenciar.\n");
    }

    printf("\n¡FIN DEL PROGRAMA!\n\n");
    return 0;
}

void intercambiar_mal(int a, int b) {
    int aux = a;
    a = b;
    b = aux;
    printf("  (dentro: a = %d, b = %d)\n", a, b);
}

void intercambiar(int *a, int *b) {
    int aux = *a;
    *a = *b;
    *b = aux;
}

void incrementar(int *valor) {
    (*valor)++;          // parentesis: primero * y despues ++
}

void dividir(int dividendo, int divisor, int *cociente, int *resto) {
    *cociente = dividendo / divisor;
    *resto = dividendo % divisor;
}

int minimo_y_maximo(int a, int b, int c, int *minimo, int *maximo) {
    *minimo = a;
    *maximo = a;
    if (b < *minimo) { *minimo = b; }
    if (c < *minimo) { *minimo = c; }
    if (b > *maximo) { *maximo = b; }
    if (c > *maximo) { *maximo = c; }
    return 0;            // 0 = todo correcto (convencion en C)
}
