package ev3.ut9.pf.u04principios.ejercicios.pendientes;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Ejercicio 1 (Principios): collect sin efectos secundarios.
 * 
 * Proposito:
 * Transformar datos produciendo nueva coleccion sin mutar fuente ni usar variables externas en forEach, principio central del estilo funcional en Java.
 * 
 * Objetivos de aprendizaje:
 *   - stream + map + collect toList.
 *   - No modificar lista original names.
 *   - Imprimir resultado y verificar original intacta.
 * 
 * Tu tarea:
 * Pasa nombres a mayusculas con stream/collect (NO forEach con add externo). Imprime mayusculas y luego la lista original sin cambios.
 * 
 * Salida esperada al ejecutar main:
 * [ANA, BOB, CARLOS]
[ana, bob, carlos]
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class Ejercicio1_CollectSinEfectosSecundarios_SIN_RESOLVER {
    public static void main(String[] args) {
        List<String> nombres = List.of("ana", "bob", "carlos");
        // TODO: stream map toUpperCase collect toList e imprimir
    }
}
