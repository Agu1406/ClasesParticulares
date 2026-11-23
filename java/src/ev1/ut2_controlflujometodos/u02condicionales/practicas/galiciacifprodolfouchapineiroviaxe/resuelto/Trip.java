package ev1.ut2_controlflujometodos.u02condicionales.practicas.galiciacifprodolfouchapineiroviaxe.resuelto;

import java.util.Locale;
import java.util.Scanner;

/**
 * <p><b>OBJETIVO:</b> completar U2T3 (viaxe): corregir lectura/validacion;
 * implementar {@code durationText} y usarlo en el resumen.</p>
 *
 * <br>
 *
 * <p><b>SOLUCION:</b> {@code hasNextInt} para el tiempo; {@code nextLine} de
 * limpieza antes del destino; {@code durationText} con {@code %02d}; aviso
 * con {@code %.1f}.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 18/11/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Trip {

    private static final int SPEED_LIMIT = 120;

    /**
     * Escribe una duracion en horas y minutos.
     *
     * @param minutes duracion en minutos, de 1 a 1440
     * @return la duracion en el formato "2 h 05 min"
     */
    public static String durationText(int minutes) {
        return String.format("%d h %02d min",
                minutes / 60, minutes % 60);
    }

    /**
     * Muestra una duracion escrita y si coincide con la esperada.
     *
     * @param minutes  duracion en minutos
     * @param expected texto que deberia devolver durationText
     */
    public static void checkDuration(int minutes, String expected) {
        String result = durationText(minutes);
        String verdict = result.equals(expected) ? "OK" : "ERRO";
        System.out.println(minutes + " -> " + result
                + " [" + verdict + "]");
    }

    public static void main(String[] args) {
        checkDuration(1, "0 h 01 min");
        checkDuration(9, "0 h 09 min");
        checkDuration(10, "0 h 10 min");
        checkDuration(59, "0 h 59 min");
        checkDuration(60, "1 h 00 min");
        checkDuration(61, "1 h 01 min");
        checkDuration(125, "2 h 05 min");
        checkDuration(600, "10 h 00 min");
        checkDuration(1440, "24 h 00 min");

        Locale.setDefault(Locale.of("gl", "ES"));
        Scanner scanner = new Scanner(System.in);

        System.out.print("Distancia (km): ");
        if (!scanner.hasNextDouble()) {
            System.out.println("Distancia non válida");
            scanner.close();
            return;
        }
        double distance = scanner.nextDouble();
        if (!Double.isFinite(distance) || distance <= 0) {
            System.out.println("Distancia non válida");
            scanner.close();
            return;
        }

        System.out.print("Tempo (minutos): ");
        if (!scanner.hasNextInt()) {
            System.out.println("Tempo non válido");
            scanner.close();
            return;
        }
        int minutes = scanner.nextInt();
        if (minutes < 1 || minutes > 1440) {
            System.out.println("Tempo non válido");
            scanner.close();
            return;
        }

        scanner.nextLine();
        System.out.print("Destino: ");
        String destination = scanner.nextLine();
        scanner.close();

        double speed = distance / (minutes / 60.0);
        System.out.println();
        System.out.printf("%-12s%s%n", "Destino:", destination);
        System.out.printf("%-12s%.1f km%n", "Distancia:", distance);
        System.out.printf("%-12s%s%n", "Tempo:", durationText(minutes));
        System.out.printf("%-12s%.1f km/h%n", "Velocidade:", speed);
        if (speed > SPEED_LIMIT) {
            System.out.printf("Aviso: %.1f km/h, por riba de %d%n",
                    speed, SPEED_LIMIT);
        }
    }
}
