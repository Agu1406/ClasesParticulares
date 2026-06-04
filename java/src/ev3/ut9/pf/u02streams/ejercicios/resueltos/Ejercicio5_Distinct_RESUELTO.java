package ev3.ut9.pf.u02streams.ejercicios.resueltos;

// List.of fabrica listas inmutables de solo lectura, seguras como fuente de datos de prueba.
import java.util.List;
// Collectors materializa el stream en coleccion, String u otro tipo segun el terminal elegido.
import java.util.stream.Collectors;

/**
 * Ejercicio 5 (Streams API): distinct - SOLUCION.
 * 
 * Proposito del ejercicio:
 * Deduplicacion funcional en pipeline.
 * 
 * Que hace este codigo resuelto:
 * Aplica distinct sobre letras repetidas y recolecta [a, b, c].
 * 
 * Conceptos que demuestra:
 *   - distinct mantiene orden de encuentro.
 *   - Sin modificar lista fuente List.of.
 *   - collect toList materializa.
 * 
 * Salida al ejecutar main:
 * [a, b, c]
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class Ejercicio5_Distinct_RESUELTO {
    public static void main(String[] args) {
        // Secuencia con duplicados a,b,a,c,b; distinct eliminara repeticiones.
        List<String> letras = List.of("a", "b", "a", "c", "b");
        // distinct() conserva primera aparicion de cada letra segun orden del stream.
        List<String> unicas = letras.stream().distinct().collect(Collectors.toList());
        // Muestra [a, b, c]: tres letras unicas en orden de primera aparicion.
        System.out.println(unicas);
    }
}
