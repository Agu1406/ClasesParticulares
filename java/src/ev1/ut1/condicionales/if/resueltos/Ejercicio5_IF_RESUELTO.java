package general.condicionales;

/**
 * Ejercicio 5 (if): Comprobar si un carácter es vocal
 * Versión resuelta.
 *
 * @author Agustín. A. Marquez. Piña
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://agu1406.github.io/ClasesParticulares">GitHub Pages</a>
 */
public class Ejercicio5_IF_RESUELTO {
    public static void main(String[] args) {
        char c = 'e';
                c = Character.toLowerCase(c);
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    System.out.println("Es vocal");
                }
    }
}
