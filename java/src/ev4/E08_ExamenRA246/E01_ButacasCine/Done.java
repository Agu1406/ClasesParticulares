package ev4.E08_ExamenRA246.E01_ButacasCine;

import java.util.Scanner;

/**
 * <p>Enunciado: {@code enunciado.md}.</p>
 *
 * <p><b>OBJETIVO:</b> RA6.1 — sala {@code boolean[4][6]}, reservas hasta {@code 0 0},
 * mensajes de error y plano final con libres.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> indices desde 1; fuera de rango o ocupada imprime mensaje;
 * al final recorre la matriz para el plano y el contador de libres.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 08/11/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Done {

    public static void main(String[] args) {
        /* --- Variables al principio del metodo --- */
        Scanner teclado;
        boolean[][] sala;
        boolean continuar;
        int fila, butaca, libres, filaPlano, columna;

        teclado = new Scanner(System.in);

        /*
         * false = libre, true = ocupada.
         * En Java los boolean de un array nuevo empiezan en false.
         */
        sala = new boolean[4][6];
        libres = 0;
        continuar = true;

        /*
         * do-while controlado con continuar.
         * Si el usuario elige 0 0 → continuar = false y no se reserva.
         * El enunciado numera desde 1; el array desde 0 → restamos 1.
         */
        do {
            System.out.print("Introduce una fila => ");
            fila = teclado.nextInt();
            System.out.println();

            System.out.print("Introduce una butaca => ");
            butaca = teclado.nextInt();
            System.out.println();

            if (fila == 0 && butaca == 0) {
                continuar = false;
            } else {
                continuar = true;

                // Si elige una posición invalida lo detecta de inmediato.
                if (fila < 1 || fila > 4 || butaca < 1 || butaca > 6) {
                    System.out.println("Butaca " + fila + "-" + butaca + " no existe");
                }
                // Si el valor de esas posiciones ya es true ya está reservado.
                else if (sala[fila - 1][butaca - 1]) {
                    System.out.println("Butaca " + fila + "-" + butaca + " ya ocupada");
                }
                // Si ninguno de los casos anteriores, disponible, se reserva.
                else {
                    sala[fila - 1][butaca - 1] = true;
                }
            }
        } while (continuar);

        // Plano: numero de fila + X (ocupada) o . (libre)
        for (filaPlano = 0; filaPlano < 4; filaPlano++) {
            System.out.print((filaPlano + 1) + " ");
            for (columna = 0; columna < 6; columna++) {
                if (sala[filaPlano][columna]) {
                    System.out.print("X");
                } else {
                    System.out.print(".");
                    libres = libres + 1;
                }
            }
            System.out.println();
        }

        System.out.println("Libres: " + libres);
        teclado.close();
    }
}
