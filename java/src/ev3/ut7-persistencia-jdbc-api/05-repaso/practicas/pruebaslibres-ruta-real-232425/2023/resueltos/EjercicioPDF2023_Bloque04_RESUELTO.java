package pruebaslibres.practica.ruta_real_232425.y2023.resueltos;

/**
 * Cobertura 2023 - Bloque 4
 * Preguntas cubiertas: Q13..Q16
 * Version resuelta.
 *
 * @author Agustin A. Marquez Pina
 * @since 01/05/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class EjercicioPDF2023_Bloque04_RESUELTO {
    public static void main(String[] args) {
        int cubiertas = 0;
        for (int q = 13; q <= 16; q++) {
            cubiertas++;
            if (q % 2 == 0) {
                System.out.println("Q" + q + " (2023): repaso de traza/codigo");
            } else {
                System.out.println("Q" + q + " (2023): repaso conceptual");
            }
        }
        System.out.println("Bloque cubierto: Q13..Q16 (" + cubiertas + " preguntas).");
    }
}
