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
        for (int i = 0; i < temps.length; i++) {
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
     *         se hai varios, ou 0 se a matriz está baleira
     */
    public static int coldestDay(int[] temps) {
        if (temps.length == 0) {
            return 0;
        }
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
        for (int i = 0; i < temps.length; i++) {
            temps[i] -= offset;
        }
    }

    /**
     * Calcula a variación da temperatura dun día ao seguinte. Non
     * modifica a matriz que recibe.
     *
     * @param temps temperaturas mínimas, unha por día
     * @return unha matriz nova cun elemento menos ca temps, no que a
     *         posición i garda temps[i + 1] - temps[i]; baleiro se
     *         temps ten menos de dous elementos
     */
    public static int[] differences(int[] temps) {
        if (temps.length < 2) {
            return new int[0];
        }
        int[] result = new int[temps.length - 1];
        for (int i = 0; i < result.length; i++) {
            result[i] = temps[i + 1] - temps[i];
        }
        return result;
    }

    /**
     * Busca a serie máis longa de días de xeada seguidos.
     *
     * @param temps temperaturas mínimas, unha por día
     * @return o maior número de días seguidos cunha temperatura por
     *         debaixo de 0, ou 0 se non hai ningún día de xeada
     */
    public static int longestFrostSpell(int[] temps) {
        int longest = 0;
        int current = 0;
        for (int t : temps) {
            if (t < 0) {
                current++;
                if (current > longest) {
                    longest = current;
                }
            } else {
                current = 0;
            }
        }
        return longest;
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
     * Amosa os días de xeada dunha matriz e compáraos cos esperados.
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
     * Amosa o día máis frío dunha matriz e se coincide co esperado.
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
     * Corrixe unha matriz con calibrate e amosa se queda como o
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
     * Amosa as variacións dunha matriz e compáraas coas esperadas.
     * Comproba tamén que a matriz orixinal queda como estaba.
     *
     * @param temps    temperaturas que se proban
     * @param expected matriz que debería devolver differences
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
     * Amosa a serie máis longa de xeadas dunha matriz e se coincide
     * coa esperada.
     *
     * @param temps    temperaturas que se proban
     * @param expected valor que debería devolver longestFrostSpell
     */
    public static void checkSpell(int[] temps, int expected) {
        int result = longestFrostSpell(temps);
        String verdict = result == expected ? "OK" : "ERRO";
        System.out.println("longestFrostSpell "
                + Arrays.toString(temps) + " -> " + result
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
        checkFrost(new int[] {}, 0);
        checkFrost(new int[] {0}, 0);
        checkFrost(new int[] {-1}, 1);
        checkFrost(new int[] {-3, 2, 4}, 1);
        checkFrost(new int[] {2, 4, -3}, 1);
        checkFrost(new int[] {-1, -5, -2}, 3);

        checkColdest(new int[] {2, -1, 0, -3}, 4);
        checkColdest(new int[] {}, 0);
        checkColdest(new int[] {7}, 1);
        checkColdest(new int[] {-4, 2, 0}, 1);
        checkColdest(new int[] {1, -2, 5, -2}, 2);
        checkColdest(new int[] {5, 3, 8}, 2);

        checkCalibrate(new int[] {2, -1, 0, -3}, 1,
                new int[] {1, -2, -1, -4});
        checkCalibrate(new int[] {2, -1}, -2, new int[] {4, 1});

        checkDifferences(new int[] {}, new int[] {});
        checkDifferences(new int[] {4}, new int[] {});
        checkDifferences(new int[] {4, 1}, new int[] {-3});
        checkDifferences(new int[] {2, -1, 0, -3},
                new int[] {-3, 1, -3});
        checkDifferences(new int[] {-5, -5, 3}, new int[] {0, 8});

        checkSpell(new int[] {}, 0);
        checkSpell(new int[] {3, 0, 5}, 0);
        checkSpell(new int[] {-1}, 1);
        checkSpell(new int[] {-2, -1, 3, -4}, 2);
        checkSpell(new int[] {1, -2, 0, -1, -3, -1}, 3);
        checkSpell(new int[] {-1, -2, -3}, 3);

        Scanner scanner = new Scanner(System.in);
        int days = readInt(scanner, "Días: ", 1, 31);
        int[] temps = new int[days];
        for (int i = 0; i < temps.length; i++) {
            String prompt = "Día " + (i + 1) + ": ";
            temps[i] = readInt(scanner, prompt, -50, 50);
        }
        int offset = readInt(scanner, "Desvío do sensor: ", -5, 5);
        scanner.close();

        calibrate(temps, offset);
        printSummary(temps);
    }
}
