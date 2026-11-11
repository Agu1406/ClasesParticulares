package ev1.ut2_controlflujometodos.u03bucles.practicas.galiciacifprodolfouchapineirocodigosbarrascalendario.resuelto;

import java.util.Locale;
import java.util.Scanner;

/**
 * <p><b>OBJETIVO:</b> completar U2T4 (codigos de barras EAN-13 y calendario):
 * corregir {@code isValidEan} y {@code printMonth}, implementar {@code readCode}
 * y, como ampliacion, {@code firstWeekday} / {@code checkWeekday}.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> parte de la entrega parcial de una alumna (EAN y calendario
 * ya corregidos, pruebas 4_b y 4_d en {@code main}). Se completa {@code readCode}
 * (4_f) y la ampliacion 4_g. Textos y comentarios en espanol.</p>
 *
 * <p>Enunciado: {@code galicia-cifprodolfouchapineiro-codigos-barras-calendario.pdf}.
 * Documento de la alumna:
 * {@code galicia-cifprodolfouchapineiro-codigos-barras-calendario-sandramd.odt}.</p>
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
        // Fuera de 1..9999999999999 no es un EAN-13 valido
        if (code < 1 || code > 9999999999999L) {
            return false;
        }
        int sum = 0;
        int position = 1; // posicion 1 = digito de control (derecha)
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
        // Cabecera del enunciado (abreviaturas del centro)
        System.out.println(" Lu Ma Mé Xo Ve Sá Do");
        int day = 1;
        // Hasta 6 semanas; si ya no quedan dias, salir sin linea en blanco
        for (int week = 1; week <= 6; week++) {
            if (day > days) {
                break;
            }
            for (int weekday = 1; weekday <= 7; weekday++) {
                if (day > days) {
                    break;
                }
                if (week == 1 && weekday < first) {
                    System.out.print("   "); // 3 espacios = ancho de un dia
                } else {
                    System.out.printf("%3d", day);
                    day++;
                }
            }
            System.out.println();
        }
    }

    /**
     * Lee un codigo del teclado. Pregunta hasta obtener un long valido.
     * El 0 finaliza la lectura en {@code main}.
     *
     * @param teclado lector de entrada
     * @return el codigo leido
     */
    public static long readCode(Scanner teclado) {
        while (true) {
            System.out.print("Codigo (0 para finalizar): ");
            if (!teclado.hasNextLine()) {
                return 0;
            }
            String line = teclado.nextLine().trim();
            if (line.isEmpty()) {
                continue; // linea vacia: se ignora y se vuelve a preguntar
            }
            String token = line.split("\\s+")[0];
            try {
                return Long.parseLong(token);
            } catch (NumberFormatException ex) {
                System.out.println("Entrada no valida");
            }
        }
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

    /**
     * Dia de la semana del primer dia del mes (1 = lunes ... 7 = domingo).
     * Referencia: 1 de enero de 2000 fue sabado.
     *
     * @param month mes de 1 a 12
     * @param year  ano a partir de 2000
     * @return dia de la semana del dia 1
     */
    public static int firstWeekday(int month, int year) {
        int total = 0;
        for (int y = 2000; y < year; y++) {
            total += isLeapYear(y) ? 366 : 365;
        }
        for (int m = 1; m < month; m++) {
            total += daysInMonth(m, year);
        }
        return (total + 5) % 7 + 1;
    }

    /**
     * Muestra el resultado de {@code firstWeekday} y si coincide con lo esperado.
     *
     * @param month    mes
     * @param year     ano
     * @param expected dia esperado (1..7)
     */
    public static void checkWeekday(int month, int year, int expected) {
        int result = firstWeekday(month, year);
        String verdict = result == expected ? "OK" : "ERRO";
        System.out.println(month + "/" + year + " -> " + result
                + " [" + verdict + "]");
    }

    public static void main(String[] args) {
        // Pruebas 4_b (tabla de isValidEan) — como en la entrega parcial
        checkEan(8412345678905L, true);
        checkEan(8412345678906L, false);
        checkEan(12345678905L, true);
        checkEan(96385074L, true);
        checkEan(5L, false);
        checkEan(17L, true);
        checkEan(0L, false);
        checkEan(-17L, false);
        checkEan(9999999999994L, true);
        checkEan(10000000000007L, false);
        System.out.println();

        // Pruebas 4_d (meses reales)
        printMonth(31, 4);
        System.out.println("---");
        printMonth(30, 1);
        System.out.println("---");
        printMonth(28, 7);
        System.out.println("---");
        printMonth(28, 1);
        System.out.println("---");
        printMonth(31, 6);
        System.out.println("---");
        printMonth(30, 7);
        System.out.println("---");
        System.out.println();

        // Ampliacion 4_g
        checkWeekday(1, 2000, 6);
        checkWeekday(10, 2026, 4);
        checkWeekday(2, 2028, 2);
        System.out.println();
        printMonth(daysInMonth(2, 2028), firstWeekday(2, 2028));
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
