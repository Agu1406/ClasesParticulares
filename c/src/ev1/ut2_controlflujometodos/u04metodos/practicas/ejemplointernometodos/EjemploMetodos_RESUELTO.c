/*
Practica ejemplo (funciones): mini biblioteca matematica (RESUELTO)

ENUNCIADO:
  Implementa las ocho funciones de la mini biblioteca. El main trae las pruebas hechas:
  al terminar debe mostrar 'Resultado: 8/8 pruebas correctas'.

PISTA:
  Resuelve y prueba una funcion cada vez: mira que prueba falla.

SOLUCION:
  Cada funcion es independiente; factorial usa recursion y las demas bucles.

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

int mcd(int a, int b) {
    while (b != 0) {
        int r = a % b;
        a = b;
        b = r;
    }
    return a;
}

long long factorial(int n) {
    return n <= 1 ? 1 : n * factorial(n - 1);
}

long long fibonacci(int n) {
    long long a = 0, b = 1;
    for (int i = 0; i < n; i++) {
        long long s = a + b;
        a = b;
        b = s;
    }
    return a;
}

int suma_digitos(int n) {
    int s = 0;
    while (n > 0) {
        s += n % 10;
        n /= 10;
    }
    return s;
}

long long potencia(int base, int exp) {
    long long r = 1;
    for (int i = 0; i < exp; i++) {
        r *= base;
    }
    return r;
}

bool es_perfecto(int n) {
    int s = 0;
    for (int d = 1; d < n; d++) {
        if (n % d == 0) {
            s += d;
        }
    }
    return n > 1 && s == n;
}

int cifras_pares(int n) {
    int cuenta = 0;
    do {
        if ((n % 10) % 2 == 0) {
            cuenta++;
        }
        n /= 10;
    } while (n > 0);
    return cuenta;
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
