package general.bucles;

/**
 * Ejercicio 10 (for): Dibujar triángulo de asteriscos (5 filas)
 * Versión resuelta.
 *
 * @author Agustín. A. Marquez. Piña
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio10_FOR_RESUELTO {
    public static void main(String[] args) {
        for (int fila = 1; fila <= 5; fila++) {
                    for (int col = 1; col <= fila; col++) {
                        System.out.print("*");
                    }
                    System.out.println();
                }
    }
}
