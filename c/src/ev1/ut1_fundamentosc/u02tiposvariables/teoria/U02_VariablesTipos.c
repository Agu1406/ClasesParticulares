/*
U02 — Tipos de variables en C.

En la clase previa vimos como se declaran. Aqui vemos QUE se puede guardar:
  - int / long / long long (enteros)
  - float / double (decimales)
  - char (un caracter; en C es un entero pequeno)
  - bool (verdadero / falso, con <stdbool.h>)
  - const y #define (valores que no cambian)

En C el tipo se decide en compilacion y NO cambia despues.
No existe string como tipo: el texto es un array de char (UT3).

OBJETIVO:
  - Recordar los tipos basicos y su tamano tipico (sizeof).
  - Ver enteros, reales, char, bool, constantes y casteo en un solo mapa.
  - Entender trampas tipicas de C: overflow, 0.1+0.2, 'A' vs "A", (double)a/b.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>
#include <stdbool.h>
#include <limits.h>
#include <math.h>   // fabs (en Linux: -lm)

#define IVA 0.21
#define MAX_INTENTOS 3

int main(void) {
    printf("\n¡INICIO DEL PROGRAMA!\n\n");

    /*
    PRIMERA PARTE - Mapa de tipos basicos (como en C++/C#).
      En C no hay string: usamos const char * para texto de ejemplo.
    */
    printf("--- PRIMERA PARTE: Valores y sus tipos ---\n\n");

    int edad = 26;
    double altura = 1.76;
    bool soy_humano = true;
    const char *nombre = "Agustin";
    char letra = 'A';

    printf("Edad: %d - Tipo: int\n", edad);
    printf("Altura: %.2f - Tipo: double\n", altura);
    printf("Soy humano: %s - Tipo: bool\n", soy_humano ? "true" : "false");
    printf("Nombre: %s - Tipo: const char * (texto; no es String)\n", nombre);
    printf("Letra: %c - Tipo: char (codigo ASCII %d)\n", letra, letra);

    /*
    SEGUNDA PARTE - Enteros: sizeof, rangos y overflow.
      C fija minimos, no tamanos exactos. sizeof da el tamano en bytes.
      signed: desbordar es indefinido. unsigned: "da la vuelta".
    */
    printf("\n--- SEGUNDA PARTE: Enteros ---\n\n");

    printf("sizeof(int)=%lu, sizeof(long)=%lu, sizeof(long long)=%lu\n",
           (unsigned long)sizeof(int), (unsigned long)sizeof(long),
           (unsigned long)sizeof(long long));
    printf("int: %d a %d\n", INT_MIN, INT_MAX);

    long long poblacion = 8100000000LL;
    printf("Poblacion mundial aprox.: %lld (literal con LL)\n", poblacion);

    unsigned char contador = 255;
    contador = (unsigned char)(contador + 1);
    printf("unsigned char 255 + 1 = %u (da la vuelta)\n", (unsigned)contador);

    /*
    TERCERA PARTE - Reales: double por defecto, no comparar con ==.
      REGLA: usa double salvo razon concreta. 0.1 + 0.2 != 0.3 con ==.
    */
    printf("\n--- TERCERA PARTE: Reales ---\n\n");

    float f = 3.14159265358979f;
    double d = 3.14159265358979;
    printf("float  %%.10f: %.10f\n", (double)f);
    printf("double %%.10f: %.10f\n", d);

    double suma = 0.1 + 0.2;
    printf("0.1 + 0.2 con %%.17f = %.17f\n", suma);
    if (fabs(suma - 0.3) < 1e-9) {
        printf("Con epsilon SI son iguales (nunca uses == con reales)\n");
    }

    printf("7 / 2 = %d (entera) | 7.0 / 2 = %.2f (real)\n", 7 / 2, 7.0 / 2);

    /*
    CUARTA PARTE - char y bool.
      char es un numero (ASCII). 'A' != "A". bool: 0 falso, distinto de 0 verdadero.
    */
    printf("\n--- CUARTA PARTE: char y bool ---\n\n");

    char digito = '7';
    printf("'7' como caracter: %c | ASCII: %d | numero: %d\n", digito, digito, digito - '0');
    printf("'A' + 1 = %c | 'g' - 32 = %c\n", 'A' + 1, (char)('g' - 32));
    printf("sizeof(\"Hola\") = %lu ('H'+'o'+'l'+'a'+'\\0')\n", (unsigned long)sizeof("Hola"));

    bool mayor = edad >= 18;
    printf("edad >= 18 -> %s | -7 cuenta como %s\n",
           mayor ? "true" : "false", -7 ? "verdadero" : "falso");

    /*
    QUINTA PARTE - Constantes: const, #define y enum breve.
      const tiene tipo. #define es texto del preprocesador. enum: enteros con nombre.
      Convencion: NOMBRE_EN_MAYUSCULAS. Evita numeros magicos.
    */
    printf("\n--- QUINTA PARTE: Constantes ---\n\n");

    const double PI = 3.14159265358979;
    double radio = 2.5;
    printf("Area radio %.1f: %.3f\n", radio, PI * radio * radio);

    double base = 100.0;
    printf("Base %.2f + IVA -> total %.2f\n", base, base * (1 + IVA));

    int intentos = 4;
    if (intentos > MAX_INTENTOS) {
        printf("Bloqueado: %d > MAX_INTENTOS (%d)\n", intentos, MAX_INTENTOS);
    }

    enum Dia { LUNES = 1, MARTES, MIERCOLES, JUEVES, VIERNES, SABADO, DOMINGO };
    enum Dia hoy = MIERCOLES;
    printf("MIERCOLES vale %d (enum; lo profundizamos en UT4)\n", hoy);

    /*
    SEXTA PARTE - Casteo.
      Implicito hacia tipo "mayor". Explicito: (tipo)valor.
      (double)a / b  !=  (double)(a / b). Truncar double->int corta, no redondea.
    */
    printf("\n--- SEXTA PARTE: Casteo ---\n\n");

    int a = 7, b = 2;
    printf("a / b = %d | (double)a / b = %.2f | (double)(a / b) = %.2f\n",
           a / b, (double)a / b, (double)(a / b));
    printf("(int)3.99 = %d (trunca)\n", (int)3.99);

    int negativo = -1;
    unsigned int uno = 1u;
    if ((unsigned int)negativo > uno) {
        printf("Trampa: (unsigned)-1 = %u > 1 (castea a int al comparar)\n",
               (unsigned int)negativo);
    }

    /*
    SEPTIMA PARTE - Tipo fijo.
      Esto NO compila:
        int dato = 26;
        dato = "Agustin";
      Si necesitas otro tipo, declara otra variable o convierte con cast.
    */
    printf("\n--- SEPTIMA PARTE: Tipo fijo ---\n\n");
    int dato = 26;
    printf("Valor: %d, tipo: int (no puedes asignarle texto)\n", dato);
    const char *mismo_como_texto = "Agustin";
    printf("Otra variable para texto: %s\n", mismo_como_texto);

    printf("\n¡FIN DEL PROGRAMA!\n\n");
    return 0;
}
