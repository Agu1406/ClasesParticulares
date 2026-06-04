package ev2.ut4.u02arraylistymapas.ejercicios.pendientes;

import java.util.HashMap;

/**
 * Ejercicio 6: Actualizar con {@code put}.
 * Si la clave ya existe, {@code put} sustituye el valor. Actualiza la nota de un alumno
 * y comprueba el cambio con {@code get}.
 *
 * @author Agustin. A. Marquez. Pina
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

        // TODO: put("Ana", 9.0) y mostrar la nota actualizada
    }
}
