package ev4.E09_ExamenRA246.E03_CuentaBanco;

import java.util.Locale;
import java.util.Scanner;

/**
 * <p>Enunciado: {@code enunciado.md}.</p>
 *
 * <p><b>OBJETIVO:</b> clase {@code Cuenta} (titular, saldo, ingresar, retirar,
 * {@code toString}) y aplicar operaciones {@code I}/{@code R} hasta {@code FIN}.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> cantidad &lt;= 0 → no valida; ingreso siempre; retirada solo
 * si hay saldo; al {@code FIN} se imprime {@code toString} de la cuenta.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 15/11/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Done {

    public static void main(String[] args) {
        /* --- Variables al principio del metodo --- */
        Scanner teclado;
        Cuenta cuenta;
        String titular, operacion;
        double cantidad;
        boolean continuar, retiradaOk;

        teclado = new Scanner(System.in);
        teclado.useLocale(Locale.US);

        titular = teclado.nextLine();
        cuenta = new Cuenta(titular);
        continuar = true;

        do {
            operacion = teclado.next();
            if (operacion.equals("FIN")) {
                continuar = false;
            } else {
                cantidad = teclado.nextDouble();
                if (cantidad <= 0) {
                    System.out.println("Cantidad no válida");
                } else if (operacion.equals("I")) {
                    cuenta.ingresar(cantidad);
                    System.out.printf(Locale.US, "Ingreso: %.2f €%n", cantidad);
                } else if (operacion.equals("R")) {
                    retiradaOk = cuenta.retirar(cantidad);
                    if (retiradaOk) {
                        System.out.printf(Locale.US, "Retirada: %.2f €%n", cantidad);
                    } else {
                        System.out.printf(Locale.US,
                                "Saldo insuficiente: quedan %.2f €%n",
                                cuenta.getSaldo());
                    }
                }
            }
        } while (continuar);

        System.out.println(cuenta);
        teclado.close();
    }
}

class Cuenta {
    private String titular;
    private double saldo;

    Cuenta(String titular) {
        this.titular = titular;
        this.saldo = 0;
    }

    void ingresar(double cantidad) {
        saldo = saldo + cantidad;
    }

    boolean retirar(double cantidad) {
        if (cantidad > saldo) {
            return false;
        }
        saldo = saldo - cantidad;
        return true;
    }

    double getSaldo() {
        return saldo;
    }

    @Override
    public String toString() {
        return String.format(Locale.US, "%s: %.2f €", titular, saldo);
    }
}
