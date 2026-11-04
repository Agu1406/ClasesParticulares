package ev2.ut4_colecciones.u02arraylistymapas.ejercicios.resueltos;

import java.util.HashMap;

/**
 * <p><b>OBJETIVO:</b> Notas Ana 7.0 y Luis 5.5. Vuelve a hacer put de Ana con 9.0 y comprueba el cambio con get.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> La segunda put de la misma clave sustituye el 7.0. get de Ana devuelve 9.0.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/05/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class E16_HashMapActualizarPut_Resuelto {
    public static void main(String[] args) {
        HashMap<String, Double> notas = new HashMap<>();
        notas.put("Ana", 7.0);
        notas.put("Luis", 5.5);

        notas.put("Ana", 9.0);
        System.out.println("Nota actualizada de Ana: " + notas.get("Ana"));
    }
}
