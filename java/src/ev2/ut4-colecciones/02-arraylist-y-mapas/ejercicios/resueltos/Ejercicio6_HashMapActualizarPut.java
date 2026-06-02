package general.mapas.resueltos;

import java.util.HashMap;

/**
 * Ejercicio 6 resuelto: Actualizar con put.
 *
 * @author Agustín. A. Marquez. Piña
 * @since 29/05/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio6_HashMapActualizarPut {
    public static void main(String[] args) {
        HashMap<String, Double> notas = new HashMap<>();
        notas.put("Ana", 7.0);
        notas.put("Luis", 5.5);

        notas.put("Ana", 9.0);
        System.out.println("Nota actualizada de Ana: " + notas.get("Ana"));
    }
}
