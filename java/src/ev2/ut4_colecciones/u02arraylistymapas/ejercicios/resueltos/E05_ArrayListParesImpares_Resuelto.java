package ev2.ut4_colecciones.u02arraylistymapas.ejercicios.resueltos;

import java.util.ArrayList;

/**
 * <p><b>OBJETIVO:</b> Separa 1, 2, 3, 4, 5 y 6 en dos ArrayList: pares e impares.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> Un for-each mira n % 2 y anade el numero a la lista que le corresponde.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 26/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class E05_ArrayListParesImpares_Resuelto {
    public static void main(String[] args) {
        ArrayList<Integer> original = new ArrayList<>();
        original.add(1);
        original.add(2);
        original.add(3);
        original.add(4);
        original.add(5);
        original.add(6);

        ArrayList<Integer> pares = new ArrayList<>();
        ArrayList<Integer> impares = new ArrayList<>();

        for (int n : original) {
            if (n % 2 == 0) {
                pares.add(n);
            } else {
                impares.add(n);
            }
        }

        System.out.println("Original: " + original);
        System.out.println("Pares: " + pares);
        System.out.println("Impares: " + impares);
    }
}
