package ev1.ut2_controlflujometodos.u05repaso.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> Cuenta del 1 al 20 y muestra PAR/IMPAR con if-else.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> El main cuenta del 1 al 20 y muestra PAR/IMPAR con if-else.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/05/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */

public class E02_WhileConIfElse_Resuelto {
    public static void main(String[] args) {
        int numero = 1;
        while (numero <= 20) {
            if (numero % 2 == 0) {
                System.out.println(numero + " PAR");
            } else {
                System.out.println(numero + " IMPAR");
            }
            numero++;
        }
    }
}
