package general.arraylist;

import java.util.ArrayList;

/**
 * Teoría: {@link ArrayList} en Java.
 *
 * <p><b>Objetivo:</b> usar listas dinámicas que crecen y se reducen en tiempo de ejecución,
 * frente a un array de tamaño fijo.</p>
 *
 * <p>Operaciones habituales:</p>
 * <ul>
 *   <li>{@code new ArrayList&lt;&gt;()} — crear lista vacía.</li>
 *   <li>{@code add(valor)} — añadir al final.</li>
 *   <li>{@code add(indice, valor)} — insertar en una posición.</li>
 *   <li>{@code get(indice)} / {@code set(indice, valor)} — leer y modificar.</li>
 *   <li>{@code remove(valor)} / {@code remove(indice)} — eliminar.</li>
 *   <li>{@code size()}, {@code contains(valor)}, {@code isEmpty()}.</li>
 * </ul>
 *
 * <p>Recorrido: bucle {@code for} por índice o {@code for-each} sobre la lista.</p>
 *
 * <p>Ejercicios ArrayList en {@code ejercicios/01-arraylist/pendientes} y {@code resueltos}
 * (clases {@code Ejercicio*_ArrayList*}).</p>
 *
 * @author Agustín. A. Marquez. Piña
 * @since 29/05/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class ArrayListIntro {

    public static void main(String[] args) {
        ArrayList<Integer> numeros = new ArrayList<>();
        numeros.add(10);
        numeros.add(20);
        numeros.add(30);

        System.out.println("Tamaño: " + numeros.size());
        System.out.println("Primer elemento: " + numeros.get(0));

        numeros.set(1, 99);
        System.out.println("Tras set(1, 99): " + numeros);

        for (int n : numeros) {
            System.out.println("Valor: " + n);
        }
    }
}
