package ev3.ut9.pf.principios.resueltos;

// Tipo List y factory List.of para crear secuencias fijas de elementos.
import java.util.List;
// Predicate<T> devuelve boolean; se usa en filter, removeIf y composicion con and/or.
import java.util.function.Predicate;

/**
 * Ejercicio 10 (Principios): Predicate compuesto - SOLUCION.
 * 
 * Proposito del ejercicio:
 * Filtrado multi-condicion con predicados reutilizables.
 * 
 * Que hace este codigo resuelto:
 * largo.and(empiezaA) selecciona ana y arte e imprime lista filtrada.
 * 
 * Conceptos que demuestra:
 *   - Predicate.and composicion.
 *   - filter en stream.
 *   - Expresividad declarativa de reglas.
 * 
 * Salida al ejecutar main:
 * [ana, arte]
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class Ejercicio10_PredicateCompuesto_RESUELTO {
    public static void main(String[] args) {
        // Cuatro palabras con distintas longitudes e iniciales; base para predicados compuestos.
        List<String> palabras = List.of("sol", "ana", "arte", "b");
        // Predicate largo: length >= 3 descarta cadenas demasiado cortas como "b".
        Predicate<String> largo = texto -> texto.length() >= 3;
        // Predicate empiezaA: startsWith("a") selecciona ana y arte entre otras.
        Predicate<String> empiezaA = texto -> texto.startsWith("a");
        // largo.and(empiezaA) exige cumplir ambos criterios a la vez.
        Predicate<String> comp = largo.and(empiezaA);
        // stream.filter(comp).collect imprime [ana, arte]: unica combinacion valida.
        System.out.println(palabras.stream().filter(comp).collect(java.util.stream.Collectors.toList()));
    }
}
