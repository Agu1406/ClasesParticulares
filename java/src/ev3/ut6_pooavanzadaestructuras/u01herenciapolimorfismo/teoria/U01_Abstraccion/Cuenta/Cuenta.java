package ev3.ut6_pooavanzadaestructuras.u01herenciapolimorfismo.teoria.U01_Abstraccion;

/**
 * Clase <b>abstracta</b>: modelo comun de una cuenta bancaria.
 *
 * <p><b>Que significa abstract:</b></p>
 * <ul>
 *   <li>Representa la idea de "cuenta", no un producto concreto del banco.</li>
 *   <li>Puede tener atributos y metodos <em>completos</em> (constructores, getters,
 *       {@code depositar}, {@code toString}) compartidos por todas las cuentas.</li>
 *   <li>Declara metodos <em>abstractos</em> ({@link #retirar(double)}) sin cuerpo:
 *       cada subclase ({@link CuentaAhorro}, {@link CuentaCredito}) escribe su propia
 *       regla de negocio.</li>
 *   <li><b>No se puede</b> hacer {@code new Cuenta(...)}: el compilador lo impide.
 *       Solo se crean objetos de clases concretas hijas.</li>
 * </ul>
 *
 * <p>Analogia: el plano generico "vehiculo" no se fabrica; se fabrican coches y motos
 * que cumplen el plano. Aqui el plano es {@code Cuenta}.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 18/09/2026
 * @see CuentaAhorro
 * @see CuentaCredito
 * @see U01_AbstraccionIntro
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public abstract class Cuenta {

    private String titular;
    private String cotitular;
    /** Visible en subclases para que puedan actualizar el saldo al retirar. */
    protected double saldo;

    /**
     * Cuenta con titular y cotitular.
     */
    public Cuenta(String nuevoTitular, String nuevoCotitular, double saldoInicial) {
        this.titular = nuevoTitular;
        this.cotitular = nuevoCotitular;
        this.saldo = saldoInicial;
    }

    /**
     * Cuenta solo con titular (sin cotitular).
     */
    public Cuenta(String nuevoTitular, double saldoInicial) {
        this.titular = nuevoTitular;
        this.cotitular = null;
        this.saldo = saldoInicial;
    }

    public String getTitular() {
        return this.titular;
    }

    public String getCotitular() {
        return this.cotitular;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public void setCotitular(String nuevoCotitular) {
        this.cotitular = nuevoCotitular;
    }

    /**
     * Comportamiento comun: todas las cuentas depositan igual.
     */
    public void depositar(double cantidad) {
        if (cantidad <= 0) {
            System.out.println("La cantidad a depositar debe ser positiva.");
            return;
        }
        this.saldo += cantidad;
        System.out.println("Deposito de " + cantidad + " OK. Saldo: " + this.saldo);
    }

    /**
     * Metodo <b>abstracto</b>: no tiene cuerpo aqui.
     * Ahorro y credito retiran con reglas distintas, por eso cada hija lo implementa.
     */
    public abstract void retirar(double cantidad);

    /**
     * Nombre del producto (util en demos polimorficas).
     */
    public abstract String tipoCuenta();

    @Override
    public String toString() {
        StringBuilder cadena = new StringBuilder();
        cadena.append("\n¡Datos de la cuenta!\n");
        cadena.append("Tipo: ").append(tipoCuenta()).append("\n");
        cadena.append("Titular: ").append(this.titular).append("\n");
        if (this.cotitular != null) {
            cadena.append("Cotitular: ").append(this.cotitular).append("\n");
        }
        cadena.append("Saldo actual: ").append(this.saldo).append("\n");
        return cadena.toString();
    }
}
