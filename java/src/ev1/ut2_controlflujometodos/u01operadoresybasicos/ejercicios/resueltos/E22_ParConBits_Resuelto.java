package ev1.ut2_controlflujometodos.u01operadoresybasicos.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> Di si el entero 27 es par o impar usando {@code &},
 * sin usar {@code %}.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> {@code n & 1} mira el último bit. Si vale 1, el número es impar.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 26/10/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class E22_ParConBits_Resuelto {
    public static void main(String[] args) {
        int n = 27;
        String paridad = (n & 1) == 1 ? "impar" : "par";
        System.out.println(n + " es " + paridad);
    }
}
