/*
Ej2 - Liga escolar de robotica (RESUELTO)
UCAM Primer parcial. PDF: Ej2_Completar.pdf / Completar_Soluciones.pdf

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
    while (opcion != 3) {
        switch (opcion) {
            case 1:
                printf("\nNUEVA INSCRIPCION\n");
                printf("Ingrese categoria (S/C/L): ");
                scanf(" %c", &cat);
                if (cat != 'S' && cat != 'C' && cat != 'L') {
                    printf("Categoria no valida\n");
                } else {
                    printf("Ingrese robots: ");
                    scanf("%d", &robots);
                    while (robots < 1 || robots > 30) {
                        printf("Robots no validos (de 1 a 30)\n");
                        printf("Ingrese robots: ");
                        scanf("%d", &robots);
                    }
                    if (cat == 'S') {
                        if (robots < 5)
                            desc = 0.0f;
                        else if (robots < 12)
                            desc = 10.0f;
                        else
                            desc = 20.0f;
                    } else if (cat == 'C') {
                        if (robots < 8)
                            desc = 5.0f;
                        else
                            desc = 15.0f;
                    } else {
                        if (robots < 6)
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
                    if (inscripciones % 4 == 0) {
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
