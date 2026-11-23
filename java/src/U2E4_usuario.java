import java.util.Scanner;

/**
 * U2. Exame práctico. E4: a acta dun partido.
 *
 * @author usuario
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

        // Escribe aquí a lectura dos datos

        scanner.close();

        // Escribe aquí a acta
    }
}
