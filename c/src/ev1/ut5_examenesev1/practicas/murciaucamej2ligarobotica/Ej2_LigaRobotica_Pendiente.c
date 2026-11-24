/*
Ej2 - Liga escolar de robotica (PENDIENTE)
UCAM Primer parcial. PDF: Ej2_Completar.pdf

Sustituye cada marca TODO (1)..(8). Compila, pero la logica esta incompleta.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    int opcion, robots, inscripciones = 0;
    char cat;
    float desc, importe;
    int nS = 0, nC = 0, nL = 0;
    int uS = 0, uC = 0, uL = 0;
    float iS = 0.0f, iC = 0.0f, iL = 0.0f;

    printf("MENU\n1. Registrar inscripcion\n");
    printf("2. Mostrar estadisticas\n3. Salir\n");
    printf("Ingrese opcion: ");
    scanf("%d", &opcion);
    while (1 /* TODO (1): mientras no salir (opcion != 3) */) {
        switch (opcion) {
            case 1:
                printf("\nNUEVA INSCRIPCION\n");
                printf("Ingrese categoria (S/C/L): ");
                scanf(" %c", &cat);
                if (0 /* TODO (2): categoria no es S ni C ni L */) {
                    printf("Categoria no valida\n");
                } else {
                    printf("Ingrese robots: ");
                    scanf("%d", &robots);
                    while (0 /* TODO (3): robots fuera de 1..30 */) {
                        printf("Robots no validos (de 1 a 30)\n");
                        printf("Ingrese robots: ");
                        scanf("%d", &robots);
                    }
                    if (cat == 'S') {
                        if (0 /* TODO (4): Sumo < 5 */)
                            desc = 0.0f;
                        else if (0 /* TODO (5): Sumo < 12 */)
                            desc = 10.0f;
                        else
                            desc = 20.0f;
                    } else if (cat == 'C') {
                        if (0 /* TODO (6): Carreras < 8 */)
                            desc = 5.0f;
                        else
                            desc = 15.0f;
                    } else {
                        if (0 /* TODO (7): Laberinto < 6 */)
                            desc = 0.0f;
                        else
                            desc = 12.0f;
                    }
                    importe = robots * 15 * (1.0f - desc / 100.0f);
                    printf("Importe de la inscripcion: %.2f euros\n", importe);
                    if (cat == 'S') {
                        nS++;
                        uS += robots;
                        iS += importe;
                    }
                    if (cat == 'C') {
                        nC++;
                        uC += robots;
                        iC += importe;
                    }
                    if (cat == 'L') {
                        nL++;
                        uL += robots;
                        iL += importe;
                    }
                    inscripciones++;
                    if (0 /* TODO (8): cada 4 inscripciones */) {
                        printf("La inscripcion numero %d", inscripciones);
                        printf(" ha ganado un kit de sensores!!\n");
                    }
                }
                break;
            case 2:
                printf("\nESTADISTICAS\n");
                printf("Sumo (S):\n- %d inscripciones\n", nS);
                printf("- %d robots\n- %.2f euros\n", uS, iS);
                printf("Carreras (C):\n- %d inscripciones\n", nC);
                printf("- %d robots\n- %.2f euros\n", uC, iC);
                printf("Laberinto (L):\n- %d inscripciones\n", nL);
                printf("- %d robots\n- %.2f euros\n", uL, iL);
                printf("Total:\n- %d inscripciones\n", nS + nC + nL);
                printf("- %d robots\n- %.2f euros\n",
                       uS + uC + uL, iS + iC + iL);
                break;
            default:
                printf("Opcion no valida\n");
        }
        printf("\nMENU\n1. Registrar inscripcion\n");
        printf("2. Mostrar estadisticas\n3. Salir\n");
        printf("Ingrese opcion: ");
        scanf("%d", &opcion);
    }
    printf("\nSaliendo...\n");
    return 0;
}
