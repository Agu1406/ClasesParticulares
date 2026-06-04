package ev3.ut9.pf.u05repaso.ejercicios.resueltos;

// List.of fabrica listas inmutables de solo lectura, seguras como fuente de datos de prueba.
import java.util.List;

/**
 * Repaso 6: parallelStream sum - SOLUCION.
 * 
 * Proposito del ejercicio:
 * Reduce paralelo sobre lista pequena (demostracion API).
 * 
 * Que hace este codigo resuelto:
 * parallelStream reduce imprime 15.
 * 
 * Conceptos que demuestra:
 *   - parallelStream fork/join interno.
 *   - reduce asociativo conmutativo.
 *   - Uso prudente en datos grandes.
 * 
 * Salida al ejecutar main:
 * 15
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class Ejercicio6_ParallelStreamSum_RESUELTO {
    public static void main(String[] args) {
        // Cuatro enteros 1..4 cuya suma funcional debe ser 10.
        List<Integer> numeros = List.of(1, 2, 3, 4, 5);
        // parallelStream reparte trabajo; reduce suma es asociativo y valido aqui.
        int sumaTotal = numeros.parallelStream().reduce(0, Integer::sum);
        // Muestra 15: suma 1+2+3+4+5 con reduce sobre stream paralelo.
        System.out.println(sumaTotal);
    }
}
