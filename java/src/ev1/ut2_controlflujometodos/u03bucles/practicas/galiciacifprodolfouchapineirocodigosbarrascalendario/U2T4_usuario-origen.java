import java.util.Locale;
import java.util.Scanner;

/**
 * U2T4. Códigos de barras e calendario.
 *
 * @author usuario
 */
class BarcodesAndCalendar {

    /**
     * Comproba un código EAN-13.
     *
     * @param code código de 13 díxitos, sen os ceros á esquerda
     * @return true se o código está no intervalo e o seu díxito de
     *         control é correcto
     */
    public static boolean isValidEan(long code) {
        int sum = 0;
        int position = 0;
        while (code > 0) {
            int digit = (int) (code % 10);
            if (position % 2 == 0) {
                sum += 3 * digit;
            } else {
                sum += digit;
            }
            code = code / 10;
            position++;
        }
        return sum % 10 == 0;
    }

    /**
     * Amosa se un código é válido e se coincide co esperado.
     *
     * @param code     código que se proba
     * @param expected resultado que debería devolver isValidEan
     */
    public static void checkEan(long code, boolean expected) {
        boolean result = isValidEan(code);
        String verdict = result == expected ? "OK" : "ERRO";
        System.out.println(code + " -> " + result
                + " [" + verdict + "]");
    }

    /**
     * Escribe o calendario dun mes, cunha liña por semana.
     *
     * @param days  número de días do mes, de 28 a 31
     * @param first día da semana do día 1, de 1 (luns) a 7 (domingo)
     */
    public static void printMonth(int days, int first) {
        System.out.println(" Lu Ma Mé Xo Ve Sá Do");
        int day = 1;
        for (int week = 1; week <= 5; week++) {
            for (int weekday = 1; weekday <= 7; weekday++) {
                if (day > days) {
                    break;
                }
                if (week == 1 && weekday < first) {
                    System.out.print("  ");
                } else {
                    System.out.printf("%3d", day);
                    day++;
                }
            }
            System.out.println();
        }
    }

    public static long readCode(Scanner scanner) {
        return 0;   // provisional ata 4_f
    }

    // Da U2T2: só os usa a ampliación, 4_g
    /**
     * Indica se un ano é bisesto no calendario gregoriano.
     *
     * @param year ano que se comproba
     * @return true se o ano é bisesto
     */
    public static boolean isLeapYear(int year) {
        return year % 4 == 0
                && (year % 100 != 0 || year % 400 == 0);
    }

    /**
     * Calcula o número de días dun mes.
     *
     * @param month número do mes, de 1 a 12
     * @param year  ano, que só inflúe en febreiro
     * @return o número de días, ou -1 se o mes non é válido
     */
    public static int daysInMonth(int month, int year) {
        return switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 4, 6, 9, 11 -> 30;
            case 2 -> isLeapYear(year) ? 29 : 28;
            default -> -1;
        };
    }

    public static void main(String[] args) {
        checkEan(12345678905L, true);
        System.out.println();

        printMonth(31, 4);
        System.out.println("---");
        System.out.println();

        // Coma decimal en calquera computador (U2A3)
        Locale.setDefault(Locale.of("gl", "ES"));
        Scanner scanner = new Scanner(System.in);
        int checked = 0;
        int valid = 0;
        long code = readCode(scanner);
        while (code != 0) {
            checked++;
            if (isValidEan(code)) {
                System.out.println("Válido");
                valid++;
            } else {
                System.out.println("Non válido");
            }
            code = readCode(scanner);
        }
        scanner.close();

        if (checked == 0) {
            System.out.println("Non se comprobou ningún código");
        } else {
            System.out.printf(
                    "Comprobados: %d. Válidos: %d (%.1f %%)%n",
                    checked, valid, valid * 100.0 / checked);
        }
    }
}
