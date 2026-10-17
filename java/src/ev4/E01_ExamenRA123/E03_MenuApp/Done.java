package ev4.E01_ExamenRA123.E03_MenuApp;

import java.util.Scanner;

/**
 * <p>Enunciado: {@code enunciado.md} .</p>
 *
 * <p><b>OBJETIVO:</b> RA1 + RA3 + RA5 — menu do-while con switch y bucles.</p>
 * <p><b>SOLUCION:</b> cada opcion usa for segun el caso; opcion 0 sale.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 17/10/2026
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
            System.out.println("¡Menú del programa!");
            System.out.println("[1] - Sumar N enteros");
            System.out.println("[2] - Tabla de multiplicar");
            System.out.println("[3] - Par o impar (varios)");
            System.out.println("[0] - Salir");
            System.out.print("Introduce una opción => ");
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("¿Cuántos enteros vas a sumar? => ");
                    int n = teclado.nextInt();
                    if (n > 0) {
                        int suma = 0;
                        for (int i = 1; i <= n; i++) {
                            System.out.print("Entero " + i + " => ");
                            suma = suma + teclado.nextInt();
                        }
                        System.out.println("Suma = " + suma);
                    } else {
                        System.out.println("N debe ser mayor que 0.");
                    }
                    break;
                case 2:
                    System.out.print("Tabla del => ");
                    int t = teclado.nextInt();
                    for (int i = 1; i <= 10; i++) {
                        System.out.println(t + " x " + i + " = " + (t * i));
                    }
                    break;
                case 3:
                    System.out.print("¿Cuántos números? => ");
                    int k = teclado.nextInt();
                    if (k > 0) {
                        for (int i = 1; i <= k; i++) {
                            System.out.print("Número " + i + " => ");
                            int num = teclado.nextInt();
                            if (num % 2 == 0) {
                                System.out.println(num + " es par.");
                            } else {
                                System.out.println(num + " es impar.");
                            }
                        }
                    } else {
                        System.out.println("La cantidad debe ser mayor que 0.");
                    }
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opcion != 0);
    }
}
