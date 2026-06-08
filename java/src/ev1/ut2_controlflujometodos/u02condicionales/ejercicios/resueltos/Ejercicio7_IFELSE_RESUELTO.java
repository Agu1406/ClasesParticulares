package ev1.ut2_controlflujometodos.u02condicionales.ejercicios.resueltos;

/**
 * Ejercicio 7 (ifelse): Comprobar si un ano es bisiesto simple
 * Version resuelta.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio7_IFELSE_RESUELTO {
    public static void main(String[] args) {
        int anio = 2023;
                if (anio % 4 == 0) {
                    System.out.println("Bisiesto");
                } else {
                    System.out.println("No bisiesto");
                }
    }
}
