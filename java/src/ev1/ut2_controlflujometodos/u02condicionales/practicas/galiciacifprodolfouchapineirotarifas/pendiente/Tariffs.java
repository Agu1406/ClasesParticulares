package ev1.ut2_controlflujometodos.u02condicionales.practicas.galiciacifprodolfouchapineirotarifas.pendiente;

import java.util.Scanner;

/**
 * <p><b>OBJETIVO:</b> completar U2T1 (tarifas): probar y corregir
 * {@code ticketPrice}; implementar {@code parkingFee} y sus pruebas.</p>
 *
 * <p>Enunciado: {@code galicia-cifprodolfouchapineiro-tarifas.odt}
 * (carpeta de la practica). Autoaval: {@code ...-tarifas-aa.pdf}.</p>
 *
 * <p>Partida del centro: {@code ticketPrice} tiene errores a proposito
 * ({@code ==} con String, limites de edad/carne).</p>
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
        } else if (age > 65) {
            return 4;
        } else if (card == "XOVE" && age < 30) {
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

    public static void main(String[] args) {
        checkTicket(40, "", 8);

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
