/*
U08 - Funciones con estructuras de control y menus.

OBJETIVO:
  - Combinar funciones con if, switch, bucles y return.
  - Dividir un programa en funciones pequenas con una sola tarea.
  - Construir un menu con do-while + switch donde cada opcion llama a una funcion.
  - Separar CALCULAR (funciones puras) de MOSTRAR y LEER (entrada/salida).
  - Probar funciones con casos de prueba sencillos (mini tests).

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>
#include <stdbool.h>

/* Funciones "puras": reciben datos, devuelven un resultado, NO leen ni imprimen. */
const char *clasificar_nota(double nota);
long suma_hasta(int n);
int contar_pares(int desde, int hasta);
bool es_primo(int n);
int primer_multiplo(int base, int minimo);

/* Funciones de entrada/salida. */
int leer_entero(const char *mensaje);
void imprimir_menu(void);

/* Mini test: muestra OK o FALLO. */
static int fallos = 0;
static void comprobar(const char *descripcion, bool condicion) {
    printf("  [%s] %s\n", condicion ? " OK  " : "FALLO", descripcion);
    if (!condicion) {
        fallos++;
    }
}

int main(void) {
    printf("\n¡INICIO DEL PROGRAMA!\n\n");

    /*
    PRIMERA PARTE - Funciones con if / else if.
    */
    printf("--- PRIMERA PARTE: clasificar_nota ---\n\n");

    printf("9.5 -> %s\n", clasificar_nota(9.5));
    printf("6.0 -> %s\n", clasificar_nota(6.0));
    printf("3.2 -> %s\n", clasificar_nota(3.2));

    /*
    SEGUNDA PARTE - Funciones con bucles.
    */
    printf("\n--- SEGUNDA PARTE: bucles dentro de funciones ---\n\n");

    printf("suma_hasta(100)       = %ld\n", suma_hasta(100));
    printf("contar_pares(1, 20)   = %d\n", contar_pares(1, 20));
    printf("primer_multiplo(7,50) = %d\n", primer_multiplo(7, 50));

    /*
    TERCERA PARTE - Mini tests.
      Antes de fiarte de una funcion, pruebala con casos conocidos
      (incluyendo los casos limite: 0, 1, negativos...).
    */
    printf("\n--- TERCERA PARTE: Pruebas ---\n\n");

    comprobar("suma_hasta(0) == 0", suma_hasta(0) == 0);
    comprobar("suma_hasta(10) == 55", suma_hasta(10) == 55);
    comprobar("contar_pares(1, 10) == 5", contar_pares(1, 10) == 5);
    comprobar("es_primo(2)", es_primo(2));
    comprobar("!es_primo(1)", !es_primo(1));
    comprobar("!es_primo(91)", !es_primo(91));
    comprobar("es_primo(97)", es_primo(97));
    printf("Fallos: %d\n", fallos);

    /*
    CUARTA PARTE - Menu de opciones: cada opcion llama a una funcion.
      Patron: do { imprimir_menu(); leer opcion; switch ... } while (opcion != 0);
    */
    printf("\n--- CUARTA PARTE: Menu ---\n\n");

    int opcion;
    do {
        imprimir_menu();
        opcion = leer_entero("Opcion: ");
        switch (opcion) {
            case 1: {
                int n = leer_entero("Hasta que numero? ");
                printf("La suma de 1 a %d es %ld\n", n, suma_hasta(n));
                break;
            }
            case 2: {
                int n = leer_entero("Numero a comprobar: ");
                printf("%d %s primo\n", n, es_primo(n) ? "es" : "no es");
                break;
            }
            case 0:
                printf("Hasta luego.\n");
                break;
            default:
                printf("Opcion no valida.\n");
                break;
        }
    } while (opcion != 0);

    printf("\n¡FIN DEL PROGRAMA!\n\n");
    return 0;
}

const char *clasificar_nota(double nota) {
    if (nota >= 9) {
        return "Sobresaliente";
    } else if (nota >= 5) {
        return "Aprobado";
    }
    return "Suspenso";
}

long suma_hasta(int n) {
    long total = 0;
    for (int i = 1; i <= n; i++) {
        total += i;
    }
    return total;
}

int contar_pares(int desde, int hasta) {
    int contador = 0;
    for (int i = desde; i <= hasta; i++) {
        if (i % 2 == 0) {
            contador++;
        }
    }
    return contador;
}

bool es_primo(int n) {
    if (n < 2) {
        return false;
    }
    for (int d = 2; d * d <= n; d++) {
        if (n % d == 0) {
            return false;
        }
    }
    return true;
}

int primer_multiplo(int base, int minimo) {
    int candidato = minimo;
    while (candidato % base != 0) {
        candidato++;
    }
    return candidato;
}

int leer_entero(const char *mensaje) {
    int valor = 0;
    printf("%s", mensaje);
    if (scanf("%d", &valor) != 1) {
        return 0;     // si falla (o se acaba la entrada) devolvemos 0 = salir
    }
    return valor;
}

void imprimir_menu(void) {
    printf("\n=== MENU ===\n");
    printf("1. Suma de 1 a N\n");
    printf("2. Es primo?\n");
    printf("0. Salir\n");
}
