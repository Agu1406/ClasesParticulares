package ev1.ut2_controlflujometodos.u02condicionales.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> Con la contrasena abc12345, usa un if para mostrar Longitud valida si tiene 8 caracteres o mas.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> {@code pass.length() >= 8} escribe Longitud valida.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class E10_ContrasenaLarga_Resuelto {
    public static void main(String[] args) {
        String pass = "abc12345";
        if (pass.length() >= 8) {
            System.out.println("Longitud valida");
        }
    }
}
