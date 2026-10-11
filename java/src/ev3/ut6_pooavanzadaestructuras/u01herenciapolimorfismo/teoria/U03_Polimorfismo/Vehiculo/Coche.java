package ev3.ut6_pooavanzadaestructuras.u01herenciapolimorfismo.teoria.U03_Polimorfismo.Vehiculo;

/**
 * Vehiculo concreto: coche.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 11/10/2026
 * @see Vehiculo
 * @see Main
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Coche extends Vehiculo {

    private int puertas;

    /** AllArgs: datos del vehiculo + puertas. */
    public Coche(String matricula, String color, String marca,
            double velocidadMin, double velocidadMax, boolean motorEncendido, int puertas) {
        super(matricula, color, marca, velocidadMin, velocidadMax, motorEncendido);
        this.puertas = puertas;
    }

    /** AnyArgs: motor apagado por defecto. */
    public Coche(String matricula, String color, String marca,
            double velocidadMin, double velocidadMax, int puertas) {
        super(matricula, color, marca, velocidadMin, velocidadMax);
        this.puertas = puertas;
    }

    public int getPuertas() {
        return puertas;
    }

    @Override
    public void acelerar() {
        if (getMotorEncendido() == null || !getMotorEncendido()) {
            System.out.println(getMarca() + " (coche): enciende el motor antes de acelerar.");
            return;
        }
        System.out.println(getMarca() + " (coche) acelera con suavidad hacia "
                + getVelocidadMax() + " km/h (" + puertas + " puertas)");
    }
}
