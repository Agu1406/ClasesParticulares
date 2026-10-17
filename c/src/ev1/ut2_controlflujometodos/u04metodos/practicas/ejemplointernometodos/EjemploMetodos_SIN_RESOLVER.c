/*
Practica ejemplo (funciones): mini biblioteca matematica (SIN RESOLVER)

ENUNCIADO:
  Implementa las ocho funciones de la mini biblioteca. El main trae las pruebas hechas:
  al terminar debe mostrar 'Resultado: 8/8 pruebas correctas'.

PISTA:
  Resuelve y prueba una funcion cada vez: mira que prueba falla.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>
#include <stdbool.h>

static int pruebas = 0;
static int aciertos = 0;
#define PRUEBA(cond) do { pruebas++; if (cond) { aciertos++; printf("  [ OK  ] %s\n", #cond); } \
                          else { printf("  [FALLO] %s\n", #cond); } } while (0)

bool es_primo(int n) {
    // TODO: es_primo: true si n es primo
    (void)n;
    return false;
}

int mcd(int a, int b) {
    // TODO: mcd: maximo comun divisor (Euclides)
    (void)a;
    (void)b;
    return 0;
}

long long factorial(int n) {
    // TODO: factorial: n! recursivo (n >= 0)
    (void)n;
    return 0;
}

long long fibonacci(int n) {
    // TODO: fibonacci: termino n con un bucle
    (void)n;
    return 0;
}

int suma_digitos(int n) {
    // TODO: suma_digitos: suma de las cifras de n >= 0
    (void)n;
    return 0;
}

long long potencia(int base, int exp) {
    // TODO: potencia: base elevada a exp (exp >= 0)
    (void)base;
    (void)exp;
    return 0;
}

bool es_perfecto(int n) {
    // TODO: es_perfecto: n es igual a la suma de sus divisores propios
    (void)n;
    return false;
}

int cifras_pares(int n) {
    // TODO: cifras_pares: cuantas cifras pares tiene n >= 0 (el 0 tiene una cifra par)
    (void)n;
    return 0;
}

int main(void) {
    PRUEBA(!es_primo(1) && es_primo(2) && es_primo(97) && !es_primo(100));
    PRUEBA(mcd(84, 36) == 12 && mcd(17, 5) == 1 && mcd(0, 9) == 9);
    PRUEBA(factorial(0) == 1 && factorial(5) == 120 && factorial(15) == 1307674368000LL);
    PRUEBA(fibonacci(0) == 0 && fibonacci(1) == 1 && fibonacci(10) == 55 && fibonacci(50) == 12586269025LL);
    PRUEBA(suma_digitos(0) == 0 && suma_digitos(4821) == 15);
    PRUEBA(potencia(2, 10) == 1024 && potencia(7, 0) == 1 && potencia(-2, 3) == -8);
    PRUEBA(es_perfecto(6) && es_perfecto(28) && !es_perfecto(12) && !es_perfecto(1));
    PRUEBA(cifras_pares(0) == 1 && cifras_pares(2468) == 4 && cifras_pares(1357) == 0 && cifras_pares(1020) == 3);

    printf("Resultado: %d/%d pruebas correctas\n", aciertos, pruebas);
    return aciertos == pruebas ? 0 : 1;
}
