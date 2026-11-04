/*
U04 — Operadores bit a bit.

OBJETIVO:
  - Leer un entero en binario (8 bits).
  - Usar &, |, ^, ~, << y >> sobre enteros sin signo.
  - Aplicar mascaras: encender, apagar y comprobar un bit.
  - Guardar varias opciones (flags) en un solo int.

  Que hace cada uno:
    & AND  — 1 solo si los dos bits son 1 (apaga / comprueba)
    | OR   — 1 si alguno es 1 (enciende)
    ^ XOR  — 1 si son distintos (invierte el elegido)
    ~ NOT  — invierte todos los bits
    x << n — desplaza a la izquierda (~ x * 2^n)
    x >> n — desplaza a la derecha (~ x / 2^n en unsigned)

  En C NO existe >>> de Java. Usa unsigned + >> para rellenar con ceros.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

/* Muestra 8 bits (el mas significativo primero). */
static void mostrar_bits(unsigned char valor) {
    for (int bit = 7; bit >= 0; bit--) {
        printf("%d", (valor >> bit) & 1);
    }
}

int main(void) {
    printf("\n¡INICIO DEL PROGRAMA!\n\n");

    /*
    PRIMERA PARTE - Numeros en binario.
      Cada bit vale una potencia de 2: 128 64 32 16 8 4 2 1
      Ejemplo: 00101101 = 32+8+4+1 = 45
      unsigned char (8 bits) para leerlo en pantalla.
    */
    printf("--- PRIMERA PARTE: Binario ---\n\n");

    unsigned char numero = 45;
    printf("%3d en binario = ", numero);
    mostrar_bits(numero);
    printf("\n");

    unsigned char otro = 12;
    printf("%3d en binario = ", otro);
    mostrar_bits(otro);
    printf("\n");

    /*
    SEGUNDA PARTE - &, |, ^, ~
      Se muestra solo el byte bajo para poder leerlo.
      ~ sobre un int invierte 32 bits; al castear a unsigned char quedan 8.
    */
    printf("\n--- SEGUNDA PARTE: &, |, ^, ~ ---\n\n");

    unsigned char a = 45, b = 12;
    printf("a      = "); mostrar_bits(a); printf(" (%d)\n", a);
    printf("b      = "); mostrar_bits(b); printf(" (%d)\n", b);
    printf("a & b  = "); mostrar_bits((unsigned char)(a & b)); printf(" (%d)\n", a & b);
    printf("a | b  = "); mostrar_bits((unsigned char)(a | b)); printf(" (%d)\n", a | b);
    printf("a ^ b  = "); mostrar_bits((unsigned char)(a ^ b)); printf(" (%d)\n", a ^ b);
    printf("~a     = "); mostrar_bits((unsigned char)(~a)); printf(" (%d)\n", (unsigned char)(~a));

    /*
    TERCERA PARTE - << y >>
      x << n  ≈ x * 2^n     x >> n  ≈ x / 2^n (enteros sin signo)
      No hay >>>: con signed, >> puede rellenar con el bit de signo.
    */
    printf("\n--- TERCERA PARTE: << y >> ---\n\n");

    int x = 5;
    printf("%d << 1 = %d\n", x, x << 1);
    printf("%d << 3 = %d (5 * 8)\n", x, x << 3);
    printf("%d >> 1 = %d\n", 40, 40 >> 1);
    printf("%d >> 3 = %d (40 / 8)\n", 40, 40 >> 3);
    printf("C: no existe >>>. Prefiere unsigned para desplazamientos.\n");

    /*
    CUARTA PARTE - Mascaras sobre un bit.
      encender n:  v |= (1u << n)
      apagar n:    v &= ~(1u << n)
      comprobar:   (v >> n) & 1
    */
    printf("\n--- CUARTA PARTE: Mascaras ---\n\n");

    unsigned char v = 0;
    printf("inicial    : "); mostrar_bits(v); printf("\n");
    v |= (1 << 3);
    printf("encender 3 : "); mostrar_bits(v); printf("\n");
    v |= (1 << 0);
    printf("encender 0 : "); mostrar_bits(v); printf("\n");
    v = (unsigned char)(v & ~(1 << 0));
    printf("apagar 0   : "); mostrar_bits(v); printf("\n");
    printf("bit 3 activo? %d\n", (v >> 3) & 1);

    /*
    QUINTA PARTE - Flags (varias opciones en un entero).
    */
    printf("\n--- QUINTA PARTE: Flags ---\n\n");

    enum { LEER = 1 << 0, ESCRIBIR = 1 << 1, EJECUTAR = 1 << 2 };

    int permisos = LEER | ESCRIBIR;
    printf("puede leer?     %s\n", (permisos & LEER) ? "si" : "no");
    printf("puede escribir? %s\n", (permisos & ESCRIBIR) ? "si" : "no");
    printf("puede ejecutar? %s\n", (permisos & EJECUTAR) ? "si" : "no");

    permisos |= EJECUTAR;
    permisos &= ~ESCRIBIR;
    printf("tras cambios: leer=%d escribir=%d ejecutar=%d\n",
           (permisos & LEER) != 0, (permisos & ESCRIBIR) != 0,
           (permisos & EJECUTAR) != 0);

    printf("\n--- SEXTA PARTE: Consejo ---\n\n");
    printf("Para bits usa tipos sin signo (unsigned char, unsigned int).\n");

    printf("\n¡FIN DEL PROGRAMA!\n\n");
    return 0;
}
