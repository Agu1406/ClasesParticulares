/*
U01 - Aserciones con assert (assert.h).

OBJETIVO:
  - Entender que es una asercion: una condicion que DEBE cumplirse.
  - Usar assert para comprobar precondiciones y postcondiciones.
  - Diferenciar entre un error del programador (assert) y un error del
    usuario (validacion con if).
  - Saber que -DNDEBUG desactiva los assert.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>
#include <assert.h>

static int dividir(int a, int b);
static int elemento(const int *v, int n, int indice);
static double raiz_cuadrada_entera(int n);

int main(void) {
    printf("\n¡INICIO DEL PROGRAMA!\n\n");

    /*
    PRIMERA PARTE - Que hace assert.
      assert(condicion): si es verdadera no pasa nada. Si es falsa el
      programa se detiene mostrando fichero, linea y la condicion:

          Assertion failed: b != 0, file U01_Assert.c, line 62

      Es una red de seguridad para el PROGRAMADOR, no un mensaje para el usuario.
    */
    printf("--- PRIMERA PARTE: assert que se cumple ---\n\n");

    int x = 10;
    assert(x > 0);
    assert(x % 2 == 0);
    printf("Las aserciones sobre x se cumplen\n");

    /*
    SEGUNDA PARTE - Precondiciones.
      Una precondicion es lo que la funcion exige a quien la llama.
      Si se incumple, el fallo esta en el codigo que llama.
    */
    printf("\n--- SEGUNDA PARTE: Precondiciones ---\n\n");

    printf("dividir(20, 4) = %d\n", dividir(20, 4));

    int datos[] = {10, 20, 30};
    printf("elemento(datos, 3, 2) = %d\n", elemento(datos, 3, 2));
    printf("raiz_cuadrada_entera(49) = %.1f\n", raiz_cuadrada_entera(49));

    /*
    TERCERA PARTE - assert NO es validacion de usuario.
      Los datos que teclea el usuario pueden ser cualquier cosa: se
      validan con if y se le avisa. assert sirve para cosas "imposibles".

        MAL:  scanf("%d", &edad); assert(edad >= 0);
        BIEN: if (edad < 0) { printf("Edad no valida\n"); }
    */
    printf("\n--- TERCERA PARTE: assert frente a validacion ---\n\n");

    int edad = -5;
    if (edad < 0) {
        printf("Edad no valida (esto es validacion de usuario)\n");
    }

    /*
    CUARTA PARTE - NDEBUG.
      Compilando con -DNDEBUG todos los assert desaparecen (versiones de
      produccion). Por eso NUNCA pongas dentro de un assert algo que deba
      ejecutarse de verdad:

        MAL:  assert(scanf("%d", &n) == 1);   // en NDEBUG no se leeria
        BIEN: int leidos = scanf("%d", &n); assert(leidos == 1);
    */
    printf("\n--- CUARTA PARTE: NDEBUG ---\n\n");
#ifdef NDEBUG
    printf("Compilado con NDEBUG: los assert estan desactivados\n");
#else
    printf("Compilado sin NDEBUG: los assert estan activos\n");
#endif

    /*
    QUINTA PARTE - static_assert (C11): comprobacion en COMPILACION.
    */
    printf("\n--- QUINTA PARTE: static_assert ---\n\n");
    static_assert(sizeof(int) >= 4, "Se necesita un int de al menos 32 bits");
    printf("static_assert superado en tiempo de compilacion\n");

    printf("\n¡FIN DEL PROGRAMA!\n\n");
    return 0;
}

static int dividir(int a, int b) {
    assert(b != 0);                       // precondicion
    return a / b;
}

static int elemento(const int *v, int n, int indice) {
    assert(v != NULL);                    // precondiciones
    assert(indice >= 0 && indice < n);
    return v[indice];
}

static double raiz_cuadrada_entera(int n) {
    assert(n >= 0);
    int r = 0;
    while ((r + 1) * (r + 1) <= n) {
        r++;
    }
    assert(r * r <= n && (r + 1) * (r + 1) > n);   // postcondicion
    return r;
}
