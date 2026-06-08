package ev3.ut9_programacionfuncional.pf.u01lambda.ejercicios.resueltos;

// lista mutable
import java.util.ArrayList;
// List.of no usado aqui
import java.util.List;
// Consumer
import java.util.function.Consumer;

/**
 * Ejercicio universidad (TPP Hoja2 ej.6): Consumer list add.
 * 
 * Proposito:
 * words::add como Consumer que muta la lista.
 * 
 * Origen:
 *   TPP Hoja2 ej.6
 * 
 * Tu tarea:
 * Anadir alfa, beta, gamma; imprimir lista.
 * 
 * Salida esperada al ejecutar main:
 * [alfa, beta, gamma]
 * 
 * SOLUCION.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class Ejercicio16_UniConsumerListAdd_RESUELTO {
    public static void main(String[] args) {
        // lista vacia
        java.util.ArrayList<String> palabras = new java.util.ArrayList<>();
        // referencia add
        java.util.function.Consumer<String> ref = palabras::add;
        // lambda add
        java.util.function.Consumer<String> lam = p -> palabras.add(p);
        // tres adds
        ref.accept("alfa"); lam.accept("beta"); ref.accept("gamma");
        // resultado
        System.out.println(palabras);
    }
}
