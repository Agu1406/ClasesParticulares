/*
U04 - Operadores bit a bit (exclusivo de la familia C).

OBJETIVO:
  - Entender los numeros en binario y mostrarlos bit a bit.
  - Usar &, |, ^, ~, << y >> sobre enteros.
  - Aplicar mascaras para activar, apagar, invertir y comprobar bits.
  - Emplear desplazamientos como multiplicar/dividir por potencias de 2.
  - Usar banderas (flags) para guardar varias opciones en un unico entero.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>
#include <stdint.h>

/* Muestra los 8 bits de un valor (el mas significativo primero). */
static void mostrar_bits(uint8_t valor) {
    for (int bit = 7; bit >= 0; bit--) {
        printf("%d", (valor >> bit) & 1);
    }
}

int main(void) {
    printf("\n¡INICIO DEL PROGRAMA!\n\n");

    /*
    PRIMERA PARTE - Numeros en binario.
      Cada bit vale una potencia de 2:  128 64 32 16 8 4 2 1
      Ejemplo: 00101101 = 32 + 8 + 4 + 1 = 45
      Se trabaja con uint8_t (8 bits sin signo) para que sea facil de leer.
    */
    printf("--- PRIMERA PARTE: Binario ---\n\n");

    uint8_t numero = 45;
    printf("%3d en binario = ", numero);
    mostrar_bits(numero);
    printf("\n");

    uint8_t otro = 12;
    printf("%3d en binario = ", otro);
    mostrar_bits(otro);
    printf("\n");

    /*
    SEGUNDA PARTE - Operadores &  |  ^  ~
      &  AND: 1 solo si ambos bits son 1       (sirve para APAGAR / COMPROBAR)
      |  OR : 1 si alguno es 1                 (sirve para ENCENDER)
      ^  XOR: 1 si los bits son DISTINTOS      (sirve para INVERTIR)
      ~  NOT: invierte todos los bits
    */
    printf("\n--- SEGUNDA PARTE: &, |, ^, ~ ---\n\n");

    uint8_t a = 45, b = 12;
    printf("a      = "); mostrar_bits(a); printf(" (%d)\n", a);
    printf("b      = "); mostrar_bits(b); printf(" (%d)\n", b);
    printf("a & b  = "); mostrar_bits((uint8_t)(a & b)); printf(" (%d)\n", a & b);
    printf("a | b  = "); mostrar_bits((uint8_t)(a | b)); printf(" (%d)\n", a | b);
    printf("a ^ b  = "); mostrar_bits((uint8_t)(a ^ b)); printf(" (%d)\n", a ^ b);
    printf("~a     = "); mostrar_bits((uint8_t)(~a)); printf(" (%d)\n", (uint8_t)(~a));

    /*
    TERCERA PARTE - Desplazamientos << y >>.
      x << n  mueve los bits n posiciones a la izquierda = x * 2^n
      x >> n  mueve los bits n posiciones a la derecha   = x / 2^n (division entera)
      Mucho mas rapido que multiplicar, y la base de hashes, graficos, etc.
    */
    printf("\n--- TERCERA PARTE: << y >> ---\n\n");

    int x = 5;
    printf("%d << 1 = %d\n", x, x << 1);
    printf("%d << 3 = %d (5 * 8)\n", x, x << 3);
    printf("%d >> 1 = %d\n", 40, 40 >> 1);
    printf("%d >> 3 = %d (40 / 8)\n", 40, 40 >> 3);
    printf("1 << 10 = %d (2 elevado a 10)\n", 1 << 10);

    /*
    CUARTA PARTE - Mascaras: trabajar con un bit concreto.
      ENCENDER el bit n:   valor |= (1 << n)
      APAGAR el bit n:     valor &= ~(1 << n)
      INVERTIR el bit n:   valor ^= (1 << n)
      COMPROBAR el bit n:  (valor >> n) & 1      o      valor & (1 << n)
    */
    printf("\n--- CUARTA PARTE: Mascaras ---\n\n");

    uint8_t v = 0;
    printf("inicial      : "); mostrar_bits(v); printf("\n");
    v |= (1 << 3);
    printf("encender 3   : "); mostrar_bits(v); printf("\n");
    v |= (1 << 0);
    printf("encender 0   : "); mostrar_bits(v); printf("\n");
    v ^= (1 << 3);
    printf("invertir 3   : "); mostrar_bits(v); printf("\n");
    v = (uint8_t)(v & ~(1 << 0));
    printf("apagar 0     : "); mostrar_bits(v); printf("\n");

    uint8_t w = 0x25;   // 00100101
    printf("bit 5 de 0x25 = %d, bit 4 de 0x25 = %d\n", (w >> 5) & 1, (w >> 4) & 1);

    /*
    QUINTA PARTE - Banderas (flags): varias opciones en un solo entero.
      Cada opcion usa un bit distinto. Es la tecnica detras de permisos de
      ficheros (rwx), opciones de ventanas, etc.
    */
    printf("\n--- QUINTA PARTE: Permisos con flags ---\n\n");

    enum { PERMISO_LEER = 1 << 0, PERMISO_ESCRIBIR = 1 << 1, PERMISO_EJECUTAR = 1 << 2 };

    int permisos = PERMISO_LEER | PERMISO_ESCRIBIR;   // 011
    printf("permisos = %d\n", permisos);
    printf("puede leer?     %s\n", (permisos & PERMISO_LEER) ? "si" : "no");
    printf("puede ejecutar? %s\n", (permisos & PERMISO_EJECUTAR) ? "si" : "no");

    permisos |= PERMISO_EJECUTAR;                     // concede ejecutar
    permisos &= ~PERMISO_ESCRIBIR;                    // retira escribir
    printf("tras cambios: leer=%d escribir=%d ejecutar=%d\n",
           (permisos & PERMISO_LEER) != 0, (permisos & PERMISO_ESCRIBIR) != 0,
           (permisos & PERMISO_EJECUTAR) != 0);

    /*
    SEXTA PARTE - Cuidado con los negativos.
      Desplazar a la izquierda un valor con signo hasta pisar el bit de
      signo, o desplazar mas bits que el ancho del tipo, es comportamiento
      indefinido. Para jugar con bits usa tipos SIN signo (unsigned, uint8_t...).
    */
    printf("\n--- SEXTA PARTE: Recomendacion ---\n\n");
    printf("Operaciones de bits -> tipos sin signo (uint8_t, uint32_t...)\n");

    printf("\n¡FIN DEL PROGRAMA!\n\n");
    return 0;
}
