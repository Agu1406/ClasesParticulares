package ev2.ut5_pooexcepcionesio.u02excepciones.teoria;

/**
 * Teoria: excepciones aplicadas a POO (validacion de negocio).
 *
 * <p><b>Objetivo:</b> combinar encapsulamiento ({@code private} saldo) con
 * {@code throw} / {@code try-catch-finally}. Si el importe no es valido o no hay
 * saldo, {@link Cuenta#retirar(double)} lanza {@link IllegalArgumentException}.</p>
 *
 * <p>Puente con {@link ev2.ut5_pooexcepcionesio.u01poobasica.teoria.U03_EncapsulamientoIntro}.
 * Practica: {@code E14_CuentaRetirar} y {@code ejemplointernoexcepciones}.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 06/09/2026
 * @see U04_ThrowThrowsYExcepcionesPropias
 * @see ev2.ut5_pooexcepcionesio.u01poobasica.teoria.U03_EncapsulamientoIntro
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class U05_ExcepcionesYPooDemo {

    static class Cuenta {
        private final String titular;
        private double saldo;

        Cuenta(String titular, double saldoInicial) {
            this.titular = titular;
            this.saldo = saldoInicial;
        }

        public String getTitular() {
            return titular;
        }

        public double getSaldo() {
            return saldo;
        }

        /**
         * Resta importe del saldo o lanza IllegalArgumentException
         * si importe &lt;= 0 o saldo insuficiente.
         */
        public void retirar(double importe) {
            if (importe <= 0) {
                throw new IllegalArgumentException("El importe debe ser positivo.");
            }
            if (importe > saldo) {
                throw new IllegalArgumentException(
                        "Saldo insuficiente (saldo=" + saldo + ", importe=" + importe + ").");
            }
            saldo -= importe;
        }
    }

    public static void main(String[] args) {
        Cuenta cuenta = new Cuenta("Daniel", 100.0);
        System.out.println("Cuenta de " + cuenta.getTitular() + " — saldo inicial: " + cuenta.getSaldo());

        intentarRetiro(cuenta, 30);
        intentarRetiro(cuenta, -5);
        intentarRetiro(cuenta, 200);
        System.out.println("Saldo final: " + cuenta.getSaldo());
    }

    private static void intentarRetiro(Cuenta cuenta, double importe) {
        System.out.println("\nIntentando retirar " + importe + "…");
        try {
            cuenta.retirar(importe);
            System.out.println("OK. Saldo ahora: " + cuenta.getSaldo());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("finally: operacion de retiro cerrada.");
        }
    }
}
