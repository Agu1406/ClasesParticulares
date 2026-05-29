package general.arraylist.resueltos;

import java.util.ArrayList;

/**
 * Ejercicio 4 resuelto: Eliminar y verificar
 * 
 * @author Agustín. A. Marquez. Piña
 * @since 26/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://agu1406.github.io/ClasesParticulares">GitHub Pages</a>
 */
public class Ejercicio4_ArrayListEliminar {
    public static void main(String[] args) {
        ArrayList<String> nombres = new ArrayList<>();
        nombres.add("Ana");
        nombres.add("Luis");
        nombres.add("Marta");
        nombres.add("Pedro");

        nombres.remove("Ana");

        System.out.println("Lista final: " + nombres);
        System.out.println("¿Contiene 'Ana'? " + nombres.contains("Ana"));
    }
}

