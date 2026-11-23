import java.util.Arrays;
import java.util.Scanner;

/**
 * U2T7. Temperaturas mínimas.
 *
 * @author usuario
 */
class MinTemperatures {

    /**
     * Conta os días de xeada.
     *
     * @param temps temperaturas mínimas, unha por día
     * @return o número de temperaturas por debaixo de 0
     */
    public static int frostDays(int[] temps) {
        int count = 0;
        for (int i = 1; i < temps.length; i++) {
            if (temps[i] < 0) {
                count++;
            }
        }
        return count;
    }

    /**
     * Busca o día máis frío.
     *
     * @param temps temperaturas mínimas, unha por día desde o día 1
     * @return o número do día coa temperatura máis baixa, o primeiro
     *         se hai varios, ou 0 se o array está baleiro
     */
    public static int coldestDay(int[] temps) {
        int min = temps[0];
        int day = 1;
        for (int i = 1; i < temps.length; i++) {
            if (temps[i] < min) {
                min = temps[i];
                day = i + 1;
            }
        }
        return day;
    }

    /**
     * Corrixe o desvío do sensor: resta offset a cada temperatura.
     *
     * @param temps  temperaturas mínimas, que quedan corrixidas
     * @param offset graos que o sensor marca de máis
     */
    public static void calibrate(int[] temps, int offset) {
        for (int t : temps) {
            t -= offset;
        }
    }

    /**
     * Calcula a variación da temperatura dun día ao seguinte.
     * Provisional: complétase en 7_c.
     *
     * @param temps temperaturas mínimas, unha por día
     * @return de momento, un array baleiro
     */
    public static int[] differences(int[] temps) {
        return new int[0];
    }

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

    /**
     * Amosa os días de xeada dun array e se coinciden cos esperados.
     *
     * @param temps    temperaturas que se proban
     * @param expected resultado que debería devolver frostDays
     */
    public static void checkFrost(int[] temps, int expected) {
        int result = frostDays(temps);
        String verdict = result == expected ? "OK" : "ERRO";
        System.out.println("frostDays " + Arrays.toString(temps)
                + " -> " + result + " [" + verdict + "]");
    }

    /**
     * Amosa o día máis frío dun array e se coincide co esperado.
     *
     * @param temps    temperaturas que se proban
     * @param expected resultado que debería devolver coldestDay
     */
    public static void checkColdest(int[] temps, int expected) {
        int result = coldestDay(temps);
        String verdict = result == expected ? "OK" : "ERRO";
        System.out.println("coldestDay " + Arrays.toString(temps)
                + " -> " + result + " [" + verdict + "]");
    }

    /**
     * Corrixe un array con calibrate e amosa se queda como o
     * esperado.
     *
     * @param temps    temperaturas que se proban
     * @param offset   desvío que se corrixe
     * @param expected como debería quedar temps
     */
    public static void checkCalibrate(int[] temps, int offset,
                                      int[] expected) {
        String before = Arrays.toString(temps);
        calibrate(temps, offset);
        boolean ok = Arrays.equals(temps, expected);
        String verdict = ok ? "OK" : "ERRO";
        System.out.println("calibrate " + before + " " + offset
                + " -> " + Arrays.toString(temps)
                + " [" + verdict + "]");
    }

    /**
     * Amosa as variacións dun array e se coinciden coas esperadas.
     * Comproba tamén que o array orixinal queda como estaba.
     *
     * @param temps    temperaturas que se proban
     * @param expected array que debería devolver differences
     */
    public static void checkDifferences(int[] temps,
                                        int[] expected) {
        int[] before = Arrays.copyOf(temps, temps.length);
        int[] result = differences(temps);
        boolean ok = Arrays.equals(result, expected)
                && Arrays.equals(temps, before);
        String verdict = ok ? "OK" : "ERRO";
        System.out.println("differences " + Arrays.toString(before)
                + " -> " + Arrays.toString(result)
                + " [" + verdict + "]");
    }

    /**
     * Escribe as temperaturas e o resumo cos métodos da tarefa.
     *
     * @param temps temperaturas xa corrixidas
     */
    public static void printSummary(int[] temps) {
        System.out.println();
        System.out.println("Día  Mín.");
        for (int i = 0; i < temps.length; i++) {
            System.out.printf("%3d%6d", i + 1, temps[i]);
            if (temps[i] < 0) {
                System.out.print(" *");
            }
            System.out.println();
        }
        System.out.println("Días de xeada: " + frostDays(temps));
        System.out.println("Día máis frío: " + coldestDay(temps));
        System.out.println("Variacións: "
                + Arrays.toString(differences(temps)));
    }

    public static void main(String[] args) {
        checkFrost(new int[] {2, -1, 0, -3}, 2);
        checkColdest(new int[] {2, -1, 0, -3}, 4);
        checkCalibrate(new int[] {2, -1, 0, -3}, 1,
                new int[] {1, -2, -1, -4});

        Scanner scanner = new Scanner(System.in);

        scanner.close();
    }
}
