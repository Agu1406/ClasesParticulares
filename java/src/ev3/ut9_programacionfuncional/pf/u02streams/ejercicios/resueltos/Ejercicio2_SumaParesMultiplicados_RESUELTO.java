package ev3.ut9_programacionfuncional.pf.u02streams.ejercicios.resueltos;

// List.of fabrica listas inmutables de solo lectura, seguras como fuente de datos de prueba.
import java.util.List;

/**
 * Ejercicio 2 (Streams API): suma pares * 10 - SOLUCION.
 * 
 * Proposito del ejercicio:
 * Pipeline numerico con terminal reduce.
 * 
 * Que hace este codigo resuelto:
 * Filtra pares, multiplica por 10, suma con reduce(0, Integer::sum) e imprime 200.
 * 
 * Conceptos que demuestra:
 *   - filter + map + reduce encadenados.
 *   - Identidad 0 en reduce.
 *   - Integer::sum como acumulador binario.
 * 
 * Salida al ejecutar main:
 * 200
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class Ejercicio2_SumaParesMultiplicados_RESUELTO {
    public static void main(String[] args) {
        // Ocho enteros consecutivos; cuatro son pares y entraran en el filter.
        List<Integer> listaNumeros = List.of(1, 2, 3, 4, 5, 6, 7, 8);
        // Abre pipeline numerico sobre listNum para encadenar filter, map y reduce.
        int resultado = listaNumeros.stream()
        // filter con numero % 2 == 0 descarta impares antes de multiplicar y sumar.
        .filter(numero -> numero % 2 == 0)
        // map escala cada par restante (2,4,6,8) multiplicandolo por 10.
        .map(numero -> numero * 10)
        // reduce(0, Integer::sum) acumula: 20+40+60+80 = 200 con identidad cero.
        .reduce(0, Integer::sum);
        // Muestra 200: suma de pares multiplicados por diez segun el enunciado.
        System.out.println(resultado);
    }
}
