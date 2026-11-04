package ev1.ut2_controlflujometodos.u03bucles.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> Usa un for anidado para dibujar un triangulo de 5 filas de asteriscos: la fila n tiene n asteriscos.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> El for exterior marca la fila y el interior imprime tantos * como el numero de fila.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */

public class E10_TrianguloAsteriscos_Resuelto {
    public static void main(String[] args) {
        for (int fila = 1; fila <= 5; fila++) {
            for (int col = 1; col <= fila; col++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
