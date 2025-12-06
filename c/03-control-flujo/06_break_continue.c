/**
 * @file 06_break_continue.c
 * @brief EJERCICIO 6: break y continue
 * 
 * TEORÍA:
 * break y continue son palabras clave que permiten controlar el flujo
 * de los bucles de manera más precisa.
 * 
 * break:
 * - Sale inmediatamente del bucle más interno
 * - También se usa en switch para salir de un case
 * - Útil para terminar un bucle antes de tiempo
 * 
 * continue:
 * - Salta el resto de la iteración actual
 * - Vuelve a evaluar la condición del bucle
 * - Útil para omitir ciertas iteraciones
 * 
 * IMPORTANTE:
 * - break termina el bucle completamente
 * - continue solo salta a la siguiente iteración
 * 
 * @author Agustín. A. Marquez. Piña
 * @date 2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://agu1406.github.io/ClasesParticulares">GitHub Pages</a>
 */

#include <stdio.h>

int main(void) {
    // EJEMPLO 1: break para salir temprano
    printf("=== EJEMPLO 1: break para salir temprano ===\n");
    printf("Buscando el número 5:\n");
    
    for (int i = 1; i <= 10; i++) {
        if (i == 5) {
            printf("¡Encontrado! %d\n", i);
            break;  // Sale del bucle cuando encuentra 5
        }
        printf("Buscando... %d\n", i);
    }
    printf("Bucle terminado\n");
    
    // EJEMPLO 2: continue para saltar iteraciones
    printf("\n=== EJEMPLO 2: continue para saltar ===\n");
    printf("Números del 1 al 10, saltando los pares:\n");
    
    for (int i = 1; i <= 10; i++) {
        if (i % 2 == 0) {
            continue;  // Salta los números pares
        }
        printf("%d ", i);
    }
    printf("\n");
    
    // EJEMPLO 3: break en bucle anidado
    printf("\n=== EJEMPLO 3: break en bucle anidado ===\n");
    printf("Buscando en matriz (sale del bucle interno):\n");
    
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 5; j++) {
            if (j == 3) {
                printf("Encontrado en j=%d, saliendo del bucle interno\n", j);
                break;  // Solo sale del bucle interno (j)
            }
            printf("i=%d, j=%d\n", i, j);
        }
    }
    
    // EJEMPLO 4: continue con números divisibles
    printf("\n=== EJEMPLO 4: continue con divisibilidad ===\n");
    printf("Números del 1 al 20 que NO son divisibles por 3:\n");
    
    for (int i = 1; i <= 20; i++) {
        if (i % 3 == 0) {
            continue;  // Salta los múltiplos de 3
        }
        printf("%d ", i);
    }
    printf("\n");
    
    // EJEMPLO 5: break en while
    printf("\n=== EJEMPLO 5: break en while ===\n");
    int numero = 1;
    
    while (numero < 100) {
        if (numero > 10) {
            printf("Número mayor a 10, saliendo...\n");
            break;
        }
        printf("%d ", numero);
        numero++;
    }
    printf("\n");
    
    // EJEMPLO 6: Validación con break
    printf("\n=== EJEMPLO 6: Validación con break ===\n");
    int valores[] = {5, -3, 10, 0, 15};
    int suma = 0;
    
    for (int i = 0; i < 5; i++) {
        if (valores[i] < 0) {
            printf("Encontrado número negativo: %d. Deteniendo suma.\n", valores[i]);
            break;  // Si encontramos un negativo, paramos
        }
        suma += valores[i];
        printf("Sumando %d. Suma: %d\n", valores[i], suma);
    }
    printf("Suma final: %d\n", suma);
    
    // EJEMPLO 7: continue para procesar solo ciertos valores
    printf("\n=== EJEMPLO 7: Procesar solo positivos ===\n");
    int numeros[] = {-5, 10, -3, 20, -1, 15};
    
    printf("Procesando solo números positivos:\n");
    for (int i = 0; i < 6; i++) {
        if (numeros[i] < 0) {
            continue;  // Saltamos los negativos
        }
        printf("Procesando: %d (doble = %d)\n", numeros[i], numeros[i] * 2);
    }
    
    // EJEMPLO 8: Búsqueda con break
    printf("\n=== EJEMPLO 8: Búsqueda eficiente ===\n");
    int lista[] = {3, 7, 2, 9, 5, 1, 8};
    int buscar = 9;
    int encontrado = 0;
    
    for (int i = 0; i < 7; i++) {
        if (lista[i] == buscar) {
            printf("¡Encontrado %d en posición %d!\n", buscar, i);
            encontrado = 1;
            break;  // No necesitamos seguir buscando
        }
    }
    
    if (!encontrado) {
        printf("No se encontró %d\n", buscar);
    }
    
    // EJEMPLO 9: continue para evitar división por cero
    printf("\n=== EJEMPLO 9: Evitar división por cero ===\n");
    int divisores[] = {5, 0, 10, 0, 3};
    int dividendo = 100;
    
    for (int i = 0; i < 5; i++) {
        if (divisores[i] == 0) {
            printf("Divisor %d es cero, saltando...\n", i);
            continue;  // Evitamos dividir por cero
        }
        printf("%d / %d = %d\n", dividendo, divisores[i], dividendo / divisores[i]);
    }
    
    // EJEMPLO 10: break y continue juntos
    printf("\n=== EJEMPLO 10: break y continue juntos ===\n");
    printf("Procesando números hasta encontrar un número mayor a 50:\n");
    
    int datos[] = {5, 15, 25, 35, 55, 45, 30};
    
    for (int i = 0; i < 7; i++) {
        if (datos[i] > 50) {
            printf("Número %d es mayor a 50. Deteniendo.\n", datos[i]);
            break;
        }
        
        if (datos[i] % 2 == 0) {
            continue;  // Saltamos los pares menores a 50
        }
        
        printf("Procesando impar: %d\n", datos[i]);
    }
    
    return 0;
}

/*
 * EJERCICIOS PRÁCTICOS:
 * 
 * 1. Busca un número en un array y usa break cuando lo encuentres
 * 2. Suma solo los números positivos de un array (usa continue para negativos)
 * 3. Encuentra el primer número divisible por 7 en un rango (usa break)
 * 4. Imprime números del 1 al 100, pero salta los múltiplos de 5 (continue)
 * 5. Valida una lista de números y detente si encuentras un inválido (break)
 * 
 * RECUERDA:
 * - break: "sal de aquí ahora"
 * - continue: "salta esta iteración y continúa con la siguiente"
 */

