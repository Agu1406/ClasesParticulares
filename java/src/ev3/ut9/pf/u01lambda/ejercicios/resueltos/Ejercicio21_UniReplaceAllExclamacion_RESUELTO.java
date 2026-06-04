package ev3.ut9.pf.u01lambda.ejercicios.resueltos;

// mutable
import java.util.ArrayList;
// List.of
import java.util.List;

/**
 * Ejercicio universidad (sesion1 ej.6): replaceAll exclamacion.
 * 
 * Proposito:
 * Anadir ! al final de cada palabra.
 * 
 * Origen:
 *   sesion1 ej.6
 * 
 * Tu tarea:
 * replaceAll con lambda.
 * 
 * Salida esperada al ejecutar main:
 * [sun!, moon!, earth!]
 * 
 * SOLUCION.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class Ejercicio21_UniReplaceAllExclamacion_RESUELTO {
    public static void main(String[] args) {
        // lista
        java.util.ArrayList<String> words = new java.util.ArrayList<>(java.util.List.of("sun", "moon", "earth"));
        // anade exclamacion
        words.replaceAll(s -> s + "!");
        // salida
        System.out.println(words);
    }
}
