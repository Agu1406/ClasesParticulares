/*
U05 - Uniones (union) y uniones etiquetadas.

OBJETIVO:
  - Entender que en una union todos los campos comparten la misma memoria.
  - Usar una union con un enum que indique el tipo activo (union etiquetada).
  - Ver el tamano de una union frente al de un struct.
  - Conocer su uso real: valores que pueden ser de varios tipos.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>
#include <string.h>

union Numero {
    int entero;
    double real;
    char caracter;
};

struct Campos {
    int entero;
    double real;
    char caracter;
};

typedef enum { TIPO_ENTERO, TIPO_REAL, TIPO_TEXTO } Tipo;

typedef struct {
    Tipo tipo;                  // la "etiqueta": que campo esta en uso
    union {
        int entero;
        double real;
        char texto[16];
    } valor;
} Dato;

static Dato dato_entero(int v);
static Dato dato_real(double v);
static Dato dato_texto(const char *t);
static void mostrar_dato(const Dato *d);

int main(void) {
    printf("\n¡INICIO DEL PROGRAMA!\n\n");

    /*
    PRIMERA PARTE - Memoria compartida.
      En un struct cada campo tiene su propio sitio.
      En una union todos los campos ocupan el MISMO sitio: solo uno
      es valido a la vez. El tamano es el del campo mas grande.
    */
    printf("--- PRIMERA PARTE: Tamano ---\n\n");

    printf("sizeof(struct Campos) = %zu\n", sizeof(struct Campos));
    printf("sizeof(union Numero)  = %zu\n", sizeof(union Numero));

    /*
    SEGUNDA PARTE - Escribir un campo "pisa" a los demas.
    */
    printf("\n--- SEGUNDA PARTE: Un solo valor activo ---\n\n");

    union Numero n;
    n.entero = 65;
    printf("Tras guardar el entero 65: entero = %d\n", n.entero);
    n.real = 3.5;
    printf("Tras guardar el real 3.5:  real   = %.1f\n", n.real);
    printf("(Leer 'entero' ahora daria basura: el real ocupo su sitio)\n");

    /*
    TERCERA PARTE - Union etiquetada: la forma segura de usarla.
      Un enum guarda cual es el tipo activo; se consulta antes de leer.
    */
    printf("\n--- TERCERA PARTE: Union etiquetada ---\n\n");

    Dato datos[3];
    datos[0] = dato_entero(42);
    datos[1] = dato_real(2.718);
    datos[2] = dato_texto("hola");
    for (int i = 0; i < 3; i++) {
        mostrar_dato(&datos[i]);
    }

    /*
    CUARTA PARTE - Cuando usarla.
      - Ahorrar memoria cuando un dato puede ser de uno u otro tipo.
      - Representar "variantes" (mensajes, tokens, valores JSON).
      - Siempre con una etiqueta; nunca leas un campo distinto al ultimo escrito.
    */
    printf("\n--- CUARTA PARTE: Resumen ---\n\n");
    printf("sizeof(Dato) = %zu\n", sizeof(Dato));

    printf("\n¡FIN DEL PROGRAMA!\n\n");
    return 0;
}

static Dato dato_entero(int v) {
    Dato d;
    d.tipo = TIPO_ENTERO;
    d.valor.entero = v;
    return d;
}

static Dato dato_real(double v) {
    Dato d;
    d.tipo = TIPO_REAL;
    d.valor.real = v;
    return d;
}

static Dato dato_texto(const char *t) {
    Dato d;
    d.tipo = TIPO_TEXTO;
    snprintf(d.valor.texto, sizeof(d.valor.texto), "%s", t);
    return d;
}

static void mostrar_dato(const Dato *d) {
    switch (d->tipo) {
        case TIPO_ENTERO:
            printf("Entero: %d\n", d->valor.entero);
            break;
        case TIPO_REAL:
            printf("Real:   %.3f\n", d->valor.real);
            break;
        case TIPO_TEXTO:
            printf("Texto:  %s\n", d->valor.texto);
            break;
    }
}
