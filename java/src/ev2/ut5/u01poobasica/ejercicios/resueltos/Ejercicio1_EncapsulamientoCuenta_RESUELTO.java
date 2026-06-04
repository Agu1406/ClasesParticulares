package ev2.ut5.u01poobasica.ejercicios.resueltos;

/**
 * Ejercicio POO Basico - Encapsulamiento (Resuelto)
 *
 * @author Agustin. A. Marquez. Pina
 * @since 05/05/2026
 */
public class Ejercicio1_EncapsulamientoCuenta_RESUELTO {
    public static void main(String[] args) {
        CuentaResuelta cuenta = new CuentaResuelta();
        cuenta.setSaldo(150.50);
        cuenta.setSaldo(-30);
        System.out.println("Saldo final: " + cuenta.getSaldo());
    }
}

class CuentaResuelta {
    private double saldo;

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        if (saldo >= 0) {
            this.saldo = saldo;
        } else {
            System.out.println("No se admiten saldos negativos.");
        }
    }
}
