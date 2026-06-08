package ev1.ut2_controlflujometodos.u05repaso.teoria;

/**
 * Teoria: bucle {@code do-while} combinado con condicionales.
 *
 * <p><b>Objetivo:</b> ejecutar al menos una vez y decidir dentro del cuerpo con if o switch.</p>
 *
 * <p>El {@code do-while} encaja bien en:</p>
 * <ul>
 *   <li><b>Menus</b> - mostrar opciones y repetir hasta elegir salir.</li>
 *   <li><b>Validacion de entrada</b> - pedir un dato al menos una vez y repetir si no es valido.</li>
 *   <li><b>Recuentos descendentes</b> - procesar y luego comprobar si quedan vueltas.</li>
 * </ul>
 *
 * <pre>{@code
 * do {
 *     // cuerpo: if, switch, lectura...
 * } while (condicion);
 * }</pre>
 *
 * <p>Ejercicios de referencia: 4, 7, 10, 13, 16, 19, 22, 25, 28 en {@code ejercicios/}.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 08/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class U04_DoWhileConCondicionalesIntro {

    public static void main(String[] args) {
        int numero;
        System.out.println("--- do-while + if: cuenta atras 10..1, solo > 5 ---");
        numero = 10;
        do {
            if (numero > 5) {
                System.out.println(numero);
            }
            numero--;
        } while (numero >= 1);
        System.out.println("--- do-while + switch: simular menu 1..3 ---");
        numero = 1;
        do {
            switch (numero) {
                case 1:
                    System.out.println("Alta");
                    break;
                case 2:
                    System.out.println("Consulta");
                    break;
                case 3:
                    System.out.println("Salir");
                    break;
                default:
                    System.out.println("Opcion invalida");
            }
            numero++;
        } while (numero <= 3);
    }
}
