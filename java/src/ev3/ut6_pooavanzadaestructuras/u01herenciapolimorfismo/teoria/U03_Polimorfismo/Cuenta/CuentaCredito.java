package ev3.ut6_pooavanzadaestructuras.u01herenciapolimorfismo.teoria.U03_Polimorfismo.Cuenta;

/**
 * Cuenta credito: retiro con descubierto hasta un limite.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 11/10/2026
 * @see Cuenta
 * @see Main
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

    public double getLimiteCredito() {
        return limiteCredito;
    }

    @Override
    public void retirar(double cantidad) {
        if (cantidad <= 0) {
            System.out.println("[Credito] La cantidad debe ser positiva.");
            return;
        }
        if (saldo - cantidad < -limiteCredito) {
            System.out.println("[Credito] Supera el limite de credito (" + limiteCredito + ").");
            return;
        }
        saldo -= cantidad;
        System.out.println("[Credito] Retiro de " + cantidad + " OK. Saldo: " + saldo);
    }

    @Override
    public String tipoCuenta() {
        return "CuentaCredito";
    }
}
