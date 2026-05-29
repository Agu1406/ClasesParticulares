package general.arraylist.resueltos;

import java.util.ArrayList;

/**
 * Ejercicio 3 resuelto: Buscar mayor en ArrayList
 * 
 * @author Agustín. A. Marquez. Piña
 * @since 26/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio3_ArrayListBuscarMayor {
    public static void main(String[] args) {
        ArrayList<Integer> lista = new ArrayList<>();
        lista.add(12);
        lista.add(7);
        lista.add(30);
        lista.add(4);
        lista.add(18);

        int mayor = buscarMayor(lista);
        System.out.println("El mayor valor es: " + mayor);
    }

    public static int buscarMayor(ArrayList<Integer> lista) {
        int mayor = lista.get(0);
        for (int n : lista) {
            if (n > mayor) {
                mayor = n;
            }
        }
        return mayor;
    }
}

