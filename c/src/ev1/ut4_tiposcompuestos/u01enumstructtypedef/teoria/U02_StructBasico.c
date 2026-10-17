/*
U02 - Estructuras (struct): agrupar datos relacionados.

OBJETIVO:
  - Declarar un struct y crear variables de ese tipo.
  - Acceder a los campos con el operador punto (.).
  - Inicializar con llaves (posicional y designada).
  - Copiar structs con = y comprobar que se copian por valor.
  - Mostrar un struct campo a campo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>
#include <string.h>

struct Punto {
    double x;
    double y;
};

struct Alumno {
    char nombre[30];
    int edad;
    double nota;
};

int main(void) {
    printf("\n¡INICIO DEL PROGRAMA!\n\n");

    /*
    PRIMERA PARTE - Declarar y usar.
      struct Nombre { tipo campo; ... };   define el tipo (una plantilla).
      struct Nombre variable;               crea una variable con esos campos.
      variable.campo                        accede a un campo.
    */
    printf("--- PRIMERA PARTE: Campos ---\n\n");

    struct Punto p;
    p.x = 3.0;
    p.y = 4.5;
    printf("Punto: (%.1f, %.1f)\n", p.x, p.y);

    /*
    SEGUNDA PARTE - Inicializacion.
      Posicional: en el orden de los campos.
      Designada (C99): por nombre; el resto queda a 0. Mas legible y segura.
    */
    printf("\n--- SEGUNDA PARTE: Inicializar ---\n\n");

    struct Punto a = {1.0, 2.0};
    struct Punto b = {.y = 7.5};            // x queda a 0
    struct Punto c = {0};                   // todo a cero
    printf("a=(%.1f, %.1f) b=(%.1f, %.1f) c=(%.1f, %.1f)\n", a.x, a.y, b.x, b.y, c.x, c.y);

    /*
    TERCERA PARTE - Cadenas dentro de un struct.
      Un campo char[30] guarda una cadena. NO se asigna con =: se usa strcpy
      (o snprintf) con cuidado de la capacidad.
    */
    printf("\n--- TERCERA PARTE: Campo cadena ---\n\n");

    struct Alumno alumno = {"Lucia", 17, 8.5};
    printf("%s, %d anios, nota %.1f\n", alumno.nombre, alumno.edad, alumno.nota);

    struct Alumno otro = {.edad = 18, .nota = 6.0};
    snprintf(otro.nombre, sizeof(otro.nombre), "%s", "Marcos");
    printf("%s, %d anios, nota %.1f\n", otro.nombre, otro.edad, otro.nota);

    /*
    CUARTA PARTE - Copiar structs.
      s2 = s1 copia TODOS los campos (incluidos los arrays internos).
      Son independientes: cambiar uno no cambia el otro.
    */
    printf("\n--- CUARTA PARTE: Copia por valor ---\n\n");

    struct Alumno copia = alumno;
    copia.nota = 10.0;
    strcpy(copia.nombre, "Clon");
    printf("Original: %s %.1f | Copia: %s %.1f\n", alumno.nombre, alumno.nota, copia.nombre, copia.nota);

    /*
    QUINTA PARTE - No se comparan con ==.
      if (a == b) no compila para structs. Se comparan campo a campo.
    */
    printf("\n--- QUINTA PARTE: Comparar ---\n\n");

    struct Punto q = {1.0, 2.0};
    int iguales = (a.x == q.x && a.y == q.y);
    printf("a y q son iguales? %s\n", iguales ? "si" : "no");

    /*
    SEXTA PARTE - Operaciones tipicas.
    */
    printf("\n--- SEXTA PARTE: Operar con campos ---\n\n");

    struct Punto medio = {(a.x + b.x) / 2.0, (a.y + b.y) / 2.0};
    printf("Punto medio entre a y b: (%.2f, %.2f)\n", medio.x, medio.y);
    printf("sizeof(struct Punto) = %zu\n", sizeof(struct Punto));

    printf("\n¡FIN DEL PROGRAMA!\n\n");
    return 0;
}
