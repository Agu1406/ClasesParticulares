/*
U04 - Structs y funciones: por valor, por puntero y const.

OBJETIVO:
  - Pasar un struct por valor (copia) y ver que no modifica el original.
  - Pasar un struct por puntero (usando el operador flecha ->) para modificarlo.
  - Usar const para pasar sin copiar y sin permitir cambios.
  - Devolver un struct desde una funcion ("constructores").

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>
#include <math.h>

typedef struct {
    double x;
    double y;
} Punto;

typedef struct {
    char nombre[20];
    int vida;
    int ataque;
} Personaje;

static void mover_por_valor(Punto p, double dx, double dy);
static void mover(Punto *p, double dx, double dy);
static double distancia(const Punto *a, const Punto *b);
static Punto crear_punto(double x, double y);
static Punto sumar_puntos(Punto a, Punto b);
static void atacar(const Personaje *atacante, Personaje *objetivo);
static void mostrar(const Personaje *p);

int main(void) {
    printf("\n¡INICIO DEL PROGRAMA!\n\n");

    /*
    PRIMERA PARTE - Por valor: la funcion trabaja con una COPIA.
    */
    printf("--- PRIMERA PARTE: Por valor ---\n\n");

    Punto p = {1.0, 1.0};
    mover_por_valor(p, 10.0, 10.0);
    printf("Despues de mover_por_valor: (%.1f, %.1f)  (no cambia)\n", p.x, p.y);

    /*
    SEGUNDA PARTE - Por puntero: la funcion modifica el ORIGINAL.
      Con un puntero a struct se usa la flecha:  p->x  es igual que (*p).x
    */
    printf("\n--- SEGUNDA PARTE: Por puntero ---\n\n");

    mover(&p, 10.0, 10.0);
    printf("Despues de mover: (%.1f, %.1f)  (si cambia)\n", p.x, p.y);

    /*
    TERCERA PARTE - const: sin copiar y sin poder modificar.
      Para structs grandes es mas eficiente pasar un puntero que copiar todo;
      con const el compilador garantiza que solo se lee.
    */
    printf("\n--- TERCERA PARTE: const Puntero ---\n\n");

    Punto origen = {0.0, 0.0};
    Punto destino = {3.0, 4.0};
    printf("Distancia entre (0,0) y (3,4) = %.1f\n", distancia(&origen, &destino));

    /*
    CUARTA PARTE - Devolver un struct.
      Un struct se puede devolver por valor sin problema (a diferencia de un array).
    */
    printf("\n--- CUARTA PARTE: Devolver struct ---\n\n");

    Punto a = crear_punto(1.5, 2.5);
    Punto b = crear_punto(0.5, 0.5);
    Punto s = sumar_puntos(a, b);
    printf("(%.1f, %.1f) + (%.1f, %.1f) = (%.1f, %.1f)\n", a.x, a.y, b.x, b.y, s.x, s.y);

    /*
    QUINTA PARTE - Ejemplo: mini juego.
    */
    printf("\n--- QUINTA PARTE: Personajes ---\n\n");

    Personaje heroe = {"Heroe", 100, 25};
    Personaje orco = {"Orco", 60, 15};
    mostrar(&heroe);
    mostrar(&orco);
    atacar(&heroe, &orco);
    atacar(&orco, &heroe);
    atacar(&heroe, &orco);
    mostrar(&heroe);
    mostrar(&orco);

    printf("\n¡FIN DEL PROGRAMA!\n\n");
    return 0;
}

static void mover_por_valor(Punto p, double dx, double dy) {
    p.x += dx;                  // solo cambia la copia
    p.y += dy;
}

static void mover(Punto *p, double dx, double dy) {
    p->x += dx;
    p->y += dy;
}

static double distancia(const Punto *a, const Punto *b) {
    double dx = b->x - a->x;
    double dy = b->y - a->y;
    return sqrt(dx * dx + dy * dy);
}

static Punto crear_punto(double x, double y) {
    Punto p = {x, y};
    return p;
}

static Punto sumar_puntos(Punto a, Punto b) {
    return crear_punto(a.x + b.x, a.y + b.y);
}

static void atacar(const Personaje *atacante, Personaje *objetivo) {
    objetivo->vida -= atacante->ataque;
    if (objetivo->vida < 0) {
        objetivo->vida = 0;
    }
    printf("%s ataca a %s (%d de dano)\n", atacante->nombre, objetivo->nombre, atacante->ataque);
}

static void mostrar(const Personaje *p) {
    printf("%-6s vida=%3d ataque=%2d\n", p->nombre, p->vida, p->ataque);
}
