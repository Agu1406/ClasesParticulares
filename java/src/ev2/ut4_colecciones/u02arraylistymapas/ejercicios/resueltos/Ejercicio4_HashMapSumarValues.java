package ev2.ut4_colecciones.u02arraylistymapas.ejercicios.resueltos;

import java.util.HashMap;

/**
 * Ejercicio 4 resuelto: Sumar todos los valores.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/05/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio4_HashMapSumarValues {
    public static void main(String[] args) {
        HashMap<String, Integer> ventas = new HashMap<>();
        ventas.put("Lunes", 12);
        ventas.put("Martes", 8);
        ventas.put("Miercoles", 15);

        int total = 0;
        for (int cantidad : ventas.values()) {
            total += cantidad;
        }
        System.out.println("Total ventas: " + total);
    }
}
