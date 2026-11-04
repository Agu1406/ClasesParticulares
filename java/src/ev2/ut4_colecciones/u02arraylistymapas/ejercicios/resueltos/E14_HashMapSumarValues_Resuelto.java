package ev2.ut4_colecciones.u02arraylistymapas.ejercicios.resueltos;

import java.util.HashMap;

/**
 * <p><b>OBJETIVO:</b> Suma las ventas Lunes 12, Martes 8 y Miercoles 15 recorriendo solo los valores del mapa.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> values() da las cantidades. El total es 35.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/05/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class E14_HashMapSumarValues_Resuelto {
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
