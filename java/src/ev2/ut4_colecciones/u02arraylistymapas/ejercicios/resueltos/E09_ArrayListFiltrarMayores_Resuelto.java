package ev2.ut4_colecciones.u02arraylistymapas.ejercicios.resueltos;

import java.util.ArrayList;

/**
 * <p><b>OBJETIVO:</b> De 4, 12, 7, 18 y 10 crea otra lista solo con los valores mayores o iguales que 10.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> El for-each anade a la lista nueva solo cuando n es mayor o igual que 10.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 26/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class E09_ArrayListFiltrarMayores_Resuelto {
    public static void main(String[] args) {
        ArrayList<Integer> original = new ArrayList<>();
        original.add(4);
        original.add(12);
        original.add(7);
        original.add(18);
        original.add(10);

        ArrayList<Integer> filtrada = new ArrayList<>();
        for (int n : original) {
            if (n >= 10) {
                filtrada.add(n);
            }
        }

        System.out.println("Original: " + original);
        System.out.println("Filtrada (>=10): " + filtrada);
    }
}
