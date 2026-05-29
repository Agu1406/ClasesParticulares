package general.arraylist.resueltos;

import java.util.ArrayList;

/**
 * Ejercicio 6 resuelto: Insertar en posición
 * 
 * @author Agustín. A. Marquez. Piña
 * @since 26/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio6_ArrayListInsertarPosicion {
    public static void main(String[] args) {
        ArrayList<String> nombres = new ArrayList<>();
        nombres.add("Ana");
        nombres.add("Luis");
        nombres.add("Marta");
        nombres.add("Pedro");

        nombres.add(2, "Lucía");
        System.out.println(nombres);
    }
}

