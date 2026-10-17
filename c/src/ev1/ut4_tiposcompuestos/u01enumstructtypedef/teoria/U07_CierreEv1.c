/*
U07 — Cierre de la EV1: enum + struct + funciones juntos.

OBJETIVO:
  - Combinar en un solo programa lo de UT1-UT4: tipos, funciones, cadenas, enum y struct.
  - Ver el flujo habitual: datos -> validar -> calcular -> mostrar.
  - Dejar claro que ESTE es el cierre de la EV1 (el u05repaso de UT2 era solo hasta funciones).
  - Preparar el salto a EV2: arrays, punteros y memoria dinamica.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>
#include <string.h>

enum Curso { DAM, DAW, ASIR };

typedef struct {
    char nombre[32];
    enum Curso curso;
    double nota_ut1;
    double nota_ut2;
} Alumno;

static const char *nombre_curso(enum Curso c);
static double media(const Alumno *a);
static int esta_aprobado(const Alumno *a);
static void imprimir_ficha(const Alumno *a);

int main(void) {
    printf("\n¡INICIO DEL PROGRAMA!\n\n");

    /*
    PRIMERA PARTE - Un alumno es un struct, su ciclo es un enum.
      En vez de 4 variables sueltas (nombre, curso, nota1, nota2)
      las agrupamos. Asi se pasan juntas a una funcion.
    */
    printf("--- PRIMERA PARTE: Datos agrupados ---\n\n");

    Alumno edu;
    strcpy(edu.nombre, "Edu");
    edu.curso = DAM;
    edu.nota_ut1 = 7.5;
    edu.nota_ut2 = 8.0;

    Alumno lucia = { "Lucia", DAW, 4.0, 5.5 };

    imprimir_ficha(&edu);
    printf("\n");
    imprimir_ficha(&lucia);

    /*
    SEGUNDA PARTE - El flujo de un programa de clase.
      1. Entrada (aqui los datos van puestos a mano; en UT1 se hacia con scanf).
      2. Validar (notas entre 0 y 10).
      3. Calcular (media, aprobado).
      4. Mostrar (ficha).
      Si un programa no se entiende, casi siempre falta uno de estos cuatro.
    */
    printf("\n--- SEGUNDA PARTE: Flujo entrada-validar-calcular-mostrar ---\n\n");
    printf("Entrada -> Validar -> Calcular -> Mostrar\n");
    printf("Media de Edu:   %.2f\n", media(&edu));
    printf("Media de Lucia: %.2f\n", media(&lucia));

    /*
    TERCERA PARTE - Mapa de la EV1 (para el dia del examen).
      UT1  entorno, tipos, printf/scanf
      UT2  operadores, if/switch, bucles, funciones, depuracion
      UT3  cadenas (array de char + caracter nulo)
      UT4  enum, struct, typedef, union
      Fuera de EV1: arrays como tema, punteros avanzados, malloc, ficheros.
    */
    printf("\n--- TERCERA PARTE: Mapa EV1 ---\n\n");
    printf("UT1 entorno y tipos | UT2 control y funciones\n");
    printf("UT3 cadenas         | UT4 enum / struct / typedef\n");
    printf("Siguiente (EV2): arrays, punteros, memoria dinamica, ficheros.\n");

    printf("\n¡FIN DEL PROGRAMA!\n\n");
    return 0;
}

static const char *nombre_curso(enum Curso c) {
    if (c == DAM) {
        return "DAM";
    }
    if (c == DAW) {
        return "DAW";
    }
    return "ASIR";
}

static double media(const Alumno *a) {
    return (a->nota_ut1 + a->nota_ut2) / 2.0;
}

static int esta_aprobado(const Alumno *a) {
    return media(a) >= 5.0;
}

static void imprimir_ficha(const Alumno *a) {
    printf("Alumno : %s\n", a->nombre);
    printf("Curso  : %s\n", nombre_curso(a->curso));
    printf("Media  : %.2f (%s)\n", media(a), esta_aprobado(a) ? "aprobado" : "suspenso");
}
