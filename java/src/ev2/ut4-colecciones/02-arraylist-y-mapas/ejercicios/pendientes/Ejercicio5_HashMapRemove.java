package general.mapas;

import java.util.HashMap;

/**
 * Ejercicio 5: Eliminar con {@code remove}.
 * Elimina una clave del mapa, muestra el valor eliminado y el tamaño final.
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

        // TODO: remove("Luis"), imprimir valor devuelto y size()
    }
}
