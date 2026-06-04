package general.mapas;

import java.util.HashMap;

/**
 * Ejercicio 7: Contar aprobados.
 * Cuenta cuantas notas del mapa son mayores o iguales que 5.0 (aprobado).
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/05/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio7_HashMapContarAprobados {
    public static void main(String[] args) {
        HashMap<String, Double> notas = new HashMap<>();
        notas.put("Ana", 8.0);
        notas.put("Luis", 4.5);
        notas.put("Marta", 6.0);
        notas.put("Pedro", 3.0);

        // TODO: Recorrer values y contar notas >= 5.0
    }
}
