package general.bucles;

/**
 * Ejercicio 7 (while): Contar dígitos de un número
 * Versión resuelta.
 *
 * @author Agustín. A. Marquez. Piña
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://agu1406.github.io/ClasesParticulares">GitHub Pages</a>
 */
public class Ejercicio7_WHILE_RESUELTO {
    public static void main(String[] args) {
        int numero = 98765;
                int digitos = 0;
                while (numero > 0) {
                    numero /= 10;
                    digitos++;
                }
                System.out.println("Dígitos: " + digitos);
    }
}
