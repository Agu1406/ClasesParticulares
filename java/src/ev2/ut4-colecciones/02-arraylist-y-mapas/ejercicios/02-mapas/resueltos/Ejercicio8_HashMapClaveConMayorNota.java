package general.mapas.resueltos;

import java.util.HashMap;
import java.util.Map;

/**
 * Ejercicio 8 resuelto: Clave con mayor nota.
 *
 * @author Agustín. A. Marquez. Piña
 * @since 29/05/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio8_HashMapClaveConMayorNota {
    public static void main(String[] args) {
        HashMap<String, Double> notas = new HashMap<>();
        notas.put("Ana", 7.5);
        notas.put("Luis", 9.2);
        notas.put("Marta", 6.8);

        String mejorAlumno = null;
        double mejorNota = Double.MIN_VALUE;

        for (Map.Entry<String, Double> entrada : notas.entrySet()) {
            if (entrada.getValue() > mejorNota) {
                mejorNota = entrada.getValue();
                mejorAlumno = entrada.getKey();
            }
        }

        System.out.println("Mayor nota: " + mejorAlumno + " (" + mejorNota + ")");
    }
}
