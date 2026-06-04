package general.condicionales;

/**
 * Teoria: estructura {@code if} en Java.
 *
 * <p><b>Objetivo:</b> ejecutar un bloque solo cuando se cumple una condicion booleana.</p>
 *
 * <pre>{@code
 * if (condicion) {
 *     // se ejecuta si condicion es true
 * }
 * }</pre>
 *
 * <p>Practica en {@code ejercicios/01-if/} (pendientes y resueltos).</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/05/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class IfIntro {

    public static void main(String[] args) {
        int nota = 7;
        if (nota >= 5) {
            System.out.println("Aprobado");
        }
        if (nota < 5) {
            System.out.println("Suspenso");
        }
    }
}
