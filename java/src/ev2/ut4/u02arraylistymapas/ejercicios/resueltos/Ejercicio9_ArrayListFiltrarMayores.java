package ev2.ut4.u02arraylistymapas.ejercicios.resueltos;

import java.util.ArrayList;

/**
 * Ejercicio 9 resuelto: Filtrar mayores que un valor
 * 
 * @author Agustin. A. Marquez. Pina
 * @since 26/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio9_ArrayListFiltrarMayores {
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

