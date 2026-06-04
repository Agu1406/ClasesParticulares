package ev3.ut9.pf.u04principios.ejercicios.resueltos;

// List.of fabrica listas inmutables de solo lectura, seguras como fuente de datos de prueba.
import java.util.List;

/**
 * Ejercicio 5 (Principios): reduce suma - SOLUCION.
 * 
 * Proposito del ejercicio:
 * Fold numerico con identidad cero.
 * 
 * Que hace este codigo resuelto:
 * reduce acumula 1+2+3+4 e imprime 10.
 * 
 * Conceptos que demuestra:
 *   - reduce terminal.
 *   - Integer::sum method reference.
 *   - Sin bucle for acumulador manual.
 * 
 * Salida al ejecutar main:
 * 10
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class Ejercicio5_ReduceSumaStream_RESUELTO {
    public static void main(String[] args) {
        // Cuatro enteros 1..4 cuya suma funcional debe ser 10.
        List<Integer> numeros = List.of(1, 2, 3, 4);
        // reduce(0, Integer::sum) acumula todos los elementos sin variable acumulador manual.
        int suma = numeros.stream().reduce(0, Integer::sum);
        // Muestra 10: suma 1+2+3+4 obtenida con terminal reduce del stream.
        System.out.println(suma);
    }
}
