package ev1.ut2_controlflujometodos.u01operadoresybasicos.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> Intercambia {@code a = 6} y {@code b = 11} sin variable auxiliar,
 * primero con suma y resta y después, para volver al original, con {@code ^}.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> {@code a = a + b; b = a - b; a = a - b} deja 11 y 6.
 * Tres {@code ^=} seguidos devuelven 6 y 11.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 26/10/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class E25_IntercambioSinAuxiliar_Resuelto {
    public static void main(String[] args) {
        int a = 6;
        int b = 11;
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println(a + " " + b);
        a ^= b;
        b ^= a;
        a ^= b;
        System.out.println(a + " " + b);
    }
}
