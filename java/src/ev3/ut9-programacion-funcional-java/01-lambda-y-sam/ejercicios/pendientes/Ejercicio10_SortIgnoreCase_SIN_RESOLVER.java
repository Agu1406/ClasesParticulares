package ev3.ut9.pf.lambda.pendientes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Ejercicio 10 (Lambda y SAM): orden sin distinguir mayusculas.
 * 
 * Proposito:
 * Aplicar compareToIgnoreCase para ordenacion alfabetica case-insensitive, comun en listas de nombres propios o etiquetas.
 * 
 * Objetivos de aprendizaje:
 *   - Usar compareToIgnoreCase en lambda Comparator.
 *   - Ordenar ciudades con distinta capitalizacion.
 *   - Verificar orden alfabetico real (Almeria antes que barcelona).
 * 
 * Tu tarea:
 * Ordena ciudades ignorando mayusculas con Collections.sort y compareToIgnoreCase. Imprime la lista.
 * 
 * Salida esperada al ejecutar main:
 * [Almeria, barcelona, cadiz]
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class Ejercicio10_SortIgnoreCase_SIN_RESOLVER {
    public static void main(String[] args) {
        List<String> ciudades = new ArrayList<>(List.of("barcelona", "Almeria", "cadiz"));
        // TODO: sort con compareToIgnoreCase
        // TODO: imprimir ciudades
    }
}
