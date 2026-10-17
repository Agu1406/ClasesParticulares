/*
E09 - Maquina de estados del semaforo (RESUELTO)

ENUNCIADO:
  Implementa Semaforo siguiente(Semaforo s) (ROJO -> VERDE -> AMARILLO -> ROJO) y int segundos(Semaforo s) con la duracion: ROJO 30, VERDE 25, AMARILLO 5.

PISTA:
  switch sobre el enum

SOLUCION:
  Todas las pruebas deben mostrar OK.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>
#include <string.h>
#include <stdbool.h>

static int pruebas = 0;
static int aciertos = 0;
#define PRUEBA(cond) do { pruebas++; if (cond) { aciertos++; printf("  [ OK  ] %s\n", #cond); } \
                          else { printf("  [FALLO] %s\n", #cond); } } while (0)


typedef enum { ROJO, AMARILLO, VERDE } Semaforo;

Semaforo siguiente(Semaforo s) {
    switch (s) {
        case ROJO: return VERDE;
        case VERDE: return AMARILLO;
        case AMARILLO: return ROJO;
    }
    return ROJO;
}

int segundos(Semaforo s) {
    switch (s) {
        case ROJO: return 30;
        case VERDE: return 25;
        case AMARILLO: return 5;
    }
    return 0;
}

int main(void) {
    PRUEBA(siguiente(ROJO) == VERDE);
    PRUEBA(siguiente(VERDE) == AMARILLO);
    PRUEBA(siguiente(AMARILLO) == ROJO);
    PRUEBA(segundos(ROJO) == 30);
    PRUEBA(segundos(VERDE) == 25);
    PRUEBA(segundos(AMARILLO) == 5);
    int total = 0;
    Semaforo s = ROJO;
    for (int i = 0; i < 3; i++) {
        total += segundos(s);
        s = siguiente(s);
    }
    PRUEBA(total == 60 && s == ROJO);

    printf("Resultado: %d/%d pruebas correctas\n", aciertos, pruebas);
    return aciertos == pruebas ? 0 : 1;
}
