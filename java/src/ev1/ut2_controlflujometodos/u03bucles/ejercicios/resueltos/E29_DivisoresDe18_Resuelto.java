package ev1.ut2_controlflujometodos.u03bucles.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> Usa un do-while para mostrar los divisores de 18, uno por linea.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> i va de 1 a 18. Si 18 % i es 0, i es divisor.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */

public class E29_DivisoresDe18_Resuelto {
    public static void main(String[] args) {
        int numero = 18;
        int i = 1;
        do {
            if (numero % i == 0) {
                System.out.println(i);
            }
            i++;
        } while (i <= numero);
    }
}
