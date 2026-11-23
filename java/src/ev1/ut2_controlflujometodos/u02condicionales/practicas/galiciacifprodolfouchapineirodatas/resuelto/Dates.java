package ev1.ut2_controlflujometodos.u02condicionales.practicas.galiciacifprodolfouchapineirodatas.resuelto;

/**
 * <p><b>OBJETIVO:</b> completar U2T2 (datas): probar y corregir
 * {@code daysInMonth}; reescribirlo con switch expresion; implementar
 * {@code dateText}.</p>
 *
 * <br>
 *
 * <p><b>SOLUCION:</b> switch expresion por mes; {@code dateText} con nombres
 * en galego y validacion via {@code daysInMonth}.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 18/11/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Dates {

    /**
     * Indica si un anio es bisiesto en el calendario gregoriano.
     *
     * @param year anio que se comprueba
     * @return true si el anio es bisiesto
     */
    public static boolean isLeapYear(int year) {
        return year % 4 == 0
                && (year % 100 != 0 || year % 400 == 0);
    }

    /**
     * Calcula el numero de dias de un mes.
     *
     * @param month numero del mes, de 1 a 12
     * @param year  anio, que solo influye en febrero
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
     * Muestra los dias de un mes y si coinciden con los esperados.
     *
     * @param month    numero del mes
     * @param year     anio
     * @param expected dias que deberia devolver daysInMonth
     */
    public static void checkDays(int month, int year, int expected) {
        int result = daysInMonth(month, year);
        String verdict = result == expected ? "OK" : "ERRO";
        System.out.println(month + "/" + year + " -> " + result
                + " [" + verdict + "]");
    }

    /**
     * Escribe una fecha con el nombre del mes en galego.
     *
     * @param day   dia del mes
     * @param month numero del mes, de 1 a 12
     * @param year  anio
     * @return la fecha en formato "6 de outubro de 2026", o "Data non valida"
     */
    public static String dateText(int day, int month, int year) {
        String name;

        if (day < 1 || day > daysInMonth(month, year)) {
            return "Data non válida";
        }
        name = switch (month) {
            case 1 -> "xaneiro";
            case 2 -> "febreiro";
            case 3 -> "marzo";
            case 4 -> "abril";
            case 5 -> "maio";
            case 6 -> "xuño";
            case 7 -> "xullo";
            case 8 -> "agosto";
            case 9 -> "setembro";
            case 10 -> "outubro";
            case 11 -> "novembro";
            case 12 -> "decembro";
            default -> "";
        };
        return day + " de " + name + " de " + year;
    }

    /**
     * Muestra la fecha escrita y si coincide con la esperada.
     *
     * @param day      dia del mes
     * @param month    numero del mes
     * @param year     anio
     * @param expected texto que deberia devolver dateText
     */
    public static void checkDate(int day, int month, int year, String expected) {
        String result = dateText(day, month, year);
        String verdict = result.equals(expected) ? "OK" : "ERRO";
        System.out.println(day + "/" + month + "/" + year + " -> "
                + result + " [" + verdict + "]");
    }

    public static void main(String[] args) {
        checkDays(1, 2026, 31);
        checkDays(2, 2026, 28);
        checkDays(3, 2026, 31);
        checkDays(4, 2026, 30);
        checkDays(5, 2026, 31);
        checkDays(6, 2026, 30);
        checkDays(7, 2026, 31);
        checkDays(8, 2026, 31);
        checkDays(9, 2026, 30);
        checkDays(10, 2026, 31);
        checkDays(11, 2026, 30);
        checkDays(12, 2026, 31);
        checkDays(2, 2028, 29);
        checkDays(0, 2026, -1);
        checkDays(13, 2026, -1);

        checkDate(0, 1, 2026, "Data non válida");
        checkDate(1, 1, 2026, "1 de xaneiro de 2026");
        checkDate(31, 1, 2026, "31 de xaneiro de 2026");
        checkDate(32, 1, 2026, "Data non válida");
        checkDate(28, 2, 2026, "28 de febreiro de 2026");
        checkDate(29, 2, 2026, "Data non válida");
        checkDate(29, 2, 2024, "29 de febreiro de 2024");
        checkDate(30, 2, 2024, "Data non válida");
        checkDate(31, 3, 2026, "31 de marzo de 2026");
        checkDate(30, 4, 2026, "30 de abril de 2026");
        checkDate(31, 4, 2026, "Data non válida");
        checkDate(15, 5, 2026, "15 de maio de 2026");
        checkDate(15, 6, 2026, "15 de xuño de 2026");
        checkDate(15, 7, 2026, "15 de xullo de 2026");
        checkDate(15, 8, 2026, "15 de agosto de 2026");
        checkDate(15, 9, 2026, "15 de setembro de 2026");
        checkDate(6, 10, 2026, "6 de outubro de 2026");
        checkDate(15, 11, 2026, "15 de novembro de 2026");
        checkDate(31, 12, 2026, "31 de decembro de 2026");
        checkDate(1, 0, 2026, "Data non válida");
        checkDate(1, 13, 2026, "Data non válida");
    }
}
