package ev1.ut2.u03bucles.ejercicios.resueltos;

/**
 * Ejercicio 10 (for): Dibujar triangulo de asteriscos (5 filas)
 * Version resuelta.
 *
 * @author Agustin. A. Marquez. Pina
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
