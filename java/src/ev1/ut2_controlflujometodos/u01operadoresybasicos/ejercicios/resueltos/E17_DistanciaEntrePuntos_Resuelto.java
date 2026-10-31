package ev1.ut2_controlflujometodos.u01operadoresybasicos.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> Calcula la distancia entre los puntos (1, 2) y (4, 6)
 * y muéstrala con dos decimales.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> {@code Math.sqrt} de la suma de los cuadrados de las diferencias.
 * La distancia es 5.00.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 26/10/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class E17_DistanciaEntrePuntos_Resuelto {
    public static void main(String[] args) {
        double x1 = 1;
        double y1 = 2;
        double x2 = 4;
        double y2 = 6;
        double distancia = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        System.out.printf("Distancia: %.2f%n", distancia);
    }
}
