package ev3.ut9.pf.u01lambda.ejercicios.resueltos;

// mutable
import java.util.ArrayList;
// List.of
import java.util.List;

/**
 * Ejercicio universidad (sesion1 ej.7): removeIf empieza por m.
 * 
 * Proposito:
 * removeIf elimina palabras que empiezan por m (ignore case).
 * 
 * Origen:
 *   sesion1 ej.7
 * 
 * Tu tarea:
 * removeIf lambda.
 * 
 * Salida esperada al ejecutar main:
 * [pear, kiwi]
 * 
 * SOLUCION.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class Ejercicio22_UniRemoveIfEmpiezaPorM_RESUELTO {
    public static void main(String[] args) {
        // lista
        java.util.ArrayList<String> words = new java.util.ArrayList<>(java.util.List.of("melon", "pear", "mango", "kiwi"));
        // removeIf
        words.removeIf(s -> s.toLowerCase().startsWith("m"));
        // salida
        System.out.println(words);
    }
}
