package general.strings;

/**
 * Teoria: la clase {@link String} en Java.
 *
 * <p><b>Objetivo:</b> trabajar con cadenas inmutables: crear, concatenar, medir longitud
 * y usar metodos habituales ({@code length}, {@code charAt}, {@code substring}, etc.).</p>
 *
 * <p>Ejercicios en {@code ejercicios/pendientes} y {@code ejercicios/resueltos}.
 * Practica de centro en {@code practicas/madrid-iescalderonbarca-cadenas/}.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/05/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class StringIntro {

    public static void main(String[] args) {
        String saludo = "Hola";
        String nombre = "Ana";
        String completo = saludo + ", " + nombre;
        System.out.println(completo);
        System.out.println("Longitud: " + completo.length());
        System.out.println("Primera letra: " + completo.charAt(0));
    }
}
