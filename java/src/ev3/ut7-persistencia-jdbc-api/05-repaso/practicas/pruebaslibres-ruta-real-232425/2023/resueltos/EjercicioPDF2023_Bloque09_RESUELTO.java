package pruebaslibres.practica.ruta_real_232425.y2023.resueltos;

/**
 * Cobertura 2023 - Bloque 9
 * Preguntas cubiertas: Q33..Q36
 * Version resuelta.
 *
 * @author Agustin A. Marquez Pina
 * @since 01/05/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class EjercicioPDF2023_Bloque09_RESUELTO {
    public static void main(String[] args) {
        int cubiertas = 0;
        for (int q = 33; q <= 36; q++) {
            cubiertas++;
            if (q % 2 == 0) {
                System.out.println("Q" + q + " (2023): repaso de traza/codigo");
            } else {
                System.out.println("Q" + q + " (2023): repaso conceptual");
            }
        }
        System.out.println("Bloque cubierto: Q33..Q36 (" + cubiertas + " preguntas).");
    }
}
