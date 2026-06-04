package ev3.ut9.pf.u02streams.ejercicios.resueltos;

// List.of fabrica listas inmutables de solo lectura, seguras como fuente de datos de prueba.
import java.util.List;

/**
 * Ejercicio 9 (Streams API): anyMatch / allMatch - SOLUCION.
 * 
 * Proposito del ejercicio:
 * Evaluacion booleana agregada sobre stream.
 * 
 * Que hace este codigo resuelto:
 * Comprueba todos pares (true) y existencia de > 10 (false) e imprime ambos.
 * 
 * Conceptos que demuestra:
 *   - allMatch short-circuit en fallo.
 *   - anyMatch short-circuit en exito.
 *   - Terminales booleanas.
 * 
 * Salida al ejecutar main:
 * true
false
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class Ejercicio9_AnyMatchAllMatch_RESUELTO {
    public static void main(String[] args) {
        // Todos los elementos son pares; allMatch deberia ser true, anyMatch(>10) false.
        List<Integer> numeros = List.of(2, 4, 6, 8);
        // allMatch comprueba condicion en TODOS; short-circuit al primer fallo.
        boolean todosPares = numeros.stream().allMatch(numero -> numero % 2 == 0);
        // anyMatch busca al menos un elemento >10; aqui ninguno cumple.
        boolean algunoGrande = numeros.stream().anyMatch(numero -> numero > 10);
        // Imprime true porque 2,4,6,8 son todos divisibles por dos.
        System.out.println(todosPares);
        // Imprime false porque ningun elemento supera 10 en esta lista.
        System.out.println(algunoGrande);
    }
}
