package ev3.ut9.pf.u01lambda.ejercicios.pendientes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Ejercicio 2 (Lambda y SAM): orden alfabetico de nombres.
 * 
 * Proposito:
 * Reforzar lambdas en Comparator usando el orden natural lexicografico de String.
 * 
 * Objetivos de aprendizaje:
 *   - Aplicar compareTo dentro de una lambda.
 *   - Ordenar nombres propios respetando mayusculas y minusculas.
 *   - Verificar el resultado imprimiendo la lista completa.
 * 
 * Tu tarea:
 * Ordena la lista nombres alfabeticamente con Collections.sort y una lambda que use compareTo. Imprime la lista resultante.
 * 
 * Salida esperada al ejecutar main:
 * [Ana, Luis, Marta, Zoe]
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class Ejercicio2_OrdenAlfabetico_SIN_RESOLVER {
    public static void main(String[] args) {
        List<String> nombres = new ArrayList<>(List.of("Zoe", "Ana", "Luis", "Marta"));
        // TODO: ordenar alfabeticamente con lambda (primeraPalabra.compareTo(segundaPalabra))
        // TODO: imprimir nombres
    }
}
