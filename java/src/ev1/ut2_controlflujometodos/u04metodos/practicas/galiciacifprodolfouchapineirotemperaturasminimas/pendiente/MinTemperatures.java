package ev1.ut2_controlflujometodos.u04metodos.practicas.galiciacifprodolfouchapineirotemperaturasminimas.pendiente;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <p><b>OBJETIVO:</b> completar U2T7 (temperaturas minimas): probar y corregir
 * {@code frostDays}, {@code coldestDay} y {@code calibrate}; implementar
 * {@code differences}; guardar lecturas en un array y aplicar el desvio del sensor.
 * Ampliacion opcional: {@code longestFrostSpell}.</p>
 *
 * <p>Enunciado: {@code galicia-cifprodolfouchapineiro-temperaturas-minimas.pdf}
 * (carpeta de la practica).</p>
 *
 * <p>Partida del centro: {@code frostDays}, {@code coldestDay} y {@code calibrate}
 * tienen errores a proposito; {@code differences} todavia es provisional.
 * {@code readInt} y {@code printSummary} ya estan completos.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 05/11/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class MinTemperatures {

    /**
     * Cuenta los dias de helada.
     *
     * @param temps temperaturas minimas, una por dia
     * @return el numero de temperaturas por debajo de 0
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
     * Busca el dia mas frio.
     *
     * @param temps temperaturas minimas, una por dia desde el dia 1
     * @return el numero del dia con la temperatura mas baja, el primero
     *         si hay varios, o 0 si el array esta vacio
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
     * Corrige el desvio del sensor: resta offset a cada temperatura.
     *
     * @param temps  temperaturas minimas, que quedan corregidas
     * @param offset grados que el sensor marca de mas
     */
    public static void calibrate(int[] temps, int offset) {
        for (int t : temps) {
            t -= offset;
        }
    }

    /**
     * Calcula la variacion de la temperatura de un dia al siguiente.
     * Provisional: se completa en 7_c.
     *
     * @param temps temperaturas minimas, una por dia
     * @return de momento, un array vacio
     */
    public static int[] differences(int[] temps) {
        return new int[0];
    }

    /**
     * Lee un entero de un intervalo y repite la pregunta hasta obtenerlo.
     *
     * @param teclado lector del teclado
     * @param prompt  pregunta que se muestra antes de cada lectura
     * @param min     valor minimo admitido
     * @param max     valor maximo admitido
     * @return el primer entero leido que esta entre min y max
     */
    public static int readInt(Scanner teclado, String prompt,
                              int min, int max) {
        int value = 0;
        boolean valid;
        do {
            System.out.print(prompt);
            valid = teclado.hasNextInt();
            if (valid) {
                value = teclado.nextInt();
                valid = value >= min && value <= max;
            }
            teclado.nextLine();   // descarta el resto de la linea
            if (!valid) {
                System.out.println("Escribe un entero de " + min
                        + " a " + max);
            }
        } while (!valid);
        return value;
    }

    /**
     * Muestra los dias de helada de un array y si coinciden con los esperados.
     *
     * @param temps    temperaturas que se prueban
     * @param expected resultado que deberia devolver frostDays
     */
    public static void checkFrost(int[] temps, int expected) {
        int result = frostDays(temps);
        String verdict = result == expected ? "OK" : "ERRO";
        System.out.println("frostDays " + Arrays.toString(temps)
                + " -> " + result + " [" + verdict + "]");
    }

    /**
     * Muestra el dia mas frio de un array y si coincide con el esperado.
     *
     * @param temps    temperaturas que se prueban
     * @param expected resultado que deberia devolver coldestDay
     */
    public static void checkColdest(int[] temps, int expected) {
        int result = coldestDay(temps);
        String verdict = result == expected ? "OK" : "ERRO";
        System.out.println("coldestDay " + Arrays.toString(temps)
                + " -> " + result + " [" + verdict + "]");
    }

    /**
     * Corrige un array con calibrate y muestra si queda como el
     * esperado.
     *
     * @param temps    temperaturas que se prueban
     * @param offset   desvio que se corrige
     * @param expected como deberia quedar temps
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
     * Muestra las variaciones de un array y si coinciden con las esperadas.
     * Comprueba tambien que el array original queda como estaba.
     *
     * @param temps    temperaturas que se prueban
     * @param expected array que deberia devolver differences
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
     * Escribe las temperaturas y el resumen con los metodos de la tarea.
     *
     * @param temps temperaturas ya corregidas
     */
    public static void printSummary(int[] temps) {
        System.out.println();
        System.out.println("Dia  Min.");
        for (int i = 0; i < temps.length; i++) {
            System.out.printf("%3d%6d", i + 1, temps[i]);
            if (temps[i] < 0) {
                System.out.print(" *");
            }
            System.out.println();
        }
        System.out.println("Dias de helada: " + frostDays(temps));
        System.out.println("Dia mas frio: " + coldestDay(temps));
        System.out.println("Variaciones: "
                + Arrays.toString(differences(temps)));
    }

    public static void main(String[] args) {
        checkFrost(new int[]{2, -1, 0, -3}, 2);
        checkColdest(new int[]{2, -1, 0, -3}, 4);
        checkCalibrate(new int[]{2, -1, 0, -3}, 1,
                new int[]{1, -2, -1, -4});

        Scanner teclado = new Scanner(System.in);

        teclado.close();
    }
}
