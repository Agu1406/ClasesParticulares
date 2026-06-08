package ev2.ut4_colecciones.u02arraylistymapas.ejercicios.resueltos;

import java.util.HashMap;

/**
 * Ejercicio 2 resuelto: Buscar con containsKey y get.
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
        if (notas.containsKey(buscado)) {
            System.out.println(buscado + ": " + notas.get(buscado));
        } else {
            System.out.println("No existe el alumno: " + buscado);
        }
    }
}
