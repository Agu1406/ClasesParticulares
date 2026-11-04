package ev2.ut4_colecciones.u02arraylistymapas.ejercicios.resueltos;

import java.util.ArrayList;

/**
 * <p><b>OBJETIVO:</b> Crea la lista Ana, Luis, Marta y Pedro. Elimina Ana y comprueba con contains si sigue en la lista.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> remove quita a Ana. contains devuelve false despues de eliminarla.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 26/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class E04_ArrayListEliminar_Resuelto {
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
