package ev3.ut9.pf.lambda.resueltos;

// ArrayList: coleccion que permite cambiar tamano y orden; necesaria para sort in-place.
import java.util.ArrayList;
// Collections aporta sort, que ordena listas mutables usando un Comparator (aqui, lambda).
import java.util.Collections;
// List.of fabrica listas inmutables de solo lectura, seguras como fuente de datos de prueba.
import java.util.List;

/**
 * Ejercicio 1 (Lambda y SAM): ordenar palabras por longitud - SOLUCION.
 * 
 * Proposito del ejercicio:
 * Mostrar la forma canonica de ordenar una lista de String por longitud con lambda.
 * 
 * Que hace este codigo resuelto:
 * Crea una ArrayList con cuatro palabras, las ordena comparando s1.length() - s2.length() mediante Collections.sort y muestra la lista reordenada en consola.
 * 
 * Conceptos que demuestra:
 *   - Comparator implementado como expresion lambda.
 *   - Collections.sort in-place sobre lista mutable.
 *   - Orden ascendente por longitud de cadena.
 * 
 * Salida al ejecutar main:
 * [pf, java, funcional, programacion]
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class Ejercicio1_OrdenarPorLongitud_RESUELTO {
    public static void main(String[] args) {
        // Datos de partida en ArrayList para poder reordenarlos con Collections.sort.
        List<String> palabras = new ArrayList<>(List.of("programacion", "funcional", "java", "pf"));
        // Comparator lambda: resta de longitudes ordena de la palabra mas corta a la mas larga.
        Collections.sort(palabras, (primeraPalabra, segundaPalabra) -> primeraPalabra.length() - segundaPalabra.length());
        // Imprime la lista ya ordenada; comprueba visualmente el orden por numero de caracteres.
        System.out.println(palabras);
    }
}
