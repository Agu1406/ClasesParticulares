package general.bucles;

/**
 * Ejercicio 6 (while): Potencias de 2 hasta 1024
 * Versión resuelta.
 *
 * @author Agustín. A. Marquez. Piña
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio6_WHILE_RESUELTO {
    public static void main(String[] args) {
        int valor = 1;
                while (valor <= 1024) {
                    System.out.println(valor);
                    valor *= 2;
                }
    }
}
