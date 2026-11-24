/*
Simulacro E02 - Rover en Marte (RESUELTO)
UCAM. PDF: SimulacroFinal_Soluciones.pdf (pregunta 2)

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
        printf("Sol %d - energia recogida y consumida (Wh): ", sol);
        scanf("%d %d", &recogida, &consumida);
        while (recogida < 0 || recogida > 6000 || consumida < 0 || consumida > 9000) {
            printf("Datos no validos: recogida de 0 a 6000, consumida de 0 a 9000\n");
            printf("Sol %d - energia recogida y consumida (Wh): ", sol);
            scanf("%d %d", &recogida, &consumida);
        }

        bateria = bateria + recogida - consumida;

        if (recogida >= 4000) {
            if (consumida < 5000) {
                printf("Valoracion del sol: BUENO\n");
                buenos++;
            } else {
                printf("Valoracion del sol: NORMAL\n");
                normales++;
            }
        } else if (recogida >= 1500) {
            if (consumida < 3000) {
                printf("Valoracion del sol: NORMAL\n");
                normales++;
            } else {
                printf("Valoracion del sol: MALO\n");
                malos++;
            }
        } else {
            printf("Valoracion del sol: MALO\n");
            malos++;
        }

        if (sol % 3 == 0 && sol != 9) {
            bateria = bateria - 2500;
            envios++;
            printf(">>> Sol %d: ENVIO DE DATOS A LA TIERRA (-2500 Wh) <<<\n", sol);
        }

        if (bateria < 0) {
            fallida = 1;
            break;
        }
    }

    printf("--- FIN DE LA MISION ---\n");
    if (fallida == 1) {
        printf("MISION FALLIDA (BATERIA AGOTADA) en el sol %d\n", sol);
    } else {
        printf("MISION COMPLETADA\n");
        printf("Envios a la Tierra: %d\n", envios);
        printf("Bateria final: %d kWh y %03d Wh\n",
               bateria / 1000, bateria % 1000);
    }
    printf("Soles buenos: %d, normales: %d, malos: %d\n",
           buenos, normales, malos);
    return 0;
}
