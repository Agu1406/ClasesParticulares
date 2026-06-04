package general.bucles;

/**
 * Ejercicio 8 (while): Invertir numero 1234
 * Version resuelta.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio8_WHILE_RESUELTO {
    public static void main(String[] args) {
        int numero = 1234;
                int invertido = 0;
                while (numero > 0) {
                    int resto = numero % 10;
                    invertido = invertido * 10 + resto;
                    numero /= 10;
                }
                System.out.println("Invertido: " + invertido);
    }
}
