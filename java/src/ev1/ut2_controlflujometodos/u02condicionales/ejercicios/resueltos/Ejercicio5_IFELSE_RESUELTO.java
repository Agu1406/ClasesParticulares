package ev1.ut2_controlflujometodos.u02condicionales.ejercicios.resueltos;

/**
 * Ejercicio 5 (ifelse): Validar acceso por contrasena exacta
 * Version resuelta.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio5_IFELSE_RESUELTO {
    public static void main(String[] args) {
        String entrada = "java21";
                if (entrada.equals("java21")) {
                    System.out.println("Acceso permitido");
                } else {
                    System.out.println("Acceso denegado");
                }
    }
}
