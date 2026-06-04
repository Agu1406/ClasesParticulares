package ev3.ut9.pf.repaso.pendientes;

import java.util.List;

/**
 * Repaso 1: pipeline mixto filter, map y reduce.
 * 
 * Proposito:
 * Integrar tres operaciones stream en un ejercicio de repaso: filtrar, transformar y agregar numericamente.
 * 
 * Objetivos de aprendizaje:
 *   - filter numeros > 5.
 *   - map cuadrado n*n.
 *   - reduce suma e imprimir.
 * 
 * Tu tarea:
 * Calcula suma de cuadrados de numeros mayores que 5 de la lista e imprime (6^2 + 8^2 + 9^2 = 36+64+81=181).
 * 
 * Salida esperada al ejecutar main:
 * 181
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class Ejercicio1_RepasoMixto_SIN_RESOLVER {
    public static void main(String[] args) {
        List<Integer> numeros = List.of(1, 3, 6, 8, 2, 9);
        // TODO: filter > 5, map numero*numero, reduce suma, imprimir
    }
}
