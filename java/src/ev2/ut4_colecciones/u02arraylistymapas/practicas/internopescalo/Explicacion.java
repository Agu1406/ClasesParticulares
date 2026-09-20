package ev2.ut4_colecciones.u02arraylistymapas.practicas.internopescalo;

import java.util.ArrayList;

/**
 * <p><b>OBJETIVO:</b> Mini demo de clase — {@code remove(0)} al repartir elementos
 * de un {@code ArrayList} a dos listas (base de Pescalo).</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 05/09/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Explicacion {

    public static void main(String[] args) {
        ArrayList<String> regalos = new ArrayList<>();
        ArrayList<String> regalosDani = new ArrayList<>();
        ArrayList<String> regalosAgus = new ArrayList<>();

        regalos.add("Regalo1");
        regalos.add("Regalo2");

        repartirRegalos(regalos, regalosDani, regalosAgus);

        System.out.println("Regalo de Agustin " + regalosAgus.get(0));
        System.out.println("Regalo de Daniel " + regalosDani.get(0));
    }

    public static void repartirRegalos(ArrayList<String> regalos,
            ArrayList<String> regalosDani, ArrayList<String> regalosAgus) {
        regalosDani.add(regalos.remove(0));
        regalosAgus.add(regalos.remove(0));
        System.out.println("¡Todos han recibido un regalo!");
    }
}
