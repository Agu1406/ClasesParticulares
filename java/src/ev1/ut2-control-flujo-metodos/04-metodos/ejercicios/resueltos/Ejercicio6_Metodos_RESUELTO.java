package general.metodos;

/**
 * Ejercicio 6: Función que retorna boolean
 * Versión resuelta.
 *
 * @author Agustín. A. Marquez. Piña
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio6_Metodos_RESUELTO {

    public static boolean esPar(int numero) {
            return numero % 2 == 0;
        }

    public static void main(String[] args) {
        System.out.println("¿Es par? " + esPar(14));
    }
}
