package ev1.ut2_controlflujometodos.u04metodos.practicas.galiciacifprodolfouchapineirotemperaturasminimas.resuelto;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <p><b>OBJETIVO:</b> completar U2T7 (temperaturas minimas): probar y corregir
 * {@code frostDays}, {@code coldestDay} y {@code calibrate}; implementar
 * {@code differences}; guardar lecturas en un array y aplicar el desvio del sensor.
 * Ampliacion opcional: {@code longestFrostSpell}.</p>
 *
 * <p><b>SOLUCION:</b> metodos corregidos segun la plantilla del centro; pruebas
 * de 7_a y 7_c en {@code main}; programa interactivo 7_d; ampliacion 7_e con
 * {@code longestFrostSpell} y {@code checkSpell}.</p>
 *
 * <p>Enunciado: {@code galicia-cifprodolfouchapineiro-temperaturas-minimas.pdf}
 * (carpeta de la practica).</p>
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
        for (int i = 0; i < temps.length; i++) {
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
     * Corrige el desvio del sensor: resta offset a cada temperatura.
     *
     * @param temps  temperaturas minimas, que quedan corregidas
     * @param offset grados que el sensor marca de mas
     */
    public static void calibrate(int[] temps, int offset) {
        for (int i = 0; i < temps.length; i++) {
            temps[i] -= offset;
        }
    }

    /**
     * Calcula la variacion de la temperatura de un dia al siguiente.
     * Cada posicion i del resultado es {@code temps[i + 1] - temps[i]}.
     * No modifica {@code temps}.
     *
     * @param temps temperaturas minimas, una por dia
     * @return array con un elemento menos; vacio si hay menos de 2 dias
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
     * Devuelve la mayor racha de dias de helada consecutivos, o 0 si no hay heladas.
     *
     * @param temps temperaturas minimas, una por dia
     * @return longitud de la racha mas larga de temperaturas &lt; 0
     */
    public static int longestFrostSpell(int[] temps) {
        int longest = 0;
        int current = 0;
        for (int i = 0; i < temps.length; i++) {
            if (temps[i] < 0) {
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
     * Comprueba longestFrostSpell y muestra OK o ERRO.
     *
     * @param temps    temperaturas que se prueban
     * @param expected resultado que deberia devolver longestFrostSpell
     */
    public static void checkSpell(int[] temps, int expected) {
        int result = longestFrostSpell(temps);
        String verdict = result == expected ? "OK" : "ERRO";
        System.out.println("longestFrostSpell " + Arrays.toString(temps)
                + " -> " + result + " [" + verdict + "]");
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
        // --- 7_a: frostDays ---
        checkFrost(new int[]{2, -1, 0, -3}, 2);
        checkFrost(new int[]{}, 0);
        checkFrost(new int[]{0}, 0);
        checkFrost(new int[]{-1}, 1);
        checkFrost(new int[]{-3, 2, 4}, 1);
        checkFrost(new int[]{2, 4, -3}, 1);
        checkFrost(new int[]{-1, -5, -2}, 3);

        // --- 7_a: coldestDay ---
        checkColdest(new int[]{2, -1, 0, -3}, 4);
        checkColdest(new int[]{}, 0);
        checkColdest(new int[]{7}, 1);
        checkColdest(new int[]{-4, 2, 0}, 1);
        checkColdest(new int[]{1, -2, 5, -2}, 2);
        checkColdest(new int[]{5, 3, 8}, 2);

        // --- 7_a: calibrate ---
        checkCalibrate(new int[]{2, -1, 0, -3}, 1,
                new int[]{1, -2, -1, -4});
        checkCalibrate(new int[]{2, -1}, -2,
                new int[]{4, 1});

        // --- 7_c: differences ---
        checkDifferences(new int[]{}, new int[]{});
        checkDifferences(new int[]{4}, new int[]{});
        checkDifferences(new int[]{4, 1}, new int[]{-3});
        checkDifferences(new int[]{2, -1, 0, -3}, new int[]{-3, 1, -3});
        checkDifferences(new int[]{-5, -5, 3}, new int[]{0, 8});

        // --- 7_e: longestFrostSpell ---
        checkSpell(new int[]{1, -2, 0, -1, -3, -1}, 3);
        checkSpell(new int[]{}, 0);
        checkSpell(new int[]{5, 3, 0}, 0);
        checkSpell(new int[]{-1}, 1);
        checkSpell(new int[]{-2, -1, 4, -3, -1}, 2);
        checkSpell(new int[]{-1, -2, -3, -4}, 4);
        checkSpell(new int[]{0, -1, -2, 1, -3}, 2);

        // --- 7_d: lectura, calibrado y resumen ---
        Scanner teclado = new Scanner(System.in);
        int days;
        int[] temps;
        int offset;
        int i;

        days = readInt(teclado, "Dias: ", 1, 31);
        temps = new int[days];
        for (i = 0; i < days; i++) {
            temps[i] = readInt(teclado, "Dia " + (i + 1) + ": ", -50, 50);
        }
        offset = readInt(teclado, "Desvio del sensor: ", -5, 5);
        teclado.close();

        calibrate(temps, offset);
        printSummary(temps);
    }
}
