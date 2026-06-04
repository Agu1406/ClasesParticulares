package ev3.ut9.pf.u01lambda.ejercicios.resueltos;

// mutable
import java.util.ArrayList;
// List.of
import java.util.List;

/**
 * Ejercicio universidad (sesion1 ej.2): replaceAll mayusculas.
 * 
 * Proposito:
 * replaceAll con lambda en ArrayList.
 * 
 * Origen:
 *   sesion1 ej.2
 * 
 * Tu tarea:
 * Pasar palabras a mayusculas.
 * 
 * Salida esperada al ejecutar main:
 * [JAVA, LAMBDA, EXPRESSION]
 * 
 * SOLUCION.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class Ejercicio20_UniReplaceAllMayusculas_RESUELTO {
    public static void main(String[] args) {
        // lista
        java.util.ArrayList<String> words = new java.util.ArrayList<>(java.util.List.of("java", "lambda", "expression"));
        // replaceAll
        words.replaceAll(s -> s.toUpperCase());
        // salida
        System.out.println(words);
    }
}
