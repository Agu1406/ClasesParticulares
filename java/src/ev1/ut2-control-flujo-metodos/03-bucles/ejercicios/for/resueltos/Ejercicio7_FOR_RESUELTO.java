package general.bucles;

/**
 * Ejercicio 7 (for): Contar vocales en una palabra
 * Versión resuelta.
 *
 * @author Agustín. A. Marquez. Piña
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio7_FOR_RESUELTO {
    public static void main(String[] args) {
        String palabra = "programacion";
                int vocales = 0;
                for (int i = 0; i < palabra.length(); i++) {
                    char c = Character.toLowerCase(palabra.charAt(i));
                    if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                        vocales++;
                    }
                }
                System.out.println("Vocales: " + vocales);
    }
}
