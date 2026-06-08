package ev3.ut9_programacionfuncional.pf.u03optional.ejercicios.pendientes;

import java.util.function.Function;

/**
 * Ejercicio 6 (Optional): compose / andThen de Function.
 * 
 * Proposito:
 * Componer funciones puras encadenando transformaciones: salida de una es entrada de la siguiente (estilo matematico f o g).
 * 
 * Objetivos de aprendizaje:
 *   - Function dup = x -> x * 2.
 *   - Function masUno = x -> x + 1.
 *   - dup.andThen(masUno) y apply(5).
 * 
 * Tu tarea:
 * Define dup y masUno, compone con andThen, aplica a 5 e imprime (5*2+1=11).
 * 
 * Salida esperada al ejecutar main:
 * 11
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class Ejercicio6_AndThenCompose_SIN_RESOLVER {
    public static void main(String[] args) {
        // TODO: Function<Integer,Integer> dup = x->x*2; masUno = x->x+1; composed = duplicar.andThen(masUno)
        // TODO: imprimir composed.apply(5) -> 11
    }
}
