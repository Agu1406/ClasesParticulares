package ev1.ut2_controlflujometodos.u01operadoresybasicos.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> Muestra 2 elevado a 0, 3, 8 y 16 con {@code 1 << n}.
 * Después muestra 40 multiplicado por 8 y dividido entre 4 usando solo desplazamientos.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> {@code << n} multiplica por 2<sup>n</sup> y {@code >> n} divide.
 * Salen 1, 8, 256, 65536, 320 y 10.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 26/10/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class E23_PotenciasDeDos_Resuelto {
    public static void main(String[] args) {
        System.out.println(1 << 0);
        System.out.println(1 << 3);
        System.out.println(1 << 8);
        System.out.println(1 << 16);
        System.out.println(40 << 3);
        System.out.println(40 >> 2);
    }
}
