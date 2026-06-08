package ev1.ut2_controlflujometodos.u05repaso.ejercicios.resueltos;

/**
 * Ejercicio: for con if-else
 * Objetivo: Recorre notas y muestra APTO/NO APTO con if-else.
 * Version resuelta.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/05/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio23_ForConIfElseNota_RESUELTO {
    public static void main(String[] args) {
        int[] notas = {4, 5, 7, 3, 9};
        for (int nota : notas) {
            if (nota >= 5) {
                System.out.println(nota + " APTO");
            } else {
                System.out.println(nota + " NO APTO");
            }
        }
    }
}
