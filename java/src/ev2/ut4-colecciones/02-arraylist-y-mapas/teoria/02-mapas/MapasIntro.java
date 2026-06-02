package general.mapas;

import java.util.HashMap;
import java.util.Map;

/**
 * Teoría: mapas ({@link HashMap}) en Java.
 *
 * <p><b>Objetivo:</b> almacenar pares <em>clave → valor</em> y recuperar datos por clave
 * sin recorrer toda la estructura.</p>
 *
 * <p>Operaciones habituales:</p>
 * <ul>
 *   <li>{@code put(clave, valor)} — insertar o actualizar.</li>
 *   <li>{@code get(clave)} — obtener el valor (o {@code null} si no existe).</li>
 *   <li>{@code containsKey(clave)} — comprobar si la clave está registrada.</li>
 *   <li>{@code remove(clave)} — eliminar un par.</li>
 *   <li>{@code size()}, {@code isEmpty()}, {@code clear()}.</li>
 * </ul>
 *
 * <p>Recorrido: {@code entrySet()} (clave y valor), {@code keySet()} o {@code values()}.</p>
 *
 * <p>Ejercicios HashMap en {@code ejercicios/02-mapas/pendientes} y {@code resueltos}
 * (clases {@code Ejercicio*_HashMap*}).</p>
 *
 * @author Agustín. A. Marquez. Piña
 * @since 29/05/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class MapasIntro {

    public static void main(String[] args) {
        HashMap<String, Integer> edades = new HashMap<>();
        edades.put("Ana", 20);
        edades.put("Luis", 22);
        edades.put("Marta", 19);

        System.out.println("Edad de Luis: " + edades.get("Luis"));
        System.out.println("¿Existe Pedro? " + edades.containsKey("Pedro"));

        System.out.println("--- Todos los pares ---");
        for (Map.Entry<String, Integer> entrada : edades.entrySet()) {
            System.out.println(entrada.getKey() + " -> " + entrada.getValue());
        }
    }
}
