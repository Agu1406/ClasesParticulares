package ev3.ut9_programacionfuncional.pf.u05repaso.ejercicios.resueltos;

// Tipo List y factory List.of para crear secuencias fijas de elementos.
import java.util.List;
// Collectors materializa el stream en coleccion, String u otro tipo segun el terminal elegido.
import java.util.stream.Collectors;

/**
 * Repaso 9: combinado 1 - SOLUCION.
 * 
 * Proposito del ejercicio:
 * Pipeline String filter/map/collect.
 * 
 * Que hace este codigo resuelto:
 * Imprime [AB, CDE].
 * 
 * Conceptos que demuestra:
 *   - Repaso filter map collect.
 *   - Criterio longitud minima.
 *   - Transformacion toUpperCase.
 * 
 * Salida al ejecutar main:
 * [AB, CDE]
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class Ejercicio9_RepasoFinalCombinado1_RESUELTO {
    public static void main(String[] args) {
        // Tres cadenas de distinta longitud; "f" quedara fuera por filter length>=2.
        List<String> items = List.of("ab", "cde", "f");
        // filter + map toUpperCase + collect: [AB, CDE] excluyendo la f de un caracter.
        List<String> listaResultado = items.stream().filter(texto -> texto.length() >= 2).map(String::toUpperCase).collect(Collectors.toList());
        // Muestra resultado transformado en consola (lista o valor segun el ejercicio).
        System.out.println(listaResultado);
    }
}
