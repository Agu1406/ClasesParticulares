package ev1.ut2_controlflujometodos.u03bucles.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> Usa un do-while para calcular el factorial de 5 y muestra Factorial: con el resultado.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> Se multiplica el acumulador por i desde 1 hasta 5. El resultado es 120.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */

public class E28_FactorialDe5_Resuelto {
    public static void main(String[] args) {
        int i = 1;
        int factorial = 1;
        do {
            factorial *= i;
            i++;
        } while (i <= 5);
        System.out.println("Factorial: " + factorial);
    }
}
