package ev3.ut9.pf.u03optional.ejercicios.resueltos;

// Function<T,R> transforma un valor en otro; base para compose, andThen y pipelines.
import java.util.function.Function;

/**
 * Ejercicio 6 (Optional): andThen compose - SOLUCION.
 * 
 * Proposito del ejercicio:
 * Composicion de funciones con andThen (orden: primero dup, luego masUno).
 * 
 * Que hace este codigo resuelto:
 * comp.apply(5) ejecuta 5*2+1 e imprime 11.
 * 
 * Conceptos que demuestra:
 *   - Function.andThen encadenamiento.
 *   - Funciones pequenas reutilizables.
 *   - compose es el orden inverso de andThen.
 * 
 * Salida al ejecutar main:
 * 11
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class Ejercicio6_AndThenCompose_RESUELTO {
    public static void main(String[] args) {
        // Function dup: transformacion pura que escala cualquier entero al doble.
        Function<Integer, Integer> duplicar = valor -> valor * 2;
        // Function f incrementa; en compose se aplicara despues de g.
        Function<Integer, Integer> masUno = valor -> valor + 1;
        // andThen encadena: apply(5) ejecuta dup(5)=10 y luego masUno(10)=11.
        Function<Integer, Integer> comp = duplicar.andThen(masUno);
        // comp.apply(5) recorre la composicion completa e imprime 11 en consola.
        System.out.println(comp.apply(5));
    }
}
