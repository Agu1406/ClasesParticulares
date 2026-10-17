/*
Practica ejemplo (depuracion): cinco funciones con errores (SIN RESOLVER)

ENUNCIADO:
  Las cinco funciones de este fichero tienen un error cada una y fallan alguna prueba.
  Encuentralas con printf o con el depurador y corrigelas hasta ver 'Resultado: 5/5 pruebas correctas'.

PISTA:
  Una prueba que falla apunta a la funcion; una traza con printf apunta a la linea.

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

// TODO: suma_pares: suma de los pares de 1 a n (inclusive). BUG: el bucle no llega a n
int suma_pares(int n) {
int s = 0;
for (int i = 1; i < n; i++) {
    if (i % 2 == 0) {
        s += i;
    }
}
return s;
}

// TODO: media_enteros: media de dos enteros como double. BUG: division entera
double media_enteros(int a, int b) {
    return (a + b) / 2;
}

// TODO: es_bisiesto: BUG: no respeta la regla de los multiplos de 100 y 400
bool es_bisiesto(int anio) {
    return anio % 4 == 0;
}

// TODO: contar_cifras: BUG: el 0 deberia tener una cifra
int contar_cifras(int n) {
    int c = 0;
    while (n > 0) {
        c++;
        n /= 10;
    }
    return c;
}

// TODO: minimo3: BUG: no considera todos los casos
int minimo3(int a, int b, int c) {
    if (a < b) {
        return a < c ? a : c;
    }
    return b;
}

int main(void) {
    PRUEBA(suma_pares(10) == 30 && suma_pares(1) == 0 && suma_pares(2) == 2);
    PRUEBA(media_enteros(2, 3) == 2.5 && media_enteros(4, 4) == 4.0);
    PRUEBA(es_bisiesto(2024) && !es_bisiesto(2023) && !es_bisiesto(1900) && es_bisiesto(2000));
    PRUEBA(contar_cifras(0) == 1 && contar_cifras(9) == 1 && contar_cifras(12345) == 5);
    PRUEBA(minimo3(1, 2, 3) == 1 && minimo3(3, 2, 1) == 1 && minimo3(2, 1, 3) == 1 && minimo3(5, 5, 5) == 5);

    printf("Resultado: %d/%d pruebas correctas\n", aciertos, pruebas);
    return aciertos == pruebas ? 0 : 1;
}
