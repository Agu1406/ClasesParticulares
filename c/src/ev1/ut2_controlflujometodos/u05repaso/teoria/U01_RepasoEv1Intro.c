/*
U01 — Repaso de UT1 + UT2 (hasta funciones). Aun NO es el cierre de la EV1.

OBJETIVO:
  - Ver de un vistazo las piezas vistas hasta ahora: variables, tipos, entrada,
    operadores, condicionales, bucles y funciones.
  - Resolver un problema pequeno combinando varias piezas.
  - Detectar las trampas mas habituales antes de los ejercicios de este bloque.
  - Recordar: strings (UT3) y enum/struct (UT4) van DESPUES. El cierre real
    de la EV1 esta en ut4_tiposcompuestos/teoria/U07_CierreEv1.c.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>
#include <stdbool.h>

#define IVA 0.21

static double precio_con_iva(double base);
static const char *tipo_de_dia(int dia);

int main(void) {
    printf("\n¡INICIO DEL PROGRAMA!\n\n");

    /*
    PRIMERA PARTE - Variables, tipos y casteo.
      int para enteros, double para decimales, char para un caracter,
      bool (stdbool.h) para verdadero/falso. Dividir dos int da un int.
    */
    printf("--- PRIMERA PARTE: Tipos y casteo ---\n\n");

    int a = 7;
    int b = 2;
    printf("7 / 2          = %d\n", a / b);
    printf("(double)7 / 2  = %.2f\n", (double)a / b);
    printf("7 %% 2          = %d\n", a % b);

    /*
    SEGUNDA PARTE - Condicionales.
      if / else if / else para rangos; switch para valores concretos.
      Cuidado: = asigna y == compara.
    */
    printf("\n--- SEGUNDA PARTE: Condicionales ---\n\n");

    for (int dia = 1; dia <= 7; dia += 3) {
        printf("Dia %d: %s\n", dia, tipo_de_dia(dia));
    }

    /*
    TERCERA PARTE - Bucles.
      for cuando sabes cuantas vueltas; while cuando depende de una condicion;
      do-while cuando el cuerpo debe ejecutarse al menos una vez.
    */
    printf("\n--- TERCERA PARTE: Bucles ---\n\n");

    int suma = 0;
    for (int i = 1; i <= 10; i++) {
        suma += i;
    }
    printf("Suma 1..10 con for   = %d\n", suma);

    int n = 1;
    int potencia = 1;
    while (potencia < 100) {
        potencia *= 2;
        n++;
    }
    printf("Primera potencia de 2 que supera 100: %d (tras %d pasos)\n", potencia, n - 1);

    int intentos = 0;
    do {
        intentos++;
    } while (intentos < 3);
    printf("do-while ejecutado %d veces\n", intentos);

    /*
    CUARTA PARTE - Funciones.
      Se declaran (prototipo), se definen y se llaman. Los parametros
      son copias: cambiarlos dentro no cambia la variable original.
    */
    printf("\n--- CUARTA PARTE: Funciones ---\n\n");

    printf("50.00 + IVA = %.2f\n", precio_con_iva(50.0));

    /*
    QUINTA PARTE - Combinar todo: tabla de precios con IVA.
    */
    printf("\n--- QUINTA PARTE: Todo junto ---\n\n");

    for (int base = 10; base <= 50; base += 10) {
        double total = precio_con_iva(base);
        bool caro = total > 40.0;
        printf("Base %2d -> Total %6.2f %s\n", base, total, caro ? "(caro)" : "");
    }

    /*
    SEXTA PARTE - Trampas habituales de la EV1.
      1) if (x = 5)            asigna en vez de comparar.
      2) ; despues de for/if   el cuerpo queda vacio.
      3) 7 / 2 con enteros     da 3, no 3.5.
      4) scanf("%f") con double  se necesita %lf.
      5) variable sin inicializar  contiene basura.
    */
    printf("\n--- SEXTA PARTE: Trampas ---\n\n");
    printf("Repasa la lista anterior antes de empezar los ejercicios.\n");

    printf("\n¡FIN DEL PROGRAMA!\n\n");
    return 0;
}

static double precio_con_iva(double base) {
    return base * (1.0 + IVA);
}

static const char *tipo_de_dia(int dia) {
    switch (dia) {
        case 6:
        case 7:
            return "fin de semana";
        default:
            return "laborable";
    }
}
