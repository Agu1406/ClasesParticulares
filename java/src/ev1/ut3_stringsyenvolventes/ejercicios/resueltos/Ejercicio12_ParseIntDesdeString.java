package ev1.ut3_stringsyenvolventes.ejercicios.resueltos;

/**
 * Ejercicio 12: Convertir String a int con Integer.parseInt
 * Implementa parsearEntero(String) que devuelve el entero o -1 si el texto no es valido.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio12_ParseIntDesdeString {

    public static int parsearEntero(String texto) {
        try {
            return Integer.parseInt(texto);
        } catch (NumberFormatException excepcion) {
            return -1;
        }
    }

    public static void main(String[] args) {
        System.out.println(parsearEntero("10"));
        System.out.println(parsearEntero("abc"));
        System.out.println(parsearEntero("-5"));
    }
}
