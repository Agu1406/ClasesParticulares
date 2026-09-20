package ev1.ut3_stringsyenvolventes.teoria;

import java.util.Scanner;

/**
 * Teoria 3.2: metodos principales de {@link String}.
 *
 * <p><b>Objetivo:</b> usar {@code length}, {@code charAt}, {@code substring},
 * {@code equals} / {@code equalsIgnoreCase}, {@code compareTo} / {@code compareToIgnoreCase}
 * e {@code indexOf} (resultado de compareTo: negativo, cero o positivo segun el orden
 * lexicografico).</p>
 *
 * <p>Bloque anterior: {@link U01_StringInmutabilidad}. Siguiente: {@link U03_StringBuilderIntro}.
 * Practica: ejercicios 2–5, 3 (equals) y {@code E14_CompareTo} en {@code ejercicios/}.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 08/08/2026
 * @see U01_StringInmutabilidad
 * @see U03_StringBuilderIntro
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class U02_MetodosString {

    public static void main(String[] args) {
        /*
         * Posiciones => [0][1][2][3][4][5][6][7][8][9][10][11]
         * Valores    => [D][a][n][i][e][l][ ][M][a][s][s][o]
         * length     => 12
         */
        String nombreCompleto = "Daniel Masso";

        System.out.println("length: " + nombreCompleto.length());
        System.out.println("charAt(0) nombre: " + nombreCompleto.charAt(0));
        System.out.println("charAt(7) apellido: " + nombreCompleto.charAt(7));

        // substring(inicio, fin): fin exclusivo
        String nombre = nombreCompleto.substring(0, 6);
        String apellido = nombreCompleto.substring(7);
        System.out.println("substring nombre: " + nombre);
        System.out.println("substring apellido: " + apellido);

        String texto = "Programacion";
        System.out.println("Programacion substring(0, 7): " + texto.substring(0, 7));
        System.out.println("Programacion substring(7):    " + texto.substring(7));

        String a = "Java";
        String b = "java";
        System.out.println("equals: " + a.equals(b));
        System.out.println("equalsIgnoreCase: " + a.equalsIgnoreCase(b));

        // compareTo: <0 si this va antes, 0 si iguales, >0 si this va despues
        String x = "casa";
        String y = "caso";
        int orden = x.compareTo(y);
        System.out.println("compareTo(\"casa\", \"caso\"): " + orden);
        if (orden < 0) {
            System.out.println("\"casa\" va antes que \"caso\"");
        } else if (orden > 0) {
            System.out.println("\"casa\" va despues que \"caso\"");
        } else {
            System.out.println("Son iguales en orden");
        }

        System.out.println("compareToIgnoreCase(\"Java\", \"java\"): "
                + a.compareToIgnoreCase(b));

        // indexOf + Scanner: partir nombre y apellido por el primer espacio
        Scanner teclado = new Scanner(System.in);
        System.out.print("Introduce tu nombre completo --> ");
        String leido = teclado.nextLine();
        int posicion = leido.indexOf(' ');
        if (posicion >= 0) {
            System.out.println("Nombre: " + leido.substring(0, posicion));
            System.out.println("Apellido: " + leido.substring(posicion + 1));
        } else {
            System.out.println("Sin espacio; cadena completa: " + leido);
        }
        teclado.close();
    }
}
