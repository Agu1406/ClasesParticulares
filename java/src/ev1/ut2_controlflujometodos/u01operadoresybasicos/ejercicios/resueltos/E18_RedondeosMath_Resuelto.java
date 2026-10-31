package ev1.ut2_controlflujometodos.u01operadoresybasicos.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> Para el número 7.5678 muestra {@code Math.floor},
 * {@code Math.ceil}, {@code Math.round}, el casteo a {@code int} y el valor
 * redondeado a dos decimales.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> Dos decimales: {@code Math.round(x * 100) / 100.0}.
 * Salen 7, 8, 8, 7 y 7.57.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 26/10/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class E18_RedondeosMath_Resuelto {
    public static void main(String[] args) {
        double x = 7.5678;
        System.out.println(Math.floor(x));
        System.out.println(Math.ceil(x));
        System.out.println(Math.round(x));
        System.out.println((int) x);
        System.out.println(Math.round(x * 100) / 100.0);
    }
}
