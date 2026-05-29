package general.condicionales;

/**
 * Ejercicio 10 (ifelse): Comprobar si una letra es mayúscula
 * Versión resuelta.
 *
 * @author Agustín. A. Marquez. Piña
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio10_IFELSE_RESUELTO {
    public static void main(String[] args) {
        char c = 'G';
                if (Character.isUpperCase(c)) {
                    System.out.println("Mayúscula");
                } else {
                    System.out.println("No mayúscula");
                }
    }
}
