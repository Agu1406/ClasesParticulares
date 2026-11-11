package ev4.E02_ExamenRA2.E03_EntrenamientoNumerico;

import java.util.Scanner;

/**
 * Menú: contar pares en rango, factorial en long y media de positivos (centinela 0).
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
            System.out.println("[1] - Contar pares en un rango");
            System.out.println("[2] - Factorial de un natural");
            System.out.println("[3] - Media de positivos (centinela 0)");
            System.out.println("[0] - Salir");
            System.out.print("Introduce una opción => ");
            opcion = teclado.nextInt();

            if (opcion == 1) {
                System.out.print("Inicio => ");
                int inicio = teclado.nextInt();
                System.out.print("Fin => ");
                int fin = teclado.nextInt();

                if (inicio > fin) {
                    int aux = inicio;
                    inicio = fin;
                    fin = aux;
                }

                int pares = 0;
                for (int i = inicio; i <= fin; i++) {
                    if (i % 2 == 0) {
                        pares = pares + 1;
                    }
                }
                System.out.println("Pares en [" + inicio + ", " + fin + "]: " + pares);

            } else if (opcion == 2) {
                System.out.print("n => ");
                int n = teclado.nextInt();

                if (n < 0) {
                    System.out.println("Error: n debe ser >= 0.");
                } else {
                    long resultado = 1;
                    for (int i = 2; i <= n; i++) {
                        resultado = resultado * i;
                    }
                    System.out.println(n + "! = " + resultado);
                }

            } else if (opcion == 3) {
                double suma = 0;
                int cantidad = 0;
                double valor;

                System.out.println("Introduce positivos. 0 para terminar.");
                System.out.print("Número => ");
                valor = teclado.nextDouble();

                while (valor != 0) {
                    if (valor < 0) {
                        System.out.println("Se ignoran los negativos.");
                    } else {
                        suma = suma + valor;
                        cantidad = cantidad + 1;
                    }
                    System.out.print("Número => ");
                    valor = teclado.nextDouble();
                }

                if (cantidad == 0) {
                    System.out.println("No hubo números positivos.");
                } else {
                    double media = suma / cantidad;
                    System.out.println("Media: " + media);
                }

            } else if (opcion == 0) {
                System.out.println("Saliendo...");

            } else {
                System.out.println("Opción no válida.");
            }

        } while (opcion != 0);
    }
}
