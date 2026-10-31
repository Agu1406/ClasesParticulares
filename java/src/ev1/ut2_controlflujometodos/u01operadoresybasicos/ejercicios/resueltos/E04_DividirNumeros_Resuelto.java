package ev1.ut2_controlflujometodos.u01operadoresybasicos.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> Crea dos enteros y muestra la división entera y la división real.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> {@code a / b} descarta los decimales. {@code a / (double) b}
 * conserva el cociente real. Con 17 y 5 sale 3 y 3.4.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class E04_DividirNumeros_Resuelto {
    public static void main(String[] args) {
        int a = 17;
        int b = 5;
        System.out.println(a / b);
        System.out.println(a / (double) b);
    }
}
