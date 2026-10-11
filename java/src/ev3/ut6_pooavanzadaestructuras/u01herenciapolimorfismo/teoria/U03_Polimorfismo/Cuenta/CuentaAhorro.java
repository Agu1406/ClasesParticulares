package ev3.ut6_pooavanzadaestructuras.u01herenciapolimorfismo.teoria.U03_Polimorfismo.Cuenta;

/**
 * Cuenta ahorro: retiro con limite diario y sin saldo negativo.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 11/10/2026
 * @see Cuenta
 * @see Main
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class CuentaAhorro extends Cuenta {

    private double limiteRetiroDiario;

    public CuentaAhorro(String titular, double saldoInicial, double limiteRetiroDiario) {
        super(titular, saldoInicial);
        this.limiteRetiroDiario = limiteRetiroDiario;
    }

    public double getLimiteRetiroDiario() {
        return limiteRetiroDiario;
    }

    @Override
    public void retirar(double cantidad) {
        if (cantidad <= 0) {
            System.out.println("[Ahorro] La cantidad debe ser positiva.");
            return;
        }
        if (cantidad > limiteRetiroDiario) {
            System.out.println("[Ahorro] Supera el limite diario (" + limiteRetiroDiario + ").");
            return;
        }
        if (cantidad > saldo) {
            System.out.println("[Ahorro] Saldo insuficiente.");
            return;
        }
        saldo -= cantidad;
        System.out.println("[Ahorro] Retiro de " + cantidad + " OK. Saldo: " + saldo);
    }

    @Override
    public String tipoCuenta() {
        return "CuentaAhorro";
    }
}
