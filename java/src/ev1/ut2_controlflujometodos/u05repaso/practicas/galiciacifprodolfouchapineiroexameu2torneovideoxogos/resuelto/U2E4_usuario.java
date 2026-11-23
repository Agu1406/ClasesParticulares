import java.util.Scanner;

/**
 * U2. Exame práctico. E4: a acta dun partido.
 *
 * <p><b>OBJETIVO:</b> completar el {@code main} de {@code U2E4_usuario.java}
 * usando {@code readInt} y {@code printf}.</p>
 *
 * <p><b>SOLUCION:</b> leer N y puntos; cabecera; filas {@code %7d%8d} y
 * {@code " *"} si puntos &gt; 20; total del equipo.</p>
 *
 * @author Agustin. A. Marquez. Pina
 */
class MatchSheet {

    /**
     * Le un enteiro dun intervalo e repite a pregunta ata obtelo.
     *
     * @param scanner lector do teclado
     * @param prompt  pregunta que se amosa antes de cada lectura
     * @param min     valor mínimo admitido
     * @param max     valor máximo admitido
     * @return o primeiro enteiro lido que está entre min e max
     */
    public static int readInt(Scanner scanner, String prompt,
                              int min, int max) {
        int value = 0;
        boolean valid;
        do {
            System.out.print(prompt);
            valid = scanner.hasNextInt();
            if (valid) {
                value = scanner.nextInt();
                valid = value >= min && value <= max;
            }
            scanner.nextLine();   // descarta o resto da liña
            if (!valid) {
                System.out.println("Escribe un enteiro de " + min
                        + " a " + max);
            }
        } while (!valid);
        return value;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int jugadores;
        int total;
        int posicion;
        int[] puntos;
        String marca;

        jugadores = readInt(scanner, "Xogadores: ", 1, 6);
        puntos = new int[jugadores];
        for (posicion = 0; posicion < jugadores; posicion++) {
            puntos[posicion] = readInt(scanner,
                    "Puntos " + (posicion + 1) + ": ", 0, 60);
        }
        scanner.close();

        System.out.println();
        System.out.println("Xogador  Puntos");
        total = 0;
        for (posicion = 0; posicion < jugadores; posicion++) {
            total = total + puntos[posicion];
            if (puntos[posicion] > 20) {
                marca = " *";
            } else {
                marca = "";
            }
            System.out.printf("%7d%8d%s%n", posicion + 1, puntos[posicion],
                    marca);
        }
        System.out.println("Total: " + total + " puntos");
    }
}
