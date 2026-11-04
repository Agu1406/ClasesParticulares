package ev1.ut2_controlflujometodos.u03bucles.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> Usa un do-while para mostrar una cuenta atras del 10 al 1, uno por linea.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> i empieza en 10. Se imprime, se resta 1 y se repite mientras i sea mayor o igual que 1.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */

public class E23_CuentaAtras_Resuelto {
    public static void main(String[] args) {
        int i = 10;
        do {
            System.out.println(i);
            i--;
        } while (i >= 1);
    }
}
