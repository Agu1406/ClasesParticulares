package general.arraylist.resueltos;

import java.util.ArrayList;

/**
 * Ejercicio 1 resuelto: ArrayList básico
 * 
 * @author Agustín. A. Marquez. Piña
 * @since 26/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://agu1406.github.io/ClasesParticulares">GitHub Pages</a>
 */
public class Ejercicio1_ArrayListBasico {
    public static void main(String[] args) {
        ArrayList<Integer> numeros = new ArrayList<>();
        numeros.add(4);
        numeros.add(6);
        numeros.add(5);
        numeros.add(7);
        numeros.add(2);

        System.out.println("Valores de la lista:");
        for (int i = 0; i < numeros.size(); i++) {
            System.out.println("Posición " + i + ": " + numeros.get(i));
        }
    }
}

