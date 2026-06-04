package general.mapas.resueltos;

import java.util.HashMap;

/**
 * Ejercicio 7 resuelto: Contar aprobados.
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

        int aprobados = 0;
        for (double nota : notas.values()) {
            if (nota >= 5.0) {
                aprobados++;
            }
        }
        System.out.println("Aprobados: " + aprobados);
    }
}
