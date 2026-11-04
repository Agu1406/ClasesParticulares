package ev1.ut2_controlflujometodos.u03bucles.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> Usa un while para mostrar los divisores de 30, uno por linea.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> i va de 1 a 30. Si 30 % i es 0, i es divisor.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */

public class E19_DivisoresDe30_Resuelto {
    public static void main(String[] args) {
        int numero = 30;
        int i = 1;
        while (i <= numero) {
            if (numero % i == 0) {
                System.out.println(i);
            }
            i++;
        }
    }
}
