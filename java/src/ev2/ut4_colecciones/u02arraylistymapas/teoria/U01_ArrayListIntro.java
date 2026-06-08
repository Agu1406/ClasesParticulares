package ev2.ut4_colecciones.u02arraylistymapas.teoria;

import java.util.ArrayList;

/**
 * Teoria: {@link ArrayList} en Java.
 *
 * <p><b>Objetivo:</b> usar listas dinamicas que crecen y se reducen en tiempo de ejecucion,
 * frente a un array de tamano fijo.</p>
 *
 * <p>Operaciones habituales:</p>
 * <ul>
 *   <li>{@code new ArrayList&lt;&gt;()} - crear lista vacia.</li>
 *   <li>{@code add(valor)} - anadir al final.</li>
 *   <li>{@code add(indice, valor)} - insertar en una posicion.</li>
 *   <li>{@code get(indice)} / {@code set(indice, valor)} - leer y modificar.</li>
 *   <li>{@code remove(valor)} / {@code remove(indice)} - eliminar.</li>
 *   <li>{@code size()}, {@code contains(valor)}, {@code isEmpty()}.</li>
 * </ul>
 *
 * <p>Recorrido: bucle {@code for} por indice o {@code for-each} sobre la lista.</p>
 *
 * <p>Ejercicios ArrayList en {@code ejercicios/01-arraylist/pendientes} y {@code resueltos}
 * (clases {@code Ejercicio*_ArrayList*}).</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/05/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class U01_ArrayListIntro {

    public static void main(String[] args) {
        ArrayList<Integer> numeros = new ArrayList<>();
        numeros.add(10);
        numeros.add(20);
        numeros.add(30);

        System.out.println("Tamano: " + numeros.size());
        System.out.println("Primer elemento: " + numeros.get(0));

        numeros.set(1, 99);
        System.out.println("Tras set(1, 99): " + numeros);

        for (int n : numeros) {
            System.out.println("Valor: " + n);
        }
    }
}
