package ev1.ut2_controlflujometodos.u05repaso.teoria;

/**
 * Teoria: bucle {@code while} combinado con condicionales.
 *
 * <p><b>Objetivo:</b> repetir mientras se cumpla una condicion y decidir en cada paso con if o switch.</p>
 *
 * <p>El {@code while} es util cuando el numero de vueltas no esta fijado en un rango simple
 * (por ejemplo, leer hasta agotar datos o procesar hasta que un contador llegue a un tope).</p>
 *
 * <ul>
 *   <li><b>while + if-else</b> - clasificar valores mientras avanzas un contador.</li>
 *   <li><b>while + if</b> - mostrar solo los que cumplen una propiedad.</li>
 *   <li><b>while + switch</b> - elegir accion segun codigo mientras el bucle sigue activo.</li>
 * </ul>
 *
 * <p><b>Recuerda:</b> actualizar la variable de control dentro del {@code while}
 * ({@code contador++}, {@code numero /= 10}) para evitar bucles infinitos.</p>
 *
 * <p>Ejercicios de referencia: 2, 6, 9, 12, 15, 18, 21, 24, 27, 30 en {@code ejercicios/}.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 08/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class U03_WhileConCondicionalesIntro {

    public static void main(String[] args) {
        int contador;
        System.out.println("--- while + if-else: PAR/IMPAR 1..8 ---");
        contador = 1;
        while (contador <= 8) {
            if (contador % 2 == 0) {
                System.out.println(contador + " PAR");
            } else {
                System.out.println(contador + " IMPAR");
            }
            contador++;
        }
        System.out.println("--- while + switch: operaciones 1..3 ---");
        contador = 1;
        while (contador <= 3) {
            switch (contador) {
                case 1:
                    System.out.println("Sumar");
                    break;
                case 2:
                    System.out.println("Restar");
                    break;
                case 3:
                    System.out.println("Salir");
                    break;
                default:
                    System.out.println("Desconocido");
            }
            contador++;
        }
    }
}
