package ev3.ut9_programacionfuncional.pf.u01lambda.ejercicios.resueltos;

// Supplier
import java.util.function.Supplier;
// builder
import java.util.function.Supplier;

/**
 * Ejercicio universidad (TPP Hoja2 ej.8): Supplier StringBuilder new.
 * 
 * Proposito:
 * StringBuilder::new como Supplier.
 * 
 * Origen:
 *   TPP Hoja2 ej.8
 * 
 * Tu tarea:
 * Dos builders con append distinto.
 * 
 * Salida esperada al ejecutar main:
 * hola
mundo
 * 
 * SOLUCION.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class Ejercicio18_UniSupplierStringBuilderNew_RESUELTO {
    public static void main(String[] args) {
        // constructor ref
        java.util.function.Supplier<StringBuilder> ref = StringBuilder::new;
        // primer builder
        StringBuilder a = ref.get(); a.append("hola");
        // segundo builder
        StringBuilder b = ref.get(); b.append("mundo");
        // hola
        System.out.println(a);
        // mundo
        System.out.println(b);
    }
}
