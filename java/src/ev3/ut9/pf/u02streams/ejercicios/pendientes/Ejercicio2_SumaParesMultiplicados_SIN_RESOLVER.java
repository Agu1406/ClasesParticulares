package ev3.ut9.pf.u02streams.ejercicios.pendientes;

import java.util.List;

/**
 * Ejercicio 2 (Streams API): suma de pares multiplicados por 10.
 * 
 * Proposito:
 * Combinar filter, map y reduce en un unico pipeline numerico con acumulacion.
 * 
 * Objetivos de aprendizaje:
 *   - Filtrar numeros pares.
 *   - Multiplicar cada par por 10 con map.
 *   - Reducir a suma total con reduce e identidad 0.
 * 
 * Tu tarea:
 * Calcula la suma de todos los pares de listaNumeros, cada uno multiplicado por 10, usando stream. Imprime el resultado (2*10 + 4*10 + 6*10 + 8*10).
 * 
 * Salida esperada al ejecutar main:
 * 200
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class Ejercicio2_SumaParesMultiplicados_SIN_RESOLVER {
    public static void main(String[] args) {
        List<Integer> listaNumeros = List.of(1, 2, 3, 4, 5, 6, 7, 8);
        // TODO: stream filter par, map *10, reduce suma
    }
}
