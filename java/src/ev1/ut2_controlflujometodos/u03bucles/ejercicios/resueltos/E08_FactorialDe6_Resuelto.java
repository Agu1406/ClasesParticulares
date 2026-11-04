package ev1.ut2_controlflujometodos.u03bucles.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> Usa un for para calcular el factorial de 6 y muestra Factorial: con el resultado.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> Se multiplica el acumulador por i desde 1 hasta 6. El resultado es 720.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */

public class E08_FactorialDe6_Resuelto {
    public static void main(String[] args) {
        int factorial = 1;
        for (int i = 1; i <= 6; i++) {
            factorial *= i;
        }
        System.out.println("Factorial: " + factorial);
    }
}
