package ev4.E06_ExamenRA123.E03_MenuEstadisticas;

import java.util.Scanner;

/**
 * Menu: maximo de N, contar vocales y tabla 1-12.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 24/10/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Done {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int opcion;

        do {
            System.out.println();
            System.out.println("[1] Maximo de N enteros");
            System.out.println("[2] Contar vocales de una palabra");
            System.out.println("[3] Tabla del n (1 al 12)");
            System.out.println("[0] Salir");
            System.out.print("Opcion => ");
            opcion = teclado.nextInt();

            if (opcion == 1) {
                System.out.print("N => ");
                int n = teclado.nextInt();
                if (n <= 0) {
                    System.out.println("N debe ser mayor que 0.");
                } else {
                    System.out.print("Numero 1 => ");
                    int maximo = teclado.nextInt();
                    for (int i = 2; i <= n; i++) {
                        System.out.print("Numero " + i + " => ");
                        int valor = teclado.nextInt();
                        if (valor > maximo) {
                            maximo = valor;
                        }
                    }
                    System.out.println("Maximo: " + maximo);
                }
            } else if (opcion == 2) {
                System.out.print("Palabra => ");
                String palabra = teclado.next();
                int vocales = 0;
                for (int i = 0; i < palabra.length(); i++) {
                    char c = palabra.charAt(i);
                    if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
                            || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                        vocales = vocales + 1;
                    }
                }
                System.out.println("Vocales: " + vocales);
            } else if (opcion == 3) {
                System.out.print("n => ");
                int n = teclado.nextInt();
                for (int i = 1; i <= 12; i++) {
                    System.out.println(n + " x " + i + " = " + (n * i));
                }
            } else if (opcion == 0) {
                System.out.println("Hasta luego.");
            } else {
                System.out.println("Opcion no valida.");
            }
        } while (opcion != 0);
    }
}
