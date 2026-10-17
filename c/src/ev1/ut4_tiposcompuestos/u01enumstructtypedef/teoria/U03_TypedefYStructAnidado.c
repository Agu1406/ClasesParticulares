/*
U03 - typedef y structs anidados.

OBJETIVO:
  - Usar typedef para no escribir "struct" cada vez.
  - Anidar un struct dentro de otro (composicion).
  - Combinar enum y struct en un mismo tipo.
  - Inicializar estructuras anidadas.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>
#include <string.h>

/* typedef: crea un alias. Convencion: nombres de tipo en CamelCase. */
typedef struct {
    int dia;
    int mes;
    int anio;
} Fecha;

typedef enum { ESTUDIANTE, PROFESOR, ADMINISTRATIVO } Rol;

typedef struct {
    char nombre[30];
    Fecha nacimiento;           // struct anidado
    Rol rol;
} Persona;

typedef struct {
    double x;
    double y;
} Punto;

typedef struct {
    Punto esquina;              // esquina superior izquierda
    double ancho;
    double alto;
} Rectangulo;

static const char *texto_rol(Rol r);
static int edad_en(const Persona *p, Fecha hoy);

int main(void) {
    printf("\n¡INICIO DEL PROGRAMA!\n\n");

    /*
    PRIMERA PARTE - typedef.
      Sin typedef:  struct Punto p;
      Con typedef:  Punto p;
      typedef struct { ... } Nombre;  declara un struct anonimo y le pone nombre.
    */
    printf("--- PRIMERA PARTE: typedef ---\n\n");

    Punto p = {2.0, 3.0};
    printf("Punto: (%.1f, %.1f)\n", p.x, p.y);

    /*
    SEGUNDA PARTE - Struct dentro de otro struct.
      Se accede encadenando puntos: persona.nacimiento.anio
    */
    printf("\n--- SEGUNDA PARTE: Anidados ---\n\n");

    Persona ana = {"Ana Lopez", {14, 3, 2008}, ESTUDIANTE};
    printf("%s nacio el %02d/%02d/%d (%s)\n", ana.nombre, ana.nacimiento.dia,
           ana.nacimiento.mes, ana.nacimiento.anio, texto_rol(ana.rol));

    Persona luis = {
        .nombre = "Luis Perez",
        .nacimiento = {.dia = 2, .mes = 11, .anio = 1980},
        .rol = PROFESOR
    };
    printf("%s nacio el %02d/%02d/%d (%s)\n", luis.nombre, luis.nacimiento.dia,
           luis.nacimiento.mes, luis.nacimiento.anio, texto_rol(luis.rol));

    /*
    TERCERA PARTE - Calcular con los campos anidados.
    */
    printf("\n--- TERCERA PARTE: Edad ---\n\n");

    Fecha hoy = {13, 10, 2026};
    printf("%s tiene %d anios\n", ana.nombre, edad_en(&ana, hoy));
    printf("%s tiene %d anios\n", luis.nombre, edad_en(&luis, hoy));

    /*
    CUARTA PARTE - Composicion: un rectangulo contiene un punto.
    */
    printf("\n--- CUARTA PARTE: Rectangulo con esquina ---\n\n");

    Rectangulo r = {{1.0, 5.0}, 4.0, 2.5};
    printf("Esquina (%.1f, %.1f), ancho %.1f, alto %.1f, area %.2f\n",
           r.esquina.x, r.esquina.y, r.ancho, r.alto, r.ancho * r.alto);

    /*
    QUINTA PARTE - Cuando usar struct y cuando enum.
      enum:   un valor entre varios posibles (Rol, Estado, Color).
      struct: varios datos distintos que forman una cosa (Persona, Fecha).
      Los dos se combinan: una Persona TIENE un Rol.
    */
    printf("\n--- QUINTA PARTE: Resumen ---\n\n");
    printf("sizeof(Fecha) = %zu | sizeof(Persona) = %zu\n", sizeof(Fecha), sizeof(Persona));

    printf("\n¡FIN DEL PROGRAMA!\n\n");
    return 0;
}

static const char *texto_rol(Rol r) {
    switch (r) {
        case ESTUDIANTE: return "estudiante";
        case PROFESOR: return "profesor";
        case ADMINISTRATIVO: return "administrativo";
    }
    return "desconocido";
}

static int edad_en(const Persona *p, Fecha hoy) {
    int edad = hoy.anio - p->nacimiento.anio;
    if (hoy.mes < p->nacimiento.mes ||
        (hoy.mes == p->nacimiento.mes && hoy.dia < p->nacimiento.dia)) {
        edad--;
    }
    return edad;
}
