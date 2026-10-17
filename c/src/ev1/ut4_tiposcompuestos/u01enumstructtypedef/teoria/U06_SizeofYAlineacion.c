/*
U06 - sizeof, alineacion y relleno (padding) en structs.

OBJETIVO:
  - Ver que el tamano de un struct puede ser mayor que la suma de sus campos.
  - Entender la alineacion: cada campo se coloca en una direccion multiplo de su tamano.
  - Usar offsetof para ver donde empieza cada campo.
  - Reordenar los campos para ahorrar memoria.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>
#include <stddef.h>

struct Desordenado {
    char a;         // 1 byte
    double b;       // 8 bytes
    char c;         // 1 byte
    int d;          // 4 bytes
};

struct Ordenado {
    double b;       // 8 bytes
    int d;          // 4 bytes
    char a;         // 1 byte
    char c;         // 1 byte
};

int main(void) {
    printf("\n¡INICIO DEL PROGRAMA!\n\n");

    /*
    PRIMERA PARTE - Suma de campos frente a tamano real.
      Campos: 1 + 8 + 1 + 4 = 14 bytes, pero sizeof es mayor porque el
      compilador inserta "relleno" para alinear cada campo.
      (Los numeros exactos dependen de la plataforma; en la mayoria 24 y 16.)
    */
    printf("--- PRIMERA PARTE: sizeof ---\n\n");

    printf("Suma de los campos             : %zu\n",
           sizeof(char) + sizeof(double) + sizeof(char) + sizeof(int));
    printf("sizeof(struct Desordenado)     : %zu\n", sizeof(struct Desordenado));
    printf("sizeof(struct Ordenado)        : %zu\n", sizeof(struct Ordenado));

    /*
    SEGUNDA PARTE - Donde empieza cada campo (offsetof).
    */
    printf("\n--- SEGUNDA PARTE: offsetof ---\n\n");

    printf("Desordenado: a=%zu b=%zu c=%zu d=%zu\n",
           offsetof(struct Desordenado, a), offsetof(struct Desordenado, b),
           offsetof(struct Desordenado, c), offsetof(struct Desordenado, d));
    printf("Ordenado   : b=%zu d=%zu a=%zu c=%zu\n",
           offsetof(struct Ordenado, b), offsetof(struct Ordenado, d),
           offsetof(struct Ordenado, a), offsetof(struct Ordenado, c));

    /*
    TERCERA PARTE - Regla practica.
      Ordena los campos de MAYOR a MENOR tamano: se pierde menos en relleno.
      Importa cuando se crean muchos structs (miles o millones).
    */
    printf("\n--- TERCERA PARTE: Regla practica ---\n\n");

    size_t perdido = sizeof(struct Desordenado) - sizeof(struct Ordenado);
    printf("Ordenando los campos se ahorran %zu bytes por struct\n", perdido);

    /*
    CUARTA PARTE - sizeof con variables, tipos y arrays.
    */
    printf("\n--- CUARTA PARTE: Usos de sizeof ---\n\n");

    int numeros[10];
    printf("sizeof(int)        = %zu\n", sizeof(int));
    printf("sizeof(numeros)    = %zu\n", sizeof(numeros));
    printf("elementos de array = %zu\n", sizeof(numeros) / sizeof(numeros[0]));
    printf("sizeof(long long)  = %zu\n", sizeof(long long));
    printf("sizeof(void *)     = %zu (32 o 64 bits segun la maquina)\n", sizeof(void *));

    printf("\n¡FIN DEL PROGRAMA!\n\n");
    return 0;
}
