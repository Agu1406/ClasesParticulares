package ev1.ut2_controlflujometodos.u02condicionales.ejercicios.resueltos;

/**
 * Ejercicio 3 (switch): Calculadora simple (+, -, *, /)
 * Version resuelta.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio3_SWITCH_RESUELTO {
    public static void main(String[] args) {
        int a = 12;
                int b = 4;
                char op = '*';
                switch (op) {
                    case '+': System.out.println(a + b); break;
                    case '-': System.out.println(a - b); break;
                    case '*': System.out.println(a * b); break;
                    case '/': System.out.println((double) a / b); break;
                    default: System.out.println("Operador invalido");
                }
    }
}
