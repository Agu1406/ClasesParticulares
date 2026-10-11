package ev3.ut6_pooavanzadaestructuras.u01herenciapolimorfismo.teoria.U03_Polimorfismo.Vehiculo;

/**
 * Vehiculo concreto: moto.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 11/10/2026
 * @see Vehiculo
 * @see Main
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Moto extends Vehiculo {

    private boolean tieneSidecar;

    /** AllArgs: datos del vehiculo + sidecar. */
    public Moto(String matricula, String color, String marca,
            double velocidadMin, double velocidadMax, boolean motorEncendido, boolean tieneSidecar) {
        super(matricula, color, marca, velocidadMin, velocidadMax, motorEncendido);
        this.tieneSidecar = tieneSidecar;
    }

    /** AnyArgs: motor apagado por defecto. */
    public Moto(String matricula, String color, String marca,
            double velocidadMin, double velocidadMax, boolean tieneSidecar) {
        super(matricula, color, marca, velocidadMin, velocidadMax);
        this.tieneSidecar = tieneSidecar;
    }

    public boolean isTieneSidecar() {
        return tieneSidecar;
    }

    @Override
    public void acelerar() {
        if (getMotorEncendido() == null || !getMotorEncendido()) {
            System.out.println(getMarca() + " (moto): enciende el motor antes de acelerar.");
            return;
        }
        System.out.println(getMarca() + " (moto) acelera con rapidez hacia "
                + getVelocidadMax() + " km/h (sidecar=" + tieneSidecar + ")");
    }
}
