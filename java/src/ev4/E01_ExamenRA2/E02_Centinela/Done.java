package ev4.E01_ExamenRA2.E02_Centinela;

import java.util.Scanner;

/**
 * Notas con centinela -1, validacion de rango y categorias.
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

        int cantidad = 0;
        double suma = 0;
        int suspensos = 0;
        int aprobados = 0;
        int notables = 0;
        int sobresalientes = 0;

        System.out.println("Introduce notas [0-10]. -1 para terminar.");

        System.out.print("Nota => ");
        double nota = teclado.nextDouble();

        while (nota != -1) {
            if (nota < 0 || nota > 10) {
                System.out.println("Nota fuera de rango. Intentalo de nuevo.");
            } else {
                cantidad = cantidad + 1;
                suma = suma + nota;

                if (nota < 5) {
                    suspensos = suspensos + 1;
                } else if (nota < 7) {
                    aprobados = aprobados + 1;
                } else if (nota < 9) {
                    notables = notables + 1;
                } else {
                    sobresalientes = sobresalientes + 1;
                }
            }

            System.out.print("Nota => ");
            nota = teclado.nextDouble();
        }

        System.out.println();
        if (cantidad == 0) {
            System.out.println("No se introdujo ninguna nota valida.");
        } else {
            double media = suma / cantidad;
            System.out.println("Notas leidas: " + cantidad);
            System.out.println("Media: " + media);
            System.out.println("Suspensos: " + suspensos);
            System.out.println("Aprobados: " + aprobados);
            System.out.println("Notables: " + notables);
            System.out.println("Sobresalientes: " + sobresalientes);
        }
    }
}
