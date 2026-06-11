package ev2.ut4_colecciones.u01arrays.teoria;

import java.util.Scanner;

/**
 * Menu interactivo para crear y gestionar un array con bucles.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class U02_ArraysBucles {

    static void main() {
        Scanner teclado = new Scanner(System.in);
        int opcion, tamano;
        int[] arrayNumeros;

        do {
            imprimirMenu();

            System.out.println("¡Dime la opción del menú!");
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("¡Dime el tamaño del array!");
                    tamano = teclado.nextInt();

                    arrayNumeros = new int[tamano];
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    System.out.println("¡Gracias por usar el programa! Hasta luego.");
                    break;
                default:
                    System.out.println("¡Error! Introduce una opción valida.");
                    break;
            }

        } while (opcion != 4);
    }

    static void imprimirMenu() {
        System.out.println("" +
                "¡MENÚ DE OPCIONES! \n" +
                "[1] - Crear un nuevo array. \n" +
                "[2] - Llenar el array con números. \n" +
                "[3] - Imprimir todos los valores del array. \n" +
                "[4] - Salir del programa.");
    }
}
