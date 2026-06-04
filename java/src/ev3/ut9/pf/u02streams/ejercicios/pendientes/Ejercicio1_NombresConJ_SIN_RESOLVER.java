package ev3.ut9.pf.u02streams.ejercicios.pendientes;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Ejercicio 1 (Streams API): nombres con J, ordenados y en mayusculas.
 * 
 * Proposito:
 * Construir un pipeline stream completo que filtre, ordene, transforme y recolecte, equivalente funcional al ejercicio clasico de nombres que empiezan por J.
 * 
 * Objetivos de aprendizaje:
 *   - filter con predicado startsWith("J").
 *   - sorted para orden alfabetico.
 *   - map a mayusculas y collect toList.
 * 
 * Tu tarea:
 * A partir de nombres, obtiene con stream solo los que empiezan por J, ordenados alfabeticamente y en MAYUSCULAS. Imprime la lista resultante.
 * 
 * Salida esperada al ejecutar main:
 * [JACK, JANE, JOHN]
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class Ejercicio1_NombresConJ_SIN_RESOLVER {
    public static void main(String[] args) {
        List<String> nombres = List.of("Alice", "Bob", "John", "Jane", "Jack");
        // TODO: stream -> filter startsWith "J" -> sorted -> map toUpperCase -> collect
    }
}
