package general.mapas;

import java.util.HashMap;

/**
 * Ejercicio 3: Recorrer con {@code entrySet()}.
 * Imprime todos los pares clave-valor de un mapa de productos y precios.
 *
 * @author Agustín. A. Marquez. Piña
 * @since 29/05/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio3_HashMapRecorrerEntrySet {
    public static void main(String[] args) {
        HashMap<String, Double> precios = new HashMap<>();
        precios.put("Teclado", 29.99);
        precios.put("Ratón", 15.50);
        precios.put("Monitor", 199.00);

        // TODO: Bucle for sobre entrySet e imprimir producto y precio
    }
}
