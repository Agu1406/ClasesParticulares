package ev1.ut2_controlflujometodos.u02condicionales.practicas.galiciacifprodolfouchapineirodatas.pendiente;

/**
 * <p><b>OBJETIVO:</b> completar U2T2 (datas): probar y corregir
 * {@code daysInMonth}; reescribirlo con switch expresion; implementar
 * {@code dateText}.</p>
 *
 * <p>Enunciado: {@code galicia-cifprodolfouchapineiro-datas.odt}
 * (carpeta de la practica). Autoaval: {@code ...-datas-aa.pdf}.</p>
 *
 * <p>Partida del centro: {@code daysInMonth} tiene errores a proposito
 * (faltan break / meses mal agrupados).</p>
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
        int days;
        switch (month) {
            case 2:
                if (isLeapYear(year)) {
                    days = 29;
                } else {
                    days = 28;
                }
            case 4:
            case 6:
            case 11:
                days = 30;
                break;
            default:
                days = 31;
        }
        return days;
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

    public static void main(String[] args) {
        checkDays(10, 2026, 31);
    }
}
