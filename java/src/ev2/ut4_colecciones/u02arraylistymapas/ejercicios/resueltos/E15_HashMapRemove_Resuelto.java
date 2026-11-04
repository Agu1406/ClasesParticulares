package ev2.ut4_colecciones.u02arraylistymapas.ejercicios.resueltos;

import java.util.HashMap;

/**
 * <p><b>OBJETIVO:</b> Mapa de telefonos de Ana, Luis y Marta. Elimina a Luis, muestra el telefono quitado y el tamano final.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> remove devuelve 600333444 y el mapa se queda con dos claves.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/05/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class E15_HashMapRemove_Resuelto {
    public static void main(String[] args) {
        HashMap<String, String> telefonos = new HashMap<>();
        telefonos.put("Ana", "600111222");
        telefonos.put("Luis", "600333444");
        telefonos.put("Marta", "600555666");

        String eliminado = telefonos.remove("Luis");
        System.out.println("Telefono eliminado: " + eliminado);
        System.out.println("Contactos restantes: " + telefonos.size());
        System.out.println(telefonos);
    }
}
