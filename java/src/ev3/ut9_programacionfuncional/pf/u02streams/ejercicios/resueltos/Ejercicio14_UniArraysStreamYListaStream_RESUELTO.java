package ev3.ut9_programacionfuncional.pf.u02streams.ejercicios.resueltos;

// stream array
import java.util.Arrays;
// lista nombres
import java.util.List;

/**
 * Ejercicio universidad (TPP Hoja2 bloque2 ej.1): Arrays stream y lista stream.
 * 
 * Proposito:
 * Crear IntStream y Stream desde array y lista.
 * 
 * Origen:
 *   TPP Hoja2 bloque2 ej.1
 * 
 * Tu tarea:
 * forEach en ambos.
 * 
 * Salida esperada al ejecutar main:
 * (numeros y nombres)
 * 
 * SOLUCION.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class Ejercicio14_UniArraysStreamYListaStream_RESUELTO {
    public static void main(String[] args) {
        // array
        int[] datos = {1, 2, 3, 4, 5};
        // lista
        java.util.List<String> nombres = java.util.List.of("Ana", "Luis", "Bea");
        // titulo
        System.out.println("Stream desde array:");
        // int stream
        java.util.Arrays.stream(datos).forEach(n -> System.out.println(n));
        // titulo2
        System.out.println("Stream desde lista:");
        // string stream
        nombres.stream().forEach(n -> System.out.println(n));
    }
}
