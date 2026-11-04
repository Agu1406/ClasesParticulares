package ev1.ut2_controlflujometodos.u02condicionales.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> Con la vocal i, usa switch para mostrar su mayuscula. Si no es vocal: No es vocal.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> El case i escribe I.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class E26_VocalMayuscula_Resuelto {
    public static void main(String[] args) {
        char vocal = 'i';
        switch (vocal) {
            case 'a':
                System.out.println('A');
                break;
            case 'e':
                System.out.println('E');
                break;
            case 'i':
                System.out.println('I');
                break;
            case 'o':
                System.out.println('O');
                break;
            case 'u':
                System.out.println('U');
                break;
            default:
                System.out.println("No es vocal");
        }
    }
}
