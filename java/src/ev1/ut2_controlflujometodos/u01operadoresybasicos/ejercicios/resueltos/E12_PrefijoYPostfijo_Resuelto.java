package ev1.ut2_controlflujometodos.u01operadoresybasicos.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> Con {@code x = 10} ejecuta y muestra {@code x} e {@code y}
 * después de cada sentencia: {@code y = x++}, {@code y = ++x}, {@code y = x--}
 * y {@code y = --x}.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> El postfijo entrega el valor antiguo y el prefijo el nuevo.
 * La secuencia deja los pares (11, 10), (12, 12), (11, 12) y (10, 10).</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 26/10/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class E12_PrefijoYPostfijo_Resuelto {
    public static void main(String[] args) {
        int x = 10;
        int y = x++;
        System.out.println("x=" + x + " y=" + y);
        y = ++x;
        System.out.println("x=" + x + " y=" + y);
        y = x--;
        System.out.println("x=" + x + " y=" + y);
        y = --x;
        System.out.println("x=" + x + " y=" + y);
    }
}
