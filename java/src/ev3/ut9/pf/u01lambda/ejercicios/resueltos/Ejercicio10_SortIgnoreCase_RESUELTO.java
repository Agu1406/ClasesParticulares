package ev3.ut9.pf.u01lambda.ejercicios.resueltos;

// ArrayList importada porque removeIf y sort modifican la lista original, no una copia.
import java.util.ArrayList;
// Collections.sort ordena in-place; la lambda define el criterio de comparacion entre elementos.
import java.util.Collections;
// List.of fabrica listas inmutables de solo lectura, seguras como fuente de datos de prueba.
import java.util.List;

/**
 * Ejercicio 10 (Lambda y SAM): sort ignore case - SOLUCION.
 * 
 * Proposito del ejercicio:
 * Orden lexicografico insensible a mayusculas con lambda.
 * 
 * Que hace este codigo resuelto:
 * Ordena tres ciudades con compareToIgnoreCase e imprime secuencia case-insensitive.
 * 
 * Conceptos que demuestra:
 *   - compareToIgnoreCase en Comparator.
 *   - Ordenacion estable respecto a reglas Unicode ignorando case.
 *   - Lista mutable ordenada in-place.
 * 
 * Salida al ejecutar main:
 * [Almeria, barcelona, cadiz]
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class Ejercicio10_SortIgnoreCase_RESUELTO {
    public static void main(String[] args) {
        // Nombres con mayusculas distintas; el sort debe ignorar capitalizacion al comparar.
        List<String> ciudades = new ArrayList<>(List.of("barcelona", "Almeria", "cadiz"));
        // compareToIgnoreCase compara letras sin distinguir mayusculas/minusculas.
        Collections.sort(ciudades, (ciudadA, ciudadB) -> ciudadA.compareToIgnoreCase(ciudadB));
        // Imprime ciudades ya ordenadas alfabeticamente de forma case-insensitive.
        System.out.println(ciudades);
    }
}
