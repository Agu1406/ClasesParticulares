package ev1.ut2_controlflujometodos.u03bucles.practicas.galiciacifprodolfouchapineirocodigosbarrascalendario.pendiente;

import java.util.Locale;
import java.util.Scanner;

/**
 * <p><b>OBJETIVO:</b> completar U2T4 (codigos de barras EAN-13 y calendario):
 * corregir {@code isValidEan} y {@code printMonth}, implementar {@code readCode}
 * y, como ampliacion, {@code firstWeekday} / {@code checkWeekday}.</p>
 *
 * <p>Enunciado: {@code galicia-cifprodolfouchapineiro-codigos-barras-calendario.pdf}
 * (carpeta de la practica). Documento de trabajo de alumna:
 * {@code galicia-cifprodolfouchapineiro-codigos-barras-calendario-sandramd.odt}.</p>
 *
 * <p>Partida del centro: {@code isValidEan} y {@code printMonth} tienen errores a proposito;
 * {@code readCode} todavia no lee (devuelve 0).</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 04/11/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class BarcodesAndCalendar {

    /**
     * Comprueba un codigo EAN-13.
     *
     * @param code codigo de 13 digitos, sin los ceros a la izquierda
     * @return true si el codigo esta en el intervalo y el digito de control es correcto
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
     * Muestra si un codigo es valido y si coincide con lo esperado.
     *
     * @param code     codigo que se prueba
     * @param expected resultado que deberia devolver isValidEan
     */
    public static void checkEan(long code, boolean expected) {
        boolean result = isValidEan(code);
        String verdict = result == expected ? "OK" : "ERRO";
        System.out.println(code + " -> " + result
                + " [" + verdict + "]");
    }

    /**
     * Escribe el calendario de un mes, con una linea por semana.
     *
     * @param days  numero de dias del mes, de 28 a 31
     * @param first dia de la semana del dia 1, de 1 (lunes) a 7 (domingo)
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

    /**
     * Lee un codigo del teclado. Completar en 4_f.
     *
     * @param teclado lector de entrada
     * @return el codigo leido (0 para finalizar)
     */
    public static long readCode(Scanner teclado) {
        return 0; // provisional hasta 4_f
    }

    /**
     * Indica si un ano es bisiesto en el calendario gregoriano.
     *
     * @param year ano que se comprueba
     * @return true si el ano es bisiesto
     */
    public static boolean isLeapYear(int year) {
        return year % 4 == 0
                && (year % 100 != 0 || year % 400 == 0);
    }

    /**
     * Calcula el numero de dias de un mes.
     *
     * @param month numero del mes, de 1 a 12
     * @param year  ano, que solo influye en febrero
     * @return el numero de dias, o -1 si el mes no es valido
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

        // Coma decimal en cualquier ordenador (U2A3)
        Locale.setDefault(Locale.of("gl", "ES"));
        Scanner teclado = new Scanner(System.in);
        int checked = 0;
        int valid = 0;
        long code = readCode(teclado);
        while (code != 0) {
            checked++;
            if (isValidEan(code)) {
                System.out.println("Valido");
                valid++;
            } else {
                System.out.println("No valido");
            }
            code = readCode(teclado);
        }
        teclado.close();
        if (checked == 0) {
            System.out.println("No se comprobo ningun codigo");
        } else {
            System.out.printf(
                    "Comprobados: %d. Validos: %d (%.1f %%)%n",
                    checked, valid, valid * 100.0 / checked);
        }
    }
}
