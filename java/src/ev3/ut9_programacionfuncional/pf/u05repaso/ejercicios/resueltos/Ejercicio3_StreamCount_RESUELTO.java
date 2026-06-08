package ev3.ut9_programacionfuncional.pf.u05repaso.ejercicios.resueltos;

// List.of fabrica listas inmutables de solo lectura, seguras como fuente de datos de prueba.
import java.util.List;

/**
 * Repaso 3: stream count - SOLUCION.
 * 
 * Proposito del ejercicio:
 * Agregacion count sobre filtro de longitud.
 * 
 * Que hace este codigo resuelto:
 * Solo "programacion" cumple >=5; imprime 1.
 * 
 * Conceptos que demuestra:
 *   - count sobre Stream<String>.
 *   - filter por length.
 *   - Repaso terminal no intermedio.
 * 
 * Salida al ejecutar main:
 * 1
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class Ejercicio3_StreamCount_RESUELTO {
    public static void main(String[] args) {
        // Tres palabras de distinta longitud; solo programacion tiene >= 5 caracteres.
        List<String> palabras = List.of("sol", "programacion", "pf");
        // filter(length>=5).count() devuelve cuantas cadenas alcanzan cinco o mas letras.
        long c = palabras.stream().filter(texto -> texto.length() >= 5).count();
        // Muestra 1: una sola palabra (programacion) cumple el criterio de longitud.
        System.out.println(c);
    }
}
