package ev1.ut2_controlflujometodos.u03bucles.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> Usa un do-while para mostrar los numeros pares del 2 al 20, uno por linea.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> i empieza en 2, se imprime y suma 2. El bucle sigue mientras i sea menor o igual que 20.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */

public class E22_Pares2A20_Resuelto {
    public static void main(String[] args) {
        int i = 2;
        do {
            System.out.println(i);
            i += 2;
        } while (i <= 20);
    }
}
