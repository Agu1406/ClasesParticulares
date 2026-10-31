package ev1.ut2_controlflujometodos.u01operadoresybasicos.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> Partiendo de {@code valor = 100}, aplica en este orden
 * {@code += 20}, {@code -= 30}, {@code *= 3}, {@code /= 4} y {@code %= 7},
 * y muestra el valor tras cada paso.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> Cada operador compuesto reescribe la variable.
 * La serie es 120, 90, 270, 67 y 4.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 26/10/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class E13_AsignacionCompuesta_Resuelto {
    public static void main(String[] args) {
        int valor = 100;
        System.out.println(valor);
        valor += 20;
        System.out.println(valor);
        valor -= 30;
        System.out.println(valor);
        valor *= 3;
        System.out.println(valor);
        valor /= 4;
        System.out.println(valor);
        valor %= 7;
        System.out.println(valor);
    }
}
