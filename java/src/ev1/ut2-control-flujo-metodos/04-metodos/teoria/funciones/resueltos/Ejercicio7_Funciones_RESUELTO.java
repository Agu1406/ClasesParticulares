package general.funciones;

/**
 * Ejercicio 7: Función con if-else
 * Versión resuelta.
 *
 * @author Agustín. A. Marquez. Piña
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://agu1406.github.io/ClasesParticulares">GitHub Pages</a>
 */
public class Ejercicio7_Funciones_RESUELTO {

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
