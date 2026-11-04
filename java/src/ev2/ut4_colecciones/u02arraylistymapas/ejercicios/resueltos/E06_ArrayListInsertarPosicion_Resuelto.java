package ev2.ut4_colecciones.u02arraylistymapas.ejercicios.resueltos;

import java.util.ArrayList;

/**
 * <p><b>OBJETIVO:</b> En la lista Ana, Luis, Marta y Pedro inserta Lucia en la posicion 2.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> add(2, Lucia) desplaza a Marta y a Pedro una posicion a la derecha.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 26/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class E06_ArrayListInsertarPosicion_Resuelto {
    public static void main(String[] args) {
        ArrayList<String> nombres = new ArrayList<>();
        nombres.add("Ana");
        nombres.add("Luis");
        nombres.add("Marta");
        nombres.add("Pedro");

        nombres.add(2, "Lucia");
        System.out.println(nombres);
    }
}
