/*
U03 - Expresiones, precedencia y asociatividad.

OBJETIVO:
  - Conocer el orden en que C evalua los operadores (precedencia).
  - Saber que operadores se agrupan de izquierda a derecha y cuales al reves.
  - Usar parentesis para eliminar dudas.
  - Detectar errores clasicos: if (a & b == c), mezcla de && y ||, etc.
  - Distinguir precedencia (orden de agrupacion) de orden de evaluacion.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    printf("\n¡INICIO DEL PROGRAMA!\n\n");

    /*
    PRIMERA PARTE - Tabla de precedencia (de mayor a menor).
       1  ()  []  ->  .   x++  x--           (izquierda a derecha)
       2  ++x  --x  +x  -x  !  ~  (tipo)  sizeof   (derecha a izquierda)
       3  *  /  %
       4  +  -
       5  <<  >>
       6  <  <=  >  >=
       7  ==  !=
       8  &       (AND bit a bit)
       9  ^       (XOR bit a bit)
      10  |       (OR bit a bit)
      11  &&
      12  ||
      13  ? :                                  (derecha a izquierda)
      14  =  +=  -=  *=  /=  %= ...            (derecha a izquierda)
      15  ,
      No hace falta memorizarla: aprende lo comun y usa parentesis.
    */
    printf("--- PRIMERA PARTE: Aritmetica ---\n\n");

    printf("2 + 3 * 4        = %d\n", 2 + 3 * 4);
    printf("(2 + 3) * 4      = %d\n", (2 + 3) * 4);
    printf("10 - 4 - 3       = %d (izquierda a derecha)\n", 10 - 4 - 3);
    printf("100 / 5 / 2      = %d\n", 100 / 5 / 2);
    printf("-3 * 2           = %d (el menos unario se aplica primero)\n", -3 * 2);
    printf("7 %% 4 * 2        = %d (%% y * tienen la misma precedencia)\n", 7 % 4 * 2);

    /*
    SEGUNDA PARTE - Asociatividad.
      Cuando dos operadores tienen la MISMA precedencia, la asociatividad
      decide como se agrupan:
        a - b - c   ->  (a - b) - c     izquierda a derecha
        a = b = c   ->  a = (b = c)     derecha a izquierda
    */
    printf("\n--- SEGUNDA PARTE: Asociatividad ---\n\n");

    int a, b, c;
    a = b = c = 4;
    printf("a = b = c = 4 -> a=%d b=%d c=%d\n", a, b, c);
    printf("2 * 3 %% 4 = %d  (se evalua (2*3)%%4)\n", 2 * 3 % 4);

    /*
    TERCERA PARTE - Comparacion y logica.
      Precedencia: !  >  aritmeticos  >  < > <= >=  >  == !=  >  &&  >  ||
      && se agrupa ANTES que ||:
          a || b && c    equivale a    a || (b && c)
      Escribe los parentesis para que quien lea no tenga que recordarlo.
    */
    printf("\n--- TERCERA PARTE: Logica ---\n\n");

    int p = 1, q = 0, r = 0;
    // Sin parentesis (p || q && r) el compilador AVISA con -Wall, porque casi
    // siempre es un descuido. C lo leeria como p || (q && r):
    printf("p || (q && r)    = %d (asi se agrupa por defecto)\n", p || (q && r));
    printf("(p || q) && r    = %d (otro resultado: los parentesis cambian el orden)\n", (p || q) && r);
    printf("!p || q          = %d (el ! va primero)\n", !p || q);
    printf("5 + 3 > 2 * 3    = %d (aritmetica antes que comparar)\n", 5 + 3 > 2 * 3);

    /*
    CUARTA PARTE - Trampa famosa: operadores bit a bit y comparacion.
      Los operadores &, ^, | tienen MENOS precedencia que ==. Por eso:
          if (flags & 4 == 4)     -> se lee como   flags & (4 == 4)  = flags & 1
      Arreglo:  if ((flags & 4) == 4)
    */
    printf("\n--- CUARTA PARTE: & frente a == ---\n\n");

    int flags = 4;
    int mal_escrito = flags & (4 == 4);
    int bien_escrito = (flags & 4) == 4;
    printf("flags & 4 == 4   se lee flags & 1       = %d (falla)\n", mal_escrito);
    printf("(flags & 4) == 4                        = %d (correcto)\n", bien_escrito);

    /*
    QUINTA PARTE - Precedencia no es orden de evaluacion.
      En  f() + g() * h()  la precedencia dice que el * se agrupa primero,
      pero NO cual de las tres funciones se ejecuta antes. Solo &&, ||, ?: y
      la coma garantizan evaluar de izquierda a derecha.
      Moraleja: no hagas que el resultado dependa del orden de evaluacion.
    */
    printf("\n--- QUINTA PARTE: Orden de evaluacion ---\n\n");

    int fahrenheit = 98;
    int celsius = (fahrenheit - 32) * 5 / 9;
    int mal_celsius = fahrenheit - 32 * 5 / 9;
    printf("(98 - 32) * 5 / 9 = %d (correcto)\n", celsius);
    printf("98 - 32 * 5 / 9   = %d (sin parentesis, mal)\n", mal_celsius);

    printf("\n¡FIN DEL PROGRAMA!\n\n");
    return 0;
}
