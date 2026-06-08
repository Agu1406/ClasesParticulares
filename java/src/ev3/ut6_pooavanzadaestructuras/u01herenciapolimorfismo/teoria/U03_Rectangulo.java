package ev3.ut6_pooavanzadaestructuras.u01herenciapolimorfismo.teoria;

/**
 * Subclase U03_Rectangulo que hereda de U03_Figura.
 *
 * Debe tener:
 *  - atributos base y altura
 *  - constructor con base y altura
 *  - implementacion de calcularArea()
 *
 * @author Agustin. A. Marquez. Pina
 * @since 14/06/2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class U03_Rectangulo extends U03_Figura {

    private double base;
    private double altura;

    public U03_Rectangulo(double base, double altura) {
        this("Rectangulo", "negro", base, altura);
    }

    public U03_Rectangulo(String nombre, String color, double base, double altura) {
        super(nombre, color, 4);
        this.base = base;
        this.altura = altura;
    }

    public double getBase() {
        return base;
    }

    public double getAltura() {
        return altura;
    }

    @Override
    public double calcularArea() {
        double areaCalculada = base * altura;
        setArea((int) areaCalculada);
        return areaCalculada;
    }
}
