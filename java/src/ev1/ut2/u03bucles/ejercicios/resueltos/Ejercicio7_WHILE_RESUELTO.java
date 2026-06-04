package ev1.ut2.u03bucles.ejercicios.resueltos;

/**
 * Ejercicio 7 (while): Contar digitos de un numero
 * Version resuelta.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio7_WHILE_RESUELTO {
    public static void main(String[] args) {
        int numero = 98765;
                int digitos = 0;
                while (numero > 0) {
                    numero /= 10;
                    digitos++;
                }
                System.out.println("Digitos: " + digitos);
    }
}
