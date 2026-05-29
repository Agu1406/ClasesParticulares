package madrid.iescanaveral.ejercicios.convocatoria2022;

/**
 * Ejercicio 12: ¿Cuál es la salida del siguiente programa?
 * 
 * Analiza la diferencia entre pre-incremento (++i) y post-incremento (i++).
 * 
 * @author Agustín. A. Marquez. Piña
 * @since 14/01/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio12_OperadoresIncremento {
    public static void main(String[] args) {
        int i, j;
        i = j = 3;
        int n = 2 * ++i;
        int m = 2 * j++;
        System.out.println(i + " " + j + " " + n + " " + m);
    }
}
