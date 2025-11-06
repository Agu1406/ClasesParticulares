#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_DISTRITOS 50
#define MAX_CANDIDATOS 20

/**
 * Ejercicio 7: Sistema de Elecciones
 * Utilizando la estructura de datos matriz, elaborar un programa en pseudocódigo que:
 * - Permita determinar en una elección de n distritos dados y m candidatos
 * - La cantidad de votos por candidato
 * - Determine quién ganó
 * - Qué distrito le aportó mayor cantidad de votos
 * 
 * Estructura de la matriz:
 * - Filas: distritos (n distritos)
 * - Columnas: candidatos (m candidatos)
 * - matriz[i][j] = cantidad de votos del candidato j en el distrito i
 */

// Función para ingresar los datos de la elección
void ingresarDatos(int matriz[][MAX_CANDIDATOS], int n, int m, char nombresCandidatos[][50], char nombresDistritos[][50]) {
    int i;
    int j;
    int votos;
    
    printf("\n=== Ingreso de Datos ===\n");
    
    // Bucle for que recorre cada distrito
    for (i = 0; i < n; i++) {
        printf("\n--- Distrito %d: %s ---\n", i + 1, nombresDistritos[i]);
        
        // Bucle for que recorre cada candidato
        for (j = 0; j < m; j++) {
            printf("Votos para %s: ", nombresCandidatos[j]);
            scanf("%d", &votos);
            
            // Validación: los votos no pueden ser negativos
            if (votos < 0) {
                printf("Error: Los votos no pueden ser negativos. Se establece en 0.\n");
                votos = 0;
            }
            
            matriz[i][j] = votos;
        }
    }
}

// Función para mostrar la matriz de votos
void mostrarMatrizVotos(int matriz[][MAX_CANDIDATOS], int n, int m, char nombresCandidatos[][50], char nombresDistritos[][50]) {
    int i;
    int j;
    
    printf("\n=== Matriz de Votos ===\n");
    printf("%-20s", "Distrito");
    for (j = 0; j < m; j++) {
        printf("%-15s", nombresCandidatos[j]);
    }
    printf("Total\n");
    printf("--------------------------------------------------------------------------------\n");
    
    // Bucle for que recorre cada distrito
    for (i = 0; i < n; i++) {
        int totalDistrito;
        totalDistrito = 0;
        
        printf("%-20s", nombresDistritos[i]);
        
        // Bucle for que muestra los votos de cada candidato en este distrito
        for (j = 0; j < m; j++) {
            printf("%-15d", matriz[i][j]);
            totalDistrito = totalDistrito + matriz[i][j];
        }
        printf("%d\n", totalDistrito);
    }
}

// Función para calcular la cantidad de votos por candidato
void calcularVotosPorCandidato(int matriz[][MAX_CANDIDATOS], int n, int m, int totalesCandidatos[]) {
    int i;
    int j;
    
    // Inicializamos los totales de cada candidato en 0
    for (j = 0; j < m; j++) {
        totalesCandidatos[j] = 0;
    }
    
    // Bucle for que recorre cada distrito
    for (i = 0; i < n; i++) {
        // Bucle for que recorre cada candidato
        for (j = 0; j < m; j++) {
            totalesCandidatos[j] = totalesCandidatos[j] + matriz[i][j];
        }
    }
}

// Función para determinar el ganador
int determinarGanador(int totalesCandidatos[], int m) {
    int indiceGanador;
    int maxVotos;
    int j;
    
    indiceGanador = 0;
    maxVotos = totalesCandidatos[0];
    
    // Bucle for que busca el candidato con más votos
    for (j = 1; j < m; j++) {
        if (totalesCandidatos[j] > maxVotos) {
            maxVotos = totalesCandidatos[j];
            indiceGanador = j;
        }
    }
    
    return indiceGanador;
}

// Función para determinar qué distrito aportó más votos a un candidato
int determinarDistritoMayorAporte(int matriz[][MAX_CANDIDATOS], int n, int candidato) {
    int indiceDistrito;
    int maxVotos;
    int i;
    
    indiceDistrito = 0;
    maxVotos = matriz[0][candidato];
    
    // Bucle for que busca el distrito con más votos para este candidato
    for (i = 1; i < n; i++) {
        if (matriz[i][candidato] > maxVotos) {
            maxVotos = matriz[i][candidato];
            indiceDistrito = i;
        }
    }
    
    return indiceDistrito;
}

int main() {
    // Matriz: filas = distritos, columnas = candidatos
    int matrizVotos[MAX_DISTRITOS][MAX_CANDIDATOS];
    // Arreglo para almacenar los nombres de los candidatos
    char nombresCandidatos[MAX_CANDIDATOS][50];
    // Arreglo para almacenar los nombres de los distritos
    char nombresDistritos[MAX_DISTRITOS][50];
    // Arreglo para almacenar el total de votos por candidato
    int totalesCandidatos[MAX_CANDIDATOS];
    // Variable para almacenar el número de distritos
    int n;
    // Variable para almacenar el número de candidatos
    int m;
    // Variable para almacenar el índice del ganador
    int indiceGanador;
    // Variable para almacenar el índice del distrito con mayor aporte
    int indiceDistritoMayor;
    // Variables para bucles
    int i;
    int j;
    
    printf("=== Ejercicio 7: Sistema de Elecciones ===\n");
    
    // Ingreso del número de distritos
    printf("Ingrese el numero de distritos (n): ");
    scanf("%d", &n);
    
    // Validación del número de distritos
    if (n <= 0 || n > MAX_DISTRITOS) {
        printf("Error: El numero de distritos debe estar entre 1 y %d.\n", MAX_DISTRITOS);
        return 1;
    }
    
    // Ingreso del número de candidatos
    printf("Ingrese el numero de candidatos (m): ");
    scanf("%d", &m);
    
    // Validación del número de candidatos
    if (m <= 0 || m > MAX_CANDIDATOS) {
        printf("Error: El numero de candidatos debe estar entre 1 y %d.\n", MAX_CANDIDATOS);
        return 1;
    }
    
    // Limpiar el buffer de entrada
    while (getchar() != '\n');
    
    // Ingreso de nombres de distritos
    printf("\n=== Ingreso de Nombres de Distritos ===\n");
    for (i = 0; i < n; i++) {
        printf("Nombre del distrito %d: ", i + 1);
        fgets(nombresDistritos[i], 50, stdin);
        // Eliminar el salto de línea al final
        nombresDistritos[i][strcspn(nombresDistritos[i], "\n")] = 0;
    }
    
    // Ingreso de nombres de candidatos
    printf("\n=== Ingreso de Nombres de Candidatos ===\n");
    for (j = 0; j < m; j++) {
        printf("Nombre del candidato %d: ", j + 1);
        fgets(nombresCandidatos[j], 50, stdin);
        // Eliminar el salto de línea al final
        nombresCandidatos[j][strcspn(nombresCandidatos[j], "\n")] = 0;
    }
    
    // Ingreso de datos de votos
    ingresarDatos(matrizVotos, n, m, nombresCandidatos, nombresDistritos);
    
    // Mostrar la matriz de votos
    mostrarMatrizVotos(matrizVotos, n, m, nombresCandidatos, nombresDistritos);
    
    // Calcular votos por candidato
    calcularVotosPorCandidato(matrizVotos, n, m, totalesCandidatos);
    
    // Mostrar resultados por candidato
    printf("\n=== Cantidad de Votos por Candidato ===\n");
    for (j = 0; j < m; j++) {
        printf("%s: %d votos\n", nombresCandidatos[j], totalesCandidatos[j]);
    }
    
    // Determinar el ganador
    indiceGanador = determinarGanador(totalesCandidatos, m);
    
    printf("\n=== Resultado de la Eleccion ===\n");
    printf("GANADOR: %s con %d votos\n", nombresCandidatos[indiceGanador], totalesCandidatos[indiceGanador]);
    
    // Determinar qué distrito aportó más votos al ganador
    indiceDistritoMayor = determinarDistritoMayorAporte(matrizVotos, n, indiceGanador);
    
    printf("\n=== Distrito con Mayor Aporte al Ganador ===\n");
    printf("Distrito: %s\n", nombresDistritos[indiceDistritoMayor]);
    printf("Votos aportados: %d\n", matrizVotos[indiceDistritoMayor][indiceGanador]);
    
    // Mostrar desglose por distrito del ganador
    printf("\n=== Desglose de Votos del Ganador por Distrito ===\n");
    for (i = 0; i < n; i++) {
        printf("%s: %d votos\n", nombresDistritos[i], matrizVotos[i][indiceGanador]);
    }
    
    return 0;
}

