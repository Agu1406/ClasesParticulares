package general.repaso;

/**
 * Ejercicio: while con if
 * Objetivo: Recorre un array y muestra solo valores positivos con if.
 * Version resuelta.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/05/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio9_WhileConIfPositivos_RESUELTO {
    public static void main(String[] args) {
        int[] valores = {3, -1, 0, 7, -4, 2};
        int i = 0;
        while (i < valores.length) {
            if (valores[i] > 0) {
                System.out.println(valores[i]);
            }
            i++;
        }
    }
}
