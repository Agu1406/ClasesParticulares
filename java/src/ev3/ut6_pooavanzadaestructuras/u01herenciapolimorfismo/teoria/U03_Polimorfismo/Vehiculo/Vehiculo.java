package ev3.ut6_pooavanzadaestructuras.u01herenciapolimorfismo.teoria.U03_Polimorfismo.Vehiculo;

/**
 * Superclase abstracta de vehiculos (datos comunes + {@code acelerar()} polimorfico).
 *
 * <p>Los constructores ilustran tres patrones habituales: todos los argumentos,
 * algunos (con valor por defecto) y ninguno.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 11/10/2026
 * @see Coche
 * @see Moto
 * @see Main
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public abstract class Vehiculo {

    private String matricula;
    private String color;
    private String marca;
    private Double velocidadMin;
    private Double velocidadMax;
    private Boolean motorEncendido;

    /**
     * AllArgsConstructor: pide <b>todos</b> los datos/argumentos de la clase
     * para instanciar un objeto nuevo.
     */
    public Vehiculo(String matricula, String color, String marca,
            double velocidadMin, double velocidadMax, boolean motorEncendido) {
        this.matricula = matricula;
        this.color = color;
        this.marca = marca;
        this.velocidadMin = velocidadMin;
        this.velocidadMax = velocidadMax;
        this.motorEncendido = motorEncendido;
    }

    /**
     * AnyArgsConstructor: pide <b>algunos</b> datos/argumentos (no todos).
     * Aqui {@code motorEncendido} recibe un valor por defecto ({@code false}).
     */
    public Vehiculo(String matricula, String color, String marca,
            double velocidadMin, double velocidadMax) {
        this.matricula = matricula;
        this.color = color;
        this.marca = marca;
        this.velocidadMin = velocidadMin;
        this.velocidadMax = velocidadMax;
        this.motorEncendido = false;
    }

    /**
     * NoArgsConstructor: no pide argumentos; deja los campos a {@code null}
     * (o valores por defecto) hasta que se asignen despues.
     */
    public Vehiculo() {
        this.matricula = null;
        this.color = null;
        this.marca = null;
        this.velocidadMin = null;
        this.velocidadMax = null;
        this.motorEncendido = null;
    }

    /** Cada subtipo define como acelera (polimorfismo). */
    public abstract void acelerar();

    public void encenderMotor() {
        motorEncendido = true;
    }

    public void apagarMotor() {
        motorEncendido = false;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getColor() {
        return color;
    }

    public String getMarca() {
        return marca;
    }

    public Double getVelocidadMin() {
        return velocidadMin;
    }

    public Double getVelocidadMax() {
        return velocidadMax;
    }

    public Boolean getMotorEncendido() {
        return motorEncendido;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setVelocidadMin(Double velocidadMin) {
        this.velocidadMin = velocidadMin;
    }

    public void setVelocidadMax(Double velocidadMax) {
        this.velocidadMax = velocidadMax;
    }

    public void setMotorEncendido(Boolean motorEncendido) {
        this.motorEncendido = motorEncendido;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName()
                + "{matricula='" + matricula
                + "', color='" + color
                + "', marca='" + marca
                + "', velocidadMin=" + velocidadMin
                + ", velocidadMax=" + velocidadMax
                + ", motorEncendido=" + motorEncendido
                + "}";
    }
}
