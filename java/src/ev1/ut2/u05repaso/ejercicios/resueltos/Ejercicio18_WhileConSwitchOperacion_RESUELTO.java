package ev1.ut2.u05repaso.ejercicios.resueltos;

/**
 * Ejercicio: while con switch
 * Objetivo: Aplica operacion aritmetica por codigo con switch.
 * Version resuelta.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/05/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio18_WhileConSwitchOperacion_RESUELTO {
    public static void main(String[] args) {
        int a = 10, b = 3;
        int codigo = 1;
        while (codigo <= 4) {
            switch (codigo) {
                case 1 -> System.out.println(a + " + " + b + " = " + (a + b));
                case 2 -> System.out.println(a + " - " + b + " = " + (a - b));
                case 3 -> System.out.println(a + " * " + b + " = " + (a * b));
                case 4 -> System.out.println(a + " / " + b + " = " + (a / b));
                default -> System.out.println("Operacion invalida");
            }
            codigo++;
        }
    }
}
