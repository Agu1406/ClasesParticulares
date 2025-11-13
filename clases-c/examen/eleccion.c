// Estas son las librerias que necesito para usar printf, scanf y malloc
#include <stdio.h>
#include <stdlib.h>

int main() {
    /* 
    Declaro las variables que voy a usar
    n es para guardar cuantos distritos hay
    m es para guardar cuantos candidatos hay
    */
    int n, m;
    // i y j las uso para los ciclos for, es como contar
    int i, j;
    
    // Primero le pido al usuario que me diga cuantos distritos hay
    printf("SISTEMA DE ELECCIONES\n");
    printf("Ingrese la cantidad de distritos (n): ");
    // scanf lee lo que el usuario escriba y lo guarda en n
    scanf("%d", &n);
    
    /* 
    Tengo que verificar que el numero sea mayor a 0, porque no puede haber 0 distritos
    El while se repite mientras n sea menor o igual a 0 
    */
    while (n <= 0) {
        printf("Error: La cantidad de distritos debe ser mayor a 0.\n");
        printf("Ingrese la cantidad de distritos (n): ");
        scanf("%d", &n);
    }
    
    // Ahora le pido cuantos candidatos hay
    printf("Ingrese la cantidad de candidatos (m): ");
    scanf("%d", &m);
    
    // Tambien verifico que los candidatos sean mayor a 0
    while (m <= 0) {
        printf("Error: La cantidad de candidatos debe ser mayor a 0.\n");
        printf("Ingrese la cantidad de candidatos (m): ");
        scanf("%d", &m);
    }
    
    /* 
    Ahora tengo que crear la matriz para guardar los votos
    Una matriz es como una tabla: las filas son los distritos y las columnas son los candidatos
    Uso malloc para reservar memoria porque no se cuantos distritos o candidatos habra
    votos es un puntero doble porque es una matriz de dos dimensiones 
    */
    int** votos = (int**)malloc(n * sizeof(int*));
    // Este for crea cada fila de la matriz
    for (i = 0; i < n; i++) {
        votos[i] = (int*)malloc(m * sizeof(int));
    }
    
    /* 
    Inicializo toda la matriz con ceros, asi empiezo desde cero
    Recorro todas las filas (distritos) 
    */
    for (i = 0; i < n; i++) {
        /* 
        Y dentro de cada fila recorro todas las columnas (candidatos) 
        */
        for (j = 0; j < m; j++) {
            votos[i][j] = 0;
        }
    }
    
    /* 
    Ahora voy a pedirle al usuario que ingrese los votos
    Para cada distrito voy a preguntar cuantos votos tiene cada candidato 
    */
    printf("\nINGRESO DE VOTOS\n");
    // Recorro cada distrito (cada fila de la matriz)
    for (i = 0; i < n; i++) {
        printf("\nDistrito %d:\n", i + 1);
        // Para cada distrito, pregunto por cada candidato
        for (j = 0; j < m; j++) {
            printf("  Votos para el candidato %d: ", j + 1);
            // Guardo los votos en la posicion [i][j] de la matriz
            scanf("%d", &votos[i][j]);
            
            /* 
            No puede haber votos negativos, eso no tiene sentido
            Si el usuario pone un numero negativo, le pido que lo vuelva a escribir 
            */
            while (votos[i][j] < 0) {
                printf("  Error: Los votos no pueden ser negativos.\n");
                printf("  Votos para el candidato %d: ", j + 1);
                scanf("%d", &votos[i][j]);
            }
        }
    }
    
    // Ahora imprimo toda la matriz
    printf("\nMATRIZ DE VOTOS\n");
    for (i = 0; i < n; i++) {
        printf("Distrito %d: ", i + 1);
        for (j = 0; j < m; j++) {
            printf("Candidato %d = %d votos  ", j + 1, votos[i][j]);
        }
        printf("\n");
    }
    
    /* 
    Ahora tengo que sumar todos los votos de cada candidato
    Para esto recorro por columnas (cada columna es un candidato)
    Creo un arreglo para guardar el total de votos de cada candidato
    */
    int* totalVotosCandidato = (int*)malloc(m * sizeof(int));
    // Recorro cada candidato (cada columna)
    for (j = 0; j < m; j++) {
        // Empiezo en cero para cada candidato
        totalVotosCandidato[j] = 0;
        // Sumo todos los votos de ese candidato en todos los distritos
        for (i = 0; i < n; i++) {
            // += es como decir: totalVotosCandidato[j] = totalVotosCandidato[j] + votos[i][j]
            totalVotosCandidato[j] += votos[i][j];
        }
    }
    
    // Muestro cuantos votos tiene cada candidato en total
    printf("\nTOTAL DE VOTOS POR CANDIDATO\n");
    for (j = 0; j < m; j++) {
        printf("Candidato %d: %d votos\n", j + 1, totalVotosCandidato[j]);
    }
    
    /* 
    Ahora busco quien tiene mas votos, ese es el ganador
    Empiezo asumiendo que el candidato 0 es el que tiene mas votos 
    */
    int candidatoGanador = 0;
    int maxVotos = totalVotosCandidato[0];
    
    /* 
    Recorro todos los candidatos para ver si alguno tiene mas votos
    Empiezo desde 1 porque ya tengo el 0 guardado 
    */
    for (j = 1; j < m; j++) {
        // Si este candidato tiene mas votos que el que tenia guardado
        if (totalVotosCandidato[j] > maxVotos) {
            // Actualizo el maximo y guardo cual es el ganador
            maxVotos = totalVotosCandidato[j];
            candidatoGanador = j;
        }
    }
    
    /* 
    Tengo que verificar si hay empate, porque puede haber varios con el mismo numero de votos
    hayEmpate es 0 si no hay empate, 1 si hay empate 
    */
    int hayEmpate = 0;
    int cantidadGanadores = 0;
    // Cuento cuantos candidatos tienen el mismo numero de votos que el maximo
    for (j = 0; j < m; j++) {
        if (totalVotosCandidato[j] == maxVotos) {
            cantidadGanadores++;
        }
    }
    
    // Si hay mas de uno con el maximo, entonces hay empate
    if (cantidadGanadores > 1) {
        hayEmpate = 1;
    }
    
    // Ahora muestro el resultado de la eleccion
    printf("\nRESULTADO DE LA ELECCION\n");
    // Si hay empate, muestro todos los que empataron
    if (hayEmpate) {
        printf("EMPATE entre los siguientes candidatos con %d votos:\n", maxVotos);
        // Busco todos los candidatos que tienen el maximo de votos
        for (j = 0; j < m; j++) {
            if (totalVotosCandidato[j] == maxVotos) {
                printf("  - Candidato %d\n", j + 1);
            }
        }
    } else {
        // Si no hay empate, muestro el ganador
        printf("GANADOR: Candidato %d con %d votos\n", candidatoGanador + 1, maxVotos);
        
        /* 
        Ahora tengo que encontrar que distrito le dio mas votos al ganador
        Empiezo asumiendo que el distrito 0 es el que mas votos le dio
        */
        int distritoMaxVotos = 0;
        int maxVotosDistrito = votos[0][candidatoGanador];
        
        /* 
        Recorro todos los distritos para ver cual le dio mas votos al ganador
        */
        for (i = 1; i < n; i++) {
            // Si este distrito le dio mas votos al ganador
            if (votos[i][candidatoGanador] > maxVotosDistrito) {
                // Actualizo el maximo y guardo cual distrito es
                maxVotosDistrito = votos[i][candidatoGanador];
                distritoMaxVotos = i;
            }
        }
        
        // Muestro cual distrito le dio mas votos al ganador
        printf("\nEl distrito que aporto mayor cantidad de votos al ganador:\n");
        printf("  Distrito %d con %d votos\n", distritoMaxVotos + 1, maxVotosDistrito);
        
        // Tambien muestro cuantos votos le dio cada distrito al ganador
        printf("\nDesglose de votos del ganador por distrito:\n");
        for (i = 0; i < n; i++) {
            printf("  Distrito %d: %d votos\n", i + 1, votos[i][candidatoGanador]);
        }
    }
    
    /* 
    Es importante liberar la memoria que pedi con malloc
    Si no lo hago, la memoria se queda ocupada (esto se llama memory leak)
    Primero libero cada fila de la matriz
    */
    for (i = 0; i < n; i++) {
        free(votos[i]);
    }
    /*
    Luego libero el arreglo de punteros
    Y finalmente libero el arreglo de totales
    */
    free(votos);
    free(totalVotosCandidato);
    
    // Retorno 0 porque el programa termino bien
    return 0;
}

