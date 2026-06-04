package ev3.ut9.pf.u02streams.ejercicios.resueltos;

// asList
import java.util.Arrays;
// lista
import java.util.List;

/**
 * Ejercicio universidad (TPP Hoja2 bloque2 ej.5): filter sorted ciudades.
 * 
 * Proposito:
 * Ciudades que empiezan por A o G, ordenadas.
 * 
 * Origen:
 *   TPP Hoja2 bloque2 ej.5
 * 
 * Tu tarea:
 * filter + sorted + forEach.
 * 
 * Salida esperada al ejecutar main:
 * Aviles
Gijon
 * 
 * SOLUCION.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class Ejercicio13_UniFilterSortedCiudades_RESUELTO {
    public static void main(String[] args) {
        // ciudades
        java.util.List<String> cities = java.util.Arrays.asList("Oviedo", "Gijon", "Aviles", "Mieres");
        // cabecera
        System.out.println("Ciudades que empiezan por A o G, ordenadas:");
        // pipeline
        cities.stream().filter(c -> c.startsWith("A") || c.startsWith("G")).sorted().forEach(System.out::println);
    }
}
