package general.mapas.resueltos;

import java.util.HashMap;

/**
 * Ejercicio 5 resuelto: Eliminar con remove.
 *
 * @author Agustín. A. Marquez. Piña
 * @since 29/05/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio5_HashMapRemove {
    public static void main(String[] args) {
        HashMap<String, String> telefonos = new HashMap<>();
        telefonos.put("Ana", "600111222");
        telefonos.put("Luis", "600333444");
        telefonos.put("Marta", "600555666");

        String eliminado = telefonos.remove("Luis");
        System.out.println("Teléfono eliminado: " + eliminado);
        System.out.println("Contactos restantes: " + telefonos.size());
        System.out.println(telefonos);
    }
}
