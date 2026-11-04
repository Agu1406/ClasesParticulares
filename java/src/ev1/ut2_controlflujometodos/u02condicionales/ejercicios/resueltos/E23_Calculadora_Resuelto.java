package ev1.ut2_controlflujometodos.u02condicionales.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> Con a = 12, b = 4 y el operador *, usa switch para sumar, restar, multiplicar o dividir. Otro operador: Operador invalido.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> El case * escribe 48. La division usa {@code (double) a / b}.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class E23_Calculadora_Resuelto {
    public static void main(String[] args) {
        int a = 12;
        int b = 4;
        char op = '*';
        switch (op) {
            case '+':
                System.out.println(a + b);
                break;
            case '-':
                System.out.println(a - b);
                break;
            case '*':
                System.out.println(a * b);
                break;
            case '/':
                System.out.println((double) a / b);
                break;
            default:
                System.out.println("Operador invalido");
        }
    }
}
