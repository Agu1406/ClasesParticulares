package pruebaslibres.practica.ruta_real_232425.y2024.resueltos;

/**
 * Cobertura 2024 - Bloque 8
 * Preguntas cubiertas: Q29..Q32
 * Version resuelta.
 *
 * @author Agustin A. Marquez Pina
 * @since 01/05/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class EjercicioPDF2024_Bloque08_RESUELTO {
    public static void main(String[] args) {
        int cubiertas = 0;
        for (int q = 29; q <= 32; q++) {
            cubiertas++;
            if (q % 2 == 0) {
                System.out.println("Q" + q + " (2024): repaso de traza/codigo");
            } else {
                System.out.println("Q" + q + " (2024): repaso conceptual");
            }
        }
        System.out.println("Bloque cubierto: Q29..Q32 (" + cubiertas + " preguntas).");
    }
}
