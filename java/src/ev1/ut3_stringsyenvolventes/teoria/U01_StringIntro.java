package ev1.ut3_stringsyenvolventes.teoria;

/**
 * Teoria: la clase {@link String} en Java.
 *
 * <p><b>Objetivo:</b> trabajar con cadenas inmutables: crear, concatenar, medir longitud
 * y usar metodos habituales ({@code length}, {@code charAt}, {@code substring}, etc.).</p>
 *
 * <p>Siguiente bloque: {@link U02_EnvolventesIntro}. Ejercicios 1–11 (strings) y 12–13 (envolventes)
 * en {@code ejercicios/pendientes} y {@code ejercicios/resueltos}.
 * Practica de centro en {@code practicas/madridiescalderonbarcacadenas/}.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/05/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class U01_StringIntro {

    public static void main(String[] args) {
        String saludo = "Hola";
        String nombre = "Ana";
        String completo = saludo + ", " + nombre;
        System.out.println(completo);
        System.out.println("Longitud: " + completo.length());
        System.out.println("Primera letra: " + completo.charAt(0));
    }
}
