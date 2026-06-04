package general.mapas.resueltos;

import java.util.HashMap;

/**
 * Ejercicio 1 resuelto: HashMap basico.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/05/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio1_HashMapBasico {
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
