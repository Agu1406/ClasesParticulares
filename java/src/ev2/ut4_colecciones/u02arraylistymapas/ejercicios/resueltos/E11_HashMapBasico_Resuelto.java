package ev2.ut4_colecciones.u02arraylistymapas.ejercicios.resueltos;

import java.util.HashMap;

/**
 * <p><b>OBJETIVO:</b> Crea un HashMap de creditos: 0483 vale 6, 0485 vale 12 y 0487 vale 6. Muestra cada par con get.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> put guarda cada asignatura. get recupera los creditos de las tres claves.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/05/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class E11_HashMapBasico_Resuelto {
    public static void main(String[] args) {
        HashMap<String, Integer> creditos = new HashMap<>();
        creditos.put("0483", 6);
        creditos.put("0485", 12);
        creditos.put("0487", 6);

        System.out.println("0485 -> " + creditos.get("0485"));
        System.out.println("0483 -> " + creditos.get("0483"));
        System.out.println("0487 -> " + creditos.get("0487"));
    }
}
