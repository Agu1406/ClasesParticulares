package ev1.ut2.u05repaso.ejercicios.resueltos;

/**
 * Ejercicio: for con switch
 * Objetivo: Convierte notas numericas a letra (A/B/C/D) con switch.
 * Version resuelta.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/05/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio11_ForConSwitchNotas_RESUELTO {
    public static void main(String[] args) {
        int[] notas = {9, 7, 6, 4, 8};
        for (int nota : notas) {
            switch (nota) {
                case 10:
                case 9:
                    System.out.println(nota + " -> A");
                    break;
                case 8:
                case 7:
                    System.out.println(nota + " -> B");
                    break;
                case 6:
                case 5:
                    System.out.println(nota + " -> C");
                    break;
                default:
                    System.out.println(nota + " -> D");
            }
        }
    }
}
