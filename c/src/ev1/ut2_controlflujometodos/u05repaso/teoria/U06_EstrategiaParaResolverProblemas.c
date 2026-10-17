/*
U06 - Estrategia para resolver un problema de programacion.

OBJETIVO:
  - Seguir un metodo: entender, ejemplos, pasos, codigo, probar.
  - Descomponer un problema en funciones pequenas.
  - Probar con casos tipicos, limite y de error.
  - Aplicar el metodo a un caso completo: "Es un ano bisiesto?".

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>
#include <stdbool.h>

static bool es_bisiesto(int anio);
static int dias_del_mes(int mes, int anio);
static void probar(int anio, bool esperado);

int main(void) {
    printf("\n¡INICIO DEL PROGRAMA!\n\n");

    /*
    PRIMERA PARTE - El metodo en 5 pasos.
      1) ENTENDER: que entra, que sale, que reglas hay.
      2) EJEMPLOS: escribe 3 o 4 casos a mano (tipico, limite, raro).
      3) PASOS: describe la solucion en lenguaje normal (pseudocodigo).
      4) CODIGO: traduce, empezando por lo mas pequeno que funcione.
      5) PROBAR: ejecuta tus ejemplos y compara con lo esperado.
    */
    printf("--- PRIMERA PARTE: El metodo ---\n\n");
    printf("Entender -> Ejemplos -> Pasos -> Codigo -> Probar\n");

    /*
    SEGUNDA PARTE - Aplicado: ano bisiesto.
      1) ENTENDER: un ano es bisiesto si es divisible entre 4, excepto los
         divisibles entre 100, salvo que lo sean tambien entre 400.
      2) EJEMPLOS: 2024 si, 2023 no, 1900 no (divisible entre 100),
         2000 si (divisible entre 400).
      3) PASOS: si anio%400==0 -> si; si anio%100==0 -> no;
         si anio%4==0 -> si; en otro caso no.
    */
    printf("\n--- SEGUNDA PARTE: Ano bisiesto ---\n\n");

    probar(2024, true);
    probar(2023, false);
    probar(1900, false);
    probar(2000, true);

    /*
    TERCERA PARTE - Reutilizar: dias de un mes.
      La funcion dias_del_mes se apoya en es_bisiesto: una funcion buena
      sirve de ladrillo para otra.
    */
    printf("\n--- TERCERA PARTE: Dias del mes ---\n\n");

    printf("Febrero 2024: %d dias\n", dias_del_mes(2, 2024));
    printf("Febrero 2023: %d dias\n", dias_del_mes(2, 2023));
    printf("Abril 2023:   %d dias\n", dias_del_mes(4, 2023));
    printf("Mes 13:       %d (error)\n", dias_del_mes(13, 2023));

    /*
    CUARTA PARTE - Probar casos limite.
      Siempre piensa en: el menor valor, el mayor, el cero, un negativo
      y un valor que rompa la regla. La mayoria de errores estan alli.
    */
    printf("\n--- CUARTA PARTE: Casos limite ---\n\n");
    printf("Limites de dias_del_mes: mes 1 = %d, mes 12 = %d\n",
           dias_del_mes(1, 2023), dias_del_mes(12, 2023));

    printf("\n¡FIN DEL PROGRAMA!\n\n");
    return 0;
}

static bool es_bisiesto(int anio) {
    if (anio % 400 == 0) {
        return true;
    }
    if (anio % 100 == 0) {
        return false;
    }
    return anio % 4 == 0;
}

static int dias_del_mes(int mes, int anio) {
    switch (mes) {
        case 1: case 3: case 5: case 7: case 8: case 10: case 12:
            return 31;
        case 4: case 6: case 9: case 11:
            return 30;
        case 2:
            return es_bisiesto(anio) ? 29 : 28;
        default:
            return -1;
    }
}

static void probar(int anio, bool esperado) {
    bool real = es_bisiesto(anio);
    printf("%d -> %s (%s)\n", anio, real ? "bisiesto" : "no bisiesto",
           real == esperado ? "OK" : "FALLO");
}
