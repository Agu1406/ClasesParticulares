package ev2.ut4.u02arraylistymapas.ejercicios.pendientes;

import java.util.HashMap;

/**
 * Ejercicio 2: Buscar con {@code containsKey} y {@code get}.
 * Dado un mapa de nombres y notas, comprueba si existe un alumno y muestra su nota;
 * si no existe, muestra un mensaje claro.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/05/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio2_HashMapGetYContainsKey {
    public static void main(String[] args) {
        HashMap<String, Double> notas = new HashMap<>();
        notas.put("Ana", 8.5);
        notas.put("Luis", 6.0);

        String buscado = "Pedro";
        // TODO: Si containsKey(buscado), mostrar nota; si no, mensaje de no encontrado
    }
}
