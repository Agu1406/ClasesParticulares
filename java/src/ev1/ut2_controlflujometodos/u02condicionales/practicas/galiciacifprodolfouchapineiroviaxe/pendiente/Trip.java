package ev1.ut2_controlflujometodos.u02condicionales.practicas.galiciacifprodolfouchapineiroviaxe.pendiente;

import java.util.Locale;
import java.util.Scanner;

/**
 * <p><b>OBJETIVO:</b> completar U2T3 (viaxe): corregir lectura/validacion;
 * implementar {@code durationText} y usarlo en el resumen.</p>
 *
 * <p>Enunciado: {@code galicia-cifprodolfouchapineiro-viaxe.odt}
 * (carpeta de la practica). Autoaval: {@code ...-viaxe-aa.pdf}.</p>
 *
 * <p>Partida del centro: faltan comprobaciones de tipo en el tiempo;
 * {@code nextLine} del destino se come mal tras {@code nextInt};
 * {@code durationText} esta vacio.</p>
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
        return "";
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.of("gl", "ES"));
        Scanner scanner = new Scanner(System.in);

        System.out.print("Distancia (km): ");
        if (!scanner.hasNextDouble()) {
            System.out.println("Distancia non válida");
            return;
        }
        double distance = scanner.nextDouble();
        scanner.nextLine();
        if (!Double.isFinite(distance) || distance <= 0) {
            System.out.println("Distancia non válida");
            return;
        }

        System.out.print("Tempo (minutos): ");
        int minutes = scanner.nextInt();
        if (minutes < 1 || minutes > 1440) {
            System.out.println("Tempo non válido");
            return;
        }

        System.out.print("Destino: ");
        String destination = scanner.nextLine();
        scanner.close();

        double speed = distance / (minutes / 60.0);
        System.out.println();
        System.out.printf("%-12s%s%n", "Destino:", destination);
        System.out.printf("%-12s%.1f km%n", "Distancia:", distance);
        System.out.printf("%-12s%d min%n", "Tempo:", minutes);
        System.out.printf("%-12s%.1f km/h%n", "Velocidade:", speed);
        if (speed > SPEED_LIMIT) {
            System.out.printf("Aviso: %.1f km/h, por riba de %d%n",
                    speed, SPEED_LIMIT);
        }
    }
}
