/*
U02 — Tipos de variables en C.

Que se puede guardar en una variable:
  - int / long / long long (enteros)
  - float / double (decimales; usa double por defecto)
  - char (un caracter; en C es un entero pequeno)
  - bool (0 o 1, con <stdbool.h>)
  - const y #define (valores que no cambian)

El tipo se fija al declarar y NO cambia. No hay tipo String:
el texto es un array de char (se ve en UT3).

OBJETIVO:
  - Ver el mapa de tipos basicos con sizeof y printf.
  - Conocer trampas de C: overflow, 0.1+0.2, 'A' vs "A", casteo en division.
  - Distinguir const, #define y un enum corto.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>
#include <stdbool.h>
#include <limits.h>
#include <math.h>   /* fabs; en Linux/macOS: -lm */

#define IVA 0.21
#define MAX_INTENTOS 3

int main(void) {
    printf("\n¡INICIO DEL PROGRAMA!\n\n");

    /*
    PRIMERA PARTE - Valores y sus tipos.
      Para mostrar un bool usa %d (sale 0 o 1). No existe String.
    */
    printf("--- PRIMERA PARTE: Valores y sus tipos ---\n\n");

    int edad = 26;
    double altura = 1.76;
    bool soy_humano = true;
    const char *nombre = "Agustin";
    char letra = 'A';

    printf("Edad: %d  (int)\n", edad);
    printf("Altura: %.2f  (double)\n", altura);
    printf("Soy humano: %d  (bool: 1=si, 0=no)\n", soy_humano);
    printf("Nombre: %s  (const char *; texto hasta UT3)\n", nombre);
    printf("Letra: %c  (char; ASCII %d)\n", letra, letra);

    /*
    SEGUNDA PARTE - Enteros: sizeof, rangos y overflow.
      sizeof da bytes. signed: desbordar es indefinido.
      unsigned: al pasarse "da la vuelta".
    */
    printf("\n--- SEGUNDA PARTE: Enteros ---\n\n");

    printf("sizeof(int)=%lu, sizeof(long)=%lu, sizeof(long long)=%lu\n",
           (unsigned long)sizeof(int), (unsigned long)sizeof(long),
           (unsigned long)sizeof(long long));
    printf("int: %d a %d\n", INT_MIN, INT_MAX);

    long long poblacion = 8100000000LL;
    printf("Poblacion aprox.: %lld (sufijo LL)\n", poblacion);

    unsigned char contador = 255;
    contador = (unsigned char)(contador + 1);
    printf("unsigned char 255 + 1 = %u (da la vuelta)\n", (unsigned)contador);

    /*
    TERCERA PARTE - Reales: no compares con ==.
    */
    printf("\n--- TERCERA PARTE: Reales ---\n\n");

    float f = 3.14159265358979f;
    double d = 3.14159265358979;
    printf("float  %.10f\n", (double)f);
    printf("double %.10f\n", d);

    double suma = 0.1 + 0.2;
    printf("0.1 + 0.2 con muchos decimales: %.17f\n", suma);
    if (fabs(suma - 0.3) < 1e-9) {
        printf("Con tolerancia SI son iguales (nunca uses == con double)\n");
    }
    printf("7 / 2 = %d (entera) | 7.0 / 2 = %.2f (real)\n", 7 / 2, 7.0 / 2);

    /*
    CUARTA PARTE - char y bool.
      'A' es un char. "A" es texto (dos bytes: 'A' y '\\0').
    */
    printf("\n--- CUARTA PARTE: char y bool ---\n\n");

    char digito = '7';
    printf("'7' como caracter: %c | ASCII: %d | valor numerico: %d\n",
           digito, digito, digito - '0');
    printf("'A' + 1 = %c | 'g' - 32 = %c\n", 'A' + 1, (char)('g' - 32));
    printf("sizeof(\"Hola\") = %lu (4 letras + '\\0')\n", (unsigned long)sizeof("Hola"));

    bool mayor = edad >= 18;
    printf("edad >= 18 -> %d | el valor -7 en un if cuenta como verdadero\n", mayor);

    /*
    QUINTA PARTE - Constantes: const, #define, enum breve.
    */
    printf("\n--- QUINTA PARTE: Constantes ---\n\n");

    const double PI = 3.14159265358979;
    double radio = 2.5;
    printf("Area radio %.1f: %.3f\n", radio, PI * radio * radio);

    double base = 100.0;
    printf("Base %.2f + IVA -> total %.2f\n", base, base * (1.0 + IVA));

    int intentos = 4;
    if (intentos > MAX_INTENTOS) {
        printf("Bloqueado: %d > MAX_INTENTOS (%d)\n", intentos, MAX_INTENTOS);
    }

    enum Dia { LUNES = 1, MARTES, MIERCOLES, JUEVES, VIERNES, SABADO, DOMINGO };
    enum Dia hoy = MIERCOLES;
    printf("MIERCOLES vale %d (enum; detalle en UT4)\n", hoy);

    /*
    SEXTA PARTE - Casteo.
      (double)a / b  !=  (double)(a / b)
    */
    printf("\n--- SEXTA PARTE: Casteo ---\n\n");

    int a = 7, b = 2;
    printf("a / b = %d | (double)a / b = %.2f | (double)(a / b) = %.2f\n",
           a / b, (double)a / b, (double)(a / b));
    printf("(int)3.99 = %d (trunca, no redondea)\n", (int)3.99);

    int negativo = -1;
    unsigned int uno = 1u;
    if ((unsigned int)negativo > uno) {
        printf("Trampa: (unsigned)-1 = %u > 1\n", (unsigned int)negativo);
    }

    /*
    SEPTIMA PARTE - Tipo fijo.
      int dato = 26;  dato = "texto";  -> no compila.
    */
    printf("\n--- SEPTIMA PARTE: Tipo fijo ---\n\n");
    int dato = 26;
    printf("dato = %d (int). Para texto usa otra variable.\n", dato);
    const char *texto = "Agustin";
    printf("texto = %s\n", texto);

    printf("\n¡FIN DEL PROGRAMA!\n\n");
    return 0;
}
