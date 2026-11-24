/*
Simulacro E02 - Rover en Marte (PENDIENTE)
UCAM. PDF: SimulacroFinal_Soluciones.pdf (pregunta 2)

ENUNCIADO (resumen):
  9 soles, bateria 20000 Wh. Leer recogida/consumida con validacion.
  Balance, valoracion BUENO/NORMAL/MALO, envio -2500 cada 3 soles (no el 9),
  fallo si bateria < 0. Informe final.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    int sol, recogida, consumida;
    int bateria = 20000;
    int envios = 0;
    int fallida = 0;
    int buenos = 0, normales = 0, malos = 0;

    printf("--- INICIO DE LA MISION (9 soles) ---\n");
    printf("Bateria inicial: %d Wh\n", bateria);

    for (sol = 1; sol <= 9; sol++) {
        /* TODO: leer y validar recogida (0..6000) y consumida (0..9000) */
        /* TODO: balance bateria */
        /* TODO: valoracion y contadores */
        /* TODO: envio cada 3 soles si sol != 9 */
        /* TODO: si bateria < 0 -> fallida y break */
        (void)recogida;
        (void)consumida;
        (void)envios;
        (void)fallida;
        (void)buenos;
        (void)normales;
        (void)malos;
        (void)bateria;
    }

    printf("--- FIN DE LA MISION ---\n");
    /* TODO: mensaje completada/fallida, envios, bateria kWh/%03d Wh, conteos */
    (void)sol;
    return 0;
}
