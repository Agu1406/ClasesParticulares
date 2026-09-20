package ev2.ut5_pooexcepcionesio.u01poobasica.teoria;

/**
 * Teoria: encapsulamiento en Java.
 *
 * <p><b>Objetivo:</b> ocultar atributos con {@code private} y acceder mediante
 * metodos {@code get} / {@code set}, validando datos cuando haga falta.</p>
 *
 * <ul>
 *   <li>{@code private} - solo visible dentro de la clase.</li>
 *   <li>{@code public} getters/setters - interfaz controlada hacia fuera.</li>
 * </ul>
 *
 * <p>Practica en {@code ejercicios/} (encapsulamiento).</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 02/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class U03_EncapsulamientoIntro {

    static class Cuenta {
        private String titular;
        private double saldo;

        Cuenta(String titular, double saldo) {
            this.titular = titular;
            this.saldo = saldo;
        }

        public String getTitular() {
            return titular;
        }

        public double getSaldo() {
            return saldo;
        }

        public void setSaldo(double saldo) {
            if (saldo >= 0) {
                this.saldo = saldo;
            }
        }
    }

    public static void main(String[] args) {
        Cuenta cuenta1 = new Cuenta("Daniel", 123456.99);
        Cuenta cuenta2 = new Cuenta("Agustin", 2000.56);

        /*
         * No se puede: cuenta1.titular = "...";  (private)
         * Solo getters (y setters cuando existan).
         */
        imprimirDatosCuenta(cuenta1);
        imprimirDatosCuenta(cuenta2);

        Cuenta cuenta = new Cuenta("Demo", 0);
        cuenta.setSaldo(100);
        cuenta.setSaldo(-50);
        System.out.println("Saldo tras setSaldo(-50) rechazado: " + cuenta.getSaldo());
    }

    public static void imprimirDatosCuenta(Cuenta cuenta) {
        System.out.println(
                "¡Datos de la cuenta!\n"
                        + "- Titular: " + cuenta.getTitular() + ".\n"
                        + "- Saldo: " + cuenta.getSaldo() + ".\n");
    }
}
