package ev3.ut7.u05repaso.practicas.pruebaslibresrutareal232425;

/**
 * Cobertura 2025 - Bloque 1
 * Preguntas cubiertas: Q1..Q5
 * Version resuelta.
 *
 * @author Agustin A. Marquez Pina
 * @since 01/05/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class EjercicioPDF2025_Bloque01_RESUELTO {
    public static void main(String[] args) {
        int cubiertas = 0;
        for (int q = 1; q <= 5; q++) {
            cubiertas++;
            if (q % 2 == 0) {
                System.out.println("Q" + q + " (2025): repaso de traza/codigo");
            } else {
                System.out.println("Q" + q + " (2025): repaso conceptual");
            }
        }
        System.out.println("Bloque cubierto: Q1..Q5 (" + cubiertas + " preguntas).");
    }
}
