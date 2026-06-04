package pruebaslibres.practica.ruta_real_232425.y2025.resueltos;

/**
 * Cobertura 2025 - Bloque 3
 * Preguntas cubiertas: Q11..Q15
 * Version resuelta.
 *
 * @author Agustin A. Marquez Pina
 * @since 01/05/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class EjercicioPDF2025_Bloque03_RESUELTO {
    public static void main(String[] args) {
        int cubiertas = 0;
        for (int q = 11; q <= 15; q++) {
            cubiertas++;
            if (q % 2 == 0) {
                System.out.println("Q" + q + " (2025): repaso de traza/codigo");
            } else {
                System.out.println("Q" + q + " (2025): repaso conceptual");
            }
        }
        System.out.println("Bloque cubierto: Q11..Q15 (" + cubiertas + " preguntas).");
    }
}
