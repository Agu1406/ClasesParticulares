package ev1.ut2_controlflujometodos.u02condicionales.practicas.galiciacifprodolfouchapineirotarifas.resuelto;

import java.util.Scanner;

/**
 * <p><b>OBJETIVO:</b> completar U2T1 (tarifas): probar y corregir
 * {@code ticketPrice}; implementar {@code parkingFee} y sus pruebas.</p>
 *
 * <br>
 *
 * <p><b>SOLUCION:</b> {@code equalsIgnoreCase("XOVE")}, {@code age >= 65},
 * {@code age <= 30}; {@code parkingFee} con tope 1200 y mitad residente.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 18/11/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Tariffs {

    /**
     * Calcula el precio de una entrada de cine.
     *
     * @param age  edad de la persona, en anos
     * @param card codigo del carne, o texto vacio si no hay
     * @return el precio en euros, o -1 si la edad no es valida
     */
    public static int ticketPrice(int age, String card) {
        if (age < 0 || age > 120) {
            return -1;
        }
        if (age < 4) {
            return 0;
        } else if (age <= 13) {
            return 5;
        } else if (age >= 65) {
            return 4;
        } else if (card.equalsIgnoreCase("XOVE") && age <= 30) {
            return 6;
        } else {
            return 8;
        }
    }

    /**
     * Muestra el precio de una entrada y si coincide con el esperado.
     *
     * @param age      edad de la persona
     * @param card     codigo del carne
     * @param expected precio que deberia devolver ticketPrice
     */
    public static void checkTicket(int age, String card, int expected) {
        int result = ticketPrice(age, card);
        String verdict = result == expected ? "OK" : "ERRO";
        System.out.println(age + " \"" + card + "\" -> " + result
                + " [" + verdict + "]");
    }

    /**
     * Calcula el importe de una estancia en el aparcamiento.
     *
     * @param minutes  duracion de la estancia, en minutos
     * @param resident true si la persona es residente
     * @return el importe en centimos, o -1 si la duracion no es valida
     */
    public static int parkingFee(int minutes, boolean resident) {
        int fee;
        int extraHours;

        if (minutes < 0 || minutes > 1440) {
            return -1;
        }
        if (minutes <= 15) {
            fee = 0;
        } else if (minutes <= 60) {
            fee = 150;
        } else {
            extraHours = (minutes - 60 + 59) / 60;
            fee = 150 + 100 * extraHours;
        }
        if (fee > 1200) {
            fee = 1200;
        }
        if (resident) {
            fee = fee / 2;
        }
        return fee;
    }

    /**
     * Muestra el importe de una estancia y si coincide con el esperado.
     *
     * @param minutes  duracion de la estancia, en minutos
     * @param resident true si la persona es residente
     * @param expected importe que deberia devolver parkingFee
     */
    public static void checkParking(int minutes, boolean resident, int expected) {
        int result = parkingFee(minutes, resident);
        String verdict = result == expected ? "OK" : "ERRO";
        System.out.println(minutes + " " + resident + " -> " + result
                + " [" + verdict + "]");
    }

    public static void main(String[] args) {
        checkTicket(-1, "", -1);
        checkTicket(0, "", 0);
        checkTicket(3, "", 0);
        checkTicket(4, "", 5);
        checkTicket(13, "XOVE", 5);
        checkTicket(14, "", 8);
        checkTicket(14, "XOVE", 6);
        checkTicket(20, "XOVE", 6);
        checkTicket(20, "xove", 6);
        checkTicket(20, "PROMO", 8);
        checkTicket(30, "XOVE", 6);
        checkTicket(31, "XOVE", 8);
        checkTicket(64, "", 8);
        checkTicket(65, "", 4);
        checkTicket(120, "XOVE", 4);
        checkTicket(121, "", -1);

        checkParking(-1, false, -1);
        checkParking(0, false, 0);
        checkParking(15, false, 0);
        checkParking(16, false, 150);
        checkParking(60, false, 150);
        checkParking(61, false, 250);
        checkParking(120, false, 250);
        checkParking(121, false, 350);
        checkParking(660, false, 1150);
        checkParking(661, false, 1200);
        checkParking(1440, false, 1200);
        checkParking(1441, false, -1);
        checkParking(16, true, 75);
        checkParking(661, true, 600);
        checkParking(1441, true, -1);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Carne (Intro se non tes): ");
        String card = scanner.nextLine();
        System.out.print("Idade: ");
        int age = scanner.nextInt();
        int price = ticketPrice(age, card);
        System.out.println("Prezo: " + price + " euros");
        scanner.close();
    }
}
