package ev3.ut6_pooavanzadaestructuras.u01herenciapolimorfismo.teoria.U01_Abstraccion;

/**
 * Cuenta de ahorro: hereda de {@link Cuenta} e implementa {@code retirar} con
 * <b>limite diario</b> y sin permitir saldo negativo.
 *
 * <p>Todo lo comun (titular, cotitular, depositar, toString) ya viene de la abstracta.
 * Aqui solo anadimos lo propio del ahorro y cumplimos el contrato abstracto.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 18/09/2026
 * @see Cuenta
 * @see CuentaCredito
 * @see U01_AbstraccionIntro
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

    public CuentaAhorro(String titular, String cotitular, double saldoInicial, double limiteRetiroDiario) {
        super(titular, cotitular, saldoInicial);
        this.limiteRetiroDiario = limiteRetiroDiario;
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
        return "Cuenta ahorro";
    }

    /**
     * Reutiliza el {@code toString} de {@link Cuenta} y anade el dato propio del ahorro.
     */
    @Override
    public String toString() {
        return super.toString()
                + "Limite de retiro diario: " + this.limiteRetiroDiario + "\n";
    }

    public double getLimiteRetiroDiario() {
        return limiteRetiroDiario;
    }
}
