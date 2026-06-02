package general.condicionales;

/**
 * Teoría: {@code switch} en Java.
 *
 * <p><b>Objetivo:</b> comparar una expresión con varios valores constantes (casos)
 * sin encadenar muchos {@code if-else}.</p>
 *
 * <pre>{@code
 * switch (variable) {
 *     case valor1:
 *         break;
 *     default:
 * }
 * }</pre>
 *
 * <p>Practica en {@code ejercicios/03-switch/} (pendientes y resueltos).</p>
 *
 * @author Agustín. A. Marquez. Piña
 * @since 29/05/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class SwitchIntro {

    public static void main(String[] args) {
        int dia = 3;
        switch (dia) {
            case 1 -> System.out.println("Lunes");
            case 2 -> System.out.println("Martes");
            case 3 -> System.out.println("Miércoles");
            default -> System.out.println("Otro día");
        }
    }
}
