package ev3.ut6_pooavanzadaestructuras.u01herenciapolimorfismo.teoria.U01_Abstraccion;

/**
 * Cuenta de credito: hereda de {@link Cuenta} e implementa {@code retirar}
 * permitiendo <b>descubierto</b> hasta un {@code limiteCredito}.
 *
 * <p>Misma firma abstracta que {@link CuentaAhorro#retirar(double)}, otra politica:
 * ahi esta la fuerza de la abstraccion (mismo contrato, distinto comportamiento).</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 18/09/2026
 * @see Cuenta
 * @see CuentaAhorro
 * @see U01_AbstraccionIntro
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class CuentaCredito extends Cuenta {

    private double limiteCredito;

    public CuentaCredito(String titular, double saldoInicial, double limiteCredito) {
        super(titular, saldoInicial);
        this.limiteCredito = limiteCredito;
    }

    public CuentaCredito(String titular, String cotitular, double saldoInicial, double limiteCredito) {
        super(titular, cotitular, saldoInicial);
        this.limiteCredito = limiteCredito;
    }

    @Override
    public void retirar(double cantidad) {
        if (cantidad <= 0) {
            System.out.println("[Credito] La cantidad debe ser positiva.");
            return;
        }
        // Puede quedar en negativo hasta -limiteCredito
        if (saldo - cantidad < -limiteCredito) {
            System.out.println("[Credito] Supera el limite de credito (" + limiteCredito + ").");
            return;
        }
        saldo -= cantidad;
        System.out.println("[Credito] Retiro de " + cantidad + " OK. Saldo: " + saldo);
    }

    @Override
    public String tipoCuenta() {
        return "Cuenta credito";
    }

    /**
     * Reutiliza el {@code toString} de {@link Cuenta} y anade el limite de credito.
     */
    @Override
    public String toString() {
        return super.toString()
                + "Limite de credito: " + this.limiteCredito + "\n";
    }

    public double getLimiteCredito() {
        return limiteCredito;
    }
}
