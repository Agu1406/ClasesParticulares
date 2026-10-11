package ev3.ut6_pooavanzadaestructuras.u01herenciapolimorfismo.teoria.U03_Polimorfismo.Cuenta;

/**
 * Superclase abstracta de cuentas bancarias (enfoque polimorfismo).
 *
 * <p><b>Objetivo:</b> contrato comun {@code retirar(double)} para tratar
 * {@link CuentaAhorro} y {@link CuentaCredito} de forma uniforme.</p>
 *
 * <p>Misma idea de dominio que {@code U01_Abstraccion/Cuenta/}, aqui usada para
 * practicar array de supertipo y enlace dinamico.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 11/10/2026
 * @see CuentaAhorro
 * @see CuentaCredito
 * @see Main
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public abstract class Cuenta {

    private String titular;
    protected double saldo;

    public Cuenta(String titular, double saldoInicial) {
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double cantidad) {
        if (cantidad <= 0) {
            System.out.println("La cantidad a depositar debe ser positiva.");
            return;
        }
        saldo += cantidad;
        System.out.println("Deposito de " + cantidad + " OK. Saldo: " + saldo);
    }

    /** Cada subtipo aplica su propia regla de retiro. */
    public abstract void retirar(double cantidad);

    public abstract String tipoCuenta();

    @Override
    public String toString() {
        return tipoCuenta() + "{titular='" + titular + "', saldo=" + saldo + "}";
    }
}
