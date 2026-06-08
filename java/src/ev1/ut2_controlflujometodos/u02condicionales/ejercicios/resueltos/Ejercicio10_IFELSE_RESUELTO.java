package ev1.ut2_controlflujometodos.u02condicionales.ejercicios.resueltos;

/**
 * Ejercicio 10 (ifelse): Comprobar si una letra es mayuscula
 * Version resuelta.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio10_IFELSE_RESUELTO {
    public static void main(String[] args) {
        char c = 'G';
                if (Character.isUpperCase(c)) {
                    System.out.println("Mayuscula");
                } else {
                    System.out.println("No mayuscula");
                }
    }
}
