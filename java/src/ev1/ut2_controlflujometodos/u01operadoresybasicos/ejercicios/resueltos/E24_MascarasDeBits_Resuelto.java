package ev1.ut2_controlflujometodos.u01operadoresybasicos.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> Partiendo de {@code v = 10}, enciende el bit 0, apaga el bit 1
 * e invierte el bit 3. Muestra el valor decimal tras cada paso.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> Encender con {@code |=}, apagar con {@code &= ~} e invertir con {@code ^=},
 * siempre sobre {@code 1 << n}. La serie es 10, 11, 9 y 1.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 26/10/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class E24_MascarasDeBits_Resuelto {
    public static void main(String[] args) {
        int v = 10;
        System.out.println(v);
        v |= (1 << 0);
        System.out.println(v);
        v &= ~(1 << 1);
        System.out.println(v);
        v ^= (1 << 3);
        System.out.println(v);
    }
}
