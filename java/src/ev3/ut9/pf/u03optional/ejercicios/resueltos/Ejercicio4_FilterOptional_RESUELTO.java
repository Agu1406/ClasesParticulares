package ev3.ut9.pf.u03optional.ejercicios.resueltos;

// Clase Optional para encadenar map/filter/flatMap sin NullPointerException.
import java.util.Optional;

/**
 * Ejercicio 4 (Optional): filter optional - SOLUCION.
 * 
 * Proposito del ejercicio:
 * Filtrado condicional dentro del contenedor.
 * 
 * Que hace este codigo resuelto:
 * "sol" (3 letras) no pasa filter > 3; orElse devuelve "corta" e imprime.
 * 
 * Conceptos que demuestra:
 *   - filter convierte presente en empty si falla.
 *   - Composicion filter + orElse.
 *   - Sin if explicito sobre isPresent.
 * 
 * Salida al ejecutar main:
 * corta
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class Ejercicio4_FilterOptional_RESUELTO {
    public static void main(String[] args) {
        // "sol" tiene 3 letras; no pasara filter que exige longitud > 3.
        Optional<String> palabra = Optional.of("sol");
        // filter descarta valor presente que no cumple; orElse devuelve "corta".
        String textoResultado = palabra.filter(texto -> texto.length() > 3).orElse("corta");
        // Muestra "corta" porque "sol" no supera tres caracteres y el filter descarto el valor.
        System.out.println(textoResultado);
    }
}
