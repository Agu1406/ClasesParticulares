package ev1.ut2_controlflujometodos.u02condicionales.ejercicios.resueltos;

/**
 * Ejercicio 10 (if): Comprobar si una contrasena tiene minimo 8 caracteres
 * Version resuelta.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio10_IF_RESUELTO {
    public static void main(String[] args) {
        String pass = "abc12345";
                if (pass.length() >= 8) {
                    System.out.println("Longitud valida");
                }
    }
}
