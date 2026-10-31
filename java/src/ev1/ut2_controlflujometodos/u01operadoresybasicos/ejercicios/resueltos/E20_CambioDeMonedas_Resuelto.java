package ev1.ut2_controlflujometodos.u01operadoresybasicos.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> Desglosa 188 euros en billetes de 50, 20, 10 y 5
 * y monedas de 2 y 1, usando {@code /} y {@code %}.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> Se toma el máximo de cada denominación y {@code %} deja el resto
 * para la siguiente. Sale 3, 1, 1, 1, 1 y 1.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 26/10/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class E20_CambioDeMonedas_Resuelto {
    public static void main(String[] args) {
        int euros = 188;
        System.out.println(euros / 50);
        euros %= 50;
        System.out.println(euros / 20);
        euros %= 20;
        System.out.println(euros / 10);
        euros %= 10;
        System.out.println(euros / 5);
        euros %= 5;
        System.out.println(euros / 2);
        euros %= 2;
        System.out.println(euros);
    }
}
