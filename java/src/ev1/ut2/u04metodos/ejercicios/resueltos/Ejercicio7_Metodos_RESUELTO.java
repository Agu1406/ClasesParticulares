package ev1.ut2.u04metodos.ejercicios.resueltos;

/**
 * Ejercicio 7: Funcion con if-else
 * Version resuelta.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio7_Metodos_RESUELTO {

    public static String calificarNota(double nota) {
            if (nota >= 5) {
                return "Aprobado";
            } else {
                return "Suspenso";
            }
        }

    public static void main(String[] args) {
        System.out.println(calificarNota(6.5));
    }
}
