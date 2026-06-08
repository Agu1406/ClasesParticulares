package ev1.ut2_controlflujometodos.u05repaso.teoria;

import java.util.Scanner;

/**
 * Teoria: menus interactivos con {@code do-while}, {@code switch} y {@code Scanner teclado}.
 *
 * <p><b>Objetivo:</b> construir un menu que se repite hasta que el usuario elige salir.</p>
 *
 * <p>Patron tipico de examen y practica:</p>
 * <ol>
 *   <li>Declarar {@code Scanner teclado} y variables al inicio del {@code main}.</li>
 *   <li>{@code do-while} con condicion {@code opcion != 0} (o similar).</li>
 *   <li>Mostrar opciones, leer {@code opcion}, {@code switch} para cada caso.</li>
 *   <li>Caso 0: mensaje de salida y fin del bucle.</li>
 * </ol>
 *
 * <p>Relacionado con {@link U04_DoWhileConCondicionalesIntro} y ejercicios 10, 22, 25, 26, 28.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 08/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class U07_MenusConTecladoIntro {

    public static void main(String[] args) {
        Scanner teclado;
        int opcion;
        teclado = new Scanner(System.in);
        do {
            System.out.println();
            System.out.println("1. Ver saludo");
            System.out.println("2. Ver fecha ficticia");
            System.out.println("0. Salir");
            System.out.print("Opcion: ");
            opcion = teclado.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Hola desde el menu de repaso");
                    break;
                case 2:
                    System.out.println("Hoy practicas bucles + condicionales");
                    break;
                case 0:
                    System.out.println("Hasta luego");
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        } while (opcion != 0);
        teclado.close();
    }
}
