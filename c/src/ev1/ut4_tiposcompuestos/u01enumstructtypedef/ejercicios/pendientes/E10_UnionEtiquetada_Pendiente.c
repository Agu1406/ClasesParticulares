/*
E10 - Union etiquetada: valor entero, real o texto (PENDIENTE)

ENUNCIADO:
  Con el tipo Dato (union etiquetada), implementa void describir(const Dato *d, char *salida, size_t cap) que escriba:
  'entero:42', 'real:2.50' (2 decimales) o 'texto:hola' segun el tipo activo.

PISTA:
  snprintf con el campo correcto del switch

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


typedef enum { TIPO_ENTERO, TIPO_REAL, TIPO_TEXTO } Tipo;

typedef struct {
    Tipo tipo;
    union {
        int entero;
        double real;
        char texto[16];
    } valor;
} Dato;

void describir(const Dato *d, char *salida, size_t cap) {
    // TODO: escribe la descripcion segun el tipo
    (void)d;
    (void)cap;
    salida[0] = '\0';
}

int main(void) {
    char buf[32];
    Dato a;
    a.tipo = TIPO_ENTERO;
    a.valor.entero = 42;
    describir(&a, buf, sizeof(buf));
    PRUEBA(strcmp(buf, "entero:42") == 0);
    Dato b;
    b.tipo = TIPO_REAL;
    b.valor.real = 2.5;
    describir(&b, buf, sizeof(buf));
    PRUEBA(strcmp(buf, "real:2.50") == 0);
    Dato c;
    c.tipo = TIPO_TEXTO;
    strcpy(c.valor.texto, "hola");
    describir(&c, buf, sizeof(buf));
    PRUEBA(strcmp(buf, "texto:hola") == 0);

    printf("Resultado: %d/%d pruebas correctas\n", aciertos, pruebas);
    return aciertos == pruebas ? 0 : 1;
}
