package ev1.ut2_controlflujometodos.u01operadoresybasicos.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> Muestra el valor de estas expresiones:
 * {@code 8 + 4 * 3}, {@code (8 + 4) * 3}, {@code 20 / 3 * 3},
 * {@code 20 % 7 + 2 * 5} y {@code 2 + 3 > 4 && 10 / 2 == 5}.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> {@code *}, {@code /} y {@code %} van antes que {@code +} y {@code -}.
 * {@code 20 / 3} es 6, así que {@code 20 / 3 * 3} vale 18. La última expresión es {@code true}.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 26/10/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class E15_Precedencia_Resuelto {
    public static void main(String[] args) {
        System.out.println(8 + 4 * 3);
        System.out.println((8 + 4) * 3);
        System.out.println(20 / 3 * 3);
        System.out.println(20 % 7 + 2 * 5);
        System.out.println(2 + 3 > 4 && 10 / 2 == 5);
    }
}
