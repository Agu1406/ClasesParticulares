/*
U04 - Repaso: break, continue y salidas anticipadas.

OBJETIVO:
  - Usar break para cortar un bucle y continue para saltar una vuelta.
  - Buscar un elemento y parar al encontrarlo.
  - Salir de bucles anidados con una bandera o un return.
  - Saber cuando conviene NO usarlos.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>
#include <stdbool.h>

static bool hay_pareja_suma(const int *v, int n, int objetivo, int *i_out, int *j_out);

int main(void) {
    printf("\n¡INICIO DEL PROGRAMA!\n\n");

    /*
    PRIMERA PARTE - break: terminar el bucle.
      Buscar el primer multiplo de 7 mayor que 50.
    */
    printf("--- PRIMERA PARTE: break ---\n\n");

    int encontrado = -1;
    for (int i = 51; i < 1000; i++) {
        if (i % 7 == 0) {
            encontrado = i;
            break;
        }
    }
    printf("Primer multiplo de 7 mayor que 50: %d\n", encontrado);

    /*
    SEGUNDA PARTE - continue: saltar esta vuelta.
      Mostrar del 1 al 10 sin los multiplos de 3.
    */
    printf("\n--- SEGUNDA PARTE: continue ---\n\n");

    for (int i = 1; i <= 10; i++) {
        if (i % 3 == 0) {
            continue;
        }
        printf("%d ", i);
    }
    printf("\n");

    /*
    TERCERA PARTE - Buscar en una lista y avisar si no esta.
    */
    printf("\n--- TERCERA PARTE: Busqueda ---\n\n");

    int lista[] = {4, 8, 15, 16, 23, 42};
    int total = (int)(sizeof(lista) / sizeof(lista[0]));
    int buscado = 16;
    int posicion = -1;
    for (int i = 0; i < total; i++) {
        if (lista[i] == buscado) {
            posicion = i;
            break;
        }
    }
    if (posicion >= 0) {
        printf("%d esta en la posicion %d\n", buscado, posicion);
    } else {
        printf("%d no esta\n", buscado);
    }

    /*
    CUARTA PARTE - Salir de dos bucles: break solo sale del bucle interior.
      Con una bandera (o una funcion con return) se sale de ambos.
    */
    printf("\n--- CUARTA PARTE: Bucles anidados ---\n\n");

    int pi = 0;
    int pj = 0;
    if (hay_pareja_suma(lista, total, 31, &pi, &pj)) {
        printf("%d + %d = 31 (posiciones %d y %d)\n", lista[pi], lista[pj], pi, pj);
    }

    bool salir = false;
    for (int f = 1; f <= 5 && !salir; f++) {
        for (int c = 1; c <= 5; c++) {
            if (f * c == 12) {
                printf("Primer producto 12 con f=%d, c=%d\n", f, c);
                salir = true;
                break;
            }
        }
    }

    /*
    QUINTA PARTE - Cuando NO usarlos.
      Si la condicion de parada cabe en la cabecera del bucle, ponla alli:
      el codigo se lee mejor.
    */
    printf("\n--- QUINTA PARTE: Alternativa sin break ---\n\n");

    int x = 1;
    while (x < 100 && x % 13 != 0) {
        x++;
    }
    printf("Primer multiplo de 13: %d\n", x);

    printf("\n¡FIN DEL PROGRAMA!\n\n");
    return 0;
}

static bool hay_pareja_suma(const int *v, int n, int objetivo, int *i_out, int *j_out) {
    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
            if (v[i] + v[j] == objetivo) {
                *i_out = i;
                *j_out = j;
                return true;      // sale de AMBOS bucles
            }
        }
    }
    return false;
}
