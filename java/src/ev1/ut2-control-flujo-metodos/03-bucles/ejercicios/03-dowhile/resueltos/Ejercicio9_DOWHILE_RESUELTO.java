package general.bucles;

/**
 * Ejercicio 9 (dowhile): Mostrar divisores de 18
 * Version resuelta.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio9_DOWHILE_RESUELTO {
    public static void main(String[] args) {
        int numero = 18;
                int i = 1;
                do {
                    if (numero % i == 0) {
                        System.out.println(i);
                    }
                    i++;
                } while (i <= numero);
    }
}
