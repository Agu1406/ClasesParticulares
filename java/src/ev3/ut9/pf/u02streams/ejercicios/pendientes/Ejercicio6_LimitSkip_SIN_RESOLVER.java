package ev3.ut9.pf.u02streams.ejercicios.pendientes;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Ejercicio 6 (Streams API): limit y skip.
 * 
 * Proposito:
 * Paginar o trocear un stream: skip salta elementos iniciales, limit acota cuantos pasan adelante (util en datos grandes).
 * 
 * Objetivos de aprendizaje:
 *   - skip(2) para omitir los dos primeros.
 *   - limit(3) para quedarse con tres siguientes.
 *   - collect del trozo resultante.
 * 
 * Tu tarea:
 * De la lista de seis numeros, salta los dos primeros, toma los tres siguientes e imprime ese subconjunto.
 * 
 * Salida esperada al ejecutar main:
 * [30, 40, 50]
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class Ejercicio6_LimitSkip_SIN_RESOLVER {
    public static void main(String[] args) {
        List<Integer> numeros = List.of(10, 20, 30, 40, 50, 60);
        // TODO: stream skip(2) limit(3) collect
    }
}
