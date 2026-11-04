package ev2.ut4_colecciones.u02arraylistymapas.ejercicios.resueltos;

import java.util.HashMap;
import java.util.Map;

/**
 * <p><b>OBJETIVO:</b> Imprime los pares Teclado 29.99, Raton 15.50 y Monitor 199.00 recorriendo entrySet.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> Cada Map.Entry da la clave y el valor del producto.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/05/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class E13_HashMapRecorrerEntrySet_Resuelto {
    public static void main(String[] args) {
        HashMap<String, Double> precios = new HashMap<>();
        precios.put("Teclado", 29.99);
        precios.put("Raton", 15.50);
        precios.put("Monitor", 199.00);

        for (Map.Entry<String, Double> entrada : precios.entrySet()) {
            System.out.println(entrada.getKey() + " -> " + entrada.getValue() + " ?");
        }
    }
}
