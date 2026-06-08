package ev3.ut6_pooavanzadaestructuras.u01herenciapolimorfismo.teoria;

/**
 * Subclase U03_Circulo que hereda de U03_Figura.
 *
 * Debe tener:
 *  - atributo radio
 *  - constructor con radio
 *  - implementacion de calcularArea()
 *
 * @author Agustin. A. Marquez. Pina
 * @since 14/06/2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class U03_Circulo extends U03_Figura {

    private double radio;

    public U03_Circulo(double radio) {
        this("Circulo", "negro", radio);
    }

    public U03_Circulo(String nombre, String color, double radio) {
        super(nombre, color, 0);
        this.radio = radio;
    }

    public double getRadio() {
        return radio;
    }

    @Override
    public double calcularArea() {
        double areaCalculada = Math.PI * radio * radio;
        setArea((int) areaCalculada);
        return areaCalculada;
    }
}
