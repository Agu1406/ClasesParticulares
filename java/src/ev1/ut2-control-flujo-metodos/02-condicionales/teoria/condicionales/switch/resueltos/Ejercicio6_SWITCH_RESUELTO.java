package general.condicionales;

/**
 * Ejercicio 6 (switch): Convertir vocal a mayúscula
 * Versión resuelta.
 *
 * @author Agustín. A. Marquez. Piña
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio6_SWITCH_RESUELTO {
    public static void main(String[] args) {
        char vocal = 'i';
                switch (vocal) {
                    case 'a': System.out.println('A'); break;
                    case 'e': System.out.println('E'); break;
                    case 'i': System.out.println('I'); break;
                    case 'o': System.out.println('O'); break;
                    case 'u': System.out.println('U'); break;
                    default: System.out.println("No es vocal");
                }
    }
}
