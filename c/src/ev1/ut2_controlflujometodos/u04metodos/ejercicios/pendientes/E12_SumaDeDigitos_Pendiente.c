/*
E12 - Suma de las cifras (PENDIENTE)

ENUNCIADO:
  Implementa int suma_digitos(int n) (n >= 0) con un while. Haz tambien int numero_de_cifras(int n).

PISTA:
  El 0 tiene una cifra

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

static int pruebas = 0;
static int aciertos = 0;
#define PRUEBA(cond) do { pruebas++; if (cond) { aciertos++; printf("  [ OK  ] %s\n", #cond); } \
                          else { printf("  [FALLO] %s\n", #cond); } } while (0)


int suma_digitos(int n) {
    // TODO: suma las cifras de n
    return 0;
}

int numero_de_cifras(int n) {
    // TODO: cuenta las cifras de n (el 0 tiene 1)
    return 0;
}

int main(void) {
    PRUEBA(suma_digitos(0) == 0);
    PRUEBA(suma_digitos(123) == 6);
    PRUEBA(suma_digitos(9999) == 36);
    PRUEBA(numero_de_cifras(0) == 1);
    PRUEBA(numero_de_cifras(7) == 1);
    PRUEBA(numero_de_cifras(123456) == 6);

    printf("Resultado: %d/%d pruebas correctas\n", aciertos, pruebas);
    return aciertos == pruebas ? 0 : 1;
}
