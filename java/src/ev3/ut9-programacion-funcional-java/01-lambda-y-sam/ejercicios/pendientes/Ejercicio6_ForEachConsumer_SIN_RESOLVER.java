package ev3.ut9.pf.lambda.pendientes;

import java.util.List;

/**
 * Ejercicio 6 (Lambda y SAM): forEach con Consumer.
 * 
 * Proposito:
 * Usar Consumer<T> para ejecutar una accion sobre cada elemento sin devolver valor, util para recorridos con efecto lateral controlado (imprimir).
 * 
 * Objetivos de aprendizaje:
 *   - Invocar forEach sobre List.
 *   - Lambda Consumer que imprime con formato "N=valor".
 *   - Diferenciar forEach (terminal) de map (transformacion).
 * 
 * Tu tarea:
 * Recorre nums e imprime cada numero con el prefijo "N=" usando forEach y lambda.
 * 
 * Salida esperada al ejecutar main:
 * N=3
N=1
N=4
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class Ejercicio6_ForEachConsumer_SIN_RESOLVER {
    public static void main(String[] args) {
        List<Integer> numeros = List.of(3, 1, 4);
        // TODO: numeros.forEach con lambda que imprima "N=" + n
    }
}
