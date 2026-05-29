package general.arraylist.resueltos;

import java.util.ArrayList;

/**
 * Ejercicio 10 resuelto: Eliminar duplicados manualmente
 * 
 * @author Agustín. A. Marquez. Piña
 * @since 26/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://agu1406.github.io/ClasesParticulares">GitHub Pages</a>
 */
public class Ejercicio10_ArrayListEliminarDuplicados {
    public static void main(String[] args) {
        ArrayList<Integer> original = new ArrayList<>();
        original.add(1);
        original.add(2);
        original.add(2);
        original.add(3);
        original.add(1);
        original.add(4);

        ArrayList<Integer> sinDuplicados = new ArrayList<>();
        for (int n : original) {
            if (!sinDuplicados.contains(n)) {
                sinDuplicados.add(n);
            }
        }

        System.out.println("Original: " + original);
        System.out.println("Sin duplicados: " + sinDuplicados);
    }
}

