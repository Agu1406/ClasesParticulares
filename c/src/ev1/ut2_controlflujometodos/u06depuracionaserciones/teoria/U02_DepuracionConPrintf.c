/*
U02 - Depuracion con printf, stderr y macros de traza.

OBJETIVO:
  - Localizar errores mostrando el valor de las variables.
  - Usar stderr para mensajes de diagnostico.
  - Activar y desactivar trazas con #ifdef DEBUG / -DDEBUG.
  - Conocer __FILE__, __LINE__ y __func__.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

/*
  Macro de traza: solo hace algo si se compila con -DDEBUG.
  Se escribe en stderr para no mezclarlo con la salida normal del programa.
*/
#ifdef DEBUG
#define TRAZA(...) do { fprintf(stderr, "[DEBUG %s:%d %s] ", __FILE__, __LINE__, __func__); \
                        fprintf(stderr, __VA_ARGS__); fprintf(stderr, "\n"); } while (0)
#else
#define TRAZA(...) do { } while (0)
#endif

static int suma_de_cuadrados(int n);
static int contar_divisores(int n);

int main(void) {
    printf("\n¡INICIO DEL PROGRAMA!\n\n");

    /*
    PRIMERA PARTE - El metodo mas simple: printf.
      Antes de adivinar, MIRA los valores. Muestra las variables clave en
      cada vuelta del bucle y compara con lo que tu esperabas.
    */
    printf("--- PRIMERA PARTE: Mostrar variables ---\n\n");

    int acumulado = 0;
    for (int i = 1; i <= 4; i++) {
        acumulado += i * i;
        printf("  [traza] i=%d  acumulado=%d\n", i, acumulado);
    }
    printf("Suma de cuadrados 1..4 = %d\n", acumulado);

    /*
    SEGUNDA PARTE - Trazas que se pueden apagar.
      Compila normal: no se ve nada. Compila con -DDEBUG: aparecen
      los mensajes en stderr (la consola los muestra igualmente).

        gcc -std=c11 -DDEBUG U02_DepuracionConPrintf.c -o prog
    */
    printf("\n--- SEGUNDA PARTE: TRAZA con -DDEBUG ---\n\n");

    printf("suma_de_cuadrados(5) = %d\n", suma_de_cuadrados(5));
    printf("contar_divisores(12) = %d\n", contar_divisores(12));

    /*
    TERCERA PARTE - Informacion automatica del compilador.
      __FILE__  nombre del fichero
      __LINE__  numero de linea
      __func__  nombre de la funcion actual (C99)
    */
    printf("\n--- TERCERA PARTE: Macros predefinidas ---\n\n");

    printf("Estamos en la funcion %s, linea %d\n", __func__, __LINE__);

    /*
    CUARTA PARTE - stdout frente a stderr.
      stdout: resultados del programa. stderr: errores y diagnostico.
      Se pueden separar al ejecutar:  prog > salida.txt 2> errores.txt
    */
    printf("\n--- CUARTA PARTE: stderr ---\n\n");

    fprintf(stderr, "Este mensaje va a stderr\n");
    printf("Este mensaje va a stdout\n");

    /*
    QUINTA PARTE - Receta para depurar con printf.
      1) Reproduce el fallo con una entrada pequena y fija.
      2) Muestra entrada y salida de la funcion sospechosa.
      3) Divide el programa a la mitad: donde dejan de ser correctos los valores?
      4) Corrige UNA cosa y vuelve a probar.
      5) Quita (o desactiva con DEBUG) las trazas al terminar.
    */
    printf("\n--- QUINTA PARTE: Receta ---\n\n");
    printf("Reproducir -> Mostrar -> Acotar -> Corregir -> Limpiar\n");

    printf("\n¡FIN DEL PROGRAMA!\n\n");
    return 0;
}

static int suma_de_cuadrados(int n) {
    int suma = 0;
    for (int i = 1; i <= n; i++) {
        suma += i * i;
        TRAZA("i=%d suma=%d", i, suma);
    }
    return suma;
}

static int contar_divisores(int n) {
    int cuenta = 0;
    for (int d = 1; d <= n; d++) {
        if (n % d == 0) {
            cuenta++;
            TRAZA("divisor encontrado: %d", d);
        }
    }
    return cuenta;
}
