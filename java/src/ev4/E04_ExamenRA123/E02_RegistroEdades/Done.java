package ev4.E04_ExamenRA123.E02_RegistroEdades;

import java.util.Scanner;

/**
 * Edades con centinela -1, validacion y categorias.
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

        int cantidad = 0;
        double suma = 0;
        int ninos = 0;
        int adolescentes = 0;
        int adultos = 0;
        int mayores = 0;

        System.out.println("Introduce edades [0-120]. -1 para terminar.");
        System.out.print("Edad => ");
        int edad = teclado.nextInt();

        while (edad != -1) {
            if (edad < 0 || edad > 120) {
                System.out.println("Edad no valida. Intentalo de nuevo.");
            } else {
                cantidad = cantidad + 1;
                suma = suma + edad;

                if (edad <= 12) {
                    ninos = ninos + 1;
                } else if (edad <= 17) {
                    adolescentes = adolescentes + 1;
                } else if (edad <= 64) {
                    adultos = adultos + 1;
                } else {
                    mayores = mayores + 1;
                }
            }

            System.out.print("Edad => ");
            edad = teclado.nextInt();
        }

        System.out.println();
        if (cantidad == 0) {
            System.out.println("No se introdujo ninguna edad valida.");
        } else {
            double media = suma / cantidad;
            System.out.println("Edades leidas: " + cantidad);
            System.out.println("Media: " + media);
            System.out.println("Ninos: " + ninos);
            System.out.println("Adolescentes: " + adolescentes);
            System.out.println("Adultos: " + adultos);
            System.out.println("Mayores: " + mayores);
        }
    }
}
