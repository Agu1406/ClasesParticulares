package ev3.ut6_pooavanzadaestructuras.u01herenciapolimorfismo.teoria.U03_Polimorfismo;

/**
 * Figura concreta: circulo.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 18/09/2026
 * @see Figura
 * @see U03_PolimorfismoIntro
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Circulo extends Figura {

    private double radio;

    public Circulo(double radio) {
        this(radio, "negro");
    }

    public Circulo(double radio, String color) {
        super("Circulo", color);
        this.radio = radio;
    }

    public double getRadio() {
        return radio;
    }

    @Override
    public double calcularArea() {
        return Math.PI * radio * radio;
    }
}
