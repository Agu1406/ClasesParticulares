package ev3.ut6_pooavanzadaestructuras.u01herenciapolimorfismo.teoria.U03_Polimorfismo;

/**
 * Superclase abstracta de figuras geometricas.
 *
 * <p><b>Objetivo:</b> contrato comun {@code calcularArea()} para tratar Circulo y
 * Rectangulo de forma uniforme (polimorfismo).</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 18/09/2026
 * @see Circulo
 * @see Rectangulo
 * @see U03_PolimorfismoIntro
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public abstract class Figura {

    protected String nombre;
    protected String color;

    protected Figura(String nombre, String color) {
        this.nombre = nombre;
        this.color = color;
    }

    public abstract double calcularArea();

    public String getNombre() {
        return nombre;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return nombre + " (" + color + ") area=" + calcularArea();
    }
}
